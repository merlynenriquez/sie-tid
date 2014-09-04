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
 * The persistent class for the HR_HOJAREMISION database table.
 * 
 */
@Entity
@Table(name="HR_HOJAREMISION")
public class Hojaremision extends AuditoriaBean implements Validador, Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7410875204571125889L;

	@Id
	@SequenceGenerator(name="HR_HOJAREMISION_ID_GENERATOR", sequenceName="SEQ_", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="HR_HOJAREMISION_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=16)
	private Long id;

	@Column(name="COSTO_TRASLADO", precision=10, scale=2)
	private BigDecimal costoTraslado;

	@Column(name="FECHA_EMISION")
	private Timestamp fechaEmision;

	@Column(name="FECHA_RECEPCION")
	private Timestamp fechaRecepcion;

	@Column(name="FECHA_TRASLADO")
	private Timestamp fechaTraslado;

	@Column(name="MOTIVO_TRASLADO", length=800)
	private String motivoTraslado;

	@Column(name="NRO_LICENCIA", length=100)
	private String nroLicencia;

	@Column(precision=22)
	private String numero;

	@Column(length=400)
	private String observacion;

	@Column(length=400)
	private String oficio;

	@Column(name="VEHICULO_PLACA", length=100)
	private String vehiculoPlaca;

	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="TIPO_HR")
	private Valor TipoHr;

	//bi-directional many-to-one association to Dependencia
	@ManyToOne
	@JoinColumn(name="DEPENDENCIA_REMITE")
	private Dependencia expDependencia1;

	//bi-directional many-to-one association to Dependencia
	@ManyToOne
	@JoinColumn(name="DEPENDENCIA_DESTINO")
	private Dependencia expDependencia2;

	//bi-directional many-to-one association to Expediente
	@ManyToOne
	@JoinColumn(name="EXPEDIENTE")
	private Expediente expExpediente;

	//bi-directional many-to-one association to ModeloMarca
	@ManyToOne
	@JoinColumn(name="VEHICULO_MARCA", nullable=false)
	private ModeloMarca mntModeloMarca;

	//bi-directional many-to-one association to Persona
	@ManyToOne
	@JoinColumn(name="PERSONA")
	private Persona persona;

	//bi-directional many-to-one association to Policia
	@ManyToOne
	@JoinColumn(name="CUSTODIO")
	private Policia custodio;

	public Hojaremision() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getCostoTraslado() {
		return costoTraslado;
	}

	public void setCostoTraslado(BigDecimal costoTraslado) {
		this.costoTraslado = costoTraslado;
	}

	public Timestamp getFechaEmision() {
		return fechaEmision;
	}

	public void setFechaEmision(Timestamp fechaEmision) {
		this.fechaEmision = fechaEmision;
	}

	public Timestamp getFechaRecepcion() {
		return fechaRecepcion;
	}

	public void setFechaRecepcion(Timestamp fechaRecepcion) {
		this.fechaRecepcion = fechaRecepcion;
	}

	public Timestamp getFechaTraslado() {
		return fechaTraslado;
	}

	public void setFechaTraslado(Timestamp fechaTraslado) {
		this.fechaTraslado = fechaTraslado;
	}

	public String getMotivoTraslado() {
		return motivoTraslado;
	}

	public void setMotivoTraslado(String motivoTraslado) {
		this.motivoTraslado = motivoTraslado;
	}

	public String getNroLicencia() {
		return nroLicencia;
	}

	public void setNroLicencia(String nroLicencia) {
		this.nroLicencia = nroLicencia;
	}	

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public String getOficio() {
		return oficio;
	}

	public void setOficio(String oficio) {
		this.oficio = oficio;
	}

	public String getVehiculoPlaca() {
		return vehiculoPlaca;
	}

	public void setVehiculoPlaca(String vehiculoPlaca) {
		this.vehiculoPlaca = vehiculoPlaca;
	}

	public Valor getTipoHr() {
		return TipoHr;
	}

	public void setTipoHr(Valor tipoHr) {
		TipoHr = tipoHr;
	}

	public Dependencia getExpDependencia1() {
		return expDependencia1;
	}

	public void setExpDependencia1(Dependencia expDependencia1) {
		this.expDependencia1 = expDependencia1;
	}

	public Dependencia getExpDependencia2() {
		return expDependencia2;
	}

	public void setExpDependencia2(Dependencia expDependencia2) {
		this.expDependencia2 = expDependencia2;
	}

	public Expediente getExpExpediente() {
		return expExpediente;
	}

	public void setExpExpediente(Expediente expExpediente) {
		this.expExpediente = expExpediente;
	}

	public ModeloMarca getMntModeloMarca() {
		return mntModeloMarca;
	}

	public void setMntModeloMarca(ModeloMarca mntModeloMarca) {
		this.mntModeloMarca = mntModeloMarca;
	}
	
	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public Policia getCustodio() {
		return custodio;
	}

	public void setCustodio(Policia custodio) {
		this.custodio = custodio;
	}

	@Override
	public void validar() {
		// TODO Auto-generated method stub
		
	}
 
}