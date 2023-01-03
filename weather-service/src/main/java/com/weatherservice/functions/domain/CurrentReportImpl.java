package com.weatherservice.functions.domain;

import com.weatherservice.functions.domain.model.CurrentReport;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NonNull;

@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class CurrentReportImpl implements CurrentReport {

    private String location;

    @NonNull
    @Override
    public String getLocation() {
        return location;
    }

}
