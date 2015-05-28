package com.ridgeequipment.returnlosscalc;

import android.support.v7.app.ActionBarActivity;

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
    public String[][] getAntennas() {

        String[][] antennas = {
                {"CSS", "SA13", "15.6"},
                {"Commscope", "HBXX-6516", "15.6"},
                {"Commscope", "HBXX-6516-IP", "14"}

        };

        return antennas;
    }


    // -- Define Parameters for combiners -- //
    public String[][] getCombiners() {

        String[][] combiners = {
                {"Commscope", "Generic", "18"},
                {"CSS", "Generic", "20"},
                {"Kathrein", "Generic", "18"}

        };
        return combiners;
    }

    public String getCombinerManu(int a) {

        String list= getCombiners()[a][0];

    return list;
    }

    //-- Define Parameters for loads --//

    public String[][] getLoads() {

        String[][] loads = {
                {"Anritsu", "42"},
                {"Bird", "40"}

        };

        return loads;

    }

    //-- Define Parameters for Bias Ts --//

    public String[][] getBiasT(){

        String[][] biast = {
                {"Commscope","Generic",".1","22"},
                {"CSS","Generic",".15","20"}

        };
        return biast;
    }


}