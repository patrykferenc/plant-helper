package com.weatherservice.functions.domain.model;

import java.time.LocalDate;

public interface FutureReport extends WeatherReport {
    LocalDate getDate();
}
