package pe.gob.mininter.dirandro.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the EXP_ARMAS database table.
 * 
 */
@Entity
@Table(name="EXP_ARMAS")
public class Arma implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="EXP_ARMAS_ID_GENERATOR", sequenceName="SEQ_")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="EXP_ARMAS_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=16)
	private long id;

	@Column(nullable=false)
	private Timestamp creacion;

	private Timestamp edicion;

	@Column(length=100)
	private String internamiento;

	@Column(name="NRO_LICENCIA", length=20)
	private String nroLicencia;

	@Column(name="NRO_SERIE", length=100)
	private String nroSerie;

	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="CLASIFICACION")
	private Valor cfgValor1;

	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="CALIBRE")
	private Valor cfgValor2;

	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="EST_SERIE")
	private Valor cfgValor3;

	//bi-directional many-to-one association to ModeloMarca
	@ManyToOne
	@JoinColumn(name="MODELO")
	private ModeloMarca mntModeloMarca;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="CREADOR", nullable=false)
	private Usuario segUsuario1;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="EDITOR")
	private Usuario segUsuario2;

	//bi-directional many-to-one association to DetPerArmExp
	@OneToMany(mappedBy="expArma")
	private List<DetPerArmExp> expDetPerArmExps;

	public Arma() {
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

	public String getInternamiento() {
		return this.internamiento;
	}

	public void setInternamiento(String internamiento) {
		this.internamiento = internamiento;
	}

	public String getNroLicencia() {
		return this.nroLicencia;
	}

	public void setNroLicencia(String nroLicencia) {
		this.nroLicencia = nroLicencia;
	}

	public String getNroSerie() {
		return this.nroSerie;
	}

	public void setNroSerie(String nroSerie) {
		this.nroSerie = nroSerie;
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

	public List<DetPerArmExp> getExpDetPerArmExps() {
		return this.expDetPerArmExps;
	}

	public void setExpDetPerArmExps(List<DetPerArmExp> expDetPerArmExps) {
		this.expDetPerArmExps = expDetPerArmExps;
	}

	public DetPerArmExp addExpDetPerArmExp(DetPerArmExp expDetPerArmExp) {
		getExpDetPerArmExps().add(expDetPerArmExp);
		expDetPerArmExp.setExpArma(this);

		return expDetPerArmExp;
	}

	public DetPerArmExp removeExpDetPerArmExp(DetPerArmExp expDetPerArmExp) {
		getExpDetPerArmExps().remove(expDetPerArmExp);
		expDetPerArmExp.setExpArma(null);

		return expDetPerArmExp;
	}

}