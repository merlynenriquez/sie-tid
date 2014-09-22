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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import pe.gob.mininter.dirandro.util.Validador;
import pe.gob.mininter.dirandro.util.beanbase.AuditoriaBean;


/**
 * The persistent class for the HR_HOJAREMISION_MUESTRA database table.
 * 
 */
@Entity
@Table(name="HR_HOJAREMISION_MUESTRA")
public class HojaremisionMuestra extends AuditoriaBean implements Validador, Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6116438175392487199L;

	@Id
	@SequenceGenerator(name="HR_HOJAREMISION_MUESTRA_ID_GENERATOR", sequenceName="SEQ_", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="HR_HOJAREMISION_MUESTRA_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=16)
	private Long id;

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

	@Column(length=400)
	private String descripcion;

	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="TIPO_MEDIDA")
	private ModeloMarca tipoMedida;

	//bi-directional many-to-one association to Droga
	@ManyToOne
	@JoinColumn(name="DROGAS")
	private Droga droga;

	//bi-directional many-to-one association to Especie
	@ManyToOne
	@JoinColumn(name="ESPECIE")
	private Especie especie;

	//bi-directional many-to-one association to Hojaremision
	@ManyToOne
	@JoinColumn(name="HOJAREMISION")
	private Hojaremision hojaRemision;

	public HojaremisionMuestra() {
	
	}
	
	public boolean esNuevo(){
		return id == null || id.longValue() == 0;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getCanPesoAnalisis() {
		return canPesoAnalisis;
	}

	public void setCanPesoAnalisis(BigDecimal canPesoAnalisis) {
		this.canPesoAnalisis = canPesoAnalisis;
	}

	public BigDecimal getCanPesoBruto() {
		return canPesoBruto;
	}

	public void setCanPesoBruto(BigDecimal canPesoBruto) {
		this.canPesoBruto = canPesoBruto;
	}

	public BigDecimal getCanPesoDevuelto() {
		return canPesoDevuelto;
	}

	public void setCanPesoDevuelto(BigDecimal canPesoDevuelto) {
		this.canPesoDevuelto = canPesoDevuelto;
	}

	public BigDecimal getCanPesoNeto() {
		return canPesoNeto;
	}

	public void setCanPesoNeto(BigDecimal canPesoNeto) {
		this.canPesoNeto = canPesoNeto;
	}

	public BigDecimal getCantidad() {
		return cantidad;
	}

	public void setCantidad(BigDecimal cantidad) {
		this.cantidad = cantidad;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public ModeloMarca getTipoMedida() {
		return tipoMedida;
	}

	public void setTipoMedida(ModeloMarca tipoMedida) {
		this.tipoMedida = tipoMedida;
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

	public Hojaremision getHojaRemision() {
		return hojaRemision;
	}

	public void setHojaRemision(Hojaremision hojaRemision) {
		this.hojaRemision = hojaRemision;
	}

	@Override
	public void validar() {
		// TODO Auto-generated method stub
		
	}

}