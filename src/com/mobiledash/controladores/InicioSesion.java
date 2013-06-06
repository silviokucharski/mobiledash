package com.mobiledash.controladores;

import com.dragdrop.R;
import com.mobiledash.datos.CargaDatosWS;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.ComponentName;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class InicioSesion extends Activity{
	ProgressDialog pd;
	String res;
	
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.inicio_sesion);
	}
	
	public void inicioSesionClick(View v)
	{
		new TareaEnBackground().execute("");
		pd = ProgressDialog.show(this, "","Iniciando sesión...", true, false);
	}
	
	private class TareaEnBackground extends AsyncTask<String, Void, Object>
	{
		@Override
		protected Integer doInBackground(String... args) {
			CargaDatosWS ws=new CargaDatosWS();
			res=ws.getTexto();
			return 1;
		}

		@Override
		protected void onPostExecute(Object result) {
			//Se elimina la pantalla de por favor espere.
			pd.dismiss();
			super.onPostExecute(result);
    		if(!res.equals(""))
    		{
    			Intent intent = new Intent();
    			intent.setComponent(new ComponentName(InicioSesion.this, Proyectos.class));
            	startActivity(intent);
    		}
    		else
    		{
    			Intent intent = new Intent();
    			intent.setComponent(new ComponentName(InicioSesion.this, Proyectos.class));
            	startActivity(intent);
            	
            	
    			Toast toast = Toast.makeText(InicioSesion.this, "No se pudo iniciar sesión...", Toast.LENGTH_LONG);
    			toast.show();
    		}
		}
	}
}
