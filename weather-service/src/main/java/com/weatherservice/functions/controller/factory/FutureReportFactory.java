package com.weatherservice.functions.controller.factory;

import com.weatherservice.functions.controller.configuration.ApiConstants;
import com.weatherservice.functions.domain.model.FutureReport;
import com.weatherservice.functions.domain.model.ReportType;
import com.weatherservice.functions.domain.model.WeatherReport;

public class FutureReportFactory implements WeatherReportUriFactory {
    @Override
    public String valueOf(WeatherReport weatherReport) {
        if (!isFutureReport(weatherReport)) {
            throw new IllegalStateException("Illegal factory usage without FutureReport class !");
        }
        return getUri((FutureReport) weatherReport);
    }

    private boolean isFutureReport(WeatherReport weatherReport) {
        return weatherReport instanceof FutureReport;
    }

    private String getUri(FutureReport futureReport) {
        return String.format("%s/v1/%s.json?%s=%s&%s=%s&%s=%s",
                ApiConstants.API_URI, ReportType.FUTURE.name().toLowerCase(), ApiConstants.API_KEY_PARAM, ApiConstants.API_KEY,
                ApiConstants.API_LOCATION_PARAM, futureReport.getLocation(), ApiConstants.API_DATE_PARAM, futureReport.getDate().toString());
    }
}
