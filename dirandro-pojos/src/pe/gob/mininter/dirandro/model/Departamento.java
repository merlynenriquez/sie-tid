package pe.gob.mininter.dirandro.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the UBG_DEPARTAMENTO database table.
 * 
 */
@Entity
@Table(name="UBG_DEPARTAMENTO")
public class Departamento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="UBG_DEPARTAMENTO_ID_GENERATOR", sequenceName="SEQ_")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="UBG_DEPARTAMENTO_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=16)
	private long id;

	@Column(nullable=false)
	private Timestamp creacion;

	private Timestamp edicion;

	@Column(nullable=false, length=100)
	private String nombre;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="CREADOR", nullable=false)
	private Usuario segUsuario1;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="EDITOR")
	private Usuario segUsuario2;

	//bi-directional many-to-one association to Provincia
	@OneToMany(mappedBy="ubgDepartamento")
	private List<Provincia> ubgProvincias;

	public Departamento() {
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

	public List<Provincia> getUbgProvincias() {
		return this.ubgProvincias;
	}

	public void setUbgProvincias(List<Provincia> ubgProvincias) {
		this.ubgProvincias = ubgProvincias;
	}

	public Provincia addUbgProvincia(Provincia ubgProvincia) {
		getUbgProvincias().add(ubgProvincia);
		ubgProvincia.setUbgDepartamento(this);

		return ubgProvincia;
	}

	public Provincia removeUbgProvincia(Provincia ubgProvincia) {
		getUbgProvincias().remove(ubgProvincia);
		ubgProvincia.setUbgDepartamento(null);

		return ubgProvincia;
	}

}