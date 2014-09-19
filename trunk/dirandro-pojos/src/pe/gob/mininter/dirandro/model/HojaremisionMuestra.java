package pe.gob.mininter.dirandro.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.math.BigDecimal;


/**
 * The persistent class for the HR_HOJAREMISION_MUESTRA database table.
 * 
 */
@Entity
@Table(name="HR_HOJAREMISION_MUESTRA")
public class HojaremisionMuestra implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="HR_HOJAREMISION_MUESTRA_ID_GENERATOR", sequenceName="SEQ_")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="HR_HOJAREMISION_MUESTRA_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=16)
	private long id;

	@Column(name="CAN_PESO_ANALISIS", precision=10, scale=2)
	private BigDecimal canPesoAnalisis;

	@Column(name="CAN_PESO_BRUTO", precision=10, scale=2)
	private BigDecimal canPesoBruto;

	@Column(name="CAN_PESO_DEVUELTO", precision=10, scale=2)
	private BigDecimal canPesoDevuelto;

	@Column(name="CAN_PESO_NETO", precision=10, scale=2)
	private BigDecimal canPesoNeto;

	@Column(precision=5)
	private BigDecimal cantidad;

	private Timestamp creacion;

	@Column(length=400)
	private String descripcion;

	private Timestamp edicion;

	//bi-directional many-to-one association to Droga
	@ManyToOne
	@JoinColumn(name="DROGAS")
	private Droga expDroga;

	//bi-directional many-to-one association to Especie
	@ManyToOne
	@JoinColumn(name="ESPECIE")
	private Especie expEspecie;

	//bi-directional many-to-one association to Hojaremision
	@ManyToOne
	@JoinColumn(name="HOJAREMISION")
	private Hojaremision hrHojaremision;

	//bi-directional many-to-one association to ModeloMarca
	@ManyToOne
	@JoinColumn(name="TIPO_MEDIDA")
	private ModeloMarca mntModeloMarca;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="EDITOR")
	private Usuario segUsuario1;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="CREADOR")
	private Usuario segUsuario2;

	public HojaremisionMuestra() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public BigDecimal getCanPesoAnalisis() {
		return this.canPesoAnalisis;
	}

	public void setCanPesoAnalisis(BigDecimal canPesoAnalisis) {
		this.canPesoAnalisis = canPesoAnalisis;
	}

	public BigDecimal getCanPesoBruto() {
		return this.canPesoBruto;
	}

	public void setCanPesoBruto(BigDecimal canPesoBruto) {
		this.canPesoBruto = canPesoBruto;
	}

	public BigDecimal getCanPesoDevuelto() {
		return this.canPesoDevuelto;
	}

	public void setCanPesoDevuelto(BigDecimal canPesoDevuelto) {
		this.canPesoDevuelto = canPesoDevuelto;
	}

	public BigDecimal getCanPesoNeto() {
		return this.canPesoNeto;
	}

	public void setCanPesoNeto(BigDecimal canPesoNeto) {
		this.canPesoNeto = canPesoNeto;
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

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Timestamp getEdicion() {
		return this.edicion;
	}

	public void setEdicion(Timestamp edicion) {
		this.edicion = edicion;
	}

	public Droga getExpDroga() {
		return this.expDroga;
	}

	public void setExpDroga(Droga expDroga) {
		this.expDroga = expDroga;
	}

	public Especie getExpEspecie() {
		return this.expEspecie;
	}

	public void setExpEspecie(Especie expEspecie) {
		this.expEspecie = expEspecie;
	}

	public Hojaremision getHrHojaremision() {
		return this.hrHojaremision;
	}

	public void setHrHojaremision(Hojaremision hrHojaremision) {
		this.hrHojaremision = hrHojaremision;
	}

	public ModeloMarca getMntModeloMarca() {
		return this.mntModeloMarca;
	}

	public void setMntModeloMarca(ModeloMarca mntModeloMarca) {
		this.mntModeloMarca = mntModeloMarca;
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

}