package com.mobiledash.controladores;

import java.util.Arrays;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import com.androidplot.xy.SimpleXYSeries;
import com.androidplot.series.XYSeries;
import com.androidplot.xy.*;
import com.dragdrop.R;

public class Burndown extends Activity{
	
	private XYPlot grafica;
	
	@Override
	  public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.burndown);
	    
	 // Inicializamos el objeto XYPlot búscandolo desde el layout:
        grafica = (XYPlot) findViewById(R.id.grafica);
 
        // Creamos un array de prueba. En el caso real debemos reemplazar
        // estos datos por los que realmente queremos mostrar
        Number[] series1Numbers = {40, 25, 19, 10, 1, 0};
        Number[] series2Numbers = {40, 32, 24, 16, 8, 0};
 
        // Añadimos Línea Número UNO:
        XYSeries series1 = new SimpleXYSeries(
                Arrays.asList(series1Numbers),  // Array de datos
                SimpleXYSeries.ArrayFormat.Y_VALS_ONLY, // Sólo valores verticales
                "Completado"); // Nombre de la primera serie
 
        // Repetimos para la segunda serie
        XYSeries series2 = new SimpleXYSeries(
        		Arrays.asList(series2Numbers), 
        		SimpleXYSeries.ArrayFormat.Y_VALS_ONLY,
        		"Objetivo");
 
        // Modificamos los colores de la primera serie
        LineAndPointFormatter series1Format = new LineAndPointFormatter(
                Color.rgb(0, 200, 0),                   // Color de la línea
                Color.rgb(0, 100, 0));              // Relleno
 
        // Una vez definida la serie (datos y estilo), la añadimos al panel
        grafica.addSeries(series2, new LineAndPointFormatter
        		(Color.rgb(0, 0, 200), Color.rgb(0, 0, 100)));
        // Repetimos para la segunda serie
        grafica.addSeries(series1, series1Format);

        grafica.setDomainLabel("");
        grafica.setRangeLabel("");
    }
}
