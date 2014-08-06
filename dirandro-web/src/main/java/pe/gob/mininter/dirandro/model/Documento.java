package pe.gob.mininter.dirandro.model;

import java.io.Serializable;

import javax.persistence.*;

import pe.gob.mininter.dirandro.util.Validador;
import pe.gob.mininter.dirandro.util.beanbase.AuditoriaBean;

import java.sql.Timestamp;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the EXP_DOCUMENTO database table.
 * 
 */
@Entity
@Table(name="EXP_DOCUMENTO")
public class Documento extends AuditoriaBean implements Validador, Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7210926761891471965L;

	@Id
	@SequenceGenerator(name="EXP_DOCUMENTO_ID_GENERATOR", sequenceName="SEQ_")
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
	private Timestamp fechaDocumento;

	@Column(name="FECHA_RECEPCION")
	private Timestamp fechaRecepcion;

	@Column(precision=4)
	private BigDecimal folios;

	@Column(name="NRO_DOCUMENTO", length=160)
	private String nroDocumento;

	//bi-directional many-to-one association to Anexo
	@OneToMany(mappedBy="expDocumento")
	private List<Anexo> expAnexos;

	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="PRIORIDAD")
	private Valor cfgValor1;

	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="TIPO_DOCUMENTO")
	private Valor cfgValor2;

	//bi-directional many-to-one association to Adjunto
	@ManyToOne
	@JoinColumn(name="ADJUNTO")
	private Adjunto expAdjunto;

	//bi-directional many-to-one association to Expediente
	@ManyToOne
	@JoinColumn(name="EXPEDIENTE")
	private Expediente expExpediente;

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

	public Timestamp getFechaDocumento() {
		return fechaDocumento;
	}

	public void setFechaDocumento(Timestamp fechaDocumento) {
		this.fechaDocumento = fechaDocumento;
	}

	public Timestamp getFechaRecepcion() {
		return fechaRecepcion;
	}

	public void setFechaRecepcion(Timestamp fechaRecepcion) {
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

	public List<Anexo> getExpAnexos() {
		return expAnexos;
	}

	public void setExpAnexos(List<Anexo> expAnexos) {
		this.expAnexos = expAnexos;
	}

	public Valor getCfgValor1() {
		return cfgValor1;
	}

	public void setCfgValor1(Valor cfgValor1) {
		this.cfgValor1 = cfgValor1;
	}

	public Valor getCfgValor2() {
		return cfgValor2;
	}

	public void setCfgValor2(Valor cfgValor2) {
		this.cfgValor2 = cfgValor2;
	}

	public Adjunto getExpAdjunto() {
		return expAdjunto;
	}

	public void setExpAdjunto(Adjunto expAdjunto) {
		this.expAdjunto = expAdjunto;
	}

	public Expediente getExpExpediente() {
		return expExpediente;
	}

	public void setExpExpediente(Expediente expExpediente) {
		this.expExpediente = expExpediente;
	}

	@Override
	public void validar() {
		// TODO Auto-generated method stub
		
	}

}