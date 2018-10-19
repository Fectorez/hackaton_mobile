package com.example.chewbs.alloheroproject.model;

import android.content.Context;
import android.content.SharedPreferences;

public class UserData {

    private static String PREF_USERNAME; // nom du fichier
    private static String TOKEN_KEY;
    private static SharedPreferences prefs;

    public UserData(String username) {
        PREF_USERNAME = username;
    }

    public static String getToken(Context c) {
        prefs = c.getSharedPreferences(PREF_USERNAME, Context.MODE_PRIVATE);
        return prefs.getString(TOKEN_KEY, "");
    }

    public void setToken(Context c, String token) {
        prefs = c.getSharedPreferences(PREF_USERNAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(TOKEN_KEY, token);
        editor.apply();
    }
//Bearer
}
