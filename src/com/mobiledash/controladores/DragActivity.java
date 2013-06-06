package com.mobiledash.controladores;

import java.util.ArrayList;

import com.dragdrop.R;
import com.mobiledash.clases.Historia;
import com.mobiledash.clases.ItemHistoriaAdapter;

import android.app.ListActivity;
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
import android.widget.ListView;

public class DragActivity extends ListActivity {
  
	ListView columna1, columna2, columna3;

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.tablero);
    findViewById(R.id.columna1).setOnTouchListener(new MyTouchListener());
    findViewById(R.id.columna2).setOnTouchListener(new MyTouchListener());
    findViewById(R.id.columna3).setOnTouchListener(new MyTouchListener());
    findViewById(R.id.controlTablero1).setOnDragListener(new MyDragListener());
    findViewById(R.id.controlTablero2).setOnDragListener(new MyDragListener());
    findViewById(R.id.controlTablero3).setOnDragListener(new MyDragListener());
    
    columna1 = (ListView)findViewById(R.id.columna1);
    columna2 = (ListView)findViewById(R.id.columna2);
    columna3 = (ListView)findViewById(R.id.columna3);
    
    ArrayList<Historia> items1 = new ArrayList<Historia>();
	Historia h1 = new Historia();
	h1.setIdHistoria(1);
	h1.setNombre("Primera");
	h1.setIcono("pulgar arriba");
	items1.add(h1);
	ItemHistoriaAdapter adapter = new ItemHistoriaAdapter(this, items1);
	columna1.setAdapter(adapter);
	
	ArrayList<Historia> items2 = new ArrayList<Historia>();
	Historia h2 = new Historia();
	h2.setIdHistoria(2);
	h2.setNombre("Segunda");
	h2.setIcono("pulgar arriba");
	items2.add(h2);
	ItemHistoriaAdapter adapter2 = new ItemHistoriaAdapter(this, items2);
	columna2.setAdapter(adapter2);
	
	ArrayList<Historia> items3 = new ArrayList<Historia>();
	Historia h3 = new Historia();
	h3.setIdHistoria(3);
	h3.setNombre("Tercera");
	h3.setIcono("pulgar arriba");
	items3.add(h3);
	ItemHistoriaAdapter adapter3 = new ItemHistoriaAdapter(this, items3);
	columna3.setAdapter(adapter3);
}
  

class MyTouchListener implements OnTouchListener {
    @Override
	public boolean onTouch(View view, MotionEvent motionEvent) 
    {
    	
    	if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) 
    	{
        ClipData data = ClipData.newPlainText("", "");
        DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(view);
        ListView lista = (ListView) view;
        
        view.startDrag(data, shadowBuilder, view, 0);
        
        //view.setVisibility(View.INVISIBLE);
        return true;
      } else {
        return false;
      }
    }
  }
  
  

class MyDragListener implements OnDragListener 
{
	Drawable enterShape = getResources().getDrawable(R.drawable.shape_dragtarget);
	Drawable normalShape = getResources().getDrawable(R.drawable.shape);
	  
	  @Override
	  public boolean onDrag(View v, DragEvent event)
	  {
	    int action = event.getAction();
	    switch (event.getAction()) {
	    case DragEvent.ACTION_DRAG_STARTED:
	    // Do nothing
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