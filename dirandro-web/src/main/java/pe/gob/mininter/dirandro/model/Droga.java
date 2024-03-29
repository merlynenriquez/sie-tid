package pe.gob.mininter.dirandro.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import pe.gob.mininter.dirandro.exception.ValidacionException;
import pe.gob.mininter.dirandro.util.Constante;
import pe.gob.mininter.dirandro.util.Validador;
import pe.gob.mininter.dirandro.util.beanbase.AuditoriaBean;


/**
 * The persistent class for the EXP_DROGAS database table.
 * 
 */
@Entity
@Table(name="EXP_DROGAS")
public class Droga extends AuditoriaBean implements Validador, Serializable {
	
	private static final long serialVersionUID = 791716717760796752L;

	@Id
	@SequenceGenerator(name="EXP_DROGAS_ID_GENERATOR", sequenceName="SEQ_DROGA", allocationSize=1)
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
	private ModeloMarca tipoMedida;

	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="TIPO_MEDIDA_MUESTRA")
	private ModeloMarca tipoMedidaMuestra;

	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="TIPO_DROGA")
	private ModeloMarca tipoDroga;

	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="SITUACION")
	private Valor situaccion;

	//bi-directional many-to-one association to Expediente
	@ManyToOne
	@JoinColumn(name="EXPEDIENTE")
	private Expediente expediente;

	//bi-directional many-to-one association to Pais
	@ManyToOne
	@JoinColumn(name="PROCEDENCIA")
	private Pais procedencia;

	//bi-directional many-to-one association to Pais
	@ManyToOne
	@JoinColumn(name="DESTINO")
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

	public Valor getSituaccion() {
		return situaccion;
	}

	public void setSituaccion(Valor situaccion) {
		this.situaccion = situaccion;
	}

	public Expediente getExpediente() {
		return expediente;
	}

	public void setExpediente(Expediente expExpediente) {
		this.expediente = expExpediente;
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
	
	public ModeloMarca getTipoMedida() {
		return tipoMedida;
	}

	public void setTipoMedida(ModeloMarca tipoMedida) {
		this.tipoMedida = tipoMedida;
	}

	public ModeloMarca getTipoMedidaMuestra() {
		return tipoMedidaMuestra;
	}

	public ModeloMarca getTipoDroga() {
		return tipoDroga;
	}

	public void setTipoDroga(ModeloMarca tipoDroga) {
		this.tipoDroga = tipoDroga;
	}

	public void setTipoMedidaMuestra(ModeloMarca tipoMedidaMuestra) {
		this.tipoMedidaMuestra = tipoMedidaMuestra;
	}

	public String getDatos(){
		return "" + getTipoDroga().getNombre() + " " + getPesoBruto();
	}
	
	@Override
	public void validar() {
		
		if (this.tipoMedida==null) {
			throw new ValidacionException(Constante.CODIGO_MENSAJE.VALIDAR_COMBOBOX, new Object[] { "Medida" });
		}
		if( this.pesoBruto == null)
		{
			throw new ValidacionException(Constante.CODIGO_MENSAJE.VALIDAR_TEXTBOX, new Object[]{"Peso Bruto"});
		}
		if (this.procedencia==null) {
			throw new ValidacionException(Constante.CODIGO_MENSAJE.VALIDAR_COMBOBOX, new Object[] { "Procedencia" });
		}
		if (this.tipoDroga==null) {
			throw new ValidacionException(Constante.CODIGO_MENSAJE.VALIDAR_COMBOBOX, new Object[] { "Tipo de Droga" });
		}
	}

	public boolean esNuevo(){
		return id == null || id.longValue() == 0;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Droga other = (Droga) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}