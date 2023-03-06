package com.example.uberfareapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        TextView txtMilesAmtDesc = (TextView) findViewById(R.id.txtMilesAmtDesc);
        TextView txtAutoPrefDesc = (TextView) findViewById(R.id.txtAutoPrefDesc);
        ImageView imageCar = (ImageView) findViewById(R.id.imgCar2);
        imageCar.getLayoutParams().height = 500;
        Button btnRequestRide = (Button) findViewById(R.id.btnRequestRide);
        Button btnBack = (Button) findViewById(R.id.btnBack);

        SharedPreferences milesAmt = getSharedPreferences("milesAmt", MODE_PRIVATE);
        int miles = milesAmt.getInt("miles", 1);
        txtMilesAmtDesc.setText("You will be travelling " + miles + " miles.");
        SharedPreferences autoSelect = getSharedPreferences("autoSelect", MODE_PRIVATE);
        int autoPrefAmt = autoSelect.getInt("add", 1);
        double total = (3.25 * miles) + 3.00 + autoPrefAmt;
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        String vehicle;
        if (autoPrefAmt == 2)
        {
            vehicle = "smart car";
            imageCar.setImageResource(R.drawable.smartcar);
        }
        else if (autoPrefAmt == 0)
        {
            vehicle = "classic sedan";
            imageCar.setImageResource(R.drawable.classicsedan);
        }
        else
        {
            vehicle = "minivan";
            imageCar.setImageResource(R.drawable.minivan);
        }


        txtAutoPrefDesc.setText("You chose to ride in a " + vehicle+ " and your ride will cost you $" + decimalFormat.format(total) + ".");
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity2.this, MainActivity.class));
            }
        });
        btnRequestRide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity2.this, MainActivity3.class));
            }
        });
    }
}