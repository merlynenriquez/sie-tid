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
	@SequenceGenerator(name="INT_DET_GREMIO_COCALERO_ID_GENERATOR", sequenceName="SEQ_INT_DET_GREMIO_COCALERO")
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
 
}