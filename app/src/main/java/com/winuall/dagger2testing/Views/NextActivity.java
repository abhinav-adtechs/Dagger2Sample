package com.winuall.dagger2testing.Views;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.winuall.dagger2testing.AppController;
import com.winuall.dagger2testing.R;

import javax.inject.Inject;

/**
 * Created by abhinav on 13/09/16.
 */

public class NextActivity extends AppCompatActivity {

    private static final String TAG = "TAG" ;
    @Inject SharedPreferences sharedPreferences ;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        ((AppController) getApplication()).getNetComponent().inject(this);

        Log.i(TAG, "onCreate: Next Activity " + sharedPreferences.getString("hello", "not available"));
    }
}
