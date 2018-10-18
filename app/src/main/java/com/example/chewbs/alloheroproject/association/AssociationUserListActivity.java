package com.example.chewbs.alloheroproject.association;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.chewbs.alloheroproject.R;
import com.example.chewbs.alloheroproject.model.User;
import com.example.chewbs.alloheroproject.presenter.AssociationUserListAdapter;
import com.example.chewbs.alloheroproject.view.AssociationView;

public class AssociationUserListActivity extends AppCompatActivity implements AssociationView, AssociationUserListAdapter.Listener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_association_user_list);
    }

    @Override
    public void onHeroClick(User user) {

    }
}
