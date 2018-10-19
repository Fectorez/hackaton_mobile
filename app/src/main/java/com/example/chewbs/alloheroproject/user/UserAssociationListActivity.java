package com.example.chewbs.alloheroproject.user;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import com.example.chewbs.alloheroproject.R;
import com.example.chewbs.alloheroproject.model.Association;
import com.example.chewbs.alloheroproject.presenter.AssociationListAdapter;
import com.example.chewbs.alloheroproject.view.AssociationView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class UserAssociationListActivity extends AppCompatActivity implements AssociationView, AssociationListAdapter.Listener {

    private List<Association> list_associations = new ArrayList<>();

    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @BindView(R.id.recyclerview_associations) RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_association_list);
    }

    @Override
    public void onAskClick(Association association) {

    }
}
