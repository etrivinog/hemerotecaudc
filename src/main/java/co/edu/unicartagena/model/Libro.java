/**
 * 
 */
package co.edu.unicartagena.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.validation.constraints.NotNull;

/**
 * @author AdrianaOtero
 *
 */
@Entity(name = "libros")
@NamedQuery(name="Libro.findAll", query="SELECT l FROM libros l")
public class Libro implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	@Id
	@Column(name="libroid")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer libroId;

	@NotNull
	@Column(name="nombre")
	private String nombre;

	@Column(name="referencia")
	private String referencia;

	@Column(name="fechaingreso")
	private Date fechaIngreso;

	@Column(name="anopublicacion")
	private String anio;

	@NotNull
	@Column(name="tiporegistro")
	private String tipoRegistro;

	@Column(name="numregistro")
	private String numRegistro;

	@NotNull
	@Column(name="tipo_de_divulgacion")
	private String tipoDivulgacion;
	
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

	public String getAnio() {
		return anio;
	}

	public void setAnio(String anio) {
		this.anio = anio;
	}

	public String getTipoRegistro() {
		return tipoRegistro;
	}

	public void setTipoRegistro(String tipoRegistro) {
		this.tipoRegistro = tipoRegistro;
	}

	public String getNumRegistro() {
		return numRegistro;
	}

	public void setNumRegistro(String numRegistro) {
		this.numRegistro = numRegistro;
	}

	public String getTipoDivulgacion() {
		return tipoDivulgacion;
	}

	public void setTipoDivulgacion(String tipoDivulgacion) {
		this.tipoDivulgacion = tipoDivulgacion;
	}
	
}
