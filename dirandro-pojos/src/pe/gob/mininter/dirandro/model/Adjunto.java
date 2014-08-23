package pe.gob.mininter.dirandro.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the EXP_ADJUNTO database table.
 * 
 */
@Entity
@Table(name="EXP_ADJUNTO")
public class Adjunto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="EXP_ADJUNTO_ID_GENERATOR", sequenceName="SEQ_")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="EXP_ADJUNTO_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=16)
	private long id;

	@Column(nullable=false)
	private Timestamp creacion;

	private Timestamp edicion;

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

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="CREADOR", nullable=false)
	private Usuario segUsuario1;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="EDITOR")
	private Usuario segUsuario2;

	//bi-directional many-to-one association to Anexo
	@OneToMany(mappedBy="expAdjunto")
	private List<Anexo> expAnexos;

	//bi-directional many-to-one association to Documento
	@OneToMany(mappedBy="expAdjunto")
	private List<Documento> expDocumentos;

	//bi-directional many-to-one association to Imagen
	@OneToMany(mappedBy="expAdjunto")
	private List<Imagen> perImagens;

	public Adjunto() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Timestamp getCreacion() {
		return this.creacion;
	}

	public void setCreacion(Timestamp creacion) {
		this.creacion = creacion;
	}

	public Timestamp getEdicion() {
		return this.edicion;
	}

	public void setEdicion(Timestamp edicion) {
		this.edicion = edicion;
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

	public List<Imagen> getPerImagens() {
		return this.perImagens;
	}

	public void setPerImagens(List<Imagen> perImagens) {
		this.perImagens = perImagens;
	}

	public Imagen addPerImagen(Imagen perImagen) {
		getPerImagens().add(perImagen);
		perImagen.setExpAdjunto(this);

		return perImagen;
	}

	public Imagen removePerImagen(Imagen perImagen) {
		getPerImagens().remove(perImagen);
		perImagen.setExpAdjunto(null);

		return perImagen;
	}

}