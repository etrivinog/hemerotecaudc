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
@Entity(name = "estados")
@NamedQuery(name="Estado.findAll", query="SELECT e FROM estados e")
public class Estado implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static final Integer AVAILABLE_STATUS = 1;
	public static final Integer UNAVAILABLE_STATUS = 2;
	
	@Id
	@Column(name="idestado")
	@SequenceGenerator(name="pk_estados_seq",sequenceName="pk_estados_seq", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="pk_estados_seq")
	private Integer idestado;
	
	@NotNull
	@Column(name="descripcion")
	private String descripcion;

	public Integer getIdestado() {
		return idestado;
	}

	public void setIdestado(Integer idestado) {
		this.idestado = idestado;
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
