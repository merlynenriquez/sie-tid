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
 * The persistent class for the EXP_ESPECIE database table.
 * 
 */
@Entity
@Table(name="EXP_ESPECIE")
public class Especie extends AuditoriaBean implements Validador, Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5910148998744477152L;

	@Id
	@SequenceGenerator(name="EXP_ESPECIE_ID_GENERATOR", sequenceName="SEQ_")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="EXP_ESPECIE_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=16)
	private Long id;

	@Column(precision=10, scale=4)
	private BigDecimal medida;

	@Column(length=400)
	private String nombre;

	@Column(length=50)
	private String serie;

	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="ESTADO")
	private Valor estado;

	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="TIPO_MEDIDA")
	private Valor tipoMedida;

	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="SITUACION")
	private Valor situacion;

	//bi-directional many-to-one association to Expediente
	@ManyToOne
	@JoinColumn(name="EXPEDIENTE")
	private Expediente expExpediente;

	//bi-directional many-to-one association to TipoEspecie
	@ManyToOne
	@JoinColumn(name="TIPO_ESPECIE")
	private TipoEspecie mntTipoEspecie;

	//bi-directional many-to-one association to HojaremisionMuestra
	@OneToMany(mappedBy="expEspecie")
	private List<HojaremisionMuestra> hrHojaremisionMuestras;

	public Especie() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getMedida() {
		return medida;
	}

	public void setMedida(BigDecimal medida) {
		this.medida = medida;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getSerie() {
		return serie;
	}

	public void setSerie(String serie) {
		this.serie = serie;
	}

	public Valor getEstado() {
		return estado;
	}

	public void setEstado(Valor estado) {
		this.estado = estado;
	}

	public Valor getTipoMedida() {
		return tipoMedida;
	}

	public void setTipoMedida(Valor tipoMedida) {
		this.tipoMedida = tipoMedida;
	}

	public Valor getSituacion() {
		return situacion;
	}

	public void setSituacion(Valor situacion) {
		this.situacion = situacion;
	}

	public Expediente getExpExpediente() {
		return expExpediente;
	}

	public void setExpExpediente(Expediente expExpediente) {
		this.expExpediente = expExpediente;
	}

	public TipoEspecie getMntTipoEspecie() {
		return mntTipoEspecie;
	}

	public void setMntTipoEspecie(TipoEspecie mntTipoEspecie) {
		this.mntTipoEspecie = mntTipoEspecie;
	}

	public List<HojaremisionMuestra> getHrHojaremisionMuestras() {
		return hrHojaremisionMuestras;
	}

	public void setHrHojaremisionMuestras(
			List<HojaremisionMuestra> hrHojaremisionMuestras) {
		this.hrHojaremisionMuestras = hrHojaremisionMuestras;
	}

	@Override
	public void validar() {
		// TODO Auto-generated method stub
		
	}
 
}