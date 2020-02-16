package com.luminous.currencyconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {
    /// Declaring UI variables
    Spinner spinnerOne;
    Spinner spinnerTwo;
    EditText editTextOne;
    EditText editTextTwo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /// Initializing UI variables
        spinnerOne = (Spinner) findViewById(R.id.spinnerOne);
        spinnerTwo = (Spinner) findViewById(R.id.spinnerTwo);
        editTextOne = (EditText) findViewById(R.id.editTextOne);
        editTextTwo = (EditText) findViewById(R.id.editTextTwo);
        /*
        ArrayAdapter<String> currencyList = new ArrayAdapter<String>(MainActivity.this,
                android.R.layout.simple_list_item_1,
                getResources().getStringArray(R.array.currencyArray));

        currencyList.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

         */

        ArrayAdapter<CharSequence> currencyList = ArrayAdapter.createFromResource(this, R.array.currencyArray, android.R.layout.simple_spinner_item);

        currencyList.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinnerOne.setAdapter(currencyList);
        spinnerTwo.setAdapter(currencyList);
    }

}
