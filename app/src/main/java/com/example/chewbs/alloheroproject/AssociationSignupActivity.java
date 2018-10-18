package com.example.chewbs.alloheroproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.Toast;

import com.example.chewbs.alloheroproject.model.AssociationData;
import com.example.chewbs.alloheroproject.presenter.AuthPresenter;
import com.example.chewbs.alloheroproject.view.SignupView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AssociationSignupActivity extends AppCompatActivity implements SignupView {

    AuthPresenter authPresenter;

    @BindView(R.id.creation_date_et)
    EditText creation_date_et;
    @BindView(R.id.name_et)
    EditText name_et;
    @BindView(R.id.mail_et)
    EditText mail_et;
    @BindView(R.id.phone_number_et)
    EditText phone_number_et;
    @BindView(R.id.address_et)
    EditText address_et;
    @BindView(R.id.postal_code_et)
    EditText postal_code_et;
    @BindView(R.id.city_et)
    EditText city_et;
    @BindView(R.id.password_et)
    EditText password_et;
    @BindView(R.id.siret_et)
    EditText siret_et;

    List<String> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_association_signup);
        ButterKnife.bind(this);

        authPresenter = new AuthPresenter(this);

        data.add(creation_date_et.getText().toString());
        data.add(name_et.getText().toString());
        data.add(mail_et.getText().toString());
        data.add(phone_number_et.getText().toString());
        data.add(address_et.getText().toString());
        data.add(postal_code_et.getText().toString());
        data.add(city_et.getText().toString());
        data.add(password_et.getText().toString());
        data.add(siret_et.getText().toString());
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
        AssociationData associationData = new AssociationData(identifier);

        associationData.setToken(this, token);

        Intent intent = new Intent(AssociationSignupActivity.this, AssociationHomeActivity.class);
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
