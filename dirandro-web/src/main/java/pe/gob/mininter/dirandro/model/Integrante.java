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
import javax.persistence.Transient;

import org.apache.commons.lang.StringUtils;

import pe.gob.mininter.dirandro.util.beanbase.AuditoriaBean;


/**
 * The persistent class for the ORG_INTEGRANTE database table.
 * 
 */
@Entity
@Table(name="ORG_INTEGRANTE")
public class Integrante extends AuditoriaBean implements Serializable {
	
	private static final long serialVersionUID = 8006992786865932374L;

	@Id
	@SequenceGenerator(name="ORG_INTEGRANTE_ID_GENERATOR", sequenceName="SEQ_INTEGRANTE", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ORG_INTEGRANTE_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=16)
	private Long id;

	//TODO: Borrar del Modelo
	//@Column(name="ES_LIDER", precision=22)
	//private Integer esLider;

	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="FUNCION")
	private Valor funcion;

	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="ESTADO", nullable=false)
	private Valor estado;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="POLICIA", nullable=false)
	private Policia policia;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="DEPENDENCIA", nullable=false)
	private Dependencia dependencia;
	
	public Integrante() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

//	public Integer getEsLider() {
//		return esLider;
//	}
//
//	public void setEsLider(Integer esLider) {
//		this.esLider = esLider;
//	}

	public Valor getFuncion() {
		return funcion;
	}

	public void setFuncion(Valor funcion) {
		this.funcion = funcion;
	}

	public Valor getEstado() {
		return estado;
	}

	public void setEstado(Valor estado) {
		this.estado = estado;
	}

	public Policia getPolicia() {
		return policia;
	}

	public void setPolicia(Policia policia) {
		this.policia = policia;
	}

	public Dependencia getDependencia() {
		return dependencia;
	}

	public void setDependencia(Dependencia dependencia) {
		this.dependencia = dependencia;
	}

	@Transient
	public String getNombreCompletoIntegrante() {
		return policia != null ? policia.getNombreCompleto() : StringUtils.EMPTY;
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
		Integrante other = (Integrante) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}