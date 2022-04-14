package Modelos;

import java.sql.Date;

public class Modelo_cls {
	private int id;
	private String nombre;
	private double precio;
	private int cantidad;
	private Date fechaInicio;
	
	
	public Modelo_cls(int id, String nombre, double precio, int cantidad, Date fechaInicio) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.precio = precio;
		this.cantidad = cantidad;
		this.fechaInicio = fechaInicio;
	}
	  
	
	public Modelo_cls() {
		// TODO Auto-generated constructor stub
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public double getPrecio() {
		return precio;
	}


	public void setPrecio(double precio) {
		this.precio = precio;
	}


	public int getCantidad() {
		return cantidad;
	}


	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}


	public Date getFechaInicio() {
		return fechaInicio;
	}


	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

}