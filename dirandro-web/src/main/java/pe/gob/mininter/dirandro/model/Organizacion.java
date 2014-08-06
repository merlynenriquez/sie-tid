package pe.gob.mininter.dirandro.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import pe.gob.mininter.dirandro.util.Validador;
import pe.gob.mininter.dirandro.util.beanbase.AuditoriaBean;


/**
 * The persistent class for the EXP_ORGANIZACION database table.
 * 
 */
@Entity
@Table(name="EXP_ORGANIZACION")
public class Organizacion extends AuditoriaBean implements Validador, Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1911787099919273558L;

	@Id
	@SequenceGenerator(name="EXP_ORGANIZACION_ID_GENERATOR", sequenceName="SEQ_")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="EXP_ORGANIZACION_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=16)
	private Long id;

	@Column(length=700)
	private String campo;

	@Column(length=300)
	private String descripcion;

	@Column(length=300)
	private String nombre;

	@Column(name="NRO_INTEGRANTES", precision=5)
	private BigDecimal nroIntegrantes;

	@Column(name="UBICACION_ACTIVOS", length=500)
	private String ubicacionActivos;

	@Column(name="ZONA_OPERACION", length=500)
	private String zonaOperacion;

	//bi-directional many-to-one association to DetExpedientePersona
	@OneToMany(mappedBy="expOrganizacion")
	private List<DetExpedientePersona> expDetExpedientePersonas;

	//bi-directional many-to-one association to Instalacion
	@OneToMany(mappedBy="expOrganizacion")
	private List<Instalacion> expInstalacions;

	public Organizacion() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCampo() {
		return campo;
	}

	public void setCampo(String campo) {
		this.campo = campo;
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

	public BigDecimal getNroIntegrantes() {
		return nroIntegrantes;
	}

	public void setNroIntegrantes(BigDecimal nroIntegrantes) {
		this.nroIntegrantes = nroIntegrantes;
	}

	public String getUbicacionActivos() {
		return ubicacionActivos;
	}

	public void setUbicacionActivos(String ubicacionActivos) {
		this.ubicacionActivos = ubicacionActivos;
	}

	public String getZonaOperacion() {
		return zonaOperacion;
	}

	public void setZonaOperacion(String zonaOperacion) {
		this.zonaOperacion = zonaOperacion;
	}

	public List<DetExpedientePersona> getExpDetExpedientePersonas() {
		return expDetExpedientePersonas;
	}

	public void setExpDetExpedientePersonas(
			List<DetExpedientePersona> expDetExpedientePersonas) {
		this.expDetExpedientePersonas = expDetExpedientePersonas;
	}

	public List<Instalacion> getExpInstalacions() {
		return expInstalacions;
	}

	public void setExpInstalacions(List<Instalacion> expInstalacions) {
		this.expInstalacions = expInstalacions;
	}

	@Override
	public void validar() {
		// TODO Auto-generated method stub
		
	}


}