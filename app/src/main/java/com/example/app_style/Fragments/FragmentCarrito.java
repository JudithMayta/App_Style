package com.example.app_style.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.app_style.Interfaces.iComunicaFragments;
import com.example.app_style.R;
import com.example.app_style.entidad.persona;
import com.example.app_style.modelo.personaDAO;

import java.util.ArrayList;

public class FragmentCarrito extends Fragment {

    ArrayList<persona> listaPer=new ArrayList<>();
    personaDAO daoPer=new personaDAO(getContext());
    ListView lstPer;
    persona p;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.carrito_fragment,container, false);
       // daoPer.openBD();
        lstPer=view.findViewById(R.id.lstPer);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //inializarpersona()
        ((iComunicaFragments)getActivity()).inializarpersona();
        //daoPer.openBD();
        lstPer=getView().findViewById(R.id.lstPer);
        listarPersonas();
    }

    private void listarPersonas() {
        p=new persona("nombre","apellido","telefn","email","passs");
        daoPer.registrarPersona(p);
        listaPer=daoPer.getPersonas();
        ArrayList<String> lista=new ArrayList<>();
        for(persona per:listaPer){
            lista.add(per.getId()+" "+per.getNombre()+" "+per.getEmail());
        }

        ArrayAdapter<String> adapter=new ArrayAdapter<>(getActivity(),android.R.layout.simple_list_item_1,lista);
        lstPer.setAdapter(adapter);
    }


}
