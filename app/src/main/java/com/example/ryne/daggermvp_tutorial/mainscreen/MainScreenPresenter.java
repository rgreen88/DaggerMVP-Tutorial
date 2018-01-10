package com.example.ryne.daggermvp_tutorial.mainscreen;

import com.example.ryne.daggermvp_tutorial.data.Post;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Retrofit;
import retrofit2.http.GET;
import rx.Observable;
import rx.Observer;
import rx.Scheduler;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

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

        retrofit.create(PostService.class).getPostList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .unsubscribeOn(Schedulers.io())
                .subscribe(new Observer<List<Post>>() {

                    //receiving data
                    @Override
                    public void onCompleted() {
                        mView.showComplete();
                    }

                    //Error occurs during call
                    @Override
                    public void onError(Throwable e) {
                        mView.showError(e.getMessage());
                    }

                    //Network call finishes
                    @Override
                    public void onNext(List<Post> posts) {
                        mView.showPost(posts);
                    }
                });//mView gets passed off to the View via this reference variable which was
                   //injected in the View (MainActivity)
    }

    public interface PostService {
        @GET("/posts")
        Observable<List<Post>> getPostList();
    }
}
