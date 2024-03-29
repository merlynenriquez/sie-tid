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
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import pe.gob.mininter.dirandro.util.Constante;
import pe.gob.mininter.dirandro.util.beanbase.AuditoriaBean;


/**
 * The persistent class for the PER_PERSONA database table.
 * 
 */
@Entity
@Table(name="PER_PERSONA")
public class Persona extends AuditoriaBean implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5500204306148416617L;

	@Id
	@SequenceGenerator(name="PER_PERSONA_ID_GENERATOR", sequenceName="SEQ_PERSONA", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PER_PERSONA_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=16)
	private Long id;

	@Column(name="APE_MATERNO", length=200)
	@NotBlank(message=Constante.CODIGO_MENSAJE.VALIDAR_TEXTBOX)
	private String apeMaterno;

	@Column(name="APE_PATERNO", length=200)
	@NotBlank(message=Constante.CODIGO_MENSAJE.VALIDAR_TEXTBOX)
	private String apePaterno;

	@Temporal(TemporalType.DATE)
	@Column(name="FEC_NACIMIENTO")
	private Date fecNacimiento;

	@Column(length=300)
	@NotBlank(message=Constante.CODIGO_MENSAJE.VALIDAR_TEXTBOX)
	private String nombres;

	@Column(name="NRO_DOCUMENTO", length=40)
	@NotBlank(message=Constante.CODIGO_MENSAJE.VALIDAR_TEXTBOX)
	private String nroDocumento;

	@Column(length=2)
	@NotBlank(message=Constante.CODIGO_MENSAJE.VALIDAR_TEXTBOX)
	private String sexo;

	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="ORIENTACION_SEXUAL")
	private Valor orientacionSexual;

	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="NACIONALIDAD")
	@NotNull(message=Constante.CODIGO_MENSAJE.VALIDAR_COMBOBOX)
	private Pais nacionalidad;

	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="ESTADO_CIVIL")
	private Valor estadoCivil;

	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="TIPO_DOCUMENTO")
	@NotNull(message=Constante.CODIGO_MENSAJE.VALIDAR_COMBOBOX)
	private Valor tipoDocumento;

	//bi-directional many-to-one association to Persona
	@ManyToOne
	@JoinColumn(name="PERSONA")
	private Persona perPersona;

	//bi-directional many-to-one association to Distrito
	@ManyToOne
	@JoinColumn(name="LUGAR_NACIMIENTO")
	private Distrito lugarNacimiento;

	public Persona() {
	}

	public Persona(Long id) {
		this.id=id;
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
	
	public Pais getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(Pais nacionalidad) {
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

	public Distrito getLugarNacimiento() {
		return lugarNacimiento;
	}

	public void setLugarNacimiento(Distrito lugarNacimiento) {
		this.lugarNacimiento = lugarNacimiento;
	}

	/*@Override
	public void validar() {
		if (tipoDocumento == null) {
			throw new ValidacionException(Constante.CODIGO_MENSAJE.VALIDAR_COMBOBOX, new Object[] { "Tipo de Documento" });
		}
		if (StringUtils.isBlank(nroDocumento)) {
			throw new ValidacionException(Constante.CODIGO_MENSAJE.VALIDAR_TEXTBOX, new Object[] { "Numero de Documento" });
		}
		if (StringUtils.isBlank(nombres)) {
			throw new ValidacionException(Constante.CODIGO_MENSAJE.VALIDAR_TEXTBOX, new Object[] { "Nombre" });
		}
		if (StringUtils.isBlank(apePaterno)) {
			throw new ValidacionException(Constante.CODIGO_MENSAJE.VALIDAR_TEXTBOX, new Object[] { "Apellido Paterno" });
		}
		if (StringUtils.isBlank(sexo)) {
			throw new ValidacionException(Constante.CODIGO_MENSAJE.VALIDAR_COMBOBOX, new Object[] { "Sexo" });
		}
		if (nacionalidad == null || nacionalidad.getId() == null) {
			throw new ValidacionException(Constante.CODIGO_MENSAJE.VALIDAR_COMBOBOX, new Object[] { "Nacionalidad" });
		}
	}*/
	
	public String getNombreCompleto(){
		return this.nombres + " " + this.apePaterno + " " + this.apeMaterno;
	}
	
	public boolean esNuevo(){
		return id == null || id.longValue() == 0;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}