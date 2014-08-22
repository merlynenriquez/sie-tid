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
 * The persistent class for the EXP_DELITO database table.
 * 
 */
@Entity
@Table(name="EXP_DELITO")
public class Delito extends AuditoriaBean implements Validador, Serializable {
	
	private static final long serialVersionUID = 8754887405793559368L;

	@Id
	@SequenceGenerator(name="EXP_DELITO_ID_GENERATOR", sequenceName="SEQ_", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="EXP_DELITO_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=16)
	private Long id;

	@Column(length=200)
	private String codigo;

	@Column(length=400)
	private String nombre;

	@Column(length=4000)
	private String observacion;

	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="ESTADO")
	private Valor cfgValor1;

	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="TIPO_CODIGO")
	private Valor cfgValor2;

	//bi-directional many-to-one association to Delito
	@ManyToOne
	@JoinColumn(name="PADRE")
	private Delito expDelito;

	//bi-directional many-to-one association to Delito
	@OneToMany(mappedBy="expDelito")
	private List<Delito> expDelitos;

	//bi-directional many-to-one association to ExpedienteDelito
	@OneToMany(mappedBy="expDelito")
	private List<ExpedienteDelito> expExpedienteDelitos;

	public Delito() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCodigo() {
		return this.codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getObservacion() {
		return this.observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
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

	public Delito getExpDelito() {
		return this.expDelito;
	}

	public void setExpDelito(Delito expDelito) {
		this.expDelito = expDelito;
	}

	public List<Delito> getExpDelitos() {
		return this.expDelitos;
	}

	public void setExpDelitos(List<Delito> expDelitos) {
		this.expDelitos = expDelitos;
	}

	public Delito addExpDelito(Delito expDelito) {
		getExpDelitos().add(expDelito);
		expDelito.setExpDelito(this);

		return expDelito;
	}

	public Delito removeExpDelito(Delito expDelito) {
		getExpDelitos().remove(expDelito);
		expDelito.setExpDelito(null);

		return expDelito;
	}

	public List<ExpedienteDelito> getExpExpedienteDelitos() {
		return this.expExpedienteDelitos;
	}

	public void setExpExpedienteDelitos(List<ExpedienteDelito> expExpedienteDelitos) {
		this.expExpedienteDelitos = expExpedienteDelitos;
	}

	public ExpedienteDelito addExpExpedienteDelito(ExpedienteDelito expExpedienteDelito) {
		getExpExpedienteDelitos().add(expExpedienteDelito);
		expExpedienteDelito.setExpDelito(this);

		return expExpedienteDelito;
	}

	public ExpedienteDelito removeExpExpedienteDelito(ExpedienteDelito expExpedienteDelito) {
		getExpExpedienteDelitos().remove(expExpedienteDelito);
		expExpedienteDelito.setExpDelito(null);

		return expExpedienteDelito;
	}

	@Override
	public void validar() {
		// TODO Auto-generated method stub
		
	}

}