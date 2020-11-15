package com.example.app_style.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.app_style.R;
import com.example.app_style.entidad.persona;
import com.example.app_style.modelo.personaDAO;
import com.example.app_style.util.SharedPrefManager;

public class RegistrarFragment extends Fragment {
    EditText registrarnombre, registrarapellido, registrartelefono, registraremail, registrarpassword;
    personaDAO pdao;
    persona per = null ;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.registrar,container, false);
        registrarnombre = view.findViewById(R.id.registrarnombre);
        registrarapellido = view.findViewById(R.id.registrarapellido);
        registrartelefono = view.findViewById(R.id.registrartelefono);
        registraremail = view.findViewById(R.id.registraremail);
        registrarpassword = view.findViewById(R.id.registrarpassword);

        view.findViewById(R.id.registrarcuenta).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ingresarregistrar();
            }
        });


        return view;
    }
    public void ingresarregistrar(){
        String nombre,apellido,telefono,email,password;
        nombre=registrarnombre.getText().toString();
        apellido=registrarapellido.getText().toString();
        telefono=registrartelefono.getText().toString();
        email=registraremail.getText().toString();
        password=registrarpassword.getText().toString();
        pdao = new personaDAO(getActivity());
        if (nombre.equals("") || apellido.equals("") || telefono.equals("") || email.equals("") || password.equals("")){
            Toast.makeText(getActivity(), "Complete los campos estan vacios", Toast.LENGTH_SHORT).show();
        }else{
            per = new persona(nombre,apellido,telefono,email,password);
            pdao.registrarPersona(per);
            Toast.makeText(getActivity(), "Registro exitoso", Toast.LENGTH_SHORT).show();
        }

    }

}