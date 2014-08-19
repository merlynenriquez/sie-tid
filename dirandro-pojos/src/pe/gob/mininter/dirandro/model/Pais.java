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

	//bi-directional one-to-one association to Droga
	@OneToOne(mappedBy="mntPais1")
	private Droga expDroga;

	//bi-directional many-to-one association to Droga
	@OneToMany(mappedBy="mntPais2")
	private List<Droga> expDrogas;

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

	//bi-directional one-to-one association to Persona
	@OneToOne(mappedBy="mntPais")
	private Persona perPersona;

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

	public Droga getExpDroga() {
		return this.expDroga;
	}

	public void setExpDroga(Droga expDroga) {
		this.expDroga = expDroga;
	}

	public List<Droga> getExpDrogas() {
		return this.expDrogas;
	}

	public void setExpDrogas(List<Droga> expDrogas) {
		this.expDrogas = expDrogas;
	}

	public Droga addExpDroga(Droga expDroga) {
		getExpDrogas().add(expDroga);
		expDroga.setMntPais2(this);

		return expDroga;
	}

	public Droga removeExpDroga(Droga expDroga) {
		getExpDrogas().remove(expDroga);
		expDroga.setMntPais2(null);

		return expDroga;
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

	public Persona getPerPersona() {
		return this.perPersona;
	}

	public void setPerPersona(Persona perPersona) {
		this.perPersona = perPersona;
	}

}