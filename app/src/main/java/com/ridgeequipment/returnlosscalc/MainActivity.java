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
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {



    //import methods from other classes
    CustomMethods mymethods = new CustomMethods();
    CableTypes ct = new CableTypes();
    Components cp = new Components();
    LayoutElements le = new LayoutElements();
    Integer freq = 0;


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
        final EditText freq = (EditText) findViewById(R.id.frequencyinput);



        int countlines = 10;


        // Setup Layout
        Log.i("Loading Preload", "For loop PreLoad");

        for (int i=0;i<countlines;i++) {

            final LinearLayout newline = le.listitem(getApplicationContext(), i);
            parent.addView(newline);
            newline.setVisibility(View.VISIBLE);

            final Spinner component = le.comp(getApplicationContext(), i);
            component.setAdapter(componentadap());
            newline.addView(component);


            final Spinner manufacturer = le.manu(getApplicationContext(), i, selectionadap(compint(component), 0));
            newline.addView(manufacturer);

            final Spinner model = le.model(getApplicationContext(), i, selectionadap(compint(component), 0));
            newline.addView(model);

            final EditText length = le.length(getApplicationContext(), i);
            newline.addView(length);

            final TextView tv = le.tv(getApplicationContext(),i);
            newline.addView(tv);



            Log.i("Event Start", "Starting Component OnItemSelectListener");
            component.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                    if (!component.getSelectedItem().toString().trim().isEmpty()) {
                        final Integer selectedint = position;
                        if (component.getSelectedItem().toString().contains("Cable")) {
                            length.setVisibility(View.VISIBLE);
                        } else {
                            length.setVisibility(View.GONE);
                        }
                        manufacturer.setAdapter(selectionadap(selectedint, 0));
                        manufacturer.setVisibility(View.VISIBLE);
                        manufacturer.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                            @Override
                            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                if (!manufacturer.getSelectedItem().toString().trim().isEmpty()) {
                                    model.setAdapter(selectionadap(selectedint, 1));
                                    model.setVisibility(View.VISIBLE);
                                    model.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                        @Override
                                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                         //   Toast.makeText(getApplicationContext(),itemStorage(component,model,Integer.parseInt(freq.toString()))[2],Toast.LENGTH_LONG).show();
                                            if (!model.getSelectedItem().toString().trim().isEmpty()) {
                                                switch (component.getSelectedItem().toString().toLowerCase()){
                                                    case "cable":

                                                            if (!length.getText().toString().trim().isEmpty()){
                                                                try {
                                                                    Log.i("1","1");
                                                                    double loss = Double.parseDouble(itemStorage(component, model, Integer.parseInt(freq.toString()))[2]) * Double.parseDouble(length.getText().toString());
                                                                    Log.i("2","2");
                                                                    tv.setText("Loss = " + loss + " dB" + " and RL = " + itemStorage(component, model, Integer.parseInt(freq.toString().trim()))[3]);
                                                                    Log.i("3", "3");
                                                                    tv.setVisibility(View.VISIBLE);
                                                                } catch (NumberFormatException e){
                                                                    Toast.makeText(getApplicationContext(),"Exception Thrown " + e, Toast.LENGTH_SHORT).show();
                                                                    Log.i("NumberFormatException",e+"");

                                                                }
                                                            //Toast.makeText(getApplicationContext(),
                                                            //        le.freq(findViewById(R.id.frequencyinput)),
                                                            //        Toast.LENGTH_LONG).show();
                                                            }

                                                        break;
                                                    case "antenna": case "load":
                                                        tv.setText("RL = " + itemStorage(component,model,Integer.parseInt(freq.toString()))[2] + " dB");
                                                        tv.setVisibility(View.VISIBLE);
                                                        break;
                                                    default:
                                                        tv.setText("Loss = " + itemStorage(component,model,Integer.parseInt(freq.toString()))[2] + " dB" + " and RL = " + itemStorage(component,model,Integer.parseInt(freq.toString()))[3]);
                                                        tv.setVisibility(View.VISIBLE);
                                                        break;
                                                }

                                            } else {
                                                tv.setVisibility(View.GONE);
                                            }

                                        }

                                        @Override
                                        public void onNothingSelected(AdapterView<?> parent) {

                                        }
                                    });


                                } else {
                                    model.setVisibility(View.GONE);
                                }
                            }

                            @Override
                            public void onNothingSelected(AdapterView<?> parent) {

                            }
                        });

                    } else {
                        Toast.makeText(getApplicationContext(), "Please make selection", Toast.LENGTH_SHORT);
                        manufacturer.setVisibility(View.GONE);
                    }


                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });

            //while (!model.getSelectedItem().toString().trim().isEmpty()){
            //    countlines++;
            //}
        }



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
                break;
            case 1:working[0] = "No array found";
                break;
            case 2:
                working = cp.combinerRawValues(b);
                break;
            case 3:
                working = cp.biastRawValues(b);
                break;
            case 4:
                working = cp.cableRawValues(Integer.parseInt(freq.toString()),b);
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

 public String[] itemStorage( Spinner comp, Spinner model,Integer freq){
            int comppos = comp.getSelectedItemPosition();
     Log.i("component position", ""+comppos);
            int modelpos = model.getSelectedItemPosition();
     Log.i("component position", ""+comppos);
            String[] working = new String[10];

     switch (comppos+1) {
         default:working[0] = "No array found";
                 break;
         case 1:working[0] = "No array found";
             break;
         case 2:
             working = cp.combinerRowValues(modelpos);
             break;
         case 3:
             working = cp.biastRowValues(modelpos);
             break;
         case 4:
             working = cp.cableRowValues(freq, modelpos);
             break;
         case 5:
             working = cp.loadRowValues(modelpos);
             break;
         case 6:
             working = cp.antennaRawValues(modelpos);
             break;
     }
     return working;
    }

}

