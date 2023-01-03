package com.weatherservice.functions.controller;

import com.microsoft.azure.functions.*;
import com.microsoft.azure.functions.annotation.AuthorizationLevel;
import com.microsoft.azure.functions.annotation.FunctionName;
import com.microsoft.azure.functions.annotation.HttpTrigger;
import com.weatherservice.functions.domain.CurrentReportImpl;
import com.weatherservice.functions.domain.ForecastReportImpl;
import com.weatherservice.functions.domain.FutureReportImpl;
import com.weatherservice.functions.domain.model.WeatherReport;

import java.time.LocalDate;
import java.util.Optional;

public class WeatherTriggerFunctionController {
    WeatherFunctionService weatherFunctionService = new WeatherFunctionService();
    @FunctionName("getWeather")
    public HttpResponseMessage run(
            @HttpTrigger(
                    name = "req",
                    methods = {HttpMethod.GET},
                    authLevel = AuthorizationLevel.ANONYMOUS)
            HttpRequestMessage<Optional<String>> request,
            final ExecutionContext context) {
        context.getLogger().info("Weather Service HTTP trigger processed a request.");

        var report = getReport(request);

        if (report == null) {
            return request.createResponseBuilder(HttpStatus.BAD_REQUEST).body("Wrong request type").build();
        } else {
            try {
                return request.createResponseBuilder(HttpStatus.OK).body(weatherFunctionService.processRequest(report)).build();
            }
            catch (Exception ex) {
                return request.createResponseBuilder(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage()).build();
            }
        }
    }

    private WeatherReport getReport(HttpRequestMessage<Optional<String>> request) {
        var days = request.getQueryParameters().get("days");
        var date = request.getQueryParameters().get("dt");
        var location = request.getQueryParameters().get("location");
        if (location == null || (date != null && days != null)) {
            return null;
        } else if (days != null) {
            return new ForecastReportImpl(Integer.parseInt(days), location);
        } else if (date != null) {
            return new FutureReportImpl(LocalDate.parse(date), location);
        }
        return new CurrentReportImpl(location);

    }
}
