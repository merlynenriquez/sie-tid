package pe.gob.mininter.dirandro.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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
	@SequenceGenerator(name="EXP_RUTA_ID_GENERATOR", sequenceName="SEQ_RUTA", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="EXP_RUTA_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=16)
	private Long id;

	@Column(name="CODIGO_DESTINO", precision=16)
	private Long codigoDestino;

	@Column(name="CODIGO_ORIGEN", precision=16)
	private Long codigoOrigen;

	@Column(name="FECHA_ENVIO")
	@Temporal( TemporalType.TIMESTAMP)
	private Date fechaEnvio;

	@Column(name="FECHA_RECEPCION")
	@Temporal( TemporalType.TIMESTAMP)
	private Date fechaRecepcion;

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
	private Expediente expediente;

	//bi-directional many-to-one association to Integrante
	@ManyToOne
	@JoinColumn(name="INTEGRANTE")
	private Integrante integrante;

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

	public Long getCodigoDestino() {
		return codigoDestino;
	}

	public void setCodigoDestino(Long codigoDestino) {
		this.codigoDestino = codigoDestino;
	}

	public Long getCodigoOrigen() {
		return codigoOrigen;
	}

	public void setCodigoOrigen(Long codigoOrigen) {
		this.codigoOrigen = codigoOrigen;
	}

	public Date getFechaEnvio() {
		return fechaEnvio;
	}

	public void setFechaEnvio(Date fechaEnvio) {
		this.fechaEnvio = fechaEnvio;
	}

	public Date getFechaRecepcion() {
		return fechaRecepcion;
	}

	public void setFechaRecepcion(Date fechaRecepcion) {
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

	public Expediente getExpediente() {
		return expediente;
	}

	public void setExpediente(Expediente expExpediente) {
		this.expediente = expExpediente;
	}

	public Integrante getIntegrante() {
		return integrante;
	}

	public void setIntegrante(Integrante orgIntegrante) {
		this.integrante = orgIntegrante;
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
		
		
	}

}