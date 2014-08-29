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
	@SequenceGenerator(name="EXP_PREDECESOR_ID_GENERATOR", sequenceName="SEQ_", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="EXP_PREDECESOR_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=16)
	private Long id;

	//bi-directional many-to-one association to Dependencia
	@ManyToOne
	@JoinColumn(name="DEPENDENCIA")
	private Dependencia dependencia;

	//bi-directional many-to-one association to Dependencia
	@ManyToOne
	@JoinColumn(name="PREDECESOR")
	private Dependencia predecedor;

	public Predecesor() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public Dependencia getDependencia() {
		return dependencia;
	}

	public void setDependencia(Dependencia dependencia) {
		this.dependencia = dependencia;
	}

	public Dependencia getPredecedor() {
		return predecedor;
	}

	public void setPredecedor(Dependencia predecedor) {
		this.predecedor = predecedor;
	}

	@Override
	public void validar() {
		// TODO Auto-generated method stub
		
	} 
	
	
}