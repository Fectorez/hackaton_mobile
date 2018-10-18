package com.example.chewbs.alloheroproject.authentication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.chewbs.alloheroproject.R;
import com.example.chewbs.alloheroproject.model.UserData;
import com.example.chewbs.alloheroproject.presenter.AuthPresenter;
import com.example.chewbs.alloheroproject.user.UserHomeActivity;
import com.example.chewbs.alloheroproject.view.SignupView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class UserSignupActivity extends AppCompatActivity implements SignupView {

    AuthPresenter authPresenter;

    @BindView(R.id.firstname_user_signup)
    EditText firstname_user_signup;
    @BindView(R.id.lastname_user_signup)
    EditText lastname_user_signup;
    @BindView(R.id.password_user_signup)
    EditText password_user_signup;
    @BindView(R.id.mail_user_signup)
    EditText mail_user_signup;
    @BindView(R.id.phone_number_user_signup)
    EditText phone_number_user_signup;
    @BindView(R.id.presentation_user_signup)
    TextView presentation_user_signup;
    @BindView(R.id.birthdate_user_signup)
    EditText birthdate_user_signup;

    List<String> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_signup);

        ButterKnife.bind(this);

        authPresenter = new AuthPresenter(this);

    }

    @OnClick(R.id.association_user_signup)
    public void goToAssociation() {
        Intent intent = new Intent(UserSignupActivity.this, AssociationSignupActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.register_button_user_signup)
    public void signup() {
        if (areFieldsValid()) {
            authPresenter.signUpUser(data);
        }
    }

    @OnClick(R.id.connect_button_user_signup)
    public void goToConnect() {
        Intent intent = new Intent(UserSignupActivity.this, UserSigninActivity.class);
        startActivity(intent);
    }

    @Override
    public void register(String token) {
        String identifier = mail_user_signup.getText().toString();
        UserData userData = new UserData(identifier);

        userData.setToken(this, token);

        Intent intent = new Intent(UserSignupActivity.this, UserHomeActivity.class);
        startActivity(intent);
    }

    @Override
    public void errorInsertData() {
        Toast.makeText(this, "Erreur d'insertion", Toast.LENGTH_SHORT).show();
    }

    boolean areFieldsValid() {
        for (String element : data) {
            if (element.isEmpty()) {
                Toast.makeText(getApplicationContext(), "Au moins un champs incomplet.", Toast.LENGTH_LONG).show();
                return false;
            }
        }

        data.add(firstname_user_signup.getText().toString());
        data.add(lastname_user_signup.getText().toString());
        data.add(password_user_signup.getText().toString());
        data.add(mail_user_signup.getText().toString());
        data.add(phone_number_user_signup.getText().toString());
        data.add(presentation_user_signup.getText().toString());
        data.add(birthdate_user_signup.getText().toString());

        return true;
    }
}
