package pe.gob.mininter.dirandro.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import pe.gob.mininter.dirandro.exception.ValidacionException;
import pe.gob.mininter.dirandro.util.Constante;
import pe.gob.mininter.dirandro.util.Validador;
import pe.gob.mininter.dirandro.util.beanbase.AuditoriaBean;


/**
 * The persistent class for the EXP_DET_PER_TEL_EXP database table.
 * 
 */
@Entity
@Table(name="EXP_DET_PER_TEL_EXP")
public class DetPerTelExp extends AuditoriaBean implements Validador, Serializable {
	
	private static final long serialVersionUID = -2597824744398259948L;

	@Id
	@SequenceGenerator(name="EXP_DET_PER_TEL_EXP_ID_GENERATOR", sequenceName="SEQ_EXP_TELEFONO", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="EXP_DET_PER_TEL_EXP_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=16)
	private Long id;

	@Column(length=500)
	private String observacion;
	
	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="OPERADORA")
	private Valor operadora;

	//bi-directional many-to-one association to DetExpedientePersona
	@ManyToOne
	@JoinColumn(name="IMPLICADO")
	private DetExpedientePersona implicado;
	
	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="ESTADO")
	private Valor estado;

	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="SITUACION")
	private Valor situacion;

	//bi-directional many-to-one association to Expediente
	@ManyToOne
	@JoinColumn(name="EXPEDIENTE", nullable=false)
	private Expediente expediente;

	//bi-directional many-to-one association to Persona
	@ManyToOne
	@JoinColumn(name="DUENO")
	private Persona propietario;

	//bi-directional many-to-one association to Telefono
	@ManyToOne
	@JoinColumn(name="TELEFONO")
	private Telefono equipo;
	
	//bi-directional many-to-one association to ExpNumero
	@ManyToOne
	@JoinColumn(name="NUMERO")
	private Numero numeroTelefonico;

	public DetPerTelExp() {
	}
	
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Valor getOperadora() {
		return operadora;
	}

	public void setOperadora(Valor operadora) {
		this.operadora = operadora;
	}

	public DetExpedientePersona getImplicado() {
		return implicado;
	}

	public void setImplicado(DetExpedientePersona implicado) {
		this.implicado = implicado;
	}

	public Valor getEstado() {
		return estado;
	}

	public void setEstado(Valor estado) {
		this.estado = estado;
	}

	public Valor getSituacion() {
		return situacion;
	}

	public void setSituacion(Valor situacion) {
		this.situacion = situacion;
	}

	public Expediente getExpediente() {
		return expediente;
	}

	public void setExpediente(Expediente expediente) {
		this.expediente = expediente;
	}

	public Persona getPropietario() {
		return propietario;
	}

	public void setPropietario(Persona propietario) {
		this.propietario = propietario;
	}

	public Telefono getEquipo() {
		return equipo;
	}

	public void setEquipo(Telefono equipo) {
		this.equipo = equipo;
	}

	public Numero getNumeroTelefonico() {
		return numeroTelefonico;
	}

	public void setNumeroTelefonico(Numero numeroTelefonico) {
		this.numeroTelefonico = numeroTelefonico;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	@Override
	public void validar() {
		if(expediente == null){
			throw new ValidacionException(Constante.CODIGO_MENSAJE.VALIDAR_COMBOBOX, new Object[]{"Expediente"});
		}
		if(this.numeroTelefonico == null){
			throw new ValidacionException(Constante.CODIGO_MENSAJE.VALIDAR_COMBOBOX, new Object[]{"Número Telefónico"});
		}
		if(estado == null){
			throw new ValidacionException(Constante.CODIGO_MENSAJE.VALIDAR_COMBOBOX, new Object[]{"Estado"});
		}
		if(situacion== null){
			throw new ValidacionException(Constante.CODIGO_MENSAJE.VALIDAR_COMBOBOX, new Object[]{"Situacion"});
		}
		
	}

	public boolean esNuevo(){
		return id == null || id.longValue() == 0;
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
		DetPerTelExp other = (DetPerTelExp) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}