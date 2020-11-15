package com.example.app_style.Fragments;

import android.database.sqlite.SQLiteDatabase;
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
import com.example.app_style.util.BDproyecto;
import com.example.app_style.util.SharedPrefManager;

public class LoginFragment extends Fragment {


    EditText loginemail, loginpassword;
    persona per = null ;
    personaDAO pdao=new personaDAO(getContext());


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.login,container, false);
        loginemail = view.findViewById(R.id.loginemail);
        loginpassword = view.findViewById(R.id.loginpassword);

        view.findViewById(R.id.logininiciarsesion).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ingresarlogin();
            }
        });
 

        return view;
    }
    public void ingresarlogin(){
        String email,password;
        email=loginemail.getText().toString();
        password=loginpassword.getText().toString();
        pdao = new personaDAO(getActivity());
        if (email.equals("") || password.equals("")){
            Toast.makeText(getActivity(), "Los campos Email y Password estan vacios", Toast.LENGTH_SHORT).show();
        }else{
            per = new persona();
            if (pdao.getLogin(email,password,getContext())){

            }else{
                Toast.makeText(getActivity(), "Credenciales incorrectos", Toast.LENGTH_SHORT).show();
            }

        }

    }






}
