package co.edu.unicartagena.dao;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

public class EjemplarDescriptionDao implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@NotNull
	private Integer idejemplar;
	
	@NotNull
	private String descripcion;
	
	public EjemplarDescriptionDao(@NotNull Integer idejemplar, @NotNull String descripcion) {
		super();
		this.idejemplar = idejemplar;
		this.descripcion = descripcion;
	}

	public Integer getIdejemplar() {
		return idejemplar;
	}

	public void setIdejemplar(Integer idejemplar) {
		this.idejemplar = idejemplar;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
