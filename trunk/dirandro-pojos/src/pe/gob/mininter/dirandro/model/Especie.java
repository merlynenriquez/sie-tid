package pe.gob.mininter.dirandro.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the EXP_ESPECIE database table.
 * 
 */
@Entity
@Table(name="EXP_ESPECIE")
public class Especie implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="EXP_ESPECIE_ID_GENERATOR", sequenceName="SEQ_")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="EXP_ESPECIE_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=16)
	private long id;

	@Column(precision=10)
	private BigDecimal cantidad;

	@Column(nullable=false)
	private Timestamp creacion;

	private Timestamp edicion;

	@Column(precision=10, scale=4)
	private BigDecimal medida;

	@Column(length=400)
	private String nombre;

	@Column(length=50)
	private String serie;

	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="ESTADO")
	private Valor cfgValor1;

	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="TIPO_MEDIDA")
	private Valor cfgValor2;

	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="SITUACION")
	private Valor cfgValor3;

	//bi-directional many-to-one association to Expediente
	@ManyToOne
	@JoinColumn(name="EXPEDIENTE")
	private Expediente expExpediente;

	//bi-directional many-to-one association to ModeloMarca
	@ManyToOne
	@JoinColumn(name="TIPO_MEDIDA")
	private ModeloMarca mntModeloMarca;

	//bi-directional many-to-one association to TipoEspecie
	@ManyToOne
	@JoinColumn(name="TIPO_ESPECIE")
	private TipoEspecie mntTipoEspecie;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="EDITOR")
	private Usuario segUsuario1;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="CREADOR", nullable=false)
	private Usuario segUsuario2;

	//bi-directional many-to-one association to HojaremisionMuestra
	@OneToMany(mappedBy="expEspecie")
	private List<HojaremisionMuestra> hrHojaremisionMuestras;

	public Especie() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public BigDecimal getCantidad() {
		return this.cantidad;
	}

	public void setCantidad(BigDecimal cantidad) {
		this.cantidad = cantidad;
	}

	public Timestamp getCreacion() {
		return this.creacion;
	}

	public void setCreacion(Timestamp creacion) {
		this.creacion = creacion;
	}

	public Timestamp getEdicion() {
		return this.edicion;
	}

	public void setEdicion(Timestamp edicion) {
		this.edicion = edicion;
	}

	public BigDecimal getMedida() {
		return this.medida;
	}

	public void setMedida(BigDecimal medida) {
		this.medida = medida;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getSerie() {
		return this.serie;
	}

	public void setSerie(String serie) {
		this.serie = serie;
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

	public Expediente getExpExpediente() {
		return this.expExpediente;
	}

	public void setExpExpediente(Expediente expExpediente) {
		this.expExpediente = expExpediente;
	}

	public ModeloMarca getMntModeloMarca() {
		return this.mntModeloMarca;
	}

	public void setMntModeloMarca(ModeloMarca mntModeloMarca) {
		this.mntModeloMarca = mntModeloMarca;
	}

	public TipoEspecie getMntTipoEspecie() {
		return this.mntTipoEspecie;
	}

	public void setMntTipoEspecie(TipoEspecie mntTipoEspecie) {
		this.mntTipoEspecie = mntTipoEspecie;
	}

	public Usuario getSegUsuario1() {
		return this.segUsuario1;
	}

	public void setSegUsuario1(Usuario segUsuario1) {
		this.segUsuario1 = segUsuario1;
	}

	public Usuario getSegUsuario2() {
		return this.segUsuario2;
	}

	public void setSegUsuario2(Usuario segUsuario2) {
		this.segUsuario2 = segUsuario2;
	}

	public List<HojaremisionMuestra> getHrHojaremisionMuestras() {
		return this.hrHojaremisionMuestras;
	}

	public void setHrHojaremisionMuestras(List<HojaremisionMuestra> hrHojaremisionMuestras) {
		this.hrHojaremisionMuestras = hrHojaremisionMuestras;
	}

	public HojaremisionMuestra addHrHojaremisionMuestra(HojaremisionMuestra hrHojaremisionMuestra) {
		getHrHojaremisionMuestras().add(hrHojaremisionMuestra);
		hrHojaremisionMuestra.setExpEspecie(this);

		return hrHojaremisionMuestra;
	}

	public HojaremisionMuestra removeHrHojaremisionMuestra(HojaremisionMuestra hrHojaremisionMuestra) {
		getHrHojaremisionMuestras().remove(hrHojaremisionMuestra);
		hrHojaremisionMuestra.setExpEspecie(null);

		return hrHojaremisionMuestra;
	}

}