package com.example.chewbs.alloheroproject.association;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.chewbs.alloheroproject.R;
import com.example.chewbs.alloheroproject.model.Association;
import com.example.chewbs.alloheroproject.model.User;
import com.example.chewbs.alloheroproject.presenter.AssociationUserListAdapter;
import com.example.chewbs.alloheroproject.presenter.UserPresenter;
import com.example.chewbs.alloheroproject.view.AssociationView;
import com.example.chewbs.alloheroproject.view.UserListView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AssociationUserListActivity extends AppCompatActivity implements AssociationView, UserListView, AssociationUserListAdapter.Listener {

    private List<Association> list_heroes = new ArrayList<>();

    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @BindView(R.id.recyclerview_heroes) RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_association_user_list);
        Association association = new Association();

        ButterKnife.bind(this);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        UserPresenter presenter = new UserPresenter(this);
        //presenter.findAllHeroes(this, Integer.valueOf(association.getSiret()));
        presenter.findAllAcceptedHeroes(this, Integer.valueOf(1));

    }

    @Override
    public void onHeroClick(User user) {

    }

    @Override
    public void getHeroes(List<User> list_heroes) {
        AssociationUserListAdapter adapter = new AssociationUserListAdapter(list_heroes);
        adapter.setListener(this);
        recyclerView.setAdapter(adapter);
    }
}
