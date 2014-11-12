package pe.gob.mininter.dirandro.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import pe.gob.mininter.dirandro.util.beanbase.AuditoriaBean;


/**
 * The persistent class for the INT_DET_INTELIGENCIA_NOTA database table.
 * 
 */
@Entity
@Table(name="INT_DET_INTELIGENCIA_NOTA")
public class InteligenciaNota extends AuditoriaBean implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="INT_DET_INTELIGENCIA_NOTA_ID_GENERATOR", sequenceName="SEQ_INT_DET_INTELIGENCIA_NOTA")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="INT_DET_INTELIGENCIA_NOTA_ID_GENERATOR")
	private Long id;

	//bi-directional many-to-one association to NotaAgente
	@ManyToOne
	@JoinColumn(name="NOTA")
	private NotaAgente notaAgente;

	//bi-directional many-to-one association to Inteligencia
	@ManyToOne
	@JoinColumn(name="INTELIGENCIA")
	private Inteligencia inteligencia;

	public InteligenciaNota() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public NotaAgente getNotaAgente() {
		return notaAgente;
	}

	public void setNotaAgente(NotaAgente notaAgente) {
		this.notaAgente = notaAgente;
	}

	public Inteligencia getInteligencia() {
		return inteligencia;
	}

	public void setInteligencia(Inteligencia inteligencia) {
		this.inteligencia = inteligencia;
	}

}