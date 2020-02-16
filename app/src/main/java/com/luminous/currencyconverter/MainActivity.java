package com.luminous.currencyconverter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
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

        //editTextOne watcher
        editTextOne.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

                double moneyVal;

                try {
                    moneyVal = Double.parseDouble(s.toString());
                }


                switch (spinnerOne.getSelectedItem().toString()) {
                    case "USD - USA":

                        switch (spinnerTwo.getSelectedItem().toString()) {

                            case "Euro - Europe":
                                moneyVal = (moneyVal * 0.92);

                                editTextTwo.setText(String.valueOf(moneyVal));
                                break;

                            case "Taka - Bangladesh":
                                moneyVal = Double.parseDouble(s.toString());
                                moneyVal = (moneyVal * 84.59);

                                editTextTwo.setText(String.valueOf(moneyVal));
                                break;

                            default:
                                editTextTwo.setText(s);
                                break;
                        }
                        break;
                    case "Euro - Europe":
                        switch (spinnerTwo.getSelectedItem().toString()) {
                            case "USD - USA":
                                moneyVal = (moneyVal * 1.08);

                                editTextTwo.setText(String.valueOf(moneyVal));
                                break;

                            case "Taka - Bangladesh":
                                moneyVal = (moneyVal * 91.95);

                                editTextTwo.setText(String.valueOf(moneyVal));
                                break;

                            default:
                                editTextTwo.setText(s);
                                break;
                        }
                        break;

                    case "Taka - Bangladesh":
                        switch (spinnerTwo.getSelectedItem().toString()) {
                            case "USD - USA":
                                moneyVal = (moneyVal * 0.012);

                                editTextTwo.setText(String.valueOf(moneyVal));
                                break;

                            case "Euro - Europe":
                                moneyVal = (moneyVal * 0.011);

                                editTextTwo.setText(String.valueOf(moneyVal));
                                break;

                            default:
                                editTextTwo.setText(s);
                                break;
                        }
                        break;
                }
            }
        });


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

    }
}
