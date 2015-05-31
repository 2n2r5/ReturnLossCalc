package com.ridgeequipment.returnlosscalc;

import android.app.Activity;
import android.view.Gravity;
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
        lp.gravity = Gravity.CENTER_HORIZONTAL;
        lp.leftMargin = 0;
        lp.rightMargin = 0;
        lp.topMargin = 5;
        lp.bottomMargin = 5;




        return lp;
    }

}