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
 * The persistent class for the EXP_EXPEDIENTE_DELITO database table.
 * 
 */
@Entity
@Table(name="EXP_EXPEDIENTE_DELITO")
public class ExpedienteDelito extends AuditoriaBean implements Validador, Serializable {
	
	private static final long serialVersionUID = 3655460035578885921L;

	@Id
	@SequenceGenerator(name="EXP_EXPEDIENTE_DELITO_ID_GENERATOR", sequenceName="SEQ_EXP_DELITO", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="EXP_EXPEDIENTE_DELITO_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=16)
	private Long id;

	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="PRIORIDAD", nullable=false)
	private Valor prioridad;

	//bi-directional many-to-one association to Delito
	@ManyToOne
	@JoinColumn(name="DELITO", nullable=false)
	private Delito delito;

	//bi-directional many-to-one association to Expediente
	@ManyToOne
	@JoinColumn(name="EXPEDIENTE", nullable=false)
	private Expediente expediente;

	public ExpedienteDelito() {
	}

	public Long getId() {
		return id;
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

	public Delito getDelito() {
		return delito;
	}

	public void setDelito(Delito delito) {
		this.delito = delito;
	}

	public Expediente getExpediente() {
		return expediente;
	}

	public void setExpediente(Expediente expediente) {
		this.expediente = expediente;
	}

	@Override
	public void validar() {
		// TODO Auto-generated method stub
		
	}

}