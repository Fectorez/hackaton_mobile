package com.example.chewbs.alloheroproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import com.example.chewbs.alloheroproject.R;
import com.example.chewbs.alloheroproject.model.UserData;
import com.example.chewbs.alloheroproject.presenter.AuthPresenter;
import com.example.chewbs.alloheroproject.view.AuthView;

import butterknife.OnClick;

public class AssociationSigninActivity extends AppCompatActivity implements AuthView {

    AuthPresenter authPresenter;

    EditText username_et;
    EditText password_et;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_association_signin);

        authPresenter = new AuthPresenter(this);

        username_et = findViewById(R.id.username);
        password_et = findViewById(R.id.password);

    }

    @OnClick(R.id.connect_button) public void signin() {
        if(areFieldsValid()){
            authPresenter.signin("association", username_et.getText().toString(), password_et.getText().toString());
        }
    }

    @Override
    public void authenticate(String token) {
        String name = username_et.getText().toString();
        UserData userData = new UserData(name);

        UserData.setToken(this, token);

        Intent intent = new Intent(AssociationSigninActivity.this, AssociationHomeActivity.class);
        startActivity(intent);
    }

    @Override
    public void errorConnectData(){
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
