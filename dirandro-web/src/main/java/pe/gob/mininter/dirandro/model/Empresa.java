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
 * The persistent class for the PER_EMPRESA database table.
 * 
 */
@Entity
@Table(name="PER_EMPRESA")
public class Empresa extends AuditoriaBean implements Validador, Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1481913729291306868L;

	@Id
	@SequenceGenerator(name="PER_EMPRESA_ID_GENERATOR", sequenceName="SEQ_")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PER_EMPRESA_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=16)
	private Long id;
	
	@Column(nullable=false, length=1000)
	private String direccion;

	@Column(name="PARTIDA_REGISTRAL", length=100)
	private String partidaRegistral;

	@Column(name="RAZON_SOCIAL", nullable=false, length=800)
	private String razonSocial;

	@Column(length=22)
	private String ruc;

	@Column(length=60)
	private String telefono;

	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="ESTADO", nullable=false)
	private Valor estado;

	//bi-directional many-to-one association to Persona
	@ManyToOne
	@JoinColumn(name="REPRESENTANTE")
	private Persona perPersona;

	public Empresa() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getPartidaRegistral() {
		return partidaRegistral;
	}

	public void setPartidaRegistral(String partidaRegistral) {
		this.partidaRegistral = partidaRegistral;
	}

	public String getRazonSocial() {
		return razonSocial;
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}

	public String getRuc() {
		return ruc;
	}

	public void setRuc(String ruc) {
		this.ruc = ruc;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Valor getEstado() {
		return estado;
	}

	public void setEstado(Valor estado) {
		this.estado = estado;
	}

	public Persona getPerPersona() {
		return perPersona;
	}

	public void setPerPersona(Persona perPersona) {
		this.perPersona = perPersona;
	}

	@Override
	public void validar() {
		// TODO Auto-generated method stub
		
	}
 
}