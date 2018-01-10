package com.example.ryne.daggermvp_tutorial.mainscreen;

import com.example.ryne.daggermvp_tutorial.util.CustomScope;

import javax.inject.Scope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Ryne on 1/9/2018.
 */

//The purpose of creating MainScreenModule is to provide the View ( in our case MainActivity)
// to our Presenter when it is injected

@Module
public class MainScreenModule {

    private final MainScreenContract.View mView;

    public MainScreenModule(MainScreenContract.View mView) {
        this.mView = mView;
    }

    //adding custom scope since two dependent components can't share the same scope (NetComponent)
    @Provides
    @CustomScope
    MainScreenContract.View providesMainScreenContractView(){
        return mView;
    }
}
