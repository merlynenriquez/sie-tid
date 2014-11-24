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
 * The persistent class for the INT_DET_GREMIO_COCALERO database table.
 * 
 */
@Entity
@Table(name="INT_DET_GREMIO_COCALERO")
public class DetGremioCocalero extends AuditoriaBean implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="INT_DET_GREMIO_COCALERO_ID_GENERATOR", sequenceName="SEQ_INT_DET_GREMIO_COCALERO", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="INT_DET_GREMIO_COCALERO_ID_GENERATOR")
	private Long id;

	//bi-directional many-to-one association to GremioCocalero
	@ManyToOne
	@JoinColumn(name="GREMIO")
	private GremioCocalero gremioCocalero;

	//bi-directional many-to-one association to Inteligencia
	@ManyToOne
	@JoinColumn(name="INTELIGENCIA")
	private Inteligencia inteligencia;

	public DetGremioCocalero() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public GremioCocalero getGremioCocalero() {
		return gremioCocalero;
	}

	public void setGremioCocalero(GremioCocalero gremioCocalero) {
		this.gremioCocalero = gremioCocalero;
	}

	public Inteligencia getInteligencia() {
		return inteligencia;
	}

	public void setInteligencia(Inteligencia inteligencia) {
		this.inteligencia = inteligencia;
	}
	
	public boolean esNuevo()
	{
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
		DetGremioCocalero other = (DetGremioCocalero) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

 
}