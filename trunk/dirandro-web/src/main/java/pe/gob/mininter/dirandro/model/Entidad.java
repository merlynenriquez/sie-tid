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
 * The persistent class for the EXP_ENTIDAD database table.
 * 
 */
@Entity
@Table(name="EXP_ENTIDAD")
public class Entidad extends AuditoriaBean implements Validador, Serializable {
	 
	/**
	 * 
	 */
	private static final long serialVersionUID = -5180147514012281821L;

	@Id
	@SequenceGenerator(name="EXP_ENTIDAD_ID_GENERATOR", sequenceName="SEQ_")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="EXP_ENTIDAD_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=16)
	private Long id;

	@Column(length=400)
	private String correo;

	@Column(length=2000)
	private String descripcion;

	@Column(length=600)
	private String direccion;

	@Column(precision=6)
	private BigDecimal dirtepol;

	@Column(length=1000)
	private String nombre;

	@Column(length=400)
	private String telefono;

	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="TIPO")
	private Valor tipo;

	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="ESTADO")
	private Valor estado;

	//bi-directional many-to-one association to Distrito
	@ManyToOne
	@JoinColumn(name="DISTRITO")
	private Distrito ubgDistrito;

	public Entidad() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public BigDecimal getDirtepol() {
		return dirtepol;
	}

	public void setDirtepol(BigDecimal dirtepol) {
		this.dirtepol = dirtepol;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
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

	public Distrito getUbgDistrito() {
		return ubgDistrito;
	}

	public void setUbgDistrito(Distrito ubgDistrito) {
		this.ubgDistrito = ubgDistrito;
	}

	@Override
	public void validar() {
		// TODO Auto-generated method stub
		
	}

}