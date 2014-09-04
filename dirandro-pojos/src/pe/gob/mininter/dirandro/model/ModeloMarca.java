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
	@OneToMany(mappedBy="mntModeloMarca1")
	private List<Arma> expArmas1;

	//bi-directional many-to-one association to Arma
	@OneToMany(mappedBy="mntModeloMarca2")
	private List<Arma> expArmas2;

	//bi-directional many-to-one association to Explosivo
	@OneToMany(mappedBy="mntModeloMarca")
	private List<Explosivo> expExplosivos;

	//bi-directional one-to-one association to Municion
	@OneToOne(mappedBy="mntModeloMarca1")
	private Municion expMunicione;

	//bi-directional many-to-one association to Municion
	@OneToMany(mappedBy="mntModeloMarca2")
	private List<Municion> expMuniciones;

	//bi-directional many-to-one association to Vehiculo
	@OneToMany(mappedBy="mntModeloMarca")
	private List<Vehiculo> expVehiculos;

	//bi-directional many-to-one association to Hojaremision
	@OneToMany(mappedBy="mntModeloMarca")
	private List<Hojaremision> hrHojaremisions;

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

	public List<Arma> getExpArmas1() {
		return this.expArmas1;
	}

	public void setExpArmas1(List<Arma> expArmas1) {
		this.expArmas1 = expArmas1;
	}

	public Arma addExpArmas1(Arma expArmas1) {
		getExpArmas1().add(expArmas1);
		expArmas1.setMntModeloMarca1(this);

		return expArmas1;
	}

	public Arma removeExpArmas1(Arma expArmas1) {
		getExpArmas1().remove(expArmas1);
		expArmas1.setMntModeloMarca1(null);

		return expArmas1;
	}

	public List<Arma> getExpArmas2() {
		return this.expArmas2;
	}

	public void setExpArmas2(List<Arma> expArmas2) {
		this.expArmas2 = expArmas2;
	}

	public Arma addExpArmas2(Arma expArmas2) {
		getExpArmas2().add(expArmas2);
		expArmas2.setMntModeloMarca2(this);

		return expArmas2;
	}

	public Arma removeExpArmas2(Arma expArmas2) {
		getExpArmas2().remove(expArmas2);
		expArmas2.setMntModeloMarca2(null);

		return expArmas2;
	}

	public List<Explosivo> getExpExplosivos() {
		return this.expExplosivos;
	}

	public void setExpExplosivos(List<Explosivo> expExplosivos) {
		this.expExplosivos = expExplosivos;
	}

	public Explosivo addExpExplosivo(Explosivo expExplosivo) {
		getExpExplosivos().add(expExplosivo);
		expExplosivo.setMntModeloMarca(this);

		return expExplosivo;
	}

	public Explosivo removeExpExplosivo(Explosivo expExplosivo) {
		getExpExplosivos().remove(expExplosivo);
		expExplosivo.setMntModeloMarca(null);

		return expExplosivo;
	}

	public Municion getExpMunicione() {
		return this.expMunicione;
	}

	public void setExpMunicione(Municion expMunicione) {
		this.expMunicione = expMunicione;
	}

	public List<Municion> getExpMuniciones() {
		return this.expMuniciones;
	}

	public void setExpMuniciones(List<Municion> expMuniciones) {
		this.expMuniciones = expMuniciones;
	}

	public Municion addExpMunicione(Municion expMunicione) {
		getExpMuniciones().add(expMunicione);
		expMunicione.setMntModeloMarca2(this);

		return expMunicione;
	}

	public Municion removeExpMunicione(Municion expMunicione) {
		getExpMuniciones().remove(expMunicione);
		expMunicione.setMntModeloMarca2(null);

		return expMunicione;
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