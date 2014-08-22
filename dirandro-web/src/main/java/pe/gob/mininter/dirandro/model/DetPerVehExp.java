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
 * The persistent class for the EXP_DET_PER_VEH_EXP database table.
 * 
 */
@Entity
@Table(name="EXP_DET_PER_VEH_EXP")
public class DetPerVehExp extends AuditoriaBean implements Validador, Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 854763308193341749L;

	@Id
	@SequenceGenerator(name="EXP_DET_PER_VEH_EXP_ID_GENERATOR", sequenceName="SEQ_", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="EXP_DET_PER_VEH_EXP_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=16)
	private Long id;

	@Column(name="PLACA_MONTADA", length=100)
	private String placaMontada;

	@Column(precision=16)
	private BigDecimal propietario;

	@Column(name="TIPO_USO", length=100)
	private String tipoUso;

	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="ESTADO")
	private Valor cfgValor1;

	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="SITUACION_LEGAL")
	private Valor cfgValor2;

	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="ESTADO_MOTOR")
	private Valor cfgValor3;

	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="ESTADO_CHASIS", nullable=false)
	private Valor cfgValor4;

	//bi-directional many-to-one association to Expediente
	@ManyToOne
	@JoinColumn(name="EXPEDIENTE", nullable=false)
	private Expediente expExpediente;

	//bi-directional many-to-one association to Vehiculo
	@ManyToOne
	@JoinColumn(name="VEHICULO")
	private Vehiculo expVehiculo;

	//bi-directional many-to-one association to Persona
	@ManyToOne
	@JoinColumn(name="PERSONA")
	private Persona perPersona;

	public DetPerVehExp() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPlacaMontada() {
		return this.placaMontada;
	}

	public void setPlacaMontada(String placaMontada) {
		this.placaMontada = placaMontada;
	}

	public BigDecimal getPropietario() {
		return this.propietario;
	}

	public void setPropietario(BigDecimal propietario) {
		this.propietario = propietario;
	}

	public String getTipoUso() {
		return this.tipoUso;
	}

	public void setTipoUso(String tipoUso) {
		this.tipoUso = tipoUso;
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

	public Valor getCfgValor3() {
		return this.cfgValor3;
	}

	public void setCfgValor3(Valor cfgValor3) {
		this.cfgValor3 = cfgValor3;
	}

	public Valor getCfgValor4() {
		return this.cfgValor4;
	}

	public void setCfgValor4(Valor cfgValor4) {
		this.cfgValor4 = cfgValor4;
	}

	public Expediente getExpExpediente() {
		return this.expExpediente;
	}

	public void setExpExpediente(Expediente expExpediente) {
		this.expExpediente = expExpediente;
	}

	public Vehiculo getExpVehiculo() {
		return this.expVehiculo;
	}

	public void setExpVehiculo(Vehiculo expVehiculo) {
		this.expVehiculo = expVehiculo;
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