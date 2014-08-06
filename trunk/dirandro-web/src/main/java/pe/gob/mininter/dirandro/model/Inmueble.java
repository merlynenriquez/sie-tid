package pe.gob.mininter.dirandro.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import pe.gob.mininter.dirandro.util.Validador;
import pe.gob.mininter.dirandro.util.beanbase.AuditoriaBean;


/**
 * The persistent class for the EXP_INMUEBLE database table.
 * 
 */
@Entity
@Table(name="EXP_INMUEBLE")
public class Inmueble extends AuditoriaBean implements Validador, Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5949075490786538492L;

	@Id
	@SequenceGenerator(name="EXP_INMUEBLE_ID_GENERATOR", sequenceName="SEQ_")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="EXP_INMUEBLE_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=16)
	private Long id;

	@Column(length=30)
	private String codigo;

	@Column(length=400)
	private String descripcion;

	@Column(precision=10, scale=2)
	private BigDecimal dimension;

	@Column(length=400)
	private String direccion;

	@Column(length=100)
	private String latitud;

	@Column(length=100)
	private String longitud;

	@Column(name="NRO_INSCRIPCION", length=100)
	private String nroInscripcion;

	@Column(length=800)
	private String observaciones;

	@Column(name="OFICINA_REGISTRAL", length=100)
	private String oficinaRegistral;

	@Column(length=100)
	private String resolucion;

	@Column(length=400)
	private String urbanizacion;

	@Column(name="VALOR_BIEN", precision=10, scale=2)
	private BigDecimal valorBien;

	@Column(name="VALOR_TERRENO", precision=10, scale=2)
	private BigDecimal valorTerreno;

	//bi-directional many-to-one association to DetPerInmExp
	@OneToMany(mappedBy="expInmueble")
	private List<DetPerInmExp> expDetPerInmExps;

	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="TIPO_DIRECCION")
	private Valor tipoDireccion;

	//bi-directional many-to-one association to Distrito
	@ManyToOne
	@JoinColumn(name="UBICACION")
	private Distrito ubgDistrito;

	public Inmueble() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public BigDecimal getDimension() {
		return dimension;
	}

	public void setDimension(BigDecimal dimension) {
		this.dimension = dimension;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
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

	public String getNroInscripcion() {
		return nroInscripcion;
	}

	public void setNroInscripcion(String nroInscripcion) {
		this.nroInscripcion = nroInscripcion;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public String getOficinaRegistral() {
		return oficinaRegistral;
	}

	public void setOficinaRegistral(String oficinaRegistral) {
		this.oficinaRegistral = oficinaRegistral;
	}

	public String getResolucion() {
		return resolucion;
	}

	public void setResolucion(String resolucion) {
		this.resolucion = resolucion;
	}

	public String getUrbanizacion() {
		return urbanizacion;
	}

	public void setUrbanizacion(String urbanizacion) {
		this.urbanizacion = urbanizacion;
	}

	public BigDecimal getValorBien() {
		return valorBien;
	}

	public void setValorBien(BigDecimal valorBien) {
		this.valorBien = valorBien;
	}

	public BigDecimal getValorTerreno() {
		return valorTerreno;
	}

	public void setValorTerreno(BigDecimal valorTerreno) {
		this.valorTerreno = valorTerreno;
	}

	public List<DetPerInmExp> getExpDetPerInmExps() {
		return expDetPerInmExps;
	}

	public void setExpDetPerInmExps(List<DetPerInmExp> expDetPerInmExps) {
		this.expDetPerInmExps = expDetPerInmExps;
	}

	public Valor getTipoDireccion() {
		return tipoDireccion;
	}

	public void setTipoDireccion(Valor tipoDireccion) {
		this.tipoDireccion = tipoDireccion;
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