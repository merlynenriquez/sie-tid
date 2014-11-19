package pe.gob.mininter.dirandro.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import pe.gob.mininter.dirandro.util.beanbase.AuditoriaBean;


/**
 * The persistent class for the INT_INTELIGENCIA database table.
 * 
 */
@Entity
@Table(name="INT_INTELIGENCIA")
public class Inteligencia extends AuditoriaBean implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="INT_INTELIGENCIA_ID_GENERATOR", sequenceName="SEQ_INT_INTELIGENCIA")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="INT_INTELIGENCIA_ID_GENERATOR")
	private Long id;

	private String autogenerado;

	private Expediente expediente;

	private Date fecha;

	private String nombre;
 
	public Inteligencia() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAutogenerado() {
		return autogenerado;
	}

	public void setAutogenerado(String autogenerado) {
		this.autogenerado = autogenerado;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Expediente getExpediente() {
		return expediente;
	}

	public void setExpediente(Expediente expediente) {
		this.expediente = expediente;
	}


}