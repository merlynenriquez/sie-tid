package pe.gob.mininter.dirandro.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3655460035578885921L;

	@Id
	@SequenceGenerator(name="EXP_EXPEDIENTE_DELITO_ID_GENERATOR", sequenceName="SEQ_")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="EXP_EXPEDIENTE_DELITO_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=16)
	private Long id;

	//bi-directional many-to-one association to DetCrimen
	@OneToMany(mappedBy="expExpedienteDelito")
	private List<DetCrimen> expDetCrimens;

	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="PRIORIDAD", nullable=false)
	private Valor prioridad;

	//bi-directional many-to-one association to Delito
	@ManyToOne
	@JoinColumn(name="DELITO", nullable=false)
	private Delito expDelito;

	//bi-directional many-to-one association to Expediente
	@ManyToOne
	@JoinColumn(name="EXPEDIENTE", nullable=false)
	private Expediente expExpediente;

	public ExpedienteDelito() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<DetCrimen> getExpDetCrimens() {
		return expDetCrimens;
	}

	public void setExpDetCrimens(List<DetCrimen> expDetCrimens) {
		this.expDetCrimens = expDetCrimens;
	}

	public Valor getPrioridad() {
		return prioridad;
	}

	public void setPrioridad(Valor prioridad) {
		this.prioridad = prioridad;
	}

	public Delito getExpDelito() {
		return expDelito;
	}

	public void setExpDelito(Delito expDelito) {
		this.expDelito = expDelito;
	}

	public Expediente getExpExpediente() {
		return expExpediente;
	}

	public void setExpExpediente(Expediente expExpediente) {
		this.expExpediente = expExpediente;
	}

	@Override
	public void validar() {
		// TODO Auto-generated method stub
		
	}

}