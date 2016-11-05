package com.ascensive_software.utils;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.SharedPreferences;

/**
 * Created by edwin on 11/5/16.
 */

public class DataSharedPreferences {

    private static final String defaultSharedPrefName_ = "defaultSharedPref";

    public static void saveInt(
            ContextWrapper context,
            String id,
            int value
    ){
        saveInt(context, defaultSharedPrefName_, id, value);
    }

    public static void saveInt(
            ContextWrapper context,
            String sharedPrefName,
            String id,
            int value) {
        SharedPreferences sharedPref = context.getSharedPreferences(sharedPrefName, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putInt(id, value);
        editor.commit();
    }

    public static int loadInt(
            ContextWrapper context,
            String id){
        return loadInt(context, defaultSharedPrefName_, id);
    }

    public static int loadInt(
            ContextWrapper context,
            String sharedPrefName,
            String id) {
        SharedPreferences sharedPref = context.getSharedPreferences(sharedPrefName, Context.MODE_PRIVATE);
        return sharedPref.getInt(id, 0);
    }
}
