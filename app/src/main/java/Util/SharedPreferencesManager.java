package Util;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreferencesManager {
    private final String PREF_NAME = "com.example.jooseongho.myasynctask";
    public final static String _1ST_SCORE = "_1ST_SCORE";
    public final static String _2ND_SCORE = "_2ND_SCORE";
    public final static String _3RD_SCORE = "_3RD_SCORE";

    public final static String _1ST_NAME = "_1ST_NAME";
    public final static String _2ND_NAME = "_2ND_NAME";
    public final static String _3RD_NAME = "_3RD_NAME";

    Context context;

    public SharedPreferencesManager(Context context) {
        this.context = context;
    }
    public void put(String key,String value){
        SharedPreferences pref = context.getSharedPreferences(
                PREF_NAME,Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString(key,value);
        editor.commit();
    }
    public void put(String key,float value){
        SharedPreferences pref = context.getSharedPreferences(
                PREF_NAME,Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putFloat(key,value);
        editor.commit();
    }
    public String getValue(String key,String defaultValue){
        SharedPreferences pref = context.getSharedPreferences(
                PREF_NAME,Activity.MODE_PRIVATE);
        try{
            return pref.getString(key,defaultValue);
        }catch (Exception e){
            return defaultValue;
        }
    }
    public float getValue(String key,float defaultValue){
        SharedPreferences pref = context.getSharedPreferences(
                PREF_NAME,Activity.MODE_PRIVATE);
        try{
            return pref.getFloat(key,defaultValue);
        }catch (Exception e){
            return defaultValue;
        }
    }

}
