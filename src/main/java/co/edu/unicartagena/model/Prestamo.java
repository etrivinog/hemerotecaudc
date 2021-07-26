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
@Entity(name = "prestamos")
@NamedQuery(name="Prestamo.findAll", query="SELECT p FROM prestamos p")
public class Prestamo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	@Id
	@Column(name="idprestamos")
	@SequenceGenerator(name="pk_prestamos_seq",sequenceName="pk_prestamos_seq", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="pk_prestamos_seq")
	private Integer idprestamos;

	@NotNull
	@Column(name="fechainicio")
	private Date fechaInicio;

	@Column(name="fechafin")
	private Date fechaFin;

	@Column(name="idejemplar")
	private Integer idEjemplar;

	@Column(name="codEstudiante")
	private Integer codEstudiante;

	@Column(name="estado")
	private String estado;

	public Integer getIdprestamos() {
		return idprestamos;
	}

	public void setIdprestamos(Integer idprestamos) {
		this.idprestamos = idprestamos;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public Integer getIdEjemplar() {
		return idEjemplar;
	}

	public void setIdEjemplar(Integer idEjemplar) {
		this.idEjemplar = idEjemplar;
	}

	public Integer getCodEstudiante() {
		return codEstudiante;
	}

	public void setCodEstudiante(Integer codEstudiante) {
		this.codEstudiante = codEstudiante;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
}
