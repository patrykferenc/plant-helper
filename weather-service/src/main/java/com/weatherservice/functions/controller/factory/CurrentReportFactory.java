package com.weatherservice.functions.controller.factory;

import com.weatherservice.functions.controller.configuration.ApiConstants;
import com.weatherservice.functions.domain.model.CurrentReport;
import com.weatherservice.functions.domain.model.ReportType;
import com.weatherservice.functions.domain.model.WeatherReport;

public class CurrentReportFactory implements WeatherReportUriFactory {
    @Override
    public String valueOf(WeatherReport weatherReport) {
        if (!isCurrentReport(weatherReport)) {
            throw new IllegalStateException("Illegal factory usage without CurrentReport class !");
        }
        return getUri((CurrentReport) weatherReport);
    }

    private boolean isCurrentReport(WeatherReport weatherReport) {
        return weatherReport instanceof CurrentReport;
    }
    private String getUri(CurrentReport currentReport)
    {
        return String.format("%s/v1/%s.json?%s=%s&%s=%s&aqi=no",
                ApiConstants.API_URI, ReportType.CURRENT.name().toLowerCase(), ApiConstants.API_KEY_PARAM, ApiConstants.API_KEY,ApiConstants.API_LOCATION_PARAM,currentReport.getLocation());
    }
}
