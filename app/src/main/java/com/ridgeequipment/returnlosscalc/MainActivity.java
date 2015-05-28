package com.ridgeequipment.returnlosscalc;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.ridgeequipment.returnlosscalc.CableTypes;

public class MainActivity extends ActionBarActivity {

    //import methods from other classes
 //   CustomMethods mymethods = new CustomMethods();
 //   CableTypes ct = new CableTypes();
   Components cp = new Components();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        TextView test = (TextView) findViewById(R.id.test);
        test.setText(cp.getCombinerManu(0));

        Toast.makeText(getApplicationContext(), cp.getCombinerManu(1),Toast.LENGTH_LONG).show();


    }

}