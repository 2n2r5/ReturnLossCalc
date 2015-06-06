package com.ridgeequipment.returnlosscalc;

import android.support.v7.app.ActionBarActivity;


/**
 *  * Created by tim on 5/25/15.
 *
 *  File Name: CableTypes.java
 *  Description: Contains an array with all cable types that users can choose from to make a a system
 *  Also contains, methods for figuring out lost at certain frequencies. This 4th degree polynomial
 *  was created from a trend line after plotting loss provided by manufacturers. The frequencies used
 *  were between 700 and 2200 MHz to maintain optimal accuracy in the frequency bands commonly used in
 *  Cellular macro testing.
 *
 *
 *
 */
public class CableTypes extends ActionBarActivity {




    //--------------------- Below is the Array of all available Cable Types ----------//
    public String[][] cables(int freq){






        //Format for entry {"Cable_Name",""+cablenameloss(freq),"Return Loss Spec"}
        String[][] cableproperties = {
                {"","","",""},
                {"Commscope", "LDF4", "" + ldf4loss(freq), "24.3"},
                {"Commscope", "FSJ4", "" + fsj4loss(freq), "20.8"},
                {"Commscope", "CR540", "" + cr540loss(freq), "26.4"},
                {"Commscope", "LDF5", "" + ldf5loss(freq), "24.3"},
                {"Commscope", "LDF6", "" + ldf6loss(freq), "24.3"},
                {"Commscope", "CR1070", "" + cr1070loss(freq), "26.4"},
                {"Commscope", "LDF7", "" + ldf7loss(freq), "24.3"},
                {"Commscope", "AVA7", "" + ava7loss(freq), "24.3"},
                {"Commscope", "AVA6", "" + ava6loss(freq), "24.3"},
                {"Commscope", "AVA5", "" + ava5loss(freq), "24.3"}
        };

    return cableproperties;


    }


//---- Begin Loss calculations based on frequency --------//

        //Calculate LDF4 loss/ft given frequency in MHz

    public double ldf4loss(int a) {
        if (a == 0) {
            return 0;
        } else {
            double out = Math.round((-0.0000001276 * Math.pow(a, 2) + 0.001429 * Math.pow(a, 1) + 0.91) * 100);
            return out / 10000;
        }
    }

    //Calculate LDF7 loss/ft given frequency in MHz
    public double ldf7loss(int a) {
        if (a == 0) {
            return 0;
        } else {
            double out = Math.round((-.00000004699 * Math.pow(a, 2) + .000532 * Math.pow(a, 1) + 0.255) * 100);
            return out / 10000;
        }
    }

    //Calculate FSJ4 loss/ft given frequency in MHz
    public double fsj4loss(int a) {
        if (a == 0) {
            return 0;
        } else {
            double out = Math.round((-.0000002437 * Math.pow(a, 2) + .002511 * Math.pow(a, 1) + 1.327) * 100);
            return out / 10000;
        }
    }

    //Calculate CR 540 loss/ft given frequency in MHz
    public double cr540loss(int a) {
        if (a == 0) {
            return 0;
        } else {
            double out = Math.round((-0.0000004859 * Math.pow(a, 2) + 0.004835 * Math.pow(a, 1) + 2.587) * 100);
            return out / 10000;
        }
    }

    //Calculate LDF5 loss/ft given frequency in MHz
    public double ldf5loss(int a) {
        if (a == 0) {
            return 0;
        } else {
            double out = Math.round((-0.00000008563 * Math.pow(a, 2) + 0.0008703 * Math.pow(a, 1) + 0.467) * 100);
            return out / 10000;
        }
    }

    //Calculate LDF6 loss/ft given frequency in MHz
    public double ldf6loss(int a) {
        if (a == 0) {
            return 0;
        } else {
            double out = Math.round((-0.00000005668 * Math.pow(a, 2) + 0.0006039 * Math.pow(a, 1) + 0.305) * 100);
            return out / 10000;
        }
    }

    //Calculate CR 1070 loss/ft given frequency in MHz
    public double cr1070loss(int a) {
        if (a == 0) {
            return 0;
        } else {
            double out = Math.round((-0.0000002525 * Math.pow(a, 2) + 0.002615 * Math.pow(a, 1) + 1.286) * 100);
            return out / 10000;
        }
    }

    //Calculate AVA7 loss/ft given frequency in MHz
    public double ava7loss(int a) {
        if (a == 0) {
            return 0;
        } else {
            double out = Math.round((-0.00000004602 * Math.pow(a, 2) + 0.0004789 * Math.pow(a, 1) + 0.251) * 100);
            return out / 10000;
        }
    }

    //Calculate AVA5 loss/ft given frequency in MHz
    public double ava5loss(int a) {
        if (a == 0) {
            return 0;
        } else {
            double out = Math.round((-0.00000008491 * Math.pow(a, 2) + 0.0008209 * Math.pow(a, 1) + 0.458) * 100);
            return out / 10000;
        }
    }

    //Calculate AVA6 loss/ft given frequency in MHz
    public double ava6loss(int a) {
        if (a == 0) {
            return 0;
        } else {
            double out = Math.round((-0.00000005924 * Math.pow(a, 2) + 0.0005994 * Math.pow(a, 1) + 0.323) * 100);
            return out / 10000;
        }
    }


}




