package com.weatherservice.functions.controller;

import com.weatherservice.functions.controller.factory.CurrentReportFactory;
import com.weatherservice.functions.controller.factory.ForecastReportFactory;
import com.weatherservice.functions.controller.factory.FutureReportFactory;
import com.weatherservice.functions.domain.model.*;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class WeatherFunctionService {
    CurrentReportFactory currentReportFactory = new CurrentReportFactory();
    ForecastReportFactory forecastReportFactory = new ForecastReportFactory();
    FutureReportFactory futureReportFactory = new FutureReportFactory();


    public String processRequest(WeatherReport weatherReport) throws URISyntaxException, IOException, InterruptedException {
        if (weatherReport instanceof CurrentReport) {
            return processCurrentReport((CurrentReport) weatherReport);

        } else if (weatherReport instanceof ForecastReport) {
            return processForecastReport((ForecastReport) weatherReport);

        } else {
            return processFutureReport((FutureReport) weatherReport);
        }
    }

    private static JSONObject makeARequest(String uri) throws URISyntaxException, IOException, InterruptedException, JSONException {
        var client = HttpClient.newHttpClient();
        var request = HttpRequest.newBuilder(new URI(uri)).build();
        var response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return new JSONObject(response.body());
    }

    private String processCurrentReport(CurrentReport currentReport) throws URISyntaxException, IOException, InterruptedException {
        var responseJsonObject = makeARequest(currentReportFactory.valueOf(currentReport));
        var currentJsonObject = responseJsonObject.getJSONObject(ReportType.current.name());
        return String.format("{\"humidity\":\"%s\",\"temperature\":\"%s\",\"percip\":\"%s\"}",
                currentJsonObject.get("humidity").toString(),
                currentJsonObject.get("temp_c").toString(),
                currentJsonObject.get("precip_mm").toString());
    }

    private String processForecastReport(ForecastReport forecastReport) throws URISyntaxException, IOException, InterruptedException {
        var responseJsonObject = makeARequest(forecastReportFactory.valueOf(forecastReport));
        var forecastJsonObject = responseJsonObject.getJSONObject(ReportType.forecast.name());
        var averagesJsonObject = (JSONObject)((JSONObject) forecastJsonObject.getJSONArray("forecastday").get(0)).get("day");
        return String.format("{\"humidity\":\"%s\",\"temperature\":\"%s\",\"percip\":\"%s\"}",
                averagesJsonObject.get("avghumidity").toString(),
                averagesJsonObject.get("avgtemp_c").toString(),
                averagesJsonObject.get("totalprecip_mm").toString());
    }

    private String processFutureReport(FutureReport futureReport) throws URISyntaxException, IOException, InterruptedException {
        var responseJsonObject = makeARequest(futureReportFactory.valueOf(futureReport));
        var forecastJsonObject = responseJsonObject.getJSONObject(ReportType.forecast.name());
        var averagesJsonObject = (JSONObject)((JSONObject) forecastJsonObject.getJSONArray("forecastday").get(0)).get("day");
        return String.format("{\"humidity\":\"%s\",\"temperature\":\"%s\",\"percip\":\"%s\"}",
                averagesJsonObject.get("avghumidity").toString(),
                averagesJsonObject.get("avgtemp_c").toString(),
                averagesJsonObject.get("totalprecip_mm").toString());
    }
}
