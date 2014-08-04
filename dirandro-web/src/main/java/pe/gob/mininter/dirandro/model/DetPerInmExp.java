package pe.gob.mininter.dirandro.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.math.BigDecimal;


/**
 * The persistent class for the EXP_DET_PER_INM_EXP database table.
 * 
 */
@Entity
@Table(name="EXP_DET_PER_INM_EXP")
public class DetPerInmExp implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="EXP_DET_PER_INM_EXP_ID_GENERATOR", sequenceName="SEQ_")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="EXP_DET_PER_INM_EXP_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=16)
	private long id;

	@Column(nullable=false)
	private Timestamp creacion;

	private Timestamp edicion;

	@Column(name="NUMERO_PISOS", precision=10)
	private BigDecimal numeroPisos;

	@Column(precision=16)
	private BigDecimal propietario;

	@Column(precision=16)
	private BigDecimal situacion;

	@Column(name="TIPO_USO", length=400)
	private String tipoUso;

	//bi-directional many-to-one association to Expediente
	@ManyToOne
	@JoinColumn(name="EXPEDIENTE", nullable=false)
	private Expediente expExpediente;

	//bi-directional many-to-one association to Inmueble
	@ManyToOne
	@JoinColumn(name="INMUEBLE")
	private Inmueble expInmueble;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="CREADOR", nullable=false)
	private Usuario segUsuario1;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="EDITOR")
	private Usuario segUsuario2;

	public DetPerInmExp() {
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

	public BigDecimal getNumeroPisos() {
		return this.numeroPisos;
	}

	public void setNumeroPisos(BigDecimal numeroPisos) {
		this.numeroPisos = numeroPisos;
	}

	public BigDecimal getPropietario() {
		return this.propietario;
	}

	public void setPropietario(BigDecimal propietario) {
		this.propietario = propietario;
	}

	public BigDecimal getSituacion() {
		return this.situacion;
	}

	public void setSituacion(BigDecimal situacion) {
		this.situacion = situacion;
	}

	public String getTipoUso() {
		return this.tipoUso;
	}

	public void setTipoUso(String tipoUso) {
		this.tipoUso = tipoUso;
	}

	public Expediente getExpExpediente() {
		return this.expExpediente;
	}

	public void setExpExpediente(Expediente expExpediente) {
		this.expExpediente = expExpediente;
	}

	public Inmueble getExpInmueble() {
		return this.expInmueble;
	}

	public void setExpInmueble(Inmueble expInmueble) {
		this.expInmueble = expInmueble;
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