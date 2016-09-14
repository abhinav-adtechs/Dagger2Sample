package com.winuall.dagger2testing.Dagger;


import com.winuall.dagger2testing.Views.MainActivity;
import com.winuall.dagger2testing.Views.NextActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class, NetModule.class})
public interface NetComponent {
    void inject(MainActivity mainActivity) ;
    void inject(NextActivity nextActivity) ;
}
