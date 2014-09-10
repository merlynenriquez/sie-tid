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

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import pe.gob.mininter.dirandro.util.Validador;
import pe.gob.mininter.dirandro.util.beanbase.AuditoriaBean;


/**
 * The persistent class for the EXP_DELITO database table.
 * 
 */
@Entity
@Table(name="EXP_DELITO")
public class Delito extends AuditoriaBean implements Validador, Serializable {
	
	private static final long serialVersionUID = 8754887405793559368L;

	@Id
	@SequenceGenerator(name="EXP_DELITO_ID_GENERATOR", sequenceName="SEQ_DELITO", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="EXP_DELITO_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=16)
	private Long id;

	@Column(length=400)
	private String nombre;

	@Column(length=4000)
	private String observacion;

	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="ESTADO")
	private Valor estado;

	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="TIPO_CODIGO")
	private Valor codigoProcesal;

	//bi-directional many-to-one association to Delito
	@ManyToOne
	@JoinColumn(name="PADRE")
	private Delito padre;	

	public Delito() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getObservacion() {
		return this.observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}
	
	public Valor getEstado() {
		return estado;
	}

	public void setEstado(Valor estado) {
		this.estado = estado;
	}

	public Delito getPadre() {
		return padre;
	}

	public void setPadre(Delito padre) {
		this.padre = padre;
	}

	public Valor getCodigoProcesal() {
		return codigoProcesal;
	}

	public void setCodigoProcesal(Valor codigoProcesal) {
		this.codigoProcesal = codigoProcesal;
	}
	
	/*@Override
	public int hashCode() {
		HashCodeBuilder hashCodeBuilder = new HashCodeBuilder(3, 7);
		hashCodeBuilder.append(id);
		return hashCodeBuilder.toHashCode();
	}

	@Override
	public boolean equals(Object obj) {
		boolean equals = false;
		if (obj instanceof Valor) {
			Delito bean = (Delito) obj;
			equals = (new EqualsBuilder().append(id, bean.id)).isEquals();
		}
		return equals;
	}*/

	@Override
	public void validar() {
		// TODO Auto-generated method stub
		
	}

}