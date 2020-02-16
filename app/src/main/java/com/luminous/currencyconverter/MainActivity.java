package com.luminous.currencyconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
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
        spinnerOne =  findViewById(R.id.spinnerOne);
        spinnerTwo =  findViewById(R.id.spinnerTwo);
        editTextOne = findViewById(R.id.editTextOne);
        editTextTwo = findViewById(R.id.editTextTwo);

        
    }
}
