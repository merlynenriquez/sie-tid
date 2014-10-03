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
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import pe.gob.mininter.dirandro.util.Constante;
import pe.gob.mininter.dirandro.util.beanbase.AuditoriaBean;


/**
 * The persistent class for the EXP_INMUEBLE database table.
 * 
 */
@Entity
@Table(name="EXP_INMUEBLE")
public class Inmueble extends AuditoriaBean implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5949075490786538492L;

	@Id
	@SequenceGenerator(name="EXP_INMUEBLE_ID_GENERATOR", sequenceName="SEQ_INMUEBLE", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="EXP_INMUEBLE_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=16)
	private Long id;

	@Column(length=2000)
	@NotBlank(message=Constante.CODIGO_MENSAJE.VALIDAR_TEXTBOX)
	private String descripcion;

	@Column(precision=10, scale=2)
	private BigDecimal dimension;

	@Column(length=1000)
	@NotBlank(message=Constante.CODIGO_MENSAJE.VALIDAR_TEXTBOX)
	private String direccion;

	@Column(length=100)
	private String latitud;

	@Column(length=100)
	private String longitud;

	@Column(name="NRO_INSCRIPCION", length=100)
	private String nroInscripcion;

	@Column(length=2000)
	private String observaciones;

	@Column(name="OFICINA_REGISTRAL", length=2000)
	private String oficinaRegistral;

	@Column(length=400)
	private String resolucion;

	@Column(length=400)
	@NotBlank(message=Constante.CODIGO_MENSAJE.VALIDAR_TEXTBOX)
	private String urbanizacion;

	@Column(name="VALOR_BIEN", precision=10, scale=2)
	private Double valorBien;

	@Column(name="VALOR_TERRENO", precision=10, scale=2)
	private Double valorTerreno;

	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="TIPO_DIRECCION")
	@NotNull(message=Constante.CODIGO_MENSAJE.VALIDAR_COMBOBOX)
	private Valor tipoDireccion;

	//bi-directional many-to-one association to Distrito
	@ManyToOne
	@JoinColumn(name="UBICACION")
	@NotNull(message=Constante.CODIGO_MENSAJE.VALIDAR_COMBOBOX)
	private Distrito ubgDistrito;

	public Inmueble() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public BigDecimal getDimension() {
		return dimension;
	}

	public void setDimension(BigDecimal dimension) {
		this.dimension = dimension;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getLatitud() {
		return latitud;
	}

	public void setLatitud(String latitud) {
		this.latitud = latitud;
	}

	public String getLongitud() {
		return longitud;
	}

	public void setLongitud(String longitud) {
		this.longitud = longitud;
	}

	public String getNroInscripcion() {
		return nroInscripcion;
	}

	public void setNroInscripcion(String nroInscripcion) {
		this.nroInscripcion = nroInscripcion;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public String getOficinaRegistral() {
		return oficinaRegistral;
	}

	public void setOficinaRegistral(String oficinaRegistral) {
		this.oficinaRegistral = oficinaRegistral;
	}

	public String getResolucion() {
		return resolucion;
	}

	public void setResolucion(String resolucion) {
		this.resolucion = resolucion;
	}

	public String getUrbanizacion() {
		return urbanizacion;
	}

	public void setUrbanizacion(String urbanizacion) {
		this.urbanizacion = urbanizacion;
	}

	public Valor getTipoDireccion() {
		return tipoDireccion;
	}

	public void setTipoDireccion(Valor tipoDireccion) {
		this.tipoDireccion = tipoDireccion;
	}

	public Distrito getUbgDistrito() {
		return ubgDistrito;
	}

	public void setUbgDistrito(Distrito ubgDistrito) {
		this.ubgDistrito = ubgDistrito;
	}

	public Double getValorBien() {
		return valorBien;
	}

	public void setValorBien(Double valorBien) {
		this.valorBien = valorBien;
	}

	public Double getValorTerreno() {
		return valorTerreno;
	}

	public void setValorTerreno(Double valorTerreno) {
		this.valorTerreno = valorTerreno;
	}
/*
	@Override
	public void validar() {
		if(StringUtils.isBlank( this.descripcion ))
		{
			throw new ValidacionException(Constante.CODIGO_MENSAJE.VALIDAR_TEXTBOX, new Object[]{"Descripción"});
		}
		if(StringUtils.isBlank( this.direccion ))
		{
			throw new ValidacionException(Constante.CODIGO_MENSAJE.VALIDAR_TEXTBOX, new Object[]{"Dirección"});
		}
		if ( this.ubgDistrito == null || this.ubgDistrito.getId() == null) {
			throw new ValidacionException(Constante.CODIGO_MENSAJE.VALIDAR_COMBOBOX, new Object[] { "Distrito" });
		}
	}

*/
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
		Inmueble other = (Inmueble) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}