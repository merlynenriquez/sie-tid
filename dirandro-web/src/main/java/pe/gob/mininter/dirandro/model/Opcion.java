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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import pe.gob.mininter.dirandro.util.Validador;
import pe.gob.mininter.dirandro.util.beanbase.AuditoriaBean;


/**
 * The persistent class for the SEG_OPCION database table.
 * 
 */
@Entity
@Table(name="SEG_OPCION")
public class Opcion extends AuditoriaBean implements Validador, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8954847423695023225L;

	@Id
	@SequenceGenerator(name="SEG_OPCION_ID_GENERATOR", sequenceName="SEQ_")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEG_OPCION_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=8)
	private Long id;

	@Column(nullable=false, length=30)
	private String codigo;

	@Column(length=500)
	private String descripcion;

	@Column(nullable=false, length=100)
	private String nombre;

	@Column(precision=8)
	private BigDecimal orden;

	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="TIPO", nullable=false)
	private Valor tipo;

	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="ESTADO")
	private Valor estado;

	//bi-directional many-to-one association to Opcion
	@ManyToOne
	@JoinColumn(name="PADRE")
	private Opcion padre;

	@Transient
	private List<Opcion> acciones;


	public Opcion() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public BigDecimal getOrden() {
		return orden;
	}

	public void setOrden(BigDecimal orden) {
		this.orden = orden;
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

	public Opcion getPadre() {
		return padre;
	}

	public void setPadre(Opcion padre) {
		this.padre = padre;
	}

	public List<Opcion> getAcciones() {
		return acciones;
	}

	public void setAcciones(List<Opcion> acciones) {
		this.acciones = acciones;
	}

	@Override
	public void validar() {
		// TODO Auto-generated method stub
		
	}

}