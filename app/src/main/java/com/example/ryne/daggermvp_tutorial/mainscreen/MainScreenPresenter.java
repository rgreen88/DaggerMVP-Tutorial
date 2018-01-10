package com.example.ryne.daggermvp_tutorial.mainscreen;

import com.example.ryne.daggermvp_tutorial.data.Post;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Retrofit;
import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by Ryne on 1/9/2018.
 */

public class MainScreenPresenter implements MainScreenContract.Presenter {

    Retrofit retrofit;
    MainScreenContract.View mView;

    @Inject
    public MainScreenPresenter(Retrofit retrofit, MainScreenContract.View mView){

        this.retrofit = retrofit;
        this.mView = mView;

    }

    @Override
    public void loadPost() {

    }

    public interface PostService {
        @GET("/posts")
        Observable<List<Post>> getPostList();
    }
}
