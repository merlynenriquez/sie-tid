package pe.gob.mininter.dirandro.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

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
 * The persistent class for the EXP_DET_EXPEDIENTE_PERSONA database table.
 * 
 */
@Entity
@Table(name="EXP_DET_EXPEDIENTE_PERSONA")
public class DetExpedientePersona extends AuditoriaBean implements Validador, Serializable {
	
	private static final long serialVersionUID = -3388910551739102700L;

	@Id
	@SequenceGenerator(name="EXP_DET_EXPEDIENTE_PERSONA_ID_GENERATOR", sequenceName="SEQ_", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="EXP_DET_EXPEDIENTE_PERSONA_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=16)
	private Long id;

	@Column(name="ALIAS", length=400)
	private String alias;

	@Column(name="ESTADO_DATO", precision=16)
	private BigDecimal estadoDato;

	private Timestamp intervencion;

	@Column(precision=16)
	private BigDecimal ocupacion;

	@Column(precision=1)
	private BigDecimal requisitoria;

	@Column(name="TIPO_PARTICIPACION", precision=16)
	private BigDecimal tipoParticipacion;

	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="SITUACION")
	private Valor situacion;

	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="PARTICIPACION")
	private Valor participacion;

	//bi-directional many-to-one association to Expediente
	@ManyToOne
	@JoinColumn(name="EXPEDIENTE", nullable=false)
	private Expediente expediente;

	//bi-directional many-to-one association to Organizacion
	@ManyToOne
	@JoinColumn(name="ORGANIZACION")
	private Organizacion organizacion;

	//bi-directional many-to-one association to Empresa
	@ManyToOne
	@JoinColumn(name="EMPRESA")
	private Empresa empresaInvolucrada;

	//bi-directional many-to-one association to Persona
	@ManyToOne
	@JoinColumn(name="INVOLUCRADO")
	private Persona involucrado;
	
	public DetExpedientePersona() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public BigDecimal getEstadoDato() {
		return estadoDato;
	}

	public void setEstadoDato(BigDecimal estadoDato) {
		this.estadoDato = estadoDato;
	}

	public Timestamp getIntervencion() {
		return intervencion;
	}

	public void setIntervencion(Timestamp intervencion) {
		this.intervencion = intervencion;
	}

	public BigDecimal getOcupacion() {
		return ocupacion;
	}

	public void setOcupacion(BigDecimal ocupacion) {
		this.ocupacion = ocupacion;
	}

	public BigDecimal getRequisitoria() {
		return requisitoria;
	}

	public void setRequisitoria(BigDecimal requisitoria) {
		this.requisitoria = requisitoria;
	}

	public BigDecimal getTipoParticipacion() {
		return tipoParticipacion;
	}

	public void setTipoParticipacion(BigDecimal tipoParticipacion) {
		this.tipoParticipacion = tipoParticipacion;
	}
	
	public Valor getSituacion() {
		return situacion;
	}

	public void setSituacion(Valor situacion) {
		this.situacion = situacion;
	}

	public Valor getParticipacion() {
		return participacion;
	}

	public void setParticipacion(Valor participacion) {
		this.participacion = participacion;
	}

	public Expediente getExpediente() {
		return expediente;
	}

	public void setExpediente(Expediente expediente) {
		this.expediente = expediente;
	}

	public Organizacion getOrganizacion() {
		return organizacion;
	}

	public void setOrganizacion(Organizacion organizacion) {
		this.organizacion = organizacion;
	}

	public Empresa getEmpresaInvolucrada() {
		return empresaInvolucrada;
	}

	public void setEmpresaInvolucrada(Empresa empresaInvolucrada) {
		this.empresaInvolucrada = empresaInvolucrada;
	}

	public Persona getInvolucrado() {
		return involucrado;
	}

	public void setInvolucrado(Persona involucrado) {
		this.involucrado = involucrado;
	}
	
	public String getNombreCompleto(){
		return involucrado.getNombreCompleto();
	}

	@Override
	public void validar() {
		// TODO Auto-generated method stub
		
	}

}