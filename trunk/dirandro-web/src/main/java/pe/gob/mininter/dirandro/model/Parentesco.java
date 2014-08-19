package pe.gob.mininter.dirandro.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import pe.gob.mininter.dirandro.util.Validador;
import pe.gob.mininter.dirandro.util.beanbase.AuditoriaBean;


/**
 * The persistent class for the PER_PARENTESCO database table.
 * 
 */
@Entity
@Table(name="PARENTESCO")
public class Parentesco extends AuditoriaBean implements Validador, Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1946559235893710683L;

	@Id
	@SequenceGenerator(name="PARENTESCO_ID_GENERATOR", sequenceName="SEQ_PARENTESCO")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PARENTESCO_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=16)
	private Long id;

	@Column(length=400)
	private String observacion;

	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="TIPO_RELACION")
	private Valor tipoRelacion;

	//bi-directional many-to-one association to Persona
	@ManyToOne
	@JoinColumn(name="PERSONA")
	private Persona persona;

	//bi-directional many-to-one association to Persona
	@ManyToOne
	@JoinColumn(name="PERSONA_PARIENTE")
	private Persona pariente;

	public Parentesco() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public Valor getTipoRelacion() {
		return tipoRelacion;
	}

	public void setTipoRelacion(Valor tipoRelacion) {
		this.tipoRelacion = tipoRelacion;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public Persona getPariente() {
		return pariente;
	}

	public void setPariente(Persona pariente) {
		this.pariente = pariente;
	}

	@Override
	public void validar() {
		// TODO Auto-generated method stub
		
	}
 
}