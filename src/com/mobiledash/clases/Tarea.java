package com.mobiledash.clases;

import android.os.Parcel;
import android.os.Parcelable;

public class Tarea implements Parcelable{

	private int idTarea;
	private String titulo;
	private String detalle;
	private int trabajoCalculado;
	private int trabajoConsumido;
	private String comentarios;
	
	public Tarea(int id, String titulo, String detalle, int trabajoCalculado, int trabajoConsumido, String comentarios){
		this.idTarea = id;
		this.titulo = titulo;
		this.detalle = detalle;
		this.trabajoCalculado = trabajoCalculado;
		this.trabajoConsumido = trabajoConsumido;
		this.comentarios = comentarios;
	}
	
	public Tarea() {
		
	}
	
	public Tarea(Parcel parcel) {
		readToParcel(parcel);
	}
	
	public static final Parcelable.Creator<Tarea> CREATOR = new Parcelable.Creator<Tarea>() {
		public Tarea createFromParcel(Parcel parcel) {
			return new Tarea(parcel);
		}

		public Tarea[] newArray(int size) {
			return new Tarea[size];
		}
	};
	
	public void writeToParcel(Parcel parcel, int flags) {
		parcel.writeInt(idTarea);
		parcel.writeString(titulo);
		parcel.writeString(detalle);
		parcel.writeInt(trabajoCalculado);
		parcel.writeInt(trabajoConsumido);
		parcel.writeString(comentarios);
	}
	
	public void readToParcel(Parcel parcel){
		idTarea = parcel.readInt();
		titulo = parcel.readString();
		detalle = parcel.readString();
		trabajoCalculado = parcel.readInt();
		trabajoConsumido = parcel.readInt();
		comentarios = parcel.readString();
	}
	
	@Override
	public int describeContents() {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * @return the idTarea
	 */
	public int getIdTarea() {
		return idTarea;
	}

	/**
	 * @param idTarea the idTarea to set
	 */
	public void setIdTarea(int idTarea) {
		this.idTarea = idTarea;
	}

	/**
	 * @return the titulo
	 */
	public String getTitulo() {
		return titulo;
	}

	/**
	 * @param titulo the titulo to set
	 */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	/**
	 * @return the detalle
	 */
	public String getDetalle() {
		return detalle;
	}

	/**
	 * @param detalle the detalle to set
	 */
	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}

	/**
	 * @return the trabajoCalculado
	 */
	public int getTrabajoCalculado() {
		return trabajoCalculado;
	}

	/**
	 * @param trabajoCalculado the trabajoCalculado to set
	 */
	public void setTrabajoCalculado(int trabajoCalculado) {
		this.trabajoCalculado = trabajoCalculado;
	}

	/**
	 * @return the trabajoConsumido
	 */
	public int getTrabajoConsumido() {
		return trabajoConsumido;
	}

	/**
	 * @param trabajoConsumido the trabajoConsumido to set
	 */
	public void setTrabajoConsumido(int trabajoConsumido) {
		this.trabajoConsumido = trabajoConsumido;
	}

	/**
	 * @return the comentarios
	 */
	public String getComentarios() {
		return comentarios;
	}

	/**
	 * @param comentarios the comentarios to set
	 */
	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}

}
