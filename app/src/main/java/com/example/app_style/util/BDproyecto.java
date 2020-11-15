package com.example.app_style.util;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class BDproyecto extends SQLiteOpenHelper {
    public BDproyecto(@Nullable Context context) {
        super(context, ConstantesBD.NOMBREBD, null, ConstantesBD.VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        //PERSONA
        db.execSQL("CREATE TABLE "+ConstantesBD.NOMBRETABLA1+" "+
                "(id integer primary key autoincrement,"+
                "nombre text not null,"+
                "apellido text not null," +
                "telefono text not null," +
                "email varchar(50) not null," +
                "password varchar(20) not null);");

        //ARTICULO

       /* db.execSQL("CREATE TABLE "+ConstantesBD.NOMBRETABLA2+" "+
        "(id integer primary key autoincrement,"+
                "descripcion text not null,"+
                "imagen text not null," +
                "precio decimal(10,2) not null," +
                "stock integer not null);");*/


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
