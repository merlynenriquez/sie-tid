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

import pe.gob.mininter.dirandro.util.beanbase.AuditoriaBean;


/**
 * The persistent class for the AGE_DET_CASO_DIRECCION database table.
 * 
 */
@Entity
@Table(name="AGE_DET_CASO_DIRECCION")
public class DetCasoDireccion extends AuditoriaBean implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="AGE_DET_CASO_DIRECCION_ID_GENERATOR", sequenceName="SEQ_CASO_DIRECCION")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="AGE_DET_CASO_DIRECCION_ID_GENERATOR")
	private Long id;

	@Column(name="DETALLE_USO")
	private String detalleUso;
	
	//bi-directional many-to-one association to Caso
	@ManyToOne
	@JoinColumn(name="CASO")
	private Caso caso;

	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="TIPO_USO")
	private Valor tipoUso;

	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="SITUACION")
	private Valor situacion;

	//bi-directional many-to-one association to Direccion
	@ManyToOne
	@JoinColumn(name="DIRECCION")
	private Direccion direccion;

	public DetCasoDireccion() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDetalleUso() {
		return detalleUso;
	}

	public void setDetalleUso(String detalleUso) {
		this.detalleUso = detalleUso;
	}

	public Caso getCaso() {
		return caso;
	}

	public void setCaso(Caso caso) {
		this.caso = caso;
	}

	public Valor getTipoUso() {
		return tipoUso;
	}

	public void setTipoUso(Valor tipoUso) {
		this.tipoUso = tipoUso;
	}

	public Valor getSituacion() {
		return situacion;
	}

	public void setSituacion(Valor situacion) {
		this.situacion = situacion;
	}

	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}
 
}