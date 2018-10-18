package com.example.chewbs.alloheroproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.widget.EditText;
import android.widget.Toast;

import com.example.chewbs.alloheroproject.model.AssociationData;
import com.example.chewbs.alloheroproject.presenter.AuthPresenter;
import com.example.chewbs.alloheroproject.view.SigninView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AssociationSigninActivity extends AppCompatActivity implements SigninView {

    AuthPresenter authPresenter;

    @BindView(R.id.username_et)
    EditText username_et;
    @BindView(R.id.password_et)
    EditText password_et;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_association_signin);

        ButterKnife.bind(this);

        authPresenter = new AuthPresenter(this);
    }

    @OnClick(R.id.connect_button)
    public void signin() {
        if (areFieldsValid()) {
            authPresenter.signin("association", username_et.getText().toString(), password_et.getText().toString());
        }
    }

    @Override
    public void authenticate(String token) {
        String name = username_et.getText().toString();
        AssociationData associationData = new AssociationData(name);

        associationData.setToken(this, token);

        Intent intent = new Intent(AssociationSigninActivity.this, AssociationHomeActivity.class);
        startActivity(intent);
    }

    @Override
    public void errorConnectData() {
        Toast.makeText(this, "Utilisateur inconnu", Toast.LENGTH_SHORT).show();
    }

    boolean areFieldsValid() {
        String username = username_et.getText().toString();
        String password = password_et.getText().toString();

        if (username.isEmpty() || password.isEmpty()) {
            Toast.makeText(getApplicationContext(), "Au moins un champs incomplet.", Toast.LENGTH_LONG).show();
            return false;
        }
        return true;
    }

}
