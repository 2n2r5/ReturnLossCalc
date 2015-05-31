package com.ridgeequipment.returnlosscalc;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends Activity {



    //import methods from other classes
    CustomMethods mymethods = new CustomMethods();
    CableTypes ct = new CableTypes();
    Components cp = new Components();
    final   LayoutElements le = new LayoutElements();



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
        test.setAdapter(compadapter());
        body.addView(test, le.spinnerLayout());

        //Manufacturer Spinner
      final Spinner manu = new Spinner(getApplicationContext());
        manu.setBackgroundColor(Color.parseColor("#ffeaeaea"));
        test.setVisibility(View.VISIBLE);
        manu.setGravity(Gravity.TOP);
        manu.setVisibility(View.GONE);
        body.addView(manu,le.spinnerLayout());



        test.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position>0){
                    manu.setVisibility(View.VISIBLE);
                } else {
                    manu.setVisibility(View.GONE);
                }
                manu.setAdapter(manuadapter(position));


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
    public ArrayAdapter<String> manuadapter(int a) {

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
                working = cp.combinerRawValues(0);
                break;
            case 3:
                working = cp.biastRawValues(0);
                break;
            case 4:
                 working = cp.cableRawValues(1900,0);
                break;
            case 5:
                working = cp.loadRawValues(0);
                break;
            case 6:
                working = cp.antennaRawValues(0);
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

}

