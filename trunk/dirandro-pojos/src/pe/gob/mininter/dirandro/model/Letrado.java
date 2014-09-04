package pe.gob.mininter.dirandro.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the PER_LETRADO database table.
 * 
 */
@Entity
@Table(name="PER_LETRADO")
public class Letrado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="PER_LETRADO_ID_GENERATOR", sequenceName="SEQ_")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PER_LETRADO_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=16)
	private long id;

	@Column(nullable=false)
	private Timestamp creacion;

	private Timestamp edicion;

	@Column(name="NRO_COLEGIATURA", length=20)
	private String nroColegiatura;

	//bi-directional many-to-one association to AbogadoPersona
	@OneToMany(mappedBy="perLetrado")
	private List<AbogadoPersona> expAbogadoPersonas;

	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="TIPO")
	private Valor cfgValor;

	//bi-directional many-to-one association to Persona
	@ManyToOne
	@JoinColumn(name="PERSONA")
	private Persona perPersona;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="CREADOR", nullable=false)
	private Usuario segUsuario1;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="EDITOR")
	private Usuario segUsuario2;

	public Letrado() {
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

	public String getNroColegiatura() {
		return this.nroColegiatura;
	}

	public void setNroColegiatura(String nroColegiatura) {
		this.nroColegiatura = nroColegiatura;
	}

	public List<AbogadoPersona> getExpAbogadoPersonas() {
		return this.expAbogadoPersonas;
	}

	public void setExpAbogadoPersonas(List<AbogadoPersona> expAbogadoPersonas) {
		this.expAbogadoPersonas = expAbogadoPersonas;
	}

	public AbogadoPersona addExpAbogadoPersona(AbogadoPersona expAbogadoPersona) {
		getExpAbogadoPersonas().add(expAbogadoPersona);
		expAbogadoPersona.setPerLetrado(this);

		return expAbogadoPersona;
	}

	public AbogadoPersona removeExpAbogadoPersona(AbogadoPersona expAbogadoPersona) {
		getExpAbogadoPersonas().remove(expAbogadoPersona);
		expAbogadoPersona.setPerLetrado(null);

		return expAbogadoPersona;
	}

	public Valor getCfgValor() {
		return this.cfgValor;
	}

	public void setCfgValor(Valor cfgValor) {
		this.cfgValor = cfgValor;
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