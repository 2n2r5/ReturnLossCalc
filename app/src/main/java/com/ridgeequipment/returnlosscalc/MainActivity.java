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
import android.os.Bundle;
import android.util.Log;
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



    }
    @Override
            protected void onStart(){
            super.onStart();
            setContentView(R.layout.activity_main);

        LinearLayout parent = (LinearLayout) findViewById(R.id.parentlayout);
        setContentView(parent);

        //initiates and stores frequency input
        Integer freq = le.freq(findViewById(R.id.frequencyinput));


        int countlines = 1;


        // Setup Layout
        Log.i("Loading Preload", "For loop PreLoad");


            final LinearLayout newline = le.listitem(getApplicationContext(), 0);
            parent.addView(newline);
            newline.setVisibility(View.VISIBLE);

            final Spinner component = le.comp(getApplicationContext(), 0);
            component.setAdapter(componentadap());
            newline.addView(component);


            final Spinner manufacturer = le.manu(getApplicationContext(), 0, selectionadap(compint(component), 0));
            newline.addView(manufacturer);

            //Spinner model = le.model(getApplicationContext(), 0, selectionadap(compint(component), 0));
            //newline.addView(model);

            EditText length = le.length(getApplicationContext(), 0);
            newline.addView(length);

            Log.i("Event Start","Starting Component OnItemSelectListener");
            component.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                  manufacturer.setAdapter(selectionadap(position,0));
                  manufacturer.setVisibility(View.VISIBLE);
                }
                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });










    }

    public ArrayAdapter<String> componentadap(){
        return new ArrayAdapter(
                getApplicationContext(),
                R.layout.spinner_item,R.id.spintv,
                cp.getComponent()
        );

    }


    //Creates Custom Array Adapter for Component Spinner
    //a = selection number of component adapter, b = column number of array
    public ArrayAdapter<String> selectionadap(int a,int b) {

        String[] working = new String[100];
        //Decide which component array to choose from
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
        //Create Adapter
        ArrayAdapter<String> aad = new ArrayAdapter<>(
                this,
                R.layout.spinner_item,R.id.spintv,
                working
        );
        return aad;
    }

    public Integer compint(Spinner comp){
        return comp.getSelectedItemPosition();
    }
    public String compstring(Spinner comp){
        return comp.getSelectedItem().toString();
    }

}

