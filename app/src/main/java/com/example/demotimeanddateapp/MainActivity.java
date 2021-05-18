package com.example.demotimeanddateapp;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;


public class MainActivity extends AppCompatActivity {

    DatePicker dp;
    TimePicker tp;
    Button btnDisplayDate;
    Button btnDisplayTime;
    TextView tvDisplay;
    Button btnReset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dp = findViewById(R.id.datePicker);
        tp = findViewById(R.id.timePicker);
        btnDisplayDate = findViewById(R.id.buttonDisplayDate);
        btnDisplayTime = findViewById(R.id.buttonDisplayTime);
        tvDisplay = findViewById(R.id.textViewDisplay);
        btnReset = findViewById(R.id.buttonReset);

        btnDisplayTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = "Time is: ";
                int hr = tp.getCurrentHour();
                int min = tp.getCurrentMinute();
                message = message + hr + min;
                tvDisplay.setText(message);

            }
        });

        btnDisplayDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = "Date is: ";
                int day = dp.getDayOfMonth();
                int mth = dp.getMonth() + 1;
                int yr = dp.getYear();
                message = message + day + "/" + mth + "/" + yr;
                tvDisplay.setText(message);

            }
        });

        btnReset.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View view) {
                TimePicker tp=(TimePicker)findViewById(R.id.timePicker);
                tp.setHour(0);
                tp.setMinute(00);

                DatePicker dp=(DatePicker)findViewById(R.id.datePicker);
                dp.updateDate(2020, 0, 1);
            }
        });






    }






}