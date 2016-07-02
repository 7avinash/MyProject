package com.metis.avinash.WebUtils;

import com.google.gson.GsonBuilder;

import java.lang.reflect.Modifier;

import retrofit.RestAdapter;
import retrofit.converter.GsonConverter;

public class RestClient {

    private static metisApi REST_CLIENT;

    private static String ROOT =
            "http://192.168.11.110:8000/";

    static {
        setupRestClient();
    }

    private RestClient() {};

    public static metisApi get() {
        return REST_CLIENT;
    }

    private static void setupRestClient() {

        RestAdapter restAdapter = new RestAdapter.Builder().setConverter(new GsonConverter(new GsonBuilder().excludeFieldsWithModifiers(Modifier.FINAL, Modifier.TRANSIENT, Modifier.STATIC).excludeFieldsWithoutExposeAnnotation().create())).setLogLevel(RestAdapter.LogLevel.FULL).
                setEndpoint(ROOT).build();

        REST_CLIENT = restAdapter.create(metisApi.class);
    }

    public static String getRootURL(){
        return ROOT;
    }
}
