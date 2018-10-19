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
import com.example.chewbs.alloheroproject.view.SignupView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AssociationSignupActivity extends AppCompatActivity implements SignupView {

    AuthPresenter authPresenter;

    @BindView(R.id.creation_date_association_signup)
    EditText creation_date_association_signup;
    @BindView(R.id.name_association_signup)
    EditText name_association_signup;
    @BindView(R.id.mail_association_signup)
    EditText mail_association_signup;
    @BindView(R.id.phone_number_association_signup)
    EditText phone_number_association_signup;
    /*
    @BindView(R.id.address_association_signup)
    EditText address_association_signup;
    @BindView(R.id.postal_code_association_signup)
    EditText postal_code_association_signup;
    @BindView(R.id.city_association_signup)
    EditText city_association_signup;
    */
    @BindView(R.id.password_association_signup)
    EditText password_association_signup;
    @BindView(R.id.siret_association_signup)
    EditText siret_association_signup;

    List<String> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_association_signup);
        ButterKnife.bind(this);

        authPresenter = new AuthPresenter(this);

    }

    @OnClick(R.id.user_association_signup)
    public void goToUser() {
        Intent intent = new Intent(AssociationSignupActivity.this, UserSignupActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.register_button_association_signup)
    public void signup() {
        if (areFieldsValid()) {
            authPresenter.signUpUser(data);
        }
    }

    @OnClick(R.id.connect_button_association_signup)
    public void goToConnect() {
        Intent intent = new Intent(AssociationSignupActivity.this, AssociationSigninActivity.class);
        startActivity(intent);
    }

    @Override
    public void register(String token) {
        String identifier = mail_association_signup.getText().toString();
        AssociationData associationData = new AssociationData(identifier);

        associationData.setToken(this, token);

        Intent intent = new Intent(AssociationSignupActivity.this, AssociationDemandListActivity.class);
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
        data.add(creation_date_association_signup.getText().toString());
        data.add(name_association_signup.getText().toString());
        data.add(mail_association_signup.getText().toString());
        data.add(phone_number_association_signup.getText().toString());
        //data.add(address_association_signup.getText().toString());
        //data.add(postal_code_association_signup.getText().toString());
        //data.add(city_association_signup.getText().toString());
        data.add(password_association_signup.getText().toString());
        data.add(siret_association_signup.getText().toString());

        return true;
    }
}
