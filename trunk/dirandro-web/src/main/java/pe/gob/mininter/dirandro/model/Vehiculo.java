package pe.gob.mininter.dirandro.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import pe.gob.mininter.dirandro.util.Validador;
import pe.gob.mininter.dirandro.util.beanbase.AuditoriaBean;


/**
 * The persistent class for the EXP_VEHICULO database table.
 * 
 */
@Entity
@Table(name="EXP_VEHICULO")
public class Vehiculo extends AuditoriaBean implements Validador, Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8452393232453894146L;

	@Id
	@SequenceGenerator(name="EXP_VEHICULO_ID_GENERATOR", sequenceName="SEQ_")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="EXP_VEHICULO_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=16)
	private Long id;

	@Column(name="MODELO_ESPECIFICO", length=50)
	private String modeloEspecifico;

	@Column(length=800)
	private String observaciones;

	@Column(length=200)
	private String placa;

	@Column(precision=16)
	private BigDecimal propietario;

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
	private Valor cilindros;

	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="TIPO_TAMANO")
	private Valor tipoTamano;

	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="ANO")
	private Valor ano;

	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="TRANSMISION")
	private Valor transmision;

	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="COLOR")
	private Valor color;

	//bi-directional many-to-one association to ModeloMarca
	@ManyToOne
	@JoinColumn(name="MODELO")
	private ModeloMarca mntModeloMarca;

	public Vehiculo() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getModeloEspecifico() {
		return modeloEspecifico;
	}

	public void setModeloEspecifico(String modeloEspecifico) {
		this.modeloEspecifico = modeloEspecifico;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public BigDecimal getPropietario() {
		return propietario;
	}

	public void setPropietario(BigDecimal propietario) {
		this.propietario = propietario;
	}

	public String getSerieChasis() {
		return serieChasis;
	}

	public void setSerieChasis(String serieChasis) {
		this.serieChasis = serieChasis;
	}

	public String getSerieMotor() {
		return serieMotor;
	}

	public void setSerieMotor(String serieMotor) {
		this.serieMotor = serieMotor;
	}

	public List<DetPerVehExp> getExpDetPerVehExps() {
		return expDetPerVehExps;
	}

	public void setExpDetPerVehExps(List<DetPerVehExp> expDetPerVehExps) {
		this.expDetPerVehExps = expDetPerVehExps;
	}

	public Valor getCilindros() {
		return cilindros;
	}

	public void setCilindros(Valor cilindros) {
		this.cilindros = cilindros;
	}

	public Valor getTipoTamano() {
		return tipoTamano;
	}

	public void setTipoTamano(Valor tipoTamano) {
		this.tipoTamano = tipoTamano;
	}

	public Valor getAno() {
		return ano;
	}

	public void setAno(Valor ano) {
		this.ano = ano;
	}

	public Valor getTransmision() {
		return transmision;
	}

	public void setTransmision(Valor transmision) {
		this.transmision = transmision;
	}

	public Valor getColor() {
		return color;
	}

	public void setColor(Valor color) {
		this.color = color;
	}

	public ModeloMarca getMntModeloMarca() {
		return mntModeloMarca;
	}

	public void setMntModeloMarca(ModeloMarca mntModeloMarca) {
		this.mntModeloMarca = mntModeloMarca;
	}

	@Override
	public void validar() {
		// TODO Auto-generated method stub
		
	}

}