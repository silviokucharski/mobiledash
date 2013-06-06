package com.mobiledash.datos;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import android.util.Log;

public class CargaDatosWS {
	public String getTexto()
	{
		String texto = null;
		SoapObject rpc = new SoapObject("http://silviokucharski.com.ar/service/servicioTablero.php","getTexto");
		SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
		envelope.bodyOut = rpc;
		envelope.encodingStyle = SoapEnvelope.XSD;
		HttpTransportSE ht = null;
		try {
			String conexion = "http://silviokucharski.com.ar/service/servicioTablero.php";
			ht = new HttpTransportSE(conexion);
			ht.debug = true;
			ht.call("http://silviokucharski.com.ar/service/servicioTablero.php", envelope);
			Log.d("REQUEST", ht.requestDump);
			Log.d("RESPONSE", ht.responseDump);
			texto = envelope.getResponse().toString();
		}
		catch(Exception e)
		{
			texto = "";
		}
		return texto;
	}
}
