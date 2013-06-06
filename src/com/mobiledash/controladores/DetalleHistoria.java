package com.mobiledash.controladores;

import java.util.ArrayList;

import com.dragdrop.R;
import com.mobiledash.clases.Historia;
import com.mobiledash.clases.Tarea;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

public class DetalleHistoria extends Activity{
	
	Historia h;
	ArrayList<String> datos;
	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.detalle_historia);
		
		Bundle b = getIntent().getExtras();
		h = (Historia) b.getParcelable("historia");
		setTitle(h.getNombre());
		
		datos = new ArrayList<String>();
		for(int x = 0; x < h.getTareas().size(); x++)
		{
			datos.add(h.getTareas().get(x).getTitulo());
		}
		
		ListView lista = (ListView) findViewById(R.id.listaTareas);
		
		ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this,R.layout.lista_blanca, datos);
		 
        lista.setAdapter(adaptador);
        
        lista.setOnItemClickListener(new OnItemClickListener(){
        	 
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long id) {
                // TODO Auto-generated method stub
            	dialogo(h.getTareas().get(position)).show();
            }
         
        });
	}
	
	private AlertDialog dialogo(Tarea t)
	{
		// 1. Instantiate an AlertDialog.Builder with its constructor
    	AlertDialog.Builder builder = new AlertDialog.Builder(this);

    	// 2. Chain together various setter methods to set the dialog characteristics
    	builder.setTitle(t.getTitulo());
    	
    	String mensaje = t.getDetalle() + "\n\r";
    		mensaje += "Trabajo calculadado: " + t.getTrabajoCalculado() + "\n\r";
    		mensaje += "Trabajo consumido: " + t.getTrabajoConsumido() + "\n\r";
    		mensaje += "Comentarios: " + t.getComentarios();
    			
    	builder.setMessage(mensaje);
    	// Add the buttons
    	/*builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
    	           public void onClick(DialogInterface dialog, int id) {
    	               dialog.cancel();
    	           }
    	       });*/

    	// 3. Get the AlertDialog from create()
    	AlertDialog dialog = builder.create();
    	
    	return dialog;
	}
}
