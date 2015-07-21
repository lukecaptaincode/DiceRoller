package com.lukecaptaincode.diceroller;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * Created by luke on 21/07/15.
 */
public class AboutFragment extends DialogFragment {

        TextView mainText;
        public AboutFragment() {
            //empty constructor
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.aboutdialogfragment, container,
                    false);
            getDialog().setTitle("About");
            // Do something else
            return view;
        }
    }

