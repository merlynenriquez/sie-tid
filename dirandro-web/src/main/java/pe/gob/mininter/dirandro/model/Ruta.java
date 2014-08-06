package pe.gob.mininter.dirandro.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

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
 * The persistent class for the EXP_RUTA database table.
 * 
 */
@Entity
@Table(name="EXP_RUTA")
public class Ruta extends AuditoriaBean implements Validador, Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5835089998137979339L;

	@Id
	@SequenceGenerator(name="EXP_RUTA_ID_GENERATOR", sequenceName="SEQ_")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="EXP_RUTA_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=16)
	private Long id;

	@Column(name="CODIGO_DESTINO", precision=16)
	private BigDecimal codigoDestino;

	@Column(name="CODIGO_ORIGEN", precision=16)
	private BigDecimal codigoOrigen;

	@Column(name="FECHA_ENVIO")
	private Timestamp fechaEnvio;

	@Column(name="FECHA_RECEPCION")
	private Timestamp fechaRecepcion;

	@Column(length=2000)
	private String observacion;

	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="ESTADO_RUTA")
	private Valor estadoRuta;

	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="TABLA_ORIGEN")
	private Valor tablaOrigen;

	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="TABLA_DESTINO")
	private Valor tablaDestino;

	//bi-directional many-to-one association to Expediente
	@ManyToOne
	@JoinColumn(name="EXPEDIENTE", nullable=false)
	private Expediente expExpediente;

	//bi-directional many-to-one association to Integrante
	@ManyToOne
	@JoinColumn(name="INTEGRANTE")
	private Integrante orgIntegrante;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="USUARIO_ORIGEN")
	private Usuario usuarioOrigen;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="USUARIO_RECEPCION")
	private Usuario usuarioRecepcion;

	public Ruta() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getCodigoDestino() {
		return codigoDestino;
	}

	public void setCodigoDestino(BigDecimal codigoDestino) {
		this.codigoDestino = codigoDestino;
	}

	public BigDecimal getCodigoOrigen() {
		return codigoOrigen;
	}

	public void setCodigoOrigen(BigDecimal codigoOrigen) {
		this.codigoOrigen = codigoOrigen;
	}

	public Timestamp getFechaEnvio() {
		return fechaEnvio;
	}

	public void setFechaEnvio(Timestamp fechaEnvio) {
		this.fechaEnvio = fechaEnvio;
	}

	public Timestamp getFechaRecepcion() {
		return fechaRecepcion;
	}

	public void setFechaRecepcion(Timestamp fechaRecepcion) {
		this.fechaRecepcion = fechaRecepcion;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public Valor getEstadoRuta() {
		return estadoRuta;
	}

	public void setEstadoRuta(Valor estadoRuta) {
		this.estadoRuta = estadoRuta;
	}

	public Valor getTablaOrigen() {
		return tablaOrigen;
	}

	public void setTablaOrigen(Valor tablaOrigen) {
		this.tablaOrigen = tablaOrigen;
	}

	public Valor getTablaDestino() {
		return tablaDestino;
	}

	public void setTablaDestino(Valor tablaDestino) {
		this.tablaDestino = tablaDestino;
	}

	public Expediente getExpExpediente() {
		return expExpediente;
	}

	public void setExpExpediente(Expediente expExpediente) {
		this.expExpediente = expExpediente;
	}

	public Integrante getOrgIntegrante() {
		return orgIntegrante;
	}

	public void setOrgIntegrante(Integrante orgIntegrante) {
		this.orgIntegrante = orgIntegrante;
	}

	public Usuario getUsuarioOrigen() {
		return usuarioOrigen;
	}

	public void setUsuarioOrigen(Usuario usuarioOrigen) {
		this.usuarioOrigen = usuarioOrigen;
	}

	public Usuario getUsuarioRecepcion() {
		return usuarioRecepcion;
	}

	public void setUsuarioRecepcion(Usuario usuarioRecepcion) {
		this.usuarioRecepcion = usuarioRecepcion;
	}

	@Override
	public void validar() {
		// TODO Auto-generated method stub
		
	}

}