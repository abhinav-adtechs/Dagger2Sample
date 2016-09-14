package com.winuall.dagger2testing.Views;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.winuall.dagger2testing.AppController;
import com.winuall.dagger2testing.R;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "TAG";
    @Inject SharedPreferences sharedPreferences ;
    SharedPreferences.Editor editor ;

    Button button ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((AppController) getApplication()).getNetComponent().inject(this);

        editor = sharedPreferences.edit() ;
        editor.putString("hello", "world") ;
        editor.apply();


        Log.i(TAG, "onCreate: " + sharedPreferences.getString("hello", "not found") );
        button = (Button) findViewById(R.id.btn_next_main) ;
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), NextActivity.class) ;
                startActivity(intent);
            }
        });
    }
}
