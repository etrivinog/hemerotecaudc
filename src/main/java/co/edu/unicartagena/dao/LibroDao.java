/**
 * 
 */
package co.edu.unicartagena.dao;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;

/**
 * @author AdrianaOtero
 *
 */
public class LibroDao implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	@NotNull
	private Integer libroId;

	@NotNull
	@Column(name="nombre")
	private String nombre;

	@NotNull
	private String referencia;
	
	private Date fechaIngreso;

	private Integer anio;

	private Integer disponibles;

	@NotNull
	private Integer tipoRegistro;

	private String numRegistro;

	@NotNull
	private Integer tipoDivulgacion;
	
	public LibroDao(@NotNull Integer libroId, @NotNull String nombre, @NotNull String referencia, Date fechaIngreso,
			Integer anio, Integer disponibles, @NotNull Integer tipoRegistro, String numRegistro,
			@NotNull Integer tipoDivulgacion) {
		super();
		this.libroId = libroId;
		this.nombre = nombre;
		this.referencia = referencia;
		this.fechaIngreso = fechaIngreso;
		this.anio = anio;
		this.disponibles = disponibles;
		this.tipoRegistro = tipoRegistro;
		this.numRegistro = numRegistro;
		this.tipoDivulgacion = tipoDivulgacion;
	}

	public Integer getLibroId() {
		return libroId;
	}

	public void setLibroId(Integer libroId) {
		this.libroId = libroId;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getReferencia() {
		return referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

	public Date getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public Integer getAnio() {
		return anio;
	}

	public void setAnio(Integer anio) {
		this.anio = anio;
	}

	public Integer getTipoRegistro() {
		return tipoRegistro;
	}

	public void setTipoRegistro(Integer tipoRegistro) {
		this.tipoRegistro = tipoRegistro;
	}

	public String getNumRegistro() {
		return numRegistro;
	}

	public void setNumRegistro(String numRegistro) {
		this.numRegistro = numRegistro;
	}

	public Integer getTipoDivulgacion() {
		return tipoDivulgacion;
	}

	public void setTipoDivulgacion(Integer tipoDivulgacion) {
		this.tipoDivulgacion = tipoDivulgacion;
	}

	public Integer getDisponibles() {
		return disponibles;
	}

	public void setDisponibles(Integer disponibles) {
		this.disponibles = disponibles;
	}
	
}
