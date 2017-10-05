package com.lukecaptaincode.diceroller;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.security.SecureRandom;


public class scatterDice extends AppCompatActivity {
    //ads
    AdRequest adRequest;
    AdView mAdView;
    //Gui Elements
    Button scatterButton;
    ImageView scatterImage;
    TextView scatterText;
    Button helpButton;
    //random
    SecureRandom random;
    int randRes;
    int imageChoose;
    //typeface
    Typeface myTypeface;
    //Fragment
    FragmentManager fm = getSupportFragmentManager();

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
        scatterText = findViewById(R.id.ScatterDice_scatterText_lbl);
        scatterImage = findViewById(R.id.ScatterDice_mainImage_img);
        scatterButton.setTypeface(myTypeface);
        scatterText.setTypeface(myTypeface);
        helpButton.setTypeface(myTypeface);

    }

    public void initButtons() {
        scatterButton = findViewById(R.id.ScatterDice_scatterButton_btn);
        scatterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scatterLogic(v);
            }
        });
        helpButton = findViewById(R.id.ScatterDice_helpButton_btn);
        helpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                helpLogic(v);

            }
        });
    }

    public void helpLogic(View v)
    {
        ScatterHelpFragment helpFrag = new ScatterHelpFragment();
        helpFrag.show(fm, "Help");
    }
    public void scatterLogic(View v) {
        random = new SecureRandom();
        randRes = random.nextInt(12 - 2 + 1) + 2;
        imageChoose = random.nextInt(150 + 1);
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
                scatterImage.setImageResource(R.drawable.scatterhit);
                break;
            case 5:
                scatterImage.setImageResource(R.drawable.scatter5);
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
                scatterImage.setImageResource(R.drawable.scatterhit);
                break;
            case 10:
                scatterImage.setImageResource(R.drawable.scatter9);
                break;
            case 11:
                scatterImage.setImageResource(R.drawable.scatter10);
                break;
            case 12:
                scatterImage.setImageResource(R.drawable.scatter11);
                break;
            case 13:
                scatterImage.setImageResource(R.drawable.scatter12);
                break;
            case 14:
                scatterImage.setImageResource(R.drawable.scatterhit);
                break;
            case 15:
                scatterImage.setImageResource(R.drawable.scatter13);
                break;
            case 16:
                scatterImage.setImageResource(R.drawable.scatter14);
                break;
            case 17:
                scatterImage.setImageResource(R.drawable.scatter15);
                break;
            case 18:
                scatterImage.setImageResource(R.drawable.scatter16);
                break;
            case 19:
                scatterImage.setImageResource(R.drawable.scatterhit);
                break;
            case 20:
                scatterImage.setImageResource(R.drawable.scatter17);
                break;
            case 21:
                scatterImage.setImageResource(R.drawable.scatter18);
                break;
            case 22:
                scatterImage.setImageResource(R.drawable.scatter19);
                break;
            case 23:
                scatterImage.setImageResource(R.drawable.scatter20);
                break;
            case 24:
                scatterImage.setImageResource(R.drawable.scatterhit);
                break;
            case 25:
                scatterImage.setImageResource(R.drawable.scatter21);
                break;
            case 26:
                scatterImage.setImageResource(R.drawable.scatter22);
                break;
            case 27:
                scatterImage.setImageResource(R.drawable.scatter23);
                break;
            case 28:
                scatterImage.setImageResource(R.drawable.scatter24);
                break;
            case 29:
                scatterImage.setImageResource(R.drawable.scatterhit);
                break;
            case 30:
                scatterImage.setImageResource(R.drawable.scatter25);
                break;
            case 31:
                scatterImage.setImageResource(R.drawable.scatter26);
                break;
            case 32:
                scatterImage.setImageResource(R.drawable.scatter27);
                break;
            case 33:
                scatterImage.setImageResource(R.drawable.scatter28);
                break;
            case 34:
                scatterImage.setImageResource(R.drawable.scatterhit);
                break;
            case 35:
                scatterImage.setImageResource(R.drawable.scatter29);
                break;
            case 36:
                scatterImage.setImageResource(R.drawable.scatter30);
                break;
            case 37:
                scatterImage.setImageResource(R.drawable.scatter31);
                break;
            case 38:
                scatterImage.setImageResource(R.drawable.scatter32);
                break;
            case 39:
                scatterImage.setImageResource(R.drawable.scatterhit);
                break;
            case 40:
                scatterImage.setImageResource(R.drawable.scatter33);
                break;
            case 41:
                scatterImage.setImageResource(R.drawable.scatter34);
                break;
            case 42:
                scatterImage.setImageResource(R.drawable.scatter35);
                break;
            case 43:
                scatterImage.setImageResource(R.drawable.scatter36);
                break;
            case 44:
                scatterImage.setImageResource(R.drawable.scatterhit);
                break;
            case 45:
                scatterImage.setImageResource(R.drawable.scatter37);
                break;
            case 46:
                scatterImage.setImageResource(R.drawable.scatter38);
                break;
            case 47:
                scatterImage.setImageResource(R.drawable.scatter39);
                break;
            case 48:
                scatterImage.setImageResource(R.drawable.scatter40);
                break;
            case 49:
                scatterImage.setImageResource(R.drawable.scatterhit);
                break;
            case 50:
                scatterImage.setImageResource(R.drawable.scatter41);
                break;
            case 51:
                scatterImage.setImageResource(R.drawable.scatter42);
                break;
            case 52:
                scatterImage.setImageResource(R.drawable.scatter43);
                break;
            case 53:
                scatterImage.setImageResource(R.drawable.scatter44);
                break;
            case 54:
                scatterImage.setImageResource(R.drawable.scatterhit);
                break;
            case 55:
                scatterImage.setImageResource(R.drawable.scatter45);
                break;
            case 56:
                scatterImage.setImageResource(R.drawable.scatter46);
                break;
            case 57:
                scatterImage.setImageResource(R.drawable.scatter47);
                break;
            case 58:
                scatterImage.setImageResource(R.drawable.scatter48);
                break;
            case 59:
                scatterImage.setImageResource(R.drawable.scatterhit);
                break;
            case 60:
                scatterImage.setImageResource(R.drawable.scatter49);
                break;
            case 61:
                scatterImage.setImageResource(R.drawable.scatter50);
                break;
            case 62:
                scatterImage.setImageResource(R.drawable.scatter51);
                break;
            case 63:
                scatterImage.setImageResource(R.drawable.scatter52);
                break;
            case 64:
                scatterImage.setImageResource(R.drawable.scatterhit);
                break;
            case 65:
                scatterImage.setImageResource(R.drawable.scatter53);
                break;
            case 66:
                scatterImage.setImageResource(R.drawable.scatter54);
                break;
            case 67:
                scatterImage.setImageResource(R.drawable.scatter55);
                break;
            case 68:
                scatterImage.setImageResource(R.drawable.scatter56);
                break;
            case 69:
                scatterImage.setImageResource(R.drawable.scatterhit);
                break;
            case 70:
                scatterImage.setImageResource(R.drawable.scatter57);
                break;
            case 71:
                scatterImage.setImageResource(R.drawable.scatter58);
                break;
            case 72:
                scatterImage.setImageResource(R.drawable.scatter59);
                break;
            case 73:
                scatterImage.setImageResource(R.drawable.scatter60);
                break;
            case 74:
                scatterImage.setImageResource(R.drawable.scatterhit);
                break;
            case 75:
                scatterImage.setImageResource(R.drawable.scatter61);
                break;
            case 76:
                scatterImage.setImageResource(R.drawable.scatter62);
                break;
            case 77:
                scatterImage.setImageResource(R.drawable.scatter63);
                break;
            case 78:
                scatterImage.setImageResource(R.drawable.scatter64);
                break;
            case 79:
                scatterImage.setImageResource(R.drawable.scatterhit);
                break;
            case 80:
                scatterImage.setImageResource(R.drawable.scatter65);
                break;
            case 81:
                scatterImage.setImageResource(R.drawable.scatter66);
                break;
            case 82:
                scatterImage.setImageResource(R.drawable.scatter67);
                break;
            case 83:
                scatterImage.setImageResource(R.drawable.scatter68);
                break;
            case 84:
                scatterImage.setImageResource(R.drawable.scatterhit);
                break;
            case 85:
                scatterImage.setImageResource(R.drawable.scatter69);
                break;
            case 86:
                scatterImage.setImageResource(R.drawable.scatter70);
                break;
            case 87:
                scatterImage.setImageResource(R.drawable.scatter71);
                break;
            case 88:
                scatterImage.setImageResource(R.drawable.scatter72);
                break;
            case 89:
                scatterImage.setImageResource(R.drawable.scatterhit);
                break;
            case 90:
                scatterImage.setImageResource(R.drawable.scatter73);
                break;
            case 91:
                scatterImage.setImageResource(R.drawable.scatter74);
                break;
            case 92:
                scatterImage.setImageResource(R.drawable.scatter75);
                break;
            case 93:
                scatterImage.setImageResource(R.drawable.scatter76);
                break;
            case 94:
                scatterImage.setImageResource(R.drawable.scatterhit);
                break;
            case 95:
                scatterImage.setImageResource(R.drawable.scatter77);
                break;
            case 96:
                scatterImage.setImageResource(R.drawable.scatter78);
                break;
            case 97:
                scatterImage.setImageResource(R.drawable.scatter79);
                break;
            case 98:
                scatterImage.setImageResource(R.drawable.scatter80);
                break;
            case 99:
                scatterImage.setImageResource(R.drawable.scatterhit);
                break;
            case 100:
                scatterImage.setImageResource(R.drawable.scatter81);
                break;
            case 101:
                scatterImage.setImageResource(R.drawable.scatter82);
                break;
            case 102:
                scatterImage.setImageResource(R.drawable.scatter83);
                break;
            case 103:
                scatterImage.setImageResource(R.drawable.scatter84);
                break;
            case 104:
                scatterImage.setImageResource(R.drawable.scatterhit);
                break;
            case 105:
                scatterImage.setImageResource(R.drawable.scatter85);
                break;
            case 106:
                scatterImage.setImageResource(R.drawable.scatter86);
                break;
            case 107:
                scatterImage.setImageResource(R.drawable.scatter87);
                break;
            case 108:
                scatterImage.setImageResource(R.drawable.scatter88);
                break;
            case 109:
                scatterImage.setImageResource(R.drawable.scatterhit);
                break;
            case 110:
                scatterImage.setImageResource(R.drawable.scatter89);
                break;
            case 111:
                scatterImage.setImageResource(R.drawable.scatter90);
                break;
            case 112:
                scatterImage.setImageResource(R.drawable.scatter91);
                break;
            case 113:
                scatterImage.setImageResource(R.drawable.scatter91);
                break;
            case 114:
                scatterImage.setImageResource(R.drawable.scatterhit);
                break;
            case 115:
                scatterImage.setImageResource(R.drawable.scatter92);
                break;
            case 116:
                scatterImage.setImageResource(R.drawable.scatter93);
                break;
            case 117:
                scatterImage.setImageResource(R.drawable.scatter94);
                break;
            case 118:
                scatterImage.setImageResource(R.drawable.scatter95);
                break;
            case 119:
                scatterImage.setImageResource(R.drawable.scatterhit);
                break;
            case 120:
                scatterImage.setImageResource(R.drawable.scatter96);
                break;
            case 121:
                scatterImage.setImageResource(R.drawable.scatter97);
                break;
            case 122:
                scatterImage.setImageResource(R.drawable.scatter98);
                break;
            case 123:
                scatterImage.setImageResource(R.drawable.scatter99);
                break;
            case 124:
                scatterImage.setImageResource(R.drawable.scatterhit);
                break;
            case 125:
                scatterImage.setImageResource(R.drawable.scatter100);
                break;
            case 126:
                scatterImage.setImageResource(R.drawable.scatter101);
                break;
            case 127:
                scatterImage.setImageResource(R.drawable.scatter102);
                break;
            case 128:
                scatterImage.setImageResource(R.drawable.scatter102);
                break;
            case 129:
                scatterImage.setImageResource(R.drawable.scatterhit);
                break;
            case 130:
                scatterImage.setImageResource(R.drawable.scatter103);
                break;
            case 131:
                scatterImage.setImageResource(R.drawable.scatter104);
                break;
            case 132:
                scatterImage.setImageResource(R.drawable.scatter105);
                break;
            case 133:
                scatterImage.setImageResource(R.drawable.scatter106);
                break;
            case 134:
                scatterImage.setImageResource(R.drawable.scatterhit);
                break;
            case 135:
                scatterImage.setImageResource(R.drawable.scatter107);
                break;
            case 136:
                scatterImage.setImageResource(R.drawable.scatter108);
                break;
            case 137:
                scatterImage.setImageResource(R.drawable.scatter109);
                break;
            case 138:
                scatterImage.setImageResource(R.drawable.scatter110);
                break;
            case 139:
                scatterImage.setImageResource(R.drawable.scatterhit);
                break;
            case 140:
                scatterImage.setImageResource(R.drawable.scatter111);
                break;
            case 141:
                scatterImage.setImageResource(R.drawable.scatter112);
                break;
            case 142:
                scatterImage.setImageResource(R.drawable.scatter113);
                break;
            case 143:
                scatterImage.setImageResource(R.drawable.scatter114);
                break;
            case 144:
                scatterImage.setImageResource(R.drawable.scatterhit);
                break;
            case 145:
                scatterImage.setImageResource(R.drawable.scatter115);
                break;
            case 146:
                scatterImage.setImageResource(R.drawable.scatter116);
                break;
            case 147:
                scatterImage.setImageResource(R.drawable.scatter117);
                break;
            case 148:
                scatterImage.setImageResource(R.drawable.scatter118);
                break;
            case 149:
                scatterImage.setImageResource(R.drawable.scatter119);
                break;
            case 150:
                scatterImage.setImageResource(R.drawable.scatter120);
                break;

            default:
                scatterImage.setImageResource(R.drawable.scatterhit);
                break;
        }

        if(imageChoose == 4 ||imageChoose == 9 ||imageChoose == 14 ||imageChoose == 19 ||imageChoose == 24 ||imageChoose == 29
                ||imageChoose == 34||imageChoose == 39||imageChoose == 44||imageChoose == 49||imageChoose == 54||imageChoose == 59
                ||imageChoose == 64||imageChoose == 69||imageChoose == 74||imageChoose == 79||imageChoose == 84||imageChoose == 89
                ||imageChoose == 94||imageChoose == 99||imageChoose == 104||imageChoose == 109||imageChoose == 114
                ||imageChoose == 119||imageChoose == 124||imageChoose == 129||imageChoose == 134||imageChoose == 139
                ||imageChoose == 144)
        {
            String directHit = "Direct hit!";
            scatterText.setText(directHit);
        }
        else
        {
            scatterText.setText("Scatter by " + Integer.toString(randRes) + " inches");
        }

    }

    public void loadAds() {
        mAdView = findViewById(R.id.adView);
        adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
    }
}
