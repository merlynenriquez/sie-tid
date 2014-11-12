package pe.gob.mininter.dirandro.model;

import java.io.Serializable;

import javax.persistence.*;

import pe.gob.mininter.dirandro.util.beanbase.AuditoriaBean;

import java.sql.Timestamp;
import java.math.BigDecimal;


/**
 * The persistent class for the INF_SEGUIMIENTO_NOT database table.
 * 
 */
@Entity
@Table(name="INF_SEGUIMIENTO_NOT")
public class SeguimientoNot extends AuditoriaBean implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="INF_SEGUIMIENTO_NOT_ID_GENERATOR", sequenceName="SEQ_INF_SEGUIMIENTO_NOT")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="INF_SEGUIMIENTO_NOT_ID_GENERATOR")
	private long id;

	private String detalle;

	@Column(name="ESTADO_SEGUIMIENTO")
	private BigDecimal estadoSeguimiento;

	@Column(name="FECHA_RECEPCION")
	private Timestamp fechaRecepcion;

	//bi-directional many-to-one association to Notificacion
	@ManyToOne
	@JoinColumn(name="NOTIFICACION")
	private Notificacion notificacion;

	public SeguimientoNot() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDetalle() {
		return detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}

	public BigDecimal getEstadoSeguimiento() {
		return estadoSeguimiento;
	}

	public void setEstadoSeguimiento(BigDecimal estadoSeguimiento) {
		this.estadoSeguimiento = estadoSeguimiento;
	}

	public Timestamp getFechaRecepcion() {
		return fechaRecepcion;
	}

	public void setFechaRecepcion(Timestamp fechaRecepcion) {
		this.fechaRecepcion = fechaRecepcion;
	}

	public Notificacion getNotificacion() {
		return notificacion;
	}

	public void setNotificacion(Notificacion notificacion) {
		this.notificacion = notificacion;
	}


}