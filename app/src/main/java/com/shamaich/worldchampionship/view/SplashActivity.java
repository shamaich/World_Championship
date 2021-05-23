package com.shamaich.worldchampionship.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;

import com.shamaich.worldchampionship.R;
import com.shamaich.worldchampionship.rannable.SplashActivityRun;


public class SplashActivity extends AppCompatActivity {

    private final Handler handler = new Handler();
    private final int delay = 3500;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        handler.postDelayed(new SplashActivityRun(this, this), delay);

    }
}