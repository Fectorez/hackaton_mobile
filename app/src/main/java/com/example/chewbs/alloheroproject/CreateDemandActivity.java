package com.example.chewbs.alloheroproject;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import com.example.chewbs.alloheroproject.model.Association;
import com.example.chewbs.alloheroproject.model.Demand;
import com.example.chewbs.alloheroproject.presenter.DemandPresenter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CreateDemandActivity extends AppCompatActivity {
    EditText title_et;
    EditText description_et;
    EditText street_et;
    EditText postal_et;
    EditText date_et;
    EditText heure_et;
    Button dem_ok_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_demand);


        title_et = findViewById(R.id.dem_title);
        description_et = findViewById(R.id.dem_description);
        street_et= findViewById(R.id.dem_street);;
        postal_et= findViewById(R.id.dem_postal);
        street_et = findViewById(R.id.dem_street);
        date_et = findViewById(R.id.dem_date);
        heure_et = findViewById(R.id.dem_time);



        dem_ok_btn = findViewById(R.id.dem_button_ok);

        dem_ok_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ajouterDemande();
            }

            private void ajouterDemande() {
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YY");

                Demand demand = new Demand();
                demand.setTitle(title_et.getText().toString());
                demand.setPostal(postal_et.getText().toString());
                demand.setAdress(street_et.getText().toString());
                demand.setDescription(description_et.toString());
                demand.setCreationDate(new Date());
                try {
                    demand.setDemandDate(sdf.parse(date_et.getText().toString()));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                demand.setAssociation(new Association());


            }
        });


    }

}
