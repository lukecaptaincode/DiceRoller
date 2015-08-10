package com.lukecaptaincode.diceroller;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;


public class RollResults extends ActionBarActivity {
    int[] results;
    LinearLayout linearLayout;
    TextView resultsText;
    TextView[] textView;
    Button backBtn;
    Button sortBtn;
    EditText filterText;
    CheckBox lessThan;
    CheckBox greaterThan;
    CheckBox equalTo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_roll_results);
        //adview
        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        //Tyoe
        Typeface myTypeface = Typeface.createFromAsset(getAssets(), "Nurjan.ttf");
        //vars
        int diceNo = 1;
        results = (int[]) getIntent().getSerializableExtra("results");
        //Elements
        lessThan = (CheckBox) findViewById(R.id.Results_MinusSort_rdb);
        greaterThan = (CheckBox) findViewById(R.id.Results_PlusSort_rdb);
        equalTo = (CheckBox) findViewById(R.id.Results_EqualSort_rdb);
        linearLayout = (LinearLayout) findViewById(R.id.LineLay);
        resultsText = (TextView) findViewById(R.id.Results_results_lbl);
        backBtn = (Button) findViewById(R.id.Results_back_btn);
        textView = new TextView[results.length];
        filterText = (EditText) findViewById(R.id.Results_Filter_txt);
        sortBtn = (Button) findViewById(R.id.Results_Sort_btn);
        //Typeface set
        backBtn.setTypeface(myTypeface);
        sortBtn.setTypeface(myTypeface);
        filterText.setTypeface(myTypeface);
        resultsText.setTypeface(myTypeface);
        //Display results
        for (int i = 0; i < results.length; i++) {

            textView[i] = new TextView(this);
            textView[i].setText("\nDice No." + diceNo + ":  " + results[i]);
            textView[i].setTypeface(myTypeface);
            textView[i].setTextColor(Color.parseColor("#ffffff"));
            textView[i].setTextSize(30);
            //textView[i].setTag(i);
            linearLayout.addView(textView[i]);
            diceNo++;
        }
        //checkbox logic
        lessThan.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (greaterThan.isChecked())
                {
                    greaterThan.setChecked(false);
                }
            }
        });
        greaterThan.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (lessThan.isChecked()) {
                    lessThan.setChecked(false);

                }
            }
        });
        //go back
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(RollResults.this, DiceRoller.class);
                startActivity(myIntent);
                finish();
            }
        });
        //sort
        sortBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sort(v);
            }
        });
    }

    public void sort(View v) {
        String filter = filterText.getText().toString();
        if(!equalTo.isChecked() && !greaterThan.isChecked()&& !lessThan.isChecked())
        {
            for (int i = 0; i < results.length; i++) {
                textView[i].setVisibility(View.VISIBLE);
            }
        }
        if (equalTo.isChecked()) {//start eqaul to if
            for (int i = 0; i < results.length; i++) {
                if (results[i] != Integer.parseInt(filter)) {
                    textView[i].setVisibility(View.GONE);
                }
                if (results[i] == Integer.parseInt(filter)) {
                    textView[i].setVisibility(View.VISIBLE);
                }
            }
        }//end equal to if
        if (greaterThan.isChecked() && !equalTo.isChecked())
        {//start greater than if
            for (int i = 0; i < results.length; i++) {
                if (results[i] >= Integer.parseInt(filter)) {
                    textView[i].setVisibility(View.GONE);
                }
                if (results[i] < Integer.parseInt(filter)) {
                    textView[i].setVisibility(View.VISIBLE);
                }
            }
        }//end greater than if
        if (lessThan.isChecked() && !equalTo.isChecked())
        {//start lest than if
            for (int i = 0; i < results.length; i++) {
                if (results[i] <= Integer.parseInt(filter)) {
                    textView[i].setVisibility(View.GONE);
                }
                if (results[i] > Integer.parseInt(filter)) {
                    textView[i].setVisibility(View.VISIBLE);
                }
            }
        }//end less than if

        if (lessThan.isChecked() && equalTo.isChecked())
        {//start lest than equla to if
            for (int i = 0; i < results.length; i++) {
                if (results[i] < Integer.parseInt(filter)) {
                    textView[i].setVisibility(View.GONE);
                }
                if (results[i] > Integer.parseInt(filter)) {
                    textView[i].setVisibility(View.VISIBLE);
                }
            }
        }//end less than equla to if
        if (greaterThan.isChecked() && equalTo.isChecked())
        {//start greater than equla to if
            for (int i = 0; i < results.length; i++) {
                if (results[i] > Integer.parseInt(filter)) {
                    textView[i].setVisibility(View.GONE);
                }
                if (results[i] < Integer.parseInt(filter)) {
                    textView[i].setVisibility(View.VISIBLE);
                }
            }
        }//end greater than equla to if
    }

}
