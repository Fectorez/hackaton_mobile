package com.example.chewbs.alloheroproject.presenter;

import android.content.Context;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;
import com.androidnetworking.interfaces.StringRequestListener;
import com.example.chewbs.alloheroproject.view.SigninView;
import com.example.chewbs.alloheroproject.view.SignupView;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

public class AuthPresenter {

    private String baseUrl = "http://10.0.2.2:8080/";

    private SigninView signinView;
    private SignupView signupView;

    public AuthPresenter(SigninView view) {
        this.signinView = view;
    }
    public AuthPresenter(SignupView view) {
        this.signupView = view;
    }

    public void signin(Context context, final String type, final String username, final String password) {

        JSONObject userJson = new JSONObject();
        try {
            userJson.put("email", username);
            userJson.put("password", password);

        } catch (JSONException e) {
            e.printStackTrace();
        }
        AndroidNetworking.initialize(context);
        AndroidNetworking.post(baseUrl + type + "/loginUser")
                .addHeaders("Content-Type", "application/json")
                .addJSONObjectBody(userJson)
                .setTag("Connect")
                .build()
                .getAsJSONObject(new JSONObjectRequestListener() {

                    @Override
                    public void onResponse(JSONObject response) {
                        signinView.authenticate("Bearer " + response);
                    }

                    @Override
                    public void onError(ANError error) {
                        signinView.errorConnectData();
                        error.printStackTrace();
                    }
                });



    }

    public void signUpAssociation(List<String> data) {

        JSONObject userJson = new JSONObject();
        try {

            userJson.put("creation_date", data.get(0));
            userJson.put("name", data.get(1));
            userJson.put("email", data.get(2));
            userJson.put("phone_number", data.get(3));
            userJson.put("address", data.get(4));
            userJson.put("postal_code", data.get(5));
            userJson.put("city", data.get(6));
            userJson.put("password", data.get(7));

        } catch (JSONException e) {
            e.printStackTrace();
        }

        AndroidNetworking.post(baseUrl + "registerAssociation")
                .addJSONObjectBody(userJson)
                .setTag("Connect")
                .build()
                .getAsString(new StringRequestListener() {
                    @Override
                    public void onResponse(String token) {
                        signinView.authenticate("Bearer " + token);
                    }

                    @Override
                    public void onError(ANError error) {
                        signinView.errorConnectData();
                        error.printStackTrace();
                    }
                });
    }

    public void signUpUser(List<String> data) {

        JSONObject userJson = new JSONObject();
        try {

            userJson.put("firstname", data.get(0));
            userJson.put("lastname", data.get(1));
            userJson.put("password", data.get(2));
            userJson.put("email", data.get(3));
            userJson.put("phone_number", data.get(4));
            userJson.put("presentation", data.get(5));
            userJson.put("birthdate", data.get(6));

        } catch (JSONException e) {
            e.printStackTrace();
        }

        AndroidNetworking.post(baseUrl + "registerUser")
                .addJSONObjectBody(userJson)
                .setTag("Connect")
                .build()
                .getAsString(new StringRequestListener() {
                    @Override
                    public void onResponse(String token) {
                        signinView.authenticate("Bearer " + token);
                    }

                    @Override
                    public void onError(ANError error) {
                        signinView.errorConnectData();
                        error.printStackTrace();
                    }
                });
    }

}
