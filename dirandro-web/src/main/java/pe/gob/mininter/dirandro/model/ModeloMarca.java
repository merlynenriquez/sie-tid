package pe.gob.mininter.dirandro.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import pe.gob.mininter.dirandro.util.Validador;
import pe.gob.mininter.dirandro.util.beanbase.AuditoriaBean;


/**
 * The persistent class for the MNT_MODELO_MARCA database table.
 * 
 */
@Entity
@Table(name="MNT_MODELO_MARCA")
public class ModeloMarca extends AuditoriaBean implements Validador, Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 9127973250630000562L;

	@Id
	@SequenceGenerator(name="MNT_MODELO_MARCA_ID_GENERATOR", sequenceName="SEQ_")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="MNT_MODELO_MARCA_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=16)
	private Long id;

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

	//bi-directional one-to-one association to Municione
	@OneToOne(mappedBy="mntModeloMarca")
	private Municione expMunicione;

	//bi-directional many-to-one association to Vehiculo
	@OneToMany(mappedBy="mntModeloMarca")
	private List<Vehiculo> expVehiculos;

	//bi-directional many-to-one association to Hojaremision
	@OneToMany(mappedBy="mntModeloMarca")
	private List<Hojaremision> hrHojaremisions;

	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="TIPO")
	private Valor tipo;

	//bi-directional many-to-one association to ModeloMarca
	@ManyToOne
	@JoinColumn(name="PADRE")
	private ModeloMarca mntModeloMarca;

	//bi-directional many-to-one association to ModeloMarca
	@OneToMany(mappedBy="mntModeloMarca")
	private List<ModeloMarca> mntModeloMarcas;

	//bi-directional many-to-one association to Telefono
	@OneToMany(mappedBy="mntModeloMarca")
	private List<Telefono> perTelefonos;

	public ModeloMarca() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Arma> getExpArmas1() {
		return expArmas1;
	}

	public void setExpArmas1(List<Arma> expArmas1) {
		this.expArmas1 = expArmas1;
	}

	public List<Arma> getExpArmas2() {
		return expArmas2;
	}

	public void setExpArmas2(List<Arma> expArmas2) {
		this.expArmas2 = expArmas2;
	}

	public List<Explosivo> getExpExplosivos() {
		return expExplosivos;
	}

	public void setExpExplosivos(List<Explosivo> expExplosivos) {
		this.expExplosivos = expExplosivos;
	}

	public Municione getExpMunicione() {
		return expMunicione;
	}

	public void setExpMunicione(Municione expMunicione) {
		this.expMunicione = expMunicione;
	}

	public List<Vehiculo> getExpVehiculos() {
		return expVehiculos;
	}

	public void setExpVehiculos(List<Vehiculo> expVehiculos) {
		this.expVehiculos = expVehiculos;
	}

	public List<Hojaremision> getHrHojaremisions() {
		return hrHojaremisions;
	}

	public void setHrHojaremisions(List<Hojaremision> hrHojaremisions) {
		this.hrHojaremisions = hrHojaremisions;
	}

	public Valor getTipo() {
		return tipo;
	}

	public void setTipo(Valor tipo) {
		this.tipo = tipo;
	}

	public ModeloMarca getMntModeloMarca() {
		return mntModeloMarca;
	}

	public void setMntModeloMarca(ModeloMarca mntModeloMarca) {
		this.mntModeloMarca = mntModeloMarca;
	}

	public List<ModeloMarca> getMntModeloMarcas() {
		return mntModeloMarcas;
	}

	public void setMntModeloMarcas(List<ModeloMarca> mntModeloMarcas) {
		this.mntModeloMarcas = mntModeloMarcas;
	}

	public List<Telefono> getPerTelefonos() {
		return perTelefonos;
	}

	public void setPerTelefonos(List<Telefono> perTelefonos) {
		this.perTelefonos = perTelefonos;
	}

	@Override
	public void validar() {
		// TODO Auto-generated method stub
		
	}

}