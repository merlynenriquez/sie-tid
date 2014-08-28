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
import javax.persistence.Transient;

import org.apache.commons.lang.StringUtils;

import pe.gob.mininter.dirandro.util.Validador;
import pe.gob.mininter.dirandro.util.beanbase.AuditoriaBean;


/**
 * The persistent class for the SEG_USUARIO database table.
 * 
 */
@Entity
@Table(name="SEG_USUARIO")
public class Usuario extends AuditoriaBean implements Validador, Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SEG_USUARIO_ID_GENERATOR", sequenceName="SEQ_USUARIO")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEG_USUARIO_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=16)
	private Long id;

	@Column(name="APE_MAT", length=400)
	private String apeMat;

	@Column(name="APE_PAT", length=400)
	private String apePat;

	@Column(length=100)
	private String cargo;

	@Column(nullable=false, length=512)
	private String clave;

	@Column(name="DESC_CARGO", length=100)
	private String descCargo;

	@Column(length=400)
	private String nombres;

	@Column(nullable=false, length=20)
	private String usuario;

	//bi-directional many-to-one association to Dependencia
	@ManyToOne
	@JoinColumn(name="OFICINA")
	private Dependencia oficina;

	//bi-directional many-to-one association to Policia
	@ManyToOne
	@JoinColumn(name="POLICIA")
	private Policia policia;

	//bi-directional many-to-one association to Rol
	@ManyToOne
	@JoinColumn(name="ROL")
	private Rol rol;
	
	@Transient
	private String terminal;

	public Usuario() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getApeMat() {
		return apeMat;
	}

	public void setApeMat(String apeMat) {
		this.apeMat = apeMat;
	}

	public String getApePat() {
		return apePat;
	}

	public void setApePat(String apePat) {
		this.apePat = apePat;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getDescCargo() {
		return descCargo;
	}

	public void setDescCargo(String descCargo) {
		this.descCargo = descCargo;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public Dependencia getOficina() {
		return oficina;
	}

	public void setOficina(Dependencia oficina) {
		this.oficina = oficina;
	}
	
	public Policia getPolicia() {
		return policia;
	}

	public void setPolicia(Policia policia) {
		this.policia = policia;
	}

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	public String getTerminal() {
		return terminal;
	}

	public void setTerminal(String terminal) {
		this.terminal = terminal;
	}

	@Override
	public void validar() {
		// TODO Auto-generated method stub
		
	}

	@Transient
	public String getNombreCompleto() {
		return StringUtils.join(new Object[]{nombres, apePat, apeMat}, " ");
		
	}
 
}