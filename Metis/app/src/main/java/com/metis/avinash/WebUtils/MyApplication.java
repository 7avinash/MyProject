package com.metis.avinash.WebUtils;

import android.app.Application;

import com.activeandroid.ActiveAndroid;
import com.activeandroid.Configuration;
import com.metis.avinash.Models.PostModel;

/**
 * Created by avinash on 7/2/16.
 */
public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Configuration.Builder config = new Configuration.Builder(this);
        config.addModelClass(PostModel.class);
        ActiveAndroid.initialize(config.create());
    }
}
