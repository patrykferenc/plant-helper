package com.weatherservice.functions.controller.factory;

import com.weatherservice.functions.controller.configuration.ApiConstants;
import com.weatherservice.functions.domain.model.ForecastReport;
import com.weatherservice.functions.domain.model.ReportType;
import com.weatherservice.functions.domain.model.WeatherReport;

public class ForecastReportFactory implements WeatherReportUriFactory {
    @Override
    public String valueOf(WeatherReport weatherReport) {
        if (!isForecastReport(weatherReport)) {
            throw new RuntimeException("Illegal factory usage without ForecastReport class !");
        }
        return getUri((ForecastReport) weatherReport);
    }

    private boolean isForecastReport(WeatherReport weatherReport) {
        return weatherReport instanceof ForecastReport;
    }

    private String getUri(ForecastReport forecastReport) {
        return String.format("%s/v1/%s.json?%s=%s&%s=%s&%s=%d&aqi=no&alerts=no",
                ApiConstants.API_URI, ReportType.forecast.name(), ApiConstants.API_KEY_PARAM, ApiConstants.API_KEY,
                ApiConstants.API_LOCATION_PARAM, forecastReport.getLocation(), ApiConstants.API_DAYS_PARAM, forecastReport.getDays());
    }
}
