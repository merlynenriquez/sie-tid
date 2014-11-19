package pe.gob.mininter.dirandro.model;

import java.io.Serializable;

import javax.persistence.*;

import pe.gob.mininter.dirandro.util.beanbase.AuditoriaBean;


/**
 * The persistent class for the PER_DET_SENTENCIA_DELITO database table.
 * 
 */
@Entity
@Table(name="PER_DET_SENTENCIA_DELITO")
public class DetSentenciaDelito extends AuditoriaBean implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="PER_DET_SENTENCIA_DELITO_ID_GENERATOR", sequenceName="SEQ_PER_DET_SENTENCIA_DELITO", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PER_DET_SENTENCIA_DELITO_ID_GENERATOR")
	private Long id;

	private String observacion;

	//bi-directional many-to-one association to DetCrimen
	@ManyToOne
	@JoinColumn(name="DELITO_IMPUTADO")
	private DetCrimen detCrimen;

	//bi-directional many-to-one association to SituacionProceso
	@ManyToOne
	@JoinColumn(name="PROCESO")
	private SituacionProceso situacionProceso;

	public DetSentenciaDelito() {
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

	public DetCrimen getDetCrimen() {
		return detCrimen;
	}

	public void setDetCrimen(DetCrimen detCrimen) {
		this.detCrimen = detCrimen;
	}

	public SituacionProceso getSituacionProceso() {
		return situacionProceso;
	}

	public void setSituacionProceso(SituacionProceso situacionProceso) {
		this.situacionProceso = situacionProceso;
	}

}