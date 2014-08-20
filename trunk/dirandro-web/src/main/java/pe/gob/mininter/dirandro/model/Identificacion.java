package pe.gob.mininter.dirandro.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.apache.commons.lang.StringUtils;

import pe.gob.mininter.dirandro.exception.ValidacionException;
import pe.gob.mininter.dirandro.util.Constante;
import pe.gob.mininter.dirandro.util.Validador;
import pe.gob.mininter.dirandro.util.beanbase.AuditoriaBean;


/**
 * The persistent class for the PER_IDENTIFICACION database table.
 * 
 */
@Entity
@Table(name="PER_IDENTIFICACION")
public class Identificacion extends AuditoriaBean implements Validador, Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -109588933356103657L;

	@Id
	@SequenceGenerator(name="PER_IDENTIFICACION_ID_GENERATOR", sequenceName="SEQ_IDENTIFICACION")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PER_IDENTIFICACION_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=16)
	private Long id;

	@Column(length=40)
	private String numero;

	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="TIPO")
	private Valor tipo;

	//bi-directional many-to-one association to Persona
	@ManyToOne
	@JoinColumn(name="PERSONA")
	private Persona persona;

	public Identificacion() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Valor getTipo() {
		return tipo;
	}

	public void setTipo(Valor tipo) {
		this.tipo = tipo;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	@Override
	public void validar() {
		if(StringUtils.isBlank(numero))
		{
			throw new ValidacionException(Constante.CODIGO_MENSAJE.VALIDAR_TEXTBOX, new Object[]{"Numero"});
		}
		if( tipo == null || tipo.getId() == null)
		{
			throw new ValidacionException(Constante.CODIGO_MENSAJE.VALIDAR_COMBOBOX, new Object[]{"Tipo de Documento"});
		}
	}

}