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
 * The persistent class for the EXP_ADJUNTO database table.
 * 
 */
@Entity
@Table(name="EXP_ADJUNTO")
public class Adjunto extends AuditoriaBean implements Validador, Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="EXP_ADJUNTO_ID_GENERATOR", sequenceName="SEQ_")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="EXP_ADJUNTO_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=16)
	private Long id;

	@Column(nullable=false, length=200)
	private String nombre;

	@Column(length=400)
	private String ruta;

	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="TIPO", nullable=false)
	private Valor cfgValor;

	//bi-directional many-to-one association to Expediente
	@ManyToOne
	@JoinColumn(name="EXPEDIENTE")
	private Expediente expExpediente;	

	//bi-directional many-to-one association to Anexo
	@OneToMany(mappedBy="expAdjunto")
	private List<Anexo> expAnexos;

	//bi-directional many-to-one association to Documento
	@OneToMany(mappedBy="expAdjunto")
	private List<Documento> expDocumentos;

	public Adjunto() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getRuta() {
		return this.ruta;
	}

	public void setRuta(String ruta) {
		this.ruta = ruta;
	}

	public Valor getCfgValor() {
		return this.cfgValor;
	}

	public void setCfgValor(Valor cfgValor) {
		this.cfgValor = cfgValor;
	}

	public Expediente getExpExpediente() {
		return this.expExpediente;
	}

	public void setExpExpediente(Expediente expExpediente) {
		this.expExpediente = expExpediente;
	}
	
	public List<Anexo> getExpAnexos() {
		return this.expAnexos;
	}

	public void setExpAnexos(List<Anexo> expAnexos) {
		this.expAnexos = expAnexos;
	}

	public Anexo addExpAnexo(Anexo expAnexo) {
		getExpAnexos().add(expAnexo);
		expAnexo.setExpAdjunto(this);

		return expAnexo;
	}

	public Anexo removeExpAnexo(Anexo expAnexo) {
		getExpAnexos().remove(expAnexo);
		expAnexo.setExpAdjunto(null);

		return expAnexo;
	}

	public List<Documento> getExpDocumentos() {
		return this.expDocumentos;
	}

	public void setExpDocumentos(List<Documento> expDocumentos) {
		this.expDocumentos = expDocumentos;
	}

	public Documento addExpDocumento(Documento expDocumento) {
		getExpDocumentos().add(expDocumento);
		expDocumento.setExpAdjunto(this);

		return expDocumento;
	}

	public Documento removeExpDocumento(Documento expDocumento) {
		getExpDocumentos().remove(expDocumento);
		expDocumento.setExpAdjunto(null);

		return expDocumento;
	}

	@Override
	public void validar() {
		// TODO Auto-generated method stub
		
	}

}