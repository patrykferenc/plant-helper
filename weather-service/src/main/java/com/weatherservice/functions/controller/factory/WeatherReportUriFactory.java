package com.weatherservice.functions.controller.factory;

import com.weatherservice.functions.domain.model.WeatherReport;

public interface WeatherReportUriFactory {
    String valueOf (WeatherReport weatherReport);
}
