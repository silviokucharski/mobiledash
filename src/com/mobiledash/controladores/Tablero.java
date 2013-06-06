package com.mobiledash.controladores;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.dragdrop.R;
import com.mobiledash.clases.ControlTablero;

public class Tablero extends Activity {

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.tablero);
    findViewById(R.id.controlTablero1).setOnTouchListener(new MyTouchListener());
    findViewById(R.id.controlTablero2).setOnTouchListener(new MyTouchListener());
    findViewById(R.id.controlTablero3).setOnTouchListener(new MyTouchListener());
    rellenarDatos();
  }

  private void rellenarDatos()
  {
	  ControlTablero ct = (ControlTablero) findViewById(R.id.controlTablero1);
	  ct.setTitulo("ABM historias");
	  ct.setDescripcion("Gestión de historias");
	  
	  ControlTablero ct1 = (ControlTablero) findViewById(R.id.controlTablero2);
	  ct1.setTitulo("ABM usuarios");
	  ct1.setDescripcion("Gestión de usuarios");
	  
	  ControlTablero ct2 = (ControlTablero) findViewById(R.id.controlTablero3);
	  ct2.setTitulo("ABM artículos");
	  ct2.setDescripcion("Gestión de artículos");
  }
  
  private final class MyTouchListener implements OnTouchListener
  {
	  public boolean onTouch(View view, MotionEvent motionEvent) {
		  if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
			  Intent i = new Intent(Tablero.this, TableroTareas.class);
			  startActivity(i);
			  return true;
		  } else {
			  return false;
		  }
	  }
  }
} 
