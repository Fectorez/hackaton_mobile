package com.example.chewbs.alloheroproject;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

public class CreateDemandActivity extends AppCompatActivity {
    EditText title_et;
    EditText description_et;
    EditText street_et;
    EditText postal_et;
    DatePicker date_dp;
    TimePicker heure_tp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_demand);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        title_et = findViewById(R.id.dem_title);
        description_et = findViewById(R.id.dem_description);
        street_et= findViewById(R.id.dem_street);;
        postal_et= findViewById(R.id.dem_postal);


    }

}
