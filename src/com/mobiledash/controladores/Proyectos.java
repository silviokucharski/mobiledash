package com.mobiledash.controladores;

import java.util.ArrayList;

import com.dragdrop.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Proyectos extends Activity{
	
	ListView lista;
	ArrayAdapter<String> adaptador;
	ArrayList<String> datos;
	
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.proyectos);
	    
	    datos = new ArrayList<String>();
        rellenaDatos();
 
        lista = (ListView) findViewById(R.id.listaproyectos);
 
        adaptador = new ArrayAdapter<String>(this,R.layout.lista_blanca, datos);
 
        lista.setAdapter(adaptador);
        
        lista.setOnItemClickListener(new OnItemClickListener(){
        	 
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long id) {
                // TODO Auto-generated method stub
                Intent i = new Intent(arg1.getContext(), TabsProyecto.class);
                i.putExtra("proyecto", datos.get(position));
                startActivity(i);
            }
         
        });
    }
 
    private void rellenaDatos(){
        datos.add("Deposito-Compras");
        datos.add("Practica Profesional");
        datos.add("Librería online");
	}
}
