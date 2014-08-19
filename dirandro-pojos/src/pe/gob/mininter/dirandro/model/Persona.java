package pe.gob.mininter.dirandro.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the PER_PERSONA database table.
 * 
 */
@Entity
@Table(name="PER_PERSONA")
public class Persona implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="PER_PERSONA_ID_GENERATOR", sequenceName="SEQ_")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PER_PERSONA_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=16)
	private long id;

	@Column(name="APE_MATERNO", length=200)
	private String apeMaterno;

	@Column(name="APE_PATERNO", length=200)
	private String apePaterno;

	@Column(nullable=false)
	private Timestamp creacion;

	private Timestamp edicion;

	@Temporal(TemporalType.DATE)
	@Column(name="FEC_NACIMIENTO")
	private Date fecNacimiento;

	@Column(length=300)
	private String nombres;

	@Column(name="NRO_DOCUMENTO", length=40)
	private String nroDocumento;

	@Column(length=2)
	private String sexo;

	//bi-directional many-to-one association to DetDroga
	@OneToMany(mappedBy="perPersona")
	private List<DetDroga> expDetDrogas;

	//bi-directional many-to-one association to DetExpedientePersona
	@OneToMany(mappedBy="perPersona")
	private List<DetExpedientePersona> expDetExpedientePersonas;

	//bi-directional many-to-one association to DetPerArmExp
	@OneToMany(mappedBy="perPersona1")
	private List<DetPerArmExp> expDetPerArmExps1;

	//bi-directional many-to-one association to DetPerArmExp
	@OneToMany(mappedBy="perPersona2")
	private List<DetPerArmExp> expDetPerArmExps2;

	//bi-directional many-to-one association to DetPerTelExp
	@OneToMany(mappedBy="perPersona1")
	private List<DetPerTelExp> expDetPerTelExps1;

	//bi-directional many-to-one association to DetPerTelExp
	@OneToMany(mappedBy="perPersona2")
	private List<DetPerTelExp> expDetPerTelExps2;

	//bi-directional many-to-one association to DetPerVehExp
	@OneToMany(mappedBy="perPersona")
	private List<DetPerVehExp> expDetPerVehExps;

	//bi-directional many-to-one association to Explosivo
	@OneToMany(mappedBy="perPersona1")
	private List<Explosivo> expExplosivos1;

	//bi-directional many-to-one association to Explosivo
	@OneToMany(mappedBy="perPersona2")
	private List<Explosivo> expExplosivos2;

	//bi-directional many-to-one association to Municione
	@OneToMany(mappedBy="perPersona")
	private List<Municione> expMuniciones;

	//bi-directional many-to-one association to Hojaremision
	@OneToMany(mappedBy="perPersona")
	private List<Hojaremision> hrHojaremisions;

	//bi-directional many-to-one association to Correo
	@OneToMany(mappedBy="perPersona")
	private List<Correo> perCorreos;

	//bi-directional many-to-one association to Detalle
	@OneToMany(mappedBy="perPersona")
	private List<Detalle> perDetalles;

	//bi-directional many-to-one association to Direccion
	@OneToMany(mappedBy="perPersona")
	private List<Direccion> perDireccions;

	//bi-directional many-to-one association to Empresa
	@OneToMany(mappedBy="perPersona")
	private List<Empresa> perEmpresas;

	//bi-directional many-to-one association to Identificacion
	@OneToMany(mappedBy="perPersona")
	private List<Identificacion> perIdentificacions;

	//bi-directional many-to-one association to Imagen
	@OneToMany(mappedBy="perPersona")
	private List<Imagen> perImagens;

	//bi-directional many-to-one association to Letrado
	@OneToMany(mappedBy="perPersona")
	private List<Letrado> perLetrados;

	//bi-directional many-to-one association to NoIdentificado
	@OneToMany(mappedBy="perPersona")
	private List<NoIdentificado> perNoIdentificados;

	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="ORIENTACION_SEXUAL")
	private Valor cfgValor1;

	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="ESTADO_CIVIL")
	private Valor cfgValor2;

	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="TIPO_DOCUMENTO")
	private Valor cfgValor3;

	//bi-directional one-to-one association to Pais
	@OneToOne
	@JoinColumn(name="ID", nullable=false, insertable=false, updatable=false)
	private Pais mntPais;

	//bi-directional many-to-one association to Persona
	@ManyToOne
	@JoinColumn(name="PERSONA")
	private Persona perPersona;

	//bi-directional many-to-one association to Persona
	@OneToMany(mappedBy="perPersona")
	private List<Persona> perPersonas;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="CREADOR", nullable=false)
	private Usuario segUsuario1;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="EDITOR")
	private Usuario segUsuario2;

	//bi-directional many-to-one association to Distrito
	@ManyToOne
	@JoinColumn(name="LUGAR_NACIMIENTO")
	private Distrito ubgDistrito;

	//bi-directional many-to-one association to Policia
	@OneToMany(mappedBy="perPersona")
	private List<Policia> perPolicias;

	//bi-directional many-to-one association to PerParentesco
	@OneToMany(mappedBy="perPersona1")
	private List<Parentesco> perParentescos1;

	//bi-directional many-to-one association to PerParentesco
	@OneToMany(mappedBy="perPersona2")
	private List<Parentesco> perParentescos2;

	public Persona() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getApeMaterno() {
		return this.apeMaterno;
	}

	public void setApeMaterno(String apeMaterno) {
		this.apeMaterno = apeMaterno;
	}

	public String getApePaterno() {
		return this.apePaterno;
	}

	public void setApePaterno(String apePaterno) {
		this.apePaterno = apePaterno;
	}

	public Timestamp getCreacion() {
		return this.creacion;
	}

	public void setCreacion(Timestamp creacion) {
		this.creacion = creacion;
	}

	public Timestamp getEdicion() {
		return this.edicion;
	}

	public void setEdicion(Timestamp edicion) {
		this.edicion = edicion;
	}

	public Date getFecNacimiento() {
		return this.fecNacimiento;
	}

	public void setFecNacimiento(Date fecNacimiento) {
		this.fecNacimiento = fecNacimiento;
	}

	public String getNombres() {
		return this.nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getNroDocumento() {
		return this.nroDocumento;
	}

	public void setNroDocumento(String nroDocumento) {
		this.nroDocumento = nroDocumento;
	}

	public String getSexo() {
		return this.sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public List<DetDroga> getExpDetDrogas() {
		return this.expDetDrogas;
	}

	public void setExpDetDrogas(List<DetDroga> expDetDrogas) {
		this.expDetDrogas = expDetDrogas;
	}

	public DetDroga addExpDetDroga(DetDroga expDetDroga) {
		getExpDetDrogas().add(expDetDroga);
		expDetDroga.setPerPersona(this);

		return expDetDroga;
	}

	public DetDroga removeExpDetDroga(DetDroga expDetDroga) {
		getExpDetDrogas().remove(expDetDroga);
		expDetDroga.setPerPersona(null);

		return expDetDroga;
	}

	public List<DetExpedientePersona> getExpDetExpedientePersonas() {
		return this.expDetExpedientePersonas;
	}

	public void setExpDetExpedientePersonas(List<DetExpedientePersona> expDetExpedientePersonas) {
		this.expDetExpedientePersonas = expDetExpedientePersonas;
	}

	public DetExpedientePersona addExpDetExpedientePersona(DetExpedientePersona expDetExpedientePersona) {
		getExpDetExpedientePersonas().add(expDetExpedientePersona);
		expDetExpedientePersona.setPerPersona(this);

		return expDetExpedientePersona;
	}

	public DetExpedientePersona removeExpDetExpedientePersona(DetExpedientePersona expDetExpedientePersona) {
		getExpDetExpedientePersonas().remove(expDetExpedientePersona);
		expDetExpedientePersona.setPerPersona(null);

		return expDetExpedientePersona;
	}

	public List<DetPerArmExp> getExpDetPerArmExps1() {
		return this.expDetPerArmExps1;
	}

	public void setExpDetPerArmExps1(List<DetPerArmExp> expDetPerArmExps1) {
		this.expDetPerArmExps1 = expDetPerArmExps1;
	}

	public DetPerArmExp addExpDetPerArmExps1(DetPerArmExp expDetPerArmExps1) {
		getExpDetPerArmExps1().add(expDetPerArmExps1);
		expDetPerArmExps1.setPerPersona1(this);

		return expDetPerArmExps1;
	}

	public DetPerArmExp removeExpDetPerArmExps1(DetPerArmExp expDetPerArmExps1) {
		getExpDetPerArmExps1().remove(expDetPerArmExps1);
		expDetPerArmExps1.setPerPersona1(null);

		return expDetPerArmExps1;
	}

	public List<DetPerArmExp> getExpDetPerArmExps2() {
		return this.expDetPerArmExps2;
	}

	public void setExpDetPerArmExps2(List<DetPerArmExp> expDetPerArmExps2) {
		this.expDetPerArmExps2 = expDetPerArmExps2;
	}

	public DetPerArmExp addExpDetPerArmExps2(DetPerArmExp expDetPerArmExps2) {
		getExpDetPerArmExps2().add(expDetPerArmExps2);
		expDetPerArmExps2.setPerPersona2(this);

		return expDetPerArmExps2;
	}

	public DetPerArmExp removeExpDetPerArmExps2(DetPerArmExp expDetPerArmExps2) {
		getExpDetPerArmExps2().remove(expDetPerArmExps2);
		expDetPerArmExps2.setPerPersona2(null);

		return expDetPerArmExps2;
	}

	public List<DetPerTelExp> getExpDetPerTelExps1() {
		return this.expDetPerTelExps1;
	}

	public void setExpDetPerTelExps1(List<DetPerTelExp> expDetPerTelExps1) {
		this.expDetPerTelExps1 = expDetPerTelExps1;
	}

	public DetPerTelExp addExpDetPerTelExps1(DetPerTelExp expDetPerTelExps1) {
		getExpDetPerTelExps1().add(expDetPerTelExps1);
		expDetPerTelExps1.setPerPersona1(this);

		return expDetPerTelExps1;
	}

	public DetPerTelExp removeExpDetPerTelExps1(DetPerTelExp expDetPerTelExps1) {
		getExpDetPerTelExps1().remove(expDetPerTelExps1);
		expDetPerTelExps1.setPerPersona1(null);

		return expDetPerTelExps1;
	}

	public List<DetPerTelExp> getExpDetPerTelExps2() {
		return this.expDetPerTelExps2;
	}

	public void setExpDetPerTelExps2(List<DetPerTelExp> expDetPerTelExps2) {
		this.expDetPerTelExps2 = expDetPerTelExps2;
	}

	public DetPerTelExp addExpDetPerTelExps2(DetPerTelExp expDetPerTelExps2) {
		getExpDetPerTelExps2().add(expDetPerTelExps2);
		expDetPerTelExps2.setPerPersona2(this);

		return expDetPerTelExps2;
	}

	public DetPerTelExp removeExpDetPerTelExps2(DetPerTelExp expDetPerTelExps2) {
		getExpDetPerTelExps2().remove(expDetPerTelExps2);
		expDetPerTelExps2.setPerPersona2(null);

		return expDetPerTelExps2;
	}

	public List<DetPerVehExp> getExpDetPerVehExps() {
		return this.expDetPerVehExps;
	}

	public void setExpDetPerVehExps(List<DetPerVehExp> expDetPerVehExps) {
		this.expDetPerVehExps = expDetPerVehExps;
	}

	public DetPerVehExp addExpDetPerVehExp(DetPerVehExp expDetPerVehExp) {
		getExpDetPerVehExps().add(expDetPerVehExp);
		expDetPerVehExp.setPerPersona(this);

		return expDetPerVehExp;
	}

	public DetPerVehExp removeExpDetPerVehExp(DetPerVehExp expDetPerVehExp) {
		getExpDetPerVehExps().remove(expDetPerVehExp);
		expDetPerVehExp.setPerPersona(null);

		return expDetPerVehExp;
	}

	public List<Explosivo> getExpExplosivos1() {
		return this.expExplosivos1;
	}

	public void setExpExplosivos1(List<Explosivo> expExplosivos1) {
		this.expExplosivos1 = expExplosivos1;
	}

	public Explosivo addExpExplosivos1(Explosivo expExplosivos1) {
		getExpExplosivos1().add(expExplosivos1);
		expExplosivos1.setPerPersona1(this);

		return expExplosivos1;
	}

	public Explosivo removeExpExplosivos1(Explosivo expExplosivos1) {
		getExpExplosivos1().remove(expExplosivos1);
		expExplosivos1.setPerPersona1(null);

		return expExplosivos1;
	}

	public List<Explosivo> getExpExplosivos2() {
		return this.expExplosivos2;
	}

	public void setExpExplosivos2(List<Explosivo> expExplosivos2) {
		this.expExplosivos2 = expExplosivos2;
	}

	public Explosivo addExpExplosivos2(Explosivo expExplosivos2) {
		getExpExplosivos2().add(expExplosivos2);
		expExplosivos2.setPerPersona2(this);

		return expExplosivos2;
	}

	public Explosivo removeExpExplosivos2(Explosivo expExplosivos2) {
		getExpExplosivos2().remove(expExplosivos2);
		expExplosivos2.setPerPersona2(null);

		return expExplosivos2;
	}

	public List<Municione> getExpMuniciones() {
		return this.expMuniciones;
	}

	public void setExpMuniciones(List<Municione> expMuniciones) {
		this.expMuniciones = expMuniciones;
	}

	public Municione addExpMunicione(Municione expMunicione) {
		getExpMuniciones().add(expMunicione);
		expMunicione.setPerPersona(this);

		return expMunicione;
	}

	public Municione removeExpMunicione(Municione expMunicione) {
		getExpMuniciones().remove(expMunicione);
		expMunicione.setPerPersona(null);

		return expMunicione;
	}

	public List<Hojaremision> getHrHojaremisions() {
		return this.hrHojaremisions;
	}

	public void setHrHojaremisions(List<Hojaremision> hrHojaremisions) {
		this.hrHojaremisions = hrHojaremisions;
	}

	public Hojaremision addHrHojaremision(Hojaremision hrHojaremision) {
		getHrHojaremisions().add(hrHojaremision);
		hrHojaremision.setPerPersona(this);

		return hrHojaremision;
	}

	public Hojaremision removeHrHojaremision(Hojaremision hrHojaremision) {
		getHrHojaremisions().remove(hrHojaremision);
		hrHojaremision.setPerPersona(null);

		return hrHojaremision;
	}

	public List<Correo> getPerCorreos() {
		return this.perCorreos;
	}

	public void setPerCorreos(List<Correo> perCorreos) {
		this.perCorreos = perCorreos;
	}

	public Correo addPerCorreo(Correo perCorreo) {
		getPerCorreos().add(perCorreo);
		perCorreo.setPerPersona(this);

		return perCorreo;
	}

	public Correo removePerCorreo(Correo perCorreo) {
		getPerCorreos().remove(perCorreo);
		perCorreo.setPerPersona(null);

		return perCorreo;
	}

	public List<Detalle> getPerDetalles() {
		return this.perDetalles;
	}

	public void setPerDetalles(List<Detalle> perDetalles) {
		this.perDetalles = perDetalles;
	}

	public Detalle addPerDetalle(Detalle perDetalle) {
		getPerDetalles().add(perDetalle);
		perDetalle.setPerPersona(this);

		return perDetalle;
	}

	public Detalle removePerDetalle(Detalle perDetalle) {
		getPerDetalles().remove(perDetalle);
		perDetalle.setPerPersona(null);

		return perDetalle;
	}

	public List<Direccion> getPerDireccions() {
		return this.perDireccions;
	}

	public void setPerDireccions(List<Direccion> perDireccions) {
		this.perDireccions = perDireccions;
	}

	public Direccion addPerDireccion(Direccion perDireccion) {
		getPerDireccions().add(perDireccion);
		perDireccion.setPerPersona(this);

		return perDireccion;
	}

	public Direccion removePerDireccion(Direccion perDireccion) {
		getPerDireccions().remove(perDireccion);
		perDireccion.setPerPersona(null);

		return perDireccion;
	}

	public List<Empresa> getPerEmpresas() {
		return this.perEmpresas;
	}

	public void setPerEmpresas(List<Empresa> perEmpresas) {
		this.perEmpresas = perEmpresas;
	}

	public Empresa addPerEmpresa(Empresa perEmpresa) {
		getPerEmpresas().add(perEmpresa);
		perEmpresa.setPerPersona(this);

		return perEmpresa;
	}

	public Empresa removePerEmpresa(Empresa perEmpresa) {
		getPerEmpresas().remove(perEmpresa);
		perEmpresa.setPerPersona(null);

		return perEmpresa;
	}

	public List<Identificacion> getPerIdentificacions() {
		return this.perIdentificacions;
	}

	public void setPerIdentificacions(List<Identificacion> perIdentificacions) {
		this.perIdentificacions = perIdentificacions;
	}

	public Identificacion addPerIdentificacion(Identificacion perIdentificacion) {
		getPerIdentificacions().add(perIdentificacion);
		perIdentificacion.setPerPersona(this);

		return perIdentificacion;
	}

	public Identificacion removePerIdentificacion(Identificacion perIdentificacion) {
		getPerIdentificacions().remove(perIdentificacion);
		perIdentificacion.setPerPersona(null);

		return perIdentificacion;
	}

	public List<Imagen> getPerImagens() {
		return this.perImagens;
	}

	public void setPerImagens(List<Imagen> perImagens) {
		this.perImagens = perImagens;
	}

	public Imagen addPerImagen(Imagen perImagen) {
		getPerImagens().add(perImagen);
		perImagen.setPerPersona(this);

		return perImagen;
	}

	public Imagen removePerImagen(Imagen perImagen) {
		getPerImagens().remove(perImagen);
		perImagen.setPerPersona(null);

		return perImagen;
	}

	public List<Letrado> getPerLetrados() {
		return this.perLetrados;
	}

	public void setPerLetrados(List<Letrado> perLetrados) {
		this.perLetrados = perLetrados;
	}

	public Letrado addPerLetrado(Letrado perLetrado) {
		getPerLetrados().add(perLetrado);
		perLetrado.setPerPersona(this);

		return perLetrado;
	}

	public Letrado removePerLetrado(Letrado perLetrado) {
		getPerLetrados().remove(perLetrado);
		perLetrado.setPerPersona(null);

		return perLetrado;
	}

	public List<NoIdentificado> getPerNoIdentificados() {
		return this.perNoIdentificados;
	}

	public void setPerNoIdentificados(List<NoIdentificado> perNoIdentificados) {
		this.perNoIdentificados = perNoIdentificados;
	}

	public NoIdentificado addPerNoIdentificado(NoIdentificado perNoIdentificado) {
		getPerNoIdentificados().add(perNoIdentificado);
		perNoIdentificado.setPerPersona(this);

		return perNoIdentificado;
	}

	public NoIdentificado removePerNoIdentificado(NoIdentificado perNoIdentificado) {
		getPerNoIdentificados().remove(perNoIdentificado);
		perNoIdentificado.setPerPersona(null);

		return perNoIdentificado;
	}

	public Valor getCfgValor1() {
		return this.cfgValor1;
	}

	public void setCfgValor1(Valor cfgValor1) {
		this.cfgValor1 = cfgValor1;
	}

	public Valor getCfgValor2() {
		return this.cfgValor2;
	}

	public void setCfgValor2(Valor cfgValor2) {
		this.cfgValor2 = cfgValor2;
	}

	public Valor getCfgValor3() {
		return this.cfgValor3;
	}

	public void setCfgValor3(Valor cfgValor3) {
		this.cfgValor3 = cfgValor3;
	}

	public Pais getMntPais() {
		return this.mntPais;
	}

	public void setMntPais(Pais mntPais) {
		this.mntPais = mntPais;
	}

	public Persona getPerPersona() {
		return this.perPersona;
	}

	public void setPerPersona(Persona perPersona) {
		this.perPersona = perPersona;
	}

	public List<Persona> getPerPersonas() {
		return this.perPersonas;
	}

	public void setPerPersonas(List<Persona> perPersonas) {
		this.perPersonas = perPersonas;
	}

	public Persona addPerPersona(Persona perPersona) {
		getPerPersonas().add(perPersona);
		perPersona.setPerPersona(this);

		return perPersona;
	}

	public Persona removePerPersona(Persona perPersona) {
		getPerPersonas().remove(perPersona);
		perPersona.setPerPersona(null);

		return perPersona;
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

	public Distrito getUbgDistrito() {
		return this.ubgDistrito;
	}

	public void setUbgDistrito(Distrito ubgDistrito) {
		this.ubgDistrito = ubgDistrito;
	}

	public List<Policia> getPerPolicias() {
		return this.perPolicias;
	}

	public void setPerPolicias(List<Policia> perPolicias) {
		this.perPolicias = perPolicias;
	}

	public Policia addPerPolicia(Policia perPolicia) {
		getPerPolicias().add(perPolicia);
		perPolicia.setPerPersona(this);

		return perPolicia;
	}

	public Policia removePerPolicia(Policia perPolicia) {
		getPerPolicias().remove(perPolicia);
		perPolicia.setPerPersona(null);

		return perPolicia;
	}

	public List<Parentesco> getPerParentescos1() {
		return this.perParentescos1;
	}

	public void setPerParentescos1(List<Parentesco> perParentescos1) {
		this.perParentescos1 = perParentescos1;
	}

	public Parentesco addPerParentescos1(Parentesco perParentescos1) {
		getPerParentescos1().add(perParentescos1);
		perParentescos1.setPerPersona1(this);

		return perParentescos1;
	}

	public Parentesco removePerParentescos1(Parentesco perParentescos1) {
		getPerParentescos1().remove(perParentescos1);
		perParentescos1.setPerPersona1(null);

		return perParentescos1;
	}

	public List<Parentesco> getPerParentescos2() {
		return this.perParentescos2;
	}

	public void setPerParentescos2(List<Parentesco> perParentescos2) {
		this.perParentescos2 = perParentescos2;
	}

	public Parentesco addPerParentescos2(Parentesco perParentescos2) {
		getPerParentescos2().add(perParentescos2);
		perParentescos2.setPerPersona2(this);

		return perParentescos2;
	}

	public Parentesco removePerParentescos2(Parentesco perParentescos2) {
		getPerParentescos2().remove(perParentescos2);
		perParentescos2.setPerPersona2(null);

		return perParentescos2;
	}

}