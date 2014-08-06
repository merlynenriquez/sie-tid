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
 * The persistent class for the EXP_PREDECESOR database table.
 * 
 */
@Entity
@Table(name="EXP_PREDECESOR")
public class Predecesor extends AuditoriaBean implements Validador, Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1831611683665698626L;

	@Id
	@SequenceGenerator(name="EXP_PREDECESOR_ID_GENERATOR", sequenceName="SEQ_")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="EXP_PREDECESOR_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=16)
	private Long id;

	//bi-directional many-to-one association to Dependencia
	@ManyToOne
	@JoinColumn(name="DEPENDENCIA")
	private Dependencia expDependencia1;

	//bi-directional many-to-one association to Dependencia
	@ManyToOne
	@JoinColumn(name="PREDECESOR")
	private Dependencia expDependencia2;

	public Predecesor() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Dependencia getExpDependencia1() {
		return expDependencia1;
	}

	public void setExpDependencia1(Dependencia expDependencia1) {
		this.expDependencia1 = expDependencia1;
	}

	public Dependencia getExpDependencia2() {
		return expDependencia2;
	}

	public void setExpDependencia2(Dependencia expDependencia2) {
		this.expDependencia2 = expDependencia2;
	}

	@Override
	public void validar() {
		// TODO Auto-generated method stub
		
	} 
	
	
}