package pe.gob.mininter.dirandro.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the EXP_DOCUMENTO database table.
 * 
 */
@Entity
@Table(name="EXP_DOCUMENTO")
public class Documento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="EXP_DOCUMENTO_ID_GENERATOR", sequenceName="SEQ_")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="EXP_DOCUMENTO_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=16)
	private long id;

	@Column(length=1000)
	private String asunto;

	@Column(nullable=false)
	private Timestamp creacion;

	@Column(name="DIAS_ATENCION", precision=4)
	private BigDecimal diasAtencion;

	private Timestamp edicion;

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

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="EDITOR")
	private Usuario segUsuario1;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="CREADOR", nullable=false)
	private Usuario segUsuario2;

	public Documento() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAsunto() {
		return this.asunto;
	}

	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}

	public Timestamp getCreacion() {
		return this.creacion;
	}

	public void setCreacion(Timestamp creacion) {
		this.creacion = creacion;
	}

	public BigDecimal getDiasAtencion() {
		return this.diasAtencion;
	}

	public void setDiasAtencion(BigDecimal diasAtencion) {
		this.diasAtencion = diasAtencion;
	}

	public Timestamp getEdicion() {
		return this.edicion;
	}

	public void setEdicion(Timestamp edicion) {
		this.edicion = edicion;
	}

	public String getEsInicial() {
		return this.esInicial;
	}

	public void setEsInicial(String esInicial) {
		this.esInicial = esInicial;
	}

	public Timestamp getFechaDocumento() {
		return this.fechaDocumento;
	}

	public void setFechaDocumento(Timestamp fechaDocumento) {
		this.fechaDocumento = fechaDocumento;
	}

	public Timestamp getFechaRecepcion() {
		return this.fechaRecepcion;
	}

	public void setFechaRecepcion(Timestamp fechaRecepcion) {
		this.fechaRecepcion = fechaRecepcion;
	}

	public BigDecimal getFolios() {
		return this.folios;
	}

	public void setFolios(BigDecimal folios) {
		this.folios = folios;
	}

	public String getNroDocumento() {
		return this.nroDocumento;
	}

	public void setNroDocumento(String nroDocumento) {
		this.nroDocumento = nroDocumento;
	}

	public List<Anexo> getExpAnexos() {
		return this.expAnexos;
	}

	public void setExpAnexos(List<Anexo> expAnexos) {
		this.expAnexos = expAnexos;
	}

	public Anexo addExpAnexo(Anexo expAnexo) {
		getExpAnexos().add(expAnexo);
		expAnexo.setExpDocumento(this);

		return expAnexo;
	}

	public Anexo removeExpAnexo(Anexo expAnexo) {
		getExpAnexos().remove(expAnexo);
		expAnexo.setExpDocumento(null);

		return expAnexo;
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

	public Adjunto getExpAdjunto() {
		return this.expAdjunto;
	}

	public void setExpAdjunto(Adjunto expAdjunto) {
		this.expAdjunto = expAdjunto;
	}

	public Expediente getExpExpediente() {
		return this.expExpediente;
	}

	public void setExpExpediente(Expediente expExpediente) {
		this.expExpediente = expExpediente;
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

}