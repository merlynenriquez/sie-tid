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
 * The persistent class for the EXP_DROGAS database table.
 * 
 */
@Entity
@Table(name="EXP_DROGAS")
public class Droga extends AuditoriaBean implements Validador, Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 791716717760796752L;

	@Id
	@SequenceGenerator(name="EXP_DROGAS_ID_GENERATOR", sequenceName="SEQ_")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="EXP_DROGAS_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=16)
	private Long id;

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
	private Valor tipoMedida;

	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="TIPO_MEDIDA_MUESTRA")
	private Valor tipoMedidaMuestra;

	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="TIPO_DROGA")
	private Valor tipoDroga;

	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="SITUACION")
	private Valor situaccion;

	//bi-directional many-to-one association to Expediente
	@ManyToOne
	@JoinColumn(name="EXPEDIENTE")
	private Expediente expExpediente;

	//bi-directional many-to-one association to Pais
	@ManyToOne
	@JoinColumn(name="PROCEDENCIA")
	private Pais procedencia;

	//bi-directional many-to-one association to Pais
	@ManyToOne
	@JoinColumn(name="DESTINO", nullable=false)
	private Pais destino;

	//bi-directional many-to-one association to HojaremisionMuestra
	@OneToMany(mappedBy="expDroga")
	private List<HojaremisionMuestra> hrHojaremisionMuestras;

	public Droga() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public BigDecimal getPesoBruto() {
		return pesoBruto;
	}

	public void setPesoBruto(BigDecimal pesoBruto) {
		this.pesoBruto = pesoBruto;
	}

	public BigDecimal getPesoMuestra() {
		return pesoMuestra;
	}

	public void setPesoMuestra(BigDecimal pesoMuestra) {
		this.pesoMuestra = pesoMuestra;
	}

	public BigDecimal getPesoNeto() {
		return pesoNeto;
	}

	public void setPesoNeto(BigDecimal pesoNeto) {
		this.pesoNeto = pesoNeto;
	}

	public BigDecimal getTipoCambio() {
		return tipoCambio;
	}

	public void setTipoCambio(BigDecimal tipoCambio) {
		this.tipoCambio = tipoCambio;
	}

	public BigDecimal getValorDolares() {
		return valorDolares;
	}

	public void setValorDolares(BigDecimal valorDolares) {
		this.valorDolares = valorDolares;
	}

	public BigDecimal getValorSoles() {
		return valorSoles;
	}

	public void setValorSoles(BigDecimal valorSoles) {
		this.valorSoles = valorSoles;
	}

	public List<DetDroga> getExpDetDrogas() {
		return expDetDrogas;
	}

	public void setExpDetDrogas(List<DetDroga> expDetDrogas) {
		this.expDetDrogas = expDetDrogas;
	}

	public Valor getTipoMedida() {
		return tipoMedida;
	}

	public void setTipoMedida(Valor tipoMedida) {
		this.tipoMedida = tipoMedida;
	}

	public Valor getTipoMedidaMuestra() {
		return tipoMedidaMuestra;
	}

	public void setTipoMedidaMuestra(Valor tipoMedidaMuestra) {
		this.tipoMedidaMuestra = tipoMedidaMuestra;
	}

	public Valor getTipoDroga() {
		return tipoDroga;
	}

	public void setTipoDroga(Valor tipoDroga) {
		this.tipoDroga = tipoDroga;
	}

	public Valor getSituaccion() {
		return situaccion;
	}

	public void setSituaccion(Valor situaccion) {
		this.situaccion = situaccion;
	}

	public Expediente getExpExpediente() {
		return expExpediente;
	}

	public void setExpExpediente(Expediente expExpediente) {
		this.expExpediente = expExpediente;
	}

	public Pais getProcedencia() {
		return procedencia;
	}

	public void setProcedencia(Pais procedencia) {
		this.procedencia = procedencia;
	}

	public Pais getDestino() {
		return destino;
	}

	public void setDestino(Pais destino) {
		this.destino = destino;
	}

	public List<HojaremisionMuestra> getHrHojaremisionMuestras() {
		return hrHojaremisionMuestras;
	}

	public void setHrHojaremisionMuestras(
			List<HojaremisionMuestra> hrHojaremisionMuestras) {
		this.hrHojaremisionMuestras = hrHojaremisionMuestras;
	}

	@Override
	public void validar() {
		// TODO Auto-generated method stub
		
	}

}