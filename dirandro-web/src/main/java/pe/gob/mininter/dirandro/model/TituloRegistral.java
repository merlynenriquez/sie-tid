package pe.gob.mininter.dirandro.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

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
 * The persistent class for the INF_TITULO_REGISTRAL database table.
 * 
 */
@Entity
@Table(name="INF_TITULO_REGISTRAL")
public class TituloRegistral extends AuditoriaBean implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="INF_TITULO_REGISTRAL_ID_GENERATOR", sequenceName="SEQ_INF_TITULO_REGISTRAL")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="INF_TITULO_REGISTRAL_ID_GENERATOR")
	private Long id;

	@Column(name="ESTADO_TRAMITE")
	private BigDecimal estadoTramite;

	@Column(name="FECHA_SEGUIMIENTO")
	private Timestamp fechaSeguimiento;

	@Column(name="FECHA_TERMINO")
	private Timestamp fechaTermino;

	@Column(name="FECHA_TITULO")
	private Timestamp fechaTitulo;

	@Column(name="NRO_TITULO")
	private String nroTitulo;

	@Column(name="SEDE_REGISTRAL")
	private BigDecimal sedeRegistral;

	//bi-directional many-to-one association to DetPerInmExp
	@ManyToOne
	@JoinColumn(name="INMUEBLE")
	private DetPerInmExp expDetPerInmExp;

	//bi-directional many-to-one association to DetPerVehExp
	@ManyToOne
	@JoinColumn(name="VEHICULO")
	private DetPerVehExp expDetPerVehExp;

	//bi-directional many-to-one association to Informe
	@ManyToOne
	@JoinColumn(name="INFORME")
	private Informe infInforme;

	public TituloRegistral() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getEstadoTramite() {
		return estadoTramite;
	}

	public void setEstadoTramite(BigDecimal estadoTramite) {
		this.estadoTramite = estadoTramite;
	}

	public Timestamp getFechaSeguimiento() {
		return fechaSeguimiento;
	}

	public void setFechaSeguimiento(Timestamp fechaSeguimiento) {
		this.fechaSeguimiento = fechaSeguimiento;
	}

	public Timestamp getFechaTermino() {
		return fechaTermino;
	}

	public void setFechaTermino(Timestamp fechaTermino) {
		this.fechaTermino = fechaTermino;
	}

	public Timestamp getFechaTitulo() {
		return fechaTitulo;
	}

	public void setFechaTitulo(Timestamp fechaTitulo) {
		this.fechaTitulo = fechaTitulo;
	}

	public String getNroTitulo() {
		return nroTitulo;
	}

	public void setNroTitulo(String nroTitulo) {
		this.nroTitulo = nroTitulo;
	}

	public BigDecimal getSedeRegistral() {
		return sedeRegistral;
	}

	public void setSedeRegistral(BigDecimal sedeRegistral) {
		this.sedeRegistral = sedeRegistral;
	}

	public DetPerInmExp getExpDetPerInmExp() {
		return expDetPerInmExp;
	}

	public void setExpDetPerInmExp(DetPerInmExp expDetPerInmExp) {
		this.expDetPerInmExp = expDetPerInmExp;
	}

	public DetPerVehExp getExpDetPerVehExp() {
		return expDetPerVehExp;
	}

	public void setExpDetPerVehExp(DetPerVehExp expDetPerVehExp) {
		this.expDetPerVehExp = expDetPerVehExp;
	}

	public Informe getInfInforme() {
		return infInforme;
	}

	public void setInfInforme(Informe infInforme) {
		this.infInforme = infInforme;
	}

}