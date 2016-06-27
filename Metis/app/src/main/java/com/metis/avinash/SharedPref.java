package com.metis.avinash;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * Created by avinash on 6/1/16.
 */
public class SharedPref {


    static final String USER_ACCESS_TOKEN = "access_token";

    public static final String PREF_NAME = "METIS_APP";


    static SharedPreferences getSharedPreferences(Context ctx) {
        return PreferenceManager.getDefaultSharedPreferences(ctx);
    }

    public static void setAccessToken(Context ctx, String access_token) {
        SharedPreferences.Editor editor = getSharedPreferences(ctx).edit();
        editor.putString(USER_ACCESS_TOKEN, access_token);
        editor.commit();
    }

    public static String getAccessToken(Context ctx) {
        return getSharedPreferences(ctx).getString(USER_ACCESS_TOKEN, "missing");
    }

    public static void removeAccessToken(Context ctx) {

        SharedPreferences.Editor editor = getSharedPreferences(ctx).edit();
        editor.putString(USER_ACCESS_TOKEN, "missing");
        ;
        editor.commit();
    }


    public static void removeSharedPreference(Context ctx) {

        SharedPreferences.Editor editor = getSharedPreferences(ctx).edit();
        editor.clear();
        editor.commit();

    }
}
