package tech.asfaw.ethiochallenge.models;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by eyoela on 12/24/17.
 */

public class UserLab {
    public static final String SYSTEM_PREFS_NAME = "PreferencesForEntireApp";
    public static final String USER_PREFS_NAME = "UserObject";
    private Context mContext;
    private static UserLab singleton;
    private UserLab(Context context) {
        mContext = context.getApplicationContext();
    }

    public static UserLab getLab(Context context){
        if(singleton == null){
            singleton = new UserLab(context);
        }
        return singleton;
    }

    public void saveUser(final Person personToSave){

        SharedPreferences.Editor editor = mContext.getApplicationContext().getSharedPreferences(SYSTEM_PREFS_NAME, MODE_PRIVATE).edit();
        String jsonString = new Gson().toJson(personToSave).toString();
        editor.putString(USER_PREFS_NAME, jsonString);
        editor.apply();
    }

    public Person getUser(){
        SharedPreferences prefs = mContext.getApplicationContext().getSharedPreferences(SYSTEM_PREFS_NAME, MODE_PRIVATE);
        String userString = prefs.getString(USER_PREFS_NAME, null);
        if(userString == null || userString.isEmpty()){
            return null;
        } else {
            return new Gson().fromJson(userString, Person.class);
        }

    }
}
