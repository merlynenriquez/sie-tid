package pe.gob.mininter.dirandro.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the EXP_ENTIDAD database table.
 * 
 */
@Entity
@Table(name="EXP_ENTIDAD")
public class Entidad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="EXP_ENTIDAD_ID_GENERATOR", sequenceName="SEQ_")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="EXP_ENTIDAD_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=16)
	private long id;

	@Column(length=400)
	private String correo;

	@Column(nullable=false)
	private Timestamp creacion;

	@Column(length=2000)
	private String descripcion;

	@Column(length=600)
	private String direccion;

	@Column(precision=6)
	private BigDecimal dirtepol;

	private Timestamp edicion;

	@Column(length=1000)
	private String nombre;

	@Column(length=400)
	private String telefono;

	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="TIPO")
	private Valor cfgValor1;

	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="ESTADO")
	private Valor cfgValor2;

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
	@JoinColumn(name="DISTRITO")
	private Distrito ubgDistrito;

	//bi-directional many-to-one association to Expediente
	@OneToMany(mappedBy="expEntidad")
	private List<Expediente> expExpedientes;

	public Entidad() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCorreo() {
		return this.correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
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

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public BigDecimal getDirtepol() {
		return this.dirtepol;
	}

	public void setDirtepol(BigDecimal dirtepol) {
		this.dirtepol = dirtepol;
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

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
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

	public List<Expediente> getExpExpedientes() {
		return this.expExpedientes;
	}

	public void setExpExpedientes(List<Expediente> expExpedientes) {
		this.expExpedientes = expExpedientes;
	}

	public Expediente addExpExpediente(Expediente expExpediente) {
		getExpExpedientes().add(expExpediente);
		expExpediente.setExpEntidad(this);

		return expExpediente;
	}

	public Expediente removeExpExpediente(Expediente expExpediente) {
		getExpExpedientes().remove(expExpediente);
		expExpediente.setExpEntidad(null);

		return expExpediente;
	}

}