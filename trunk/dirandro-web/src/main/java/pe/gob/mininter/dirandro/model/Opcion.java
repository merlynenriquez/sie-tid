package pe.gob.mininter.dirandro.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the SEG_OPCION database table.
 * 
 */
@Entity
@Table(name="SEG_OPCION")
public class Opcion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SEG_OPCION_ID_GENERATOR", sequenceName="SEQ_")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEG_OPCION_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=8)
	private long id;

	@Column(nullable=false, length=30)
	private String codigo;

	@Column(nullable=false)
	private Timestamp creacion;

	@Column(length=500)
	private String descripcion;

	private Timestamp edicion;

	@Column(nullable=false, length=100)
	private String nombre;

	@Column(precision=8)
	private BigDecimal orden;

	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="TIPO", nullable=false)
	private Valor cfgValor1;

	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="ESTADO")
	private Valor cfgValor2;

	//bi-directional many-to-one association to Opcion
	@ManyToOne
	@JoinColumn(name="PADRE")
	private Opcion segOpcion;

	//bi-directional many-to-one association to Opcion
	@OneToMany(mappedBy="segOpcion")
	private List<Opcion> segOpcions;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="CREADOR", nullable=false)
	private Usuario segUsuario1;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="EDITOR")
	private Usuario segUsuario2;

	//bi-directional many-to-one association to Permiso
	@OneToMany(mappedBy="segOpcion")
	private List<Permiso> segPermisos;

	public Opcion() {
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

	public BigDecimal getOrden() {
		return this.orden;
	}

	public void setOrden(BigDecimal orden) {
		this.orden = orden;
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

	public Opcion getSegOpcion() {
		return this.segOpcion;
	}

	public void setSegOpcion(Opcion segOpcion) {
		this.segOpcion = segOpcion;
	}

	public List<Opcion> getSegOpcions() {
		return this.segOpcions;
	}

	public void setSegOpcions(List<Opcion> segOpcions) {
		this.segOpcions = segOpcions;
	}

	public Opcion addSegOpcion(Opcion segOpcion) {
		getSegOpcions().add(segOpcion);
		segOpcion.setSegOpcion(this);

		return segOpcion;
	}

	public Opcion removeSegOpcion(Opcion segOpcion) {
		getSegOpcions().remove(segOpcion);
		segOpcion.setSegOpcion(null);

		return segOpcion;
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

	public List<Permiso> getSegPermisos() {
		return this.segPermisos;
	}

	public void setSegPermisos(List<Permiso> segPermisos) {
		this.segPermisos = segPermisos;
	}

	public Permiso addSegPermiso(Permiso segPermiso) {
		getSegPermisos().add(segPermiso);
		segPermiso.setSegOpcion(this);

		return segPermiso;
	}

	public Permiso removeSegPermiso(Permiso segPermiso) {
		getSegPermisos().remove(segPermiso);
		segPermiso.setSegOpcion(null);

		return segPermiso;
	}

}