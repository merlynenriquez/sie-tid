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
 * The persistent class for the INF_AGENDA database table.
 * 
 */
@Entity
@Table(name="INF_AGENDA")
public class Agenda extends AuditoriaBean implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="INF_AGENDA_ID_GENERATOR", sequenceName="SEQ_INF_AGENDA", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="INF_AGENDA_ID_GENERATOR")
	private Long id;

	@Column(name="FECHA_EMISION")
	private Timestamp fechaEmision;

	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="TIPO_AGENDA")
	private Valor tipoAgenda;

	//bi-directional many-to-one association to Dependencia
	@ManyToOne
	@JoinColumn(name="UNIDAD_PPTID")
	private Dependencia dependencia;

	//bi-directional many-to-one association to Notificacion
	@ManyToOne
	@JoinColumn(name="NOTIFICACION")
	private Notificacion notificacion;

	public Agenda() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Timestamp getFechaEmision() {
		return fechaEmision;
	}

	public void setFechaEmision(Timestamp fechaEmision) {
		this.fechaEmision = fechaEmision;
	}

	public Valor getTipoAgenda() {
		return tipoAgenda;
	}

	public void setTipoAgenda(Valor tipoAgenda) {
		this.tipoAgenda = tipoAgenda;
	}

	public Dependencia getDependencia() {
		return dependencia;
	}

	public void setDependencia(Dependencia dependencia) {
		this.dependencia = dependencia;
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
		Agenda other = (Agenda) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}