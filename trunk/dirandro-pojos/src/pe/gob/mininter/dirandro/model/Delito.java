package pe.gob.mininter.dirandro.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the EXP_DELITO database table.
 * 
 */
@Entity
@Table(name="EXP_DELITO")
public class Delito implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="EXP_DELITO_ID_GENERATOR", sequenceName="SEQ_")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="EXP_DELITO_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=16)
	private long id;

	@Column(nullable=false)
	private Timestamp creacion;

	private Timestamp edicion;

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

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="CREADOR", nullable=false)
	private Usuario segUsuario1;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="EDITOR")
	private Usuario segUsuario2;

	//bi-directional many-to-one association to ExpedienteDelito
	@OneToMany(mappedBy="expDelito")
	private List<ExpedienteDelito> expExpedienteDelitos;

	public Delito() {
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

}