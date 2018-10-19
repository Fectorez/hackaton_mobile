package com.example.chewbs.alloheroproject.authentication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.Toast;

import com.example.chewbs.alloheroproject.R;
import com.example.chewbs.alloheroproject.association.AssociationDemandListActivity;
import com.example.chewbs.alloheroproject.model.AssociationData;
import com.example.chewbs.alloheroproject.presenter.AuthPresenter;
import com.example.chewbs.alloheroproject.view.SigninView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AssociationSigninActivity extends AppCompatActivity implements SigninView {

    AuthPresenter authPresenter;

    @BindView(R.id.username_association_signin)
    EditText username_association_signin;
    @BindView(R.id.password_association_signin)
    EditText password_association_signin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_association_signin);

        ButterKnife.bind(this);

        authPresenter = new AuthPresenter(this);
    }

    @OnClick(R.id.user_association_signin)
    public void goToUser() {
        Intent intent = new Intent(AssociationSigninActivity.this, UserSigninActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.connect_button_association_signin)
    public void signin() {
        if (areFieldsValid()) {
            authPresenter.signin(this,"association", username_association_signin.getText().toString(), password_association_signin.getText().toString());
        }
    }

    @OnClick(R.id.register_button_association_signin)
    public void goToRegister() {
        Intent intent = new Intent(AssociationSigninActivity.this, AssociationSignupActivity.class);
        startActivity(intent);
    }

    @Override
    public void authenticate(String token) {
        String name = username_association_signin.getText().toString();
        AssociationData associationData = new AssociationData(name);

        associationData.setToken(this, token);

        Intent intent = new Intent(AssociationSigninActivity.this, AssociationDemandListActivity.class);
        startActivity(intent);
    }

    @Override
    public void errorConnectData() {
        Toast.makeText(this, "Utilisateur inconnu", Toast.LENGTH_SHORT).show();
    }

    boolean areFieldsValid() {
        String username = username_association_signin.getText().toString();
        String password = password_association_signin.getText().toString();

        if (username.isEmpty() || password.isEmpty()) {
            Toast.makeText(getApplicationContext(), "Au moins un champs incomplet.", Toast.LENGTH_LONG).show();
            return false;
        }
        return true;
    }

}
