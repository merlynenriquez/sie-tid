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

	@Column(precision=16)
	private BigDecimal modalidad;

	@Column(precision=16)
	private BigDecimal transporte;

	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="PARTICIPACION")
	private Valor cfgValor1;

	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="ESTADO_PARTICIPACION")
	private Valor cfgValor2;

	//bi-directional many-to-one association to Droga
	@ManyToOne
	@JoinColumn(name="DROGA")
	private Droga expDroga;

	//bi-directional many-to-one association to Persona
	@ManyToOne
	@JoinColumn(name="PERSONA")
	private Persona perPersona;

	public DetDroga() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getModalidad() {
		return this.modalidad;
	}

	public void setModalidad(BigDecimal modalidad) {
		this.modalidad = modalidad;
	}

	public BigDecimal getTransporte() {
		return this.transporte;
	}

	public void setTransporte(BigDecimal transporte) {
		this.transporte = transporte;
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

	public Droga getExpDroga() {
		return this.expDroga;
	}

	public void setExpDroga(Droga expDroga) {
		this.expDroga = expDroga;
	}

	public Persona getPerPersona() {
		return this.perPersona;
	}

	public void setPerPersona(Persona perPersona) {
		this.perPersona = perPersona;
	}

	@Override
	public void validar() {
		// TODO Auto-generated method stub
		
	}

}