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

@Entity(name = "recursos")
@NamedQuery(name="Recurso.findAll", query="SELECT r FROM recursos r")
public class Recurso  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	@Id
	@Column(name="recursoid")
	@SequenceGenerator(name="pk_recursos_seq",sequenceName="pk_recursos_seq", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="pk_recursos_seq")
	private int recursoId;

	@NotNull
	@Column(name="cohortecade")
	private String cohorteCade;
	
	@Column(name="cohortenal")
	private String cohorteNal;

	@Column(name="titulo")
	private String titulo;

	@Column(name="lineaformacion")
	private String lineaFormacion;

	@Column(name="directornacional")
	private String directorNacional;

	@Column(name="directorinternac")
	private String directorInternac;

	@Column(name="enlace")
	private String enlace;

	public int getRecursoId() {
		return recursoId;
	}

	public void setRecursoId(int recursoId) {
		this.recursoId = recursoId;
	}

	public String getCohorteCade() {
		return cohorteCade;
	}

	public void setCohorteCade(String cohorteCade) {
		this.cohorteCade = cohorteCade;
	}

	public String getCohorteNal() {
		return cohorteNal;
	}

	public void setCohorteNal(String cohorteNal) {
		this.cohorteNal = cohorteNal;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getLineaFormacion() {
		return lineaFormacion;
	}

	public void setLineaFormacion(String lineaFormacion) {
		this.lineaFormacion = lineaFormacion;
	}

	public String getDirectorNacional() {
		return directorNacional;
	}

	public void setDirectorNacional(String directorNacional) {
		this.directorNacional = directorNacional;
	}

	public String getDirectorInternac() {
		return directorInternac;
	}

	public void setDirectorInternac(String directorInternac) {
		this.directorInternac = directorInternac;
	}

	public String getEnlace() {
		return enlace;
	}

	public void setEnlace(String enlace) {
		this.enlace = enlace;
	}
	
}
