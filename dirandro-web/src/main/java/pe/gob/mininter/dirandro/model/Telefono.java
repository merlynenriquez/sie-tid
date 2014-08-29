package pe.gob.mininter.dirandro.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import pe.gob.mininter.dirandro.util.Validador;
import pe.gob.mininter.dirandro.util.beanbase.AuditoriaBean;


/**
 * The persistent class for the PER_TELEFONO database table.
 * 
 */
@Entity
@Table(name="PER_TELEFONO")
public class Telefono extends AuditoriaBean implements Validador, Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2382445968562609353L;

	@Id
	@SequenceGenerator(name="PER_TELEFONO_ID_GENERATOR", sequenceName="SEQ_", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PER_TELEFONO_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=16)
	private Long id;

	@Column(length=50)
	private String alcance;

	@Column(precision=16)
	private BigDecimal frecuencia;

	@Column(nullable=false, length=100)
	private String numero;

	@Column(length=50)
	private String serie;

	//bi-directional many-to-one association to DetPerTelExp
	@OneToMany(mappedBy="perTelefono")
	private List<DetPerTelExp> expDetPerTelExps;

	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="TIPO", nullable=false)
	private Valor tipo;

	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="ESTADO")
	private Valor estado;

	//bi-directional many-to-one association to ModeloMarca
	@ManyToOne
	@JoinColumn(name="MARCA")
	private ModeloMarca mntModeloMarca;

	public Telefono() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAlcance() {
		return alcance;
	}

	public void setAlcance(String alcance) {
		this.alcance = alcance;
	}

	public BigDecimal getFrecuencia() {
		return frecuencia;
	}

	public void setFrecuencia(BigDecimal frecuencia) {
		this.frecuencia = frecuencia;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getSerie() {
		return serie;
	}

	public void setSerie(String serie) {
		this.serie = serie;
	}

	public List<DetPerTelExp> getExpDetPerTelExps() {
		return expDetPerTelExps;
	}

	public void setExpDetPerTelExps(List<DetPerTelExp> expDetPerTelExps) {
		this.expDetPerTelExps = expDetPerTelExps;
	}

	public Valor getTipo() {
		return tipo;
	}

	public void setTipo(Valor tipo) {
		this.tipo = tipo;
	}

	public Valor getEstado() {
		return estado;
	}

	public void setEstado(Valor estado) {
		this.estado = estado;
	}

	public ModeloMarca getMntModeloMarca() {
		return mntModeloMarca;
	}

	public void setMntModeloMarca(ModeloMarca mntModeloMarca) {
		this.mntModeloMarca = mntModeloMarca;
	}

	@Override
	public void validar() {
		// TODO Auto-generated method stub
		
	}

}