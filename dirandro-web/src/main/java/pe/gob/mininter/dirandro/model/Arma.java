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
	private Valor cfgValor1;

	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="CALIBRE")
	private Valor cfgValor2;

	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="EST_SERIE")
	private Valor cfgValor3;

	//bi-directional many-to-one association to ModeloMarca
	@ManyToOne
	@JoinColumn(name="MARCA")
	private ModeloMarca mntModeloMarca1;

	//bi-directional many-to-one association to ModeloMarca
	@ManyToOne
	@JoinColumn(name="MODELO")
	private ModeloMarca mntModeloMarca2;

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

	public Valor getCfgValor1() {
		return this.cfgValor1;
	}

	public void setCfgValor1(Valor cfgValor1) {
		this.cfgValor1 = cfgValor1;
	}

	public Valor getCfgValor2() {
		return this.cfgValor2;
	}

	public void setCfgValor2(Valor cfgValor2) {
		this.cfgValor2 = cfgValor2;
	}

	public Valor getCfgValor3() {
		return this.cfgValor3;
	}

	public void setCfgValor3(Valor cfgValor3) {
		this.cfgValor3 = cfgValor3;
	}

	public ModeloMarca getMntModeloMarca1() {
		return this.mntModeloMarca1;
	}

	public void setMntModeloMarca1(ModeloMarca mntModeloMarca1) {
		this.mntModeloMarca1 = mntModeloMarca1;
	}

	public ModeloMarca getMntModeloMarca2() {
		return this.mntModeloMarca2;
	}

	public void setMntModeloMarca2(ModeloMarca mntModeloMarca2) {
		this.mntModeloMarca2 = mntModeloMarca2;
	}

	@Override
	public void validar() {
		// TODO Auto-generated method stub
		
	}

}