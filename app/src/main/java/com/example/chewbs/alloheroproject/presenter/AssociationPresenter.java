package com.example.chewbs.alloheroproject.presenter;

import android.util.Log;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONArrayRequestListener;
import com.example.chewbs.alloheroproject.model.Association;
import com.example.chewbs.alloheroproject.model.UserData;
import com.example.chewbs.alloheroproject.user.UserAssociationListActivity;
import com.example.chewbs.alloheroproject.view.AssociationKeywordView;
import com.example.chewbs.alloheroproject.view.AssociationNameView;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AssociationPresenter {

    private String baseUrl = "http://10.0.2.2:8080/";

    private AssociationKeywordView associationKeyWordView;
    private AssociationNameView associationNameView;

    public AssociationPresenter(AssociationKeywordView view) {
        this.associationKeyWordView = view;
    }
    public AssociationPresenter(AssociationNameView view) {
        this.associationNameView = view;
    }

    public void findAssociationByName(UserAssociationListActivity context, String association_name) {

        String token = UserData.getToken(context);

        AndroidNetworking.get(baseUrl + "/demande/getAssoRequests/" + association_name)
                .addHeaders("AUTHORIZATION", token)
                .setTag("Connect")
                .build()
                .getAsJSONArray(new JSONArrayRequestListener() {
                    @Override
                    public void onResponse(JSONArray response) {

                        JsonParser parser = new JsonParser();
                        JsonElement arr = parser.parse(response.toString());
                        Gson gson = new GsonBuilder().create();
                        Association[] associations = gson.fromJson(arr, Association[].class);

                        List<Association> list_association = new ArrayList<>(Arrays.asList(associations));

                        associationNameView.findAssociationByName(list_association);
                    }

                    @Override
                    public void onError(ANError anError) {
                        Log.e("AAA", anError.toString());
                    }
                });

    }

    public void findAssociationByKeyWord(UserAssociationListActivity context, String keyword) {

        String token = UserData.getToken(context);

        AndroidNetworking.get(baseUrl + "/association?nom=" + keyword)
                .addHeaders("AUTHORIZATION", token)
                .setTag("Connect")
                .build()
                .getAsJSONArray(new JSONArrayRequestListener() {
                    @Override
                    public void onResponse(JSONArray response) {

                        JsonParser parser = new JsonParser();
                        JsonElement arr = parser.parse(response.toString());
                        Gson gson = new GsonBuilder().create();
                        Association[] associations = gson.fromJson(arr, Association[].class);

                        List<Association> list_association = new ArrayList<>(Arrays.asList(associations));

                        associationKeyWordView.findAssociationByKeyword(list_association);
                    }

                    @Override
                    public void onError(ANError anError) {
                        Log.e("AAA", anError.toString());
                    }
                });

    }
}
