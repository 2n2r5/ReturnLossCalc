package com.ridgeequipment.returnlosscalc;

import android.app.Activity;
import android.graphics.Color;
import android.text.InputFilter;
import android.text.InputType;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;

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


    public EditText length(int a) {
        //Cable Length Edittext

        EditText name = new EditText(getApplicationContext());
        name.setId(R.id.length+a);
        name.setLayoutParams(spinnerLayout());
        name.setInputType(InputType.TYPE_CLASS_NUMBER);
        name.setTextColor(Color.BLACK);
        name.setBackgroundColor(Color.parseColor("#ffeaeaea"));
        name.setFilters(new InputFilter[]{new InputFilter.LengthFilter(3)});
        name.setTextSize(10);
        name.setGravity(Gravity.TOP);
        name.setHint("0000");
        name.setVisibility(View.GONE);

        return name;

    }



}