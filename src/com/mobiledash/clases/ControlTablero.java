package com.mobiledash.clases;

import com.dragdrop.R;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ControlTablero extends LinearLayout
{
	TextView txtTitulo;
	TextView txtDescripcion;
	ImageView imagen;
	
	public ControlTablero(Context context) {
		super(context);
		inicializar();
	}
	
	public ControlTablero(Context context, AttributeSet attrs) {
		super(context, attrs);
		inicializar();
	}

	private void inicializar()
	{
		//Utilizamos el layout 'control_tablero' como interfaz del control
	    String infService = Context.LAYOUT_INFLATER_SERVICE;
	    LayoutInflater li =
	        (LayoutInflater)getContext().getSystemService(infService);
	    li.inflate(R.layout.control_tablero, this, true);
	 
	    //Obtenemoslas referencias a los distintos control
	    txtTitulo = (TextView)findViewById(R.id.tituloControl);
	    txtDescripcion = (TextView)findViewById(R.id.descripcionControl);
	    imagen = (ImageView)findViewById(R.id.imagenControl);
	}
	
	public void setTitulo(String msg)
	{
	    txtTitulo.setText(msg);
	}
	
	public void setDescripcion(String descripc)
	{
		txtDescripcion.setText(descripc);
	}
	
	public String getTitulo()
	{
		return txtTitulo.getText().toString();
	}
	
	public String getDescripcion()
	{
		return txtDescripcion.getText().toString();
	}
}
