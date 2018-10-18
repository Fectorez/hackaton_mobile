package com.example.chewbs.alloheroproject.presenter;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.StringRequestListener;
import com.example.chewbs.alloheroproject.view.SigninView;
import com.example.chewbs.alloheroproject.view.SignupView;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

public class AuthPresenter {

    private String baseUrl = "http://10.0.2.2:3000/";

    private SigninView signinView;
    private SignupView signupView;

    public AuthPresenter(SigninView view) {
        this.signinView = view;
    }

    public AuthPresenter(SignupView view) {
        this.signupView = view;
    }

    public void signin(String type, String username, String password) {
        String baseUrl = "http://10.0.2.2:3000/" + type + "/signin";
        JSONObject userJson = new JSONObject();
        try {
            userJson.put("username", username);
            userJson.put("password", password);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        AndroidNetworking.post(baseUrl + "auth/signin")
                .addJSONObjectBody(userJson)
                .setTag("Connect")
                .build()
                .getAsString(new StringRequestListener() {
                    @Override
                    public void onResponse(String token) {
                        signinView.authenticate(token);
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
            userJson.put("mail", data.get(2));
            userJson.put("phone_number", data.get(3));
            userJson.put("address", data.get(4));
            userJson.put("postal_code", data.get(5));
            userJson.put("city", data.get(6));
            userJson.put("password", data.get(7));

        } catch (JSONException e) {
            e.printStackTrace();
        }

        AndroidNetworking.post(baseUrl + "association/signup")
                .addJSONObjectBody(userJson)
                .setTag("Connect")
                .build()
                .getAsString(new StringRequestListener() {
                    @Override
                    public void onResponse(String token) {
                        signinView.authenticate(token);
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
            userJson.put("mail", data.get(3));
            userJson.put("phone_number", data.get(4));
            userJson.put("presentation", data.get(5));
            userJson.put("birthdate", data.get(6));

        } catch (JSONException e) {
            e.printStackTrace();
        }

        AndroidNetworking.post(baseUrl + "user/signup")
                .addJSONObjectBody(userJson)
                .setTag("Connect")
                .build()
                .getAsString(new StringRequestListener() {
                    @Override
                    public void onResponse(String token) {
                        signinView.authenticate(token);
                    }

                    @Override
                    public void onError(ANError error) {
                        signinView.errorConnectData();
                        error.printStackTrace();
                    }
                });
    }

}
