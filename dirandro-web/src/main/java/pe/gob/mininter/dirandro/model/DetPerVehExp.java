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
	@SequenceGenerator(name="EXP_DET_PER_VEH_EXP_ID_GENERATOR", sequenceName="SEQ_EXP_VEHICULO", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="EXP_DET_PER_VEH_EXP_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=16)
	private Long id;

	@Column(name="PLACA_MONTADA", length=100)
	private String placaMontada;

	@Column(name="TIPO_USO", length=100)
	private String tipoUso;
	
	@Column(length=4000)
	private String observacion;

	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="ESTADO")
	private Valor estado;

	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="SITUACION_LEGAL")
	private Valor situacionLegal;

	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="ESTADO_MOTOR")
	private Valor estadoMotor;

	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="ESTADO_CHASIS", nullable=false)
	private Valor estadoChasis;

	//bi-directional many-to-one association to Expediente
	@ManyToOne
	@JoinColumn(name="EXPEDIENTE", nullable=false)
	private Expediente expediente;

	//bi-directional many-to-one association to Vehiculo
	@ManyToOne
	@JoinColumn(name="VEHICULO")
	private Vehiculo vehiculo;

	//bi-directional many-to-one association to Persona
	@ManyToOne
	@JoinColumn(name="PERSONA")
	private Persona personaImplicada;
	
	//bi-directional many-to-one association to Persona
	@ManyToOne
	@JoinColumn(name="PROPIETARIO")
	private Persona propietario;

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

	public String getTipoUso() {
		return this.tipoUso;
	}

	public void setTipoUso(String tipoUso) {
		this.tipoUso = tipoUso;
	}

	public Valor getEstado() {
		return estado;
	}

	public void setEstado(Valor estado) {
		this.estado = estado;
	}

	public Valor getSituacionLegal() {
		return situacionLegal;
	}

	public void setSituacionLegal(Valor situacionLegal) {
		this.situacionLegal = situacionLegal;
	}

	public Valor getEstadoMotor() {
		return estadoMotor;
	}

	public void setEstadoMotor(Valor estadoMotor) {
		this.estadoMotor = estadoMotor;
	}

	public Valor getEstadoChasis() {
		return estadoChasis;
	}

	public void setEstadoChasis(Valor estadoChasis) {
		this.estadoChasis = estadoChasis;
	}

	public Expediente getExpediente() {
		return expediente;
	}

	public void setExpediente(Expediente expediente) {
		this.expediente = expediente;
	}

	public Vehiculo getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}

	public Persona getPersonaImplicada() {
		return personaImplicada;
	}

	public void setPersonaImplicada(Persona personaImplicada) {
		this.personaImplicada = personaImplicada;
	}

	public Persona getPropietario() {
		return propietario;
	}

	public void setPropietario(Persona propietario) {
		this.propietario = propietario;
	}

	public String getObservaciones() {
		return observacion;
	}

	public void setObservaciones(String observacion) {
		this.observacion = observacion;
	}

	@Override
	public void validar() {
		// TODO Auto-generated method stub
		
	}

}