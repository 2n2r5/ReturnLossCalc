package com.ridgeequipment.returnlosscalc;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.Spinner;

public class MainActivity extends Activity {





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //import methods from other classes
        CustomMethods mymethods = new CustomMethods();
        CableTypes ct = new CableTypes();
        Components cp = new Components();
        LayoutElements le = new LayoutElements();


        LinearLayout parent = (LinearLayout) findViewById(R.id.parentlayout);
        parent.setBackgroundColor(Color.WHITE);

        LinearLayout body = new LinearLayout(this);
        body.setOrientation(LinearLayout.HORIZONTAL);
        parent.addView(body, le.bodyLayout());


        // Setup Layout
        //Test Spinner

        Spinner test = new Spinner(getApplicationContext());
        test.setAdapter(le.compadapter());
        body.addView(test, le.bodyLayout());







    }


}

