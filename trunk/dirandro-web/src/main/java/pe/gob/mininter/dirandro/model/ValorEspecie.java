package pe.gob.mininter.dirandro.model;

import java.io.Serializable;

import javax.persistence.*;

import pe.gob.mininter.dirandro.util.beanbase.AuditoriaBean;

import java.sql.Timestamp;
import java.math.BigDecimal;


/**
 * The persistent class for the INF_VALOR_ESPECIE database table.
 * 
 */
@Entity
@Table(name="INF_VALOR_ESPECIE")
public class ValorEspecie extends AuditoriaBean implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="INF_VALOR_ESPECIE_ID_GENERATOR", sequenceName="SEQ_INF_VALOR_ESPECIE")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="INF_VALOR_ESPECIE_ID_GENERATOR")
	private Long id;

	@Column(name="ESTRUCTURA_PERICIAL")
	private BigDecimal estructuraPericial;

	private Timestamp fechavalor;

	private BigDecimal valor;

	//bi-directional many-to-one association to Droga
	@ManyToOne
	@JoinColumn(name="DROGA")
	private Droga droga;

	//bi-directional many-to-one association to Especie
	@ManyToOne
	@JoinColumn(name="ESPECIE")
	private Especie especie;

	//bi-directional many-to-one association to Informe
	@ManyToOne
	@JoinColumn(name="INFORME")
	private Informe infInforme;

	public ValorEspecie() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getEstructuraPericial() {
		return estructuraPericial;
	}

	public void setEstructuraPericial(BigDecimal estructuraPericial) {
		this.estructuraPericial = estructuraPericial;
	}

	public Timestamp getFechavalor() {
		return fechavalor;
	}

	public void setFechavalor(Timestamp fechavalor) {
		this.fechavalor = fechavalor;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public Droga getDroga() {
		return droga;
	}

	public void setDroga(Droga droga) {
		this.droga = droga;
	}

	public Especie getEspecie() {
		return especie;
	}

	public void setEspecie(Especie especie) {
		this.especie = especie;
	}

	public Informe getInfInforme() {
		return infInforme;
	}

	public void setInfInforme(Informe infInforme) {
		this.infInforme = infInforme;
	}
	
	
}