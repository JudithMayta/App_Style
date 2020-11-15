package com.example.app_style.Fragments;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.app_style.Interfaces.iComunicaFragments;
import com.example.app_style.R;
import com.example.app_style.entidad.persona;
import com.example.app_style.util.SharedPrefManager;

public class FragmentPerfil extends Fragment {
    persona p=null;
    int id=0;
    Activity actividad;
    iComunicaFragments interfaceComunicaFragments;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View view;
        p= new persona();
        p= SharedPrefManager.getmInstance(getContext()).getUser();
        id = p.getId();
        if ( p != null){ // si p tiene
             view = inflater.inflate(R.layout.perfil,container, false);
        }
        else{
             view = inflater.inflate(R.layout.cuentacreada,container, false);
        }


       view.findViewById(R.id.iniciarsesion).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                interfaceComunicaFragments.abrirlogin();
            }
        });

        view.findViewById(R.id.perfilregistrate).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                interfaceComunicaFragments.abrirregistrar();
            }
        });


        return view;
    }

    //metodo para comunicar con el fragent detalle
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        //esto es necesario para establecer la comunicacion entre la lista y el detalle
        //si el contexto que le esta llegando es una instancia de un activity:
        if(context instanceof Activity){
            //voy a decirle a mi actividad que sea igual a dicho contesto. castin correspondiente:
            this.actividad= (Activity) context;
            ////que la interface icomunicafragments sea igual ese contexto de la actividad:
            interfaceComunicaFragments= (iComunicaFragments) this.actividad;
        }
    }
}
