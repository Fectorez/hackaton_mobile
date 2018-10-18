package com.example.chewbs.alloheroproject.presenter;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.StringRequestListener;
import com.example.chewbs.alloheroproject.view.AuthView;

import org.json.JSONException;
import org.json.JSONObject;

public class AuthPresenter {

    public AuthView authView;

    public AuthPresenter(AuthView view) {
        this.authView = view;
    }

    public void signin(String type, String username, String password){
        String baseUrl = "http://10.0.2.2:3000/" + type + "/signin";
        JSONObject userJson = new JSONObject();
        try {
            userJson.put("username", username);
            userJson.put("password", password);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        AndroidNetworking.post(baseUrl+"auth/signin")
                .addJSONObjectBody(userJson)
                .setTag("Connect")
                .build()
                .getAsString(new StringRequestListener() {
                    @Override
                    public void onResponse(String token) {
                        authView.authenticate(token);
                    }

                    @Override
                    public void onError(ANError error) {
                        authView.errorConnectData();
                        error.printStackTrace();
                    }
                });
    }

}
