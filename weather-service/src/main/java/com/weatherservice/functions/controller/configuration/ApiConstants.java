package com.weatherservice.functions.controller.configuration;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(access = AccessLevel.PUBLIC)
public class ApiConstants {
    public static final String API_URI = System.getenv("apiUri");
    public static final String API_KEY = System.getenv("apiKey");
    public static final String API_LOCATION_PARAM = "q";
    public static final String API_KEY_PARAM = "key";
    public static final String API_DAYS_PARAM = "days";
    public static final String API_DATE_PARAM = "dt";

}
