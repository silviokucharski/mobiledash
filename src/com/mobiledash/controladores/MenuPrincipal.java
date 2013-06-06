package com.mobiledash.controladores;

import com.dragdrop.R;

import android.app.TabActivity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.RelativeLayout;
import android.widget.TabHost;
import android.widget.TextView;

/**
 * Gestiona el menú principal y las acciones al presionar los botones
 */
@SuppressWarnings("deprecation")
public class MenuPrincipal extends TabActivity
{
	//Variables globales
		TabHost tabHost;
		
		@Override
		public void onCreate(Bundle savedInstanceState)
		{
			super.onCreate(savedInstanceState);
			setContentView(R.layout.menu_principal);
			
			tabHost = getTabHost();
			tabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
				
				public void onTabChanged(String arg0) {
					for(int i=0;i<tabHost.getTabWidget().getChildCount();i++)
				    {
						tabHost.getTabWidget().getChildAt(i).setBackgroundResource(R.drawable.fondo); //unselected
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
			
			//Nueva pestaña para el tablero
			intent = new Intent().setClass(this, Tablero.class);
			spec = tabHost.newTabSpec("Tablero").setIndicator("Tablero").setContent(intent);
			tabHost.addTab(spec);
			
			//Nueva pestaña para las EVA
			intent = new Intent().setClass(this, Eva.class);
			spec = tabHost.newTabSpec("EVA").setIndicator("EVA").setContent(intent);
			tabHost.addTab(spec);
			
			//Nueva pestaña para la gráfica
			intent = new Intent().setClass(this, Burndown.class);
			spec = tabHost.newTabSpec("Burndown").setIndicator("Burndown").setContent(intent);
			tabHost.addTab(spec);
			
			//Cambiar el color al texto
			tabHost.getTabWidget().getChildAt(1).setBackgroundResource(R.drawable.fondo);
			RelativeLayout rl = (RelativeLayout) tabHost.getTabWidget().getChildAt(1);
	        TextView textView = (TextView) rl.getChildAt(1);//          
	        textView.setTextColor(Color.parseColor("#FFFFFF"));
	        textView.setTextSize(20);
	        
	        tabHost.getTabWidget().getChildAt(2).setBackgroundResource(R.drawable.fondo);
	        RelativeLayout r2 = (RelativeLayout) tabHost.getTabWidget().getChildAt(2);
	        TextView tv = (TextView) r2.getChildAt(1);//          
	        tv.setTextColor(Color.parseColor("#FFFFFF"));
	        tv.setTextSize(20);
		}
}
