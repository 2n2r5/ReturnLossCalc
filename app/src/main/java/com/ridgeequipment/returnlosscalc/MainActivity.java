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
    final   LayoutElements le = new LayoutElements();
    Integer freq = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        LinearLayout parent = (LinearLayout) findViewById(R.id.parentlayout);
        parent.setBackgroundColor(Color.WHITE);

        LinearLayout body = new LinearLayout(this);
        body.setOrientation(LinearLayout.HORIZONTAL);
        parent.addView(body, le.bodyLayout());


        // Setup Layout
        //Test Spinner

      final  Spinner test = new Spinner(getApplicationContext());
        test.setBackgroundColor(Color.parseColor("#ffeaeaea"));
        test.setVisibility(View.VISIBLE);
        test.setAdapter(compadapter());
        body.addView(test, le.spinnerLayout());


        //Manufacturer Spinner
      final Spinner manu = new Spinner(getApplicationContext());
        manu.setBackgroundColor(Color.parseColor("#ffeaeaea"));
        manu.setGravity(Gravity.TOP);
        manu.setVisibility(View.GONE);
        body.addView(manu, le.spinnerLayout());
        try {
            final String manuSelected = manu.getSelectedItem().toString().trim();
        } catch (NullPointerException e){

        }


        //Model Number Spinner
        final Spinner model = new Spinner(getApplicationContext());
        model.setBackgroundColor(Color.parseColor("#ffeaeaea"));
        model.setGravity(Gravity.TOP);
        model.setVisibility(View.GONE);
        body.addView(model, le.spinnerLayout());


        //Cable Length Edittext
        final EditText length = new EditText(getApplicationContext());
        length.setInputType(InputType.TYPE_CLASS_NUMBER);
        Integer lengthint = 0;
        if (!length.getText().toString().trim().isEmpty()){
            lengthint = Integer.parseInt(length.getText().toString().trim());
        }
        length.setVisibility(View.GONE);
        body.addView(length);

        final int selectionholder = 0;

        try {
            final String modelSelected = model.getSelectedItem().toString().trim();
        }catch (NullPointerException e){

        }

        freq();

        //Component Item Listener - Creates Manufacturer Spinner
        test.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if (position>0){

                    manu.setVisibility(View.VISIBLE);


                    //Manufacturer Item Listener - Creates Model Number Spinner
                    manu.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            if (position>0){
                                model.setVisibility(View.VISIBLE);

                                model.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                    @Override
                                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                                        if (test.getSelectedItem().toString().contains("Cable")) {
                                            length.setVisibility(View.VISIBLE);

                                        } else {

                                            length.setVisibility(View.GONE);
                                        }

                                    }

                                        @Override
                                        public void onNothingSelected (AdapterView < ? > parent){

                                        }

                                });


                        } else {

                            model.setVisibility(View.GONE);
                        }
                        model.setAdapter(itemadapter(selectionPosition(compselected(test)), 1));
                        }



                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {

                        }
                    });

                } else {
                    manu.setVisibility(View.GONE);
                    model.setVisibility(View.GONE);
                }
                manu.setAdapter(itemadapter(position, 0));

            Toast.makeText(getApplicationContext(),
                    "Component Selected is "+ selectionPosition(compselected(test)) +
                            " which is "+test.getSelectedItem().toString(),
                    Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }

        });







    }



    //Creates Custom Array Adapter for Component Sprinner
    public ArrayAdapter<String> compadapter() {

        Components cp = new Components();
        ArrayAdapter<String> aad = new ArrayAdapter<>(
                this,
                R.layout.spinner_item,R.id.spintv,
                cp.getComponent()
        );

        return aad;
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
                 working = cp.cableRawValues(freq(),b);
                break;
            case 5:
                working = cp.loadRawValues(b);
                break;
            case 6:
                working = cp.antennaRawValues(b);
                break;
        }



        Components cp = new Components();
        ArrayAdapter<String> aad = new ArrayAdapter<>(
                this,
                R.layout.spinner_item,R.id.spintv,
                working
        );

        return aad;
    }

    public Integer freq(){
        //frequency input


        EditText freqet = (EditText) findViewById(R.id.etid);


        freqet.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!s.toString().isEmpty()) {
                    freq = Integer.parseInt(s.toString());
                } else {
                    freq = 0;
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

                Toast.makeText(getApplicationContext(),"Frequency entered is " + freq,Toast.LENGTH_SHORT).show();
            }
        });

        return freq;
    }

    public String compselected(Spinner spinnername){
        if (spinnername.getSelectedItem().toString().isEmpty()){
            return "empty";
        }
        return spinnername.getSelectedItem().toString();
    }

    public int selectionPosition(String firstSpinnerSelection){
        int ret = 0;
        String test = firstSpinnerSelection.toLowerCase().trim();
        if (firstSpinnerSelection.trim().isEmpty()) {
            return 0;
        }

        if (test.contains("combiner")){
            ret = 1;
        }else if (test.contains("bias t")){
            ret = 2;
        }else if (test.contains("cable")){
            ret = 3;

        }else if (test.contains("load")){
            ret = 4;
        }else if (test.contains("antenna")){
            ret = 5;
        }
            return ret;

    }

}

