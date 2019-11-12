package com.example.moviesmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ProgressBar;

import java.util.Timer;
import java.util.TimerTask;

public class SplashActivity extends AppCompatActivity {

    final long TIME_PERIOD = 30L;

    private ProgressBar mProgressBar;
    private Timer mTimer = new Timer();
    private int progress = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                             WindowManager.LayoutParams.FLAG_FULLSCREEN);

        mProgressBar = findViewById(R.id.progressBar);

        startProgress(mProgressBar);
    }

    private void startProgress(final ProgressBar progressBar)
    {
        mTimer.schedule(new TimerTask() {
            @Override
            public void run() {

                if (progress < 100){
                    progressBar.setProgress(progress);
                    progress++;

                }else{

                    mTimer.cancel();

                    startActivity(new Intent(SplashActivity.this, MainActivity.class));
                    finish();
                }
            }
        }, 0, TIME_PERIOD);
    }
}
