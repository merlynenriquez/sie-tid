package pe.gob.mininter.dirandro.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the HR_HOJAREMISION database table.
 * 
 */
@Entity
@Table(name="HR_HOJAREMISION")
public class Hojaremision implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="HR_HOJAREMISION_ID_GENERATOR", sequenceName="SEQ_")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="HR_HOJAREMISION_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=16)
	private long id;

	@Column(name="COSTO_TRASLADO", precision=10, scale=2)
	private BigDecimal costoTraslado;

	private Timestamp creacion;

	private Timestamp edicion;

	@Column(name="FECHA_EMISION")
	private Timestamp fechaEmision;

	@Column(name="FECHA_RECEPCION")
	private Timestamp fechaRecepcion;

	@Column(name="FECHA_TRASLADO")
	private Timestamp fechaTraslado;

	@Column(name="MOTIVO_TRASLADO", length=800)
	private String motivoTraslado;

	@Column(name="NRO_LICENCIA", length=100)
	private String nroLicencia;

	@Column(precision=22)
	private BigDecimal numero;

	@Column(length=400)
	private String observacion;

	@Column(length=400)
	private String oficio;

	@Column(name="VEHICULO_PLACA", length=100)
	private String vehiculoPlaca;

	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="TIPO_HR")
	private Valor cfgValor;

	//bi-directional many-to-one association to Dependencia
	@ManyToOne
	@JoinColumn(name="DEPENDENCIA_REMITE")
	private Dependencia expDependencia1;

	//bi-directional many-to-one association to Dependencia
	@ManyToOne
	@JoinColumn(name="DEPENDENCIA_DESTINO")
	private Dependencia expDependencia2;

	//bi-directional many-to-one association to Expediente
	@ManyToOne
	@JoinColumn(name="EXPEDIENTE")
	private Expediente expExpediente;

	//bi-directional many-to-one association to ModeloMarca
	@ManyToOne
	@JoinColumn(name="VEHICULO_MARCA", nullable=false)
	private ModeloMarca mntModeloMarca;

	//bi-directional many-to-one association to Persona
	@ManyToOne
	@JoinColumn(name="PERSONA")
	private Persona perPersona;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="CREADOR")
	private Usuario segUsuario1;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="EDITOR")
	private Usuario segUsuario2;

	//bi-directional many-to-one association to HojaremisionMuestra
	@OneToMany(mappedBy="hrHojaremision")
	private List<HojaremisionMuestra> hrHojaremisionMuestras;

	public Hojaremision() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public BigDecimal getCostoTraslado() {
		return this.costoTraslado;
	}

	public void setCostoTraslado(BigDecimal costoTraslado) {
		this.costoTraslado = costoTraslado;
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

	public Timestamp getFechaEmision() {
		return this.fechaEmision;
	}

	public void setFechaEmision(Timestamp fechaEmision) {
		this.fechaEmision = fechaEmision;
	}

	public Timestamp getFechaRecepcion() {
		return this.fechaRecepcion;
	}

	public void setFechaRecepcion(Timestamp fechaRecepcion) {
		this.fechaRecepcion = fechaRecepcion;
	}

	public Timestamp getFechaTraslado() {
		return this.fechaTraslado;
	}

	public void setFechaTraslado(Timestamp fechaTraslado) {
		this.fechaTraslado = fechaTraslado;
	}

	public String getMotivoTraslado() {
		return this.motivoTraslado;
	}

	public void setMotivoTraslado(String motivoTraslado) {
		this.motivoTraslado = motivoTraslado;
	}

	public String getNroLicencia() {
		return this.nroLicencia;
	}

	public void setNroLicencia(String nroLicencia) {
		this.nroLicencia = nroLicencia;
	}

	public BigDecimal getNumero() {
		return this.numero;
	}

	public void setNumero(BigDecimal numero) {
		this.numero = numero;
	}

	public String getObservacion() {
		return this.observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public String getOficio() {
		return this.oficio;
	}

	public void setOficio(String oficio) {
		this.oficio = oficio;
	}

	public String getVehiculoPlaca() {
		return this.vehiculoPlaca;
	}

	public void setVehiculoPlaca(String vehiculoPlaca) {
		this.vehiculoPlaca = vehiculoPlaca;
	}

	public Valor getCfgValor() {
		return this.cfgValor;
	}

	public void setCfgValor(Valor cfgValor) {
		this.cfgValor = cfgValor;
	}

	public Dependencia getExpDependencia1() {
		return this.expDependencia1;
	}

	public void setExpDependencia1(Dependencia expDependencia1) {
		this.expDependencia1 = expDependencia1;
	}

	public Dependencia getExpDependencia2() {
		return this.expDependencia2;
	}

	public void setExpDependencia2(Dependencia expDependencia2) {
		this.expDependencia2 = expDependencia2;
	}

	public Expediente getExpExpediente() {
		return this.expExpediente;
	}

	public void setExpExpediente(Expediente expExpediente) {
		this.expExpediente = expExpediente;
	}

	public ModeloMarca getMntModeloMarca() {
		return this.mntModeloMarca;
	}

	public void setMntModeloMarca(ModeloMarca mntModeloMarca) {
		this.mntModeloMarca = mntModeloMarca;
	}

	public Persona getPerPersona() {
		return this.perPersona;
	}

	public void setPerPersona(Persona perPersona) {
		this.perPersona = perPersona;
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
		hrHojaremisionMuestra.setHrHojaremision(this);

		return hrHojaremisionMuestra;
	}

	public HojaremisionMuestra removeHrHojaremisionMuestra(HojaremisionMuestra hrHojaremisionMuestra) {
		getHrHojaremisionMuestras().remove(hrHojaremisionMuestra);
		hrHojaremisionMuestra.setHrHojaremision(null);

		return hrHojaremisionMuestra;
	}

}