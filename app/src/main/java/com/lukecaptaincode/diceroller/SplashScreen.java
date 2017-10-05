package com.lukecaptaincode.diceroller;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        Typeface myTypeface = Typeface.createFromAsset(getAssets(), "Heroic.ttf");
        ImageView mainLogo;
        mainLogo = findViewById(R.id.SplashScreen_Logo_imgv);
        TextView mainTitle;
        mainTitle = findViewById(R.id.SplashScreen_title_lbl);
        mainTitle.setTypeface(myTypeface);
        Animation fadeIn = AnimationUtils.loadAnimation(this, R.anim.fadein);
        mainTitle.setAnimation(fadeIn);
        mainLogo.setAnimation(fadeIn);
        final Handler changeActivityHandler = new Handler();
        Timer timer = new Timer(false);
        TimerTask changeTimerTask = new TimerTask() {
            @Override
            public void run() {
                changeActivityHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        Intent myIntent = new Intent(SplashScreen.this, MainMenu.class);
                        startActivity(myIntent);

                    }
                });
            }
        };
        timer.schedule(changeTimerTask, 4000); // 1000 = 1 second*/
    }

}
