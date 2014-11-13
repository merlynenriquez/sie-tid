package pe.gob.mininter.dirandro.model;

import java.io.Serializable;
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

	@Column(name="NRO_RESOLUCION")
	private String nroResolucion;

	private String numero;

	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="TIPO_MEDIO_RECEPCION")
	private Valor tipoMedioRecepcion;

	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="TIPO_FUENTE")
	private Valor tipoFuente;

	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="TIPO_INFORME")
	private Valor tipoInforme;

	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="TIPO_RESOLUCION")
	private Valor tipoResolucion;

	//bi-directional many-to-one association to Dependencia
	@ManyToOne
	@JoinColumn(name="UNIDAD_PROCURADURIA")
	private Dependencia unidad;

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

	public Valor getTipoMedioRecepcion() {
		return tipoMedioRecepcion;
	}

	public void setTipoMedioRecepcion(Valor tipoMedioRecepcion) {
		this.tipoMedioRecepcion = tipoMedioRecepcion;
	}

	public Valor getTipoFuente() {
		return tipoFuente;
	}

	public void setTipoFuente(Valor tipoFuente) {
		this.tipoFuente = tipoFuente;
	}

	public Valor getTipoInforme() {
		return tipoInforme;
	}

	public void setTipoInforme(Valor tipoInforme) {
		this.tipoInforme = tipoInforme;
	}

	public Valor getTipoResolucion() {
		return tipoResolucion;
	}

	public void setTipoResolucion(Valor tipoResolucion) {
		this.tipoResolucion = tipoResolucion;
	}

	public Dependencia getUnidad() {
		return unidad;
	}

	public void setUnidad(Dependencia unidad) {
		this.unidad = unidad;
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
		Informe other = (Informe) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}