package pe.gob.mininter.dirandro.model;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

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
 * The persistent class for the SEG_ROL database table.
 * 
 */
@Entity
@Table(name="SEG_ROL")
public class Rol extends AuditoriaBean implements Validador, Serializable {

	private static final long serialVersionUID = 4748951542756910651L;

	@Id
	@SequenceGenerator(name="SEG_ROL_ID_GENERATOR", sequenceName="SEQ_")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEG_ROL_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=8)
	private Long id;

	@Column(length=20)
	private String codigo;

	@Column(length=500)
	private String descripcion;

	@Column(length=100)
	private String nombre;

	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="ESTADO", nullable=false)
	private Valor estado;

	//bi-directional many-to-one association to Rol
	@ManyToOne
	@JoinColumn(name="PADRE")
	private Rol padre;
	
	@Transient
	private Map<String, List<Opcion>> opciones;
	
/*
	//bi-directional many-to-one association to Rol
	@OneToMany(mappedBy="segRol")
	private List<Rol> segRols;

	//bi-directional many-to-one association to Permiso
		@OneToMany(mappedBy="segRol")
		private List<Permiso> segPermisos;
*/
	public Rol() {
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
	public Valor getEstado() {
		return estado;
	}
	public void setEstado(Valor estado) {
		this.estado = estado;
	}
	public Rol getPadre() {
		return padre;
	}
	public void setPadre(Rol padre) {
		this.padre = padre;
	}
	public Map<String, List<Opcion>> getOpciones() {
		return opciones;
	}
	public void setOpciones(Map<String, List<Opcion>> opciones) {
		this.opciones = opciones;
	}
	@Override
	public void validar() {
		// TODO Auto-generated method stub
		
	}
 
}