package pe.gob.mininter.dirandro.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the EXP_ORGANIZACION database table.
 * 
 */
@Entity
@Table(name="EXP_ORGANIZACION")
public class Organizacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="EXP_ORGANIZACION_ID_GENERATOR", sequenceName="SEQ_")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="EXP_ORGANIZACION_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=16)
	private long id;

	@Column(length=700)
	private String campo;

	@Column(nullable=false)
	private Timestamp creacion;

	@Column(length=300)
	private String descripcion;

	private Timestamp edicion;

	@Column(length=300)
	private String nombre;

	@Column(name="NRO_INTEGRANTES", precision=5)
	private BigDecimal nroIntegrantes;

	@Column(name="UBICACION_ACTIVOS", length=500)
	private String ubicacionActivos;

	@Column(name="ZONA_OPERACION", length=500)
	private String zonaOperacion;

	//bi-directional many-to-one association to DetExpedientePersona
	@OneToMany(mappedBy="expOrganizacion")
	private List<DetExpedientePersona> expDetExpedientePersonas;

	//bi-directional many-to-one association to Instalacion
	@OneToMany(mappedBy="expOrganizacion")
	private List<Instalacion> expInstalacions;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="CREADOR", nullable=false)
	private Usuario segUsuario1;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="EDITOR")
	private Usuario segUsuario2;

	public Organizacion() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCampo() {
		return this.campo;
	}

	public void setCampo(String campo) {
		this.campo = campo;
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

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public BigDecimal getNroIntegrantes() {
		return this.nroIntegrantes;
	}

	public void setNroIntegrantes(BigDecimal nroIntegrantes) {
		this.nroIntegrantes = nroIntegrantes;
	}

	public String getUbicacionActivos() {
		return this.ubicacionActivos;
	}

	public void setUbicacionActivos(String ubicacionActivos) {
		this.ubicacionActivos = ubicacionActivos;
	}

	public String getZonaOperacion() {
		return this.zonaOperacion;
	}

	public void setZonaOperacion(String zonaOperacion) {
		this.zonaOperacion = zonaOperacion;
	}

	public List<DetExpedientePersona> getExpDetExpedientePersonas() {
		return this.expDetExpedientePersonas;
	}

	public void setExpDetExpedientePersonas(List<DetExpedientePersona> expDetExpedientePersonas) {
		this.expDetExpedientePersonas = expDetExpedientePersonas;
	}

	public DetExpedientePersona addExpDetExpedientePersona(DetExpedientePersona expDetExpedientePersona) {
		getExpDetExpedientePersonas().add(expDetExpedientePersona);
		expDetExpedientePersona.setExpOrganizacion(this);

		return expDetExpedientePersona;
	}

	public DetExpedientePersona removeExpDetExpedientePersona(DetExpedientePersona expDetExpedientePersona) {
		getExpDetExpedientePersonas().remove(expDetExpedientePersona);
		expDetExpedientePersona.setExpOrganizacion(null);

		return expDetExpedientePersona;
	}

	public List<Instalacion> getExpInstalacions() {
		return this.expInstalacions;
	}

	public void setExpInstalacions(List<Instalacion> expInstalacions) {
		this.expInstalacions = expInstalacions;
	}

	public Instalacion addExpInstalacion(Instalacion expInstalacion) {
		getExpInstalacions().add(expInstalacion);
		expInstalacion.setExpOrganizacion(this);

		return expInstalacion;
	}

	public Instalacion removeExpInstalacion(Instalacion expInstalacion) {
		getExpInstalacions().remove(expInstalacion);
		expInstalacion.setExpOrganizacion(null);

		return expInstalacion;
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

}