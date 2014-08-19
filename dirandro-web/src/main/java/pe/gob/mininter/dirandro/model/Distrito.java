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
 * The persistent class for the UBG_DISTRITO database table.
 * 
 */
@Entity
@Table(name="UBG_DISTRITO")
public class Distrito extends AuditoriaBean implements Validador, Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4436282812752985025L;

	@Id
	@SequenceGenerator(name="UBG_DISTRITO_ID_GENERATOR", sequenceName="SEQ_")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="UBG_DISTRITO_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=16)
	private Long id;

	@Column(name="CODIGO_HOST", length=14)
	private String codigoHost;

	@Column(nullable=false, length=100)
	private String nombre;
	
	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="ESTADO")
	private Valor estado;

	//bi-directional many-to-one association to Provincia
	@ManyToOne
	@JoinColumn(name="PROVINCIA", nullable=false)
	private Provincia ubgProvincia;

	public Distrito() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCodigoHost() {
		return codigoHost;
	}

	public void setCodigoHost(String codigoHost) {
		this.codigoHost = codigoHost;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Provincia getUbgProvincia() {
		return ubgProvincia;
	}

	public void setUbgProvincia(Provincia ubgProvincia) {
		this.ubgProvincia = ubgProvincia;
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