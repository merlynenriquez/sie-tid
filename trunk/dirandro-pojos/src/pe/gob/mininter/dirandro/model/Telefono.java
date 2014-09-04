package pe.gob.mininter.dirandro.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the PER_TELEFONO database table.
 * 
 */
@Entity
@Table(name="PER_TELEFONO")
public class Telefono implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="PER_TELEFONO_ID_GENERATOR", sequenceName="SEQ_")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PER_TELEFONO_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=16)
	private long id;

	@Column(length=50)
	private String alcance;

	@Column(nullable=false)
	private Timestamp creacion;

	private Timestamp edicion;

	@Column(nullable=false, length=100)
	private String numero;

	@Column(length=50)
	private String serie;

	//bi-directional many-to-one association to DetPerTelExp
	@OneToMany(mappedBy="perTelefono")
	private List<DetPerTelExp> expDetPerTelExps;

	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="TIPO", nullable=false)
	private Valor cfgValor1;

	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="ESTADO")
	private Valor cfgValor2;

	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="FRECUENCIA")
	private Valor cfgValor3;

	//bi-directional many-to-one association to ModeloMarca
	@ManyToOne
	@JoinColumn(name="MARCA")
	private ModeloMarca mntModeloMarca;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="CREADOR", nullable=false)
	private Usuario segUsuario1;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="EDITOR")
	private Usuario segUsuario2;

	public Telefono() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAlcance() {
		return this.alcance;
	}

	public void setAlcance(String alcance) {
		this.alcance = alcance;
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

	public String getNumero() {
		return this.numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getSerie() {
		return this.serie;
	}

	public void setSerie(String serie) {
		this.serie = serie;
	}

	public List<DetPerTelExp> getExpDetPerTelExps() {
		return this.expDetPerTelExps;
	}

	public void setExpDetPerTelExps(List<DetPerTelExp> expDetPerTelExps) {
		this.expDetPerTelExps = expDetPerTelExps;
	}

	public DetPerTelExp addExpDetPerTelExp(DetPerTelExp expDetPerTelExp) {
		getExpDetPerTelExps().add(expDetPerTelExp);
		expDetPerTelExp.setPerTelefono(this);

		return expDetPerTelExp;
	}

	public DetPerTelExp removeExpDetPerTelExp(DetPerTelExp expDetPerTelExp) {
		getExpDetPerTelExps().remove(expDetPerTelExp);
		expDetPerTelExp.setPerTelefono(null);

		return expDetPerTelExp;
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

	public Valor getCfgValor3() {
		return this.cfgValor3;
	}

	public void setCfgValor3(Valor cfgValor3) {
		this.cfgValor3 = cfgValor3;
	}

	public ModeloMarca getMntModeloMarca() {
		return this.mntModeloMarca;
	}

	public void setMntModeloMarca(ModeloMarca mntModeloMarca) {
		this.mntModeloMarca = mntModeloMarca;
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