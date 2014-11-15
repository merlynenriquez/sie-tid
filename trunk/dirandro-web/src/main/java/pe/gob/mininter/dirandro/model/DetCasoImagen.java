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
 * The persistent class for the AGE_DET_CASO_IMAGEN database table.
 * 
 */
@Entity
@Table(name="AGE_DET_CASO_IMAGEN")
public class DetCasoImagen extends AuditoriaBean implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="AGE_DET_CASO_IMAGEN_ID_GENERATOR", sequenceName="SEQ_CASO_IMAGEN")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="AGE_DET_CASO_IMAGEN_ID_GENERATOR")
	private Long id;

	private String observacion;

	//bi-directional many-to-one association to Caso
	@ManyToOne
	@JoinColumn(name="CASO")
	private Caso caso;

	//bi-directional many-to-one association to Adjunto
	@ManyToOne
	@JoinColumn(name="IMAGEN")
	private Adjunto imagen;

	public DetCasoImagen() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public Caso getCaso() {
		return caso;
	}

	public void setCaso(Caso caso) {
		this.caso = caso;
	}

	public Adjunto getImagen() {
		return imagen;
	}

	public void setImagen(Adjunto imagen) {
		this.imagen = imagen;
	}

}