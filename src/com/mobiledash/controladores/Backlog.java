package com.mobiledash.controladores;

import java.util.ArrayList;

import com.dragdrop.R;
import com.mobiledash.clases.Historia;
import com.mobiledash.clases.ItemHistoriaAdapter;
import com.mobiledash.clases.Tarea;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

public class Backlog extends Activity{
	
	ListView lista;
	ArrayList<Historia> datos;
	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.backlog);
		
		datos = new ArrayList<Historia>();
		rellenaDatos();
		lista = (ListView) findViewById(R.id.listaHistoriasProy);
		
		ItemHistoriaAdapter adaptador = new ItemHistoriaAdapter(this, datos);
		
        lista.setAdapter(adaptador);
        
        lista.setOnItemClickListener(new OnItemClickListener(){
       	 
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long id) {
                // TODO Auto-generated method stub
            	
            	Historia h = (Historia) datos.get(position);
            	
            	Intent i = new Intent(Backlog.this, DetalleHistoria.class);
            	i.putExtra("historia", h);
            	startActivity(i);
            }
        });
	}
	
	private void rellenaDatos(){
		ArrayList<Tarea> tareas = new ArrayList<Tarea>();
		tareas.add(new Tarea(1,"Alta historias","Crear el alta de historias",10,0,""));
		tareas.add(new Tarea(2,"Modificar historias","Crear modificaciones de historias",8,0,""));
		tareas.add(new Tarea(3,"Eliminar historias","Crear eliminado de historias",12,0,""));
        datos.add(new Historia(1,"ABM historias","","",tareas));
        
        ArrayList<Tarea> tareas1 = new ArrayList<Tarea>();
		tareas1.add(new Tarea(1,"Alta usuarios","Crear el alta de usuarios",10,0,""));
		tareas1.add(new Tarea(2,"Modificar usuarios","Crear modificaciones de usuarios",8,0,""));
		tareas1.add(new Tarea(3,"Eliminar usuarios","Crear eliminado de usuarios",12,0,""));
        datos.add(new Historia(1,"ABM usuarios","","",tareas1));

        ArrayList<Tarea> tareas2 = new ArrayList<Tarea>();
		tareas2.add(new Tarea(1,"Alta pedidos","Crear el alta de pedidos",10,0,""));
		tareas2.add(new Tarea(2,"Modificar pedidos","Crear modificaciones de pedidos",8,0,""));
		tareas2.add(new Tarea(3,"Eliminar pedidos","Crear eliminado de pedidos",12,0,""));
        datos.add(new Historia(1,"ABM pedidos","","",tareas2));
        
        ArrayList<Tarea> tareas3 = new ArrayList<Tarea>();
		tareas3.add(new Tarea(1,"Alta art�culos","Crear el alta de art�culos",10,0,""));
		tareas3.add(new Tarea(2,"Modificar art�culos","Crear modificaciones de art�culos",8,0,""));
		tareas3.add(new Tarea(3,"Eliminar art�culos","Crear eliminado de art�culos",12,0,""));
        datos.add(new Historia(1,"ABM art�culos","","",tareas3));
        
        ArrayList<Tarea> tareas4 = new ArrayList<Tarea>();
		tareas4.add(new Tarea(1,"Alta rotaciones","Crear el alta de rotaciones",10,0,""));
		tareas4.add(new Tarea(2,"Modificar rotacion","Crear modificaciones de rotaciones",8,0,""));
		tareas4.add(new Tarea(3,"Eliminar rotacion","Crear eliminado de rotaciones",12,0,""));
        datos.add(new Historia(1,"Gestionar rotaciones","","",tareas4));
	}

	public void agregarClick(View v)
	{
		Intent i = new Intent();
		i.setComponent(new ComponentName(this, NuevaHistoria.class));
    	startActivity(i);
	}
}
