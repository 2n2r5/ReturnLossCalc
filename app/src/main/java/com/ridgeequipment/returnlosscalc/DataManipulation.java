package com.ridgeequipment.returnlosscalc;

/**
 * Created by tim on 6/9/15.
 */
public class DataManipulation {

    //Array for holding all results

    String[][] results = new String[20][3];

    public String[] resultsoneline(int a, double loss , double rl){
        results[a][0] = ""+loss;
        results[a][1] = ""+rl;
        return results[a];
    }

    public String[] resultsoneline(int a, double rl){
        results[a][0] = "0";
        results[a][1] = ""+rl;
        return results[a];
    }

    public String[][] resultsRecall(){
        return results;
    }

    String[] hold = new String[3];

    public String[] hold(){
        return hold;
    }


}
