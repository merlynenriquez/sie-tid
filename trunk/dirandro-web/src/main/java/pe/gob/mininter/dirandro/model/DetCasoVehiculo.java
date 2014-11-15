package pe.gob.mininter.dirandro.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import pe.gob.mininter.dirandro.util.beanbase.AuditoriaBean;


/**
 * The persistent class for the AGE_DET_CASO_VEHICULO database table.
 * 
 */
@Entity
@Table(name="AGE_DET_CASO_VEHICULO")
@NamedQuery(name="DetCasoVehiculo.findAll", query="SELECT d FROM DetCasoVehiculo d")
public class DetCasoVehiculo extends AuditoriaBean implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="AGE_DET_CASO_VEHICULO_ID_GENERATOR", sequenceName="SEQ_CASO_VEHICULO")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="AGE_DET_CASO_VEHICULO_ID_GENERATOR")
	private Long id;

	private String observacion;

	@Column(name="TIPO_USO")
	private String tipoUso;

	//bi-directional many-to-one association to Caso
	@ManyToOne
	@JoinColumn(name="CASO")
	private Caso caso;

	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="PARTICIPACION")
	private Valor participacion;

	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="ESTADO_DATO")
	private Valor estadoDato;

	//bi-directional many-to-one association to Vehiculo
	@ManyToOne
	@JoinColumn(name="VEHICULO")
	private Vehiculo vehiculo;

	//bi-directional many-to-one association to Persona
	@ManyToOne
	@JoinColumn(name="PROPIETARIO")
	private Persona propietario;

	public DetCasoVehiculo() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public String getTipoUso() {
		return tipoUso;
	}

	public void setTipoUso(String tipoUso) {
		this.tipoUso = tipoUso;
	}

	public Caso getCaso() {
		return caso;
	}

	public void setCaso(Caso caso) {
		this.caso = caso;
	}

	public Valor getParticipacion() {
		return participacion;
	}

	public void setParticipacion(Valor participacion) {
		this.participacion = participacion;
	}

	public Valor getEstadoDato() {
		return estadoDato;
	}

	public void setEstadoDato(Valor estadoDato) {
		this.estadoDato = estadoDato;
	}

	public Vehiculo getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}

	public Persona getPropietario() {
		return propietario;
	}

	public void setPropietario(Persona propietario) {
		this.propietario = propietario;
	}

}