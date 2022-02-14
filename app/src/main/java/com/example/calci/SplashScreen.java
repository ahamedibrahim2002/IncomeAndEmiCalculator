package com.example.calci;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;


public class SplashScreen extends AppCompatActivity {
    final int SPLASH_TIME=1200;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        getSupportActionBar().hide();
        new Handler().postDelayed(() ->{
            startActivity(new Intent(SplashScreen.this,MainActivity.class));
            finish();
        }, SPLASH_TIME);
    }
}