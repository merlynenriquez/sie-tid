package pe.gob.mininter.dirandro.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the EXP_DEPENDENCIA database table.
 * 
 */
@Entity
@Table(name="EXP_DEPENDENCIA")
public class Dependencia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="EXP_DEPENDENCIA_ID_GENERATOR", sequenceName="SEQ_")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="EXP_DEPENDENCIA_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=16)
	private long id;

	@Column(length=2000)
	private String abreviatura;

	@Column(length=30)
	private String codigo;

	@Column(nullable=false)
	private Timestamp creacion;

	@Column(length=600)
	private String direccion;

	private Timestamp edicion;

	@Column(length=2000)
	private String nombre;

	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="SIGLA")
	private Valor cfgValor1;

	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="ESTADO")
	private Valor cfgValor2;

	//bi-directional many-to-one association to Dependencia
	@ManyToOne
	@JoinColumn(name="PADRE")
	private Dependencia expDependencia;

	//bi-directional many-to-one association to Dependencia
	@OneToMany(mappedBy="expDependencia")
	private List<Dependencia> expDependencias;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="CREADOR", nullable=false)
	private Usuario segUsuario1;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="EDITOR")
	private Usuario segUsuario2;

	//bi-directional many-to-one association to Expediente
	@OneToMany(mappedBy="expDependencia")
	private List<Expediente> expExpedientes;

	//bi-directional many-to-one association to Predecesor
	@OneToMany(mappedBy="expDependencia1")
	private List<Predecesor> expPredecesors1;

	//bi-directional many-to-one association to Predecesor
	@OneToMany(mappedBy="expDependencia2")
	private List<Predecesor> expPredecesors2;

	//bi-directional many-to-one association to Hojaremision
	@OneToMany(mappedBy="expDependencia1")
	private List<Hojaremision> hrHojaremisions1;

	//bi-directional many-to-one association to Hojaremision
	@OneToMany(mappedBy="expDependencia2")
	private List<Hojaremision> hrHojaremisions2;

	//bi-directional many-to-one association to Equipo
	@OneToMany(mappedBy="expDependencia")
	private List<Equipo> orgEquipos;

	//bi-directional many-to-one association to Usuario
	@OneToMany(mappedBy="expDependencia")
	private List<Usuario> segUsuarios;

	public Dependencia() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAbreviatura() {
		return this.abreviatura;
	}

	public void setAbreviatura(String abreviatura) {
		this.abreviatura = abreviatura;
	}

	public String getCodigo() {
		return this.codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Timestamp getCreacion() {
		return this.creacion;
	}

	public void setCreacion(Timestamp creacion) {
		this.creacion = creacion;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
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

	public Dependencia getExpDependencia() {
		return this.expDependencia;
	}

	public void setExpDependencia(Dependencia expDependencia) {
		this.expDependencia = expDependencia;
	}

	public List<Dependencia> getExpDependencias() {
		return this.expDependencias;
	}

	public void setExpDependencias(List<Dependencia> expDependencias) {
		this.expDependencias = expDependencias;
	}

	public Dependencia addExpDependencia(Dependencia expDependencia) {
		getExpDependencias().add(expDependencia);
		expDependencia.setExpDependencia(this);

		return expDependencia;
	}

	public Dependencia removeExpDependencia(Dependencia expDependencia) {
		getExpDependencias().remove(expDependencia);
		expDependencia.setExpDependencia(null);

		return expDependencia;
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

	public List<Expediente> getExpExpedientes() {
		return this.expExpedientes;
	}

	public void setExpExpedientes(List<Expediente> expExpedientes) {
		this.expExpedientes = expExpedientes;
	}

	public Expediente addExpExpediente(Expediente expExpediente) {
		getExpExpedientes().add(expExpediente);
		expExpediente.setExpDependencia(this);

		return expExpediente;
	}

	public Expediente removeExpExpediente(Expediente expExpediente) {
		getExpExpedientes().remove(expExpediente);
		expExpediente.setExpDependencia(null);

		return expExpediente;
	}

	public List<Predecesor> getExpPredecesors1() {
		return this.expPredecesors1;
	}

	public void setExpPredecesors1(List<Predecesor> expPredecesors1) {
		this.expPredecesors1 = expPredecesors1;
	}

	public Predecesor addExpPredecesors1(Predecesor expPredecesors1) {
		getExpPredecesors1().add(expPredecesors1);
		expPredecesors1.setExpDependencia1(this);

		return expPredecesors1;
	}

	public Predecesor removeExpPredecesors1(Predecesor expPredecesors1) {
		getExpPredecesors1().remove(expPredecesors1);
		expPredecesors1.setExpDependencia1(null);

		return expPredecesors1;
	}

	public List<Predecesor> getExpPredecesors2() {
		return this.expPredecesors2;
	}

	public void setExpPredecesors2(List<Predecesor> expPredecesors2) {
		this.expPredecesors2 = expPredecesors2;
	}

	public Predecesor addExpPredecesors2(Predecesor expPredecesors2) {
		getExpPredecesors2().add(expPredecesors2);
		expPredecesors2.setExpDependencia2(this);

		return expPredecesors2;
	}

	public Predecesor removeExpPredecesors2(Predecesor expPredecesors2) {
		getExpPredecesors2().remove(expPredecesors2);
		expPredecesors2.setExpDependencia2(null);

		return expPredecesors2;
	}

	public List<Hojaremision> getHrHojaremisions1() {
		return this.hrHojaremisions1;
	}

	public void setHrHojaremisions1(List<Hojaremision> hrHojaremisions1) {
		this.hrHojaremisions1 = hrHojaremisions1;
	}

	public Hojaremision addHrHojaremisions1(Hojaremision hrHojaremisions1) {
		getHrHojaremisions1().add(hrHojaremisions1);
		hrHojaremisions1.setExpDependencia1(this);

		return hrHojaremisions1;
	}

	public Hojaremision removeHrHojaremisions1(Hojaremision hrHojaremisions1) {
		getHrHojaremisions1().remove(hrHojaremisions1);
		hrHojaremisions1.setExpDependencia1(null);

		return hrHojaremisions1;
	}

	public List<Hojaremision> getHrHojaremisions2() {
		return this.hrHojaremisions2;
	}

	public void setHrHojaremisions2(List<Hojaremision> hrHojaremisions2) {
		this.hrHojaremisions2 = hrHojaremisions2;
	}

	public Hojaremision addHrHojaremisions2(Hojaremision hrHojaremisions2) {
		getHrHojaremisions2().add(hrHojaremisions2);
		hrHojaremisions2.setExpDependencia2(this);

		return hrHojaremisions2;
	}

	public Hojaremision removeHrHojaremisions2(Hojaremision hrHojaremisions2) {
		getHrHojaremisions2().remove(hrHojaremisions2);
		hrHojaremisions2.setExpDependencia2(null);

		return hrHojaremisions2;
	}

	public List<Equipo> getOrgEquipos() {
		return this.orgEquipos;
	}

	public void setOrgEquipos(List<Equipo> orgEquipos) {
		this.orgEquipos = orgEquipos;
	}

	public Equipo addOrgEquipo(Equipo orgEquipo) {
		getOrgEquipos().add(orgEquipo);
		orgEquipo.setExpDependencia(this);

		return orgEquipo;
	}

	public Equipo removeOrgEquipo(Equipo orgEquipo) {
		getOrgEquipos().remove(orgEquipo);
		orgEquipo.setExpDependencia(null);

		return orgEquipo;
	}

	public List<Usuario> getSegUsuarios() {
		return this.segUsuarios;
	}

	public void setSegUsuarios(List<Usuario> segUsuarios) {
		this.segUsuarios = segUsuarios;
	}

	public Usuario addSegUsuario(Usuario segUsuario) {
		getSegUsuarios().add(segUsuario);
		segUsuario.setExpDependencia(this);

		return segUsuario;
	}

	public Usuario removeSegUsuario(Usuario segUsuario) {
		getSegUsuarios().remove(segUsuario);
		segUsuario.setExpDependencia(null);

		return segUsuario;
	}

}