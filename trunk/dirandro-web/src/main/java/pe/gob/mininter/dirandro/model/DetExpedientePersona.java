package pe.gob.mininter.dirandro.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import pe.gob.mininter.dirandro.exception.ValidacionException;
import pe.gob.mininter.dirandro.util.Constante;
import pe.gob.mininter.dirandro.util.Validador;
import pe.gob.mininter.dirandro.util.beanbase.AuditoriaBean;

@Entity
@Table(name="EXP_DET_EXPEDIENTE_PERSONA")
public class DetExpedientePersona extends AuditoriaBean implements Validador, Serializable {
	
	private static final long serialVersionUID = -3388910551739102700L;

	@Id
	@SequenceGenerator(name="EXP_DET_EXPEDIENTE_PERSONA_ID_GENERATOR", sequenceName="SEQ_EXPEDIENTE_PERSONA", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="EXP_DET_EXPEDIENTE_PERSONA_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=16)
	private Long id;

	@Column(name="ALIAS", length=400)
	private String alias;

	@ManyToOne
	@JoinColumn(name="ESTADO_DATO")
	@NotNull(message=Constante.CODIGO_MENSAJE.VALIDAR_COMBOBOX)
	private Valor estadoDato;

	@Column(name="INTERVENCION")
	@Temporal( TemporalType.TIMESTAMP)
	@NotNull(message=Constante.CODIGO_MENSAJE.VALIDAR_TEXTBOX)
	private Date intervencion;

	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="OCUPACION")
	private Valor ocupacion;

	@Column(name="TIPO_PARTICIPACION", precision=16)
	private BigDecimal tipoParticipacion;

	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="SITUACION")
	@NotNull(message=Constante.CODIGO_MENSAJE.VALIDAR_COMBOBOX)
	private Valor situacion;

	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="PARTICIPACION")
	private Valor participacion;

	//bi-directional many-to-one association to Expediente
	@ManyToOne
	@JoinColumn(name="EXPEDIENTE", nullable=false)
	private Expediente expediente;

	//bi-directional many-to-one association to Organizacion
	@ManyToOne
	@JoinColumn(name="ORGANIZACION")
	private Organizacion organizacion;

	//bi-directional many-to-one association to Empresa
	@ManyToOne
	@JoinColumn(name="EMPRESA")
	private Empresa empresaInvolucrada;

	//bi-directional many-to-one association to Persona
	@ManyToOne
	@JoinColumn(name="INVOLUCRADO")
	private Persona involucrado;
	
	public DetExpedientePersona() {
	}
	
	public boolean esNuevo(){
		return id == null || id.longValue() == 0;
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

	public Valor getEstadoDato() {
		return estadoDato;
	}

	public void setEstadoDato(Valor estadoDato) {
		this.estadoDato = estadoDato;
	}

	public Date getIntervencion() {
		return intervencion;
	}

	public void setIntervencion(Date intervencion) {
		this.intervencion = intervencion;
	}

	public Valor getOcupacion() {
		return ocupacion;
	}

	public void setOcupacion(Valor ocupacion) {
		this.ocupacion = ocupacion;
	}

	public BigDecimal getTipoParticipacion() {
		return tipoParticipacion;
	}

	public void setTipoParticipacion(BigDecimal tipoParticipacion) {
		this.tipoParticipacion = tipoParticipacion;
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

	public Expediente getExpediente() {
		return expediente;
	}

	public void setExpediente(Expediente expediente) {
		this.expediente = expediente;
	}

	public Organizacion getOrganizacion() {
		return organizacion;
	}

	public void setOrganizacion(Organizacion organizacion) {
		this.organizacion = organizacion;
	}

	public Empresa getEmpresaInvolucrada() {
		return empresaInvolucrada;
	}

	public void setEmpresaInvolucrada(Empresa empresaInvolucrada) {
		this.empresaInvolucrada = empresaInvolucrada;
	}

	public Persona getInvolucrado() {
		return involucrado;
	}

	public void setInvolucrado(Persona involucrado) {
		this.involucrado = involucrado;
	}
	
	public String getNombreCompleto(){
		return involucrado.getNombreCompleto();
	}

	@Override
	public void validar() {
		if( this.getEmpresaInvolucrada() == null && this.getInvolucrado() == null)
		{
			throw new ValidacionException(Constante.CODIGO_MENSAJE.VALIDAR_COMBOBOX, new Object[]{"Involucrado"});
		}
		if(this.estadoDato==null)
		{
			throw new ValidacionException(Constante.CODIGO_MENSAJE.VALIDAR_COMBOBOX, new Object[]{"Estado del dato"});
		}
		if(this.intervencion==null)
		{
			throw new ValidacionException(Constante.CODIGO_MENSAJE.VALIDAR_TEXTBOX, new Object[]{"Fecha de intervención"});
		}
		if(this.situacion==null)
		{
			throw new ValidacionException(Constante.CODIGO_MENSAJE.VALIDAR_COMBOBOX, new Object[]{"Situacion"});
		}
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DetExpedientePersona other = (DetExpedientePersona) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}