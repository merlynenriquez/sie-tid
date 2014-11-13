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
	private Informe informe;

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

	public Informe getInforme() {
		return informe;
	}

	public void setInforme(Informe informe) {
		this.informe = informe;
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
		ValorEspecie other = (ValorEspecie) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}