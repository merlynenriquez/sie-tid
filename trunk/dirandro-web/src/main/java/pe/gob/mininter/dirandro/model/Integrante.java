package pe.gob.mininter.dirandro.model;

import java.io.Serializable;
import java.math.BigDecimal;
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
import javax.persistence.Transient;

import org.apache.commons.lang.StringUtils;

import pe.gob.mininter.dirandro.util.Validador;
import pe.gob.mininter.dirandro.util.beanbase.AuditoriaBean;


/**
 * The persistent class for the ORG_INTEGRANTE database table.
 * 
 */
@Entity
@Table(name="ORG_INTEGRANTE")
public class Integrante extends AuditoriaBean implements Validador, Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8006992786865932374L;

	@Id
	@SequenceGenerator(name="ORG_INTEGRANTE_ID_GENERATOR", sequenceName="SEQ_")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ORG_INTEGRANTE_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=16)
	private Long id;

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
	private Valor funcion;

	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="ESTADO", nullable=false)
	private Valor estado;

	//bi-directional many-to-one association to Equipo
	@ManyToOne
	@JoinColumn(name="EQUIPO", nullable=false)
	private Equipo orgEquipo;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="INTEGRANTE", nullable=false)
	private Usuario integrante;

	public Integrante() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getEsLider() {
		return esLider;
	}

	public void setEsLider(BigDecimal esLider) {
		this.esLider = esLider;
	}

	public List<Expediente> getExpExpedientes() {
		return expExpedientes;
	}

	public void setExpExpedientes(List<Expediente> expExpedientes) {
		this.expExpedientes = expExpedientes;
	}

	public List<Ruta> getExpRutas() {
		return expRutas;
	}

	public void setExpRutas(List<Ruta> expRutas) {
		this.expRutas = expRutas;
	}

	public Valor getFuncion() {
		return funcion;
	}

	public void setFuncion(Valor funcion) {
		this.funcion = funcion;
	}

	public Valor getEstado() {
		return estado;
	}

	public void setEstado(Valor estado) {
		this.estado = estado;
	}

	public Equipo getOrgEquipo() {
		return orgEquipo;
	}

	public void setOrgEquipo(Equipo orgEquipo) {
		this.orgEquipo = orgEquipo;
	}

	public Usuario getIntegrante() {
		return integrante;
	}

	public void setIntegrante(Usuario integrante) {
		this.integrante = integrante;
	}
	
	@Transient
	public String getNombreCompletoIntegrante() {
		return integrante != null ? integrante.getNombreCompleto() : StringUtils.EMPTY;
	}

	@Override
	public void validar() {
		// TODO Auto-generated method stub
		
	}

}