package com.example.chewbs.alloheroproject.presenter;

import android.util.Log;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.StringRequestListener;
import com.example.chewbs.alloheroproject.model.Demand;
import com.example.chewbs.alloheroproject.view.DemandView;

import org.json.JSONException;
import org.json.JSONObject;

public class DemandPresenter {
    DemandView demandView ;

    public void put(final Demand demand){
        String baseUrl = "http://127.0.0.1:8080/demand/put";
        JSONObject demandJson = new JSONObject();
        try {
            demandJson.put("demande", demand);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        AndroidNetworking.post(baseUrl+"auth/signin")
                .addJSONObjectBody(demandJson)
                .setTag("Connect")
                .build()
                .getAsString(new StringRequestListener() {
                    @Override
                    public void onResponse(String token) {
                        Log.d("", "onResponse: OK");
                    }

                    @Override
                    public void onError(ANError error) {
                        error.printStackTrace();
                    }
                });
    }
}
