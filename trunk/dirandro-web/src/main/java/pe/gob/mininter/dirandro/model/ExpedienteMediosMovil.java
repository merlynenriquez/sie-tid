package pe.gob.mininter.dirandro.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import pe.gob.mininter.dirandro.util.Validador;
import pe.gob.mininter.dirandro.util.beanbase.AuditoriaBean;


/**
 * The persistent class for the EXP_EXPEDIENTE_MEDIOS_MOVIL database table.
 * 
 */
@Entity
@Table(name="EXP_EXPEDIENTE_MEDIOS_MOVIL")
public class ExpedienteMediosMovil extends AuditoriaBean implements Validador, Serializable {
	 
	/**
	 * 
	 */
	private static final long serialVersionUID = -591991440697393339L;


	@Id
	@SequenceGenerator(name="EXP_EXPEDIENTE_MEDIOS_MOVIL_ID_GENERATOR", sequenceName="SEQ_", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="EXP_EXPEDIENTE_MEDIOS_MOVIL_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=16)
	private Long id;

	
	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="MEDIO_MOVIL")
	private Valor medioMovil;

	//bi-directional many-to-one association to DetCrimen
	@ManyToOne
	@JoinColumn(name="CRIMEN")
	private DetCrimen expDetCrimen;

	public ExpedienteMediosMovil() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Valor getMedioMovil() {
		return medioMovil;
	}

	public void setMedioMovil(Valor medioMovil) {
		this.medioMovil = medioMovil;
	}

	public DetCrimen getExpDetCrimen() {
		return expDetCrimen;
	}

	public void setExpDetCrimen(DetCrimen expDetCrimen) {
		this.expDetCrimen = expDetCrimen;
	}

	@Override
	public void validar() {
		// TODO Auto-generated method stub
		
	}

}