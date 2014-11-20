package pe.gob.mininter.dirandro.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
	@SequenceGenerator(name="INT_INTELIGENCIA_ID_GENERATOR", sequenceName="SEQ_INT_INTELIGENCIA", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="INT_INTELIGENCIA_ID_GENERATOR")
	private Long id;

	private String autogenerado;

	//bi-directional many-to-one association to Organizacion
	@ManyToOne
	@JoinColumn(name="EXPEDIENTE")
	private Expediente expediente;

	@Column(name="FECHA")
	private Date fechaApertura;

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

	public Date getFechaApertura() {
		return fechaApertura;
	}

	public void setFechaApertura(Date fechaApertura) {
		this.fechaApertura = fechaApertura;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Inteligencia other = (Inteligencia) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}