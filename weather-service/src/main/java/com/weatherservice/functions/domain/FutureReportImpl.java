package com.weatherservice.functions.domain;

import com.weatherservice.functions.domain.model.FutureReport;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class FutureReportImpl implements FutureReport {
    private LocalDate date;
    private String location;
    @Override
    public String getLocation() {
        return location;
    }

    @Override
    public LocalDate getDate() {
        return date;
    }
}
