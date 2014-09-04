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

	private static final long serialVersionUID = 8063743236030806260L;

	@Id
	@SequenceGenerator(name="EXP_DET_PER_INM_EXP_ID_GENERATOR", sequenceName="SEQ_", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="EXP_DET_PER_INM_EXP_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=16)
	private Long id;


	@Column(name="NUMERO_PISOS", precision=10)
	private BigDecimal numeroPisos;

	@Column(name="TIPO_USO", length=400)
	private String tipoUso;

	//bi-directional many-to-one association to Expediente
	@ManyToOne
	@JoinColumn(name="EXPEDIENTE", nullable=false)
	private Expediente expediente;
	
	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="SITUACION")
	private Valor situacion;

	//bi-directional many-to-one association to Persona
	@ManyToOne
	@JoinColumn(name="PROPIETARIO")
	private Persona propietario;
		
	//bi-directional many-to-one association to Inmueble
	@ManyToOne
	@JoinColumn(name="INMUEBLE")
	private Inmueble inmueble;


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
	
	public String getTipoUso() {
		return this.tipoUso;
	}

	public void setTipoUso(String tipoUso) {
		this.tipoUso = tipoUso;
	}

	public Expediente getExpediente() {
		return expediente;
	}

	public void setExpediente(Expediente expediente) {
		this.expediente = expediente;
	}

	public Valor getSituacion() {
		return situacion;
	}

	public void setSituacion(Valor situacion) {
		this.situacion = situacion;
	}

	public Persona getPropietario() {
		return propietario;
	}

	public void setPropietario(Persona propietario) {
		this.propietario = propietario;
	}

	public Inmueble getInmueble() {
		return inmueble;
	}

	public void setInmueble(Inmueble inmueble) {
		this.inmueble = inmueble;
	}

	@Override
	public void validar() {
		// TODO Auto-generated method stub
		
	}

}