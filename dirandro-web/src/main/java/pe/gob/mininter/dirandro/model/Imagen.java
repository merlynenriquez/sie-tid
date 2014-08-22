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
 * The persistent class for the PER_IMAGEN database table.
 * 
 */
@Entity
@Table(name="PER_IMAGEN")
public class Imagen extends AuditoriaBean implements Validador, Serializable {
	
	private static final long serialVersionUID = -1186366091631764798L;

	@Id
	@SequenceGenerator(name="PER_IMAGEN_ID_GENERATOR", sequenceName="SEQ_IMAGEN", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PER_IMAGEN_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=16)
	private Long id;

	//bi-directional many-to-one association to Adjunto
	@ManyToOne
	@JoinColumn(name="IMAGEN")
	private Adjunto adjunto;

	//bi-directional many-to-one association to Persona
	@ManyToOne
	@JoinColumn(name="PERSONA")
	private Persona persona;

	public Imagen() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Adjunto getAdjunto() {
		return adjunto;
	}

	public void setAdjunto(Adjunto adjunto) {
		this.adjunto = adjunto;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	@Override
	public void validar() {
		// TODO Auto-generated method stub
	}

}