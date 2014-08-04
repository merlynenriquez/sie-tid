package pe.gob.mininter.dirandro.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the EXP_DET_EXPEDIENTE_PERSONA database table.
 * 
 */
@Entity
@Table(name="EXP_DET_EXPEDIENTE_PERSONA")
public class DetExpedientePersona implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="EXP_DET_EXPEDIENTE_PERSONA_ID_GENERATOR", sequenceName="SEQ_")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="EXP_DET_EXPEDIENTE_PERSONA_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=16)
	private long id;

	@Column(name="\"ALIAS\"", length=400)
	private String alias;

	@Column(nullable=false)
	private Timestamp creacion;

	private Timestamp edicion;

	@Column(name="ESTADO_DATO", precision=16)
	private BigDecimal estadoDato;

	private Timestamp intervencion;

	@Column(precision=16)
	private BigDecimal ocupacion;

	@Column(precision=1)
	private BigDecimal requisitoria;

	@Column(name="TIPO_PARTICIPACION", precision=16)
	private BigDecimal tipoParticipacion;

	//bi-directional many-to-one association to AbogadoPersona
	@OneToMany(mappedBy="expDetExpedientePersona")
	private List<AbogadoPersona> expAbogadoPersonas;

	//bi-directional many-to-one association to DetCrimen
	@OneToMany(mappedBy="expDetExpedientePersona")
	private List<DetCrimen> expDetCrimens;

	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="SITUACION")
	private Valor cfgValor1;

	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="PARTICIPACION")
	private Valor cfgValor2;

	//bi-directional many-to-one association to Expediente
	@ManyToOne
	@JoinColumn(name="EXPEDIENTE", nullable=false)
	private Expediente expExpediente;

	//bi-directional many-to-one association to Organizacion
	@ManyToOne
	@JoinColumn(name="ORGANIZACION")
	private Organizacion expOrganizacion;

	//bi-directional many-to-one association to Empresa
	@ManyToOne
	@JoinColumn(name="EMPRESA")
	private Empresa perEmpresa;

	//bi-directional many-to-one association to Persona
	@ManyToOne
	@JoinColumn(name="INVOLUCRADO")
	private Persona perPersona;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="CREADOR", nullable=false)
	private Usuario segUsuario1;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="EDITOR")
	private Usuario segUsuario2;

	public DetExpedientePersona() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAlias() {
		return this.alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
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

	public BigDecimal getEstadoDato() {
		return this.estadoDato;
	}

	public void setEstadoDato(BigDecimal estadoDato) {
		this.estadoDato = estadoDato;
	}

	public Timestamp getIntervencion() {
		return this.intervencion;
	}

	public void setIntervencion(Timestamp intervencion) {
		this.intervencion = intervencion;
	}

	public BigDecimal getOcupacion() {
		return this.ocupacion;
	}

	public void setOcupacion(BigDecimal ocupacion) {
		this.ocupacion = ocupacion;
	}

	public BigDecimal getRequisitoria() {
		return this.requisitoria;
	}

	public void setRequisitoria(BigDecimal requisitoria) {
		this.requisitoria = requisitoria;
	}

	public BigDecimal getTipoParticipacion() {
		return this.tipoParticipacion;
	}

	public void setTipoParticipacion(BigDecimal tipoParticipacion) {
		this.tipoParticipacion = tipoParticipacion;
	}

	public List<AbogadoPersona> getExpAbogadoPersonas() {
		return this.expAbogadoPersonas;
	}

	public void setExpAbogadoPersonas(List<AbogadoPersona> expAbogadoPersonas) {
		this.expAbogadoPersonas = expAbogadoPersonas;
	}

	public AbogadoPersona addExpAbogadoPersona(AbogadoPersona expAbogadoPersona) {
		getExpAbogadoPersonas().add(expAbogadoPersona);
		expAbogadoPersona.setExpDetExpedientePersona(this);

		return expAbogadoPersona;
	}

	public AbogadoPersona removeExpAbogadoPersona(AbogadoPersona expAbogadoPersona) {
		getExpAbogadoPersonas().remove(expAbogadoPersona);
		expAbogadoPersona.setExpDetExpedientePersona(null);

		return expAbogadoPersona;
	}

	public List<DetCrimen> getExpDetCrimens() {
		return this.expDetCrimens;
	}

	public void setExpDetCrimens(List<DetCrimen> expDetCrimens) {
		this.expDetCrimens = expDetCrimens;
	}

	public DetCrimen addExpDetCrimen(DetCrimen expDetCrimen) {
		getExpDetCrimens().add(expDetCrimen);
		expDetCrimen.setExpDetExpedientePersona(this);

		return expDetCrimen;
	}

	public DetCrimen removeExpDetCrimen(DetCrimen expDetCrimen) {
		getExpDetCrimens().remove(expDetCrimen);
		expDetCrimen.setExpDetExpedientePersona(null);

		return expDetCrimen;
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

	public Organizacion getExpOrganizacion() {
		return this.expOrganizacion;
	}

	public void setExpOrganizacion(Organizacion expOrganizacion) {
		this.expOrganizacion = expOrganizacion;
	}

	public Empresa getPerEmpresa() {
		return this.perEmpresa;
	}

	public void setPerEmpresa(Empresa perEmpresa) {
		this.perEmpresa = perEmpresa;
	}

	public Persona getPerPersona() {
		return this.perPersona;
	}

	public void setPerPersona(Persona perPersona) {
		this.perPersona = perPersona;
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