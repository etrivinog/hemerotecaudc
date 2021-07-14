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
@Entity(name = "autenticaciones")
@NamedQuery(name="Autenticacion.findAll", query="SELECT a FROM autenticaciones a")
public class Autenticacion implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	@Id
	@Column(name="idautenticacion")
	@SequenceGenerator(name="pk_autenticaciones_seq",sequenceName="pk_autenticaciones_seq", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="pk_autenticaciones_seq")
	private Integer idAutenticacion;

	@NotNull
	@Column(name="nombreDeUsuario")
	private String nombre;

	@Column(name="codigoDeInicio")
	private String codigoDeInicio;

	@Column(name="nombres")
	private String nombres;

	@Column(name="apellidos")
	private String apellidos;

	@NotNull
	@Column(name="email")
	private String email;

	public Integer getIdAutenticacion() {
		return idAutenticacion;
	}

	public void setIdAutenticacion(Integer idAutenticacion) {
		this.idAutenticacion = idAutenticacion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCodigoDeInicio() {
		return codigoDeInicio;
	}

	public void setCodigoDeInicio(String codigoDeInicio) {
		this.codigoDeInicio = codigoDeInicio;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}
