package com.krakedev.financiero.entidades;

public class Cliente {
	private String cedula;
	private String apellido;
	private String nombre;
	
	public Cliente(String cedula, String nombre, String apellido) {
		this.cedula = cedula;
		this.apellido = apellido;
		this.nombre = nombre;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void imprimir() {
		String mensaje = "Cedula: " + cedula + " Nombre: " + nombre + " Apellido: " + apellido;
		System.out.println(mensaje);
	}
}
