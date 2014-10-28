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

import pe.gob.mininter.dirandro.exception.ValidacionException;
import pe.gob.mininter.dirandro.util.Constante;
import pe.gob.mininter.dirandro.util.Validador;
import pe.gob.mininter.dirandro.util.beanbase.AuditoriaBean;


/**
 * The persistent class for the EXP_DET_CRIMEN database table.
 * 
 */
@Entity
@Table(name="EXP_DET_CRIMEN")
public class DetCrimen extends AuditoriaBean implements Validador, Serializable {

	private static final long serialVersionUID = -6704151480718740744L;

	@Id
	@SequenceGenerator(name="EXP_DET_CRIMEN_ID_GENERATOR", sequenceName="SEQ_CRIMEN", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="EXP_DET_CRIMEN_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=16)
	private Long id;

	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="PRIORIDAD")
	private Valor prioridad;

	//bi-directional many-to-one association to DetExpedientePersona
	@ManyToOne
	@JoinColumn(name="EXP_PER")
	private DetExpedientePersona expedientePersona;

	//bi-directional many-to-one association to ExpedienteDelito
	@ManyToOne
	@JoinColumn(name="EXP_DEL")
	private ExpedienteDelito expedienteDelito;

	public DetCrimen() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Valor getPrioridad() {
		return prioridad;
	}

	public void setPrioridad(Valor prioridad) {
		this.prioridad = prioridad;
	}

	public DetExpedientePersona getExpedientePersona() {
		return expedientePersona;
	}

	public void setExpedientePersona(DetExpedientePersona expedientePersona) {
		this.expedientePersona = expedientePersona;
	}

	public ExpedienteDelito getExpedienteDelito() {
		return expedienteDelito;
	}

	public void setExpedienteDelito(ExpedienteDelito expedienteDelito) {
		this.expedienteDelito = expedienteDelito;
	}

	@Override
	public void validar() {
		if(expedienteDelito==null){
			throw new ValidacionException(Constante.CODIGO_MENSAJE.VALIDAR_COMBOBOX, new Object[]{"Delito"});
		}
		if(expedientePersona==null){
			throw new ValidacionException(Constante.CODIGO_MENSAJE.VALIDAR_COMBOBOX, new Object[]{"Intervenido"});
		}
		if(prioridad==null){
			throw new ValidacionException(Constante.CODIGO_MENSAJE.VALIDAR_COMBOBOX, new Object[]{"Prioridad"});
		}
	}

}