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
 * The persistent class for the CFG_PARAMETRO database table.
 * 
 */
@Entity
@Table(name="CFG_PARAMETRO")
public class Parametro extends AuditoriaBean implements Validador, Serializable {

	private static final long serialVersionUID = 2585331288022926733L;

	@Id
	@SequenceGenerator(name="CFG_PARAMETRO_CODIGO_GENERATOR", sequenceName="SEQ_")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CFG_PARAMETRO_CODIGO_GENERATOR")
	@Column(unique=true, nullable=false, length=30)
	private String codigo;

	@Column(length=500)
	private String descripcion;

	@Column(nullable=false, length=100)
	private String nombre;

	@Column(nullable=false, length=1000)
	private String valor;

	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="ESTADO", nullable=false)
	private Valor cfgValor;

	public Parametro() {
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

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getValor() {
		return this.valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public Valor getCfgValor() {
		return this.cfgValor;
	}

	public void setCfgValor(Valor cfgValor) {
		this.cfgValor = cfgValor;
	}

	@Override
	public void validar() {
		// TODO Auto-generated method stub
		
	}

}