package pe.gob.mininter.dirandro.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import pe.gob.mininter.dirandro.exception.ValidacionException;
import pe.gob.mininter.dirandro.util.Constante;
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
	@SequenceGenerator(name="CFG_VALOR_ID_GENERATOR", sequenceName="SEQ_VALOR")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CFG_VALOR_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=16)
	private Long id;

	@Column(nullable=false, length=30)
	private String codigo;

	@Column(length=500)
	private String descripcion;
	
	@Column(nullable=false, length=2)
	private String estado;

	@Column(nullable=false, length=100)
	private String nombre;

	@Column(precision=8)
	private Integer orden;

	//bi-directional many-to-one association to Lista
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="LISTA", nullable=false)
	private Lista lista;
	
	public Valor() {
	}
	
	public Valor(Long id) {
		this.id = id;
	}
	
	public Valor(Lista lista) {
		this.lista = lista;
	}
	
	public Valor(String codigo) {
		this.codigo = codigo;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCodigo() {
		return this.codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getOrden() {
		return this.orden;
	}

	public void setOrden(Integer orden) {
		this.orden = orden;
	}

	public Lista getLista() {
		return lista;
	}

	public void setLista(Lista lista) {
		this.lista = lista;
	}
	
	@Override
	public int hashCode() {
		HashCodeBuilder hashCodeBuilder = new HashCodeBuilder(3, 7);
		hashCodeBuilder.append(id);
		return hashCodeBuilder.toHashCode();
	}

	@Override
	public boolean equals(Object obj) {
		boolean equals = false;
		if (obj instanceof Valor) {
			Valor bean = (Valor) obj;
			equals = (new EqualsBuilder().append(id, bean.id)).isEquals();
		}
		return equals;
	}

	@Override
	public void validar() {
		if(StringUtils.isBlank(codigo))
		{
			throw new ValidacionException(Constante.CODIGO_MENSAJE.VALIDAR_TEXTBOX, new Object[]{"Código"});
		}
		if(StringUtils.isBlank(nombre))
		{
			throw new ValidacionException(Constante.CODIGO_MENSAJE.VALIDAR_TEXTBOX, new Object[]{"Nombre"});
		}
		if(StringUtils.isBlank(estado))
		{
			throw new ValidacionException(Constante.CODIGO_MENSAJE.VALIDAR_COMBOBOX, new Object[]{"Valor"});
		}
		if(lista == null || lista.getId() == null)
		{
			throw new ValidacionException(Constante.CODIGO_MENSAJE.VALIDAR_COMBOBOX, new Object[]{"Estado"});
		}
	}	
}