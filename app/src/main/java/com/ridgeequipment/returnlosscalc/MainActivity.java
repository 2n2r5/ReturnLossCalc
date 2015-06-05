package com.ridgeequipment.returnlosscalc;

/*
 * File Name: MainActivity.java
 * Description: This file is where the bulk of all activity takes place. All UI items must originate
 * here. They should be placed in or after the onCreate() method.
 *
 * Creation of all body items are done programmatically on demand to cut down on excessive UI elements.
 * This will also provide a the best possible layout control for elements.
 *
 * After a system element is defined using the drop down boxes, it's loss and reflection are calculated
 * and added to/subtracted from a rolling calculation. A load or antenna should terminate any signal
 * and will denote the end of a system calculation.
 */



import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputType;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends Activity {



    //import methods from other classes
    CustomMethods mymethods = new CustomMethods();
    CableTypes ct = new CableTypes();
    Components cp = new Components();
    LayoutElements le = new LayoutElements();
    Integer freq = 0;
    int longest = 4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



      Integer freq = le.freq(findViewById(R.id.frequencyinput));


        // Setup Layout

        le.listitem(this,1).addView(le.comp(getApplicationContext(), 1), le.spinnerLayout());


        le.listitem(this,1).addView(le.manu(getApplicationContext(), 1), le.spinnerLayout());


        try {
            final String manuSelected = le.manu(getApplicationContext(), 1).getSelectedItem().toString().trim();
        } catch (NullPointerException e) {

        }


        le.listitem(this,1).addView(le.model(getApplicationContext(), 1), le.spinnerLayout());
        try {
            final String modelSelected = le.model(getApplicationContext(), 1).getSelectedItem().toString().trim();
        } catch (NullPointerException e) {

        }

        le.listitem(this,1).addView(le.length(getApplicationContext(), 1));

    }

    //Creates Custom Array Adapter for Component Sprinner
    public ArrayAdapter<String> itemadapter(int a,int b) {

        String[] working = new String[100];
        String[] holding = new String[101];

        switch (a+1) {
            default:working[0] = "No array found";
                Toast.makeText(getApplicationContext(), "Invalid Selection", Toast.LENGTH_LONG).show();
                break;
            case 1:working[0] = "No array found";
                Toast.makeText(getApplicationContext(), "Select a Component", Toast.LENGTH_LONG).show();
                break;
            case 2:
                working = cp.combinerRawValues(b);
                break;
            case 3:
                working = cp.biastRawValues(b);
                break;
            case 4:
                working = cp.cableRawValues(freq,b);
                break;
            case 5:
                working = cp.loadRawValues(b);
                break;
            case 6:
                working = cp.antennaRawValues(b);
                break;
        }



        ArrayAdapter<String> aad = new ArrayAdapter<>(
                this,
                R.layout.spinner_item,R.id.spintv,
                working
        );

        return aad;
    }




}

