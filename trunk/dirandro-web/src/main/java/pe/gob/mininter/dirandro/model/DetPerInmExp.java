package pe.gob.mininter.dirandro.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import pe.gob.mininter.dirandro.util.Validador;
import pe.gob.mininter.dirandro.util.beanbase.AuditoriaBean;


/**
 * The persistent class for the EXP_DET_PER_INM_EXP database table.
 * 
 */
@Entity
@Table(name="EXP_DET_PER_INM_EXP")
public class DetPerInmExp extends AuditoriaBean implements Validador, Serializable {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 8063743236030806260L;

	@Id
	@SequenceGenerator(name="EXP_DET_PER_INM_EXP_ID_GENERATOR", sequenceName="SEQ_")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="EXP_DET_PER_INM_EXP_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=16)
	private Long id;


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


	public DetPerInmExp() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
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


	@Override
	public void validar() {
		// TODO Auto-generated method stub
		
	}

}