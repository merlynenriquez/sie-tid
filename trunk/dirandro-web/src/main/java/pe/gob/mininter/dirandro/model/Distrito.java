package pe.gob.mininter.dirandro.model;

import java.io.Serializable;
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
 * The persistent class for the UBG_DISTRITO database table.
 * 
 */
@Entity
@Table(name="UBG_DISTRITO")
public class Distrito extends AuditoriaBean implements Validador, Serializable {
	
	private static final long serialVersionUID = 2374489167323606236L;

	@Id
	@SequenceGenerator(name="UBG_DISTRITO_ID_GENERATOR", sequenceName="SEQ_")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="UBG_DISTRITO_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=16)
	private long id;

	@Column(name="CODIGO_HOST", length=14)
	private String codigoHost;

	@Column(nullable=false, length=100)
	private String nombre;

	//bi-directional many-to-one association to CentroPoblado
	@OneToMany(mappedBy="ubgDistrito")
	private List<CentroPoblado> expCentroPoblados;

	//bi-directional many-to-one association to Entidad
	@OneToMany(mappedBy="ubgDistrito")
	private List<Entidad> expEntidads;

	//bi-directional many-to-one association to Expediente
	@OneToMany(mappedBy="ubgDistrito")
	private List<Expediente> expExpedientes;

	//bi-directional many-to-one association to Inmueble
	@OneToMany(mappedBy="ubgDistrito")
	private List<Inmueble> expInmuebles;

	//bi-directional many-to-one association to Instalacion
	@OneToMany(mappedBy="ubgDistrito")
	private List<Instalacion> expInstalacions;

	//bi-directional many-to-one association to Direccion
	@OneToMany(mappedBy="ubgDistrito")
	private List<Direccion> perDireccions;

	//bi-directional many-to-one association to Persona
	@OneToMany(mappedBy="ubgDistrito")
	private List<Persona> perPersonas;

	//bi-directional many-to-one association to Provincia
	@ManyToOne
	@JoinColumn(name="PROVINCIA", nullable=false)
	private Provincia ubgProvincia;

	public Distrito() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCodigoHost() {
		return this.codigoHost;
	}

	public void setCodigoHost(String codigoHost) {
		this.codigoHost = codigoHost;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<CentroPoblado> getExpCentroPoblados() {
		return this.expCentroPoblados;
	}

	public void setExpCentroPoblados(List<CentroPoblado> expCentroPoblados) {
		this.expCentroPoblados = expCentroPoblados;
	}

	public CentroPoblado addExpCentroPoblado(CentroPoblado expCentroPoblado) {
		getExpCentroPoblados().add(expCentroPoblado);
		expCentroPoblado.setUbgDistrito(this);

		return expCentroPoblado;
	}

	public CentroPoblado removeExpCentroPoblado(CentroPoblado expCentroPoblado) {
		getExpCentroPoblados().remove(expCentroPoblado);
		expCentroPoblado.setUbgDistrito(null);

		return expCentroPoblado;
	}

	public List<Entidad> getExpEntidads() {
		return this.expEntidads;
	}

	public void setExpEntidads(List<Entidad> expEntidads) {
		this.expEntidads = expEntidads;
	}

	public Entidad addExpEntidad(Entidad expEntidad) {
		getExpEntidads().add(expEntidad);
		expEntidad.setUbgDistrito(this);

		return expEntidad;
	}

	public Entidad removeExpEntidad(Entidad expEntidad) {
		getExpEntidads().remove(expEntidad);
		expEntidad.setUbgDistrito(null);

		return expEntidad;
	}

	public List<Expediente> getExpExpedientes() {
		return this.expExpedientes;
	}

	public void setExpExpedientes(List<Expediente> expExpedientes) {
		this.expExpedientes = expExpedientes;
	}

	public Expediente addExpExpediente(Expediente expExpediente) {
		getExpExpedientes().add(expExpediente);
		expExpediente.setUbgDistrito(this);

		return expExpediente;
	}

	public Expediente removeExpExpediente(Expediente expExpediente) {
		getExpExpedientes().remove(expExpediente);
		expExpediente.setUbgDistrito(null);

		return expExpediente;
	}

	public List<Inmueble> getExpInmuebles() {
		return this.expInmuebles;
	}

	public void setExpInmuebles(List<Inmueble> expInmuebles) {
		this.expInmuebles = expInmuebles;
	}

	public Inmueble addExpInmueble(Inmueble expInmueble) {
		getExpInmuebles().add(expInmueble);
		expInmueble.setUbgDistrito(this);

		return expInmueble;
	}

	public Inmueble removeExpInmueble(Inmueble expInmueble) {
		getExpInmuebles().remove(expInmueble);
		expInmueble.setUbgDistrito(null);

		return expInmueble;
	}

	public List<Instalacion> getExpInstalacions() {
		return this.expInstalacions;
	}

	public void setExpInstalacions(List<Instalacion> expInstalacions) {
		this.expInstalacions = expInstalacions;
	}

	public Instalacion addExpInstalacion(Instalacion expInstalacion) {
		getExpInstalacions().add(expInstalacion);
		expInstalacion.setUbgDistrito(this);

		return expInstalacion;
	}

	public Instalacion removeExpInstalacion(Instalacion expInstalacion) {
		getExpInstalacions().remove(expInstalacion);
		expInstalacion.setUbgDistrito(null);

		return expInstalacion;
	}

	public List<Direccion> getPerDireccions() {
		return this.perDireccions;
	}

	public void setPerDireccions(List<Direccion> perDireccions) {
		this.perDireccions = perDireccions;
	}

	public Direccion addPerDireccion(Direccion perDireccion) {
		getPerDireccions().add(perDireccion);
		perDireccion.setUbgDistrito(this);

		return perDireccion;
	}

	public Direccion removePerDireccion(Direccion perDireccion) {
		getPerDireccions().remove(perDireccion);
		perDireccion.setUbgDistrito(null);

		return perDireccion;
	}

	public List<Persona> getPerPersonas() {
		return this.perPersonas;
	}

	public void setPerPersonas(List<Persona> perPersonas) {
		this.perPersonas = perPersonas;
	}

	public Persona addPerPersona(Persona perPersona) {
		getPerPersonas().add(perPersona);
		perPersona.setUbgDistrito(this);

		return perPersona;
	}

	public Persona removePerPersona(Persona perPersona) {
		getPerPersonas().remove(perPersona);
		perPersona.setUbgDistrito(null);

		return perPersona;
	}

	public Provincia getUbgProvincia() {
		return this.ubgProvincia;
	}

	public void setUbgProvincia(Provincia ubgProvincia) {
		this.ubgProvincia = ubgProvincia;
	}

	@Override
	public void validar() {
		// TODO Auto-generated method stub
		
	}

}