package com.example.chewbs.alloheroproject.user;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.chewbs.alloheroproject.R;

import butterknife.ButterKnife;

public class UserProfileActivity extends AppCompatActivity {

    //@BindView(R.id.recyclerview_associations)
    //RecyclerView associations_recycler_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        ButterKnife.bind(this);
    }


}
