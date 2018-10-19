package com.example.chewbs.alloheroproject.presenter;

import android.util.Log;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONArrayRequestListener;
import com.example.chewbs.alloheroproject.association.AssociationUserListActivity;
import com.example.chewbs.alloheroproject.model.User;
import com.example.chewbs.alloheroproject.model.UserData;
import com.example.chewbs.alloheroproject.view.UserListView;
import com.example.chewbs.alloheroproject.view.UserView;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserPresenter {

    private String baseUrl = "http://10.0.2.2:8080/";

    private UserView userView;
    private UserListView userListView;

    public UserPresenter(UserView view) {
        this.userView = view;
    }
    public UserPresenter(UserListView view) {
        this.userListView = view;
    }

    public void findAllAcceptedHeroes(AssociationUserListActivity context, int id) {

        String token = UserData.getToken(context);

        AndroidNetworking.get(baseUrl + "/demande/acceptedUsers/" + id)
                .addHeaders("AUTHORIZATION", token)
                .setTag("Connect")
                .build()
                .getAsJSONArray(new JSONArrayRequestListener() {
                    @Override
                    public void onResponse(JSONArray response) {

                        JsonParser parser = new JsonParser();
                        JsonElement arr = parser.parse(response.toString());
                        Gson gson = new GsonBuilder().create();
                        User[] users = gson.fromJson(arr, User[].class);

                        List<User> list_user = new ArrayList<>(Arrays.asList(users));

                        userListView.getHeroes(list_user);
                    }

                    @Override
                    public void onError(ANError anError) {
                        Log.e("AAA", anError.toString());
                    }
                });
    }

    public void findAllPendingHeroes(AssociationUserListActivity context, int id) {

        String token = UserData.getToken(context);

        AndroidNetworking.get(baseUrl + "/demande/pendingUsers/" + id)
                .addHeaders("AUTHORIZATION", token)
                .setTag("Connect")
                .build()
                .getAsJSONArray(new JSONArrayRequestListener() {
                    @Override
                    public void onResponse(JSONArray response) {

                        JsonParser parser = new JsonParser();
                        JsonElement arr = parser.parse(response.toString());
                        Gson gson = new GsonBuilder().create();
                        User[] users = gson.fromJson(arr, User[].class);

                        List<User> list_user = new ArrayList<>(Arrays.asList(users));

                        userListView.getHeroes(list_user);
                    }

                    @Override
                    public void onError(ANError anError) {
                        Log.e("AAA", anError.toString());
                    }
                });
    }

    public void findOne(AssociationUserListActivity context, int id) {

        String token = UserData.getToken(context);

        AndroidNetworking.get(baseUrl + "/user?id=" + id)
                .addHeaders("authorization", token)
                .setTag("Connect")
                .build()
                .getAsJSONArray(new JSONArrayRequestListener() {
                    @Override
                    public void onResponse(JSONArray response) {

                        JsonParser parser = new JsonParser();
                        JsonElement arr = parser.parse(response.toString());
                        Gson gson = new GsonBuilder().create();
                        User[] users = gson.fromJson(arr, User[].class);

                        List<User> list_user = new ArrayList<>(Arrays.asList(users));

                        userListView.getHeroes(list_user);
                    }

                    @Override
                    public void onError(ANError anError) {
                        Log.e("AAA", anError.toString());
                    }
                });
    }

}
