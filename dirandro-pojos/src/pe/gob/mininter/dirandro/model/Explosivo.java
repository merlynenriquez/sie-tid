package pe.gob.mininter.dirandro.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.math.BigDecimal;


/**
 * The persistent class for the EXP_EXPLOSIVOS database table.
 * 
 */
@Entity
@Table(name="EXP_EXPLOSIVOS")
public class Explosivo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="EXP_EXPLOSIVOS_ID_GENERATOR", sequenceName="SEQ_")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="EXP_EXPLOSIVOS_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=16)
	private long id;

	@Column(nullable=false)
	private Timestamp creacion;

	@Column(length=50)
	private String descripcion;

	private Timestamp edicion;

	@Column(precision=10, scale=4)
	private BigDecimal medida;

	@Column(length=100)
	private String observacion;

	@Column(length=50)
	private String serie;

	@Column(precision=16)
	private BigDecimal situacion;

	@Column(precision=10)
	private BigDecimal tipo;

	@Column(name="TIPO_DESCRIPCION", precision=10)
	private BigDecimal tipoDescripcion;

	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="TIPO_MEDIDA")
	private Valor cfgValor1;

	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="ESTADO")
	private Valor cfgValor2;

	//bi-directional many-to-one association to Expediente
	@ManyToOne
	@JoinColumn(name="EXPEDIENTE")
	private Expediente expExpediente;

	//bi-directional many-to-one association to ModeloMarca
	@ManyToOne
	@JoinColumn(name="MARCA")
	private ModeloMarca mntModeloMarca;

	//bi-directional many-to-one association to Empresa
	@ManyToOne
	@JoinColumn(name="EMPRESA_PROPIETARIA")
	private Empresa perEmpresa;

	//bi-directional many-to-one association to Persona
	@ManyToOne
	@JoinColumn(name="PERSONA", nullable=false)
	private Persona perPersona1;

	//bi-directional many-to-one association to Persona
	@ManyToOne
	@JoinColumn(name="PROPIETARIO")
	private Persona perPersona2;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="CREADOR", nullable=false)
	private Usuario segUsuario1;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="EDITOR")
	private Usuario segUsuario2;

	public Explosivo() {
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

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Timestamp getEdicion() {
		return this.edicion;
	}

	public void setEdicion(Timestamp edicion) {
		this.edicion = edicion;
	}

	public BigDecimal getMedida() {
		return this.medida;
	}

	public void setMedida(BigDecimal medida) {
		this.medida = medida;
	}

	public String getObservacion() {
		return this.observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public String getSerie() {
		return this.serie;
	}

	public void setSerie(String serie) {
		this.serie = serie;
	}

	public BigDecimal getSituacion() {
		return this.situacion;
	}

	public void setSituacion(BigDecimal situacion) {
		this.situacion = situacion;
	}

	public BigDecimal getTipo() {
		return this.tipo;
	}

	public void setTipo(BigDecimal tipo) {
		this.tipo = tipo;
	}

	public BigDecimal getTipoDescripcion() {
		return this.tipoDescripcion;
	}

	public void setTipoDescripcion(BigDecimal tipoDescripcion) {
		this.tipoDescripcion = tipoDescripcion;
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

	public Expediente getExpExpediente() {
		return this.expExpediente;
	}

	public void setExpExpediente(Expediente expExpediente) {
		this.expExpediente = expExpediente;
	}

	public ModeloMarca getMntModeloMarca() {
		return this.mntModeloMarca;
	}

	public void setMntModeloMarca(ModeloMarca mntModeloMarca) {
		this.mntModeloMarca = mntModeloMarca;
	}

	public Empresa getPerEmpresa() {
		return this.perEmpresa;
	}

	public void setPerEmpresa(Empresa perEmpresa) {
		this.perEmpresa = perEmpresa;
	}

	public Persona getPerPersona1() {
		return this.perPersona1;
	}

	public void setPerPersona1(Persona perPersona1) {
		this.perPersona1 = perPersona1;
	}

	public Persona getPerPersona2() {
		return this.perPersona2;
	}

	public void setPerPersona2(Persona perPersona2) {
		this.perPersona2 = perPersona2;
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