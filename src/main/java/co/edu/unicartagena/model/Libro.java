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
import javax.persistence.SequenceGenerator;
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
	@SequenceGenerator(name="pk_libros_seq",sequenceName="pk_libros_seq", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="pk_libros_seq")
	private Integer libroId;

	@NotNull
	@Column(name="nombre")
	private String nombre;

	@Column(name="referencia")
	private String referencia;

	@Column(name="fechaingreso")
	private Date fechaIngreso;

	@Column(name="anopublicacion")
	private Integer anio;

	@NotNull
	@Column(name="tiporegistro")
	private Integer tipoRegistro;

	@Column(name="numregistro")
	private String numRegistro;

	@NotNull
	@Column(name="tipo_de_divulgacion")
	private Integer tipoDivulgacion;
	
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
	
}
