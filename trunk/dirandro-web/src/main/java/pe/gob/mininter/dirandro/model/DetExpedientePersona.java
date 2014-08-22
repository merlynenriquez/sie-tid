package pe.gob.mininter.dirandro.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
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
 * The persistent class for the EXP_DET_EXPEDIENTE_PERSONA database table.
 * 
 */
@Entity
@Table(name="EXP_DET_EXPEDIENTE_PERSONA")
public class DetExpedientePersona extends AuditoriaBean implements Validador, Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3388910551739102700L;

	@Id
	@SequenceGenerator(name="EXP_DET_EXPEDIENTE_PERSONA_ID_GENERATOR", sequenceName="SEQ_", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="EXP_DET_EXPEDIENTE_PERSONA_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=16)
	private Long id;

	@Column(name="\"ALIAS\"", length=400)
	private String alias;

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
	private Valor situacion;

	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="PARTICIPACION")
	private Valor participacion;

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

	public DetExpedientePersona() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public BigDecimal getEstadoDato() {
		return estadoDato;
	}

	public void setEstadoDato(BigDecimal estadoDato) {
		this.estadoDato = estadoDato;
	}

	public Timestamp getIntervencion() {
		return intervencion;
	}

	public void setIntervencion(Timestamp intervencion) {
		this.intervencion = intervencion;
	}

	public BigDecimal getOcupacion() {
		return ocupacion;
	}

	public void setOcupacion(BigDecimal ocupacion) {
		this.ocupacion = ocupacion;
	}

	public BigDecimal getRequisitoria() {
		return requisitoria;
	}

	public void setRequisitoria(BigDecimal requisitoria) {
		this.requisitoria = requisitoria;
	}

	public BigDecimal getTipoParticipacion() {
		return tipoParticipacion;
	}

	public void setTipoParticipacion(BigDecimal tipoParticipacion) {
		this.tipoParticipacion = tipoParticipacion;
	}

	public List<AbogadoPersona> getExpAbogadoPersonas() {
		return expAbogadoPersonas;
	}

	public void setExpAbogadoPersonas(List<AbogadoPersona> expAbogadoPersonas) {
		this.expAbogadoPersonas = expAbogadoPersonas;
	}

	public List<DetCrimen> getExpDetCrimens() {
		return expDetCrimens;
	}

	public void setExpDetCrimens(List<DetCrimen> expDetCrimens) {
		this.expDetCrimens = expDetCrimens;
	}

	public Valor getSituacion() {
		return situacion;
	}

	public void setSituacion(Valor situacion) {
		this.situacion = situacion;
	}

	public Valor getParticipacion() {
		return participacion;
	}

	public void setParticipacion(Valor participacion) {
		this.participacion = participacion;
	}

	public Expediente getExpExpediente() {
		return expExpediente;
	}

	public void setExpExpediente(Expediente expExpediente) {
		this.expExpediente = expExpediente;
	}

	public Organizacion getExpOrganizacion() {
		return expOrganizacion;
	}

	public void setExpOrganizacion(Organizacion expOrganizacion) {
		this.expOrganizacion = expOrganizacion;
	}

	public Empresa getPerEmpresa() {
		return perEmpresa;
	}

	public void setPerEmpresa(Empresa perEmpresa) {
		this.perEmpresa = perEmpresa;
	}

	public Persona getPerPersona() {
		return perPersona;
	}

	public void setPerPersona(Persona perPersona) {
		this.perPersona = perPersona;
	}

	@Override
	public void validar() {
		// TODO Auto-generated method stub
		
	}

}