package pe.gob.mininter.dirandro.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the ORG_INTEGRANTE database table.
 * 
 */
@Entity
@Table(name="ORG_INTEGRANTE")
public class Integrante implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="ORG_INTEGRANTE_ID_GENERATOR", sequenceName="SEQ_")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ORG_INTEGRANTE_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=16)
	private long id;

	@Column(nullable=false)
	private Timestamp creacion;

	private Timestamp edicion;

	@Column(name="ES_LIDER", nullable=false, precision=22)
	private BigDecimal esLider;

	//bi-directional many-to-one association to Expediente
	@OneToMany(mappedBy="orgIntegrante")
	private List<Expediente> expExpedientes;

	//bi-directional many-to-one association to Ruta
	@OneToMany(mappedBy="orgIntegrante")
	private List<Ruta> expRutas;

	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="FUNCION")
	private Valor cfgValor1;

	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="ESTADO", nullable=false)
	private Valor cfgValor2;

	//bi-directional many-to-one association to Equipo
	@ManyToOne
	@JoinColumn(name="EQUIPO", nullable=false)
	private Equipo orgEquipo;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="EDITOR")
	private Usuario segUsuario1;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="CREADOR", nullable=false)
	private Usuario segUsuario2;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="INTEGRANTE", nullable=false)
	private Usuario segUsuario3;

	public Integrante() {
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

	public BigDecimal getEsLider() {
		return this.esLider;
	}

	public void setEsLider(BigDecimal esLider) {
		this.esLider = esLider;
	}

	public List<Expediente> getExpExpedientes() {
		return this.expExpedientes;
	}

	public void setExpExpedientes(List<Expediente> expExpedientes) {
		this.expExpedientes = expExpedientes;
	}

	public Expediente addExpExpediente(Expediente expExpediente) {
		getExpExpedientes().add(expExpediente);
		expExpediente.setOrgIntegrante(this);

		return expExpediente;
	}

	public Expediente removeExpExpediente(Expediente expExpediente) {
		getExpExpedientes().remove(expExpediente);
		expExpediente.setOrgIntegrante(null);

		return expExpediente;
	}

	public List<Ruta> getExpRutas() {
		return this.expRutas;
	}

	public void setExpRutas(List<Ruta> expRutas) {
		this.expRutas = expRutas;
	}

	public Ruta addExpRuta(Ruta expRuta) {
		getExpRutas().add(expRuta);
		expRuta.setOrgIntegrante(this);

		return expRuta;
	}

	public Ruta removeExpRuta(Ruta expRuta) {
		getExpRutas().remove(expRuta);
		expRuta.setOrgIntegrante(null);

		return expRuta;
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

	public Equipo getOrgEquipo() {
		return this.orgEquipo;
	}

	public void setOrgEquipo(Equipo orgEquipo) {
		this.orgEquipo = orgEquipo;
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

	public Usuario getSegUsuario3() {
		return this.segUsuario3;
	}

	public void setSegUsuario3(Usuario segUsuario3) {
		this.segUsuario3 = segUsuario3;
	}

}