package com.example.app_style.modelo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.widget.Toast;


import com.example.app_style.entidad.persona;
import com.example.app_style.util.BDproyecto;
import com.example.app_style.util.ConstantesBD;
import com.example.app_style.util.SharedPrefManager;

import java.util.ArrayList;

public class personaDAO {
    BDproyecto bdPersona;
    SQLiteDatabase database;


    public personaDAO(Context c) {

        bdPersona=new BDproyecto(c);
    }


    public  void openBD(){
        database=bdPersona.getWritableDatabase();
    }

    public  void closeBD(){
        bdPersona.close();
        database.close();
    }

    public  void registrarPersona(persona p){
        try{
            ContentValues values=new ContentValues();
            values.put("nombre",p.getNombre());
            values.put("apellido",p.getApellido());
            values.put("telefono",p.getTelefono());
            values.put("email",p.getEmail());
            values.put("password",p.getPassword());
            database.insert(ConstantesBD.NOMBRETABLA1,null,values);
        }catch (Exception e){

        }
    }
    public  void modificarDatos(persona p){
        try {
            ContentValues values=new ContentValues();
            values.put("nombre",p.getNombre());
            values.put("apellido",p.getApellido());
            values.put("telefono",p.getTelefono());
            values.put("email",p.getEmail());
            values.put("password",p.getPassword());
            //database.update(ConstantesBD.NOMBRETABLA,values,"id=?",
            //      new String[]{p.getId()+""} );
            database.update(ConstantesBD.NOMBRETABLA1,values,"id="+p.getId(),null);
        }catch (Exception e){

        }
    }

    public Boolean getLogin(String email, String password, Context con){
        persona p = null;
        Boolean respuesta= false;
        try {
            Cursor c=database.rawQuery("SELECT * FROM "+ConstantesBD.NOMBRETABLA1 + " WHERE email='"+email+"' AND password='"+password+
                    "'" ,  null);
            if (c.moveToFirst()){
                Toast.makeText(con , "" + c.getInt(0), Toast.LENGTH_SHORT).show();
                //p = new persona(c.getInt(0),c.getString(1),c.getString(2),c.getString(3),
                       // c.getString(4),c.getString(5));
              //  SharedPrefManager.getmInstance(con).userLogin(p);
                respuesta = true;

            }else{

            }


        }catch (Exception e){
            respuesta =  false;
        }
       return respuesta;

    }

    public ArrayList<persona> getPersonas(){
        ArrayList<persona> listaPer=new ArrayList<>();
        try {
            Cursor c=database.rawQuery("SELECT * FROM "+ConstantesBD.NOMBRETABLA1,
                    null);
            while (c.moveToNext()){
                //public Persona(int id, int dni, String ape, String nom, String email) {
                listaPer.add(new persona(c.getInt(0), c.getString(1),
                        c.getString(2),c.getString(3),c.getString(4),c.getString(5)));
            }

        }catch (Exception e){
            return  null;
        }
        return listaPer;
    }

}
