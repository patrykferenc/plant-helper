package com.weatherservice.functions.domain;

import com.weatherservice.functions.domain.model.ForecastReport;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class ForecastReportImpl implements ForecastReport {
    private int days;
    private String location;

    @Override
    public int getDays() {
        return days;
    }

    @Override
    public String getLocation() {
        return location;
    }

}
