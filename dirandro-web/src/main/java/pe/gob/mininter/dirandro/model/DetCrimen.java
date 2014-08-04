package pe.gob.mininter.dirandro.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the EXP_DET_CRIMEN database table.
 * 
 */
@Entity
@Table(name="EXP_DET_CRIMEN")
public class DetCrimen implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="EXP_DET_CRIMEN_ID_GENERATOR", sequenceName="SEQ_")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="EXP_DET_CRIMEN_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=16)
	private long id;

	@Column(nullable=false)
	private Timestamp creacion;

	private Timestamp edicion;

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

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="CREADOR", nullable=false)
	private Usuario segUsuario1;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="EDITOR")
	private Usuario segUsuario2;

	//bi-directional many-to-one association to ExpedienteMediosMovil
	@OneToMany(mappedBy="expDetCrimen")
	private List<ExpedienteMediosMovil> expExpedienteMediosMovils;

	public DetCrimen() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Timestamp getCreacion() {
		return this.creacion;
	}

	public void setCreacion(Timestamp creacion) {
		this.creacion = creacion;
	}

	public Timestamp getEdicion() {
		return this.edicion;
	}

	public void setEdicion(Timestamp edicion) {
		this.edicion = edicion;
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

	public Usuario getSegUsuario1() {
		return this.segUsuario1;
	}

	public void setSegUsuario1(Usuario segUsuario1) {
		this.segUsuario1 = segUsuario1;
	}

	public Usuario getSegUsuario2() {
		return this.segUsuario2;
	}

	public void setSegUsuario2(Usuario segUsuario2) {
		this.segUsuario2 = segUsuario2;
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

}