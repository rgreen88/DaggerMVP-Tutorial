package com.example.ryne.daggermvp_tutorial.data.module;

import android.app.Application;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;

/**
 * Created by Ryne on 1/9/2018.
 */

@Module
public class NetModule {

    private final String mBaseUrl;

    Application mApplication;

    public NetModule(String mBaseUrl) {

        this.mBaseUrl = mBaseUrl;

    }

    @Provides
    @Singleton
    SharedPreferences providesSharedPreferences(Application application) {
        return PreferenceManager.getDefaultSharedPreferences(application);

    }



    }

}