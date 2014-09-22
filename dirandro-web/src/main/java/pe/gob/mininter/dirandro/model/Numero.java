package pe.gob.mininter.dirandro.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import pe.gob.mininter.dirandro.util.Validador;
import pe.gob.mininter.dirandro.util.beanbase.AuditoriaBean;


/**
 * The persistent class for the EXP_NUMERO database table.
 * 
 */
@Entity
@Table(name="EXP_NUMERO")
public class Numero extends AuditoriaBean implements Validador, Serializable {
	
	private static final long serialVersionUID = 160195192053678873L;

	@Id
	@SequenceGenerator(name="EXP_NUMERO_ID_GENERATOR", sequenceName="SEQ_NUMERO")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="EXP_NUMERO_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=16)
	private Long id;
	
	@Column(nullable=false, length=80)
	private String numero;

	public Numero() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumero() {
		return this.numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	@Override
	public void validar() {
		// TODO Auto-generated method stub
		
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
		Numero other = (Numero) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}