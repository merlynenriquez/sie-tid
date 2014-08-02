package pe.gob.mininter.dirandro.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the EXP_TIPO_HECHO database table.
 * 
 */
@Entity
@Table(name="EXP_TIPO_HECHO")
public class TipoHecho implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="EXP_TIPO_HECHO_ID_GENERATOR", sequenceName="SEQ_")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="EXP_TIPO_HECHO_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=16)
	private long id;

	@Column(nullable=false)
	private Timestamp creacion;

	private Timestamp edicion;

	@Column(precision=16)
	private BigDecimal estado;

	@Column(nullable=false, length=400)
	private String nombre;

	//bi-directional many-to-one association to Expediente
	@OneToMany(mappedBy="expTipoHecho")
	private List<Expediente> expExpedientes;

	//bi-directional many-to-one association to TipoHecho
	@ManyToOne
	@JoinColumn(name="PADRE")
	private TipoHecho expTipoHecho;

	//bi-directional many-to-one association to TipoHecho
	@OneToMany(mappedBy="expTipoHecho")
	private List<TipoHecho> expTipoHechos;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="CREADOR", nullable=false)
	private Usuario segUsuario1;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="EDITOR")
	private Usuario segUsuario2;

	public TipoHecho() {
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

	public BigDecimal getEstado() {
		return this.estado;
	}

	public void setEstado(BigDecimal estado) {
		this.estado = estado;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Expediente> getExpExpedientes() {
		return this.expExpedientes;
	}

	public void setExpExpedientes(List<Expediente> expExpedientes) {
		this.expExpedientes = expExpedientes;
	}

	public Expediente addExpExpediente(Expediente expExpediente) {
		getExpExpedientes().add(expExpediente);
		expExpediente.setExpTipoHecho(this);

		return expExpediente;
	}

	public Expediente removeExpExpediente(Expediente expExpediente) {
		getExpExpedientes().remove(expExpediente);
		expExpediente.setExpTipoHecho(null);

		return expExpediente;
	}

	public TipoHecho getExpTipoHecho() {
		return this.expTipoHecho;
	}

	public void setExpTipoHecho(TipoHecho expTipoHecho) {
		this.expTipoHecho = expTipoHecho;
	}

	public List<TipoHecho> getExpTipoHechos() {
		return this.expTipoHechos;
	}

	public void setExpTipoHechos(List<TipoHecho> expTipoHechos) {
		this.expTipoHechos = expTipoHechos;
	}

	public TipoHecho addExpTipoHecho(TipoHecho expTipoHecho) {
		getExpTipoHechos().add(expTipoHecho);
		expTipoHecho.setExpTipoHecho(this);

		return expTipoHecho;
	}

	public TipoHecho removeExpTipoHecho(TipoHecho expTipoHecho) {
		getExpTipoHechos().remove(expTipoHecho);
		expTipoHecho.setExpTipoHecho(null);

		return expTipoHecho;
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