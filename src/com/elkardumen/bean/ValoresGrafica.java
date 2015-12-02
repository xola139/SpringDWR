package com.elkardumen.bean;

public class ValoresGrafica {

	private int occ;
	private double montos;
	private String fecha;
	private int ntransacciones;
	private String tipotransaccion;
	
	private String color;
	private int registros;
	
	
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public int getRegistros() {
		return registros;
	}
	public void setRegistros(int registros) {
		this.registros = registros;
	}
	public int getNtransacciones() {
		return ntransacciones;
	}
	public void setNtransacciones(int ntransacciones) {
		this.ntransacciones = ntransacciones;
	}
	public String getTipotransaccion() {
		return tipotransaccion;
	}
	public void setTipotransaccion(String tipotransaccion) {
		this.tipotransaccion = tipotransaccion;
	}
	
	
	
	
	
	public int getOcc() {
		return occ;
	}
	public void setOcc(int occ) {
		this.occ = occ;
	}
	public double getMontos() {
		return montos;
	}
	public void setMontos(double montos) {
		this.montos = montos;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	
	
}
