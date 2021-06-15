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
 * @author AdrianaOtero
 *
 */
@Entity(name = "autores")
@NamedQuery(name="Autores.findAll", query="SELECT a FROM autores a")
public class Autor implements Serializable {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="autorid")
	@SequenceGenerator(name="sq_autor_id",sequenceName="sq_autor_id", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="sq_autor_id")
	private Integer autorId;
	
	@NotNull
	@Column(name="nombre")
	private String nombre;
	
	public Integer getAutorId() {
		return autorId;
	}

	public void setAutorId(Integer autorId) {
		this.autorId = autorId;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
