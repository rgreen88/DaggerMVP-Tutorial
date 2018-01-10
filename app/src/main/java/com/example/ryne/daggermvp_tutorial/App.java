package com.example.ryne.daggermvp_tutorial;

import android.app.Application;


import com.example.ryne.daggermvp_tutorial.data.component.NetComponent;
import com.example.ryne.daggermvp_tutorial.data.module.AppModule;
import com.example.ryne.daggermvp_tutorial.data.module.NetModule;

/**
 * Created by Ryne on 1/9/2018.
 */

public class App extends Application {

    private NetComponent mNetComponent;

    //Overriding default Application class, so we need to modify application name to launch App
    @Override
    public void onCreate(){
        super.onCreate();

        //creating dagger builder object from NetComponent object
        mNetComponent = DaggerNetComponent.builder()
                .appModule(new AppModule(this))
                .netModule(new NetModule("http://jsonplaceholder.typicode.com/"))
                .build();

    }

    public NetComponent getNetComponent() {
        return mNetComponent;
    }

}
