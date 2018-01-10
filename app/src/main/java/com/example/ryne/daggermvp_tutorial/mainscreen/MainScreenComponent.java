package com.example.ryne.daggermvp_tutorial.mainscreen;

import com.example.ryne.daggermvp_tutorial.data.component.NetComponent;
import com.example.ryne.daggermvp_tutorial.util.CustomScope;

import dagger.Component;

/**
 * Created by Ryne on 1/9/2018.
 */


@CustomScope
@Component (dependencies = NetComponent.class, modules = MainScreenModule.class)
public interface MainScreenComponent {
    void inject(MainActivity activity);
}
