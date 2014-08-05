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
 * The persistent class for the EXP_DET_CRIMEN database table.
 * 
 */
@Entity
@Table(name="EXP_DET_CRIMEN")
public class DetCrimen extends AuditoriaBean implements Validador, Serializable {

	private static final long serialVersionUID = -6704151480718740744L;

	@Id
	@SequenceGenerator(name="EXP_DET_CRIMEN_ID_GENERATOR", sequenceName="SEQ_")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="EXP_DET_CRIMEN_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=16)
	private Long id;

	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="PRIORIDAD")
	private Valor cfgValor;

	//bi-directional many-to-one association to DetExpedientePersona
	@ManyToOne
	@JoinColumn(name="EXP_PER")
	private DetExpedientePersona expDetExpedientePersona;

	//bi-directional many-to-one association to ExpedienteDelito
	@ManyToOne
	@JoinColumn(name="EXP_DEL")
	private ExpedienteDelito expExpedienteDelito;

	//bi-directional many-to-one association to ExpedienteMediosMovil
	@OneToMany(mappedBy="expDetCrimen")
	private List<ExpedienteMediosMovil> expExpedienteMediosMovils;

	public DetCrimen() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Valor getCfgValor() {
		return this.cfgValor;
	}

	public void setCfgValor(Valor cfgValor) {
		this.cfgValor = cfgValor;
	}

	public DetExpedientePersona getExpDetExpedientePersona() {
		return this.expDetExpedientePersona;
	}

	public void setExpDetExpedientePersona(DetExpedientePersona expDetExpedientePersona) {
		this.expDetExpedientePersona = expDetExpedientePersona;
	}

	public ExpedienteDelito getExpExpedienteDelito() {
		return this.expExpedienteDelito;
	}

	public void setExpExpedienteDelito(ExpedienteDelito expExpedienteDelito) {
		this.expExpedienteDelito = expExpedienteDelito;
	}

	public List<ExpedienteMediosMovil> getExpExpedienteMediosMovils() {
		return this.expExpedienteMediosMovils;
	}

	public void setExpExpedienteMediosMovils(List<ExpedienteMediosMovil> expExpedienteMediosMovils) {
		this.expExpedienteMediosMovils = expExpedienteMediosMovils;
	}

	public ExpedienteMediosMovil addExpExpedienteMediosMovil(ExpedienteMediosMovil expExpedienteMediosMovil) {
		getExpExpedienteMediosMovils().add(expExpedienteMediosMovil);
		expExpedienteMediosMovil.setExpDetCrimen(this);

		return expExpedienteMediosMovil;
	}

	public ExpedienteMediosMovil removeExpExpedienteMediosMovil(ExpedienteMediosMovil expExpedienteMediosMovil) {
		getExpExpedienteMediosMovils().remove(expExpedienteMediosMovil);
		expExpedienteMediosMovil.setExpDetCrimen(null);

		return expExpedienteMediosMovil;
	}

	@Override
	public void validar() {
		// TODO Auto-generated method stub
		
	}

}