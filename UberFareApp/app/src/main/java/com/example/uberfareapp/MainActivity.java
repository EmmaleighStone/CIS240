package com.example.uberfareapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.Map;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnCalc = (Button) findViewById(R.id.btnEstimateCost);
        EditText txtMilesAmt = (EditText) findViewById(R.id.txtEditMilesAmtMain);
        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radioGroup);

        btnCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences autoSelect = getSharedPreferences("autoSelect", MODE_PRIVATE);
                SharedPreferences.Editor autoEditor = autoSelect.edit();
                SharedPreferences milesAmt = getSharedPreferences("milesAmt", MODE_PRIVATE);
                SharedPreferences.Editor milesEditor = milesAmt.edit();
                int intMilesAmt = Integer.parseInt(txtMilesAmt.getText().toString());
                milesEditor.putInt("miles", intMilesAmt);
                milesEditor.apply();
                int selectedId = radioGroup.getCheckedRadioButtonId();
                RadioButton selectedRadio = (RadioButton) findViewById(selectedId);

                if (selectedRadio == findViewById(R.id.radioSmartCar)) {
                    autoEditor.putInt("add", 2);
                    autoEditor.apply();
                } else if (selectedRadio == findViewById(R.id.radioClassicSedan)) {
                    autoEditor.putInt("add", 0);
                    autoEditor.apply();
                } else {
                    autoEditor.putInt("add", 5);
                    autoEditor.apply();
                }


                startActivity(new Intent(MainActivity.this, MainActivity2.class));
            }
        });
    }
}