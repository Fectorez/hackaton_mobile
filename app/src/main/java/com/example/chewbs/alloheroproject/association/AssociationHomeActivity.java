package com.example.chewbs.alloheroproject.association;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.chewbs.alloheroproject.R;
import com.example.chewbs.alloheroproject.model.Association;
import com.example.chewbs.alloheroproject.presenter.AssociationListAdapter;
import com.example.chewbs.alloheroproject.view.AssociationView;

public class AssociationHomeActivity extends AppCompatActivity implements AssociationView, AssociationListAdapter.Listener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_association_home);
    }


    @Override
    public void onAskClick(Association association) {

    }
}
