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
 * The persistent class for the EXP_IMPORTES database table.
 * 
 */
@Entity
@Table(name="EXP_IMPORTES")
public class Importe extends AuditoriaBean implements Validador, Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5594740774950181739L;

	@Id
	@SequenceGenerator(name="EXP_IMPORTES_ID_GENERATOR", sequenceName="SEQ_", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="EXP_IMPORTES_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=16)
	private Long id;

	@Column(precision=10, scale=2)
	private BigDecimal moneda;

	@Column(name="NRO_CUENTA", length=40)
	private String nroCuenta;

	@Column(name="NRO_TARJETA", length=48)
	private String nroTarjeta;

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
	@JoinColumn(name="ESTADO_MONEDA")
	private Valor estadoMoneda;

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
	@JoinColumn(name="EXPEDIENTE")
	private Expediente expExpediente;

	public Importe() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getMoneda() {
		return moneda;
	}

	public void setMoneda(BigDecimal moneda) {
		this.moneda = moneda;
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

	public Valor getEstadoMoneda() {
		return estadoMoneda;
	}

	public void setEstadoMoneda(Valor estadoMoneda) {
		this.estadoMoneda = estadoMoneda;
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

	public Expediente getExpExpediente() {
		return expExpediente;
	}

	public void setExpExpediente(Expediente expExpediente) {
		this.expExpediente = expExpediente;
	}

	@Override
	public void validar() {
		// TODO Auto-generated method stub
		
	}


}