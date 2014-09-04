package pe.gob.mininter.dirandro.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the EXP_INMUEBLE database table.
 * 
 */
@Entity
@Table(name="EXP_INMUEBLE")
public class Inmueble implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="EXP_INMUEBLE_ID_GENERATOR", sequenceName="SEQ_")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="EXP_INMUEBLE_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=16)
	private long id;

	@Column(nullable=false)
	private Timestamp creacion;

	@Column(length=2000)
	private String descripcion;

	@Column(precision=10, scale=2)
	private BigDecimal dimension;

	@Column(length=400)
	private String direccion;

	private Timestamp edicion;

	@Column(length=100)
	private String latitud;

	@Column(length=100)
	private String longitud;

	@Column(name="NRO_INSCRIPCION", length=100)
	private String nroInscripcion;

	@Column(length=2000)
	private String observaciones;

	@Column(name="OFICINA_REGISTRAL", length=2000)
	private String oficinaRegistral;

	@Column(length=400)
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
	private Valor cfgValor;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="CREADOR", nullable=false)
	private Usuario segUsuario1;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="EDITOR")
	private Usuario segUsuario2;

	//bi-directional many-to-one association to Distrito
	@ManyToOne
	@JoinColumn(name="UBICACION")
	private Distrito ubgDistrito;

	public Inmueble() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
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

	public BigDecimal getDimension() {
		return this.dimension;
	}

	public void setDimension(BigDecimal dimension) {
		this.dimension = dimension;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Timestamp getEdicion() {
		return this.edicion;
	}

	public void setEdicion(Timestamp edicion) {
		this.edicion = edicion;
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

	public String getNroInscripcion() {
		return this.nroInscripcion;
	}

	public void setNroInscripcion(String nroInscripcion) {
		this.nroInscripcion = nroInscripcion;
	}

	public String getObservaciones() {
		return this.observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public String getOficinaRegistral() {
		return this.oficinaRegistral;
	}

	public void setOficinaRegistral(String oficinaRegistral) {
		this.oficinaRegistral = oficinaRegistral;
	}

	public String getResolucion() {
		return this.resolucion;
	}

	public void setResolucion(String resolucion) {
		this.resolucion = resolucion;
	}

	public String getUrbanizacion() {
		return this.urbanizacion;
	}

	public void setUrbanizacion(String urbanizacion) {
		this.urbanizacion = urbanizacion;
	}

	public BigDecimal getValorBien() {
		return this.valorBien;
	}

	public void setValorBien(BigDecimal valorBien) {
		this.valorBien = valorBien;
	}

	public BigDecimal getValorTerreno() {
		return this.valorTerreno;
	}

	public void setValorTerreno(BigDecimal valorTerreno) {
		this.valorTerreno = valorTerreno;
	}

	public List<DetPerInmExp> getExpDetPerInmExps() {
		return this.expDetPerInmExps;
	}

	public void setExpDetPerInmExps(List<DetPerInmExp> expDetPerInmExps) {
		this.expDetPerInmExps = expDetPerInmExps;
	}

	public DetPerInmExp addExpDetPerInmExp(DetPerInmExp expDetPerInmExp) {
		getExpDetPerInmExps().add(expDetPerInmExp);
		expDetPerInmExp.setExpInmueble(this);

		return expDetPerInmExp;
	}

	public DetPerInmExp removeExpDetPerInmExp(DetPerInmExp expDetPerInmExp) {
		getExpDetPerInmExps().remove(expDetPerInmExp);
		expDetPerInmExp.setExpInmueble(null);

		return expDetPerInmExp;
	}

	public Valor getCfgValor() {
		return this.cfgValor;
	}

	public void setCfgValor(Valor cfgValor) {
		this.cfgValor = cfgValor;
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