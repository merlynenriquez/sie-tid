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
 * The persistent class for the EXP_ARMAS database table.
 * 
 */
@Entity
@Table(name="EXP_ARMAS")
public class Arma extends AuditoriaBean implements Validador, Serializable {
	
	private static final long serialVersionUID = 5081528737398160530L;

	@Id
	@SequenceGenerator(name="EXP_ARMAS_ID_GENERATOR", sequenceName="SEQ_", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="EXP_ARMAS_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=16)
	private Long id;

	@Column(length=100)
	private String internamiento;

	@Column(name="NRO_LICENCIA", length=20)
	private String nroLicencia;

	@Column(name="NRO_SERIE", length=100)
	private String nroSerie;

	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="CLASIFICACION")
	private Valor clasificacion;

	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="CALIBRE")
	private Valor calibre;

	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="EST_SERIE")
	private Valor estadoSerie;

	//bi-directional many-to-one association to ModeloMarca
	@ManyToOne
	@JoinColumn(name="MODELO")
	private ModeloMarca modelo;

	public Arma() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getInternamiento() {
		return this.internamiento;
	}

	public void setInternamiento(String internamiento) {
		this.internamiento = internamiento;
	}

	public String getNroLicencia() {
		return this.nroLicencia;
	}

	public void setNroLicencia(String nroLicencia) {
		this.nroLicencia = nroLicencia;
	}

	public String getNroSerie() {
		return this.nroSerie;
	}

	public void setNroSerie(String nroSerie) {
		this.nroSerie = nroSerie;
	}

	public Valor getClasificacion() {
		return clasificacion;
	}

	public void setClasificacion(Valor clasificacion) {
		this.clasificacion = clasificacion;
	}

	public Valor getCalibre() {
		return calibre;
	}

	public void setCalibre(Valor calibre) {
		this.calibre = calibre;
	}

	public Valor getEstadoSerie() {
		return estadoSerie;
	}

	public void setEstadoSerie(Valor estadoSerie) {
		this.estadoSerie = estadoSerie;
	}

	public ModeloMarca getModelo() {
		return modelo;
	}

	public void setModelo(ModeloMarca modelo) {
		this.modelo = modelo;
	}

	@Override
	public void validar() {
		// TODO Auto-generated method stub
		
	}

}