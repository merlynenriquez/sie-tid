package pe.gob.mininter.dirandro.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the PER_PARENTEZCO database table.
 * 
 */
@Entity
@Table(name="PER_PARENTEZCO")
public class Parentezco implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="PER_PARENTEZCO_ID_GENERATOR", sequenceName="SEQ_")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PER_PARENTEZCO_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=16)
	private long id;

	@Column(nullable=false)
	private Timestamp creacion;

	private Timestamp edicion;

	@Column(length=400)
	private String observacion;

	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="TIPO_RELACION")
	private Valor cfgValor;

	//bi-directional many-to-one association to Persona
	@ManyToOne
	@JoinColumn(name="PERSONA")
	private Persona perPersona1;

	//bi-directional many-to-one association to Persona
	@ManyToOne
	@JoinColumn(name="PERSONA_PARIENTE")
	private Persona perPersona2;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="CREADOR", nullable=false)
	private Usuario segUsuario1;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="EDITOR")
	private Usuario segUsuario2;

	public Parentezco() {
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

	public String getObservacion() {
		return this.observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public Valor getCfgValor() {
		return this.cfgValor;
	}

	public void setCfgValor(Valor cfgValor) {
		this.cfgValor = cfgValor;
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