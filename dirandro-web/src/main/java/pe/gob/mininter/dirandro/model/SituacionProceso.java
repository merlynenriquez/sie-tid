package pe.gob.mininter.dirandro.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import pe.gob.mininter.dirandro.util.beanbase.AuditoriaBean;


/**
 * The persistent class for the PER_SITUACION_PROCESO database table.
 * 
 */
@Entity
@Table(name="PER_SITUACION_PROCESO")
public class SituacionProceso extends AuditoriaBean implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="PER_SITUACION_PROCESO_ID_GENERATOR", sequenceName="SEQ_PER_SITUACION_PROCESO")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PER_SITUACION_PROCESO_ID_GENERATOR")
	private Long id;

	@Column(name="FECHA_RESOLUCION")
	private Timestamp fechaResolucion;

	@Column(name="FECHA_SENTENCIA")
	private Timestamp fechaSentencia;

	@Column(name="NRO_EXPEDIENTE")
	private String nroExpediente;

	@Column(name="NRO_RESOLUCION")
	private String nroResolucion;

	@Column(name="SENTENCIA_INICIO")
	private Timestamp sentenciaInicio;

	@Column(name="SENTENCIA_TERMINO")
	private Timestamp sentenciaTermino;

	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="TIPO_REPACION")
	private Valor tipoReparacion;

	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="TIPO_PENA")
	private Valor tipoPena;

	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="TIPO_RESOLUCION")
	private Valor tipoResolucion;

	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="TIPO_SENTENCIA")
	private Valor tipoSentencia;

	//bi-directional many-to-one association to DetExpedientePersona
	@ManyToOne
	@JoinColumn(name="PROCESADO")
	private DetExpedientePersona procesado;

	public SituacionProceso() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Timestamp getFechaResolucion() {
		return fechaResolucion;
	}

	public void setFechaResolucion(Timestamp fechaResolucion) {
		this.fechaResolucion = fechaResolucion;
	}

	public Timestamp getFechaSentencia() {
		return fechaSentencia;
	}

	public void setFechaSentencia(Timestamp fechaSentencia) {
		this.fechaSentencia = fechaSentencia;
	}

	public String getNroExpediente() {
		return nroExpediente;
	}

	public void setNroExpediente(String nroExpediente) {
		this.nroExpediente = nroExpediente;
	}

	public String getNroResolucion() {
		return nroResolucion;
	}

	public void setNroResolucion(String nroResolucion) {
		this.nroResolucion = nroResolucion;
	}

	public Timestamp getSentenciaInicio() {
		return sentenciaInicio;
	}

	public void setSentenciaInicio(Timestamp sentenciaInicio) {
		this.sentenciaInicio = sentenciaInicio;
	}

	public Timestamp getSentenciaTermino() {
		return sentenciaTermino;
	}

	public void setSentenciaTermino(Timestamp sentenciaTermino) {
		this.sentenciaTermino = sentenciaTermino;
	}

	public Valor getTipoReparacion() {
		return tipoReparacion;
	}

	public void setTipoReparacion(Valor tipoReparacion) {
		this.tipoReparacion = tipoReparacion;
	}

	public Valor getTipoPena() {
		return tipoPena;
	}

	public void setTipoPena(Valor tipoPena) {
		this.tipoPena = tipoPena;
	}

	public Valor getTipoResolucion() {
		return tipoResolucion;
	}

	public void setTipoResolucion(Valor tipoResolucion) {
		this.tipoResolucion = tipoResolucion;
	}

	public Valor getTipoSentencia() {
		return tipoSentencia;
	}

	public void setTipoSentencia(Valor tipoSentencia) {
		this.tipoSentencia = tipoSentencia;
	}

	public DetExpedientePersona getProcesado() {
		return procesado;
	}

	public void setProcesado(DetExpedientePersona procesado) {
		this.procesado = procesado;
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
		SituacionProceso other = (SituacionProceso) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}