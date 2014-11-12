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
 * The persistent class for the INT_DET_AERODROMO database table.
 * 
 */
@Entity
@Table(name="INT_DET_AERODROMO")
public class DetAerodromo  extends AuditoriaBean implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="INT_DET_AERODROMO_ID_GENERATOR", sequenceName="SEQ_INT_DET_AERODROMO")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="INT_DET_AERODROMO_ID_GENERATOR")
	private Long id;

	//bi-directional many-to-one association to Aerodromo
	@ManyToOne
	@JoinColumn(name="AERODROMO")
	private Aerodromo intAerodromo;

	//bi-directional many-to-one association to Inteligencia
	@ManyToOne
	@JoinColumn(name="INTEGENCIA")
	private Inteligencia intInteligencia;

	public DetAerodromo() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Aerodromo getIntAerodromo() {
		return intAerodromo;
	}

	public void setIntAerodromo(Aerodromo intAerodromo) {
		this.intAerodromo = intAerodromo;
	}

	public Inteligencia getIntInteligencia() {
		return intInteligencia;
	}

	public void setIntInteligencia(Inteligencia intInteligencia) {
		this.intInteligencia = intInteligencia;
	}
	
	
}