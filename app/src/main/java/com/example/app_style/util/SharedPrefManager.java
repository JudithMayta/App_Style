package com.example.app_style.util;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import com.example.app_style.MainActivity;
import com.example.app_style.entidad.persona;

public class SharedPrefManager {
    private static final String SHARED_PREF_NAME = "proyecto";
    private static final String KEY_ID = "keyid";
    private static final String KEY_NOMBRE = "keynombre";
    private static final String KEY_APELLIDO = "keyapellido";
    private static final String KEY_TELEFONO = "keytelefono";
    private static final String KEY_EMAIL = "keyn_email";
    private static final String KEY_PASSWORD = "keypassword";


    private static SharedPrefManager mInstance;
    private static Context mCtx;

    private SharedPrefManager(Context context){mCtx = context;}

    public static synchronized SharedPrefManager getmInstance(Context context){
        if (mInstance == null){
            mInstance = new SharedPrefManager(context);
        }
        return mInstance;
    }

    public void userLogin(persona per){
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(KEY_ID, per.getId());
        editor.putString(KEY_NOMBRE, per.getNombre());
        editor.putString(KEY_APELLIDO, per.getApellido());
        editor.putString(KEY_TELEFONO, per.getTelefono());
        editor.putString(KEY_EMAIL, per.getEmail());
        editor.putString(KEY_PASSWORD, per.getPassword());
        editor.apply();
    }

    //este método verificará si el usuario ya ha iniciado sesión o no
    public boolean isLoggedIn(){
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString(KEY_NOMBRE, null) != null;
    }

    //este método le dará al usuario conectado
    public persona getUser(){
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return new persona(
                sharedPreferences.getInt(KEY_ID, -1),
                sharedPreferences.getString(KEY_NOMBRE, null),
                sharedPreferences.getString(KEY_APELLIDO, null),
                sharedPreferences.getString(KEY_TELEFONO, null),
                sharedPreferences.getString(KEY_EMAIL, null),
                sharedPreferences.getString(KEY_PASSWORD, null)
        );
    }

    //este método desconectará al usuario
    public void logOut(){
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
        mCtx.startActivity(new Intent(mCtx, MainActivity.class));
    }

}
