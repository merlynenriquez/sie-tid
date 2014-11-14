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
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import pe.gob.mininter.dirandro.exception.ValidacionException;
import pe.gob.mininter.dirandro.util.Constante;
import pe.gob.mininter.dirandro.util.Validador;
import pe.gob.mininter.dirandro.util.beanbase.AuditoriaBean;


/**
 * The persistent class for the PER_LETRADO database table.
 * 
 */
@Entity
@Table(name="PER_LETRADO")
public class Letrado extends AuditoriaBean implements Validador, Serializable {
	
	private static final long serialVersionUID = -6117520471153540228L;

	@Id
	@SequenceGenerator(name="PER_LETRADO_ID_GENERATOR", sequenceName="SEQ_LETRADO", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PER_LETRADO_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=16)
	private Long id;

	@Column(name="NRO_COLEGIATURA", length=20)
	@NotBlank(message=Constante.CODIGO_MENSAJE.VALIDAR_COMBOBOX)
	private String nroColegiatura;
	
	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="tipo")
	@NotNull(message=Constante.CODIGO_MENSAJE.VALIDAR_COMBOBOX)
	private Valor tipo;

	//bi-directional many-to-one association to Persona
	@ManyToOne
	@JoinColumn(name="PERSONA")
	@NotNull(message=Constante.CODIGO_MENSAJE.VALIDAR_COMBOBOX)
	private Persona persona;

	public Letrado() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNroColegiatura() {
		return nroColegiatura;
	}

	public void setNroColegiatura(String nroColegiatura) {
		this.nroColegiatura = nroColegiatura;
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

	public String getNombreCompleto(){
		StringBuilder nombre = new StringBuilder();
		if(this.getTipo()!=null){
			nombre.append(this.getTipo().getNombre());
			nombre.append(" - ");
		}
		nombre.append(this.persona.getNombres());
		nombre.append("");
		nombre.append(this.persona.getApePaterno());
		nombre.append(" ");
		nombre.append(this.persona.getApeMaterno());
		return nombre.toString();
	}
	
	@Override
	public void validar(){
		if(persona == null){
			throw new ValidacionException(Constante.CODIGO_MENSAJE.VALIDAR_COMBOBOX, new Object[]{"Persona"});
		}
		if(tipo == null) {
			throw new ValidacionException(Constante.CODIGO_MENSAJE.VALIDAR_COMBOBOX, new Object[]{"Tipo"});
		}		
	}


}