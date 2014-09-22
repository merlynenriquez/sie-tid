package pe.gob.mininter.dirandro.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import pe.gob.mininter.dirandro.exception.ValidacionException;
import pe.gob.mininter.dirandro.util.Constante;
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
	@SequenceGenerator(name="HR_HOJAREMISION_ID_GENERATOR", sequenceName="SEQ_HOJAREMISION", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="HR_HOJAREMISION_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=16)
	private Long id;

	@Column(name="COSTO_TRASLADO", precision=10, scale=2)
	private BigDecimal costoTraslado;

	@Column(name="FECHA_EMISION")
	private Date fechaEmision;

	@Column(name="FECHA_RECEPCION")
	private Date fechaRecepcion;

	@Column(name="FECHA_TRASLADO")
	private Date fechaTraslado;

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
	private Valor tipoHr;

	//bi-directional many-to-one association to Dependencia
	@ManyToOne
	@JoinColumn(name="DEPENDENCIA_REMITE")
	private Dependencia origen;

	//bi-directional many-to-one association to Dependencia
	@ManyToOne
	@JoinColumn(name="DEPENDENCIA_DESTINO")
	private Dependencia destino;

	//bi-directional many-to-one association to Expediente
	@ManyToOne
	@JoinColumn(name="EXPEDIENTE")
	private Expediente expediente;

	//bi-directional many-to-one association to ModeloMarca
	@ManyToOne
	@JoinColumn(name="VEHICULO_MARCA", nullable=false)
	private ModeloMarca vehiculoMarca;

	//bi-directional many-to-one association to Persona
	@ManyToOne
	@JoinColumn(name="PERSONA")
	private Persona conductor;

	//bi-directional many-to-one association to Policia
	@ManyToOne
	@JoinColumn(name="CUSTODIO")
	private Policia custodio;

	public Hojaremision() {
	}

	public boolean esNuevo(){
		return id == null || id.longValue() == 0;
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

	public Date getFechaEmision() {
		return fechaEmision;
	}

	public void setFechaEmision(Date fechaEmision) {
		this.fechaEmision = fechaEmision;
	}

	public Date getFechaRecepcion() {
		return fechaRecepcion;
	}

	public void setFechaRecepcion(Date fechaRecepcion) {
		this.fechaRecepcion = fechaRecepcion;
	}

	public Date getFechaTraslado() {
		return fechaTraslado;
	}

	public void setFechaTraslado(Date fechaTraslado) {
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
		return tipoHr;
	}

	public void setTipoHr(Valor tipoHr) {
		this.tipoHr = tipoHr;
	}
	
	public Dependencia getOrigen() {
		return origen;
	}

	public void setOrigen(Dependencia origen) {
		this.origen = origen;
	}

	public Dependencia getDestino() {
		return destino;
	}

	public void setDestino(Dependencia destino) {
		this.destino = destino;
	}

	public Expediente getExpediente() {
		return expediente;
	}

	public void setExpediente(Expediente expediente) {
		this.expediente = expediente;
	}

	public ModeloMarca getVehiculoMarca() {
		return vehiculoMarca;
	}

	public void setVehiculoMarca(ModeloMarca vehiculoMarca) {
		this.vehiculoMarca = vehiculoMarca;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Persona getConductor() {
		return conductor;
	}

	public void setConductor(Persona conductor) {
		this.conductor = conductor;
	}

	public Policia getCustodio() {
		return custodio;
	}

	public void setCustodio(Policia custodio) {
		this.custodio = custodio;
	}

	@Override
	public void validar() {
		if(numero == null) {
			throw new ValidacionException(Constante.CODIGO_MENSAJE.VALIDAR_TEXTBOX, new Object[]{"Número"});
		}
		if( this.expediente == null) {
			throw new ValidacionException(Constante.CODIGO_MENSAJE.VALIDAR_COMBOBOX, new Object[]{"Expediente"});
		}
		if( this.origen == null) {
			throw new ValidacionException(Constante.CODIGO_MENSAJE.VALIDAR_COMBOBOX, new Object[]{"Dependencia de Origen"});
		}
		if( this.destino == null) {
			throw new ValidacionException(Constante.CODIGO_MENSAJE.VALIDAR_COMBOBOX, new Object[]{"Dependencia de Destino"});
		}
	}
 
}