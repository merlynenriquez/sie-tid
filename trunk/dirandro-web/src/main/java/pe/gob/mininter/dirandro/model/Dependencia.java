package pe.gob.mininter.dirandro.model;

import java.io.Serializable;

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
 * The persistent class for the EXP_DEPENDENCIA database table.
 * La clase persistente para la tabla EXP_DEPENDENCIA de base de datos 
 */
@Entity
@Table(name="EXP_DEPENDENCIA")
public class Dependencia extends AuditoriaBean implements Validador, Serializable {
	
	private static final long serialVersionUID = -5926061859511311124L;

	@Id
	@SequenceGenerator(name="EXP_DEPENDENCIA_ID_GENERATOR", sequenceName="SEQ_", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="EXP_DEPENDENCIA_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=16)
	private Long id;

	@Column(length=2000)
	private String abreviatura;

	@Column(length=30)
	private String codigo;

	@Column(length=600)
	private String direccion;

	@Column(length=2000)
	private String nombre;

	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="SIGLA")
	private Valor sigla;

	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="ESTADO")
	private Valor estado;

	//bi-directional many-to-one association to Dependencia
	@ManyToOne
	@JoinColumn(name="PADRE")
	private Dependencia padre;

	public Dependencia() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAbreviatura() {
		return this.abreviatura;
	}

	public void setAbreviatura(String abreviatura) {
		this.abreviatura = abreviatura;
	}

	public String getCodigo() {
		return this.codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public Valor getSigla() {
		return sigla;
	}

	public void setSigla(Valor sigla) {
		this.sigla = sigla;
	}

	public Valor getEstado() {
		return estado;
	}

	public void setEstado(Valor estado) {
		this.estado = estado;
	}

	public Dependencia getPadre() {
		return padre;
	}

	public void setPadre(Dependencia padre) {
		this.padre = padre;
	}

	@Override
	public void validar() {
		// TODO Auto-generated method stub
		
	}

}