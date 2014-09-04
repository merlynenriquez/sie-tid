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
 * The persistent class for the EXP_DET_DROGAS database table.
 * 
 */
@Entity
@Table(name="EXP_DET_DROGAS")
public class DetDroga extends AuditoriaBean implements Validador, Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="EXP_DET_DROGAS_ID_GENERATOR", sequenceName="SEQ_", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="EXP_DET_DROGAS_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=16)
	private Long id;

	@Column(name="LOGO_DESCRIPCION", length=4000)
	private String logoDescripcion;
	
	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="PARTICIPACION")
	private Valor participacion;

	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="ESTADO_PARTICIPACION")
	private Valor estadoParticipacion;
	
	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="MODALIDAD", nullable=false)
	private Valor modalidad;

	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="TRANSPORTE")
	private Valor transporte;

	//bi-directional many-to-one association to Adjunto
	@ManyToOne
	@JoinColumn(name="LOGO")
	private Adjunto adjuntoLogo;

	//bi-directional many-to-one association to Droga
	@ManyToOne
	@JoinColumn(name="DROGA")
	private Droga droga;

	//bi-directional many-to-one association to Persona
	@ManyToOne
	@JoinColumn(name="PERSONA")
	private Persona personaImplicada;

	public DetDroga() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogoDescripcion() {
		return logoDescripcion;
	}

	public void setLogoDescripcion(String logoDescripcion) {
		this.logoDescripcion = logoDescripcion;
	}

	public Valor getParticipacion() {
		return participacion;
	}

	public void setParticipacion(Valor participacion) {
		this.participacion = participacion;
	}

	public Valor getEstadoParticipacion() {
		return estadoParticipacion;
	}

	public void setEstadoParticipacion(Valor estadoParticipacion) {
		this.estadoParticipacion = estadoParticipacion;
	}

	public Valor getModalidad() {
		return modalidad;
	}

	public void setModalidad(Valor modalidad) {
		this.modalidad = modalidad;
	}

	public Valor getTransporte() {
		return transporte;
	}

	public void setTransporte(Valor transporte) {
		this.transporte = transporte;
	}

	public Adjunto getAdjuntoLogo() {
		return adjuntoLogo;
	}

	public void setAdjuntoLogo(Adjunto adjuntoLogo) {
		this.adjuntoLogo = adjuntoLogo;
	}

	public Droga getDroga() {
		return droga;
	}

	public void setDroga(Droga droga) {
		this.droga = droga;
	}

	public Persona getPersonaImplicada() {
		return personaImplicada;
	}

	public void setPersonaImplicada(Persona personaImplicada) {
		this.personaImplicada = personaImplicada;
	}

	@Override
	public void validar() {
		// TODO Auto-generated method stub
		
	}

}