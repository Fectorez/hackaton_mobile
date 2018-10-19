package com.example.chewbs.alloheroproject.user;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.EditText;

import com.example.chewbs.alloheroproject.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class UserHomeActivity extends AppCompatActivity {

    @BindView(R.id.association_search_name)
    EditText association_name;
    @BindView(R.id.association_keyword)
    EditText keyword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_home);

        ButterKnife.bind(this);
    }

    @OnClick(R.id.search_association)
    public void search() {
        String criteria;
        if (!association_name.getText().toString().isEmpty() || !keyword.getText().toString().isEmpty()){
            if (!association_name.getText().toString().isEmpty()) {
                criteria = association_name.getText().toString();
                Intent intent = new Intent(UserHomeActivity.this, UserAssociationListActivity.class);
                intent.putExtra("association_name", criteria);
                startActivity(intent);
            }
            else {
                criteria = keyword.getText().toString();
                Intent intent = new Intent(UserHomeActivity.this, UserAssociationListActivity.class);
                intent.putExtra("association_keyword", criteria);
                startActivity(intent);
            }
        }
    }
}
