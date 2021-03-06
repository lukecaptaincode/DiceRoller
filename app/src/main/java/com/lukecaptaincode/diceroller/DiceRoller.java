package com.lukecaptaincode.diceroller;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;


public class DiceRoller extends AppCompatActivity {

    int userDiceNo;
    int userSidesNo;
    int [] results;
    RollLogic myRollLogic;
    // The following are used for the shake detection
    private SensorManager mSensorManager;
    private Sensor mAccelerometer;
    private ShakeDetector mShakeDetector;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dice_roller);
        //typeface
        Typeface myTypeface = Typeface.createFromAsset(getAssets(), "Decalotype-SemiBold.ttf");
        Typeface myTypeface_Hero = Typeface.createFromAsset(getAssets(), "Heroic.ttf");
        TextView noDiceText = findViewById(R.id.DiceRoller_noDice_lbl);
        //adview
        AdView mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        //gui elements
        final EditText noDiceBox = findViewById(R.id.DiceRoller_noDice_txt);
        TextView noSidesText = findViewById(R.id.DiceRoller_noSides_lbl);
        TextView shakeText = findViewById(R.id.DiceRoller_shake_lbl);
        final EditText noSidesBox = findViewById(R.id.DiceRoller_noSides_txt);
        Button rollButton = findViewById(R.id.DiceRoller_roll_btn);
        //set typeface
        rollButton.setTypeface(myTypeface_Hero);
        noDiceBox.setTypeface(myTypeface);
        noDiceText.setTypeface(myTypeface);
        noSidesBox.setTypeface(myTypeface);
        noSidesText.setTypeface(myTypeface);
        shakeText.setTypeface(myTypeface);
        //logic class object
        myRollLogic = new RollLogic();

        // ShakeDetector initialization
        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        mAccelerometer = mSensorManager
                .getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        mShakeDetector = new ShakeDetector();
        //shake listener
        mShakeDetector.setOnShakeListener(new ShakeDetector.OnShakeListener() {

            @Override
            public void onShake(int count) {
            roll();

        }
    });
        //button listener
        Button roll = (Button) findViewById(R.id.DiceRoller_roll_btn);
        roll.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
              roll();
            }

        });
    }
    @Override
    public void onResume() {
        super.onResume();
        // Add the following line to register the Session Manager Listener onResume
        mSensorManager.registerListener(mShakeDetector, mAccelerometer, SensorManager.SENSOR_DELAY_FASTEST);
    }

    @Override
    public void onPause() {
        // Add the following line to unregister the Sensor Manager onPause
        mSensorManager.unregisterListener(mShakeDetector);
        super.onPause();
    }
    public void roll()
    {//start of roll method
        //edit text objects
        final EditText noDiceBox = (EditText)findViewById(R.id.DiceRoller_noDice_txt);
        final EditText noSidesBox = (EditText)findViewById(R.id.DiceRoller_noSides_txt);
        //if checks if boxes are empty or equl to 0
        if(noDiceBox.getText().toString().trim().length() ==0||noSidesBox.getText().toString().trim().length() ==0
                ||noSidesBox.getText().toString()=="0"||noDiceBox.getText().toString()=="0")
        {//if start
            Toast.makeText(getApplicationContext(), "Please do not leave boxes empty or enter a 0",
                    Toast.LENGTH_LONG).show();
            noDiceBox.setText("1");
            noSidesBox.setText("6");

        }//if end
        else {//else start
            userDiceNo = Integer.parseInt(noDiceBox.getText().toString());
            userSidesNo = Integer.parseInt(noSidesBox.getText().toString());
            myRollLogic.setUserInput(userDiceNo, userSidesNo);
            myRollLogic.compute();
            results = myRollLogic.getResults();
            mSensorManager.unregisterListener(mShakeDetector);
            mShakeDetector = null;
            Intent myIntent = new Intent(DiceRoller.this, RollResults.class);
            myIntent.putExtra("results", results);
            startActivity(myIntent);
            finish();
        }//else end
    }//end of roll method
}
