package pe.gob.mininter.dirandro.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the ORG_EQUIPO database table.
 * 
 */
@Entity
@Table(name="ORG_EQUIPO")
public class Equipo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="ORG_EQUIPO_ID_GENERATOR", sequenceName="SEQ_")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ORG_EQUIPO_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=16)
	private long id;

	@Column(nullable=false, length=40)
	private String codigo;

	@Column(nullable=false)
	private Timestamp creacion;

	private Timestamp edicion;

	@Column(nullable=false, length=400)
	private String nombre;

	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="TIPO_AGRUPACION")
	private Valor cfgValor1;

	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="ESTADO", nullable=false)
	private Valor cfgValor2;

	//bi-directional many-to-one association to Dependencia
	@ManyToOne
	@JoinColumn(name="DEPENDENCIA")
	private Dependencia expDependencia;

	//bi-directional many-to-one association to Equipo
	@ManyToOne
	@JoinColumn(name="PADRE")
	private Equipo orgEquipo;

	//bi-directional many-to-one association to Equipo
	@OneToMany(mappedBy="orgEquipo")
	private List<Equipo> orgEquipos;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="EDITOR")
	private Usuario segUsuario1;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="CREADOR", nullable=false)
	private Usuario segUsuario2;

	//bi-directional many-to-one association to Integrante
	@OneToMany(mappedBy="orgEquipo")
	private List<Integrante> orgIntegrantes;

	public Equipo() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
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

	public Equipo getOrgEquipo() {
		return this.orgEquipo;
	}

	public void setOrgEquipo(Equipo orgEquipo) {
		this.orgEquipo = orgEquipo;
	}

	public List<Equipo> getOrgEquipos() {
		return this.orgEquipos;
	}

	public void setOrgEquipos(List<Equipo> orgEquipos) {
		this.orgEquipos = orgEquipos;
	}

	public Equipo addOrgEquipo(Equipo orgEquipo) {
		getOrgEquipos().add(orgEquipo);
		orgEquipo.setOrgEquipo(this);

		return orgEquipo;
	}

	public Equipo removeOrgEquipo(Equipo orgEquipo) {
		getOrgEquipos().remove(orgEquipo);
		orgEquipo.setOrgEquipo(null);

		return orgEquipo;
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

	public List<Integrante> getOrgIntegrantes() {
		return this.orgIntegrantes;
	}

	public void setOrgIntegrantes(List<Integrante> orgIntegrantes) {
		this.orgIntegrantes = orgIntegrantes;
	}

	public Integrante addOrgIntegrante(Integrante orgIntegrante) {
		getOrgIntegrantes().add(orgIntegrante);
		orgIntegrante.setOrgEquipo(this);

		return orgIntegrante;
	}

	public Integrante removeOrgIntegrante(Integrante orgIntegrante) {
		getOrgIntegrantes().remove(orgIntegrante);
		orgIntegrante.setOrgEquipo(null);

		return orgIntegrante;
	}

}