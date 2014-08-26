package pe.gob.mininter.dirandro.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import pe.gob.mininter.dirandro.util.Validador;
import pe.gob.mininter.dirandro.util.beanbase.AuditoriaBean;


/**
 * The persistent class for the CFG_LISTA database table.
 * 
 */
@Entity
@Table(name="CFG_LISTA")
public class Lista extends AuditoriaBean implements Validador, Serializable {
	
	private static final long serialVersionUID = -8943186992102390415L;

	@Id
	@SequenceGenerator(name="CFG_LISTA_ID_GENERATOR", sequenceName="SEQ_LISTA")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CFG_LISTA_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=8)
	private Long id;

	@Column(nullable=false, length=30)
	private String codigo;

	@Column(length=500)
	private String descripcion;

	@Column(nullable=false, length=2)
	private String estado;

	@Column(nullable=false, length=100)
	private String nombre;

 
	public Lista() {
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

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public void validar() {
		// TODO Auto-generated method stub
		
	}
}