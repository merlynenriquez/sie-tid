package pe.gob.mininter.dirandro.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the EXP_ABOGADO_PERSONA database table.
 * 
 */
@Entity
@Table(name="EXP_ABOGADO_PERSONA")
public class AbogadoPersona implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="EXP_ABOGADO_PERSONA_ID_GENERATOR", sequenceName="SEQ_")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="EXP_ABOGADO_PERSONA_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=16)
	private long id;

	@Column(nullable=false)
	private Timestamp creacion;

	private Timestamp edicion;

	@Column(precision=16)
	private BigDecimal estado;

	@Temporal(TemporalType.DATE)
	@Column(name="FEC_INI_REPRESENTACION")
	private Date fecIniRepresentacion;

	//bi-directional many-to-one association to DetExpedientePersona
	@ManyToOne
	@JoinColumn(name="PERSONA", nullable=false)
	private DetExpedientePersona expDetExpedientePersona;

	//bi-directional many-to-one association to Letrado
	@ManyToOne
	@JoinColumn(name="ABOGADO")
	private Letrado perLetrado;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="EDITOR")
	private Usuario segUsuario1;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="CREADOR", nullable=false)
	private Usuario segUsuario2;

	public AbogadoPersona() {
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

	public Date getFecIniRepresentacion() {
		return this.fecIniRepresentacion;
	}

	public void setFecIniRepresentacion(Date fecIniRepresentacion) {
		this.fecIniRepresentacion = fecIniRepresentacion;
	}

	public DetExpedientePersona getExpDetExpedientePersona() {
		return this.expDetExpedientePersona;
	}

	public void setExpDetExpedientePersona(DetExpedientePersona expDetExpedientePersona) {
		this.expDetExpedientePersona = expDetExpedientePersona;
	}

	public Letrado getPerLetrado() {
		return this.perLetrado;
	}

	public void setPerLetrado(Letrado perLetrado) {
		this.perLetrado = perLetrado;
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