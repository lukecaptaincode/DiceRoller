package com.lukecaptaincode.diceroller;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.security.SecureRandom;


public class scatterDice extends ActionBarActivity {
    //ads
    AdRequest adRequest;
    AdView mAdView;
    //Image variables
    int[] arrowImageUris;
    Bitmap[] arrowImages;
    //Gui Elements
    Button scatterButton;
    ImageView scatterImage;
    TextView scatterText;
    //random
    SecureRandom random;
    int randRes;
    int imageChoose;
    //typeface
    Typeface myTypeface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scatter_dice);
        loadAds();
        initButtons();
        setTypeface();
    }

    public void setTypeface() {
        myTypeface = Typeface.createFromAsset(getAssets(), "Nurjan.ttf");
        scatterText = (TextView) findViewById(R.id.ScatterDice_scatterText_lbl);
        scatterImage = (ImageView) findViewById(R.id.ScatterDice_mainImage_img);
        scatterButton.setTypeface(myTypeface);
        scatterText.setTypeface(myTypeface);

    }

    public void initButtons() {
        scatterButton = (Button) findViewById(R.id.ScatterDice_scatterButton_btn);
        scatterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scatterLogic(v);
            }
        });
    }

    public void scatterLogic(View v) {
        random = new SecureRandom();
        randRes = random.nextInt(12 - 2 + 1) + 2;
        imageChoose = random.nextInt(37 - 0 + 1) + 0;
        switch (imageChoose) {
            case 0:
                scatterImage.setImageResource(R.drawable.scatter1);
                break;
            case 1:
                scatterImage.setImageResource(R.drawable.scatter2);
                break;
            case 2:
                scatterImage.setImageResource(R.drawable.scatter3);
                break;
            case 3:
                scatterImage.setImageResource(R.drawable.scatter4);
                break;
            case 4:
                scatterImage.setImageResource(R.drawable.scatter5);
                break;
            case 5:
                scatterImage.setImageResource(R.drawable.scatterhit);
                break;
            case 6:
                scatterImage.setImageResource(R.drawable.scatter6);
                break;
            case 7:
                scatterImage.setImageResource(R.drawable.scatter7);
                break;
            case 8:
                scatterImage.setImageResource(R.drawable.scatter8);
                break;
            case 9:
                scatterImage.setImageResource(R.drawable.scatter9);
                break;
            case 10:
                scatterImage.setImageResource(R.drawable.scatter10);
                break;
            case 11:
                scatterImage.setImageResource(R.drawable.scatterhit);
                break;
            case 12:
                scatterImage.setImageResource(R.drawable.scatter11);
                break;
            case 13:
                scatterImage.setImageResource(R.drawable.scatter12);
                break;
            case 14:
                scatterImage.setImageResource(R.drawable.scatter13);
                break;
            case 15:
                scatterImage.setImageResource(R.drawable.scatter14);
                break;
            case 16:
                scatterImage.setImageResource(R.drawable.scatter15);
                break;
            case 17:
                scatterImage.setImageResource(R.drawable.scatterhit);
                break;
            case 18:
                scatterImage.setImageResource(R.drawable.scatter16);
                break;
            case 19:
                scatterImage.setImageResource(R.drawable.scatter17);
                break;
            case 20:
                scatterImage.setImageResource(R.drawable.scatter18);
                break;
            case 21:
                scatterImage.setImageResource(R.drawable.scatter19);
                break;
            case 22:
                scatterImage.setImageResource(R.drawable.scatter20);
                break;
            case 23:
                scatterImage.setImageResource(R.drawable.scatterhit);
                break;
            case 24:
                scatterImage.setImageResource(R.drawable.scatter21);
                break;
            case 25:
                scatterImage.setImageResource(R.drawable.scatter22);
                break;
            case 26:
                scatterImage.setImageResource(R.drawable.scatter23);
                break;
            case 27:
                scatterImage.setImageResource(R.drawable.scatter24);
                break;
            case 28:
                scatterImage.setImageResource(R.drawable.scatter25);
                break;
            case 29:
                scatterImage.setImageResource(R.drawable.scatterhit);
                break;
            case 30:
                scatterImage.setImageResource(R.drawable.scatter26);
                break;
            case 31:
                scatterImage.setImageResource(R.drawable.scatter27);
                break;
            case 32:
                scatterImage.setImageResource(R.drawable.scatter28);
                break;
            case 33:
                scatterImage.setImageResource(R.drawable.scatter29);
                break;
            case 34:
                scatterImage.setImageResource(R.drawable.scatter30);
                break;
            case 35:
                scatterImage.setImageResource(R.drawable.scatterhit);
                break;
            case 36:
                scatterImage.setImageResource(R.drawable.scatter31);
                break;
            case 37:
                scatterImage.setImageResource(R.drawable.scatter32);
                break;
            default:
                scatterImage.setImageResource(R.drawable.scatterhit);
                break;
        }

        if(imageChoose == 35 ||imageChoose == 29 ||imageChoose == 23 ||imageChoose == 17 ||imageChoose == 11 ||imageChoose == 5)
        {
            scatterText.setText("Direct hit!");
        }
        else
        {
            scatterText.setText("Scatter by " + Integer.toString(randRes) + " inches");
        }

    }

    public void loadAds() {
        mAdView = ((AdView) findViewById(R.id.adView));
        adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
    }
}
