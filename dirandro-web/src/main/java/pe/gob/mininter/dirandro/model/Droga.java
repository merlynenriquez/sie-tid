package pe.gob.mininter.dirandro.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the EXP_DROGAS database table.
 * 
 */
@Entity
@Table(name="EXP_DROGAS")
public class Droga implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="EXP_DROGAS_ID_GENERATOR", sequenceName="SEQ_")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="EXP_DROGAS_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=16)
	private long id;

	@Column(nullable=false)
	private Timestamp creacion;

	private Timestamp edicion;

	@Column(length=1600)
	private String observacion;

	@Column(name="PESO_BRUTO", precision=10, scale=2)
	private BigDecimal pesoBruto;

	@Column(name="PESO_MUESTRA", precision=10, scale=2)
	private BigDecimal pesoMuestra;

	@Column(name="PESO_NETO", precision=10, scale=2)
	private BigDecimal pesoNeto;

	@Column(name="TIPO_CAMBIO", precision=10, scale=2)
	private BigDecimal tipoCambio;

	@Column(name="VALOR_DOLARES", precision=10, scale=2)
	private BigDecimal valorDolares;

	@Column(name="VALOR_SOLES", precision=10, scale=2)
	private BigDecimal valorSoles;

	//bi-directional many-to-one association to DetDroga
	@OneToMany(mappedBy="expDroga")
	private List<DetDroga> expDetDrogas;

	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="TIPO_MEDIDA")
	private Valor cfgValor1;

	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="TIPO_MEDIDA_MUESTRA")
	private Valor cfgValor2;

	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="TIPO_DROGA")
	private Valor cfgValor3;

	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="SITUACION")
	private Valor cfgValor4;

	//bi-directional many-to-one association to Expediente
	@ManyToOne
	@JoinColumn(name="EXPEDIENTE")
	private Expediente expExpediente;

	//bi-directional many-to-one association to Pais
	@ManyToOne
	@JoinColumn(name="PROCEDENCIA")
	private Pais mntPais1;

	//bi-directional many-to-one association to Pais
	@ManyToOne
	@JoinColumn(name="DESTINO", nullable=false)
	private Pais mntPais2;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="EDITOR")
	private Usuario segUsuario1;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="CREADOR", nullable=false)
	private Usuario segUsuario2;

	//bi-directional many-to-one association to HojaremisionMuestra
	@OneToMany(mappedBy="expDroga")
	private List<HojaremisionMuestra> hrHojaremisionMuestras;

	public Droga() {
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

	public String getObservacion() {
		return this.observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public BigDecimal getPesoBruto() {
		return this.pesoBruto;
	}

	public void setPesoBruto(BigDecimal pesoBruto) {
		this.pesoBruto = pesoBruto;
	}

	public BigDecimal getPesoMuestra() {
		return this.pesoMuestra;
	}

	public void setPesoMuestra(BigDecimal pesoMuestra) {
		this.pesoMuestra = pesoMuestra;
	}

	public BigDecimal getPesoNeto() {
		return this.pesoNeto;
	}

	public void setPesoNeto(BigDecimal pesoNeto) {
		this.pesoNeto = pesoNeto;
	}

	public BigDecimal getTipoCambio() {
		return this.tipoCambio;
	}

	public void setTipoCambio(BigDecimal tipoCambio) {
		this.tipoCambio = tipoCambio;
	}

	public BigDecimal getValorDolares() {
		return this.valorDolares;
	}

	public void setValorDolares(BigDecimal valorDolares) {
		this.valorDolares = valorDolares;
	}

	public BigDecimal getValorSoles() {
		return this.valorSoles;
	}

	public void setValorSoles(BigDecimal valorSoles) {
		this.valorSoles = valorSoles;
	}

	public List<DetDroga> getExpDetDrogas() {
		return this.expDetDrogas;
	}

	public void setExpDetDrogas(List<DetDroga> expDetDrogas) {
		this.expDetDrogas = expDetDrogas;
	}

	public DetDroga addExpDetDroga(DetDroga expDetDroga) {
		getExpDetDrogas().add(expDetDroga);
		expDetDroga.setExpDroga(this);

		return expDetDroga;
	}

	public DetDroga removeExpDetDroga(DetDroga expDetDroga) {
		getExpDetDrogas().remove(expDetDroga);
		expDetDroga.setExpDroga(null);

		return expDetDroga;
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

	public Expediente getExpExpediente() {
		return this.expExpediente;
	}

	public void setExpExpediente(Expediente expExpediente) {
		this.expExpediente = expExpediente;
	}

	public Pais getMntPais1() {
		return this.mntPais1;
	}

	public void setMntPais1(Pais mntPais1) {
		this.mntPais1 = mntPais1;
	}

	public Pais getMntPais2() {
		return this.mntPais2;
	}

	public void setMntPais2(Pais mntPais2) {
		this.mntPais2 = mntPais2;
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

	public List<HojaremisionMuestra> getHrHojaremisionMuestras() {
		return this.hrHojaremisionMuestras;
	}

	public void setHrHojaremisionMuestras(List<HojaremisionMuestra> hrHojaremisionMuestras) {
		this.hrHojaremisionMuestras = hrHojaremisionMuestras;
	}

	public HojaremisionMuestra addHrHojaremisionMuestra(HojaremisionMuestra hrHojaremisionMuestra) {
		getHrHojaremisionMuestras().add(hrHojaremisionMuestra);
		hrHojaremisionMuestra.setExpDroga(this);

		return hrHojaremisionMuestra;
	}

	public HojaremisionMuestra removeHrHojaremisionMuestra(HojaremisionMuestra hrHojaremisionMuestra) {
		getHrHojaremisionMuestras().remove(hrHojaremisionMuestra);
		hrHojaremisionMuestra.setExpDroga(null);

		return hrHojaremisionMuestra;
	}

}