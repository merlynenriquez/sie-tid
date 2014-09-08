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
	@SequenceGenerator(name="EXP_INSTALACION_ID_GENERATOR", sequenceName="SEQ_INSTALACION", allocationSize=1)
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

	@Column(precision=4)
	private Integer radio;

	@Column(name="ZONA_PRODUCCION", length=400)
	private String zonaProduccion;

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
	@JoinColumn(name="EXPEDIENTE", nullable=false)
	private Expediente expediente;

	//bi-directional many-to-one association to Organizacion
	@ManyToOne
	@JoinColumn(name="ORGANIZACION")
	private Organizacion organizacionDelictiva;

	//bi-directional many-to-one association to Distrito
	@ManyToOne
	@JoinColumn(name="UBICACION")
	private Distrito distrito;

	public Instalacion() {
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

	public Integer getRadio() {
		return radio;
	}

	public void setRadio(Integer radio) {
		this.radio = radio;
	}

	public String getZonaProduccion() {
		return zonaProduccion;
	}

	public void setZonaProduccion(String zonaProduccion) {
		this.zonaProduccion = zonaProduccion;
	}

	public Expediente getExpediente() {
		return expediente;
	}

	public void setExpediente(Expediente expediente) {
		this.expediente = expediente;
	}

	public Organizacion getOrganizacionDelictiva() {
		return organizacionDelictiva;
	}

	public void setOrganizacionDelictiva(Organizacion organizacionDelictiva) {
		this.organizacionDelictiva = organizacionDelictiva;
	}

	public Distrito getDistrito() {
		return distrito;
	}

	public void setDistrito(Distrito distrito) {
		this.distrito = distrito;
	}

	@Override
	public void validar() {
		// TODO Auto-generated method stub
		
	}

}