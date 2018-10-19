package com.example.chewbs.alloheroproject.user;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.chewbs.alloheroproject.R;
import com.example.chewbs.alloheroproject.model.Association;
import com.example.chewbs.alloheroproject.presenter.AssociationListAdapter;
import com.example.chewbs.alloheroproject.presenter.AssociationPresenter;
import com.example.chewbs.alloheroproject.view.AssociationKeywordView;
import com.example.chewbs.alloheroproject.view.AssociationNameView;
import com.example.chewbs.alloheroproject.view.AssociationView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class UserAssociationListActivity extends AppCompatActivity implements AssociationNameView, AssociationKeywordView, AssociationListAdapter.Listener {

    @BindView(R.id.recyclerview_associations) RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_association_list);

        ButterKnife.bind(this);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Intent intent = getIntent();
        String name = intent.getStringExtra("association_name");
        String keyword = intent.getStringExtra("association_keyword");

        if(!name.equals("")) {
            AssociationPresenter presenter = new AssociationPresenter((AssociationNameView) this);
            presenter.findAssociationByName(this, name);
        }
        else {
            AssociationPresenter presenter = new AssociationPresenter((AssociationKeywordView) this);
            presenter.findAssociationByKeyWord(this, keyword);
        }
    }

    @Override
    public void findAssociationByKeyword(List<Association> list_associations) {
        Log.e("LIST ASSSOCIATION",list_associations.toString());
        AssociationListAdapter associationListAdapter = new AssociationListAdapter(list_associations);
        associationListAdapter.setListener(this);
        recyclerView.setAdapter(associationListAdapter);
    }

    @Override
    public void findAssociationByName(List<Association> list_associations) {
        Log.e("LISTES",list_associations.toString());
        AssociationListAdapter associationListAdapter = new AssociationListAdapter(list_associations);
        associationListAdapter.setListener(this);
        recyclerView.setAdapter(associationListAdapter);
    }

    @Override
    public void onDemandClick(Association association) {

    }
}
