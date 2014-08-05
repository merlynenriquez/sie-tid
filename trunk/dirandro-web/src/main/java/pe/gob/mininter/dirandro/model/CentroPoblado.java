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
 * The persistent class for the EXP_CENTRO_POBLADO database table.
 * 
 */
@Entity
@Table(name="EXP_CENTRO_POBLADO")
public class CentroPoblado extends AuditoriaBean implements Validador, Serializable {

	private static final long serialVersionUID = -510486200814174107L;

	@Id
	@SequenceGenerator(name="EXP_CENTRO_POBLADO_ID_GENERATOR", sequenceName="SEQ_")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="EXP_CENTRO_POBLADO_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=16)
	private Long id;

	@Column(nullable=false, length=400)
	private String nombre;

	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="CATEGORIA")
	private Valor cfgValor;

	//bi-directional many-to-one association to Distrito
	@ManyToOne
	@JoinColumn(name="DISTRITO")
	private Distrito ubgDistrito;

	//bi-directional many-to-one association to Expediente
	@OneToMany(mappedBy="expCentroPoblado")
	private List<Expediente> expExpedientes;

	//bi-directional many-to-one association to Instalacion
	@OneToMany(mappedBy="expCentroPoblado")
	private List<Instalacion> expInstalacions;

	public CentroPoblado() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Valor getCfgValor() {
		return this.cfgValor;
	}

	public void setCfgValor(Valor cfgValor) {
		this.cfgValor = cfgValor;
	}

	public Distrito getUbgDistrito() {
		return this.ubgDistrito;
	}

	public void setUbgDistrito(Distrito ubgDistrito) {
		this.ubgDistrito = ubgDistrito;
	}

	public List<Expediente> getExpExpedientes() {
		return this.expExpedientes;
	}

	public void setExpExpedientes(List<Expediente> expExpedientes) {
		this.expExpedientes = expExpedientes;
	}

	public Expediente addExpExpediente(Expediente expExpediente) {
		getExpExpedientes().add(expExpediente);
		expExpediente.setExpCentroPoblado(this);

		return expExpediente;
	}

	public Expediente removeExpExpediente(Expediente expExpediente) {
		getExpExpedientes().remove(expExpediente);
		expExpediente.setExpCentroPoblado(null);

		return expExpediente;
	}

	public List<Instalacion> getExpInstalacions() {
		return this.expInstalacions;
	}

	public void setExpInstalacions(List<Instalacion> expInstalacions) {
		this.expInstalacions = expInstalacions;
	}

	public Instalacion addExpInstalacion(Instalacion expInstalacion) {
		getExpInstalacions().add(expInstalacion);
		expInstalacion.setExpCentroPoblado(this);

		return expInstalacion;
	}

	public Instalacion removeExpInstalacion(Instalacion expInstalacion) {
		getExpInstalacions().remove(expInstalacion);
		expInstalacion.setExpCentroPoblado(null);

		return expInstalacion;
	}

	@Override
	public void validar() {
		// TODO Auto-generated method stub
		
	}

}