package pe.gob.mininter.dirandro.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the EXP_PREDECESOR database table.
 * 
 */
@Entity
@Table(name="EXP_PREDECESOR")
public class Predecesor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="EXP_PREDECESOR_ID_GENERATOR", sequenceName="SEQ_")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="EXP_PREDECESOR_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=16)
	private long id;

	@Column(nullable=false)
	private Timestamp creacion;

	private Timestamp edicion;

	//bi-directional many-to-one association to Dependencia
	@ManyToOne
	@JoinColumn(name="DEPENDENCIA")
	private Dependencia expDependencia1;

	//bi-directional many-to-one association to Dependencia
	@ManyToOne
	@JoinColumn(name="PREDECESOR")
	private Dependencia expDependencia2;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="CREADOR", nullable=false)
	private Usuario segUsuario1;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="EDITOR")
	private Usuario segUsuario2;

	public Predecesor() {
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

	public Dependencia getExpDependencia1() {
		return this.expDependencia1;
	}

	public void setExpDependencia1(Dependencia expDependencia1) {
		this.expDependencia1 = expDependencia1;
	}

	public Dependencia getExpDependencia2() {
		return this.expDependencia2;
	}

	public void setExpDependencia2(Dependencia expDependencia2) {
		this.expDependencia2 = expDependencia2;
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