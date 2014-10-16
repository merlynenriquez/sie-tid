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
 * The persistent class for the HR_PERICIA database table.
 * 
 */
@Entity
@Table(name="HR_PERICIA")
public class Pericia extends AuditoriaBean implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="HR_PERICIA_ID_GENERATOR", sequenceName="SEQ_PERICIA")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="HR_PERICIA_ID_GENERATOR")
	private Long id;

	@Column(name="DESCRIPCION_LOGO")
	private String descripcionLogo;

	@Column(name="FECHA_PERITAJE")
	private Timestamp fechaPeritaje;

	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="ESTADO_PERICIA")
	private Valor estado;

	//bi-directional many-to-one association to Adjunto
	@ManyToOne
	@JoinColumn(name="LOGO")
	private Adjunto logo;

	//bi-directional many-to-one association to Adjunto
	@ManyToOne
	@JoinColumn(name="ADJUNTO")
	private Adjunto adjunto;

	//bi-directional many-to-one association to HrHojaremisionMuestra
	@ManyToOne
	@JoinColumn(name="MUESTRA")
	private HojaremisionMuestra muestra;

	public Pericia() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDescripcionLogo() {
		return descripcionLogo;
	}

	public void setDescripcionLogo(String descripcionLogo) {
		this.descripcionLogo = descripcionLogo;
	}

	public Timestamp getFechaPeritaje() {
		return fechaPeritaje;
	}

	public void setFechaPeritaje(Timestamp fechaPeritaje) {
		this.fechaPeritaje = fechaPeritaje;
	}

	public Valor getEstado() {
		return estado;
	}

	public void setEstado(Valor estado) {
		this.estado = estado;
	}

	public Adjunto getLogo() {
		return logo;
	}

	public void setLogo(Adjunto logo) {
		this.logo = logo;
	}

	public Adjunto getAdjunto() {
		return adjunto;
	}

	public void setAdjunto(Adjunto adjunto) {
		this.adjunto = adjunto;
	}

	public HojaremisionMuestra getMuestra() {
		return muestra;
	}

	public void setMuestra(HojaremisionMuestra muestra) {
		this.muestra = muestra;
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
		Pericia other = (Pericia) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}