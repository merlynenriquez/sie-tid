package pe.gob.mininter.dirandro.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.math.BigDecimal;


/**
 * The persistent class for the EXP_SITUACION_GENERAL database table.
 * 
 */
@Entity
@Table(name="EXP_SITUACION_GENERAL")
public class SituacionGeneral implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="EXP_SITUACION_GENERAL_ID_GENERATOR", sequenceName="SEQ_")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="EXP_SITUACION_GENERAL_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=16)
	private long id;

	@Column(nullable=false)
	private Timestamp creacion;

	private Timestamp edicion;

	private Timestamp fecha;

	@Column(name="ID_REGISTRO", precision=16)
	private BigDecimal idRegistro;

	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="TABLA")
	private Valor cfgValor1;

	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="SITUACION")
	private Valor cfgValor2;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="EDITOR")
	private Usuario segUsuario1;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="CREADOR", nullable=false)
	private Usuario segUsuario2;

	public SituacionGeneral() {
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

	public Timestamp getFecha() {
		return this.fecha;
	}

	public void setFecha(Timestamp fecha) {
		this.fecha = fecha;
	}

	public BigDecimal getIdRegistro() {
		return this.idRegistro;
	}

	public void setIdRegistro(BigDecimal idRegistro) {
		this.idRegistro = idRegistro;
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