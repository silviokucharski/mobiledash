package com.mobiledash.controladores;

import com.dragdrop.R;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class DetalleProyecto extends Activity{
	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.detalle_proyecto);
				
		TextView f = (TextView) findViewById(R.id.fechaInicio);
		f.setText("10/03/2013");
	}
	
	public void evasClick(View v)
	{
		Intent i = new Intent();
		i.setComponent(new ComponentName(this, MenuPrincipal.class));
    	startActivity(i);
	}
}
