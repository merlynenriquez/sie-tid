package pe.gob.mininter.dirandro.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the MNT_MODELO_MARCA database table.
 * 
 */
@Entity
@Table(name="MNT_MODELO_MARCA")
public class ModeloMarca implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="MNT_MODELO_MARCA_ID_GENERATOR", sequenceName="SEQ_")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="MNT_MODELO_MARCA_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=16)
	private long id;

	@Column(nullable=false)
	private Timestamp creacion;

	private Timestamp edicion;

	@Column(length=200)
	private String nombre;

	//bi-directional many-to-one association to Arma
	@OneToMany(mappedBy="mntModeloMarca")
	private List<Arma> expArmas;

	//bi-directional many-to-one association to Droga
	@OneToMany(mappedBy="mntModeloMarca1")
	private List<Droga> expDrogas1;

	//bi-directional many-to-one association to Droga
	@OneToMany(mappedBy="mntModeloMarca2")
	private List<Droga> expDrogas2;

	//bi-directional many-to-one association to Especie
	@OneToMany(mappedBy="mntModeloMarca")
	private List<Especie> expEspecies;

	//bi-directional many-to-one association to Explosivo
	@OneToMany(mappedBy="mntModeloMarca1")
	private List<Explosivo> expExplosivos1;

	//bi-directional many-to-one association to Explosivo
	@OneToMany(mappedBy="mntModeloMarca2")
	private List<Explosivo> expExplosivos2;

	//bi-directional one-to-one association to Municion
	@OneToOne(mappedBy="mntModeloMarca1")
	private Municion expMunicione;

	//bi-directional many-to-one association to Municion
	@OneToMany(mappedBy="mntModeloMarca2")
	private List<Municion> expMuniciones1;

	//bi-directional many-to-one association to Municion
	@OneToMany(mappedBy="mntModeloMarca3")
	private List<Municion> expMuniciones2;

	//bi-directional many-to-one association to Vehiculo
	@OneToMany(mappedBy="mntModeloMarca")
	private List<Vehiculo> expVehiculos;

	//bi-directional many-to-one association to Hojaremision
	@OneToMany(mappedBy="mntModeloMarca")
	private List<Hojaremision> hrHojaremisions;

	//bi-directional many-to-one association to HojaremisionMuestra
	@OneToMany(mappedBy="mntModeloMarca")
	private List<HojaremisionMuestra> hrHojaremisionMuestras;

	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="TIPO")
	private Valor cfgValor;

	//bi-directional many-to-one association to ModeloMarca
	@ManyToOne
	@JoinColumn(name="PADRE")
	private ModeloMarca mntModeloMarca;

	//bi-directional many-to-one association to ModeloMarca
	@OneToMany(mappedBy="mntModeloMarca")
	private List<ModeloMarca> mntModeloMarcas;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="CREADOR", nullable=false)
	private Usuario segUsuario1;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="EDITOR")
	private Usuario segUsuario2;

	//bi-directional many-to-one association to Telefono
	@OneToMany(mappedBy="mntModeloMarca")
	private List<Telefono> perTelefonos;

	public ModeloMarca() {
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

	public List<Arma> getExpArmas() {
		return this.expArmas;
	}

	public void setExpArmas(List<Arma> expArmas) {
		this.expArmas = expArmas;
	}

	public Arma addExpArma(Arma expArma) {
		getExpArmas().add(expArma);
		expArma.setMntModeloMarca(this);

		return expArma;
	}

	public Arma removeExpArma(Arma expArma) {
		getExpArmas().remove(expArma);
		expArma.setMntModeloMarca(null);

		return expArma;
	}

	public List<Droga> getExpDrogas1() {
		return this.expDrogas1;
	}

	public void setExpDrogas1(List<Droga> expDrogas1) {
		this.expDrogas1 = expDrogas1;
	}

	public Droga addExpDrogas1(Droga expDrogas1) {
		getExpDrogas1().add(expDrogas1);
		expDrogas1.setMntModeloMarca1(this);

		return expDrogas1;
	}

	public Droga removeExpDrogas1(Droga expDrogas1) {
		getExpDrogas1().remove(expDrogas1);
		expDrogas1.setMntModeloMarca1(null);

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
		expDrogas2.setMntModeloMarca2(this);

		return expDrogas2;
	}

	public Droga removeExpDrogas2(Droga expDrogas2) {
		getExpDrogas2().remove(expDrogas2);
		expDrogas2.setMntModeloMarca2(null);

		return expDrogas2;
	}

	public List<Especie> getExpEspecies() {
		return this.expEspecies;
	}

	public void setExpEspecies(List<Especie> expEspecies) {
		this.expEspecies = expEspecies;
	}

	public Especie addExpEspecy(Especie expEspecy) {
		getExpEspecies().add(expEspecy);
		expEspecy.setMntModeloMarca(this);

		return expEspecy;
	}

	public Especie removeExpEspecy(Especie expEspecy) {
		getExpEspecies().remove(expEspecy);
		expEspecy.setMntModeloMarca(null);

		return expEspecy;
	}

	public List<Explosivo> getExpExplosivos1() {
		return this.expExplosivos1;
	}

	public void setExpExplosivos1(List<Explosivo> expExplosivos1) {
		this.expExplosivos1 = expExplosivos1;
	}

	public Explosivo addExpExplosivos1(Explosivo expExplosivos1) {
		getExpExplosivos1().add(expExplosivos1);
		expExplosivos1.setMntModeloMarca1(this);

		return expExplosivos1;
	}

	public Explosivo removeExpExplosivos1(Explosivo expExplosivos1) {
		getExpExplosivos1().remove(expExplosivos1);
		expExplosivos1.setMntModeloMarca1(null);

		return expExplosivos1;
	}

	public List<Explosivo> getExpExplosivos2() {
		return this.expExplosivos2;
	}

	public void setExpExplosivos2(List<Explosivo> expExplosivos2) {
		this.expExplosivos2 = expExplosivos2;
	}

	public Explosivo addExpExplosivos2(Explosivo expExplosivos2) {
		getExpExplosivos2().add(expExplosivos2);
		expExplosivos2.setMntModeloMarca2(this);

		return expExplosivos2;
	}

	public Explosivo removeExpExplosivos2(Explosivo expExplosivos2) {
		getExpExplosivos2().remove(expExplosivos2);
		expExplosivos2.setMntModeloMarca2(null);

		return expExplosivos2;
	}

	public Municion getExpMunicione() {
		return this.expMunicione;
	}

	public void setExpMunicione(Municion expMunicione) {
		this.expMunicione = expMunicione;
	}

	public List<Municion> getExpMuniciones1() {
		return this.expMuniciones1;
	}

	public void setExpMuniciones1(List<Municion> expMuniciones1) {
		this.expMuniciones1 = expMuniciones1;
	}

	public Municion addExpMuniciones1(Municion expMuniciones1) {
		getExpMuniciones1().add(expMuniciones1);
		expMuniciones1.setMntModeloMarca2(this);

		return expMuniciones1;
	}

	public Municion removeExpMuniciones1(Municion expMuniciones1) {
		getExpMuniciones1().remove(expMuniciones1);
		expMuniciones1.setMntModeloMarca2(null);

		return expMuniciones1;
	}

	public List<Municion> getExpMuniciones2() {
		return this.expMuniciones2;
	}

	public void setExpMuniciones2(List<Municion> expMuniciones2) {
		this.expMuniciones2 = expMuniciones2;
	}

	public Municion addExpMuniciones2(Municion expMuniciones2) {
		getExpMuniciones2().add(expMuniciones2);
		expMuniciones2.setMntModeloMarca3(this);

		return expMuniciones2;
	}

	public Municion removeExpMuniciones2(Municion expMuniciones2) {
		getExpMuniciones2().remove(expMuniciones2);
		expMuniciones2.setMntModeloMarca3(null);

		return expMuniciones2;
	}

	public List<Vehiculo> getExpVehiculos() {
		return this.expVehiculos;
	}

	public void setExpVehiculos(List<Vehiculo> expVehiculos) {
		this.expVehiculos = expVehiculos;
	}

	public Vehiculo addExpVehiculo(Vehiculo expVehiculo) {
		getExpVehiculos().add(expVehiculo);
		expVehiculo.setMntModeloMarca(this);

		return expVehiculo;
	}

	public Vehiculo removeExpVehiculo(Vehiculo expVehiculo) {
		getExpVehiculos().remove(expVehiculo);
		expVehiculo.setMntModeloMarca(null);

		return expVehiculo;
	}

	public List<Hojaremision> getHrHojaremisions() {
		return this.hrHojaremisions;
	}

	public void setHrHojaremisions(List<Hojaremision> hrHojaremisions) {
		this.hrHojaremisions = hrHojaremisions;
	}

	public Hojaremision addHrHojaremision(Hojaremision hrHojaremision) {
		getHrHojaremisions().add(hrHojaremision);
		hrHojaremision.setMntModeloMarca(this);

		return hrHojaremision;
	}

	public Hojaremision removeHrHojaremision(Hojaremision hrHojaremision) {
		getHrHojaremisions().remove(hrHojaremision);
		hrHojaremision.setMntModeloMarca(null);

		return hrHojaremision;
	}

	public List<HojaremisionMuestra> getHrHojaremisionMuestras() {
		return this.hrHojaremisionMuestras;
	}

	public void setHrHojaremisionMuestras(List<HojaremisionMuestra> hrHojaremisionMuestras) {
		this.hrHojaremisionMuestras = hrHojaremisionMuestras;
	}

	public HojaremisionMuestra addHrHojaremisionMuestra(HojaremisionMuestra hrHojaremisionMuestra) {
		getHrHojaremisionMuestras().add(hrHojaremisionMuestra);
		hrHojaremisionMuestra.setMntModeloMarca(this);

		return hrHojaremisionMuestra;
	}

	public HojaremisionMuestra removeHrHojaremisionMuestra(HojaremisionMuestra hrHojaremisionMuestra) {
		getHrHojaremisionMuestras().remove(hrHojaremisionMuestra);
		hrHojaremisionMuestra.setMntModeloMarca(null);

		return hrHojaremisionMuestra;
	}

	public Valor getCfgValor() {
		return this.cfgValor;
	}

	public void setCfgValor(Valor cfgValor) {
		this.cfgValor = cfgValor;
	}

	public ModeloMarca getMntModeloMarca() {
		return this.mntModeloMarca;
	}

	public void setMntModeloMarca(ModeloMarca mntModeloMarca) {
		this.mntModeloMarca = mntModeloMarca;
	}

	public List<ModeloMarca> getMntModeloMarcas() {
		return this.mntModeloMarcas;
	}

	public void setMntModeloMarcas(List<ModeloMarca> mntModeloMarcas) {
		this.mntModeloMarcas = mntModeloMarcas;
	}

	public ModeloMarca addMntModeloMarca(ModeloMarca mntModeloMarca) {
		getMntModeloMarcas().add(mntModeloMarca);
		mntModeloMarca.setMntModeloMarca(this);

		return mntModeloMarca;
	}

	public ModeloMarca removeMntModeloMarca(ModeloMarca mntModeloMarca) {
		getMntModeloMarcas().remove(mntModeloMarca);
		mntModeloMarca.setMntModeloMarca(null);

		return mntModeloMarca;
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

	public List<Telefono> getPerTelefonos() {
		return this.perTelefonos;
	}

	public void setPerTelefonos(List<Telefono> perTelefonos) {
		this.perTelefonos = perTelefonos;
	}

	public Telefono addPerTelefono(Telefono perTelefono) {
		getPerTelefonos().add(perTelefono);
		perTelefono.setMntModeloMarca(this);

		return perTelefono;
	}

	public Telefono removePerTelefono(Telefono perTelefono) {
		getPerTelefonos().remove(perTelefono);
		perTelefono.setMntModeloMarca(null);

		return perTelefono;
	}

}