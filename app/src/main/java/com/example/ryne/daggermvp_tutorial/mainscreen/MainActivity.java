package com.example.ryne.daggermvp_tutorial.mainscreen;

import android.app.Application;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.ryne.daggermvp_tutorial.R;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }




}
