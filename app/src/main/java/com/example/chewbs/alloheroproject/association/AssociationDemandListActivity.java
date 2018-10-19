package com.example.chewbs.alloheroproject.association;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import com.example.chewbs.alloheroproject.R;
import com.example.chewbs.alloheroproject.model.Association;
import com.example.chewbs.alloheroproject.model.Demand;
import com.example.chewbs.alloheroproject.presenter.AssociationListAdapter;
import com.example.chewbs.alloheroproject.view.AssociationView;
import com.example.chewbs.alloheroproject.view.DemandView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AssociationDemandListActivity extends AppCompatActivity implements DemandView, AssociationListAdapter.Listener {

    private List<Association> list_associations = new ArrayList<>();

    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @BindView(R.id.recyclerview_home_association) RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_association_demands);

        ButterKnife.bind(this);

    }

    @Override
    public void findAllDemands(List<Demand> list_demand) {
        AssociationListAdapter associationListAdapter = new AssociationListAdapter(list_associations);
        associationListAdapter.setListener(this);
        recyclerView.setAdapter(associationListAdapter);
    }

    @Override
    public void onDemandClick(Association association) {

    }
}
