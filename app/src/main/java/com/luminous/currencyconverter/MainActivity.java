package com.luminous.currencyconverter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    /// Declaring UI variables
    Spinner spinnerOne;
    Spinner spinnerTwo;
    EditText editTextOne;
    EditText editTextTwo;
    ArrayAdapter<CharSequence> currencyList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /// Initializing UI variables
        spinnerOne = (Spinner) findViewById(R.id.spinnerOne);
        spinnerOne.setOnItemSelectedListener(this);
        spinnerTwo = (Spinner) findViewById(R.id.spinnerTwo);
        spinnerTwo.setOnItemSelectedListener(this);
        editTextOne = (EditText) findViewById(R.id.editTextOne);
        editTextTwo = (EditText) findViewById(R.id.editTextTwo);
        /*
        ArrayAdapter<String> currencyList = new ArrayAdapter<String>(MainActivity.this,
                android.R.layout.simple_list_item_1,
                getResources().getStringArray(R.array.currencyArray));

        currencyList.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

         */

        currencyList = ArrayAdapter.createFromResource(this, R.array.currencyArray, android.R.layout.simple_spinner_item);
        currencyList.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinnerOne.setAdapter(currencyList);
        spinnerTwo.setAdapter(currencyList);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        switch (parent.getId()) {
            case R.id.spinnerOne:
                editTextOne.setHint(spinnerOne.getSelectedItem().toString());
                break;

            case R.id.spinnerTwo:
                editTextTwo.setHint(spinnerTwo.getSelectedItem().toString());
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        return;
    }
}
