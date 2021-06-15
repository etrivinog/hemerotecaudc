/**
 * 
 */
package co.edu.unicartagena.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;

/**
 * @author AdrianaOtero *
 */
@Entity(name = "ejemplares")
@NamedQuery(name="Ejemplar.findAll", query="SELECT e FROM ejemplares e")
public class Ejemplar implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	@Id
	@Column(name="idejemplar")
	@SequenceGenerator(name="pk_ejemplares_seq",sequenceName="pk_ejemplares_seq", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="pk_ejemplares_seq")
	private Integer idejemplar;
	
	@NotNull
	@Column(name="descripcion")
	private String descripcion;
	
	@NotNull
	@Column(name="libroid")
	private Integer libroid;

	@NotNull
	@Column(name="idestado")
	private Integer idestado;

	public Integer getIdEjemplar() {
		return idejemplar;
	}

	public void setIdEjemplar(Integer idejemplar) {
		this.idejemplar = idejemplar;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Integer getLibroid() {
		return libroid;
	}

	public void setLibroid(Integer libroid) {
		this.libroid = libroid;
	}

	public Integer getIdestado() {
		return idestado;
	}

	public void setIdestado(Integer idestado) {
		this.idestado = idestado;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
