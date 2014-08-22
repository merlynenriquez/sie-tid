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
 * The persistent class for the EXP_DET_PER_TEL_EXP database table.
 * 
 */
@Entity
@Table(name="EXP_DET_PER_TEL_EXP")
public class DetPerTelExp extends AuditoriaBean implements Validador, Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2597824744398259948L;

	@Id
	@SequenceGenerator(name="EXP_DET_PER_TEL_EXP_ID_GENERATOR", sequenceName="SEQ_", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="EXP_DET_PER_TEL_EXP_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=16)
	private Long id;

	@Column(length=40)
	private String imei;

	//bi-directional many-to-one association to DetLlamada
	@OneToMany(mappedBy="expDetPerTelExp")
	private List<DetLlamada> expDetLlamadas;

	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="ESTADO")
	private Valor cfgValor1;

	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="SITUACION")
	private Valor cfgValor2;

	//bi-directional many-to-one association to Expediente
	@ManyToOne
	@JoinColumn(name="EXPEDIENTE", nullable=false)
	private Expediente expExpediente;

	//bi-directional many-to-one association to Persona
	@ManyToOne
	@JoinColumn(name="DUENO")
	private Persona perPersona1;

	//bi-directional many-to-one association to Persona
	@ManyToOne
	@JoinColumn(name="PERSONA")
	private Persona perPersona2;

	//bi-directional many-to-one association to Telefono
	@ManyToOne
	@JoinColumn(name="TELEFONO")
	private Telefono perTelefono;

	public DetPerTelExp() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getImei() {
		return this.imei;
	}

	public void setImei(String imei) {
		this.imei = imei;
	}

	public List<DetLlamada> getExpDetLlamadas() {
		return this.expDetLlamadas;
	}

	public void setExpDetLlamadas(List<DetLlamada> expDetLlamadas) {
		this.expDetLlamadas = expDetLlamadas;
	}

	public DetLlamada addExpDetLlamada(DetLlamada expDetLlamada) {
		getExpDetLlamadas().add(expDetLlamada);
		expDetLlamada.setExpDetPerTelExp(this);

		return expDetLlamada;
	}

	public DetLlamada removeExpDetLlamada(DetLlamada expDetLlamada) {
		getExpDetLlamadas().remove(expDetLlamada);
		expDetLlamada.setExpDetPerTelExp(null);

		return expDetLlamada;
	}

	public Valor getCfgValor1() {
		return this.cfgValor1;
	}

	public void setCfgValor1(Valor cfgValor1) {
		this.cfgValor1 = cfgValor1;
	}

	public Valor getCfgValor2() {
		return this.cfgValor2;
	}

	public void setCfgValor2(Valor cfgValor2) {
		this.cfgValor2 = cfgValor2;
	}

	public Expediente getExpExpediente() {
		return this.expExpediente;
	}

	public void setExpExpediente(Expediente expExpediente) {
		this.expExpediente = expExpediente;
	}

	public Persona getPerPersona1() {
		return this.perPersona1;
	}

	public void setPerPersona1(Persona perPersona1) {
		this.perPersona1 = perPersona1;
	}

	public Persona getPerPersona2() {
		return this.perPersona2;
	}

	public void setPerPersona2(Persona perPersona2) {
		this.perPersona2 = perPersona2;
	}

	public Telefono getPerTelefono() {
		return this.perTelefono;
	}

	public void setPerTelefono(Telefono perTelefono) {
		this.perTelefono = perTelefono;
	}

	@Override
	public void validar() {
		// TODO Auto-generated method stub
		
	}

}