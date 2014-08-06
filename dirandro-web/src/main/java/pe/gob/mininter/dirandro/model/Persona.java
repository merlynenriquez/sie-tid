package pe.gob.mininter.dirandro.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import pe.gob.mininter.dirandro.util.Validador;
import pe.gob.mininter.dirandro.util.beanbase.AuditoriaBean;


/**
 * The persistent class for the PER_PERSONA database table.
 * 
 */
@Entity
@Table(name="PER_PERSONA")
public class Persona extends AuditoriaBean implements Validador, Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5500204306148416617L;

	@Id
	@SequenceGenerator(name="PER_PERSONA_ID_GENERATOR", sequenceName="SEQ_")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PER_PERSONA_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=16)
	private Long id;

	@Column(name="APE_MATERNO", length=200)
	private String apeMaterno;

	@Column(name="APE_PATERNO", length=200)
	private String apePaterno;

	@Temporal(TemporalType.DATE)
	@Column(name="FEC_NACIMIENTO")
	private Date fecNacimiento;

	@Column(length=300)
	private String nombres;

	@Column(name="NRO_DOCUMENTO", length=40)
	private String nroDocumento;

	@Column(length=2)
	private String sexo;

	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="ORIENTACION_SEXUAL")
	private Valor orientacionSexual;

	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="NACIONALIDAD")
	private Valor nacionalidad;

	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="ESTADO_CIVIL")
	private Valor estadoCivil;

	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="TIPO_DOCUMENTO")
	private Valor tipoDocumento;

	//bi-directional many-to-one association to Persona
	@ManyToOne
	@JoinColumn(name="PERSONA")
	private Persona perPersona;

	//bi-directional many-to-one association to Distrito
	@ManyToOne
	@JoinColumn(name="LUGAR_NACIMIENTO")
	private Distrito ubgDistrito;

	public Persona() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getApeMaterno() {
		return apeMaterno;
	}

	public void setApeMaterno(String apeMaterno) {
		this.apeMaterno = apeMaterno;
	}

	public String getApePaterno() {
		return apePaterno;
	}

	public void setApePaterno(String apePaterno) {
		this.apePaterno = apePaterno;
	}

	public Date getFecNacimiento() {
		return fecNacimiento;
	}

	public void setFecNacimiento(Date fecNacimiento) {
		this.fecNacimiento = fecNacimiento;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getNroDocumento() {
		return nroDocumento;
	}

	public void setNroDocumento(String nroDocumento) {
		this.nroDocumento = nroDocumento;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public Valor getOrientacionSexual() {
		return orientacionSexual;
	}

	public void setOrientacionSexual(Valor orientacionSexual) {
		this.orientacionSexual = orientacionSexual;
	}

	public Valor getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(Valor nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public Valor getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(Valor estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public Valor getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(Valor tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public Persona getPerPersona() {
		return perPersona;
	}

	public void setPerPersona(Persona perPersona) {
		this.perPersona = perPersona;
	}

	public Distrito getUbgDistrito() {
		return ubgDistrito;
	}

	public void setUbgDistrito(Distrito ubgDistrito) {
		this.ubgDistrito = ubgDistrito;
	}

	@Override
	public void validar() {
		// TODO Auto-generated method stub
		
	}

}