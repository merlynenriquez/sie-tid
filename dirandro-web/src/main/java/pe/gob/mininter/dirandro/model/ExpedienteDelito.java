package pe.gob.mininter.dirandro.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the EXP_EXPEDIENTE_DELITO database table.
 * 
 */
@Entity
@Table(name="EXP_EXPEDIENTE_DELITO")
public class ExpedienteDelito implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="EXP_EXPEDIENTE_DELITO_ID_GENERATOR", sequenceName="SEQ_")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="EXP_EXPEDIENTE_DELITO_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=16)
	private long id;

	@Column(nullable=false)
	private Timestamp creacion;

	private Timestamp edicion;

	//bi-directional many-to-one association to DetCrimen
	@OneToMany(mappedBy="expExpedienteDelito")
	private List<DetCrimen> expDetCrimens;

	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="PRIORIDAD", nullable=false)
	private Valor cfgValor;

	//bi-directional many-to-one association to Delito
	@ManyToOne
	@JoinColumn(name="DELITO", nullable=false)
	private Delito expDelito;

	//bi-directional many-to-one association to Expediente
	@ManyToOne
	@JoinColumn(name="EXPEDIENTE", nullable=false)
	private Expediente expExpediente;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="EDITOR")
	private Usuario segUsuario1;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="CREADOR", nullable=false)
	private Usuario segUsuario2;

	public ExpedienteDelito() {
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

	public List<DetCrimen> getExpDetCrimens() {
		return this.expDetCrimens;
	}

	public void setExpDetCrimens(List<DetCrimen> expDetCrimens) {
		this.expDetCrimens = expDetCrimens;
	}

	public DetCrimen addExpDetCrimen(DetCrimen expDetCrimen) {
		getExpDetCrimens().add(expDetCrimen);
		expDetCrimen.setExpExpedienteDelito(this);

		return expDetCrimen;
	}

	public DetCrimen removeExpDetCrimen(DetCrimen expDetCrimen) {
		getExpDetCrimens().remove(expDetCrimen);
		expDetCrimen.setExpExpedienteDelito(null);

		return expDetCrimen;
	}

	public Valor getCfgValor() {
		return this.cfgValor;
	}

	public void setCfgValor(Valor cfgValor) {
		this.cfgValor = cfgValor;
	}

	public Delito getExpDelito() {
		return this.expDelito;
	}

	public void setExpDelito(Delito expDelito) {
		this.expDelito = expDelito;
	}

	public Expediente getExpExpediente() {
		return this.expExpediente;
	}

	public void setExpExpediente(Expediente expExpediente) {
		this.expExpediente = expExpediente;
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

}