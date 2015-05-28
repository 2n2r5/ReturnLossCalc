package com.ridgeequipment.returnlosscalc;

import android.app.Activity;
import android.view.Gravity;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Toast;

/**
 * Created by tim on 5/28/15.
 */


public class LayoutElements extends Activity {

    Components cp = new Components();


    //Array for Keeping selected variables

    String[][] ks = {new String[0]};


    //Creates Custom Array Adapter for Component Sprinner
    public ArrayAdapter<String> manuadapter(int a) {

        String[][] working = new String[0][];
        String[] holding = new String[0];

        switch (a) {
            default:
                Toast.makeText(getApplicationContext(), "Invalid Selection", Toast.LENGTH_LONG).show();
                break;
            case 1:
                Toast.makeText(getApplicationContext(), "Select Component", Toast.LENGTH_LONG).show();
                break;
            case 2:
                working = cp.combiners;
                break;
            case 3:
                working = cp.antennas;
                break;
            case 4:
                working = cp.biast;
                break;
            case 5:
                working = cp.loads;
                break;
        }
        for (int i = 0; i < working.length; i++) {
            holding[i] = working[i][0];
        }


        Components cp = new Components();
        ArrayAdapter<String> aad = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_dropdown_item,
                holding
        );

        return aad;
    }


    //Creates Custom Array Adapter for Component Sprinner
    public ArrayAdapter<String> compadapter() {

        Components cp = new Components();
        ArrayAdapter<String> aad = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_dropdown_item,
                cp.getComponent()
        );

        return aad;
    }


    public LinearLayout.LayoutParams bodyLayout() {
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        lp.gravity = Gravity.START;
        lp.leftMargin = 20;
        lp.rightMargin = 5;
        lp.topMargin = 10;
        lp.bottomMargin = 10;

        return lp;


    }


}