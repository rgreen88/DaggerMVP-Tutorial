package com.example.ryne.daggermvp_tutorial.mainscreen;

import android.app.Application;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.ryne.daggermvp_tutorial.App;
import com.example.ryne.daggermvp_tutorial.R;
import com.example.ryne.daggermvp_tutorial.data.Post;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

public class MainActivity extends AppCompatActivity implements MainScreenContract.View{

    //variables for ListView
    ListView listView;
    ArrayList<String> list;
    ArrayAdapter<String> adapter;

    //calling MainScreenPresenter as object and injecting it
    @Inject
    MainScreenPresenter mainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //listView binding
        listView = findViewById(R.id.my_list);

        //list set = to ArrayList<>() generated from pojo
        list = new ArrayList<>();

        //Dagger builder
        DaggerMainScreenComponent.builder()
                .netComponent (((App) getApplicationContext()).getNetComponent())
                .mainScreenModule(new MainScreenModule(this))
                .build()
                .inject(this);

        //calling MainPresenter to make network request
        mainPresenter.loadPost();
    }


    @Override
    public void showPost(List<Post> posts) {

    }

    @Override
    public void showError(String message) {

    }

    @Override
    public void showComplete() {

    }
}
