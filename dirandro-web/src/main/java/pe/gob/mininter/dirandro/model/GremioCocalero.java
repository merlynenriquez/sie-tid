package pe.gob.mininter.dirandro.model;

import java.io.Serializable;
import java.math.BigDecimal;

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
 * The persistent class for the INT_GREMIO_COCALERO database table.
 * 
 */
@Entity
@Table(name="INT_GREMIO_COCALERO")
@NamedQuery(name="GremioCocalero.findAll", query="SELECT g FROM GremioCocalero g")
public class GremioCocalero extends AuditoriaBean implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="INT_GREMIO_COCALERO_ID_GENERATOR", sequenceName="SEQ_INT_GREMIO_COCALERO")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="INT_GREMIO_COCALERO_ID_GENERATOR")
	private Long id;

	private String actividad;

	@Column(name="JUNTA_DIRECTIVA")
	private String juntaDirectiva;

	private String nombre;

	@Column(name="NUM_MIEMBROS")
	private BigDecimal numMiembros;

	@Column(name="PLATAFORMA_LUCHA")
	private String plataformaLucha;

	private String siglas;

	@Column(name="ZONA_INFLUENCIA")
	private String zonaInfluencia;

	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="CUENCA")
	private Valor cuenca;

	//bi-directional many-to-one association to Distrito
	@ManyToOne
	@JoinColumn(name="UBIGEO")
	private Distrito distrito;

	public GremioCocalero() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getActividad() {
		return actividad;
	}

	public void setActividad(String actividad) {
		this.actividad = actividad;
	}

	public String getJuntaDirectiva() {
		return juntaDirectiva;
	}

	public void setJuntaDirectiva(String juntaDirectiva) {
		this.juntaDirectiva = juntaDirectiva;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public BigDecimal getNumMiembros() {
		return numMiembros;
	}

	public void setNumMiembros(BigDecimal numMiembros) {
		this.numMiembros = numMiembros;
	}

	public String getPlataformaLucha() {
		return plataformaLucha;
	}

	public void setPlataformaLucha(String plataformaLucha) {
		this.plataformaLucha = plataformaLucha;
	}

	public String getSiglas() {
		return siglas;
	}

	public void setSiglas(String siglas) {
		this.siglas = siglas;
	}

	public String getZonaInfluencia() {
		return zonaInfluencia;
	}

	public void setZonaInfluencia(String zonaInfluencia) {
		this.zonaInfluencia = zonaInfluencia;
	}

	public Valor getCuenca() {
		return cuenca;
	}

	public void setCuenca(Valor cuenca) {
		this.cuenca = cuenca;
	}

	public Distrito getDistrito() {
		return distrito;
	}

	public void setDistrito(Distrito distrito) {
		this.distrito = distrito;
	}
 
}