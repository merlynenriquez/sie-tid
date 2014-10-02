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
 * The persistent class for the EXP_IMPORTES database table.
 * 
 */
@Entity
@Table(name="EXP_IMPORTES")
public class Importe extends AuditoriaBean implements Validador, Serializable {
	
	private static final long serialVersionUID = 5594740774950181739L;

	@Id
	@SequenceGenerator(name="EXP_IMPORTES_ID_GENERATOR", sequenceName="SEQ_IMPORTE", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="EXP_IMPORTES_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=16)
	private Long id;

	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="TIPO_PRESENTECION")
	private Valor tipoPresentacion;
		
	@Column(nullable=false, length=2)
	private String autenticidad;
	
	@Column(precision=10, scale=2)
	private Double moneda;

	@Column(name="NRO_CUENTA", length=40)
	private String nroCuenta;

	@Column(name="NRO_TARJETA", length=48)
	private String nroTarjeta;
	
	@Column(name="TIPO_CAMBIO", precision=10, scale=2)
	private Double tipoCambio;

	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="TIPO_CUENTA")
	private Valor tipoCuenta;

	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="SITUACION")
	private Valor situacion;

	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="BANCO")
	private Valor banco;

	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="TIPO_MONEDA")
	private Valor tipoMoneda;

	//bi-directional many-to-one association to Expediente
	@ManyToOne
	@JoinColumn(name="EXPEDIENTE", nullable=false)
	private Expediente expediente;

	public Importe() {
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNroCuenta() {
		return nroCuenta;
	}

	public void setNroCuenta(String nroCuenta) {
		this.nroCuenta = nroCuenta;
	}

	public String getNroTarjeta() {
		return nroTarjeta;
	}

	public void setNroTarjeta(String nroTarjeta) {
		this.nroTarjeta = nroTarjeta;
	}

	public Valor getTipoCuenta() {
		return tipoCuenta;
	}

	public void setTipoCuenta(Valor tipoCuenta) {
		this.tipoCuenta = tipoCuenta;
	}

	public Valor getSituacion() {
		return situacion;
	}

	public void setSituacion(Valor situacion) {
		this.situacion = situacion;
	}

	public Valor getBanco() {
		return banco;
	}

	public void setBanco(Valor banco) {
		this.banco = banco;
	}

	public Valor getTipoMoneda() {
		return tipoMoneda;
	}

	public void setTipoMoneda(Valor tipoMoneda) {
		this.tipoMoneda = tipoMoneda;
	}
	
	public Double getTipoCambio() {
		return tipoCambio;
	}

	public void setTipoCambio(Double tipoCambio) {
		this.tipoCambio = tipoCambio;
	}

	public Expediente getExpediente() {
		return expediente;
	}

	public void setExpediente(Expediente expediente) {
		this.expediente = expediente;
	}

	public Valor getTipoPresentacion() {
		return tipoPresentacion;
	}

	public void setTipoPresentacion(Valor tipoPresentacion) {
		this.tipoPresentacion = tipoPresentacion;
	}

	public Double getMoneda() {
		return moneda;
	}

	public void setMoneda(Double moneda) {
		this.moneda = moneda;
	}

	public String getAutenticidad() {
		return autenticidad;
	}

	public void setAutenticidad(String autenticidad) {
		this.autenticidad = autenticidad;
	}

	@Override
	public void validar() {
		if(expediente == null){
			throw new ValidacionException(Constante.CODIGO_MENSAJE.VALIDAR_COMBOBOX, new Object[]{"Expediente"});
		}
		if(this.tipoMoneda == null){
			throw new ValidacionException(Constante.CODIGO_MENSAJE.VALIDAR_COMBOBOX, new Object[]{"Tipo de Moneda"});
		}
		if( this.moneda == null ){
			throw new ValidacionException(Constante.CODIGO_MENSAJE.VALIDAR_TEXTBOX, new Object[]{"Monto"});
		}
		if(this.situacion== null){
			throw new ValidacionException(Constante.CODIGO_MENSAJE.VALIDAR_COMBOBOX, new Object[]{"Situación"});
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
		Importe other = (Importe) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}