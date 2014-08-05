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
 * The persistent class for the CFG_VALOR database table.
 * 
 */
@Entity
@Table(name="CFG_VALOR")
public class Valor extends AuditoriaBean implements Validador, Serializable {
	
	private static final long serialVersionUID = 6480705418606133868L;

	@Id
	@SequenceGenerator(name="CFG_VALOR_ID_GENERATOR", sequenceName="SEQ_")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CFG_VALOR_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=16)
	private Long id;

	@Column(nullable=false, length=30)
	private String codigo;

	@Column(length=500)
	private String descripcion;
	
	@Column(length=2)
	private String estado;

	@Column(nullable=false, length=100)
	private String nombre;

	@Column(precision=8)
	private BigDecimal orden;
 
	//bi-directional many-to-one association to Lista
	@ManyToOne
	@JoinColumn(name="LISTA", nullable=false)
	private Lista lista;

	public Valor() {
		
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
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

	public BigDecimal getOrden() {
		return orden;
	}

	public void setOrden(BigDecimal orden) {
		this.orden = orden;
	}

	public Lista getLista() {
		return lista;
	}

	public void setLista(Lista lista) {
		this.lista = lista;
	}
	
	@Override
	public void validar() {
		// TODO Auto-generated method stub
		
	}
}