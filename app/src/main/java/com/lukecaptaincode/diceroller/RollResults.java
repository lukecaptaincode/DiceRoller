package com.lukecaptaincode.diceroller;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;


public class

        RollResults extends ActionBarActivity {
    int[] results;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_roll_results);
        //adview
        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        Typeface myTypeface = Typeface.createFromAsset(getAssets(), "Nurjan.ttf");
        int diceNo = 1;
        results = (int[]) getIntent().getSerializableExtra("results");
        TextView resultsText = (TextView) findViewById(R.id.Results_results_lbl);
        resultsText.setTypeface(myTypeface);
        for (int i = 0; i < results.length; i++) {

            resultsText.append("\nDice No." + diceNo + ":  " + results[i]);
            diceNo++;
        }
        Button backBtn = (Button)findViewById(R.id.Results_back_btn);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(RollResults.this, DiceRoller.class);
                startActivity(myIntent);
                finish();
            }
        });
    }

}
