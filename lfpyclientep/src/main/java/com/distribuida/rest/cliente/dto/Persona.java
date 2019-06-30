package com.distribuida.rest.cliente.dto;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * UNIVERSIDAD CENTRAL DEL ECUADOR
 * @author Luis Pantoja
 */

@XmlRootElement(name = "persona")
public class Persona implements Serializable {

	private static final long serialVersionUID = 1L;

	private int id;
	private String nombre;

	public Persona() {
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

}
