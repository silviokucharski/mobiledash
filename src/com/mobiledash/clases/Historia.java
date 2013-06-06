package com.mobiledash.clases;

import java.util.ArrayList;
import java.util.List;

import android.os.Parcel;
import android.os.Parcelable;

public class Historia implements Parcelable {
	private int idHistoria;
	private String nombre;
	private String icono;
	private String pruebas;
	private List<Tarea> tareas = new ArrayList<Tarea>();
	
	public Historia(int id, String nombre, String icono, String pruebas, ArrayList<Tarea> tareas) 
	{
		this.idHistoria = id;
		this.nombre = nombre;
		this.icono = icono;
		this.pruebas = pruebas;
		this.tareas = tareas;
	}
	
	public Historia() {
		tareas = new ArrayList<Tarea>();
	}
	
	public Historia(Parcel parcel) {
		readToParcel(parcel);
	}
	
	public void readToParcel(Parcel parcel){
		idHistoria = parcel.readInt();
		nombre = parcel.readString();
		icono = parcel.readString();
		pruebas = parcel.readString();
		parcel.readTypedList(tareas, Tarea.CREATOR);
	}
	
	public static final Parcelable.Creator<Historia> CREATOR = new Parcelable.Creator<Historia>() {
		public Historia createFromParcel(Parcel parcel) {
			return new Historia(parcel);
		}

		public Historia[] newArray(int size) {
			return new Historia[size];
		}
	};
	
	public void writeToParcel(Parcel parcel, int flags) {
		parcel.writeInt(idHistoria);
		parcel.writeString(nombre);
		parcel.writeString(icono);
		parcel.writeString(pruebas);
		parcel.writeTypedList(tareas);
	}
	
	public int describeContents() {
		return 0;
	}

	public int getIdHistoria() {
		return idHistoria;
	}

	public void setIdHistoria(int idHistoria) {
		this.idHistoria = idHistoria;
	}
	public String getIcono() {
		return icono;
	}
	
	public void setIcono(String icono) {
		this.icono = icono;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the pruebas
	 */
	public String getPruebas() {
		return pruebas;
	}

	/**
	 * @param pruebas the pruebas to set
	 */
	public void setPruebas(String pruebas) {
		this.pruebas = pruebas;
	}

	/**
	 * @return the tareas
	 */
	public List<Tarea> getTareas() {
		return tareas;
	}

	/**
	 * @param tareas the tareas to set
	 */
	public void setTareas(ArrayList<Tarea> tareas) {
		this.tareas = tareas;
	}
	
}
