package pe.gob.mininter.dirandro.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the MNT_PAISES database table.
 * 
 */
@Entity
@Table(name="MNT_PAISES")
public class Pais implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="MNT_PAISES_ID_GENERATOR", sequenceName="SEQ_")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="MNT_PAISES_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=16)
	private long id;

	@Column(nullable=false)
	private Timestamp creacion;

	private Timestamp edicion;

	@Column(length=400)
	private String nacionalidad;

	@Column(nullable=false, length=400)
	private String nombre;

	//bi-directional many-to-one association to Droga
	@OneToMany(mappedBy="mntPais1")
	private List<Droga> expDrogas1;


	//bi-directional many-to-one association to Droga
	@OneToMany(mappedBy="mntPais3")
	private List<Droga> expDrogas2;

	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="ESTADO")
	private Valor cfgValor;

	//bi-directional many-to-one association to Pais
	@ManyToOne
	@JoinColumn(name="PADRE")
	private Pais mntPais;

	//bi-directional many-to-one association to Pais
	@OneToMany(mappedBy="mntPais")
	private List<Pais> mntPaises;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="CREADOR", nullable=false)
	private Usuario segUsuario1;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="EDITOR")
	private Usuario segUsuario2;

	public Pais() {
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

	public String getNacionalidad() {
		return this.nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Droga> getExpDrogas1() {
		return this.expDrogas1;
	}

	public void setExpDrogas1(List<Droga> expDrogas1) {
		this.expDrogas1 = expDrogas1;
	}

	public Droga addExpDrogas1(Droga expDrogas1) {
		getExpDrogas1().add(expDrogas1);
		expDrogas1.setMntPais1(this);

		return expDrogas1;
	}

	public Droga removeExpDrogas1(Droga expDrogas1) {
		getExpDrogas1().remove(expDrogas1);
		expDrogas1.setMntPais1(null);

		return expDrogas1;
	}

	public List<Droga> getExpDrogas2() {
		return this.expDrogas2;
	}

	public void setExpDrogas2(List<Droga> expDrogas2) {
		this.expDrogas2 = expDrogas2;
	}

	public Droga addExpDrogas2(Droga expDrogas2) {
		getExpDrogas2().add(expDrogas2);
		expDrogas2.setMntPais3(this);

		return expDrogas2;
	}

	public Droga removeExpDrogas2(Droga expDrogas2) {
		getExpDrogas2().remove(expDrogas2);
		expDrogas2.setMntPais3(null);

		return expDrogas2;
	}

	public Valor getCfgValor() {
		return this.cfgValor;
	}

	public void setCfgValor(Valor cfgValor) {
		this.cfgValor = cfgValor;
	}

	public Pais getMntPais() {
		return this.mntPais;
	}

	public void setMntPais(Pais mntPais) {
		this.mntPais = mntPais;
	}

	public List<Pais> getMntPaises() {
		return this.mntPaises;
	}

	public void setMntPaises(List<Pais> mntPaises) {
		this.mntPaises = mntPaises;
	}

	public Pais addMntPais(Pais mntPais) {
		getMntPaises().add(mntPais);
		mntPais.setMntPais(this);

		return mntPais;
	}

	public Pais removeMntPais(Pais mntPais) {
		getMntPaises().remove(mntPais);
		mntPais.setMntPais(null);

		return mntPais;
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