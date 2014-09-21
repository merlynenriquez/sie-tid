package pe.gob.mininter.dirandro.model;

import java.io.Serializable;
import java.math.BigDecimal;

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
 * The persistent class for the EXP_DET_PER_ARM_EXP database table.
 * 
 */
@Entity
@Table(name="EXP_DET_PER_ARM_EXP")
public class DetPerArmExp extends AuditoriaBean implements Validador, Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 669204553259119178L;

	@Id
	@SequenceGenerator(name="EXP_DET_PER_ARM_EXP_ID_GENERATOR", sequenceName="SEQ_", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="EXP_DET_PER_ARM_EXP_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=16)
	private Long id;

	@Column(name="CANTIDAD_MUNICION", precision=10)
	private BigDecimal cantidadMunicion;

	@Column(name="NRO_LICENCIA", length=20)
	private String nroLicencia;
	
	@Column(length=4000)
	private String observacion;

	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="ESTADO")
	private Valor estado;

	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="SITUACION")
	private Valor situacion;

	//bi-directional many-to-one association to Arma
	@ManyToOne
	@JoinColumn(name="ARMA")
	private Arma arma;

	//bi-directional many-to-one association to Expediente
	@ManyToOne
	@JoinColumn(name="EXPEDIENTE", nullable=false)
	private Expediente expediente;

	//bi-directional many-to-one association to Empresa
	@ManyToOne
	@JoinColumn(name="EMPRESA")
	private Empresa empresaImplicada;

	//bi-directional many-to-one association to Persona
	@ManyToOne
	@JoinColumn(name="PROPIETARIO")
	private Persona propietario;

	//bi-directional many-to-one association to Persona
	@ManyToOne
	@JoinColumn(name="PERSONA")
	private Persona personaImplicada;

	public DetPerArmExp() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getCantidadMunicion() {
		return this.cantidadMunicion;
	}

	public void setCantidadMunicion(BigDecimal cantidadMunicion) {
		this.cantidadMunicion = cantidadMunicion;
	}

	public String getObservacion() {
		return this.observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}
	
	public Valor getEstado() {
		return estado;
	}

	public void setEstado(Valor estado) {
		this.estado = estado;
	}

	public Valor getSituacion() {
		return situacion;
	}

	public void setSituacion(Valor situacion) {
		this.situacion = situacion;
	}

	public Arma getArma() {
		return arma;
	}

	public void setArma(Arma arma) {
		this.arma = arma;
	}

	public Expediente getExpediente() {
		return expediente;
	}

	public void setExpediente(Expediente expediente) {
		this.expediente = expediente;
	}

	public Empresa getEmpresaImplicada() {
		return empresaImplicada;
	}

	public void setEmpresaImplicada(Empresa empresaImplicada) {
		this.empresaImplicada = empresaImplicada;
	}

	public Persona getPropietario() {
		return propietario;
	}

	public void setPropietario(Persona propietario) {
		this.propietario = propietario;
	}

	public Persona getPersonaImplicada() {
		return personaImplicada;
	}

	public void setPersonaImplicada(Persona personaImplicada) {
		this.personaImplicada = personaImplicada;
	}

	public String getNroLicencia() {
		return nroLicencia;
	}

	public void setNroLicencia(String nroLicencia) {
		this.nroLicencia = nroLicencia;
	}

	@Override
	public void validar() {
		
	}

}