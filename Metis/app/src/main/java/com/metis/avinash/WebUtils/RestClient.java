package com.metis.avinash.WebUtils;

import retrofit.RestAdapter;

public class RestClient {

    private static metisApi REST_CLIENT;

    private static String ROOT =
            "http://192.168.43.193:8000/";

    static {
        setupRestClient();
    }

    private RestClient() {};

    public static metisApi get() {
        return REST_CLIENT;
    }

    private static void setupRestClient() {

        RestAdapter restAdapter = new RestAdapter.Builder().setLogLevel(RestAdapter.LogLevel.FULL).
                setEndpoint(ROOT).build();

        REST_CLIENT = restAdapter.create(metisApi.class);
    }

    public static String getRootURL(){
        return ROOT;
    }
}
