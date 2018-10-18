package com.example.chewbs.alloheroproject.user;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.chewbs.alloheroproject.R;
import com.example.chewbs.alloheroproject.model.Association;
import com.example.chewbs.alloheroproject.presenter.AssociationListAdapter;
import com.example.chewbs.alloheroproject.view.AssociationView;

public class UserAssociationListActivity extends AppCompatActivity implements AssociationView, AssociationListAdapter.Listener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_association_list);
    }

    @Override
    public void onAskClick(Association association) {

    }
}
