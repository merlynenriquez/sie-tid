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
 * The persistent class for the ORG_EQUIPO database table.
 * 
 */
@Entity
@Table(name="ORG_EQUIPO")
public class Equipo extends AuditoriaBean implements Validador, Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3314570696630180739L;

	@Id
	@SequenceGenerator(name="ORG_EQUIPO_ID_GENERATOR", sequenceName="SEQ_")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ORG_EQUIPO_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=16)
	private Long id;

	@Column(nullable=false, length=40)
	private String codigo;

	@Column(nullable=false, length=400)
	private String nombre;

	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="TIPO_AGRUPACION")
	private Valor tipoAgrupacion;

	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="ESTADO", nullable=false)
	private Valor estado;

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

	//bi-directional many-to-one association to Integrante
	@OneToMany(mappedBy="orgEquipo")
	private List<Integrante> orgIntegrantes;

	public Equipo() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Valor getTipoAgrupacion() {
		return tipoAgrupacion;
	}

	public void setTipoAgrupacion(Valor tipoAgrupacion) {
		this.tipoAgrupacion = tipoAgrupacion;
	}

	public Valor getEstado() {
		return estado;
	}

	public void setEstado(Valor estado) {
		this.estado = estado;
	}

	public Dependencia getExpDependencia() {
		return expDependencia;
	}

	public void setExpDependencia(Dependencia expDependencia) {
		this.expDependencia = expDependencia;
	}

	public Equipo getOrgEquipo() {
		return orgEquipo;
	}

	public void setOrgEquipo(Equipo orgEquipo) {
		this.orgEquipo = orgEquipo;
	}

	public List<Equipo> getOrgEquipos() {
		return orgEquipos;
	}

	public void setOrgEquipos(List<Equipo> orgEquipos) {
		this.orgEquipos = orgEquipos;
	}

	public List<Integrante> getOrgIntegrantes() {
		return orgIntegrantes;
	}

	public void setOrgIntegrantes(List<Integrante> orgIntegrantes) {
		this.orgIntegrantes = orgIntegrantes;
	}

	@Override
	public void validar() {
		// TODO Auto-generated method stub
		
	}

}