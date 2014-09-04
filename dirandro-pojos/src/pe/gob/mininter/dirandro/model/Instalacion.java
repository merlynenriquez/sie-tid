package pe.gob.mininter.dirandro.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.math.BigDecimal;


/**
 * The persistent class for the EXP_INSTALACION database table.
 * 
 */
@Entity
@Table(name="EXP_INSTALACION")
public class Instalacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="EXP_INSTALACION_ID_GENERATOR", sequenceName="SEQ_")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="EXP_INSTALACION_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=16)
	private long id;

	@Column(name="ALTURA_MT", precision=4)
	private BigDecimal alturaMt;

	@Column(name="ANCHO_MT", precision=4)
	private BigDecimal anchoMt;

	@Column(nullable=false)
	private Timestamp creacion;

	@Column(length=4000)
	private String descripcion;

	private Timestamp edicion;

	@Column(name="LARGO_MT", precision=4)
	private BigDecimal largoMt;

	@Column(length=40)
	private String latitud;

	@Column(length=40)
	private String longitud;

	@Column(length=400)
	private String nombre;

	@Column(precision=4)
	private BigDecimal radio;

	@Column(name="ZONA_PRODUCCION", length=400)
	private String zonaProduccion;

	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="TIPO")
	private Valor cfgValor1;

	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="SITUACION")
	private Valor cfgValor2;

	//bi-directional many-to-one association to CentroPoblado
	@ManyToOne
	@JoinColumn(name="CENTRO_POBLADO")
	private CentroPoblado expCentroPoblado;

	//bi-directional many-to-one association to Expediente
	@ManyToOne
	@JoinColumn(name="EXPEDIENTE", nullable=false)
	private Expediente expExpediente;

	//bi-directional many-to-one association to Organizacion
	@ManyToOne
	@JoinColumn(name="ORGANIZACION")
	private Organizacion expOrganizacion;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="EDITOR")
	private Usuario segUsuario1;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="CREADOR", nullable=false)
	private Usuario segUsuario2;

	//bi-directional many-to-one association to Distrito
	@ManyToOne
	@JoinColumn(name="UBICACION")
	private Distrito ubgDistrito;

	public Instalacion() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public BigDecimal getAlturaMt() {
		return this.alturaMt;
	}

	public void setAlturaMt(BigDecimal alturaMt) {
		this.alturaMt = alturaMt;
	}

	public BigDecimal getAnchoMt() {
		return this.anchoMt;
	}

	public void setAnchoMt(BigDecimal anchoMt) {
		this.anchoMt = anchoMt;
	}

	public Timestamp getCreacion() {
		return this.creacion;
	}

	public void setCreacion(Timestamp creacion) {
		this.creacion = creacion;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Timestamp getEdicion() {
		return this.edicion;
	}

	public void setEdicion(Timestamp edicion) {
		this.edicion = edicion;
	}

	public BigDecimal getLargoMt() {
		return this.largoMt;
	}

	public void setLargoMt(BigDecimal largoMt) {
		this.largoMt = largoMt;
	}

	public String getLatitud() {
		return this.latitud;
	}

	public void setLatitud(String latitud) {
		this.latitud = latitud;
	}

	public String getLongitud() {
		return this.longitud;
	}

	public void setLongitud(String longitud) {
		this.longitud = longitud;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public BigDecimal getRadio() {
		return this.radio;
	}

	public void setRadio(BigDecimal radio) {
		this.radio = radio;
	}

	public String getZonaProduccion() {
		return this.zonaProduccion;
	}

	public void setZonaProduccion(String zonaProduccion) {
		this.zonaProduccion = zonaProduccion;
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

	public CentroPoblado getExpCentroPoblado() {
		return this.expCentroPoblado;
	}

	public void setExpCentroPoblado(CentroPoblado expCentroPoblado) {
		this.expCentroPoblado = expCentroPoblado;
	}

	public Expediente getExpExpediente() {
		return this.expExpediente;
	}

	public void setExpExpediente(Expediente expExpediente) {
		this.expExpediente = expExpediente;
	}

	public Organizacion getExpOrganizacion() {
		return this.expOrganizacion;
	}

	public void setExpOrganizacion(Organizacion expOrganizacion) {
		this.expOrganizacion = expOrganizacion;
	}

	public Usuario getSegUsuario1() {
		return this.segUsuario1;
	}

	public void setSegUsuario1(Usuario segUsuario1) {
		this.segUsuario1 = segUsuario1;
	}

	public Usuario getSegUsuario2() {
		return this.segUsuario2;
	}

	public void setSegUsuario2(Usuario segUsuario2) {
		this.segUsuario2 = segUsuario2;
	}

	public Distrito getUbgDistrito() {
		return this.ubgDistrito;
	}

	public void setUbgDistrito(Distrito ubgDistrito) {
		this.ubgDistrito = ubgDistrito;
	}

}