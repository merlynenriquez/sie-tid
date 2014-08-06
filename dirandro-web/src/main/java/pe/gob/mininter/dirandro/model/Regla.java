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
 * The persistent class for the CFG_REGLA database table.
 * 
 */
@Entity
@Table(name="CFG_REGLA")
public class Regla extends AuditoriaBean implements Validador, Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3017272614624214486L;

	@Id
	@SequenceGenerator(name="CFG_REGLA_ID_GENERATOR", sequenceName="SEQ_")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CFG_REGLA_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=16)
	private Long id;

	@Column(nullable=false, length=20)
	private String codigo;

	@Column(nullable=false, length=200)
	private String nombre;

	@Column(nullable=false, length=4000)
	private String regla;

	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="TIPO_REGLA", nullable=false)
	private Valor tipoRegla;

	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="ESTADO", nullable=false)
	private Valor estado;

	public Regla() {
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

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getRegla() {
		return regla;
	}

	public void setRegla(String regla) {
		this.regla = regla;
	}

	public Valor getTipoRegla() {
		return tipoRegla;
	}

	public void setTipoRegla(Valor tipoRegla) {
		this.tipoRegla = tipoRegla;
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