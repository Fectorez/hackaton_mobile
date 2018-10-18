package com.example.chewbs.alloheroproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.chewbs.alloheroproject.model.UserData;
import com.example.chewbs.alloheroproject.presenter.AuthPresenter;
import com.example.chewbs.alloheroproject.view.SignupView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class UserSignupActivity extends AppCompatActivity implements SignupView {

    AuthPresenter authPresenter;

    @BindView(R.id.firstname_et)
    EditText firstname_et;
    @BindView(R.id.lastname_et)
    EditText lastname_et;
    @BindView(R.id.password_et)
    EditText password_et;
    @BindView(R.id.mail_et)
    EditText mail_et;
    @BindView(R.id.phone_number_et)
    EditText phone_number_et;
    @BindView(R.id.presentation_tv)
    TextView presentation_tv;
    @BindView(R.id.birthdate_et)
    EditText birthdate_et;

    List<String> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_signup);

        ButterKnife.bind(this);

        authPresenter = new AuthPresenter(this);

        data.add(firstname_et.getText().toString());
        data.add(lastname_et.getText().toString());
        data.add(password_et.getText().toString());
        data.add(mail_et.getText().toString());
        data.add(phone_number_et.getText().toString());
        data.add(presentation_tv.getText().toString());
        data.add(birthdate_et.getText().toString());
    }

    @OnClick(R.id.register_button)
    public void signup() {
        if (areFieldsValid()) {
            authPresenter.signUpUser(data);
        }
    }

    @Override
    public void register(String token) {
        String identifier = mail_et.getText().toString();
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
        return true;
    }
}
