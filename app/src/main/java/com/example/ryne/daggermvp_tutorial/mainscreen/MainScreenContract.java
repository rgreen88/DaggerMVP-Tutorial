package com.example.ryne.daggermvp_tutorial.mainscreen;

import com.example.ryne.daggermvp_tutorial.data.Post;

import java.util.List;

/**
 * Created by Ryne on 1/9/2018.
 */

public interface MainScreenContract {

    interface View{

        void showPost(List<Post> posts);

        void showError (String message);

        void showComplete();
    }

    interface Presenter {

        void loadPost();
    }
}
