package com.lukecaptaincode.diceroller;

import android.app.ActionBar;
import android.app.AlertDialog;
import android.app.Application;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.util.logging.Handler;


public class MainMenu extends ActionBarActivity {

    private ProgressBar spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        //ads
        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        Typeface myTypeface = Typeface.createFromAsset(getAssets(),"Nurjan.ttf");
        Button diceRoller_btn = (Button)findViewById(R.id.MainMenu_DiceRoller_btn);
        diceRoller_btn.setTypeface(myTypeface);

        Button diceRoller = (Button) findViewById(R.id.MainMenu_DiceRoller_btn);
        diceRoller.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent myIntent = new Intent(MainMenu.this, DiceRoller.class);
                startActivity(myIntent);
            }
        });
        Button woundsBtn = (Button)findViewById(R.id.MainMenu_wounds_btn);
        woundsBtn.setTypeface(myTypeface);
        woundsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent woundsIntent = new Intent(MainMenu.this, WoundCounter.class);
                startActivity(woundsIntent);
            }
        });
        Button scatterBtn = (Button)findViewById(R.id.MainMenu_scatter_btn);
        scatterBtn.setTypeface(myTypeface);
        scatterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent scatterIntent = new Intent(MainMenu.this, scatterDice.class);
                startActivity(scatterIntent);
            }
        });


    }
    @Override
    public void onBackPressed() {
    }

    @Override
    protected void onStop() {
        super.onStop();
        spinner.setVisibility(View.GONE);
    }
}
