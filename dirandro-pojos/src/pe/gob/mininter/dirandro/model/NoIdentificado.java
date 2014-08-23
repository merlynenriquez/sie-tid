package pe.gob.mininter.dirandro.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the PER_NO_IDENTIFICADOS database table.
 * 
 */
@Entity
@Table(name="PER_NO_IDENTIFICADOS")
public class NoIdentificado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="PER_NO_IDENTIFICADOS_ID_GENERATOR", sequenceName="SEQ_")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PER_NO_IDENTIFICADOS_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=16)
	private long id;

	@Column(name="\"ALIAS\"", length=200)
	private String alias;

	@Column(length=200)
	private String apellidos;

	@Column(nullable=false)
	private Timestamp creacion;

	@Column(name="EDAD_APROX", precision=22)
	private BigDecimal edadAprox;

	private Timestamp edicion;

	@Column(length=200)
	private String nombres;

	//bi-directional many-to-one association to Detalle
	@OneToMany(mappedBy="perNoIdentificado")
	private List<Detalle> perDetalles;

	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="ORIENT_SEXUAL")
	private Valor cfgValor;

	//bi-directional many-to-one association to Expediente
	@ManyToOne
	@JoinColumn(name="EXPEDIENTE")
	private Expediente expExpediente;

	//bi-directional many-to-one association to Persona
	@ManyToOne
	@JoinColumn(name="PERSONA")
	private Persona perPersona;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="EDITOR")
	private Usuario segUsuario1;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="CREADOR", nullable=false)
	private Usuario segUsuario2;

	public NoIdentificado() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAlias() {
		return this.alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public String getApellidos() {
		return this.apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public Timestamp getCreacion() {
		return this.creacion;
	}

	public void setCreacion(Timestamp creacion) {
		this.creacion = creacion;
	}

	public BigDecimal getEdadAprox() {
		return this.edadAprox;
	}

	public void setEdadAprox(BigDecimal edadAprox) {
		this.edadAprox = edadAprox;
	}

	public Timestamp getEdicion() {
		return this.edicion;
	}

	public void setEdicion(Timestamp edicion) {
		this.edicion = edicion;
	}

	public String getNombres() {
		return this.nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public List<Detalle> getPerDetalles() {
		return this.perDetalles;
	}

	public void setPerDetalles(List<Detalle> perDetalles) {
		this.perDetalles = perDetalles;
	}

	public Detalle addPerDetalle(Detalle perDetalle) {
		getPerDetalles().add(perDetalle);
		perDetalle.setPerNoIdentificado(this);

		return perDetalle;
	}

	public Detalle removePerDetalle(Detalle perDetalle) {
		getPerDetalles().remove(perDetalle);
		perDetalle.setPerNoIdentificado(null);

		return perDetalle;
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

	public Persona getPerPersona() {
		return this.perPersona;
	}

	public void setPerPersona(Persona perPersona) {
		this.perPersona = perPersona;
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