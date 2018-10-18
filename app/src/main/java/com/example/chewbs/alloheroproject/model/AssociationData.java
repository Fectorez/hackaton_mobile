package com.example.chewbs.alloheroproject.model;

import android.content.Context;
import android.content.SharedPreferences;

public class AssociationData {

    private static String PREF_ASSOCIATIONNAME; // nom du fichier
    private static String TOKEN_KEY;
    private static SharedPreferences prefs;

    public AssociationData(String association_name) {
        PREF_ASSOCIATIONNAME = association_name;
    }

    public String getToken(Context c) {
        prefs = c.getSharedPreferences(PREF_ASSOCIATIONNAME, Context.MODE_PRIVATE);
        return prefs.getString(TOKEN_KEY, "");
    }

    public void setToken(Context c, String token) {
        prefs = c.getSharedPreferences(PREF_ASSOCIATIONNAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(TOKEN_KEY, token);
        editor.apply();
    }


}
