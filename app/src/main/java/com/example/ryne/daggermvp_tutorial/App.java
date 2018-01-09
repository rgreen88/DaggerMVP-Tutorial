package com.example.ryne.daggermvp_tutorial;

import android.app.Application;

/**
 * Created by Ryne on 1/9/2018.
 */

public class App extends Application {

    //Overriding default Application class, so we need to modify application name to launch App
    @Override
    public void onCreate(){
        super.onCreate();
    }

}
