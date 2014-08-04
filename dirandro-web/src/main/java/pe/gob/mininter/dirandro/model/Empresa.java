package pe.gob.mininter.dirandro.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the PER_EMPRESA database table.
 * 
 */
@Entity
@Table(name="PER_EMPRESA")
public class Empresa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="PER_EMPRESA_ID_GENERATOR", sequenceName="SEQ_")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PER_EMPRESA_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=16)
	private long id;

	@Column(nullable=false)
	private Timestamp creacion;

	@Column(nullable=false, length=1000)
	private String direccion;

	private Timestamp edicion;

	@Column(name="PARTIDA_REGISTRAL", length=100)
	private String partidaRegistral;

	@Column(name="RAZON_SOCIAL", nullable=false, length=800)
	private String razonSocial;

	@Column(length=22)
	private String ruc;

	@Column(length=60)
	private String telefono;

	//bi-directional many-to-one association to DetExpedientePersona
	@OneToMany(mappedBy="perEmpresa")
	private List<DetExpedientePersona> expDetExpedientePersonas;

	//bi-directional many-to-one association to DetPerArmExp
	@OneToMany(mappedBy="perEmpresa")
	private List<DetPerArmExp> expDetPerArmExps;

	//bi-directional many-to-one association to Explosivo
	@OneToMany(mappedBy="perEmpresa")
	private List<Explosivo> expExplosivos;

	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="ESTADO", nullable=false)
	private Valor cfgValor;

	//bi-directional many-to-one association to Persona
	@ManyToOne
	@JoinColumn(name="REPRESENTANTE")
	private Persona perPersona;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="CREADOR", nullable=false)
	private Usuario segUsuario1;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="EDITOR")
	private Usuario segUsuario2;

	public Empresa() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Timestamp getCreacion() {
		return this.creacion;
	}

	public void setCreacion(Timestamp creacion) {
		this.creacion = creacion;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Timestamp getEdicion() {
		return this.edicion;
	}

	public void setEdicion(Timestamp edicion) {
		this.edicion = edicion;
	}

	public String getPartidaRegistral() {
		return this.partidaRegistral;
	}

	public void setPartidaRegistral(String partidaRegistral) {
		this.partidaRegistral = partidaRegistral;
	}

	public String getRazonSocial() {
		return this.razonSocial;
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}

	public String getRuc() {
		return this.ruc;
	}

	public void setRuc(String ruc) {
		this.ruc = ruc;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public List<DetExpedientePersona> getExpDetExpedientePersonas() {
		return this.expDetExpedientePersonas;
	}

	public void setExpDetExpedientePersonas(List<DetExpedientePersona> expDetExpedientePersonas) {
		this.expDetExpedientePersonas = expDetExpedientePersonas;
	}

	public DetExpedientePersona addExpDetExpedientePersona(DetExpedientePersona expDetExpedientePersona) {
		getExpDetExpedientePersonas().add(expDetExpedientePersona);
		expDetExpedientePersona.setPerEmpresa(this);

		return expDetExpedientePersona;
	}

	public DetExpedientePersona removeExpDetExpedientePersona(DetExpedientePersona expDetExpedientePersona) {
		getExpDetExpedientePersonas().remove(expDetExpedientePersona);
		expDetExpedientePersona.setPerEmpresa(null);

		return expDetExpedientePersona;
	}

	public List<DetPerArmExp> getExpDetPerArmExps() {
		return this.expDetPerArmExps;
	}

	public void setExpDetPerArmExps(List<DetPerArmExp> expDetPerArmExps) {
		this.expDetPerArmExps = expDetPerArmExps;
	}

	public DetPerArmExp addExpDetPerArmExp(DetPerArmExp expDetPerArmExp) {
		getExpDetPerArmExps().add(expDetPerArmExp);
		expDetPerArmExp.setPerEmpresa(this);

		return expDetPerArmExp;
	}

	public DetPerArmExp removeExpDetPerArmExp(DetPerArmExp expDetPerArmExp) {
		getExpDetPerArmExps().remove(expDetPerArmExp);
		expDetPerArmExp.setPerEmpresa(null);

		return expDetPerArmExp;
	}

	public List<Explosivo> getExpExplosivos() {
		return this.expExplosivos;
	}

	public void setExpExplosivos(List<Explosivo> expExplosivos) {
		this.expExplosivos = expExplosivos;
	}

	public Explosivo addExpExplosivo(Explosivo expExplosivo) {
		getExpExplosivos().add(expExplosivo);
		expExplosivo.setPerEmpresa(this);

		return expExplosivo;
	}

	public Explosivo removeExpExplosivo(Explosivo expExplosivo) {
		getExpExplosivos().remove(expExplosivo);
		expExplosivo.setPerEmpresa(null);

		return expExplosivo;
	}

	public Valor getCfgValor() {
		return this.cfgValor;
	}

	public void setCfgValor(Valor cfgValor) {
		this.cfgValor = cfgValor;
	}

	public Persona getPerPersona() {
		return this.perPersona;
	}

	public void setPerPersona(Persona perPersona) {
		this.perPersona = perPersona;
	}

	public Usuario getSegUsuario1() {
		return this.segUsuario1;
	}

	public void setSegUsuario1(Usuario segUsuario1) {
		this.segUsuario1 = segUsuario1;
	}

	public Usuario getSegUsuario2() {
		return this.segUsuario2;
	}

	public void setSegUsuario2(Usuario segUsuario2) {
		this.segUsuario2 = segUsuario2;
	}

}