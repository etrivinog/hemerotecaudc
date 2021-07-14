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
@Entity(name = "estudiantes")
@NamedQuery(name="Estudiante.findAll", query="SELECT e FROM estudiantes e")
public class Estudiante implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	@Id
	@Column(name="idestudiante")
	@SequenceGenerator(name="pk_estudiantes_seq",sequenceName="pk_estudiantes_seq", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="pk_estudiantes_seq")
	private Integer idEstudiante;

	@NotNull
	@Column(name="nombres")
	private String nombres;
	
	@NotNull
	@Column(name="apellidos")
	private String apellidos;

	@Column(name="email")
	private String email;

	@Column(name="telefono")
	private String telefono;

	@Column(name="codigo_estudiantil")
	private String codigo_estudiantil;

	@NotNull
	@Column(name="identificacion")
	private String identificacion;

	@NotNull
	@Column(name="idtipoidentificacion")
	private Integer idtipoidentificacion;

	@NotNull
	@Column(name="pass")
	private String pass;

	public Integer getIdEstudiante() {
		return idEstudiante;
	}

	public void setIdEstudiante(Integer idEstudiante) {
		this.idEstudiante = idEstudiante;
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

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCodigo_estudiantil() {
		return codigo_estudiantil;
	}

	public void setCodigo_estudiantil(String codigo_estudiantil) {
		this.codigo_estudiantil = codigo_estudiantil;
	}

	public String getIdentificacion() {
		return identificacion;
	}

	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}

	public Integer getIdtipoidentificacion() {
		return idtipoidentificacion;
	}

	public void setIdtipoidentificacion(Integer idtipoidentificacion) {
		this.idtipoidentificacion = idtipoidentificacion;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}
	
}
