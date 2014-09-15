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
 * The persistent class for the EXP_MUNICIONES database table.
 * TODO falta relacionarla en le modelo entidad relacion.
 */
@Entity
@Table(name="EXP_MUNICIONES")
public class Municion extends AuditoriaBean implements Validador, Serializable {
	
	private static final long serialVersionUID = 5539914583114696827L;

	@Id
	@SequenceGenerator(name="EXP_MUNICIONES_ID_GENERATOR", sequenceName="SEQ_MUNICION", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="EXP_MUNICIONES_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=16)
	private Long id;

	@Column(length=500)
	private String descripcion;

	//@Column(name="EMPRESA_PROPIETARIA", precision=16)
//	private BigDecimal empresaPropietaria;

	@Column(precision=10, scale=4)
	private BigDecimal medida;

	@Column(length=2000)
	private String observacion;
	
	@Column(precision=7)
	private Integer cantidad;

	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="TIPO")
	private Valor tipo;

	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="ESTADO")
	private Valor estado;

	//bi-directional many-to-one association to Expediente
	@ManyToOne
	@JoinColumn(name="EXPEDIENTE")
	private Expediente expediente;

	//bi-directional many-to-one association to ModeloMarca
	@ManyToOne
	@JoinColumn(name="MARCA")
	private ModeloMarca marca;

	//bi-directional many-to-one association to Empresa
	@ManyToOne
	@JoinColumn(name="EMPRESA")
	private Empresa empresaImplicada;

	//bi-directional many-to-one association to Persona
	@ManyToOne
	@JoinColumn(name="PERSONA")
	private Persona personaImplicada;
	
	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="CALIBRE")
	private Valor calibre;

	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="SITUACION")
	private Valor situacion;

	public Municion() {
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

//	public BigDecimal getEmpresaPropietaria() {
//		return empresaPropietaria;
//	}

//	public void setEmpresaPropietaria(BigDecimal empresaPropietaria) {
//		this.empresaPropietaria = empresaPropietaria;
//	}

	public BigDecimal getMedida() {
		return medida;
	}

	public void setMedida(BigDecimal medida) {
		this.medida = medida;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
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

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public Expediente getExpediente() {
		return expediente;
	}

	public void setExpediente(Expediente expediente) {
		this.expediente = expediente;
	}

	public ModeloMarca getMarca() {
		return marca;
	}

	public void setMarca(ModeloMarca marca) {
		this.marca = marca;
	}

	public Empresa getEmpresaImplicada() {
		return empresaImplicada;
	}

	public void setEmpresaImplicada(Empresa empresaImplicada) {
		this.empresaImplicada = empresaImplicada;
	}

	public Persona getPersonaImplicada() {
		return personaImplicada;
	}

	public void setPersonaImplicada(Persona personaImplicada) {
		this.personaImplicada = personaImplicada;
	}

	public Valor getCalibre() {
		return calibre;
	}

	public void setCalibre(Valor calibre) {
		this.calibre = calibre;
	}

	public Valor getSituacion() {
		return situacion;
	}

	public void setSituacion(Valor situacion) {
		this.situacion = situacion;
	}

	@Override
	public void validar() {
		// TODO Auto-generated method stub
		
	}

}