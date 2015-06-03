package com.ridgeequipment.returnlosscalc;

import android.support.v7.app.ActionBarActivity;

/**
 * Created by tim on 5/25/15.
 */
public class CustomMethods extends ActionBarActivity {



    /*------------------------- Custom Functions --------------------*/


      /*
    *This starts the section where we add out custom conversions
    * Conversions list includes:
    * swrtorl(a)
    * rltorc(a)
    * dBmtomW(a)
    * mWtodBm(a)
    * swrtorc(a)
    * rlfrompw(a) return loss give measured output power assuming 1 for input
    * dlnext(power_in,attenuation,return_loss) Gives through power after component
    * ulreflect(power_in,local_attenuation,return_loss,aggregate_attenuation) computes a points reflected power as seen from source
    *
     */

    //Converts swr to rl
    public double swrtorl(double a) {
        return -20 * Math.log10((a - 1) / (a + 1));
    }

    //Converts RL to Reflection Coefficient
    public double rltorc(double a){
        return 10*Math.pow(10, (-a / 20));
    }

    // Converts dBm to mW
    public double dBmtomW(double dBm){
        return Math.pow(10,(dBm/10) );
    }

    //Converts mW to dBm
    public double mWtodBm(double pw){
        return 10 * Math.log10(pw);
    }

    //Converts vswr to Reflection Coefficient
    public double swrtorc(double a){
        return ((a-1)/(a+1));
    }

    // Return Loss give start and end power
    public double rlfrompw(double a){
        return -20 * Math.log10(a);
    }

    //takes power in, attenuatoion and RL to give power out
    public double dlnext(double a, double b, double c){
        return  dBmtomW(mWtodBm(a)-b) * (1-rltorc(c));
    }

    //Gives reflected power that will make it back to origin from this point
    //a = power in , b = local attenuation, c = returnloss, d = aggregate attenuation
    public double ulreflect(double a, double b, double c, double d){
        return  dBmtomW(mWtodBm(dBmtomW(mWtodBm(a)-b) * rltorc(c))-d);
    }

    public String[][] picker(String searchTerm, String[][] arrayName,int rowNumber){
        int b = 0;
        String[][] output = new String[99][5];
        for (int i=0;i<arrayName.length;i++){
            if (arrayName[i][rowNumber].contains(searchTerm)){
               output[b] = arrayName[i];
                b++;
            }
        }

        return output;
    }



}
