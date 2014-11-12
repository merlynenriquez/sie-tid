package pe.gob.mininter.dirandro.model;

import java.io.Serializable;

import javax.persistence.*;

import pe.gob.mininter.dirandro.util.beanbase.AuditoriaBean;

import java.sql.Timestamp;
import java.math.BigDecimal;


/**
 * The persistent class for the EXP_AGENDA_ACTORES database table.
 * 
 */
@Entity
@Table(name="EXP_AGENDA_ACTORES")
public class AgendaActor extends AuditoriaBean implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="EXP_AGENDA_ACTORES_ID_GENERATOR", sequenceName="SEQ_EXP_AGENDA_ACTORES")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="EXP_AGENDA_ACTORES_ID_GENERATOR")
	private Long id;

	private BigDecimal actor;

	private BigDecimal estado;

	private Timestamp fecha;

	private Timestamp hora;

	private String lugar;

	private BigDecimal motivo;

	//bi-directional many-to-one association to Agenda
	@ManyToOne
	@JoinColumn(name="AGENDA")
	private Agenda infAgenda;

	public AgendaActor() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getActor() {
		return actor;
	}

	public void setActor(BigDecimal actor) {
		this.actor = actor;
	}

	public BigDecimal getEstado() {
		return estado;
	}

	public void setEstado(BigDecimal estado) {
		this.estado = estado;
	}

	public Timestamp getFecha() {
		return fecha;
	}

	public void setFecha(Timestamp fecha) {
		this.fecha = fecha;
	}

	public Timestamp getHora() {
		return hora;
	}

	public void setHora(Timestamp hora) {
		this.hora = hora;
	}

	public String getLugar() {
		return lugar;
	}

	public void setLugar(String lugar) {
		this.lugar = lugar;
	}

	public BigDecimal getMotivo() {
		return motivo;
	}

	public void setMotivo(BigDecimal motivo) {
		this.motivo = motivo;
	}

	public Agenda getInfAgenda() {
		return infAgenda;
	}

	public void setInfAgenda(Agenda infAgenda) {
		this.infAgenda = infAgenda;
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
		AgendaActor other = (AgendaActor) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}