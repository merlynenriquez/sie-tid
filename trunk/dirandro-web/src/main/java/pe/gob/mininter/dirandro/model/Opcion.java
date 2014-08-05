package pe.gob.mininter.dirandro.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;


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
	private Valor tipo;

	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="ESTADO")
	private Valor estado;

	//bi-directional many-to-one association to Opcion
	@ManyToOne
	@JoinColumn(name="PADRE")
	private Opcion padre;
/*
	//bi-directional many-to-one association to Opcion
	@OneToMany(mappedBy="segOpcion")
	private List<Opcion> segOpcions;

	//bi-directional many-to-one association to Permiso
	@OneToMany(mappedBy="segOpcion")
	private List<Permiso> segPermisos;

*/
	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="CREADOR", nullable=false)
	private Usuario segUsuario1;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="EDITOR")
	private Usuario segUsuario2;

	@Transient
	private List<Opcion> acciones;


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

	public Valor getTipo() {
		return this.tipo;
	}

	public void setTipo(Valor cfgValor1) {
		this.tipo = cfgValor1;
	}

	public Valor getEstado() {
		return this.estado;
	}

	public void setEstado(Valor cfgValor2) {
		this.estado = cfgValor2;
	}

	public Opcion getPadre() {
		return this.padre;
	}

	public void setPadre(Opcion segOpcion) {
		this.padre = segOpcion;
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

	public List<Opcion> getAcciones() {
		return acciones;
	}

	public void setAcciones(List<Opcion> acciones) {
		this.acciones = acciones;
	}

	/*public List<Permiso> getSegPermisos() {
		return this.segPermisos;
	}

	public void setSegPermisos(List<Permiso> segPermisos) {
		this.segPermisos = segPermisos;
	}

	public List<Opcion> getSegOpcions() {
		return this.segOpcions;
	}

	public void setSegOpcions(List<Opcion> segOpcions) {
		this.segOpcions = segOpcions;
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

*/
}