package pe.gob.mininter.dirandro.model;

import java.io.Serializable;

import javax.persistence.*;

import pe.gob.mininter.dirandro.util.Validador;
import pe.gob.mininter.dirandro.util.beanbase.AuditoriaBean;

import java.sql.Timestamp;
import java.math.BigDecimal;


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
	@SequenceGenerator(name="EXP_DET_PER_ARM_EXP_ID_GENERATOR", sequenceName="SEQ_")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="EXP_DET_PER_ARM_EXP_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=16)
	private Long id;

	@Column(name="CANTIDAD_MUNICION", precision=10)
	private BigDecimal cantidadMunicion;

	@Column(length=800)
	private String observacion;

	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="ESTADO")
	private Valor cfgValor1;

	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="SITUACION")
	private Valor cfgValor2;

	//bi-directional many-to-one association to Arma
	@ManyToOne
	@JoinColumn(name="ARMA")
	private Arma expArma;

	//bi-directional many-to-one association to Expediente
	@ManyToOne
	@JoinColumn(name="EXPEDIENTE", nullable=false)
	private Expediente expExpediente;

	//bi-directional many-to-one association to Empresa
	@ManyToOne
	@JoinColumn(name="EMPRESA_PROPIETARIA")
	private Empresa perEmpresa;

	//bi-directional many-to-one association to Persona
	@ManyToOne
	@JoinColumn(name="PROPIETARIO")
	private Persona perPersona1;

	//bi-directional many-to-one association to Persona
	@ManyToOne
	@JoinColumn(name="PERSONA")
	private Persona perPersona2;

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

	public Valor getCfgValor1() {
		return this.cfgValor1;
	}

	public void setCfgValor1(Valor cfgValor1) {
		this.cfgValor1 = cfgValor1;
	}

	public Valor getCfgValor2() {
		return this.cfgValor2;
	}

	public void setCfgValor2(Valor cfgValor2) {
		this.cfgValor2 = cfgValor2;
	}

	public Arma getExpArma() {
		return this.expArma;
	}

	public void setExpArma(Arma expArma) {
		this.expArma = expArma;
	}

	public Expediente getExpExpediente() {
		return this.expExpediente;
	}

	public void setExpExpediente(Expediente expExpediente) {
		this.expExpediente = expExpediente;
	}

	public Empresa getPerEmpresa() {
		return this.perEmpresa;
	}

	public void setPerEmpresa(Empresa perEmpresa) {
		this.perEmpresa = perEmpresa;
	}

	public Persona getPerPersona1() {
		return this.perPersona1;
	}

	public void setPerPersona1(Persona perPersona1) {
		this.perPersona1 = perPersona1;
	}

	public Persona getPerPersona2() {
		return this.perPersona2;
	}

	public void setPerPersona2(Persona perPersona2) {
		this.perPersona2 = perPersona2;
	}
	
	@Override
	public void validar() {
		// TODO Auto-generated method stub
		
	}

}