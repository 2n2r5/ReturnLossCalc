package com.ridgeequipment.returnlosscalc;

import android.support.v7.app.ActionBarActivity;

import java.util.Arrays;
import java.util.HashSet;

/**
 * Created by tim on 5/26/15.
 */
public class Components extends ActionBarActivity {

    CableTypes cableTypes = new CableTypes();

    public String[] getComponent() {


        String[] component = {
                "",
                "Combiner",
                "Bias T",
                "Cable",
                "Load",
                "Antenna"

        };

        return component;
    }


    //---- All models of antennas that are currently used----//


        String[][] antennas = {
                {"CSS", "SA13", "15.6"},
                {"Commscope", "HBXX-6516", "15.6"},
                {"Commscope", "HBXX-6516-IP", "14"}
        };

    //Arg Selects Array Column and outputs unique items only
    public String[] antennaValues(int a) {
        String[] out = new String[antennas.length];
        for (int i = 0; i < antennas.length; i++) {

            out[i] = antennas[i][a];
        }
        String[] unique = new HashSet<String>(Arrays.asList(out)).toArray(new String[0]);
        return unique;
    }

    // Arg selects column and outputs all items
    public String[] antennaRawValues(int a) {
        String[] out = new String[antennas.length];
        for (int i = 0; i < antennas.length; i++) {

            out[i] = antennas[i][a];
        }
        return out;
    }


    // -- Define Parameters for combiners -- //
        String[][] combiners = {
                {"Commscope", "Generic", "18"},
                {"CSS", "Generic", "20"},
            {"Kathrein", "Generic", "18"}};

    //Arg Selects Array Column and outputs unique items only
    public String[] combinerValues(int a) {
        String[] out = new String[combiners.length];
        for (int i = 0; i < combiners.length; i++) {
            out[i] = combiners[i][a];
        }
        String[] unique = new HashSet<String>(Arrays.asList(out)).toArray(new String[0]);
        return unique;
    }

    //Arg Selects Array Column and outputs all items
    public String[] combinerRawValues(int a) {
        String[] out = new String[combiners.length];
        for (int i = 0; i < combiners.length; i++) {
            out[i] = combiners[i][a];
        }
        return out;
    }
    // --- End Combiners Array Control --//


    //-- Define Parameters for loads --//
        String[][] loads = {
                {"Anritsu", "42"},
                {"Bird", "40"}
        };

    // Arg selects column selects column
    public String[] loadValues(int a) {
        String[] out = new String[loads.length];
        for (int i = 0; i < loads.length; i++) {
            out[i] = loads[i][a];
        }
        String[] unique = new HashSet<String>(Arrays.asList(out)).toArray(new String[0]);
        return unique;
    }

    // Arg selects column selects column
    public String[] loadRawValues(int a) {
        String[] out = new String[loads.length];
        for (int i = 0; i < loads.length; i++) {
            out[i] = loads[i][a];
        }
        return out;
    }


    //-- Define Parameters for Bias Ts --//
        String[][] biast = {
                {"Commscope","Generic",".1","22"},
                {"CSS","Generic",".15","20"}
        };

    // Arg selects column selects column
    public String[] biastValues(int a) {
        String[] out = new String[biast.length];
        for (int i = 0; i < biast.length; i++) {
            out[i] = biast[i][a];
        }
        String[] unique = new HashSet<String>(Arrays.asList(out)).toArray(new String[0]);
        return unique;
    }

    // Arg selects column selects column
    public String[] biastRawValues(int a) {
        String[] out = new String[biast.length];
        for (int i = 0; i < biast.length; i++) {
            out[i] = biast[i][a];
        }
        return out;
    }


    //-- Manage output from Cable Types --//
    CableTypes ct = new CableTypes();

    // Arg selects column selects column
    public String[] cableValues(int a, int b) {
        String[] out = new String[ct.cables(a).length];
        for (int i = 0; i < ct.cables(a).length; i++) {

            out[i] = ct.cables(a)[i][b];
        }
        String[] unique = new HashSet<String>(Arrays.asList(out)).toArray(new String[0]);
        return unique;
    }

    // Arg selects column selects column
    public String[] cableRawValues(int a, int b) {
        String[] out = new String[ct.cables(a).length];
        for (int i = 0; i < ct.cables(a).length; i++) {

            out[i] = ct.cables(a)[i][b];
        }
        return out;
    }



}