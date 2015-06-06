package com.ridgeequipment.returnlosscalc;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.text.InputFilter;
import android.text.InputType;
import android.view.Gravity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;

/**
 * Created by tim on 5/28/15.
 */


public class LayoutElements extends Activity {

    Components cp = new Components();


    //Array for Keeping selected variables

    String[][] ks = {new String[0]};


    public LinearLayout.LayoutParams bodyLayout() {
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        lp.gravity = Gravity.LEFT;
        lp.gravity = Gravity.CENTER_VERTICAL;
        lp.leftMargin = 0;
        lp.rightMargin = 0;
        lp.topMargin = 5;
        lp.bottomMargin = 5;
        return lp;
    }

    public LinearLayout.LayoutParams spinnerLayout() {
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        lp.gravity = Gravity.TOP;
        lp.leftMargin = 0;
        lp.rightMargin = 0;
        lp.topMargin = 0;
        lp.bottomMargin = 0;


        return lp;
    }


    public LinearLayout parent() {

        LinearLayout parent = (LinearLayout) findViewById(R.id.parentlayout);
        parent.setBackgroundColor(Color.WHITE);
        return parent;
    }

    public LinearLayout listitem(Context context, int a) {


        LinearLayout body = new LinearLayout(context);
        body.setLayoutParams(bodyLayout());
        body.setId(R.id.listitem + a);
        body.setOrientation(LinearLayout.HORIZONTAL);

        return body;
    }

    public Spinner manu(Context context, int a, ArrayAdapter adapter) {
        //Manufacturer Spinner
        Spinner manu = new Spinner(context);
        manu.setBackgroundColor(Color.parseColor("#ffeaeaea"));
        manu.setGravity(Gravity.TOP);
        manu.setVisibility(View.GONE);
        manu.setAdapter(adapter);


        return manu;
    }

    public Spinner comp(Context context, int a) {
        //comp Spinner

        Spinner comp = new Spinner(context);
        comp.setBackgroundColor(Color.parseColor("#ffeaeaea"));
        comp.setVisibility(View.VISIBLE);

        return comp;
    }


    public Spinner model(Context context, int a , ArrayAdapter adapter) {
        //Model Number Spinner
        Spinner model = new Spinner(context);
        model.setId(R.id.model + a);
        model.setBackgroundColor(Color.parseColor("#ffeaeaea"));
        model.setGravity(Gravity.TOP);
        model.setVisibility(View.GONE);
        model.setAdapter(adapter);

        return model;
    }


    //Creates Edit Text For Cable Length
    public EditText length(Context context, int a) {
        //Cable Length Edittext
        EditText input = new EditText(context);
        input.setId(R.id.length + a);
        input.setLayoutParams(spinnerLayout());
        input.setInputType(InputType.TYPE_CLASS_NUMBER);
        input.setTextColor(Color.BLACK);
        input.setBackgroundColor(Color.parseColor("#ffeaeaea"));
        input.setFilters(new InputFilter[]{new InputFilter.LengthFilter(3)});
        input.setTextSize(10);
        input.setGravity(Gravity.TOP);
        input.setTextSize(10);
        input.setHint("0000");
        input.setVisibility(View.GONE);

        return input;

    }


    public Integer freq(View view) {
        //frequency input

        EditText freqet = (EditText) view;

        if (!freqet.getText().toString().isEmpty()) {
            return Integer.parseInt(freqet.getText().toString());
        } else {
            return 0;
        }

    }


}