package pe.gob.mininter.dirandro.model;

import java.io.Serializable;

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
 * The persistent class for the AGE_DET_CASO_AGENTE database table.
 * 
 */
@Entity
@Table(name="AGE_DET_CASO_AGENTE")
public class DetCasoAgente  extends AuditoriaBean implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="AGE_DET_CASO_AGENTE_ID_GENERATOR", sequenceName="SEQ_CASO_AGENTE", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="AGE_DET_CASO_AGENTE_ID_GENERATOR")
	private Long id;

	//bi-directional many-to-one association to Caso
	@ManyToOne
	@JoinColumn(name="CASO")
	private Caso caso;

	//bi-directional many-to-one association to Policia
	@ManyToOne
	@JoinColumn(name="AGENTE")
	private Policia agente;

	public DetCasoAgente() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Caso getCaso() {
		return caso;
	}

	public void setCaso(Caso caso) {
		this.caso = caso;
	}

	public Policia getAgente() {
		return agente;
	}

	public void setAgente(Policia agente) {
		this.agente = agente;
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
		DetCasoAgente other = (DetCasoAgente) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}