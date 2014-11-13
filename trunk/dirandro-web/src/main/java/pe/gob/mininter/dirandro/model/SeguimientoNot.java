package pe.gob.mininter.dirandro.model;

import java.io.Serializable;

import javax.persistence.*;

import pe.gob.mininter.dirandro.util.beanbase.AuditoriaBean;

import java.sql.Timestamp;


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
	private Long id;

	private String detalle;

	@Column(name="FECHA_RECEPCION")
	private Timestamp fechaRecepcion;

	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="ESTADO_SEGUIMIENTO")
	private Valor estadoSeguimiento;

	//bi-directional many-to-one association to Notificacion
	@ManyToOne
	@JoinColumn(name="NOTIFICACION")
	private Notificacion notificacion;

	public SeguimientoNot() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDetalle() {
		return detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}

	public Timestamp getFechaRecepcion() {
		return fechaRecepcion;
	}

	public void setFechaRecepcion(Timestamp fechaRecepcion) {
		this.fechaRecepcion = fechaRecepcion;
	}

	public Valor getEstadoSeguimiento() {
		return estadoSeguimiento;
	}

	public void setEstadoSeguimiento(Valor estadoSeguimiento) {
		this.estadoSeguimiento = estadoSeguimiento;
	}

	public Notificacion getNotificacion() {
		return notificacion;
	}

	public void setNotificacion(Notificacion notificacion) {
		this.notificacion = notificacion;
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
		SeguimientoNot other = (SeguimientoNot) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}