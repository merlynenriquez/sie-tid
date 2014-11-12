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
 * The persistent class for the INF_AGENDA database table.
 * 
 */
@Entity
@Table(name="INF_AGENDA")
public class Agenda  extends AuditoriaBean implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="INF_AGENDA_ID_GENERATOR", sequenceName="SEQ_INF_AGENDA")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="INF_AGENDA_ID_GENERATOR")
	private Long id;

	@Column(name="FECHA_EMISION")
	private Timestamp fechaEmision;

	private BigDecimal notificacion;

	@Column(name="TIPO_AGENDA")
	private BigDecimal tipoAgenda;

	@Column(name="UNIDAD_PPTID")
	private BigDecimal unidadPptid;

	//bi-directional many-to-one association to Informe
	@ManyToOne
	@JoinColumn(name="INFORME")
	private Informe infInforme;

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

	public BigDecimal getNotificacion() {
		return notificacion;
	}

	public void setNotificacion(BigDecimal notificacion) {
		this.notificacion = notificacion;
	}

	public BigDecimal getTipoAgenda() {
		return tipoAgenda;
	}

	public void setTipoAgenda(BigDecimal tipoAgenda) {
		this.tipoAgenda = tipoAgenda;
	}

	public BigDecimal getUnidadPptid() {
		return unidadPptid;
	}

	public void setUnidadPptid(BigDecimal unidadPptid) {
		this.unidadPptid = unidadPptid;
	}

	public Informe getInfInforme() {
		return infInforme;
	}

	public void setInfInforme(Informe infInforme) {
		this.infInforme = infInforme;
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