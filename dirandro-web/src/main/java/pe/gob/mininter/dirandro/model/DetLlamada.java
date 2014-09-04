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

import pe.gob.mininter.dirandro.util.Validador;
import pe.gob.mininter.dirandro.util.beanbase.AuditoriaBean;


/**
 * The persistent class for the EXP_DET_LLAMADAS database table.
 * 
 */
@Entity
@Table(name="EXP_DET_LLAMADAS")
public class DetLlamada extends AuditoriaBean implements Validador, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8318376794022766132L;

	@Id
	@SequenceGenerator(name="EXP_DET_LLAMADAS_ID_GENERATOR", sequenceName="SEQ_", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="EXP_DET_LLAMADAS_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=16)
	private Long id;

	@Column(precision=10)
	private BigDecimal duracion;

	@Column(name="FECHA_HORA")
	private Timestamp fechaHora;

	@Column(name="NUMERO_MARCADO", length=50)
	private String numeroMarcado;
	
	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="TIPO_LLAMADA")
	private Valor tipoLlamada;

	//bi-directional many-to-one association to DetPerTelExp
	@ManyToOne
	@JoinColumn(name="EXP_PER_TEL")
	private DetPerTelExp expDetPerTelExp;


	public DetLlamada() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getDuracion() {
		return this.duracion;
	}

	public void setDuracion(BigDecimal duracion) {
		this.duracion = duracion;
	}

	public Timestamp getFechaHora() {
		return this.fechaHora;
	}

	public void setFechaHora(Timestamp fechaHora) {
		this.fechaHora = fechaHora;
	}

	public String getNumeroMarcado() {
		return this.numeroMarcado;
	}

	public void setNumeroMarcado(String numeroMarcado) {
		this.numeroMarcado = numeroMarcado;
	}

	public DetPerTelExp getExpDetPerTelExp() {
		return this.expDetPerTelExp;
	}

	public void setExpDetPerTelExp(DetPerTelExp expDetPerTelExp) {
		this.expDetPerTelExp = expDetPerTelExp;
	}

	public Valor getTipoLlamada() {
		return tipoLlamada;
	}

	public void setTipoLlamada(Valor tipoLlamada) {
		this.tipoLlamada = tipoLlamada;
	}

	@Override
	public void validar() {
		// TODO Auto-generated method stub
		
	}

}