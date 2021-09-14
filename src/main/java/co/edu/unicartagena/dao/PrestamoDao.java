/**
 * 
 */
package co.edu.unicartagena.dao;

import java.io.Serializable;
import java.sql.Date;

import javax.validation.constraints.NotNull;

/**
 * @author AdrianaOtero
 *
 */
public class PrestamoDao implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

	@NotNull
	private Integer idprestamos;
	@NotNull
	private Date fechaInicio;
	private Date fechaFin;
	private Integer idLibro;
	private String libroTittle;
	private Integer idEjemplar;
	private String ejemplarDesc;
	private String codEstudiante;
	private String estado;

	public PrestamoDao(@NotNull Integer idprestamos, @NotNull Date fechaInicio, Date fechaFin, Integer idLibro,
			String libroTittle, Integer idEjemplar, String ejemplarDesc, String codEstudiante, String estado) {
		super();
		this.idprestamos = idprestamos;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.idLibro = idLibro;
		this.libroTittle = libroTittle;
		this.idEjemplar = idEjemplar;
		this.ejemplarDesc = ejemplarDesc;
		this.codEstudiante = codEstudiante;
		this.estado = estado;
	}

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

	public Integer getIdLibro() {
		return idLibro;
	}

	public void setIdLibro(Integer idLibro) {
		this.idLibro = idLibro;
	}

	public String getLibroTittle() {
		return libroTittle;
	}

	public void setLibroTittle(String libroTittle) {
		this.libroTittle = libroTittle;
	}

	public String getEjemplarDesc() {
		return ejemplarDesc;
	}

	public void setEjemplarDesc(String ejemplarDesc) {
		this.ejemplarDesc = ejemplarDesc;
	}

	public Integer getIdEjemplar() {
		return idEjemplar;
	}

	public void setIdEjemplar(Integer idEjemplar) {
		this.idEjemplar = idEjemplar;
	}

	public String getCodEstudiante() {
		return codEstudiante;
	}

	public void setCodEstudiante(String codEstudiante) {
		this.codEstudiante = codEstudiante;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
}
