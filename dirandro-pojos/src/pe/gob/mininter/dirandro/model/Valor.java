package pe.gob.mininter.dirandro.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the CFG_VALOR database table.
 * 
 */
@Entity
@Table(name="CFG_VALOR")
public class Valor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="CFG_VALOR_ID_GENERATOR", sequenceName="SEQ_")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CFG_VALOR_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=16)
	private long id;

	@Column(nullable=false, length=30)
	private String codigo;

	@Column(nullable=false)
	private Timestamp creacion;

	@Column(length=500)
	private String descripcion;

	private Timestamp edicion;

	@Column(length=2)
	private String estado;

	@Column(nullable=false, length=100)
	private String nombre;

	@Column(precision=8)
	private BigDecimal orden;

	//bi-directional many-to-one association to Parametro
	@OneToMany(mappedBy="cfgValor")
	private List<Parametro> cfgParametros;

	//bi-directional many-to-one association to Regla
	@OneToMany(mappedBy="cfgValor1")
	private List<Regla> cfgReglas1;

	//bi-directional many-to-one association to Regla
	@OneToMany(mappedBy="cfgValor2")
	private List<Regla> cfgReglas2;

	//bi-directional many-to-one association to Lista
	@ManyToOne
	@JoinColumn(name="LISTA", nullable=false)
	private Lista cfgLista;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="EDITOR")
	private Usuario segUsuario1;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="CREADOR", nullable=false)
	private Usuario segUsuario2;

	//bi-directional many-to-one association to Adjunto
	@OneToMany(mappedBy="cfgValor")
	private List<Adjunto> expAdjuntos;

	//bi-directional many-to-one association to Arma
	@OneToMany(mappedBy="cfgValor1")
	private List<Arma> expArmas1;

	//bi-directional many-to-one association to Arma
	@OneToMany(mappedBy="cfgValor2")
	private List<Arma> expArmas2;

	//bi-directional many-to-one association to Arma
	@OneToMany(mappedBy="cfgValor3")
	private List<Arma> expArmas3;

	//bi-directional many-to-one association to CentroPoblado
	@OneToMany(mappedBy="cfgValor1")
	private List<CentroPoblado> expCentroPoblados1;

	//bi-directional many-to-one association to CentroPoblado
	@OneToMany(mappedBy="cfgValor2")
	private List<CentroPoblado> expCentroPoblados2;

	//bi-directional many-to-one association to Delito
	@OneToMany(mappedBy="cfgValor1")
	private List<Delito> expDelitos1;

	//bi-directional many-to-one association to Delito
	@OneToMany(mappedBy="cfgValor2")
	private List<Delito> expDelitos2;

	//bi-directional many-to-one association to Dependencia
	@OneToMany(mappedBy="cfgValor1")
	private List<Dependencia> expDependencias1;

	//bi-directional many-to-one association to Dependencia
	@OneToMany(mappedBy="cfgValor2")
	private List<Dependencia> expDependencias2;

	//bi-directional many-to-one association to DetCrimen
	@OneToMany(mappedBy="cfgValor")
	private List<DetCrimen> expDetCrimens;

	//bi-directional many-to-one association to DetDroga
	@OneToMany(mappedBy="cfgValor1")
	private List<DetDroga> expDetDrogas1;

	//bi-directional many-to-one association to DetDroga
	@OneToMany(mappedBy="cfgValor2")
	private List<DetDroga> expDetDrogas2;

	//bi-directional many-to-one association to DetDroga
	@OneToMany(mappedBy="cfgValor3")
	private List<DetDroga> expDetDrogas3;

	//bi-directional many-to-one association to DetDroga
	@OneToMany(mappedBy="cfgValor4")
	private List<DetDroga> expDetDrogas4;

	//bi-directional many-to-one association to DetExpedientePersona
	@OneToMany(mappedBy="cfgValor1")
	private List<DetExpedientePersona> expDetExpedientePersonas1;

	//bi-directional many-to-one association to DetExpedientePersona
	@OneToMany(mappedBy="cfgValor2")
	private List<DetExpedientePersona> expDetExpedientePersonas2;

	//bi-directional many-to-one association to DetLlamada
	@OneToMany(mappedBy="cfgValor")
	private List<DetLlamada> expDetLlamadas;

	//bi-directional many-to-one association to DetPerArmExp
	@OneToMany(mappedBy="cfgValor1")
	private List<DetPerArmExp> expDetPerArmExps1;

	//bi-directional many-to-one association to DetPerArmExp
	@OneToMany(mappedBy="cfgValor2")
	private List<DetPerArmExp> expDetPerArmExps2;

	//bi-directional many-to-one association to DetPerInmExp
	@OneToMany(mappedBy="cfgValor")
	private List<DetPerInmExp> expDetPerInmExps;

	//bi-directional many-to-one association to DetPerTelExp
	@OneToMany(mappedBy="cfgValor1")
	private List<DetPerTelExp> expDetPerTelExps1;

	//bi-directional many-to-one association to DetPerTelExp
	@OneToMany(mappedBy="cfgValor2")
	private List<DetPerTelExp> expDetPerTelExps2;

	//bi-directional many-to-one association to DetPerTelExp
	@OneToMany(mappedBy="cfgValor3")
	private List<DetPerTelExp> expDetPerTelExps3;

	//bi-directional many-to-one association to DetPerVehExp
	@OneToMany(mappedBy="cfgValor1")
	private List<DetPerVehExp> expDetPerVehExps1;

	//bi-directional many-to-one association to DetPerVehExp
	@OneToMany(mappedBy="cfgValor2")
	private List<DetPerVehExp> expDetPerVehExps2;

	//bi-directional many-to-one association to DetPerVehExp
	@OneToMany(mappedBy="cfgValor3")
	private List<DetPerVehExp> expDetPerVehExps3;

	//bi-directional many-to-one association to DetPerVehExp
	@OneToMany(mappedBy="cfgValor4")
	private List<DetPerVehExp> expDetPerVehExps4;

	//bi-directional many-to-one association to Documento
	@OneToMany(mappedBy="cfgValor1")
	private List<Documento> expDocumentos1;

	//bi-directional many-to-one association to Documento
	@OneToMany(mappedBy="cfgValor2")
	private List<Documento> expDocumentos2;

	//bi-directional many-to-one association to Droga
	@OneToMany(mappedBy="cfgValor1")
	private List<Droga> expDrogas1;

	//bi-directional many-to-one association to Droga
	@OneToMany(mappedBy="cfgValor2")
	private List<Droga> expDrogas2;

	//bi-directional many-to-one association to Droga
	@OneToMany(mappedBy="cfgValor3")
	private List<Droga> expDrogas3;

	//bi-directional many-to-one association to Droga
	@OneToMany(mappedBy="cfgValor4")
	private List<Droga> expDrogas4;

	//bi-directional many-to-one association to Entidad
	@OneToMany(mappedBy="cfgValor1")
	private List<Entidad> expEntidads1;

	//bi-directional many-to-one association to Entidad
	@OneToMany(mappedBy="cfgValor2")
	private List<Entidad> expEntidads2;

	//bi-directional many-to-one association to Especie
	@OneToMany(mappedBy="cfgValor1")
	private List<Especie> expEspecies1;

	//bi-directional many-to-one association to Especie
	@OneToMany(mappedBy="cfgValor2")
	private List<Especie> expEspecies2;

	//bi-directional many-to-one association to Especie
	@OneToMany(mappedBy="cfgValor3")
	private List<Especie> expEspecies3;

	//bi-directional many-to-one association to Estado
	@OneToMany(mappedBy="cfgValor")
	private List<Estado> expEstados;

	//bi-directional many-to-one association to Expediente
	@OneToMany(mappedBy="cfgValor1")
	private List<Expediente> expExpedientes1;

	//bi-directional many-to-one association to Expediente
	@OneToMany(mappedBy="cfgValor2")
	private List<Expediente> expExpedientes2;

	//bi-directional many-to-one association to Expediente
	@OneToMany(mappedBy="cfgValor3")
	private List<Expediente> expExpedientes3;

	//bi-directional many-to-one association to Expediente
	@OneToMany(mappedBy="cfgValor4")
	private List<Expediente> expExpedientes4;

	//bi-directional many-to-one association to ExpedienteDelito
	@OneToMany(mappedBy="cfgValor")
	private List<ExpedienteDelito> expExpedienteDelitos;

	//bi-directional many-to-one association to ExpedienteMediosMovil
	@OneToMany(mappedBy="cfgValor")
	private List<ExpedienteMediosMovil> expExpedienteMediosMovils;

	//bi-directional many-to-one association to Explosivo
	@OneToMany(mappedBy="cfgValor1")
	private List<Explosivo> expExplosivos1;

	//bi-directional many-to-one association to Explosivo
	@OneToMany(mappedBy="cfgValor2")
	private List<Explosivo> expExplosivos2;

	//bi-directional many-to-one association to Explosivo
	@OneToMany(mappedBy="cfgValor3")
	private List<Explosivo> expExplosivos3;

	//bi-directional many-to-one association to Importe
	@OneToMany(mappedBy="cfgValor1")
	private List<Importe> expImportes1;

	//bi-directional many-to-one association to Importe
	@OneToMany(mappedBy="cfgValor2")
	private List<Importe> expImportes2;

	//bi-directional many-to-one association to Importe
	@OneToMany(mappedBy="cfgValor3")
	private List<Importe> expImportes3;

	//bi-directional many-to-one association to Importe
	@OneToMany(mappedBy="cfgValor4")
	private List<Importe> expImportes4;

	//bi-directional many-to-one association to Importe
	@OneToMany(mappedBy="cfgValor5")
	private List<Importe> expImportes5;

	//bi-directional many-to-one association to Importe
	@OneToMany(mappedBy="cfgValor6")
	private List<Importe> expImportes6;

	//bi-directional many-to-one association to Inmueble
	@OneToMany(mappedBy="cfgValor")
	private List<Inmueble> expInmuebles;

	//bi-directional many-to-one association to Instalacion
	@OneToMany(mappedBy="cfgValor1")
	private List<Instalacion> expInstalacions1;

	//bi-directional many-to-one association to Instalacion
	@OneToMany(mappedBy="cfgValor2")
	private List<Instalacion> expInstalacions2;

	//bi-directional many-to-one association to Municion
	@OneToMany(mappedBy="cfgValor1")
	private List<Municion> expMuniciones1;

	//bi-directional many-to-one association to Municion
	@OneToMany(mappedBy="cfgValor2")
	private List<Municion> expMuniciones2;

	//bi-directional many-to-one association to Municion
	@OneToMany(mappedBy="cfgValor3")
	private List<Municion> expMuniciones3;

	//bi-directional many-to-one association to Municion
	@OneToMany(mappedBy="cfgValor4")
	private List<Municion> expMuniciones4;

	//bi-directional many-to-one association to Ruta
	@OneToMany(mappedBy="cfgValor1")
	private List<Ruta> expRutas1;

	//bi-directional many-to-one association to Ruta
	@OneToMany(mappedBy="cfgValor2")
	private List<Ruta> expRutas2;

	//bi-directional many-to-one association to Ruta
	@OneToMany(mappedBy="cfgValor3")
	private List<Ruta> expRutas3;

	//bi-directional many-to-one association to SituacionGeneral
	@OneToMany(mappedBy="cfgValor1")
	private List<SituacionGeneral> expSituacionGenerals1;

	//bi-directional many-to-one association to SituacionGeneral
	@OneToMany(mappedBy="cfgValor2")
	private List<SituacionGeneral> expSituacionGenerals2;

	//bi-directional many-to-one association to TipoHecho
	@OneToMany(mappedBy="cfgValor")
	private List<TipoHecho> expTipoHechos;

	//bi-directional many-to-one association to Vehiculo
	@OneToMany(mappedBy="cfgValor1")
	private List<Vehiculo> expVehiculos1;

	//bi-directional many-to-one association to Vehiculo
	@OneToMany(mappedBy="cfgValor2")
	private List<Vehiculo> expVehiculos2;

	//bi-directional many-to-one association to Vehiculo
	@OneToMany(mappedBy="cfgValor3")
	private List<Vehiculo> expVehiculos3;

	//bi-directional many-to-one association to Vehiculo
	@OneToMany(mappedBy="cfgValor4")
	private List<Vehiculo> expVehiculos4;

	//bi-directional many-to-one association to Vehiculo
	@OneToMany(mappedBy="cfgValor5")
	private List<Vehiculo> expVehiculos5;

	//bi-directional many-to-one association to Hojaremision
	@OneToMany(mappedBy="cfgValor")
	private List<Hojaremision> hrHojaremisions;

	//bi-directional many-to-one association to ModeloMarca
	@OneToMany(mappedBy="cfgValor")
	private List<ModeloMarca> mntModeloMarcas;

	//bi-directional many-to-one association to Pais
	@OneToMany(mappedBy="cfgValor")
	private List<Pais> mntPaises;

	//bi-directional many-to-one association to Equipo
	@OneToMany(mappedBy="cfgValor1")
	private List<Equipo> orgEquipos1;

	//bi-directional many-to-one association to Equipo
	@OneToMany(mappedBy="cfgValor2")
	private List<Equipo> orgEquipos2;

	//bi-directional many-to-one association to Integrante
	@OneToMany(mappedBy="cfgValor1")
	private List<Integrante> orgIntegrantes1;

	//bi-directional many-to-one association to Integrante
	@OneToMany(mappedBy="cfgValor2")
	private List<Integrante> orgIntegrantes2;

	//bi-directional many-to-one association to Detalle
	@OneToMany(mappedBy="cfgValor1")
	private List<Detalle> perDetalles1;

	//bi-directional many-to-one association to Detalle
	@OneToMany(mappedBy="cfgValor2")
	private List<Detalle> perDetalles2;

	//bi-directional many-to-one association to Detalle
	@OneToMany(mappedBy="cfgValor3")
	private List<Detalle> perDetalles3;

	//bi-directional many-to-one association to Detalle
	@OneToMany(mappedBy="cfgValor4")
	private List<Detalle> perDetalles4;

	//bi-directional many-to-one association to Detalle
	@OneToMany(mappedBy="cfgValor5")
	private List<Detalle> perDetalles5;

	//bi-directional many-to-one association to Detalle
	@OneToMany(mappedBy="cfgValor6")
	private List<Detalle> perDetalles6;

	//bi-directional many-to-one association to Detalle
	@OneToMany(mappedBy="cfgValor7")
	private List<Detalle> perDetalles7;

	//bi-directional many-to-one association to Detalle
	@OneToMany(mappedBy="cfgValor8")
	private List<Detalle> perDetalles8;

	//bi-directional many-to-one association to Detalle
	@OneToMany(mappedBy="cfgValor9")
	private List<Detalle> perDetalles9;

	//bi-directional many-to-one association to Detalle
	@OneToMany(mappedBy="cfgValor10")
	private List<Detalle> perDetalles10;

	//bi-directional many-to-one association to Detalle
	@OneToMany(mappedBy="cfgValor11")
	private List<Detalle> perDetalles11;

	//bi-directional many-to-one association to Detalle
	@OneToMany(mappedBy="cfgValor12")
	private List<Detalle> perDetalles12;

	//bi-directional many-to-one association to Detalle
	@OneToMany(mappedBy="cfgValor13")
	private List<Detalle> perDetalles13;

	//bi-directional many-to-one association to Detalle
	@OneToMany(mappedBy="cfgValor14")
	private List<Detalle> perDetalles14;

	//bi-directional many-to-one association to Detalle
	@OneToMany(mappedBy="cfgValor15")
	private List<Detalle> perDetalles15;

	//bi-directional many-to-one association to Empresa
	@OneToMany(mappedBy="cfgValor")
	private List<Empresa> perEmpresas;

	//bi-directional many-to-one association to Identificacion
	@OneToMany(mappedBy="cfgValor")
	private List<Identificacion> perIdentificacions;

	//bi-directional many-to-one association to Letrado
	@OneToMany(mappedBy="cfgValor")
	private List<Letrado> perLetrados;

	//bi-directional many-to-one association to NoIdentificado
	@OneToMany(mappedBy="cfgValor")
	private List<NoIdentificado> perNoIdentificados;

	//bi-directional many-to-one association to Parentesco
	@OneToMany(mappedBy="cfgValor")
	private List<Parentesco> perParentescos;

	//bi-directional many-to-one association to Persona
	@OneToMany(mappedBy="cfgValor1")
	private List<Persona> perPersonas1;

	//bi-directional many-to-one association to Persona
	@OneToMany(mappedBy="cfgValor2")
	private List<Persona> perPersonas2;

	//bi-directional many-to-one association to Persona
	@OneToMany(mappedBy="cfgValor3")
	private List<Persona> perPersonas3;

	//bi-directional many-to-one association to Policia
	@OneToMany(mappedBy="cfgValor1")
	private List<Policia> perPolicias1;

	//bi-directional many-to-one association to Policia
	@OneToMany(mappedBy="cfgValor2")
	private List<Policia> perPolicias2;

	//bi-directional many-to-one association to Telefono
	@OneToMany(mappedBy="cfgValor1")
	private List<Telefono> perTelefonos1;

	//bi-directional many-to-one association to Telefono
	@OneToMany(mappedBy="cfgValor2")
	private List<Telefono> perTelefonos2;

	//bi-directional many-to-one association to Opcion
	@OneToMany(mappedBy="cfgValor1")
	private List<Opcion> segOpcions1;

	//bi-directional many-to-one association to Opcion
	@OneToMany(mappedBy="cfgValor2")
	private List<Opcion> segOpcions2;

	//bi-directional many-to-one association to Permiso
	@OneToMany(mappedBy="cfgValor")
	private List<Permiso> segPermisos;

	//bi-directional many-to-one association to Rol
	@OneToMany(mappedBy="cfgValor")
	private List<Rol> segRols;

	//bi-directional many-to-one association to Departamento
	@OneToMany(mappedBy="cfgValor")
	private List<Departamento> ubgDepartamentos;

	//bi-directional many-to-one association to Distrito
	@OneToMany(mappedBy="cfgValor")
	private List<Distrito> ubgDistritos;

	//bi-directional many-to-one association to Provincia
	@OneToMany(mappedBy="cfgValor")
	private List<Provincia> ubgProvincias;

	public Valor() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCodigo() {
		return this.codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Timestamp getCreacion() {
		return this.creacion;
	}

	public void setCreacion(Timestamp creacion) {
		this.creacion = creacion;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Timestamp getEdicion() {
		return this.edicion;
	}

	public void setEdicion(Timestamp edicion) {
		this.edicion = edicion;
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

	public BigDecimal getOrden() {
		return this.orden;
	}

	public void setOrden(BigDecimal orden) {
		this.orden = orden;
	}

	public List<Parametro> getCfgParametros() {
		return this.cfgParametros;
	}

	public void setCfgParametros(List<Parametro> cfgParametros) {
		this.cfgParametros = cfgParametros;
	}

	public Parametro addCfgParametro(Parametro cfgParametro) {
		getCfgParametros().add(cfgParametro);
		cfgParametro.setCfgValor(this);

		return cfgParametro;
	}

	public Parametro removeCfgParametro(Parametro cfgParametro) {
		getCfgParametros().remove(cfgParametro);
		cfgParametro.setCfgValor(null);

		return cfgParametro;
	}

	public List<Regla> getCfgReglas1() {
		return this.cfgReglas1;
	}

	public void setCfgReglas1(List<Regla> cfgReglas1) {
		this.cfgReglas1 = cfgReglas1;
	}

	public Regla addCfgReglas1(Regla cfgReglas1) {
		getCfgReglas1().add(cfgReglas1);
		cfgReglas1.setCfgValor1(this);

		return cfgReglas1;
	}

	public Regla removeCfgReglas1(Regla cfgReglas1) {
		getCfgReglas1().remove(cfgReglas1);
		cfgReglas1.setCfgValor1(null);

		return cfgReglas1;
	}

	public List<Regla> getCfgReglas2() {
		return this.cfgReglas2;
	}

	public void setCfgReglas2(List<Regla> cfgReglas2) {
		this.cfgReglas2 = cfgReglas2;
	}

	public Regla addCfgReglas2(Regla cfgReglas2) {
		getCfgReglas2().add(cfgReglas2);
		cfgReglas2.setCfgValor2(this);

		return cfgReglas2;
	}

	public Regla removeCfgReglas2(Regla cfgReglas2) {
		getCfgReglas2().remove(cfgReglas2);
		cfgReglas2.setCfgValor2(null);

		return cfgReglas2;
	}

	public Lista getCfgLista() {
		return this.cfgLista;
	}

	public void setCfgLista(Lista cfgLista) {
		this.cfgLista = cfgLista;
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

	public List<Adjunto> getExpAdjuntos() {
		return this.expAdjuntos;
	}

	public void setExpAdjuntos(List<Adjunto> expAdjuntos) {
		this.expAdjuntos = expAdjuntos;
	}

	public Adjunto addExpAdjunto(Adjunto expAdjunto) {
		getExpAdjuntos().add(expAdjunto);
		expAdjunto.setCfgValor(this);

		return expAdjunto;
	}

	public Adjunto removeExpAdjunto(Adjunto expAdjunto) {
		getExpAdjuntos().remove(expAdjunto);
		expAdjunto.setCfgValor(null);

		return expAdjunto;
	}

	public List<Arma> getExpArmas1() {
		return this.expArmas1;
	}

	public void setExpArmas1(List<Arma> expArmas1) {
		this.expArmas1 = expArmas1;
	}

	public Arma addExpArmas1(Arma expArmas1) {
		getExpArmas1().add(expArmas1);
		expArmas1.setCfgValor1(this);

		return expArmas1;
	}

	public Arma removeExpArmas1(Arma expArmas1) {
		getExpArmas1().remove(expArmas1);
		expArmas1.setCfgValor1(null);

		return expArmas1;
	}

	public List<Arma> getExpArmas2() {
		return this.expArmas2;
	}

	public void setExpArmas2(List<Arma> expArmas2) {
		this.expArmas2 = expArmas2;
	}

	public Arma addExpArmas2(Arma expArmas2) {
		getExpArmas2().add(expArmas2);
		expArmas2.setCfgValor2(this);

		return expArmas2;
	}

	public Arma removeExpArmas2(Arma expArmas2) {
		getExpArmas2().remove(expArmas2);
		expArmas2.setCfgValor2(null);

		return expArmas2;
	}

	public List<Arma> getExpArmas3() {
		return this.expArmas3;
	}

	public void setExpArmas3(List<Arma> expArmas3) {
		this.expArmas3 = expArmas3;
	}

	public Arma addExpArmas3(Arma expArmas3) {
		getExpArmas3().add(expArmas3);
		expArmas3.setCfgValor3(this);

		return expArmas3;
	}

	public Arma removeExpArmas3(Arma expArmas3) {
		getExpArmas3().remove(expArmas3);
		expArmas3.setCfgValor3(null);

		return expArmas3;
	}

	public List<CentroPoblado> getExpCentroPoblados1() {
		return this.expCentroPoblados1;
	}

	public void setExpCentroPoblados1(List<CentroPoblado> expCentroPoblados1) {
		this.expCentroPoblados1 = expCentroPoblados1;
	}

	public CentroPoblado addExpCentroPoblados1(CentroPoblado expCentroPoblados1) {
		getExpCentroPoblados1().add(expCentroPoblados1);
		expCentroPoblados1.setCfgValor1(this);

		return expCentroPoblados1;
	}

	public CentroPoblado removeExpCentroPoblados1(CentroPoblado expCentroPoblados1) {
		getExpCentroPoblados1().remove(expCentroPoblados1);
		expCentroPoblados1.setCfgValor1(null);

		return expCentroPoblados1;
	}

	public List<CentroPoblado> getExpCentroPoblados2() {
		return this.expCentroPoblados2;
	}

	public void setExpCentroPoblados2(List<CentroPoblado> expCentroPoblados2) {
		this.expCentroPoblados2 = expCentroPoblados2;
	}

	public CentroPoblado addExpCentroPoblados2(CentroPoblado expCentroPoblados2) {
		getExpCentroPoblados2().add(expCentroPoblados2);
		expCentroPoblados2.setCfgValor2(this);

		return expCentroPoblados2;
	}

	public CentroPoblado removeExpCentroPoblados2(CentroPoblado expCentroPoblados2) {
		getExpCentroPoblados2().remove(expCentroPoblados2);
		expCentroPoblados2.setCfgValor2(null);

		return expCentroPoblados2;
	}

	public List<Delito> getExpDelitos1() {
		return this.expDelitos1;
	}

	public void setExpDelitos1(List<Delito> expDelitos1) {
		this.expDelitos1 = expDelitos1;
	}

	public Delito addExpDelitos1(Delito expDelitos1) {
		getExpDelitos1().add(expDelitos1);
		expDelitos1.setCfgValor1(this);

		return expDelitos1;
	}

	public Delito removeExpDelitos1(Delito expDelitos1) {
		getExpDelitos1().remove(expDelitos1);
		expDelitos1.setCfgValor1(null);

		return expDelitos1;
	}

	public List<Delito> getExpDelitos2() {
		return this.expDelitos2;
	}

	public void setExpDelitos2(List<Delito> expDelitos2) {
		this.expDelitos2 = expDelitos2;
	}

	public Delito addExpDelitos2(Delito expDelitos2) {
		getExpDelitos2().add(expDelitos2);
		expDelitos2.setCfgValor2(this);

		return expDelitos2;
	}

	public Delito removeExpDelitos2(Delito expDelitos2) {
		getExpDelitos2().remove(expDelitos2);
		expDelitos2.setCfgValor2(null);

		return expDelitos2;
	}

	public List<Dependencia> getExpDependencias1() {
		return this.expDependencias1;
	}

	public void setExpDependencias1(List<Dependencia> expDependencias1) {
		this.expDependencias1 = expDependencias1;
	}

	public Dependencia addExpDependencias1(Dependencia expDependencias1) {
		getExpDependencias1().add(expDependencias1);
		expDependencias1.setCfgValor1(this);

		return expDependencias1;
	}

	public Dependencia removeExpDependencias1(Dependencia expDependencias1) {
		getExpDependencias1().remove(expDependencias1);
		expDependencias1.setCfgValor1(null);

		return expDependencias1;
	}

	public List<Dependencia> getExpDependencias2() {
		return this.expDependencias2;
	}

	public void setExpDependencias2(List<Dependencia> expDependencias2) {
		this.expDependencias2 = expDependencias2;
	}

	public Dependencia addExpDependencias2(Dependencia expDependencias2) {
		getExpDependencias2().add(expDependencias2);
		expDependencias2.setCfgValor2(this);

		return expDependencias2;
	}

	public Dependencia removeExpDependencias2(Dependencia expDependencias2) {
		getExpDependencias2().remove(expDependencias2);
		expDependencias2.setCfgValor2(null);

		return expDependencias2;
	}

	public List<DetCrimen> getExpDetCrimens() {
		return this.expDetCrimens;
	}

	public void setExpDetCrimens(List<DetCrimen> expDetCrimens) {
		this.expDetCrimens = expDetCrimens;
	}

	public DetCrimen addExpDetCrimen(DetCrimen expDetCrimen) {
		getExpDetCrimens().add(expDetCrimen);
		expDetCrimen.setCfgValor(this);

		return expDetCrimen;
	}

	public DetCrimen removeExpDetCrimen(DetCrimen expDetCrimen) {
		getExpDetCrimens().remove(expDetCrimen);
		expDetCrimen.setCfgValor(null);

		return expDetCrimen;
	}

	public List<DetDroga> getExpDetDrogas1() {
		return this.expDetDrogas1;
	}

	public void setExpDetDrogas1(List<DetDroga> expDetDrogas1) {
		this.expDetDrogas1 = expDetDrogas1;
	}

	public DetDroga addExpDetDrogas1(DetDroga expDetDrogas1) {
		getExpDetDrogas1().add(expDetDrogas1);
		expDetDrogas1.setCfgValor1(this);

		return expDetDrogas1;
	}

	public DetDroga removeExpDetDrogas1(DetDroga expDetDrogas1) {
		getExpDetDrogas1().remove(expDetDrogas1);
		expDetDrogas1.setCfgValor1(null);

		return expDetDrogas1;
	}

	public List<DetDroga> getExpDetDrogas2() {
		return this.expDetDrogas2;
	}

	public void setExpDetDrogas2(List<DetDroga> expDetDrogas2) {
		this.expDetDrogas2 = expDetDrogas2;
	}

	public DetDroga addExpDetDrogas2(DetDroga expDetDrogas2) {
		getExpDetDrogas2().add(expDetDrogas2);
		expDetDrogas2.setCfgValor2(this);

		return expDetDrogas2;
	}

	public DetDroga removeExpDetDrogas2(DetDroga expDetDrogas2) {
		getExpDetDrogas2().remove(expDetDrogas2);
		expDetDrogas2.setCfgValor2(null);

		return expDetDrogas2;
	}

	public List<DetDroga> getExpDetDrogas3() {
		return this.expDetDrogas3;
	}

	public void setExpDetDrogas3(List<DetDroga> expDetDrogas3) {
		this.expDetDrogas3 = expDetDrogas3;
	}

	public DetDroga addExpDetDrogas3(DetDroga expDetDrogas3) {
		getExpDetDrogas3().add(expDetDrogas3);
		expDetDrogas3.setCfgValor3(this);

		return expDetDrogas3;
	}

	public DetDroga removeExpDetDrogas3(DetDroga expDetDrogas3) {
		getExpDetDrogas3().remove(expDetDrogas3);
		expDetDrogas3.setCfgValor3(null);

		return expDetDrogas3;
	}

	public List<DetDroga> getExpDetDrogas4() {
		return this.expDetDrogas4;
	}

	public void setExpDetDrogas4(List<DetDroga> expDetDrogas4) {
		this.expDetDrogas4 = expDetDrogas4;
	}

	public DetDroga addExpDetDrogas4(DetDroga expDetDrogas4) {
		getExpDetDrogas4().add(expDetDrogas4);
		expDetDrogas4.setCfgValor4(this);

		return expDetDrogas4;
	}

	public DetDroga removeExpDetDrogas4(DetDroga expDetDrogas4) {
		getExpDetDrogas4().remove(expDetDrogas4);
		expDetDrogas4.setCfgValor4(null);

		return expDetDrogas4;
	}

	public List<DetExpedientePersona> getExpDetExpedientePersonas1() {
		return this.expDetExpedientePersonas1;
	}

	public void setExpDetExpedientePersonas1(List<DetExpedientePersona> expDetExpedientePersonas1) {
		this.expDetExpedientePersonas1 = expDetExpedientePersonas1;
	}

	public DetExpedientePersona addExpDetExpedientePersonas1(DetExpedientePersona expDetExpedientePersonas1) {
		getExpDetExpedientePersonas1().add(expDetExpedientePersonas1);
		expDetExpedientePersonas1.setCfgValor1(this);

		return expDetExpedientePersonas1;
	}

	public DetExpedientePersona removeExpDetExpedientePersonas1(DetExpedientePersona expDetExpedientePersonas1) {
		getExpDetExpedientePersonas1().remove(expDetExpedientePersonas1);
		expDetExpedientePersonas1.setCfgValor1(null);

		return expDetExpedientePersonas1;
	}

	public List<DetExpedientePersona> getExpDetExpedientePersonas2() {
		return this.expDetExpedientePersonas2;
	}

	public void setExpDetExpedientePersonas2(List<DetExpedientePersona> expDetExpedientePersonas2) {
		this.expDetExpedientePersonas2 = expDetExpedientePersonas2;
	}

	public DetExpedientePersona addExpDetExpedientePersonas2(DetExpedientePersona expDetExpedientePersonas2) {
		getExpDetExpedientePersonas2().add(expDetExpedientePersonas2);
		expDetExpedientePersonas2.setCfgValor2(this);

		return expDetExpedientePersonas2;
	}

	public DetExpedientePersona removeExpDetExpedientePersonas2(DetExpedientePersona expDetExpedientePersonas2) {
		getExpDetExpedientePersonas2().remove(expDetExpedientePersonas2);
		expDetExpedientePersonas2.setCfgValor2(null);

		return expDetExpedientePersonas2;
	}

	public List<DetLlamada> getExpDetLlamadas() {
		return this.expDetLlamadas;
	}

	public void setExpDetLlamadas(List<DetLlamada> expDetLlamadas) {
		this.expDetLlamadas = expDetLlamadas;
	}

	public DetLlamada addExpDetLlamada(DetLlamada expDetLlamada) {
		getExpDetLlamadas().add(expDetLlamada);
		expDetLlamada.setCfgValor(this);

		return expDetLlamada;
	}

	public DetLlamada removeExpDetLlamada(DetLlamada expDetLlamada) {
		getExpDetLlamadas().remove(expDetLlamada);
		expDetLlamada.setCfgValor(null);

		return expDetLlamada;
	}

	public List<DetPerArmExp> getExpDetPerArmExps1() {
		return this.expDetPerArmExps1;
	}

	public void setExpDetPerArmExps1(List<DetPerArmExp> expDetPerArmExps1) {
		this.expDetPerArmExps1 = expDetPerArmExps1;
	}

	public DetPerArmExp addExpDetPerArmExps1(DetPerArmExp expDetPerArmExps1) {
		getExpDetPerArmExps1().add(expDetPerArmExps1);
		expDetPerArmExps1.setCfgValor1(this);

		return expDetPerArmExps1;
	}

	public DetPerArmExp removeExpDetPerArmExps1(DetPerArmExp expDetPerArmExps1) {
		getExpDetPerArmExps1().remove(expDetPerArmExps1);
		expDetPerArmExps1.setCfgValor1(null);

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
		expDetPerArmExps2.setCfgValor2(this);

		return expDetPerArmExps2;
	}

	public DetPerArmExp removeExpDetPerArmExps2(DetPerArmExp expDetPerArmExps2) {
		getExpDetPerArmExps2().remove(expDetPerArmExps2);
		expDetPerArmExps2.setCfgValor2(null);

		return expDetPerArmExps2;
	}

	public List<DetPerInmExp> getExpDetPerInmExps() {
		return this.expDetPerInmExps;
	}

	public void setExpDetPerInmExps(List<DetPerInmExp> expDetPerInmExps) {
		this.expDetPerInmExps = expDetPerInmExps;
	}

	public DetPerInmExp addExpDetPerInmExp(DetPerInmExp expDetPerInmExp) {
		getExpDetPerInmExps().add(expDetPerInmExp);
		expDetPerInmExp.setCfgValor(this);

		return expDetPerInmExp;
	}

	public DetPerInmExp removeExpDetPerInmExp(DetPerInmExp expDetPerInmExp) {
		getExpDetPerInmExps().remove(expDetPerInmExp);
		expDetPerInmExp.setCfgValor(null);

		return expDetPerInmExp;
	}

	public List<DetPerTelExp> getExpDetPerTelExps1() {
		return this.expDetPerTelExps1;
	}

	public void setExpDetPerTelExps1(List<DetPerTelExp> expDetPerTelExps1) {
		this.expDetPerTelExps1 = expDetPerTelExps1;
	}

	public DetPerTelExp addExpDetPerTelExps1(DetPerTelExp expDetPerTelExps1) {
		getExpDetPerTelExps1().add(expDetPerTelExps1);
		expDetPerTelExps1.setCfgValor1(this);

		return expDetPerTelExps1;
	}

	public DetPerTelExp removeExpDetPerTelExps1(DetPerTelExp expDetPerTelExps1) {
		getExpDetPerTelExps1().remove(expDetPerTelExps1);
		expDetPerTelExps1.setCfgValor1(null);

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
		expDetPerTelExps2.setCfgValor2(this);

		return expDetPerTelExps2;
	}

	public DetPerTelExp removeExpDetPerTelExps2(DetPerTelExp expDetPerTelExps2) {
		getExpDetPerTelExps2().remove(expDetPerTelExps2);
		expDetPerTelExps2.setCfgValor2(null);

		return expDetPerTelExps2;
	}

	public List<DetPerTelExp> getExpDetPerTelExps3() {
		return this.expDetPerTelExps3;
	}

	public void setExpDetPerTelExps3(List<DetPerTelExp> expDetPerTelExps3) {
		this.expDetPerTelExps3 = expDetPerTelExps3;
	}

	public DetPerTelExp addExpDetPerTelExps3(DetPerTelExp expDetPerTelExps3) {
		getExpDetPerTelExps3().add(expDetPerTelExps3);
		expDetPerTelExps3.setCfgValor3(this);

		return expDetPerTelExps3;
	}

	public DetPerTelExp removeExpDetPerTelExps3(DetPerTelExp expDetPerTelExps3) {
		getExpDetPerTelExps3().remove(expDetPerTelExps3);
		expDetPerTelExps3.setCfgValor3(null);

		return expDetPerTelExps3;
	}

	public List<DetPerVehExp> getExpDetPerVehExps1() {
		return this.expDetPerVehExps1;
	}

	public void setExpDetPerVehExps1(List<DetPerVehExp> expDetPerVehExps1) {
		this.expDetPerVehExps1 = expDetPerVehExps1;
	}

	public DetPerVehExp addExpDetPerVehExps1(DetPerVehExp expDetPerVehExps1) {
		getExpDetPerVehExps1().add(expDetPerVehExps1);
		expDetPerVehExps1.setCfgValor1(this);

		return expDetPerVehExps1;
	}

	public DetPerVehExp removeExpDetPerVehExps1(DetPerVehExp expDetPerVehExps1) {
		getExpDetPerVehExps1().remove(expDetPerVehExps1);
		expDetPerVehExps1.setCfgValor1(null);

		return expDetPerVehExps1;
	}

	public List<DetPerVehExp> getExpDetPerVehExps2() {
		return this.expDetPerVehExps2;
	}

	public void setExpDetPerVehExps2(List<DetPerVehExp> expDetPerVehExps2) {
		this.expDetPerVehExps2 = expDetPerVehExps2;
	}

	public DetPerVehExp addExpDetPerVehExps2(DetPerVehExp expDetPerVehExps2) {
		getExpDetPerVehExps2().add(expDetPerVehExps2);
		expDetPerVehExps2.setCfgValor2(this);

		return expDetPerVehExps2;
	}

	public DetPerVehExp removeExpDetPerVehExps2(DetPerVehExp expDetPerVehExps2) {
		getExpDetPerVehExps2().remove(expDetPerVehExps2);
		expDetPerVehExps2.setCfgValor2(null);

		return expDetPerVehExps2;
	}

	public List<DetPerVehExp> getExpDetPerVehExps3() {
		return this.expDetPerVehExps3;
	}

	public void setExpDetPerVehExps3(List<DetPerVehExp> expDetPerVehExps3) {
		this.expDetPerVehExps3 = expDetPerVehExps3;
	}

	public DetPerVehExp addExpDetPerVehExps3(DetPerVehExp expDetPerVehExps3) {
		getExpDetPerVehExps3().add(expDetPerVehExps3);
		expDetPerVehExps3.setCfgValor3(this);

		return expDetPerVehExps3;
	}

	public DetPerVehExp removeExpDetPerVehExps3(DetPerVehExp expDetPerVehExps3) {
		getExpDetPerVehExps3().remove(expDetPerVehExps3);
		expDetPerVehExps3.setCfgValor3(null);

		return expDetPerVehExps3;
	}

	public List<DetPerVehExp> getExpDetPerVehExps4() {
		return this.expDetPerVehExps4;
	}

	public void setExpDetPerVehExps4(List<DetPerVehExp> expDetPerVehExps4) {
		this.expDetPerVehExps4 = expDetPerVehExps4;
	}

	public DetPerVehExp addExpDetPerVehExps4(DetPerVehExp expDetPerVehExps4) {
		getExpDetPerVehExps4().add(expDetPerVehExps4);
		expDetPerVehExps4.setCfgValor4(this);

		return expDetPerVehExps4;
	}

	public DetPerVehExp removeExpDetPerVehExps4(DetPerVehExp expDetPerVehExps4) {
		getExpDetPerVehExps4().remove(expDetPerVehExps4);
		expDetPerVehExps4.setCfgValor4(null);

		return expDetPerVehExps4;
	}

	public List<Documento> getExpDocumentos1() {
		return this.expDocumentos1;
	}

	public void setExpDocumentos1(List<Documento> expDocumentos1) {
		this.expDocumentos1 = expDocumentos1;
	}

	public Documento addExpDocumentos1(Documento expDocumentos1) {
		getExpDocumentos1().add(expDocumentos1);
		expDocumentos1.setCfgValor1(this);

		return expDocumentos1;
	}

	public Documento removeExpDocumentos1(Documento expDocumentos1) {
		getExpDocumentos1().remove(expDocumentos1);
		expDocumentos1.setCfgValor1(null);

		return expDocumentos1;
	}

	public List<Documento> getExpDocumentos2() {
		return this.expDocumentos2;
	}

	public void setExpDocumentos2(List<Documento> expDocumentos2) {
		this.expDocumentos2 = expDocumentos2;
	}

	public Documento addExpDocumentos2(Documento expDocumentos2) {
		getExpDocumentos2().add(expDocumentos2);
		expDocumentos2.setCfgValor2(this);

		return expDocumentos2;
	}

	public Documento removeExpDocumentos2(Documento expDocumentos2) {
		getExpDocumentos2().remove(expDocumentos2);
		expDocumentos2.setCfgValor2(null);

		return expDocumentos2;
	}

	public List<Droga> getExpDrogas1() {
		return this.expDrogas1;
	}

	public void setExpDrogas1(List<Droga> expDrogas1) {
		this.expDrogas1 = expDrogas1;
	}

	public Droga addExpDrogas1(Droga expDrogas1) {
		getExpDrogas1().add(expDrogas1);
		expDrogas1.setCfgValor1(this);

		return expDrogas1;
	}

	public Droga removeExpDrogas1(Droga expDrogas1) {
		getExpDrogas1().remove(expDrogas1);
		expDrogas1.setCfgValor1(null);

		return expDrogas1;
	}

	public List<Droga> getExpDrogas2() {
		return this.expDrogas2;
	}

	public void setExpDrogas2(List<Droga> expDrogas2) {
		this.expDrogas2 = expDrogas2;
	}

	public Droga addExpDrogas2(Droga expDrogas2) {
		getExpDrogas2().add(expDrogas2);
		expDrogas2.setCfgValor2(this);

		return expDrogas2;
	}

	public Droga removeExpDrogas2(Droga expDrogas2) {
		getExpDrogas2().remove(expDrogas2);
		expDrogas2.setCfgValor2(null);

		return expDrogas2;
	}

	public List<Droga> getExpDrogas3() {
		return this.expDrogas3;
	}

	public void setExpDrogas3(List<Droga> expDrogas3) {
		this.expDrogas3 = expDrogas3;
	}

	public Droga addExpDrogas3(Droga expDrogas3) {
		getExpDrogas3().add(expDrogas3);
		expDrogas3.setCfgValor3(this);

		return expDrogas3;
	}

	public Droga removeExpDrogas3(Droga expDrogas3) {
		getExpDrogas3().remove(expDrogas3);
		expDrogas3.setCfgValor3(null);

		return expDrogas3;
	}

	public List<Droga> getExpDrogas4() {
		return this.expDrogas4;
	}

	public void setExpDrogas4(List<Droga> expDrogas4) {
		this.expDrogas4 = expDrogas4;
	}

	public Droga addExpDrogas4(Droga expDrogas4) {
		getExpDrogas4().add(expDrogas4);
		expDrogas4.setCfgValor4(this);

		return expDrogas4;
	}

	public Droga removeExpDrogas4(Droga expDrogas4) {
		getExpDrogas4().remove(expDrogas4);
		expDrogas4.setCfgValor4(null);

		return expDrogas4;
	}

	public List<Entidad> getExpEntidads1() {
		return this.expEntidads1;
	}

	public void setExpEntidads1(List<Entidad> expEntidads1) {
		this.expEntidads1 = expEntidads1;
	}

	public Entidad addExpEntidads1(Entidad expEntidads1) {
		getExpEntidads1().add(expEntidads1);
		expEntidads1.setCfgValor1(this);

		return expEntidads1;
	}

	public Entidad removeExpEntidads1(Entidad expEntidads1) {
		getExpEntidads1().remove(expEntidads1);
		expEntidads1.setCfgValor1(null);

		return expEntidads1;
	}

	public List<Entidad> getExpEntidads2() {
		return this.expEntidads2;
	}

	public void setExpEntidads2(List<Entidad> expEntidads2) {
		this.expEntidads2 = expEntidads2;
	}

	public Entidad addExpEntidads2(Entidad expEntidads2) {
		getExpEntidads2().add(expEntidads2);
		expEntidads2.setCfgValor2(this);

		return expEntidads2;
	}

	public Entidad removeExpEntidads2(Entidad expEntidads2) {
		getExpEntidads2().remove(expEntidads2);
		expEntidads2.setCfgValor2(null);

		return expEntidads2;
	}

	public List<Especie> getExpEspecies1() {
		return this.expEspecies1;
	}

	public void setExpEspecies1(List<Especie> expEspecies1) {
		this.expEspecies1 = expEspecies1;
	}

	public Especie addExpEspecies1(Especie expEspecies1) {
		getExpEspecies1().add(expEspecies1);
		expEspecies1.setCfgValor1(this);

		return expEspecies1;
	}

	public Especie removeExpEspecies1(Especie expEspecies1) {
		getExpEspecies1().remove(expEspecies1);
		expEspecies1.setCfgValor1(null);

		return expEspecies1;
	}

	public List<Especie> getExpEspecies2() {
		return this.expEspecies2;
	}

	public void setExpEspecies2(List<Especie> expEspecies2) {
		this.expEspecies2 = expEspecies2;
	}

	public Especie addExpEspecies2(Especie expEspecies2) {
		getExpEspecies2().add(expEspecies2);
		expEspecies2.setCfgValor2(this);

		return expEspecies2;
	}

	public Especie removeExpEspecies2(Especie expEspecies2) {
		getExpEspecies2().remove(expEspecies2);
		expEspecies2.setCfgValor2(null);

		return expEspecies2;
	}

	public List<Especie> getExpEspecies3() {
		return this.expEspecies3;
	}

	public void setExpEspecies3(List<Especie> expEspecies3) {
		this.expEspecies3 = expEspecies3;
	}

	public Especie addExpEspecies3(Especie expEspecies3) {
		getExpEspecies3().add(expEspecies3);
		expEspecies3.setCfgValor3(this);

		return expEspecies3;
	}

	public Especie removeExpEspecies3(Especie expEspecies3) {
		getExpEspecies3().remove(expEspecies3);
		expEspecies3.setCfgValor3(null);

		return expEspecies3;
	}

	public List<Estado> getExpEstados() {
		return this.expEstados;
	}

	public void setExpEstados(List<Estado> expEstados) {
		this.expEstados = expEstados;
	}

	public Estado addExpEstado(Estado expEstado) {
		getExpEstados().add(expEstado);
		expEstado.setCfgValor(this);

		return expEstado;
	}

	public Estado removeExpEstado(Estado expEstado) {
		getExpEstados().remove(expEstado);
		expEstado.setCfgValor(null);

		return expEstado;
	}

	public List<Expediente> getExpExpedientes1() {
		return this.expExpedientes1;
	}

	public void setExpExpedientes1(List<Expediente> expExpedientes1) {
		this.expExpedientes1 = expExpedientes1;
	}

	public Expediente addExpExpedientes1(Expediente expExpedientes1) {
		getExpExpedientes1().add(expExpedientes1);
		expExpedientes1.setCfgValor1(this);

		return expExpedientes1;
	}

	public Expediente removeExpExpedientes1(Expediente expExpedientes1) {
		getExpExpedientes1().remove(expExpedientes1);
		expExpedientes1.setCfgValor1(null);

		return expExpedientes1;
	}

	public List<Expediente> getExpExpedientes2() {
		return this.expExpedientes2;
	}

	public void setExpExpedientes2(List<Expediente> expExpedientes2) {
		this.expExpedientes2 = expExpedientes2;
	}

	public Expediente addExpExpedientes2(Expediente expExpedientes2) {
		getExpExpedientes2().add(expExpedientes2);
		expExpedientes2.setCfgValor2(this);

		return expExpedientes2;
	}

	public Expediente removeExpExpedientes2(Expediente expExpedientes2) {
		getExpExpedientes2().remove(expExpedientes2);
		expExpedientes2.setCfgValor2(null);

		return expExpedientes2;
	}

	public List<Expediente> getExpExpedientes3() {
		return this.expExpedientes3;
	}

	public void setExpExpedientes3(List<Expediente> expExpedientes3) {
		this.expExpedientes3 = expExpedientes3;
	}

	public Expediente addExpExpedientes3(Expediente expExpedientes3) {
		getExpExpedientes3().add(expExpedientes3);
		expExpedientes3.setCfgValor3(this);

		return expExpedientes3;
	}

	public Expediente removeExpExpedientes3(Expediente expExpedientes3) {
		getExpExpedientes3().remove(expExpedientes3);
		expExpedientes3.setCfgValor3(null);

		return expExpedientes3;
	}

	public List<Expediente> getExpExpedientes4() {
		return this.expExpedientes4;
	}

	public void setExpExpedientes4(List<Expediente> expExpedientes4) {
		this.expExpedientes4 = expExpedientes4;
	}

	public Expediente addExpExpedientes4(Expediente expExpedientes4) {
		getExpExpedientes4().add(expExpedientes4);
		expExpedientes4.setCfgValor4(this);

		return expExpedientes4;
	}

	public Expediente removeExpExpedientes4(Expediente expExpedientes4) {
		getExpExpedientes4().remove(expExpedientes4);
		expExpedientes4.setCfgValor4(null);

		return expExpedientes4;
	}

	public List<ExpedienteDelito> getExpExpedienteDelitos() {
		return this.expExpedienteDelitos;
	}

	public void setExpExpedienteDelitos(List<ExpedienteDelito> expExpedienteDelitos) {
		this.expExpedienteDelitos = expExpedienteDelitos;
	}

	public ExpedienteDelito addExpExpedienteDelito(ExpedienteDelito expExpedienteDelito) {
		getExpExpedienteDelitos().add(expExpedienteDelito);
		expExpedienteDelito.setCfgValor(this);

		return expExpedienteDelito;
	}

	public ExpedienteDelito removeExpExpedienteDelito(ExpedienteDelito expExpedienteDelito) {
		getExpExpedienteDelitos().remove(expExpedienteDelito);
		expExpedienteDelito.setCfgValor(null);

		return expExpedienteDelito;
	}

	public List<ExpedienteMediosMovil> getExpExpedienteMediosMovils() {
		return this.expExpedienteMediosMovils;
	}

	public void setExpExpedienteMediosMovils(List<ExpedienteMediosMovil> expExpedienteMediosMovils) {
		this.expExpedienteMediosMovils = expExpedienteMediosMovils;
	}

	public ExpedienteMediosMovil addExpExpedienteMediosMovil(ExpedienteMediosMovil expExpedienteMediosMovil) {
		getExpExpedienteMediosMovils().add(expExpedienteMediosMovil);
		expExpedienteMediosMovil.setCfgValor(this);

		return expExpedienteMediosMovil;
	}

	public ExpedienteMediosMovil removeExpExpedienteMediosMovil(ExpedienteMediosMovil expExpedienteMediosMovil) {
		getExpExpedienteMediosMovils().remove(expExpedienteMediosMovil);
		expExpedienteMediosMovil.setCfgValor(null);

		return expExpedienteMediosMovil;
	}

	public List<Explosivo> getExpExplosivos1() {
		return this.expExplosivos1;
	}

	public void setExpExplosivos1(List<Explosivo> expExplosivos1) {
		this.expExplosivos1 = expExplosivos1;
	}

	public Explosivo addExpExplosivos1(Explosivo expExplosivos1) {
		getExpExplosivos1().add(expExplosivos1);
		expExplosivos1.setCfgValor1(this);

		return expExplosivos1;
	}

	public Explosivo removeExpExplosivos1(Explosivo expExplosivos1) {
		getExpExplosivos1().remove(expExplosivos1);
		expExplosivos1.setCfgValor1(null);

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
		expExplosivos2.setCfgValor2(this);

		return expExplosivos2;
	}

	public Explosivo removeExpExplosivos2(Explosivo expExplosivos2) {
		getExpExplosivos2().remove(expExplosivos2);
		expExplosivos2.setCfgValor2(null);

		return expExplosivos2;
	}

	public List<Explosivo> getExpExplosivos3() {
		return this.expExplosivos3;
	}

	public void setExpExplosivos3(List<Explosivo> expExplosivos3) {
		this.expExplosivos3 = expExplosivos3;
	}

	public Explosivo addExpExplosivos3(Explosivo expExplosivos3) {
		getExpExplosivos3().add(expExplosivos3);
		expExplosivos3.setCfgValor3(this);

		return expExplosivos3;
	}

	public Explosivo removeExpExplosivos3(Explosivo expExplosivos3) {
		getExpExplosivos3().remove(expExplosivos3);
		expExplosivos3.setCfgValor3(null);

		return expExplosivos3;
	}

	public List<Importe> getExpImportes1() {
		return this.expImportes1;
	}

	public void setExpImportes1(List<Importe> expImportes1) {
		this.expImportes1 = expImportes1;
	}

	public Importe addExpImportes1(Importe expImportes1) {
		getExpImportes1().add(expImportes1);
		expImportes1.setCfgValor1(this);

		return expImportes1;
	}

	public Importe removeExpImportes1(Importe expImportes1) {
		getExpImportes1().remove(expImportes1);
		expImportes1.setCfgValor1(null);

		return expImportes1;
	}

	public List<Importe> getExpImportes2() {
		return this.expImportes2;
	}

	public void setExpImportes2(List<Importe> expImportes2) {
		this.expImportes2 = expImportes2;
	}

	public Importe addExpImportes2(Importe expImportes2) {
		getExpImportes2().add(expImportes2);
		expImportes2.setCfgValor2(this);

		return expImportes2;
	}

	public Importe removeExpImportes2(Importe expImportes2) {
		getExpImportes2().remove(expImportes2);
		expImportes2.setCfgValor2(null);

		return expImportes2;
	}

	public List<Importe> getExpImportes3() {
		return this.expImportes3;
	}

	public void setExpImportes3(List<Importe> expImportes3) {
		this.expImportes3 = expImportes3;
	}

	public Importe addExpImportes3(Importe expImportes3) {
		getExpImportes3().add(expImportes3);
		expImportes3.setCfgValor3(this);

		return expImportes3;
	}

	public Importe removeExpImportes3(Importe expImportes3) {
		getExpImportes3().remove(expImportes3);
		expImportes3.setCfgValor3(null);

		return expImportes3;
	}

	public List<Importe> getExpImportes4() {
		return this.expImportes4;
	}

	public void setExpImportes4(List<Importe> expImportes4) {
		this.expImportes4 = expImportes4;
	}

	public Importe addExpImportes4(Importe expImportes4) {
		getExpImportes4().add(expImportes4);
		expImportes4.setCfgValor4(this);

		return expImportes4;
	}

	public Importe removeExpImportes4(Importe expImportes4) {
		getExpImportes4().remove(expImportes4);
		expImportes4.setCfgValor4(null);

		return expImportes4;
	}

	public List<Importe> getExpImportes5() {
		return this.expImportes5;
	}

	public void setExpImportes5(List<Importe> expImportes5) {
		this.expImportes5 = expImportes5;
	}

	public Importe addExpImportes5(Importe expImportes5) {
		getExpImportes5().add(expImportes5);
		expImportes5.setCfgValor5(this);

		return expImportes5;
	}

	public Importe removeExpImportes5(Importe expImportes5) {
		getExpImportes5().remove(expImportes5);
		expImportes5.setCfgValor5(null);

		return expImportes5;
	}

	public List<Importe> getExpImportes6() {
		return this.expImportes6;
	}

	public void setExpImportes6(List<Importe> expImportes6) {
		this.expImportes6 = expImportes6;
	}

	public Importe addExpImportes6(Importe expImportes6) {
		getExpImportes6().add(expImportes6);
		expImportes6.setCfgValor6(this);

		return expImportes6;
	}

	public Importe removeExpImportes6(Importe expImportes6) {
		getExpImportes6().remove(expImportes6);
		expImportes6.setCfgValor6(null);

		return expImportes6;
	}

	public List<Inmueble> getExpInmuebles() {
		return this.expInmuebles;
	}

	public void setExpInmuebles(List<Inmueble> expInmuebles) {
		this.expInmuebles = expInmuebles;
	}

	public Inmueble addExpInmueble(Inmueble expInmueble) {
		getExpInmuebles().add(expInmueble);
		expInmueble.setCfgValor(this);

		return expInmueble;
	}

	public Inmueble removeExpInmueble(Inmueble expInmueble) {
		getExpInmuebles().remove(expInmueble);
		expInmueble.setCfgValor(null);

		return expInmueble;
	}

	public List<Instalacion> getExpInstalacions1() {
		return this.expInstalacions1;
	}

	public void setExpInstalacions1(List<Instalacion> expInstalacions1) {
		this.expInstalacions1 = expInstalacions1;
	}

	public Instalacion addExpInstalacions1(Instalacion expInstalacions1) {
		getExpInstalacions1().add(expInstalacions1);
		expInstalacions1.setCfgValor1(this);

		return expInstalacions1;
	}

	public Instalacion removeExpInstalacions1(Instalacion expInstalacions1) {
		getExpInstalacions1().remove(expInstalacions1);
		expInstalacions1.setCfgValor1(null);

		return expInstalacions1;
	}

	public List<Instalacion> getExpInstalacions2() {
		return this.expInstalacions2;
	}

	public void setExpInstalacions2(List<Instalacion> expInstalacions2) {
		this.expInstalacions2 = expInstalacions2;
	}

	public Instalacion addExpInstalacions2(Instalacion expInstalacions2) {
		getExpInstalacions2().add(expInstalacions2);
		expInstalacions2.setCfgValor2(this);

		return expInstalacions2;
	}

	public Instalacion removeExpInstalacions2(Instalacion expInstalacions2) {
		getExpInstalacions2().remove(expInstalacions2);
		expInstalacions2.setCfgValor2(null);

		return expInstalacions2;
	}

	public List<Municion> getExpMuniciones1() {
		return this.expMuniciones1;
	}

	public void setExpMuniciones1(List<Municion> expMuniciones1) {
		this.expMuniciones1 = expMuniciones1;
	}

	public Municion addExpMuniciones1(Municion expMuniciones1) {
		getExpMuniciones1().add(expMuniciones1);
		expMuniciones1.setCfgValor1(this);

		return expMuniciones1;
	}

	public Municion removeExpMuniciones1(Municion expMuniciones1) {
		getExpMuniciones1().remove(expMuniciones1);
		expMuniciones1.setCfgValor1(null);

		return expMuniciones1;
	}

	public List<Municion> getExpMuniciones2() {
		return this.expMuniciones2;
	}

	public void setExpMuniciones2(List<Municion> expMuniciones2) {
		this.expMuniciones2 = expMuniciones2;
	}

	public Municion addExpMuniciones2(Municion expMuniciones2) {
		getExpMuniciones2().add(expMuniciones2);
		expMuniciones2.setCfgValor2(this);

		return expMuniciones2;
	}

	public Municion removeExpMuniciones2(Municion expMuniciones2) {
		getExpMuniciones2().remove(expMuniciones2);
		expMuniciones2.setCfgValor2(null);

		return expMuniciones2;
	}

	public List<Municion> getExpMuniciones3() {
		return this.expMuniciones3;
	}

	public void setExpMuniciones3(List<Municion> expMuniciones3) {
		this.expMuniciones3 = expMuniciones3;
	}

	public Municion addExpMuniciones3(Municion expMuniciones3) {
		getExpMuniciones3().add(expMuniciones3);
		expMuniciones3.setCfgValor3(this);

		return expMuniciones3;
	}

	public Municion removeExpMuniciones3(Municion expMuniciones3) {
		getExpMuniciones3().remove(expMuniciones3);
		expMuniciones3.setCfgValor3(null);

		return expMuniciones3;
	}

	public List<Municion> getExpMuniciones4() {
		return this.expMuniciones4;
	}

	public void setExpMuniciones4(List<Municion> expMuniciones4) {
		this.expMuniciones4 = expMuniciones4;
	}

	public Municion addExpMuniciones4(Municion expMuniciones4) {
		getExpMuniciones4().add(expMuniciones4);
		expMuniciones4.setCfgValor4(this);

		return expMuniciones4;
	}

	public Municion removeExpMuniciones4(Municion expMuniciones4) {
		getExpMuniciones4().remove(expMuniciones4);
		expMuniciones4.setCfgValor4(null);

		return expMuniciones4;
	}

	public List<Ruta> getExpRutas1() {
		return this.expRutas1;
	}

	public void setExpRutas1(List<Ruta> expRutas1) {
		this.expRutas1 = expRutas1;
	}

	public Ruta addExpRutas1(Ruta expRutas1) {
		getExpRutas1().add(expRutas1);
		expRutas1.setCfgValor1(this);

		return expRutas1;
	}

	public Ruta removeExpRutas1(Ruta expRutas1) {
		getExpRutas1().remove(expRutas1);
		expRutas1.setCfgValor1(null);

		return expRutas1;
	}

	public List<Ruta> getExpRutas2() {
		return this.expRutas2;
	}

	public void setExpRutas2(List<Ruta> expRutas2) {
		this.expRutas2 = expRutas2;
	}

	public Ruta addExpRutas2(Ruta expRutas2) {
		getExpRutas2().add(expRutas2);
		expRutas2.setCfgValor2(this);

		return expRutas2;
	}

	public Ruta removeExpRutas2(Ruta expRutas2) {
		getExpRutas2().remove(expRutas2);
		expRutas2.setCfgValor2(null);

		return expRutas2;
	}

	public List<Ruta> getExpRutas3() {
		return this.expRutas3;
	}

	public void setExpRutas3(List<Ruta> expRutas3) {
		this.expRutas3 = expRutas3;
	}

	public Ruta addExpRutas3(Ruta expRutas3) {
		getExpRutas3().add(expRutas3);
		expRutas3.setCfgValor3(this);

		return expRutas3;
	}

	public Ruta removeExpRutas3(Ruta expRutas3) {
		getExpRutas3().remove(expRutas3);
		expRutas3.setCfgValor3(null);

		return expRutas3;
	}

	public List<SituacionGeneral> getExpSituacionGenerals1() {
		return this.expSituacionGenerals1;
	}

	public void setExpSituacionGenerals1(List<SituacionGeneral> expSituacionGenerals1) {
		this.expSituacionGenerals1 = expSituacionGenerals1;
	}

	public SituacionGeneral addExpSituacionGenerals1(SituacionGeneral expSituacionGenerals1) {
		getExpSituacionGenerals1().add(expSituacionGenerals1);
		expSituacionGenerals1.setCfgValor1(this);

		return expSituacionGenerals1;
	}

	public SituacionGeneral removeExpSituacionGenerals1(SituacionGeneral expSituacionGenerals1) {
		getExpSituacionGenerals1().remove(expSituacionGenerals1);
		expSituacionGenerals1.setCfgValor1(null);

		return expSituacionGenerals1;
	}

	public List<SituacionGeneral> getExpSituacionGenerals2() {
		return this.expSituacionGenerals2;
	}

	public void setExpSituacionGenerals2(List<SituacionGeneral> expSituacionGenerals2) {
		this.expSituacionGenerals2 = expSituacionGenerals2;
	}

	public SituacionGeneral addExpSituacionGenerals2(SituacionGeneral expSituacionGenerals2) {
		getExpSituacionGenerals2().add(expSituacionGenerals2);
		expSituacionGenerals2.setCfgValor2(this);

		return expSituacionGenerals2;
	}

	public SituacionGeneral removeExpSituacionGenerals2(SituacionGeneral expSituacionGenerals2) {
		getExpSituacionGenerals2().remove(expSituacionGenerals2);
		expSituacionGenerals2.setCfgValor2(null);

		return expSituacionGenerals2;
	}

	public List<TipoHecho> getExpTipoHechos() {
		return this.expTipoHechos;
	}

	public void setExpTipoHechos(List<TipoHecho> expTipoHechos) {
		this.expTipoHechos = expTipoHechos;
	}

	public TipoHecho addExpTipoHecho(TipoHecho expTipoHecho) {
		getExpTipoHechos().add(expTipoHecho);
		expTipoHecho.setCfgValor(this);

		return expTipoHecho;
	}

	public TipoHecho removeExpTipoHecho(TipoHecho expTipoHecho) {
		getExpTipoHechos().remove(expTipoHecho);
		expTipoHecho.setCfgValor(null);

		return expTipoHecho;
	}

	public List<Vehiculo> getExpVehiculos1() {
		return this.expVehiculos1;
	}

	public void setExpVehiculos1(List<Vehiculo> expVehiculos1) {
		this.expVehiculos1 = expVehiculos1;
	}

	public Vehiculo addExpVehiculos1(Vehiculo expVehiculos1) {
		getExpVehiculos1().add(expVehiculos1);
		expVehiculos1.setCfgValor1(this);

		return expVehiculos1;
	}

	public Vehiculo removeExpVehiculos1(Vehiculo expVehiculos1) {
		getExpVehiculos1().remove(expVehiculos1);
		expVehiculos1.setCfgValor1(null);

		return expVehiculos1;
	}

	public List<Vehiculo> getExpVehiculos2() {
		return this.expVehiculos2;
	}

	public void setExpVehiculos2(List<Vehiculo> expVehiculos2) {
		this.expVehiculos2 = expVehiculos2;
	}

	public Vehiculo addExpVehiculos2(Vehiculo expVehiculos2) {
		getExpVehiculos2().add(expVehiculos2);
		expVehiculos2.setCfgValor2(this);

		return expVehiculos2;
	}

	public Vehiculo removeExpVehiculos2(Vehiculo expVehiculos2) {
		getExpVehiculos2().remove(expVehiculos2);
		expVehiculos2.setCfgValor2(null);

		return expVehiculos2;
	}

	public List<Vehiculo> getExpVehiculos3() {
		return this.expVehiculos3;
	}

	public void setExpVehiculos3(List<Vehiculo> expVehiculos3) {
		this.expVehiculos3 = expVehiculos3;
	}

	public Vehiculo addExpVehiculos3(Vehiculo expVehiculos3) {
		getExpVehiculos3().add(expVehiculos3);
		expVehiculos3.setCfgValor3(this);

		return expVehiculos3;
	}

	public Vehiculo removeExpVehiculos3(Vehiculo expVehiculos3) {
		getExpVehiculos3().remove(expVehiculos3);
		expVehiculos3.setCfgValor3(null);

		return expVehiculos3;
	}

	public List<Vehiculo> getExpVehiculos4() {
		return this.expVehiculos4;
	}

	public void setExpVehiculos4(List<Vehiculo> expVehiculos4) {
		this.expVehiculos4 = expVehiculos4;
	}

	public Vehiculo addExpVehiculos4(Vehiculo expVehiculos4) {
		getExpVehiculos4().add(expVehiculos4);
		expVehiculos4.setCfgValor4(this);

		return expVehiculos4;
	}

	public Vehiculo removeExpVehiculos4(Vehiculo expVehiculos4) {
		getExpVehiculos4().remove(expVehiculos4);
		expVehiculos4.setCfgValor4(null);

		return expVehiculos4;
	}

	public List<Vehiculo> getExpVehiculos5() {
		return this.expVehiculos5;
	}

	public void setExpVehiculos5(List<Vehiculo> expVehiculos5) {
		this.expVehiculos5 = expVehiculos5;
	}

	public Vehiculo addExpVehiculos5(Vehiculo expVehiculos5) {
		getExpVehiculos5().add(expVehiculos5);
		expVehiculos5.setCfgValor5(this);

		return expVehiculos5;
	}

	public Vehiculo removeExpVehiculos5(Vehiculo expVehiculos5) {
		getExpVehiculos5().remove(expVehiculos5);
		expVehiculos5.setCfgValor5(null);

		return expVehiculos5;
	}

	public List<Hojaremision> getHrHojaremisions() {
		return this.hrHojaremisions;
	}

	public void setHrHojaremisions(List<Hojaremision> hrHojaremisions) {
		this.hrHojaremisions = hrHojaremisions;
	}

	public Hojaremision addHrHojaremision(Hojaremision hrHojaremision) {
		getHrHojaremisions().add(hrHojaremision);
		hrHojaremision.setCfgValor(this);

		return hrHojaremision;
	}

	public Hojaremision removeHrHojaremision(Hojaremision hrHojaremision) {
		getHrHojaremisions().remove(hrHojaremision);
		hrHojaremision.setCfgValor(null);

		return hrHojaremision;
	}

	public List<ModeloMarca> getMntModeloMarcas() {
		return this.mntModeloMarcas;
	}

	public void setMntModeloMarcas(List<ModeloMarca> mntModeloMarcas) {
		this.mntModeloMarcas = mntModeloMarcas;
	}

	public ModeloMarca addMntModeloMarca(ModeloMarca mntModeloMarca) {
		getMntModeloMarcas().add(mntModeloMarca);
		mntModeloMarca.setCfgValor(this);

		return mntModeloMarca;
	}

	public ModeloMarca removeMntModeloMarca(ModeloMarca mntModeloMarca) {
		getMntModeloMarcas().remove(mntModeloMarca);
		mntModeloMarca.setCfgValor(null);

		return mntModeloMarca;
	}

	public List<Pais> getMntPaises() {
		return this.mntPaises;
	}

	public void setMntPaises(List<Pais> mntPaises) {
		this.mntPaises = mntPaises;
	}

	public Pais addMntPais(Pais mntPais) {
		getMntPaises().add(mntPais);
		mntPais.setCfgValor(this);

		return mntPais;
	}

	public Pais removeMntPais(Pais mntPais) {
		getMntPaises().remove(mntPais);
		mntPais.setCfgValor(null);

		return mntPais;
	}

	public List<Equipo> getOrgEquipos1() {
		return this.orgEquipos1;
	}

	public void setOrgEquipos1(List<Equipo> orgEquipos1) {
		this.orgEquipos1 = orgEquipos1;
	}

	public Equipo addOrgEquipos1(Equipo orgEquipos1) {
		getOrgEquipos1().add(orgEquipos1);
		orgEquipos1.setCfgValor1(this);

		return orgEquipos1;
	}

	public Equipo removeOrgEquipos1(Equipo orgEquipos1) {
		getOrgEquipos1().remove(orgEquipos1);
		orgEquipos1.setCfgValor1(null);

		return orgEquipos1;
	}

	public List<Equipo> getOrgEquipos2() {
		return this.orgEquipos2;
	}

	public void setOrgEquipos2(List<Equipo> orgEquipos2) {
		this.orgEquipos2 = orgEquipos2;
	}

	public Equipo addOrgEquipos2(Equipo orgEquipos2) {
		getOrgEquipos2().add(orgEquipos2);
		orgEquipos2.setCfgValor2(this);

		return orgEquipos2;
	}

	public Equipo removeOrgEquipos2(Equipo orgEquipos2) {
		getOrgEquipos2().remove(orgEquipos2);
		orgEquipos2.setCfgValor2(null);

		return orgEquipos2;
	}

	public List<Integrante> getOrgIntegrantes1() {
		return this.orgIntegrantes1;
	}

	public void setOrgIntegrantes1(List<Integrante> orgIntegrantes1) {
		this.orgIntegrantes1 = orgIntegrantes1;
	}

	public Integrante addOrgIntegrantes1(Integrante orgIntegrantes1) {
		getOrgIntegrantes1().add(orgIntegrantes1);
		orgIntegrantes1.setCfgValor1(this);

		return orgIntegrantes1;
	}

	public Integrante removeOrgIntegrantes1(Integrante orgIntegrantes1) {
		getOrgIntegrantes1().remove(orgIntegrantes1);
		orgIntegrantes1.setCfgValor1(null);

		return orgIntegrantes1;
	}

	public List<Integrante> getOrgIntegrantes2() {
		return this.orgIntegrantes2;
	}

	public void setOrgIntegrantes2(List<Integrante> orgIntegrantes2) {
		this.orgIntegrantes2 = orgIntegrantes2;
	}

	public Integrante addOrgIntegrantes2(Integrante orgIntegrantes2) {
		getOrgIntegrantes2().add(orgIntegrantes2);
		orgIntegrantes2.setCfgValor2(this);

		return orgIntegrantes2;
	}

	public Integrante removeOrgIntegrantes2(Integrante orgIntegrantes2) {
		getOrgIntegrantes2().remove(orgIntegrantes2);
		orgIntegrantes2.setCfgValor2(null);

		return orgIntegrantes2;
	}

	public List<Detalle> getPerDetalles1() {
		return this.perDetalles1;
	}

	public void setPerDetalles1(List<Detalle> perDetalles1) {
		this.perDetalles1 = perDetalles1;
	}

	public Detalle addPerDetalles1(Detalle perDetalles1) {
		getPerDetalles1().add(perDetalles1);
		perDetalles1.setCfgValor1(this);

		return perDetalles1;
	}

	public Detalle removePerDetalles1(Detalle perDetalles1) {
		getPerDetalles1().remove(perDetalles1);
		perDetalles1.setCfgValor1(null);

		return perDetalles1;
	}

	public List<Detalle> getPerDetalles2() {
		return this.perDetalles2;
	}

	public void setPerDetalles2(List<Detalle> perDetalles2) {
		this.perDetalles2 = perDetalles2;
	}

	public Detalle addPerDetalles2(Detalle perDetalles2) {
		getPerDetalles2().add(perDetalles2);
		perDetalles2.setCfgValor2(this);

		return perDetalles2;
	}

	public Detalle removePerDetalles2(Detalle perDetalles2) {
		getPerDetalles2().remove(perDetalles2);
		perDetalles2.setCfgValor2(null);

		return perDetalles2;
	}

	public List<Detalle> getPerDetalles3() {
		return this.perDetalles3;
	}

	public void setPerDetalles3(List<Detalle> perDetalles3) {
		this.perDetalles3 = perDetalles3;
	}

	public Detalle addPerDetalles3(Detalle perDetalles3) {
		getPerDetalles3().add(perDetalles3);
		perDetalles3.setCfgValor3(this);

		return perDetalles3;
	}

	public Detalle removePerDetalles3(Detalle perDetalles3) {
		getPerDetalles3().remove(perDetalles3);
		perDetalles3.setCfgValor3(null);

		return perDetalles3;
	}

	public List<Detalle> getPerDetalles4() {
		return this.perDetalles4;
	}

	public void setPerDetalles4(List<Detalle> perDetalles4) {
		this.perDetalles4 = perDetalles4;
	}

	public Detalle addPerDetalles4(Detalle perDetalles4) {
		getPerDetalles4().add(perDetalles4);
		perDetalles4.setCfgValor4(this);

		return perDetalles4;
	}

	public Detalle removePerDetalles4(Detalle perDetalles4) {
		getPerDetalles4().remove(perDetalles4);
		perDetalles4.setCfgValor4(null);

		return perDetalles4;
	}

	public List<Detalle> getPerDetalles5() {
		return this.perDetalles5;
	}

	public void setPerDetalles5(List<Detalle> perDetalles5) {
		this.perDetalles5 = perDetalles5;
	}

	public Detalle addPerDetalles5(Detalle perDetalles5) {
		getPerDetalles5().add(perDetalles5);
		perDetalles5.setCfgValor5(this);

		return perDetalles5;
	}

	public Detalle removePerDetalles5(Detalle perDetalles5) {
		getPerDetalles5().remove(perDetalles5);
		perDetalles5.setCfgValor5(null);

		return perDetalles5;
	}

	public List<Detalle> getPerDetalles6() {
		return this.perDetalles6;
	}

	public void setPerDetalles6(List<Detalle> perDetalles6) {
		this.perDetalles6 = perDetalles6;
	}

	public Detalle addPerDetalles6(Detalle perDetalles6) {
		getPerDetalles6().add(perDetalles6);
		perDetalles6.setCfgValor6(this);

		return perDetalles6;
	}

	public Detalle removePerDetalles6(Detalle perDetalles6) {
		getPerDetalles6().remove(perDetalles6);
		perDetalles6.setCfgValor6(null);

		return perDetalles6;
	}

	public List<Detalle> getPerDetalles7() {
		return this.perDetalles7;
	}

	public void setPerDetalles7(List<Detalle> perDetalles7) {
		this.perDetalles7 = perDetalles7;
	}

	public Detalle addPerDetalles7(Detalle perDetalles7) {
		getPerDetalles7().add(perDetalles7);
		perDetalles7.setCfgValor7(this);

		return perDetalles7;
	}

	public Detalle removePerDetalles7(Detalle perDetalles7) {
		getPerDetalles7().remove(perDetalles7);
		perDetalles7.setCfgValor7(null);

		return perDetalles7;
	}

	public List<Detalle> getPerDetalles8() {
		return this.perDetalles8;
	}

	public void setPerDetalles8(List<Detalle> perDetalles8) {
		this.perDetalles8 = perDetalles8;
	}

	public Detalle addPerDetalles8(Detalle perDetalles8) {
		getPerDetalles8().add(perDetalles8);
		perDetalles8.setCfgValor8(this);

		return perDetalles8;
	}

	public Detalle removePerDetalles8(Detalle perDetalles8) {
		getPerDetalles8().remove(perDetalles8);
		perDetalles8.setCfgValor8(null);

		return perDetalles8;
	}

	public List<Detalle> getPerDetalles9() {
		return this.perDetalles9;
	}

	public void setPerDetalles9(List<Detalle> perDetalles9) {
		this.perDetalles9 = perDetalles9;
	}

	public Detalle addPerDetalles9(Detalle perDetalles9) {
		getPerDetalles9().add(perDetalles9);
		perDetalles9.setCfgValor9(this);

		return perDetalles9;
	}

	public Detalle removePerDetalles9(Detalle perDetalles9) {
		getPerDetalles9().remove(perDetalles9);
		perDetalles9.setCfgValor9(null);

		return perDetalles9;
	}

	public List<Detalle> getPerDetalles10() {
		return this.perDetalles10;
	}

	public void setPerDetalles10(List<Detalle> perDetalles10) {
		this.perDetalles10 = perDetalles10;
	}

	public Detalle addPerDetalles10(Detalle perDetalles10) {
		getPerDetalles10().add(perDetalles10);
		perDetalles10.setCfgValor10(this);

		return perDetalles10;
	}

	public Detalle removePerDetalles10(Detalle perDetalles10) {
		getPerDetalles10().remove(perDetalles10);
		perDetalles10.setCfgValor10(null);

		return perDetalles10;
	}

	public List<Detalle> getPerDetalles11() {
		return this.perDetalles11;
	}

	public void setPerDetalles11(List<Detalle> perDetalles11) {
		this.perDetalles11 = perDetalles11;
	}

	public Detalle addPerDetalles11(Detalle perDetalles11) {
		getPerDetalles11().add(perDetalles11);
		perDetalles11.setCfgValor11(this);

		return perDetalles11;
	}

	public Detalle removePerDetalles11(Detalle perDetalles11) {
		getPerDetalles11().remove(perDetalles11);
		perDetalles11.setCfgValor11(null);

		return perDetalles11;
	}

	public List<Detalle> getPerDetalles12() {
		return this.perDetalles12;
	}

	public void setPerDetalles12(List<Detalle> perDetalles12) {
		this.perDetalles12 = perDetalles12;
	}

	public Detalle addPerDetalles12(Detalle perDetalles12) {
		getPerDetalles12().add(perDetalles12);
		perDetalles12.setCfgValor12(this);

		return perDetalles12;
	}

	public Detalle removePerDetalles12(Detalle perDetalles12) {
		getPerDetalles12().remove(perDetalles12);
		perDetalles12.setCfgValor12(null);

		return perDetalles12;
	}

	public List<Detalle> getPerDetalles13() {
		return this.perDetalles13;
	}

	public void setPerDetalles13(List<Detalle> perDetalles13) {
		this.perDetalles13 = perDetalles13;
	}

	public Detalle addPerDetalles13(Detalle perDetalles13) {
		getPerDetalles13().add(perDetalles13);
		perDetalles13.setCfgValor13(this);

		return perDetalles13;
	}

	public Detalle removePerDetalles13(Detalle perDetalles13) {
		getPerDetalles13().remove(perDetalles13);
		perDetalles13.setCfgValor13(null);

		return perDetalles13;
	}

	public List<Detalle> getPerDetalles14() {
		return this.perDetalles14;
	}

	public void setPerDetalles14(List<Detalle> perDetalles14) {
		this.perDetalles14 = perDetalles14;
	}

	public Detalle addPerDetalles14(Detalle perDetalles14) {
		getPerDetalles14().add(perDetalles14);
		perDetalles14.setCfgValor14(this);

		return perDetalles14;
	}

	public Detalle removePerDetalles14(Detalle perDetalles14) {
		getPerDetalles14().remove(perDetalles14);
		perDetalles14.setCfgValor14(null);

		return perDetalles14;
	}

	public List<Detalle> getPerDetalles15() {
		return this.perDetalles15;
	}

	public void setPerDetalles15(List<Detalle> perDetalles15) {
		this.perDetalles15 = perDetalles15;
	}

	public Detalle addPerDetalles15(Detalle perDetalles15) {
		getPerDetalles15().add(perDetalles15);
		perDetalles15.setCfgValor15(this);

		return perDetalles15;
	}

	public Detalle removePerDetalles15(Detalle perDetalles15) {
		getPerDetalles15().remove(perDetalles15);
		perDetalles15.setCfgValor15(null);

		return perDetalles15;
	}

	public List<Empresa> getPerEmpresas() {
		return this.perEmpresas;
	}

	public void setPerEmpresas(List<Empresa> perEmpresas) {
		this.perEmpresas = perEmpresas;
	}

	public Empresa addPerEmpresa(Empresa perEmpresa) {
		getPerEmpresas().add(perEmpresa);
		perEmpresa.setCfgValor(this);

		return perEmpresa;
	}

	public Empresa removePerEmpresa(Empresa perEmpresa) {
		getPerEmpresas().remove(perEmpresa);
		perEmpresa.setCfgValor(null);

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
		perIdentificacion.setCfgValor(this);

		return perIdentificacion;
	}

	public Identificacion removePerIdentificacion(Identificacion perIdentificacion) {
		getPerIdentificacions().remove(perIdentificacion);
		perIdentificacion.setCfgValor(null);

		return perIdentificacion;
	}

	public List<Letrado> getPerLetrados() {
		return this.perLetrados;
	}

	public void setPerLetrados(List<Letrado> perLetrados) {
		this.perLetrados = perLetrados;
	}

	public Letrado addPerLetrado(Letrado perLetrado) {
		getPerLetrados().add(perLetrado);
		perLetrado.setCfgValor(this);

		return perLetrado;
	}

	public Letrado removePerLetrado(Letrado perLetrado) {
		getPerLetrados().remove(perLetrado);
		perLetrado.setCfgValor(null);

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
		perNoIdentificado.setCfgValor(this);

		return perNoIdentificado;
	}

	public NoIdentificado removePerNoIdentificado(NoIdentificado perNoIdentificado) {
		getPerNoIdentificados().remove(perNoIdentificado);
		perNoIdentificado.setCfgValor(null);

		return perNoIdentificado;
	}

	public List<Parentesco> getPerParentescos() {
		return this.perParentescos;
	}

	public void setPerParentescos(List<Parentesco> perParentescos) {
		this.perParentescos = perParentescos;
	}

	public Parentesco addPerParentesco(Parentesco perParentesco) {
		getPerParentescos().add(perParentesco);
		perParentesco.setCfgValor(this);

		return perParentesco;
	}

	public Parentesco removePerParentesco(Parentesco perParentesco) {
		getPerParentescos().remove(perParentesco);
		perParentesco.setCfgValor(null);

		return perParentesco;
	}

	public List<Persona> getPerPersonas1() {
		return this.perPersonas1;
	}

	public void setPerPersonas1(List<Persona> perPersonas1) {
		this.perPersonas1 = perPersonas1;
	}

	public Persona addPerPersonas1(Persona perPersonas1) {
		getPerPersonas1().add(perPersonas1);
		perPersonas1.setCfgValor1(this);

		return perPersonas1;
	}

	public Persona removePerPersonas1(Persona perPersonas1) {
		getPerPersonas1().remove(perPersonas1);
		perPersonas1.setCfgValor1(null);

		return perPersonas1;
	}

	public List<Persona> getPerPersonas2() {
		return this.perPersonas2;
	}

	public void setPerPersonas2(List<Persona> perPersonas2) {
		this.perPersonas2 = perPersonas2;
	}

	public Persona addPerPersonas2(Persona perPersonas2) {
		getPerPersonas2().add(perPersonas2);
		perPersonas2.setCfgValor2(this);

		return perPersonas2;
	}

	public Persona removePerPersonas2(Persona perPersonas2) {
		getPerPersonas2().remove(perPersonas2);
		perPersonas2.setCfgValor2(null);

		return perPersonas2;
	}

	public List<Persona> getPerPersonas3() {
		return this.perPersonas3;
	}

	public void setPerPersonas3(List<Persona> perPersonas3) {
		this.perPersonas3 = perPersonas3;
	}

	public Persona addPerPersonas3(Persona perPersonas3) {
		getPerPersonas3().add(perPersonas3);
		perPersonas3.setCfgValor3(this);

		return perPersonas3;
	}

	public Persona removePerPersonas3(Persona perPersonas3) {
		getPerPersonas3().remove(perPersonas3);
		perPersonas3.setCfgValor3(null);

		return perPersonas3;
	}

	public List<Policia> getPerPolicias1() {
		return this.perPolicias1;
	}

	public void setPerPolicias1(List<Policia> perPolicias1) {
		this.perPolicias1 = perPolicias1;
	}

	public Policia addPerPolicias1(Policia perPolicias1) {
		getPerPolicias1().add(perPolicias1);
		perPolicias1.setCfgValor1(this);

		return perPolicias1;
	}

	public Policia removePerPolicias1(Policia perPolicias1) {
		getPerPolicias1().remove(perPolicias1);
		perPolicias1.setCfgValor1(null);

		return perPolicias1;
	}

	public List<Policia> getPerPolicias2() {
		return this.perPolicias2;
	}

	public void setPerPolicias2(List<Policia> perPolicias2) {
		this.perPolicias2 = perPolicias2;
	}

	public Policia addPerPolicias2(Policia perPolicias2) {
		getPerPolicias2().add(perPolicias2);
		perPolicias2.setCfgValor2(this);

		return perPolicias2;
	}

	public Policia removePerPolicias2(Policia perPolicias2) {
		getPerPolicias2().remove(perPolicias2);
		perPolicias2.setCfgValor2(null);

		return perPolicias2;
	}

	public List<Telefono> getPerTelefonos1() {
		return this.perTelefonos1;
	}

	public void setPerTelefonos1(List<Telefono> perTelefonos1) {
		this.perTelefonos1 = perTelefonos1;
	}

	public Telefono addPerTelefonos1(Telefono perTelefonos1) {
		getPerTelefonos1().add(perTelefonos1);
		perTelefonos1.setCfgValor1(this);

		return perTelefonos1;
	}

	public Telefono removePerTelefonos1(Telefono perTelefonos1) {
		getPerTelefonos1().remove(perTelefonos1);
		perTelefonos1.setCfgValor1(null);

		return perTelefonos1;
	}

	public List<Telefono> getPerTelefonos2() {
		return this.perTelefonos2;
	}

	public void setPerTelefonos2(List<Telefono> perTelefonos2) {
		this.perTelefonos2 = perTelefonos2;
	}

	public Telefono addPerTelefonos2(Telefono perTelefonos2) {
		getPerTelefonos2().add(perTelefonos2);
		perTelefonos2.setCfgValor2(this);

		return perTelefonos2;
	}

	public Telefono removePerTelefonos2(Telefono perTelefonos2) {
		getPerTelefonos2().remove(perTelefonos2);
		perTelefonos2.setCfgValor2(null);

		return perTelefonos2;
	}

	public List<Opcion> getSegOpcions1() {
		return this.segOpcions1;
	}

	public void setSegOpcions1(List<Opcion> segOpcions1) {
		this.segOpcions1 = segOpcions1;
	}

	public Opcion addSegOpcions1(Opcion segOpcions1) {
		getSegOpcions1().add(segOpcions1);
		segOpcions1.setCfgValor1(this);

		return segOpcions1;
	}

	public Opcion removeSegOpcions1(Opcion segOpcions1) {
		getSegOpcions1().remove(segOpcions1);
		segOpcions1.setCfgValor1(null);

		return segOpcions1;
	}

	public List<Opcion> getSegOpcions2() {
		return this.segOpcions2;
	}

	public void setSegOpcions2(List<Opcion> segOpcions2) {
		this.segOpcions2 = segOpcions2;
	}

	public Opcion addSegOpcions2(Opcion segOpcions2) {
		getSegOpcions2().add(segOpcions2);
		segOpcions2.setCfgValor2(this);

		return segOpcions2;
	}

	public Opcion removeSegOpcions2(Opcion segOpcions2) {
		getSegOpcions2().remove(segOpcions2);
		segOpcions2.setCfgValor2(null);

		return segOpcions2;
	}

	public List<Permiso> getSegPermisos() {
		return this.segPermisos;
	}

	public void setSegPermisos(List<Permiso> segPermisos) {
		this.segPermisos = segPermisos;
	}

	public Permiso addSegPermiso(Permiso segPermiso) {
		getSegPermisos().add(segPermiso);
		segPermiso.setCfgValor(this);

		return segPermiso;
	}

	public Permiso removeSegPermiso(Permiso segPermiso) {
		getSegPermisos().remove(segPermiso);
		segPermiso.setCfgValor(null);

		return segPermiso;
	}

	public List<Rol> getSegRols() {
		return this.segRols;
	}

	public void setSegRols(List<Rol> segRols) {
		this.segRols = segRols;
	}

	public Rol addSegRol(Rol segRol) {
		getSegRols().add(segRol);
		segRol.setCfgValor(this);

		return segRol;
	}

	public Rol removeSegRol(Rol segRol) {
		getSegRols().remove(segRol);
		segRol.setCfgValor(null);

		return segRol;
	}

	public List<Departamento> getUbgDepartamentos() {
		return this.ubgDepartamentos;
	}

	public void setUbgDepartamentos(List<Departamento> ubgDepartamentos) {
		this.ubgDepartamentos = ubgDepartamentos;
	}

	public Departamento addUbgDepartamento(Departamento ubgDepartamento) {
		getUbgDepartamentos().add(ubgDepartamento);
		ubgDepartamento.setCfgValor(this);

		return ubgDepartamento;
	}

	public Departamento removeUbgDepartamento(Departamento ubgDepartamento) {
		getUbgDepartamentos().remove(ubgDepartamento);
		ubgDepartamento.setCfgValor(null);

		return ubgDepartamento;
	}

	public List<Distrito> getUbgDistritos() {
		return this.ubgDistritos;
	}

	public void setUbgDistritos(List<Distrito> ubgDistritos) {
		this.ubgDistritos = ubgDistritos;
	}

	public Distrito addUbgDistrito(Distrito ubgDistrito) {
		getUbgDistritos().add(ubgDistrito);
		ubgDistrito.setCfgValor(this);

		return ubgDistrito;
	}

	public Distrito removeUbgDistrito(Distrito ubgDistrito) {
		getUbgDistritos().remove(ubgDistrito);
		ubgDistrito.setCfgValor(null);

		return ubgDistrito;
	}

	public List<Provincia> getUbgProvincias() {
		return this.ubgProvincias;
	}

	public void setUbgProvincias(List<Provincia> ubgProvincias) {
		this.ubgProvincias = ubgProvincias;
	}

	public Provincia addUbgProvincia(Provincia ubgProvincia) {
		getUbgProvincias().add(ubgProvincia);
		ubgProvincia.setCfgValor(this);

		return ubgProvincia;
	}

	public Provincia removeUbgProvincia(Provincia ubgProvincia) {
		getUbgProvincias().remove(ubgProvincia);
		ubgProvincia.setCfgValor(null);

		return ubgProvincia;
	}

}