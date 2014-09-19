package pe.gob.mininter.dirandro.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the EXP_VEHICULO database table.
 * 
 */
@Entity
@Table(name="EXP_VEHICULO")
public class Vehiculo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="EXP_VEHICULO_ID_GENERATOR", sequenceName="SEQ_")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="EXP_VEHICULO_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=16)
	private long id;

	@Column(nullable=false)
	private Timestamp creacion;

	private Timestamp edicion;

	@Column(name="MODELO_ESPECIFICO", length=500)
	private String modeloEspecifico;

	@Column(length=200)
	private String placa;

	@Column(name="SERIE_CHASIS", length=100)
	private String serieChasis;

	@Column(name="SERIE_MOTOR", length=100)
	private String serieMotor;

	//bi-directional many-to-one association to DetPerVehExp
	@OneToMany(mappedBy="expVehiculo")
	private List<DetPerVehExp> expDetPerVehExps;

	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="CILINDROS", nullable=false)
	private Valor cfgValor1;

	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="TIPO_TAMANO")
	private Valor cfgValor2;

	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="TRANSMISION")
	private Valor cfgValor3;

	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="COLOR")
	private Valor cfgValor4;

	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="PERIODO_FABRICACION")
	private Valor cfgValor5;

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

	public Vehiculo() {
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

	public String getModeloEspecifico() {
		return this.modeloEspecifico;
	}

	public void setModeloEspecifico(String modeloEspecifico) {
		this.modeloEspecifico = modeloEspecifico;
	}

	public String getPlaca() {
		return this.placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getSerieChasis() {
		return this.serieChasis;
	}

	public void setSerieChasis(String serieChasis) {
		this.serieChasis = serieChasis;
	}

	public String getSerieMotor() {
		return this.serieMotor;
	}

	public void setSerieMotor(String serieMotor) {
		this.serieMotor = serieMotor;
	}

	public List<DetPerVehExp> getExpDetPerVehExps() {
		return this.expDetPerVehExps;
	}

	public void setExpDetPerVehExps(List<DetPerVehExp> expDetPerVehExps) {
		this.expDetPerVehExps = expDetPerVehExps;
	}

	public DetPerVehExp addExpDetPerVehExp(DetPerVehExp expDetPerVehExp) {
		getExpDetPerVehExps().add(expDetPerVehExp);
		expDetPerVehExp.setExpVehiculo(this);

		return expDetPerVehExp;
	}

	public DetPerVehExp removeExpDetPerVehExp(DetPerVehExp expDetPerVehExp) {
		getExpDetPerVehExps().remove(expDetPerVehExp);
		expDetPerVehExp.setExpVehiculo(null);

		return expDetPerVehExp;
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

	public Valor getCfgValor4() {
		return this.cfgValor4;
	}

	public void setCfgValor4(Valor cfgValor4) {
		this.cfgValor4 = cfgValor4;
	}

	public Valor getCfgValor5() {
		return this.cfgValor5;
	}

	public void setCfgValor5(Valor cfgValor5) {
		this.cfgValor5 = cfgValor5;
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