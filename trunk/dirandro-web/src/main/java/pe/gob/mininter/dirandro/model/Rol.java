package pe.gob.mininter.dirandro.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the SEG_ROL database table.
 * 
 */
@Entity
@Table(name="SEG_ROL")
public class Rol implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SEG_ROL_ID_GENERATOR", sequenceName="SEQ_")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEG_ROL_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=8)
	private long id;

	@Column(length=20)
	private String codigo;

	@Column(nullable=false)
	private Timestamp creacion;

	@Column(length=500)
	private String descripcion;

	private Timestamp edicion;

	@Column(length=100)
	private String nombre;

	//bi-directional many-to-one association to Permiso
	@OneToMany(mappedBy="segRol")
	private List<Permiso> segPermisos;

	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="ESTADO", nullable=false)
	private Valor cfgValor;

	//bi-directional many-to-one association to Rol
	@ManyToOne
	@JoinColumn(name="PADRE")
	private Rol segRol;

	//bi-directional many-to-one association to Rol
	@OneToMany(mappedBy="segRol")
	private List<Rol> segRols;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="CREADOR", nullable=false)
	private Usuario segUsuario1;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="EDITOR")
	private Usuario segUsuario2;

	//bi-directional many-to-one association to Usuario
	@OneToMany(mappedBy="segRol")
	private List<Usuario> segUsuarios;

	public Rol() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCodigo() {
		return this.codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
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

	public List<Permiso> getSegPermisos() {
		return this.segPermisos;
	}

	public void setSegPermisos(List<Permiso> segPermisos) {
		this.segPermisos = segPermisos;
	}

	public Permiso addSegPermiso(Permiso segPermiso) {
		getSegPermisos().add(segPermiso);
		segPermiso.setSegRol(this);

		return segPermiso;
	}

	public Permiso removeSegPermiso(Permiso segPermiso) {
		getSegPermisos().remove(segPermiso);
		segPermiso.setSegRol(null);

		return segPermiso;
	}

	public Valor getCfgValor() {
		return this.cfgValor;
	}

	public void setCfgValor(Valor cfgValor) {
		this.cfgValor = cfgValor;
	}

	public Rol getSegRol() {
		return this.segRol;
	}

	public void setSegRol(Rol segRol) {
		this.segRol = segRol;
	}

	public List<Rol> getSegRols() {
		return this.segRols;
	}

	public void setSegRols(List<Rol> segRols) {
		this.segRols = segRols;
	}

	public Rol addSegRol(Rol segRol) {
		getSegRols().add(segRol);
		segRol.setSegRol(this);

		return segRol;
	}

	public Rol removeSegRol(Rol segRol) {
		getSegRols().remove(segRol);
		segRol.setSegRol(null);

		return segRol;
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

	public List<Usuario> getSegUsuarios() {
		return this.segUsuarios;
	}

	public void setSegUsuarios(List<Usuario> segUsuarios) {
		this.segUsuarios = segUsuarios;
	}

	public Usuario addSegUsuario(Usuario segUsuario) {
		getSegUsuarios().add(segUsuario);
		segUsuario.setSegRol(this);

		return segUsuario;
	}

	public Usuario removeSegUsuario(Usuario segUsuario) {
		getSegUsuarios().remove(segUsuario);
		segUsuario.setSegRol(null);

		return segUsuario;
	}

}