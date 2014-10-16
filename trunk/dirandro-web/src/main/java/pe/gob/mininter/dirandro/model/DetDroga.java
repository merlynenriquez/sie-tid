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
import javax.validation.constraints.NotNull;

import pe.gob.mininter.dirandro.util.Constante;
import pe.gob.mininter.dirandro.util.beanbase.AuditoriaBean;


/**
 * The persistent class for the EXP_DET_DROGAS database table.
 * 
 */
@Entity
@Table(name="EXP_DET_DROGAS")
public class DetDroga extends AuditoriaBean implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="EXP_DET_DROGAS_ID_GENERATOR", sequenceName="SEQ_DET_DROGA", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="EXP_DET_DROGAS_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=16)
	private Long id;

	@Deprecated
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
	@NotNull(message=Constante.CODIGO_MENSAJE.VALIDAR_COMBOBOX)
	private Valor modalidad;

	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="TRANSPORTE")
	@NotNull(message=Constante.CODIGO_MENSAJE.VALIDAR_COMBOBOX)
	private Valor transporte;

	//bi-directional many-to-one association to Adjunto
	@Deprecated
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
	@NotNull(message=Constante.CODIGO_MENSAJE.VALIDAR_COMBOBOX)
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
}