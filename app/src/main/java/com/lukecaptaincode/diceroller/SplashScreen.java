package com.lukecaptaincode.diceroller;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import java.util.Timer;
import java.util.TimerTask;
import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Handler.Callback;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashScreen extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        Typeface myTypeface = Typeface.createFromAsset(getAssets(),"Nurjan.ttf");
        TextView mainTitle = (TextView)findViewById(R.id.SplashScreen_title_lbl);
        mainTitle.setTypeface(myTypeface);
        Animation fadein = AnimationUtils.loadAnimation(this, R.anim.fadein);
        mainTitle.setAnimation(fadein);
        final Handler changeActivityHandler = new Handler();
        Timer timer = new Timer(false);
        TimerTask changetimerTask = new TimerTask() {
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
        timer.schedule(changetimerTask, 4000); // 1000 = 1 second*/
    }

}
