package pe.gob.mininter.dirandro.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
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
	@SequenceGenerator(name="PER_SITUACION_PROCESO_ID_GENERATOR", sequenceName="SEQ_PER_SITUACION_PROCESO", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PER_SITUACION_PROCESO_ID_GENERATOR")
	private Long id;

	//bi-directional many-to-one association to DetExpedientePersona
	@ManyToOne
	@JoinColumn(name="PROCESADO")
	private DetExpedientePersona procesado;
	
	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="TIPO_RESOLUCION")
	private Valor tipoResolucion;
	
	@Column(name="NRO_RESOLUCION")
	private String nroResolucion;
	
	@Column(name="FECHA_RESOLUCION")
	private Date fechaResolucion;

	@Column(name="NRO_EXPEDIENTE")
	private String nroExpediente;

	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="TIPO_PENA")
	private Valor tipoPena;

	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="TIPO_DELITO")
	private Valor tipoDelito;

	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="TIPO_SENTENCIA")
	private Valor tipoSentencia;

	@Column(name="FECHA_SENTENCIA")
	private Date fechaSentencia;

	@Column(name="SENTENCIA_INICIO")
	private Date sentenciaInicio;

	@Column(name="SENTENCIA_TERMINO")
	private Date sentenciaTermino;

	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="CODIGO_PROCESAL")
	private Valor codigoProcesal;

	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="TIPO_REPARACION_CIVIL")
	private Valor tipoReparacionCivil;

	@Column(name="IMPORTE_REPARACION_CIVIL", precision=16, scale=2)
	private BigDecimal importeReparacionCivil;

	@Column(name="IMPORTE_REPARACION_SOLIDARIO", precision=16, scale=2)
	private BigDecimal importeReparacionSolidario;

	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="TIPO_INHABITACION")
	private Valor tipoInhabitacion;

	@Column(name="NRO_ANO_INHABITADO", precision=16)
	private BigDecimal nroAnoInhabitado;

	@Column(name="NRO_MES_INHABITADO", precision=16)
	private BigDecimal nroMesInhabitado;

	@Column(name="NRO_DIA_INHABITADO", precision=16)
	private BigDecimal nroDiaInhabitado;

	@Column(name="NRO_DIA_MULTA", precision=16)
	private BigDecimal nroDiaMulta;
	
	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="ESTABLECIMIENTO_PENITENCIARIO")
	private Valor establecimientoPenitenciario;

	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="TIPO_CONDICION_PENA")
	private Valor tipoCondicionPena;

	@Column(name="NRO_ANO_PENA", precision=16)
	private BigDecimal nroAnoPena;
	
	@Column(name="NRO_MES_PENA", precision=16)
	private BigDecimal nroMesPena;
	
	@Column(name="NRO_DIA_PENA", precision=16)
	private BigDecimal nroDiaPena;

	public SituacionProceso() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public DetExpedientePersona getProcesado() {
		return procesado;
	}

	public void setProcesado(DetExpedientePersona procesado) {
		this.procesado = procesado;
	}

	public Valor getTipoResolucion() {
		return tipoResolucion;
	}

	public void setTipoResolucion(Valor tipoResolucion) {
		this.tipoResolucion = tipoResolucion;
	}

	public String getNroResolucion() {
		return nroResolucion;
	}

	public void setNroResolucion(String nroResolucion) {
		this.nroResolucion = nroResolucion;
	}

	public Date getFechaResolucion() {
		return fechaResolucion;
	}

	public void setFechaResolucion(Date fechaResolucion) {
		this.fechaResolucion = fechaResolucion;
	}

	public String getNroExpediente() {
		return nroExpediente;
	}

	public void setNroExpediente(String nroExpediente) {
		this.nroExpediente = nroExpediente;
	}

	public Valor getTipoPena() {
		return tipoPena;
	}

	public void setTipoPena(Valor tipoPena) {
		this.tipoPena = tipoPena;
	}

	public Valor getTipoDelito() {
		return tipoDelito;
	}

	public void setTipoDelito(Valor tipoDelito) {
		this.tipoDelito = tipoDelito;
	}

	public Valor getTipoSentencia() {
		return tipoSentencia;
	}

	public void setTipoSentencia(Valor tipoSentencia) {
		this.tipoSentencia = tipoSentencia;
	}

	public Date getFechaSentencia() {
		return fechaSentencia;
	}

	public void setFechaSentencia(Date fechaSentencia) {
		this.fechaSentencia = fechaSentencia;
	}

	public Date getSentenciaInicio() {
		return sentenciaInicio;
	}

	public void setSentenciaInicio(Date sentenciaInicio) {
		this.sentenciaInicio = sentenciaInicio;
	}

	public Date getSentenciaTermino() {
		return sentenciaTermino;
	}

	public void setSentenciaTermino(Date sentenciaTermino) {
		this.sentenciaTermino = sentenciaTermino;
	}

	public Valor getCodigoProcesal() {
		return codigoProcesal;
	}

	public void setCodigoProcesal(Valor codigoProcesal) {
		this.codigoProcesal = codigoProcesal;
	}

	public Valor getTipoReparacionCivil() {
		return tipoReparacionCivil;
	}

	public void setTipoReparacionCivil(Valor tipoReparacionCivil) {
		this.tipoReparacionCivil = tipoReparacionCivil;
	}

	public BigDecimal getImporteReparacionCivil() {
		return importeReparacionCivil;
	}

	public void setImporteReparacionCivil(BigDecimal importeReparacionCivil) {
		this.importeReparacionCivil = importeReparacionCivil;
	}

	public BigDecimal getImporteReparacionSolidario() {
		return importeReparacionSolidario;
	}

	public void setImporteReparacionSolidario(BigDecimal importeReparacionSolidario) {
		this.importeReparacionSolidario = importeReparacionSolidario;
	}

	public Valor getTipoInhabitacion() {
		return tipoInhabitacion;
	}

	public void setTipoInhabitacion(Valor tipoInhabitacion) {
		this.tipoInhabitacion = tipoInhabitacion;
	}

	public BigDecimal getNroAnoInhabitado() {
		return nroAnoInhabitado;
	}

	public void setNroAnoInhabitado(BigDecimal nroAnoInhabitado) {
		this.nroAnoInhabitado = nroAnoInhabitado;
	}

	public BigDecimal getNroMesInhabitado() {
		return nroMesInhabitado;
	}

	public void setNroMesInhabitado(BigDecimal nroMesInhabitado) {
		this.nroMesInhabitado = nroMesInhabitado;
	}

	public BigDecimal getNroDiaInhabitado() {
		return nroDiaInhabitado;
	}

	public void setNroDiaInhabitado(BigDecimal nroDiaInhabitado) {
		this.nroDiaInhabitado = nroDiaInhabitado;
	}

	public BigDecimal getNroDiaMulta() {
		return nroDiaMulta;
	}

	public void setNroDiaMulta(BigDecimal nroDiaMulta) {
		this.nroDiaMulta = nroDiaMulta;
	}

	public Valor getEstablecimientoPenitenciario() {
		return establecimientoPenitenciario;
	}

	public void setEstablecimientoPenitenciario(Valor establecimientoPenitenciario) {
		this.establecimientoPenitenciario = establecimientoPenitenciario;
	}

	public Valor getTipoCondicionPena() {
		return tipoCondicionPena;
	}

	public void setTipoCondicionPena(Valor tipoCondicionPena) {
		this.tipoCondicionPena = tipoCondicionPena;
	}

	public BigDecimal getNroAnoPena() {
		return nroAnoPena;
	}

	public void setNroAnoPena(BigDecimal nroAnoPena) {
		this.nroAnoPena = nroAnoPena;
	}

	public BigDecimal getNroMesPena() {
		return nroMesPena;
	}

	public void setNroMesPena(BigDecimal nroMesPena) {
		this.nroMesPena = nroMesPena;
	}

	public BigDecimal getNroDiaPena() {
		return nroDiaPena;
	}

	public void setNroDiaPena(BigDecimal nroDiaPena) {
		this.nroDiaPena = nroDiaPena;
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