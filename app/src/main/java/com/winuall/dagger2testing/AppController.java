package com.winuall.dagger2testing;


import android.app.Application;

import com.winuall.dagger2testing.Dagger.AppModule;
import com.winuall.dagger2testing.Dagger.DaggerNetComponent;
import com.winuall.dagger2testing.Dagger.NetComponent;
import com.winuall.dagger2testing.Dagger.NetModule;


public class AppController extends Application {

    private NetComponent netComponent ;

    @Override
    public void onCreate() {
        super.onCreate();

        netComponent = DaggerNetComponent.builder()
                .appModule(new AppModule(this))
                .netModule(new NetModule("https://api.github.com"))
                .build() ;
    }

    public NetComponent getNetComponent() {
        return netComponent;
    }
}
