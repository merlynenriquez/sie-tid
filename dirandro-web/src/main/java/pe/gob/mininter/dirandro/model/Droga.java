package pe.gob.mininter.dirandro.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
	@SequenceGenerator(name="EXP_DROGAS_ID_GENERATOR", sequenceName="SEQ_", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="EXP_DROGAS_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=16)
	private Long id;

	@Column(length=4000)
	private String observacion;

	@Column(name="PESO_BRUTO", precision=10, scale=2)
	private Double pesoBruto;

	@Column(name="PESO_MUESTRA", precision=10, scale=2)
	private Double pesoMuestra;

	@Column(name="PESO_NETO", precision=10, scale=2)
	private Double pesoNeto;

	@Column(name="TIPO_CAMBIO", precision=10, scale=2)
	private Double tipoCambio;

	@Column(name="VALOR_DOLARES", precision=10, scale=2)
	private Double valorDolares;

	@Column(name="VALOR_SOLES", precision=10, scale=2)
	private Double valorSoles;

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

	public Double getPesoBruto() {
		return pesoBruto;
	}

	public void setPesoBruto(Double pesoBruto) {
		this.pesoBruto = pesoBruto;
	}

	public Double getPesoMuestra() {
		return pesoMuestra;
	}

	public void setPesoMuestra(Double pesoMuestra) {
		this.pesoMuestra = pesoMuestra;
	}

	public Double getPesoNeto() {
		return pesoNeto;
	}

	public void setPesoNeto(Double pesoNeto) {
		this.pesoNeto = pesoNeto;
	}

	public Double getTipoCambio() {
		return tipoCambio;
	}

	public void setTipoCambio(Double tipoCambio) {
		this.tipoCambio = tipoCambio;
	}

	public Double getValorDolares() {
		return valorDolares;
	}

	public void setValorDolares(Double valorDolares) {
		this.valorDolares = valorDolares;
	}

	public Double getValorSoles() {
		return valorSoles;
	}

	public void setValorSoles(Double valorSoles) {
		this.valorSoles = valorSoles;
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
	
	@Override
	public void validar() {
		// TODO Auto-generated method stub
		
	}

}