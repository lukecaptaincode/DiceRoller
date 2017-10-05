package com.lukecaptaincode.diceroller;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;


public class MainMenu extends AppCompatActivity {


    //Fragment
    FragmentManager fm = getSupportFragmentManager();
    //Done
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        //ads
        AdView mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        Typeface myTypeface = Typeface.createFromAsset(getAssets(), "Heroic.ttf");
        Button diceRoller_btn = findViewById(R.id.MainMenu_DiceRoller_btn);
        diceRoller_btn.setTypeface(myTypeface);

        diceRoller_btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent myIntent = new Intent(MainMenu.this, DiceRoller.class);
                startActivity(myIntent);
            }
        });
        Button woundsBtn = findViewById(R.id.MainMenu_wounds_btn);
        woundsBtn.setTypeface(myTypeface);
        woundsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent woundsIntent = new Intent(MainMenu.this, WoundCounter.class);
                startActivity(woundsIntent);
            }
        });
        Button scatterBtn = findViewById(R.id.MainMenu_scatter_btn);
        scatterBtn.setTypeface(myTypeface);
        scatterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent scatterIntent = new Intent(MainMenu.this, scatterDice.class);
                startActivity(scatterIntent);
            }
        });
        Button aboutBtn = findViewById(R.id.mainMenu_aboutButton_btn);
        aboutBtn.setTypeface(myTypeface);
        aboutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AboutFragment aboutFrag = new AboutFragment();
                aboutFrag.show(fm, "About");
            }
        });


    }
    @Override
    public void onBackPressed() {
    }

    @Override
    protected void onStop() {
        super.onStop();

    }
}
