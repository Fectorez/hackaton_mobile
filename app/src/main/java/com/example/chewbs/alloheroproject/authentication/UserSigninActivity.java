package com.example.chewbs.alloheroproject.authentication;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import com.androidnetworking.AndroidNetworking;
import com.example.chewbs.alloheroproject.R;
import com.example.chewbs.alloheroproject.model.User;
import com.example.chewbs.alloheroproject.model.UserData;
import com.example.chewbs.alloheroproject.presenter.AuthPresenter;
import com.example.chewbs.alloheroproject.user.UserHomeActivity;
import com.example.chewbs.alloheroproject.view.SigninView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class UserSigninActivity extends AppCompatActivity implements SigninView {

    AuthPresenter authPresenter;

    @BindView(R.id.username_user_signin)
    EditText username_user_signin;
    @BindView(R.id.password_user_signin)
    EditText password_user_signin;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_signin);

        int permissionCheck = ContextCompat.checkSelfPermission(this,
                Manifest.permission.INTERNET);

        Log.e("INTERNET1", String.valueOf(permissionCheck));
        Log.e("INTERNET2", String.valueOf(PackageManager.PERMISSION_GRANTED));

        ButterKnife.bind(this);

        authPresenter = new AuthPresenter(this);
    }

    @OnClick(R.id.association_user_signin)
    public void goToAssociation() {
        Intent intent = new Intent(UserSigninActivity.this, AssociationSigninActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.connect_button_user_signin)
    public void signin() {
        if (areFieldsValid()) {
            authPresenter.signin(this,"utilisateur", username_user_signin.getText().toString(), password_user_signin.getText().toString());
        }
    }

    @OnClick(R.id.register_button_user_signin)
    public void goToRegister() {
        Intent intent = new Intent(UserSigninActivity.this, UserSignupActivity.class);
        startActivity(intent);
    }

    @Override
    public void authenticate(String token) {
        String name = username_user_signin.getText().toString();
        UserData userData = new UserData(name);

        User.IS_ONLINE = true;
        userData.setToken(this, token);

        Intent intent = new Intent(UserSigninActivity.this, UserHomeActivity.class);
        startActivity(intent);
    }

    @Override
    public void errorConnectData() {
        Toast.makeText(this, "Utilisateur inconnu", Toast.LENGTH_SHORT).show();
    }

    boolean areFieldsValid() {
        String username = username_user_signin.getText().toString();
        String password = password_user_signin.getText().toString();

        if (username.isEmpty() || password.isEmpty()) {
            Toast.makeText(getApplicationContext(), "Au moins un champs incomplet.", Toast.LENGTH_LONG).show();
            return false;
        }
        return true;
    }

}
