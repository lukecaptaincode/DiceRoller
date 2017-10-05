package com.lukecaptaincode.diceroller;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;


public class WoundCounter extends AppCompatActivity {
    //element arrays
    private Button [] addButtons;
    private Button [] delButtons;
    private Button [] woundButtons;
    private EditText [] nameBoxes;
    private EditText [] woundBoxes;
    //element id
    int [] nameBoxId;
    int [] woundBoxId;
    int [] addButtonId;
    //elements
    Typeface myTypeface;
    TextView woundTitle;
    TextView characterNameTitle;
    TextView woundHeader;
    //Prefs
    public static String MY_PREFS = "MY_PREFS";
    private SharedPreferences mySharedPreferences;
    int prefMode;
    //returned pref variable
    String [] returnedStorage;
    String [] returnedNames;
    String [] returnedWounds;
    //ads
    AdRequest adRequest;
    AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wound_counter);

        loadAds();
        initBoxes();
        initButtons();
        loadSharedPrefs();
        userCharCheck();
        setTypeface();

    }
    public void initBoxes()
    {
        //Name Boxes
        nameBoxId = new int[20];
        for(int i = 0; i<nameBoxId.length;i++)
        {
            nameBoxId[i] = getResources().getIdentifier("WoundsCounter_charName"+(i+1)+"_txt", "id", this.getPackageName());
        }
        nameBoxes = new EditText[20];
        for (int i = 0; i <nameBoxes.length;i++)
        {
            nameBoxes[i] = findViewById(nameBoxId[i]);
        }
        for(int i = 0; i<nameBoxes.length; i++)
        {
            nameBoxes[i].setTag(i);
            nameBoxes[i].setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    nameBoxesClick(view);
                    return false;
                }
            });
        }
        //Wound Boxes
        woundBoxId = new int[20];
        for(int i = 0; i<woundBoxId.length;i++)
        {
            woundBoxId[i] = getResources().getIdentifier("WoundsCounter_wounds"+(i+1)+"_txt", "id", this.getPackageName());
        }
        woundBoxes = new EditText[20];
        for (int i = 0; i <woundBoxes.length;i++)
        {
            woundBoxes[i] = findViewById(woundBoxId[i]);
        }
        for(int i = 0; i<woundBoxes.length; i++)
        {
            woundBoxes[i].setTag(i);
            woundBoxes[i].setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    woundBoxesClick(view);
                    return false;
                }
            });
        }
    }

    public void initButtons()
    {
        //add Buttons
        addButtonId = new int[20];
        addButtons = new Button[20];
        addButtons[0] = findViewById(R.id.WoundCounter_add1_btn);
        addButtons[1] = findViewById(R.id.WoundCounter_add2_btn);
        addButtons[2] = findViewById(R.id.WoundCounter_add3_btn);
        addButtons[3] = findViewById(R.id.WoundCounter_add4_btn);
        addButtons[4] = findViewById(R.id.WoundCounter_add5_btn);
        addButtons[5] = findViewById(R.id.WoundCounter_add6_btn);
        addButtons[6] = findViewById(R.id.WoundCounter_add7_btn);
        addButtons[7] = findViewById(R.id.WoundCounter_add8_btn);
        addButtons[8] = findViewById(R.id.WoundCounter_add9_btn);
        addButtons[9] = findViewById(R.id.WoundCounter_add10_btn);
        addButtons[10] = findViewById(R.id.WoundCounter_add11_btn);
        addButtons[11] = findViewById(R.id.WoundCounter_add12_btn);
        addButtons[12] = findViewById(R.id.WoundCounter_add13_btn);
        addButtons[13] = findViewById(R.id.WoundCounter_add14_btn);
        addButtons[14] = findViewById(R.id.WoundCounter_add15_btn);
        addButtons[15] = findViewById(R.id.WoundCounter_add16_btn);
        addButtons[16] = findViewById(R.id.WoundCounter_add17_btn);
        addButtons[17] = findViewById(R.id.WoundCounter_add18_btn);
        addButtons[18] = findViewById(R.id.WoundCounter_add19_btn);
        addButtons[19] = findViewById(R.id.WoundCounter_add20_btn);
        for(int i = 0; i <addButtons.length; i++) {
          /*  addButtonId[i] = getResources().getIdentifier("WoundsCounter_add"+(i+1)+"_txt", "id", this.getPackageName());
            addButtons[i] =findViewById(addButtonId[i]);*/
            addButtons[i].setTag(i);
            addButtons[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    addButtonLogic(view);
                }
            });
        }
        //del buttons
        delButtons = new Button[20];
        delButtons[0] = findViewById(R.id.WoundCounter_del1_btn);
        delButtons[1] = findViewById(R.id.WoundCounter_del2_btn);
        delButtons[2] = findViewById(R.id.WoundCounter_del3_btn);
        delButtons[3] = findViewById(R.id.WoundCounter_del4_btn);
        delButtons[4] = findViewById(R.id.WoundCounter_del5_btn);
        delButtons[5] = findViewById(R.id.WoundCounter_del6_btn);
        delButtons[6] = findViewById(R.id.WoundCounter_del7_btn);
        delButtons[7] = findViewById(R.id.WoundCounter_del8_btn);
        delButtons[8] = findViewById(R.id.WoundCounter_del9_btn);
        delButtons[9] = findViewById(R.id.WoundCounter_del10_btn);
        delButtons[10] = findViewById(R.id.WoundCounter_del11_btn);
        delButtons[11] = findViewById(R.id.WoundCounter_del12_btn);
        delButtons[12] = findViewById(R.id.WoundCounter_del13_btn);
        delButtons[13] = findViewById(R.id.WoundCounter_del14_btn);
        delButtons[14] = findViewById(R.id.WoundCounter_del15_btn);
        delButtons[15] = findViewById(R.id.WoundCounter_del16_btn);
        delButtons[16] = findViewById(R.id.WoundCounter_del17_btn);
        delButtons[17] = findViewById(R.id.WoundCounter_del18_btn);
        delButtons[18] = findViewById(R.id.WoundCounter_del19_btn);
        delButtons[19] = findViewById(R.id.WoundCounter_del20_btn);

        for (int i = 0; i<delButtons.length; i++){
            delButtons[i].setTag(i);
            delButtons[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    delButtonLogic(view);
                }
            });
        }
        //wound buttons
        woundButtons = new Button[20];
        woundButtons[0] = findViewById(R.id.WoundCounter_wound1_btn);
        woundButtons[1] = findViewById(R.id.WoundCounter_wound2_btn);
        woundButtons[2] = findViewById(R.id.WoundCounter_wound3_btn);
        woundButtons[3] = findViewById(R.id.WoundCounter_wound4_btn);
        woundButtons[4] = findViewById(R.id.WoundCounter_wound5_btn);
        woundButtons[5] = findViewById(R.id.WoundCounter_wound6_btn);
        woundButtons[6] = findViewById(R.id.WoundCounter_wound7_btn);
        woundButtons[7] = findViewById(R.id.WoundCounter_wound8_btn);
        woundButtons[8] = findViewById(R.id.WoundCounter_wound9_btn);
        woundButtons[9] = findViewById(R.id.WoundCounter_wound10_btn);
        woundButtons[10] = findViewById(R.id.WoundCounter_wound11_btn);
        woundButtons[11] = findViewById(R.id.WoundCounter_wound12_btn);
        woundButtons[12] = findViewById(R.id.WoundCounter_wound13_btn);
        woundButtons[13] = findViewById(R.id.WoundCounter_wound14_btn);
        woundButtons[14] = findViewById(R.id.WoundCounter_wound15_btn);
        woundButtons[15] = findViewById(R.id.WoundCounter_wound16_btn);
        woundButtons[16] = findViewById(R.id.WoundCounter_wound17_btn);
        woundButtons[17] = findViewById(R.id.WoundCounter_wound18_btn);
        woundButtons[18] = findViewById(R.id.WoundCounter_wound19_btn);
        woundButtons[19] = findViewById(R.id.WoundCounter_wound20_btn);
        for (int i=0; i<woundButtons.length;i++ ){
            woundButtons[i].setTag(i);
            woundButtons[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    woundButtonLogic(view);
                }
            });
        }
    }

    public void setTypeface()
    {
        //typeface
        myTypeface = Typeface.createFromAsset(getAssets(), "Decalotype-SemiBold.ttf");
        woundTitle = findViewById(R.id.WoundsCounter_header_lbl);
        characterNameTitle = findViewById(R.id.WoundsCounter_nameHeader_lbl);
        woundHeader = findViewById(R.id.WoundsCounter_woundsHeader_lbl);
        woundTitle.setTypeface(myTypeface);
        characterNameTitle.setTypeface(myTypeface);
        woundTitle.setTypeface(myTypeface);
        characterNameTitle.setTypeface(myTypeface);
        woundHeader.setTypeface(myTypeface);

        for(int i = 0;i <addButtons.length; i++)
        {
            addButtons[i].setTypeface(myTypeface);
            woundButtons[i].setTypeface(myTypeface);
            delButtons[i].setTypeface(myTypeface);
            nameBoxes[i].setTypeface(myTypeface);
            woundBoxes[i].setTypeface(myTypeface);
        }
    }

    public void loadSharedPrefs()
    {
        prefMode = 0;
        mySharedPreferences = getSharedPreferences(MY_PREFS, prefMode);
        returnedStorage = new String[nameBoxes.length];
        returnedNames = new String[nameBoxes.length];
        returnedWounds = new String[nameBoxes.length];



        if (mySharedPreferences.getBoolean("firstrun", true)) {
            // Do first run stuff here then set 'firstrun' as false
            // using the following line to edit/commit prefs
            mySharedPreferences.edit().putBoolean("firstrun", false).apply();
            for(int i = 0;i < returnedStorage.length; i++)
            {
                SharedPreferences.Editor localEditor = mySharedPreferences.edit();
                localEditor.putString("key" + i, "Name0");
                localEditor.apply();
                returnedNames[i] = "Name";
                returnedWounds[i] = "0";
            }
        }
        else {
            try {
                for (int i = 0; i < returnedStorage.length; i++) {
                    returnedStorage[i] = mySharedPreferences.getString("key" + i, null);
                    returnedWounds[i] = returnedStorage[i].substring(returnedStorage[i].length() - 1);
                    returnedNames[i] = returnedStorage[i].substring(0, returnedStorage[i].length() - 1);
                }
            } catch (Exception localException) {
                for (int i = 0; i < returnedStorage.length; i++) {
                    Toast.makeText(getApplicationContext(), "Cannot load character " + i, Toast.LENGTH_LONG).show();
                    SharedPreferences.Editor localEditor = mySharedPreferences.edit();
                    localEditor.putString("key" + i, "Name0");
                    localEditor.apply();
                    returnedNames[i] = "Name";
                    returnedWounds[i] = "0";
                }

            }
        }
        for (int i =0;i<nameBoxes.length;i++)
        {
            nameBoxes[i].setText(returnedNames[i]);
            woundBoxes[i].setText(returnedWounds[i]);
        }
    }

    public void addButtonLogic(View view){//start of add button logic method
        int id =((Integer) view.getTag());
        if (inputCheck(view)) {
            nameBoxes[id].setBackgroundColor(Color.parseColor("#A6A6B8"));
            nameBoxes[id].setTextColor(Color.BLACK);
            nameBoxes[id].setFocusable(false);
            nameBoxes[id].setClickable(false);
            nameBoxes[id].setEnabled(false);
            woundBoxes[id].setBackgroundColor(Color.parseColor("#A6A6B8"));
            woundBoxes[id].setTextColor(Color.BLACK);
            woundBoxes[id].setFocusable(false);
            woundBoxes[id].setClickable(false);
            woundBoxes[id].setEnabled(false);
            SharedPreferences.Editor editor = mySharedPreferences.edit();
            String storage = nameBoxes[id].getText().toString() + woundBoxes[id].getText().toString();
            editor.putString("key" + id, storage);
            editor.apply();
        }
    }//end of add button logic method

    public void delButtonLogic(View view){//start of delete button logic
        int id =((Integer) view.getTag());
        nameBoxes[id].setBackground(ContextCompat.getDrawable(this, R.drawable.editextbacksmall));
        nameBoxes[id].setTextColor(Color.BLACK);
        nameBoxes[id].setFocusable(true);
        nameBoxes[id].setClickable(true);
        nameBoxes[id].setEnabled(true);
        String name = "Name";
        nameBoxes[id].setText(name);
        woundBoxes[id].setBackground(ContextCompat.getDrawable(this, R.drawable.editextbacksmaller));
        woundBoxes[id].setTextColor(Color.BLACK);
        woundBoxes[id].setText("0");
        woundBoxes[id].setFocusable(true);
        woundBoxes[id].setClickable(true);
        woundBoxes[id].setEnabled(true);
        woundButtons[id].setEnabled(true);
        SharedPreferences.Editor editor = mySharedPreferences.edit();
        String storage = nameBoxes[id].getText().toString()+woundBoxes[id].getText().toString();
        editor.putString("key" + id, storage);
        editor.apply();

    }//end of delete button logic

    public void woundButtonLogic(View view){//start wound button logic
        int id =((Integer) view.getTag());
        int wounds =Integer.parseInt(woundBoxes[id].getText().toString());
        wounds--;
        woundBoxes[id].setText(String.valueOf(wounds));
        if(wounds == 0){
            woundButtons[id].setEnabled(false);
        }
        SharedPreferences.Editor editor = mySharedPreferences.edit();
        String storage = nameBoxes[id].getText().toString()+woundBoxes[id].getText().toString();
        editor.putString("key" + id, storage);
        editor.apply();
    }//end wound button logic

    public void nameBoxesClick(View view){//start name boxes click method
        int id = ((Integer)view.getTag());
        nameBoxes[id].clearFocus();
        nameBoxes[id].setText("");
        InputMethodManager mgr = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        // only will trigger it if no physical keyboard is open
        mgr.showSoftInput(nameBoxes[id], InputMethodManager.SHOW_IMPLICIT);

    }//end name boxes click method

    public void woundBoxesClick(View view){//start name boxes click method
        int id = ((Integer)view.getTag());
        woundBoxes[id].clearFocus();
        woundBoxes[id].setText("");
        InputMethodManager mgr = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        // only will trigger it if no physical keyboard is open
        mgr.showSoftInput(woundBoxes[id], InputMethodManager.SHOW_IMPLICIT);

    }//end name boxes click method

    public void userCharCheck()
    {
        for(int i = 0;i < nameBoxes.length; i++)
        {
            if (!nameBoxes[i].getText().toString().equals("Name"))
            {
                nameBoxes[i].setBackgroundColor(Color.parseColor("#A6A6B8"));
                nameBoxes[i].setTextColor(ContextCompat.getColor(this, R.color.Black));
                nameBoxes[i].setFocusable(false);
                nameBoxes[i].setClickable(false);
                nameBoxes[i].setEnabled(false);
                woundBoxes[i].setBackgroundColor(Color.parseColor("#A6A6B8"));
                woundBoxes[i].setTextColor(ContextCompat.getColor(this, R.color.Black));
                woundBoxes[i].setFocusable(false);
                woundBoxes[i].setClickable(false);
                woundBoxes[i].setEnabled(false);
            }
        }
    }

    public boolean inputCheck(View view)
    {
        int i = ((Integer) view.getTag());
        if (nameBoxes[i].length() < 3)
        {
            Toast.makeText(getApplicationContext(), "Name too short!", Toast.LENGTH_SHORT).show();
            return false;
        }
        if ((nameBoxes[i].getText().toString().equalsIgnoreCase("Name")) || (nameBoxes[i].getText().toString().equalsIgnoreCase("name")) || (nameBoxes[i] == null))
        {
            Toast.makeText(getApplicationContext(), "Invalid name!", Toast.LENGTH_SHORT).show();
            return false;
        }

        if ((Integer.parseInt(woundBoxes[i].getText().toString()) == 0) || (woundBoxes[i] == null) || (woundBoxes[i].getText().toString().matches("")) || (Integer.parseInt(woundBoxes[i].getText().toString()) == 0) || (woundBoxes[i].getText().toString().equals("0")))
        {
            Toast.makeText(getApplicationContext(), "Character must have a wounds value!", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    public void loadAds()
    {
        mAdView = findViewById(R.id.adView);
        adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
    }



}




