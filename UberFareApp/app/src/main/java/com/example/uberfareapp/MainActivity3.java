package com.example.uberfareapp;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity3 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        ImageView imageView = (ImageView) findViewById(R.id.imgDriver);
        imageView.getLayoutParams().height = 500;
        ImageView imageCar = (ImageView) findViewById(R.id.imgCar3);
        imageCar.getLayoutParams().height = 500;
        TextView txtDriver = (TextView) findViewById(R.id.txtDriver);
        Random rand = new Random();
        int time = rand.nextInt(100);
        SharedPreferences autoSelect = getSharedPreferences("autoSelect", MODE_PRIVATE);
        int autoPrefAmt = autoSelect.getInt("add", 1);
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
        txtDriver.setText("Your driver Morgan Freeman will be arriving in a " + vehicle + " in " + time + " minutes!");
    }
}
