package pe.gob.mininter.dirandro.model;

import java.io.OutputStream;
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
import javax.persistence.Transient;

import pe.gob.mininter.dirandro.util.Validador;
import pe.gob.mininter.dirandro.util.beanbase.AuditoriaBean;


/**
 * The persistent class for the EXP_DOCUMENTO database table.
 * 
 */
@Entity
@Table(name="EXP_DOCUMENTO")
public class Documento extends AuditoriaBean implements Validador, Serializable {
	
	private static final long serialVersionUID = 7210926761891471965L;

	@Id
	@SequenceGenerator(name="EXP_DOCUMENTO_ID_GENERATOR", sequenceName="SEQ_DOCUMENTO", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="EXP_DOCUMENTO_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=16)
	private Long id;

	@Column(length=1000)
	private String asunto;

	@Column(name="DIAS_ATENCION", precision=4)
	private BigDecimal diasAtencion;

	@Column(name="ES_INICIAL", length=1)
	private String esInicial;

	@Column(name="FECHA_DOCUMENTO")
	@Temporal( TemporalType.TIMESTAMP)
	private Date fechaDocumento;

	@Column(name="FECHA_RECEPCION")
	@Temporal( TemporalType.TIMESTAMP)
	private Date fechaRecepcion;

	@Column(precision=4)
	private BigDecimal folios;

	@Column(name="NRO_DOCUMENTO", length=160)
	private String nroDocumento;
	
	@Column(name="CODIGO_ORIGEN", precision=16)
	private Long codigoOrigen;
	
	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="TABLA_ORIGEN")
	private Valor tablaOrigen;

	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="PRIORIDAD")
	private Valor prioridad;

	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="TIPO_DOCUMENTO")
	private Valor tipoDocumento;

	//bi-directional many-to-one association to Adjunto
	@ManyToOne
	@JoinColumn(name="ADJUNTO")
	private Adjunto adjunto;

	//bi-directional many-to-one association to Expediente
	@ManyToOne
	@JoinColumn(name="EXPEDIENTE")
	private Expediente expediente;
	
	@Transient
	private OutputStream osDocumento;
	
	@Transient
	private String filename;

	@Transient
	private boolean registrable;
	
	public Documento() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAsunto() {
		return asunto;
	}

	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}

	public BigDecimal getDiasAtencion() {
		return diasAtencion;
	}

	public void setDiasAtencion(BigDecimal diasAtencion) {
		this.diasAtencion = diasAtencion;
	}

	public String getEsInicial() {
		return esInicial;
	}

	public void setEsInicial(String esInicial) {
		this.esInicial = esInicial;
	}

	public Date getFechaDocumento() {
		return fechaDocumento;
	}

	public void setFechaDocumento(Date fechaDocumento) {
		this.fechaDocumento = fechaDocumento;
	}

	public Date getFechaRecepcion() {
		return fechaRecepcion;
	}

	public void setFechaRecepcion(Date fechaRecepcion) {
		this.fechaRecepcion = fechaRecepcion;
	}

	public BigDecimal getFolios() {
		return folios;
	}

	public void setFolios(BigDecimal folios) {
		this.folios = folios;
	}

	public String getNroDocumento() {
		return nroDocumento;
	}

	public void setNroDocumento(String nroDocumento) {
		this.nroDocumento = nroDocumento;
	}

	public Valor getPrioridad() {
		return prioridad;
	}

	public void setPrioridad(Valor cfgValor1) {
		this.prioridad = cfgValor1;
	}

	public Valor getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(Valor cfgValor2) {
		this.tipoDocumento = cfgValor2;
	}

	public Adjunto getAdjunto() {
		return adjunto;
	}

	public void setAdjunto(Adjunto expAdjunto) {
		this.adjunto = expAdjunto;
	}

	public Expediente getExpediente() {
		return expediente;
	}

	public void setExpediente(Expediente expExpediente) {
		this.expediente = expExpediente;
	}

	@Override
	public void validar() {
		// TODO Auto-generated method stub
		
	}

	public OutputStream getOsDocumento() {
		return osDocumento;
	}

	public void setOsDocumento(OutputStream osDocumento) {
		this.osDocumento = osDocumento;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public Long getCodigoOrigen() {
		return codigoOrigen;
	}

	public void setCodigoOrigen(Long codigoOrigen) {
		this.codigoOrigen = codigoOrigen;
	}

	public Valor getTablaOrigen() {
		return tablaOrigen;
	}

	public void setTablaOrigen(Valor tablaOrigen) {
		this.tablaOrigen = tablaOrigen;
	}

	/**
	 * indica si se debe registrar en la bd o se debe omitir
	 * @return
	 */
	public boolean isRegistrable() {
		return registrable;
	}

	public void setRegistrable(boolean registrable) {
		this.registrable = registrable;
	}
	
}