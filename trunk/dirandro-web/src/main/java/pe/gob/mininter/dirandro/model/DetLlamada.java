package pe.gob.mininter.dirandro.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.math.BigDecimal;


/**
 * The persistent class for the EXP_DET_LLAMADAS database table.
 * 
 */
@Entity
@Table(name="EXP_DET_LLAMADAS")
public class DetLlamada implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="EXP_DET_LLAMADAS_ID_GENERATOR", sequenceName="SEQ_")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="EXP_DET_LLAMADAS_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=16)
	private long id;

	@Column(nullable=false)
	private Timestamp creacion;

	@Column(precision=10)
	private BigDecimal duracion;

	private Timestamp edicion;

	@Column(name="FECHA_HORA")
	private Timestamp fechaHora;

	@Column(name="NUMERO_MARCADO", length=50)
	private String numeroMarcado;

	//bi-directional many-to-one association to DetPerTelExp
	@ManyToOne
	@JoinColumn(name="EXP_PER_TEL")
	private DetPerTelExp expDetPerTelExp;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="CREADOR", nullable=false)
	private Usuario segUsuario1;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="EDITOR")
	private Usuario segUsuario2;

	public DetLlamada() {
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

	public BigDecimal getDuracion() {
		return this.duracion;
	}

	public void setDuracion(BigDecimal duracion) {
		this.duracion = duracion;
	}

	public Timestamp getEdicion() {
		return this.edicion;
	}

	public void setEdicion(Timestamp edicion) {
		this.edicion = edicion;
	}

	public Timestamp getFechaHora() {
		return this.fechaHora;
	}

	public void setFechaHora(Timestamp fechaHora) {
		this.fechaHora = fechaHora;
	}

	public String getNumeroMarcado() {
		return this.numeroMarcado;
	}

	public void setNumeroMarcado(String numeroMarcado) {
		this.numeroMarcado = numeroMarcado;
	}

	public DetPerTelExp getExpDetPerTelExp() {
		return this.expDetPerTelExp;
	}

	public void setExpDetPerTelExp(DetPerTelExp expDetPerTelExp) {
		this.expDetPerTelExp = expDetPerTelExp;
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