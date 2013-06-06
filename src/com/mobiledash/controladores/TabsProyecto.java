package com.mobiledash.controladores;

import android.app.TabActivity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.RelativeLayout;
import android.widget.TabHost;
import android.widget.TextView;

import com.dragdrop.R;

@SuppressWarnings("deprecation")
public class TabsProyecto extends TabActivity
	{
		//Variables globales
			TabHost tabHost;
			
			@Override
			public void onCreate(Bundle savedInstanceState)
			{
				super.onCreate(savedInstanceState);
				setContentView(R.layout.tabs_proyecto);
				
				Bundle b = getIntent().getExtras();
				setTitle(b.getString("proyecto"));
				
				tabHost = getTabHost();
				tabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
					
					public void onTabChanged(String arg0) {
						for(int i=0;i<tabHost.getTabWidget().getChildCount();i++)
					    {
							tabHost.getTabWidget().getChildAt(i).setBackgroundResource(R.drawable.fondo); //no seleccionado
							RelativeLayout rl = (RelativeLayout) tabHost.getTabWidget().getChildAt(i);
					        TextView textView = (TextView) rl.getChildAt(1);//          
					        textView.setTextColor(Color.parseColor("#FFFFFF"));
					        textView.setTextSize(20);
					    }
						tabHost.getTabWidget().getChildAt(tabHost.getCurrentTab()).setBackgroundResource(R.drawable.fondo_claro); // selected
					}
				});
		        
				TabHost.TabSpec spec;
				Intent intent;
				
				//Nueva pestaña para los detalles del proyecto
				intent = new Intent().setClass(this, DetalleProyecto.class);
				spec = tabHost.newTabSpec("Detalles");
				spec.setIndicator("Detalles");
				spec.setContent(intent);
				tabHost.addTab(spec);
				
				//Nueva pestaña para el backlog
				intent = new Intent().setClass(this, Backlog.class);
				spec = tabHost.newTabSpec("Backlog");
				spec.setIndicator("Backlog");
				spec.setContent(intent);
				tabHost.addTab(spec);
				
				//Cambiar el color al texto
				tabHost.getTabWidget().getChildAt(1).setBackgroundResource(R.drawable.fondo);
				RelativeLayout rl = (RelativeLayout) tabHost.getTabWidget().getChildAt(1);
		        TextView textView = (TextView) rl.getChildAt(1);//          
		        textView.setTextColor(Color.parseColor("#FFFFFF"));
		        textView.setTextSize(20);
			}
}
