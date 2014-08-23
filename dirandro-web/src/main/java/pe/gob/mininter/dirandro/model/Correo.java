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

import pe.gob.mininter.dirandro.util.Validador;
import pe.gob.mininter.dirandro.util.beanbase.AuditoriaBean;


/**
 * The persistent class for the PER_CORREO database table.
 * 
 */
@Entity
@Table(name="PER_CORREO")
public class Correo extends AuditoriaBean implements Validador, Serializable {
	
	private static final long serialVersionUID = -1921706650569597925L;

	@Id
	@SequenceGenerator(name="PER_CORREO_ID_GENERATOR", sequenceName="SEQ_CORREO", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PER_CORREO_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=16)
	private Long id;

	@Column(nullable=false, length=200)
	private String correo;

	//bi-directional many-to-one association to Persona
	@ManyToOne
	@JoinColumn(name="PERSONA", nullable=false)
	private Persona persona;

	public Correo() {
	}

	public Correo(Persona persona) {
		this.persona=persona;
	}
	
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCorreo() {
		return this.correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public Persona getPersona() {
		return this.persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	@Override
	public void validar() {
		// TODO Auto-generated method stub
		
	}

}