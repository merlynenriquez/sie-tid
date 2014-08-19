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
 * The persistent class for the EXP_INSTALACION database table.
 * 
 */
@Entity
@Table(name="EXP_INSTALACION")
public class Instalacion extends AuditoriaBean implements Validador, Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3029123281985069021L;

	@Id
	@SequenceGenerator(name="EXP_INSTALACION_ID_GENERATOR", sequenceName="SEQ_")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="EXP_INSTALACION_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=16)
	private Long id;

	@Column(name="ALTURA_MT", precision=4)
	private BigDecimal alturaMt;

	@Column(name="ANCHO_MT", precision=4)
	private BigDecimal anchoMt;

	@Column(length=4000)
	private String descripcion;

	@Column(name="LARGO_MT", precision=4)
	private BigDecimal largoMt;

	@Column(length=40)
	private String latitud;

	@Column(length=40)
	private String longitud;

	@Column(length=400)
	private String nombre;

	@Column(name="ZONA_PRODUCCION", precision=16)
	private BigDecimal zonaProduccion;

	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="TIPO")
	private Valor tipo;

	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="SITUACION")
	private Valor situacion;

	//bi-directional many-to-one association to CentroPoblado
	@ManyToOne
	@JoinColumn(name="CENTRO_POBLADO")
	private CentroPoblado expCentroPoblado;

	//bi-directional many-to-one association to Expediente
	@ManyToOne
	@JoinColumn(name="EXPEDIENTE")
	private Expediente expExpediente;

	//bi-directional many-to-one association to Organizacion
	@ManyToOne
	@JoinColumn(name="ORGANIZACION")
	private Organizacion expOrganizacion;

	//bi-directional many-to-one association to Distrito
	@ManyToOne
	@JoinColumn(name="UBICACION")
	private Distrito ubgDistrito;

	public Instalacion() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getAlturaMt() {
		return alturaMt;
	}

	public void setAlturaMt(BigDecimal alturaMt) {
		this.alturaMt = alturaMt;
	}

	public BigDecimal getAnchoMt() {
		return anchoMt;
	}

	public void setAnchoMt(BigDecimal anchoMt) {
		this.anchoMt = anchoMt;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public BigDecimal getLargoMt() {
		return largoMt;
	}

	public void setLargoMt(BigDecimal largoMt) {
		this.largoMt = largoMt;
	}

	public String getLatitud() {
		return latitud;
	}

	public void setLatitud(String latitud) {
		this.latitud = latitud;
	}

	public String getLongitud() {
		return longitud;
	}

	public void setLongitud(String longitud) {
		this.longitud = longitud;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public BigDecimal getZonaProduccion() {
		return zonaProduccion;
	}

	public void setZonaProduccion(BigDecimal zonaProduccion) {
		this.zonaProduccion = zonaProduccion;
	}

	public Valor getTipo() {
		return tipo;
	}

	public void setTipo(Valor tipo) {
		this.tipo = tipo;
	}

	public Valor getSituacion() {
		return situacion;
	}

	public void setSituacion(Valor situacion) {
		this.situacion = situacion;
	}

	public CentroPoblado getExpCentroPoblado() {
		return expCentroPoblado;
	}

	public void setExpCentroPoblado(CentroPoblado expCentroPoblado) {
		this.expCentroPoblado = expCentroPoblado;
	}

	public Expediente getExpExpediente() {
		return expExpediente;
	}

	public void setExpExpediente(Expediente expExpediente) {
		this.expExpediente = expExpediente;
	}

	public Organizacion getExpOrganizacion() {
		return expOrganizacion;
	}

	public void setExpOrganizacion(Organizacion expOrganizacion) {
		this.expOrganizacion = expOrganizacion;
	}

	public Distrito getUbgDistrito() {
		return ubgDistrito;
	}

	public void setUbgDistrito(Distrito ubgDistrito) {
		this.ubgDistrito = ubgDistrito;
	}

	@Override
	public void validar() {
		// TODO Auto-generated method stub
		
	}

}