package pe.gob.mininter.dirandro.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the EXP_DET_PER_TEL_EXP database table.
 * 
 */
@Entity
@Table(name="EXP_DET_PER_TEL_EXP")
public class DetPerTelExp implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="EXP_DET_PER_TEL_EXP_ID_GENERATOR", sequenceName="SEQ_")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="EXP_DET_PER_TEL_EXP_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=16)
	private long id;

	@Column(nullable=false)
	private Timestamp creacion;

	private Timestamp edicion;

	@Column(length=4000)
	private String observacion;

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

	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="OPERADORA")
	private Valor cfgValor3;

	//bi-directional many-to-one association to DetExpedientePersona
	@ManyToOne
	@JoinColumn(name="IMPLICADO")
	private DetExpedientePersona expDetExpedientePersona;

	//bi-directional many-to-one association to Expediente
	@ManyToOne
	@JoinColumn(name="EXPEDIENTE", nullable=false)
	private Expediente expExpediente;

	//bi-directional many-to-one association to Numero
	@ManyToOne
	@JoinColumn(name="NUMERO")
	private Numero expNumero;

	//bi-directional many-to-one association to Persona
	@ManyToOne
	@JoinColumn(name="DUENO")
	private Persona perPersona;

	//bi-directional many-to-one association to Telefono
	@ManyToOne
	@JoinColumn(name="TELEFONO")
	private Telefono perTelefono;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="EDITOR")
	private Usuario segUsuario1;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="CREADOR", nullable=false)
	private Usuario segUsuario2;

	public DetPerTelExp() {
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

	public String getObservacion() {
		return this.observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
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

	public Valor getCfgValor3() {
		return this.cfgValor3;
	}

	public void setCfgValor3(Valor cfgValor3) {
		this.cfgValor3 = cfgValor3;
	}

	public DetExpedientePersona getExpDetExpedientePersona() {
		return this.expDetExpedientePersona;
	}

	public void setExpDetExpedientePersona(DetExpedientePersona expDetExpedientePersona) {
		this.expDetExpedientePersona = expDetExpedientePersona;
	}

	public Expediente getExpExpediente() {
		return this.expExpediente;
	}

	public void setExpExpediente(Expediente expExpediente) {
		this.expExpediente = expExpediente;
	}

	public Numero getExpNumero() {
		return this.expNumero;
	}

	public void setExpNumero(Numero expNumero) {
		this.expNumero = expNumero;
	}

	public Persona getPerPersona() {
		return this.perPersona;
	}

	public void setPerPersona(Persona perPersona) {
		this.perPersona = perPersona;
	}

	public Telefono getPerTelefono() {
		return this.perTelefono;
	}

	public void setPerTelefono(Telefono perTelefono) {
		this.perTelefono = perTelefono;
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