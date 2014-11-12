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

import pe.gob.mininter.dirandro.util.beanbase.AuditoriaBean;


/**
 * The persistent class for the INF_INFORME database table.
 * 
 */
@Entity
@Table(name="INF_INFORME")
public class Informe extends AuditoriaBean implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="INF_INFORME_ID_GENERATOR", sequenceName="SEQ_INF_INFORME")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="INF_INFORME_ID_GENERATOR")
	private Long id;

	@Column(name="FECHA_NOTIFICACION_EMISOR")
	private Timestamp fechaNotificacionEmisor;

	@Column(name="FECHA_RECEPCION_NOTIFICACION")
	private Timestamp fechaRecepcionNotificacion;

	@Column(name="FECHA_RESOLUCION")
	private Timestamp fechaResolucion;

	@Column(name="NOMBRE_CASO")
	private Timestamp nombreCaso;

	@Column(name="NRO_RESOLUCION")
	private String nroResolucion;

	private String numero;

	@Column(name="TIPO_FUENTE")
	private BigDecimal tipoFuente;

	@Column(name="TIPO_INFORME")
	private BigDecimal tipoInforme;

	@Column(name="TIPO_MEDIO_RECEPCION")
	private BigDecimal tipoMedioRecepcion;

	@Column(name="TIPO_RESOLUCION")
	private BigDecimal tipoResolucion;

	@Column(name="UNIDAD_PROCURADURIA")
	private BigDecimal unidadProcuraduria;

	//bi-directional many-to-one association to Expediente
	@ManyToOne
	@JoinColumn(name="PARTE")
	private Expediente expediente;

	//bi-directional many-to-one association to Informe
	@ManyToOne
	@JoinColumn(name="PADRE")
	private Informe padre;

	public Informe() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Timestamp getFechaNotificacionEmisor() {
		return fechaNotificacionEmisor;
	}

	public void setFechaNotificacionEmisor(Timestamp fechaNotificacionEmisor) {
		this.fechaNotificacionEmisor = fechaNotificacionEmisor;
	}

	public Timestamp getFechaRecepcionNotificacion() {
		return fechaRecepcionNotificacion;
	}

	public void setFechaRecepcionNotificacion(Timestamp fechaRecepcionNotificacion) {
		this.fechaRecepcionNotificacion = fechaRecepcionNotificacion;
	}

	public Timestamp getFechaResolucion() {
		return fechaResolucion;
	}

	public void setFechaResolucion(Timestamp fechaResolucion) {
		this.fechaResolucion = fechaResolucion;
	}

	public Timestamp getNombreCaso() {
		return nombreCaso;
	}

	public void setNombreCaso(Timestamp nombreCaso) {
		this.nombreCaso = nombreCaso;
	}

	public String getNroResolucion() {
		return nroResolucion;
	}

	public void setNroResolucion(String nroResolucion) {
		this.nroResolucion = nroResolucion;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public BigDecimal getTipoFuente() {
		return tipoFuente;
	}

	public void setTipoFuente(BigDecimal tipoFuente) {
		this.tipoFuente = tipoFuente;
	}

	public BigDecimal getTipoInforme() {
		return tipoInforme;
	}

	public void setTipoInforme(BigDecimal tipoInforme) {
		this.tipoInforme = tipoInforme;
	}

	public BigDecimal getTipoMedioRecepcion() {
		return tipoMedioRecepcion;
	}

	public void setTipoMedioRecepcion(BigDecimal tipoMedioRecepcion) {
		this.tipoMedioRecepcion = tipoMedioRecepcion;
	}

	public BigDecimal getTipoResolucion() {
		return tipoResolucion;
	}

	public void setTipoResolucion(BigDecimal tipoResolucion) {
		this.tipoResolucion = tipoResolucion;
	}

	public BigDecimal getUnidadProcuraduria() {
		return unidadProcuraduria;
	}

	public void setUnidadProcuraduria(BigDecimal unidadProcuraduria) {
		this.unidadProcuraduria = unidadProcuraduria;
	}

	public Expediente getExpediente() {
		return expediente;
	}

	public void setExpediente(Expediente expediente) {
		this.expediente = expediente;
	}

	public Informe getPadre() {
		return padre;
	}

	public void setPadre(Informe padre) {
		this.padre = padre;
	}

}