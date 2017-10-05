package com.lukecaptaincode.diceroller;

/**
 * Created by luke on 21/07/15.
 */


import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class ScatterHelpFragment extends DialogFragment {

    TextView mainText;
    public ScatterHelpFragment() {
        //empty constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dialogfragment, container,
                false);
        getDialog().setTitle("How to use Scatter Dice");
        // Do something else
        return view;
    }
}

