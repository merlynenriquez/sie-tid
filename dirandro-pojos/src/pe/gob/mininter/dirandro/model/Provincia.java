package pe.gob.mininter.dirandro.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the UBG_PROVINCIA database table.
 * 
 */
@Entity
@Table(name="UBG_PROVINCIA")
public class Provincia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="UBG_PROVINCIA_ID_GENERATOR", sequenceName="SEQ_")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="UBG_PROVINCIA_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=16)
	private long id;

	@Column(nullable=false)
	private Timestamp creacion;

	private Timestamp edicion;

	@Column(nullable=false, length=100)
	private String nombre;

	//bi-directional many-to-one association to Distrito
	@OneToMany(mappedBy="ubgProvincia")
	private List<Distrito> ubgDistritos;

	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="ESTADO")
	private Valor cfgValor;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="CREADOR", nullable=false)
	private Usuario segUsuario1;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="EDITOR")
	private Usuario segUsuario2;

	//bi-directional many-to-one association to Departamento
	@ManyToOne
	@JoinColumn(name="DEPARTAMENTO", nullable=false)
	private Departamento ubgDepartamento;

	public Provincia() {
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

	public List<Distrito> getUbgDistritos() {
		return this.ubgDistritos;
	}

	public void setUbgDistritos(List<Distrito> ubgDistritos) {
		this.ubgDistritos = ubgDistritos;
	}

	public Distrito addUbgDistrito(Distrito ubgDistrito) {
		getUbgDistritos().add(ubgDistrito);
		ubgDistrito.setUbgProvincia(this);

		return ubgDistrito;
	}

	public Distrito removeUbgDistrito(Distrito ubgDistrito) {
		getUbgDistritos().remove(ubgDistrito);
		ubgDistrito.setUbgProvincia(null);

		return ubgDistrito;
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

	public Departamento getUbgDepartamento() {
		return this.ubgDepartamento;
	}

	public void setUbgDepartamento(Departamento ubgDepartamento) {
		this.ubgDepartamento = ubgDepartamento;
	}

}