package pe.gob.mininter.dirandro.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.apache.commons.lang.StringUtils;

import pe.gob.mininter.dirandro.exception.ValidacionException;
import pe.gob.mininter.dirandro.util.Constante;
import pe.gob.mininter.dirandro.util.Validador;
import pe.gob.mininter.dirandro.util.beanbase.AuditoriaBean;


/**
 * The persistent class for the PER_NO_IDENTIFICADOS database table.
 * 
 */
@Entity
@Table(name="PER_NO_IDENTIFICADOS")
public class NoIdentificado extends AuditoriaBean implements Validador, Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1377193537649273995L;

	@Id
	@SequenceGenerator(name="PER_NO_IDENTIFICADOS_ID_GENERATOR", sequenceName="SEQ_NO_IDENTIFICADO", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PER_NO_IDENTIFICADOS_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=16)
	private Long id;

	@Column(name="\"ALIAS\"", length=200)
	private String alias;

	@Column(length=200)
	private String apellidos;

	@Column(name="EDAD_APROX", precision=22)
	private BigDecimal edadAprox;

	@Column(length=200)
	private String nombres;
	
	@Column(length=1)
	private String sexo;
	
	//bi-directional many-to-one association to Detalle
	@OneToMany(mappedBy="perNoIdentificado")
	private List<Detalle> perDetalles;

	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="ORIENT_SEXUAL")
	private Valor orientacionSexual;

	//bi-directional many-to-one association to Expediente
	@ManyToOne
	@JoinColumn(name="EXPEDIENTE")
	private Expediente expediente;

	//bi-directional many-to-one association to Persona
	@ManyToOne
	@JoinColumn(name="PERSONA")
	private Persona perPersona;

	public NoIdentificado() {
	}

	public boolean esNuevo(){
		return id == null || id.longValue() == 0;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public BigDecimal getEdadAprox() {
		return edadAprox;
	}

	public void setEdadAprox(BigDecimal edadAprox) {
		this.edadAprox = edadAprox;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public List<Detalle> getPerDetalles() {
		return perDetalles;
	}

	public void setPerDetalles(List<Detalle> perDetalles) {
		this.perDetalles = perDetalles;
	}

	public Valor getOrientacionSexual() {
		return orientacionSexual;
	}

	public void setOrientacionSexual(Valor orientacionSexual) {
		this.orientacionSexual = orientacionSexual;
	}

	public Expediente getExpediente() {
		return expediente;
	}

	public void setExpediente(Expediente expExpediente) {
		this.expediente = expExpediente;
	}

	public Persona getPerPersona() {
		return perPersona;
	}

	public void setPerPersona(Persona perPersona) {
		this.perPersona = perPersona;
	}

	public void setSexo(String sexo){
		this.sexo=sexo;
	}
	
	public String getSexo(){
		return this.sexo;
	}
	
	@Override
	public void validar() {
		
		if(StringUtils.isBlank( this.alias ))
		{
			throw new ValidacionException(Constante.CODIGO_MENSAJE.VALIDAR_TEXTBOX, new Object[]{"Alias"});
		}

		if(  this.edadAprox == null )
		{
			throw new ValidacionException(Constante.CODIGO_MENSAJE.VALIDAR_TEXTBOX, new Object[]{"Edad aproximada"});
		}
		/*
		if (marca == null || marca.getId() == null) {
			throw new ValidacionException(Constante.CODIGO_MENSAJE.VALIDAR_COMBOBOX, new Object[] { "Tipo de Munición y Marca" });
		}*/
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
		NoIdentificado other = (NoIdentificado) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}