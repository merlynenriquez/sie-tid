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
 * The persistent class for the INF_NOTIFICACION database table.
 * 
 */
@Entity
@Table(name="INF_NOTIFICACION")
public class Notificacion extends AuditoriaBean implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="INF_NOTIFICACION_ID_GENERATOR", sequenceName="SEQ_INF_NOTIFICACION")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="INF_NOTIFICACION_ID_GENERATOR")
	private Long id;

	private BigDecimal estado;

	@Column(name="FECHA_PLAZO")
	private Timestamp fechaPlazo;

	@Column(name="FECHA_RECEPCION")
	private Timestamp fechaRecepcion;

	@Column(name="FECHA_VENCIMIENTO")
	private Timestamp fechaVencimiento;

	@Column(name="TIPO_NOTIFICACION")
	private BigDecimal tipoNotificacion;

	@Column(name="UNIDAD_PPTID")
	private BigDecimal unidadPptid;

	//bi-directional many-to-one association to Informe
	@ManyToOne
	@JoinColumn(name="INFORME")
	private Informe informe;

	public Notificacion() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getEstado() {
		return estado;
	}

	public void setEstado(BigDecimal estado) {
		this.estado = estado;
	}

	public Timestamp getFechaPlazo() {
		return fechaPlazo;
	}

	public void setFechaPlazo(Timestamp fechaPlazo) {
		this.fechaPlazo = fechaPlazo;
	}

	public Timestamp getFechaRecepcion() {
		return fechaRecepcion;
	}

	public void setFechaRecepcion(Timestamp fechaRecepcion) {
		this.fechaRecepcion = fechaRecepcion;
	}

	public Timestamp getFechaVencimiento() {
		return fechaVencimiento;
	}

	public void setFechaVencimiento(Timestamp fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}

	public BigDecimal getTipoNotificacion() {
		return tipoNotificacion;
	}

	public void setTipoNotificacion(BigDecimal tipoNotificacion) {
		this.tipoNotificacion = tipoNotificacion;
	}

	public BigDecimal getUnidadPptid() {
		return unidadPptid;
	}

	public void setUnidadPptid(BigDecimal unidadPptid) {
		this.unidadPptid = unidadPptid;
	}

	public Informe getInforme() {
		return informe;
	}

	public void setInforme(Informe informe) {
		this.informe = informe;
	}
	

}