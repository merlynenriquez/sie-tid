package pe.gob.mininter.dirandro.model;

import java.io.Serializable;
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
 * The persistent class for the UBG_PROVINCIA database table.
 * 
 */
@Entity
@Table(name="UBG_PROVINCIA")
public class Provincia extends AuditoriaBean implements Validador, Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3456939825042360460L;

	@Id
	@SequenceGenerator(name="UBG_PROVINCIA_ID_GENERATOR", sequenceName="SEQ_")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="UBG_PROVINCIA_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=16)
	private Long id;

	@Column(nullable=false, length=100)
	private String nombre;

	//bi-directional many-to-one association to Distrito
	@OneToMany(mappedBy="ubgProvincia")
	private List<Distrito> ubgDistritos;
	
	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="ESTADO")
	private Valor estado;

	//bi-directional many-to-one association to Departamento
	@ManyToOne
	@JoinColumn(name="DEPARTAMENTO", nullable=false)
	private Departamento ubgDepartamento;

	public Provincia() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Distrito> getUbgDistritos() {
		return ubgDistritos;
	}

	public void setUbgDistritos(List<Distrito> ubgDistritos) {
		this.ubgDistritos = ubgDistritos;
	}

	public Departamento getUbgDepartamento() {
		return ubgDepartamento;
	}

	public void setUbgDepartamento(Departamento ubgDepartamento) {
		this.ubgDepartamento = ubgDepartamento;
	}

	public Valor getEstado() {
		return estado;
	}

	public void setEstado(Valor estado) {
		this.estado = estado;
	}

	@Override
	public void validar() {
		// TODO Auto-generated method stub
		
	}

}