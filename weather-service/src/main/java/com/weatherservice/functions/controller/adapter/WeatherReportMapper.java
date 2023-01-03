package com.weatherservice.functions.controller.adapter;

import com.microsoft.azure.functions.HttpRequestMessage;
import com.weatherservice.functions.domain.CurrentReportImpl;
import com.weatherservice.functions.domain.ForecastReportImpl;
import com.weatherservice.functions.domain.FutureReportImpl;
import com.weatherservice.functions.domain.model.WeatherReport;

import java.time.LocalDate;
import java.util.Optional;

public class WeatherReportMapper {
    public static Optional<WeatherReport> map(HttpRequestMessage<Optional<String>> request) {
        var days = request.getQueryParameters().get("days");
        var date = request.getQueryParameters().get("dt");
        var location = request.getQueryParameters().get("location");
        if (location == null || (date != null && days != null)) {
            return Optional.empty();
        } else if (days != null) {
            return Optional.of(new ForecastReportImpl(Integer.parseInt(days), location));
        } else if (date != null) {
            return Optional.of(new FutureReportImpl(LocalDate.parse(date), location));
        }
        return Optional.of(new CurrentReportImpl(location));
    }
}
