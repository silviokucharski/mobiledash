package com.mobiledash.controladores;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ClipData;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.DragShadowBuilder;
import android.view.View.OnDragListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.dragdrop.R;
import com.mobiledash.clases.ControlTablero;
import com.mobiledash.clases.Tarea;

public class TableroTareas extends Activity{
	
	static final int NONE = 0;
	static final int DRAG = 1;
	int mode = NONE;
	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tablero_tareas);
		
		findViewById(R.id.tareas1).setOnTouchListener(new MyTouchListener());
	    findViewById(R.id.tareas2).setOnTouchListener(new MyTouchListener());
	    findViewById(R.id.tareas3).setOnTouchListener(new MyTouchListener());
	    findViewById(R.id.columna1).setOnDragListener(new MyDragListener());
	    findViewById(R.id.columna2).setOnDragListener(new MyDragListener());
	    findViewById(R.id.columna3).setOnDragListener(new MyDragListener());
		rellenarDatos();
	}
	
	private void rellenarDatos()
	  {
		  ControlTablero ct = (ControlTablero) findViewById(R.id.tareas1);
		  ct.setTitulo("Alta historias");
		  ct.setDescripcion("Gestión de historias");
		  
		  ControlTablero ct1 = (ControlTablero) findViewById(R.id.tareas2);
		  ct1.setTitulo("Baja usuarios");
		  ct1.setDescripcion("Gestión de usuarios");
		  
		  ControlTablero ct2 = (ControlTablero) findViewById(R.id.tareas3);
		  ct2.setTitulo("Modificación artículos");
		  ct2.setDescripcion("Gestión de artículos");
	  }
	
	private final class MyTouchListener implements OnTouchListener {
	    public boolean onTouch(View view, MotionEvent motionEvent) {
	    	switch(motionEvent.getAction() & MotionEvent.ACTION_MASK)
	    	{
	    	case MotionEvent.ACTION_DOWN:
	    		mode = NONE;
		        ClipData data = ClipData.newPlainText("", "");
		        DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(view);
		        view.startDrag(data, shadowBuilder, view, 0);
		        //view.setVisibility(View.INVISIBLE);
	    		break;
	    		
	    	case MotionEvent.ACTION_UP:
	    		if (mode == NONE)
		 		{
	    			ControlTablero ct = (ControlTablero) view;
		        	Tarea t = new Tarea(1,ct.getTitulo(), ct.getDescripcion(), 12, 2, "");
		        	dialogo(t).show();
		 		}
	    		else
	    		{
	    			mode = NONE;
	    		}
	    		break;
	    		
	    	case MotionEvent.ACTION_MOVE:
	    		mode = DRAG;
	    		break;
	    	}
	        return true;
	      }
	    private AlertDialog dialogo(Tarea t)
		{
			// 1. Instantiate an AlertDialog.Builder with its constructor
	    	AlertDialog.Builder builder = new AlertDialog.Builder(TableroTareas.this);

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

	  class MyDragListener implements OnDragListener {
	    Drawable enterShape = getResources().getDrawable(R.drawable.shape_dragtarget);
	    Drawable normalShape = getResources().getDrawable(R.drawable.shape);

	    @Override
	    public boolean onDrag(View v, DragEvent event) {
	      int action = event.getAction();
	      switch (action) {
	      case DragEvent.ACTION_DRAG_STARTED:
	        break;
	      case DragEvent.ACTION_DRAG_ENTERED:
	        v.setBackgroundDrawable(enterShape);
	        break;
	      case DragEvent.ACTION_DRAG_EXITED:
	        v.setBackgroundDrawable(normalShape);
	        break;
	      case DragEvent.ACTION_DROP:
	        // Dropped, reassign View to ViewGroup
	        View view = (View) event.getLocalState();
	        ViewGroup owner = (ViewGroup) view.getParent();
	        owner.removeView(view);
	        LinearLayout container = (LinearLayout) v;
	        container.addView(view);
	        view.setVisibility(View.VISIBLE);
	        break;
	      case DragEvent.ACTION_DRAG_ENDED:
	        v.setBackgroundDrawable(normalShape);
	      default:
	        break;
	      }
	      return true;
	    }
	  }
}
