package pe.gob.mininter.dirandro.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the SEG_USUARIO database table.
 * 
 */
@Entity
@Table(name="SEG_USUARIO")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SEG_USUARIO_ID_GENERATOR", sequenceName="SEQ_")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEG_USUARIO_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=16)
	private long id;

	@Column(name="APE_MAT", length=400)
	private String apeMat;

	@Column(name="APE_PAT", length=400)
	private String apePat;

	@Column(length=100)
	private String cargo;

	@Column(nullable=false, length=512)
	private String clave;

	private Timestamp creacion;

	@Column(name="DESC_CARGO", length=100)
	private String descCargo;

	private Timestamp edicion;

	@Column(length=400)
	private String nombres;

	@Column(nullable=false, length=20)
	private String usuario;

	//bi-directional many-to-one association to Lista
	@OneToMany(mappedBy="segUsuario1")
	private List<Lista> cfgListas1;

	//bi-directional many-to-one association to Lista
	@OneToMany(mappedBy="segUsuario2")
	private List<Lista> cfgListas2;

	//bi-directional many-to-one association to Parametro
	@OneToMany(mappedBy="segUsuario1")
	private List<Parametro> cfgParametros1;

	//bi-directional many-to-one association to Parametro
	@OneToMany(mappedBy="segUsuario2")
	private List<Parametro> cfgParametros2;

	//bi-directional many-to-one association to Regla
	@OneToMany(mappedBy="segUsuario1")
	private List<Regla> cfgReglas1;

	//bi-directional many-to-one association to Regla
	@OneToMany(mappedBy="segUsuario2")
	private List<Regla> cfgReglas2;

	//bi-directional many-to-one association to Valor
	@OneToMany(mappedBy="segUsuario1")
	private List<Valor> cfgValors1;

	//bi-directional many-to-one association to Valor
	@OneToMany(mappedBy="segUsuario2")
	private List<Valor> cfgValors2;

	//bi-directional many-to-one association to AbogadoPersona
	@OneToMany(mappedBy="segUsuario1")
	private List<AbogadoPersona> expAbogadoPersonas1;

	//bi-directional many-to-one association to AbogadoPersona
	@OneToMany(mappedBy="segUsuario2")
	private List<AbogadoPersona> expAbogadoPersonas2;

	//bi-directional many-to-one association to Adjunto
	@OneToMany(mappedBy="segUsuario1")
	private List<Adjunto> expAdjuntos1;

	//bi-directional many-to-one association to Adjunto
	@OneToMany(mappedBy="segUsuario2")
	private List<Adjunto> expAdjuntos2;

	//bi-directional many-to-one association to Anexo
	@OneToMany(mappedBy="segUsuario1")
	private List<Anexo> expAnexos1;

	//bi-directional many-to-one association to Anexo
	@OneToMany(mappedBy="segUsuario2")
	private List<Anexo> expAnexos2;

	//bi-directional many-to-one association to Arma
	@OneToMany(mappedBy="segUsuario1")
	private List<Arma> expArmas1;

	//bi-directional many-to-one association to Arma
	@OneToMany(mappedBy="segUsuario2")
	private List<Arma> expArmas2;

	//bi-directional many-to-one association to CentroPoblado
	@OneToMany(mappedBy="segUsuario1")
	private List<CentroPoblado> expCentroPoblados1;

	//bi-directional many-to-one association to CentroPoblado
	@OneToMany(mappedBy="segUsuario2")
	private List<CentroPoblado> expCentroPoblados2;

	//bi-directional many-to-one association to Delito
	@OneToMany(mappedBy="segUsuario1")
	private List<Delito> expDelitos1;

	//bi-directional many-to-one association to Delito
	@OneToMany(mappedBy="segUsuario2")
	private List<Delito> expDelitos2;

	//bi-directional many-to-one association to Dependencia
	@OneToMany(mappedBy="segUsuario1")
	private List<Dependencia> expDependencias1;

	//bi-directional many-to-one association to Dependencia
	@OneToMany(mappedBy="segUsuario2")
	private List<Dependencia> expDependencias2;

	//bi-directional many-to-one association to DetCrimen
	@OneToMany(mappedBy="segUsuario1")
	private List<DetCrimen> expDetCrimens1;

	//bi-directional many-to-one association to DetCrimen
	@OneToMany(mappedBy="segUsuario2")
	private List<DetCrimen> expDetCrimens2;

	//bi-directional many-to-one association to DetDroga
	@OneToMany(mappedBy="segUsuario1")
	private List<DetDroga> expDetDrogas1;

	//bi-directional many-to-one association to DetDroga
	@OneToMany(mappedBy="segUsuario2")
	private List<DetDroga> expDetDrogas2;

	//bi-directional many-to-one association to DetExpedientePersona
	@OneToMany(mappedBy="segUsuario1")
	private List<DetExpedientePersona> expDetExpedientePersonas1;

	//bi-directional many-to-one association to DetExpedientePersona
	@OneToMany(mappedBy="segUsuario2")
	private List<DetExpedientePersona> expDetExpedientePersonas2;

	//bi-directional many-to-one association to DetLlamada
	@OneToMany(mappedBy="segUsuario1")
	private List<DetLlamada> expDetLlamadas1;

	//bi-directional many-to-one association to DetLlamada
	@OneToMany(mappedBy="segUsuario2")
	private List<DetLlamada> expDetLlamadas2;

	//bi-directional many-to-one association to DetPerArmExp
	@OneToMany(mappedBy="segUsuario1")
	private List<DetPerArmExp> expDetPerArmExps1;

	//bi-directional many-to-one association to DetPerArmExp
	@OneToMany(mappedBy="segUsuario2")
	private List<DetPerArmExp> expDetPerArmExps2;

	//bi-directional many-to-one association to DetPerInmExp
	@OneToMany(mappedBy="segUsuario1")
	private List<DetPerInmExp> expDetPerInmExps1;

	//bi-directional many-to-one association to DetPerInmExp
	@OneToMany(mappedBy="segUsuario2")
	private List<DetPerInmExp> expDetPerInmExps2;

	//bi-directional many-to-one association to DetPerTelExp
	@OneToMany(mappedBy="segUsuario1")
	private List<DetPerTelExp> expDetPerTelExps1;

	//bi-directional many-to-one association to DetPerTelExp
	@OneToMany(mappedBy="segUsuario2")
	private List<DetPerTelExp> expDetPerTelExps2;

	//bi-directional many-to-one association to DetPerVehExp
	@OneToMany(mappedBy="segUsuario1")
	private List<DetPerVehExp> expDetPerVehExps1;

	//bi-directional many-to-one association to DetPerVehExp
	@OneToMany(mappedBy="segUsuario2")
	private List<DetPerVehExp> expDetPerVehExps2;

	//bi-directional many-to-one association to Documento
	@OneToMany(mappedBy="segUsuario1")
	private List<Documento> expDocumentos1;

	//bi-directional many-to-one association to Documento
	@OneToMany(mappedBy="segUsuario2")
	private List<Documento> expDocumentos2;

	//bi-directional many-to-one association to Droga
	@OneToMany(mappedBy="segUsuario1")
	private List<Droga> expDrogas1;

	//bi-directional many-to-one association to Droga
	@OneToMany(mappedBy="segUsuario2")
	private List<Droga> expDrogas2;

	//bi-directional many-to-one association to Entidad
	@OneToMany(mappedBy="segUsuario1")
	private List<Entidad> expEntidads1;

	//bi-directional many-to-one association to Entidad
	@OneToMany(mappedBy="segUsuario2")
	private List<Entidad> expEntidads2;

	//bi-directional many-to-one association to Especie
	@OneToMany(mappedBy="segUsuario1")
	private List<Especie> expEspecies1;

	//bi-directional many-to-one association to Especie
	@OneToMany(mappedBy="segUsuario2")
	private List<Especie> expEspecies2;

	//bi-directional many-to-one association to Estado
	@OneToMany(mappedBy="segUsuario1")
	private List<Estado> expEstados1;

	//bi-directional many-to-one association to Estado
	@OneToMany(mappedBy="segUsuario2")
	private List<Estado> expEstados2;

	//bi-directional many-to-one association to Expediente
	@OneToMany(mappedBy="segUsuario1")
	private List<Expediente> expExpedientes1;

	//bi-directional many-to-one association to Expediente
	@OneToMany(mappedBy="segUsuario2")
	private List<Expediente> expExpedientes2;

	//bi-directional many-to-one association to ExpedienteDelito
	@OneToMany(mappedBy="segUsuario1")
	private List<ExpedienteDelito> expExpedienteDelitos1;

	//bi-directional many-to-one association to ExpedienteDelito
	@OneToMany(mappedBy="segUsuario2")
	private List<ExpedienteDelito> expExpedienteDelitos2;

	//bi-directional many-to-one association to ExpedienteMediosMovil
	@OneToMany(mappedBy="segUsuario1")
	private List<ExpedienteMediosMovil> expExpedienteMediosMovils1;

	//bi-directional many-to-one association to ExpedienteMediosMovil
	@OneToMany(mappedBy="segUsuario2")
	private List<ExpedienteMediosMovil> expExpedienteMediosMovils2;

	//bi-directional many-to-one association to Explosivo
	@OneToMany(mappedBy="segUsuario1")
	private List<Explosivo> expExplosivos1;

	//bi-directional many-to-one association to Explosivo
	@OneToMany(mappedBy="segUsuario2")
	private List<Explosivo> expExplosivos2;

	//bi-directional many-to-one association to Importe
	@OneToMany(mappedBy="segUsuario1")
	private List<Importe> expImportes1;

	//bi-directional many-to-one association to Importe
	@OneToMany(mappedBy="segUsuario2")
	private List<Importe> expImportes2;

	//bi-directional many-to-one association to Inmueble
	@OneToMany(mappedBy="segUsuario1")
	private List<Inmueble> expInmuebles1;

	//bi-directional many-to-one association to Inmueble
	@OneToMany(mappedBy="segUsuario2")
	private List<Inmueble> expInmuebles2;

	//bi-directional many-to-one association to Instalacion
	@OneToMany(mappedBy="segUsuario1")
	private List<Instalacion> expInstalacions1;

	//bi-directional many-to-one association to Instalacion
	@OneToMany(mappedBy="segUsuario2")
	private List<Instalacion> expInstalacions2;

	//bi-directional many-to-one association to Municione
	@OneToMany(mappedBy="segUsuario1")
	private List<Municione> expMuniciones1;

	//bi-directional many-to-one association to Municione
	@OneToMany(mappedBy="segUsuario2")
	private List<Municione> expMuniciones2;

	//bi-directional many-to-one association to Organizacion
	@OneToMany(mappedBy="segUsuario1")
	private List<Organizacion> expOrganizacions1;

	//bi-directional many-to-one association to Organizacion
	@OneToMany(mappedBy="segUsuario2")
	private List<Organizacion> expOrganizacions2;

	//bi-directional many-to-one association to Predecesor
	@OneToMany(mappedBy="segUsuario1")
	private List<Predecesor> expPredecesors1;

	//bi-directional many-to-one association to Predecesor
	@OneToMany(mappedBy="segUsuario2")
	private List<Predecesor> expPredecesors2;

	//bi-directional many-to-one association to Ruta
	@OneToMany(mappedBy="segUsuario1")
	private List<Ruta> expRutas1;

	//bi-directional many-to-one association to Ruta
	@OneToMany(mappedBy="segUsuario2")
	private List<Ruta> expRutas2;

	//bi-directional many-to-one association to Ruta
	@OneToMany(mappedBy="segUsuario3")
	private List<Ruta> expRutas3;

	//bi-directional many-to-one association to Ruta
	@OneToMany(mappedBy="segUsuario4")
	private List<Ruta> expRutas4;

	//bi-directional many-to-one association to SituacionGeneral
	@OneToMany(mappedBy="segUsuario1")
	private List<SituacionGeneral> expSituacionGenerals1;

	//bi-directional many-to-one association to SituacionGeneral
	@OneToMany(mappedBy="segUsuario2")
	private List<SituacionGeneral> expSituacionGenerals2;

	//bi-directional many-to-one association to TipoHecho
	@OneToMany(mappedBy="segUsuario1")
	private List<TipoHecho> expTipoHechos1;

	//bi-directional many-to-one association to TipoHecho
	@OneToMany(mappedBy="segUsuario2")
	private List<TipoHecho> expTipoHechos2;

	//bi-directional many-to-one association to Vehiculo
	@OneToMany(mappedBy="segUsuario1")
	private List<Vehiculo> expVehiculos1;

	//bi-directional many-to-one association to Vehiculo
	@OneToMany(mappedBy="segUsuario2")
	private List<Vehiculo> expVehiculos2;

	//bi-directional many-to-one association to Hojaremision
	@OneToMany(mappedBy="segUsuario1")
	private List<Hojaremision> hrHojaremisions1;

	//bi-directional many-to-one association to Hojaremision
	@OneToMany(mappedBy="segUsuario2")
	private List<Hojaremision> hrHojaremisions2;

	//bi-directional many-to-one association to HojaremisionMuestra
	@OneToMany(mappedBy="segUsuario1")
	private List<HojaremisionMuestra> hrHojaremisionMuestras1;

	//bi-directional many-to-one association to HojaremisionMuestra
	@OneToMany(mappedBy="segUsuario2")
	private List<HojaremisionMuestra> hrHojaremisionMuestras2;

	//bi-directional many-to-one association to ModeloMarca
	@OneToMany(mappedBy="segUsuario1")
	private List<ModeloMarca> mntModeloMarcas1;

	//bi-directional many-to-one association to ModeloMarca
	@OneToMany(mappedBy="segUsuario2")
	private List<ModeloMarca> mntModeloMarcas2;

	//bi-directional many-to-one association to Pais
	@OneToMany(mappedBy="segUsuario1")
	private List<Pais> mntPaises1;

	//bi-directional many-to-one association to Pais
	@OneToMany(mappedBy="segUsuario2")
	private List<Pais> mntPaises2;

	//bi-directional many-to-one association to TipoEspecie
	@OneToMany(mappedBy="segUsuario1")
	private List<TipoEspecie> mntTipoEspecies1;

	//bi-directional many-to-one association to TipoEspecie
	@OneToMany(mappedBy="segUsuario2")
	private List<TipoEspecie> mntTipoEspecies2;

	//bi-directional many-to-one association to Equipo
	@OneToMany(mappedBy="segUsuario1")
	private List<Equipo> orgEquipos1;

	//bi-directional many-to-one association to Equipo
	@OneToMany(mappedBy="segUsuario2")
	private List<Equipo> orgEquipos2;

	//bi-directional many-to-one association to Integrante
	@OneToMany(mappedBy="segUsuario1")
	private List<Integrante> orgIntegrantes1;

	//bi-directional many-to-one association to Integrante
	@OneToMany(mappedBy="segUsuario2")
	private List<Integrante> orgIntegrantes2;

	//bi-directional many-to-one association to Integrante
	@OneToMany(mappedBy="segUsuario3")
	private List<Integrante> orgIntegrantes3;

	//bi-directional many-to-one association to Correo
	@OneToMany(mappedBy="segUsuario1")
	private List<Correo> perCorreos1;

	//bi-directional many-to-one association to Correo
	@OneToMany(mappedBy="segUsuario2")
	private List<Correo> perCorreos2;

	//bi-directional many-to-one association to Detalle
	@OneToMany(mappedBy="segUsuario1")
	private List<Detalle> perDetalles1;

	//bi-directional many-to-one association to Detalle
	@OneToMany(mappedBy="segUsuario2")
	private List<Detalle> perDetalles2;

	//bi-directional many-to-one association to Direccion
	@OneToMany(mappedBy="segUsuario1")
	private List<Direccion> perDireccions1;

	//bi-directional many-to-one association to Direccion
	@OneToMany(mappedBy="segUsuario2")
	private List<Direccion> perDireccions2;

	//bi-directional many-to-one association to Empresa
	@OneToMany(mappedBy="segUsuario1")
	private List<Empresa> perEmpresas1;

	//bi-directional many-to-one association to Empresa
	@OneToMany(mappedBy="segUsuario2")
	private List<Empresa> perEmpresas2;

	//bi-directional many-to-one association to Identificacion
	@OneToMany(mappedBy="segUsuario1")
	private List<Identificacion> perIdentificacions1;

	//bi-directional many-to-one association to Identificacion
	@OneToMany(mappedBy="segUsuario2")
	private List<Identificacion> perIdentificacions2;

	//bi-directional many-to-one association to Imagen
	@OneToMany(mappedBy="segUsuario1")
	private List<Imagen> perImagens1;

	//bi-directional many-to-one association to Imagen
	@OneToMany(mappedBy="segUsuario2")
	private List<Imagen> perImagens2;

	//bi-directional many-to-one association to Letrado
	@OneToMany(mappedBy="segUsuario1")
	private List<Letrado> perLetrados1;

	//bi-directional many-to-one association to Letrado
	@OneToMany(mappedBy="segUsuario2")
	private List<Letrado> perLetrados2;

	//bi-directional many-to-one association to NoIdentificado
	@OneToMany(mappedBy="segUsuario1")
	private List<NoIdentificado> perNoIdentificados1;

	//bi-directional many-to-one association to NoIdentificado
	@OneToMany(mappedBy="segUsuario2")
	private List<NoIdentificado> perNoIdentificados2;

	//bi-directional many-to-one association to Parentesco
	@OneToMany(mappedBy="segUsuario1")
	private List<Parentesco> Parentescos1;

	//bi-directional many-to-one association to Parentesco
	@OneToMany(mappedBy="segUsuario2")
	private List<Parentesco> Parentescos2;

	//bi-directional many-to-one association to Persona
	@OneToMany(mappedBy="segUsuario1")
	private List<Persona> perPersonas1;

	//bi-directional many-to-one association to Persona
	@OneToMany(mappedBy="segUsuario2")
	private List<Persona> perPersonas2;

	//bi-directional many-to-one association to Policia
	@OneToMany(mappedBy="segUsuario1")
	private List<Policia> perPolicias1;

	//bi-directional many-to-one association to Policia
	@OneToMany(mappedBy="segUsuario2")
	private List<Policia> perPolicias2;

	//bi-directional many-to-one association to Telefono
	@OneToMany(mappedBy="segUsuario1")
	private List<Telefono> perTelefonos1;

	//bi-directional many-to-one association to Telefono
	@OneToMany(mappedBy="segUsuario2")
	private List<Telefono> perTelefonos2;

	//bi-directional many-to-one association to Opcion
	@OneToMany(mappedBy="segUsuario1")
	private List<Opcion> segOpcions1;

	//bi-directional many-to-one association to Opcion
	@OneToMany(mappedBy="segUsuario2")
	private List<Opcion> segOpcions2;

	//bi-directional many-to-one association to Permiso
	@OneToMany(mappedBy="segUsuario1")
	private List<Permiso> segPermisos1;

	//bi-directional many-to-one association to Permiso
	@OneToMany(mappedBy="segUsuario2")
	private List<Permiso> segPermisos2;

	//bi-directional many-to-one association to Preferencia
	@OneToMany(mappedBy="segUsuario")
	private List<Preferencia> segPreferencias;

	//bi-directional many-to-one association to Rol
	@OneToMany(mappedBy="segUsuario1")
	private List<Rol> segRols1;

	//bi-directional many-to-one association to Rol
	@OneToMany(mappedBy="segUsuario2")
	private List<Rol> segRols2;

	//bi-directional many-to-one association to Dependencia
	@ManyToOne
	@JoinColumn(name="OFICINA")
	private Dependencia expDependencia;

	//bi-directional many-to-one association to Policia
	@ManyToOne
	@JoinColumn(name="POLICIA")
	private Policia perPolicia;

	//bi-directional many-to-one association to Rol
	@ManyToOne
	@JoinColumn(name="ROL")
	private Rol segRol;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="CREADOR")
	private Usuario segUsuario1;

	//bi-directional many-to-one association to Usuario
	@OneToMany(mappedBy="segUsuario1")
	private List<Usuario> segUsuarios1;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="EDITOR")
	private Usuario segUsuario2;

	//bi-directional many-to-one association to Usuario
	@OneToMany(mappedBy="segUsuario2")
	private List<Usuario> segUsuarios2;

	//bi-directional many-to-one association to Departamento
	@OneToMany(mappedBy="segUsuario1")
	private List<Departamento> ubgDepartamentos1;

	//bi-directional many-to-one association to Departamento
	@OneToMany(mappedBy="segUsuario2")
	private List<Departamento> ubgDepartamentos2;

	//bi-directional many-to-one association to Distrito
	@OneToMany(mappedBy="segUsuario1")
	private List<Distrito> ubgDistritos1;

	//bi-directional many-to-one association to Distrito
	@OneToMany(mappedBy="segUsuario2")
	private List<Distrito> ubgDistritos2;

	//bi-directional many-to-one association to Provincia
	@OneToMany(mappedBy="segUsuario1")
	private List<Provincia> ubgProvincias1;

	//bi-directional many-to-one association to Provincia
	@OneToMany(mappedBy="segUsuario2")
	private List<Provincia> ubgProvincias2;

	public Usuario() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getApeMat() {
		return this.apeMat;
	}

	public void setApeMat(String apeMat) {
		this.apeMat = apeMat;
	}

	public String getApePat() {
		return this.apePat;
	}

	public void setApePat(String apePat) {
		this.apePat = apePat;
	}

	public String getCargo() {
		return this.cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getClave() {
		return this.clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public Timestamp getCreacion() {
		return this.creacion;
	}

	public void setCreacion(Timestamp creacion) {
		this.creacion = creacion;
	}

	public String getDescCargo() {
		return this.descCargo;
	}

	public void setDescCargo(String descCargo) {
		this.descCargo = descCargo;
	}

	public Timestamp getEdicion() {
		return this.edicion;
	}

	public void setEdicion(Timestamp edicion) {
		this.edicion = edicion;
	}

	public String getNombres() {
		return this.nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getUsuario() {
		return this.usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public List<Lista> getCfgListas1() {
		return this.cfgListas1;
	}

	public void setCfgListas1(List<Lista> cfgListas1) {
		this.cfgListas1 = cfgListas1;
	}

	public Lista addCfgListas1(Lista cfgListas1) {
		getCfgListas1().add(cfgListas1);
		cfgListas1.setSegUsuario1(this);

		return cfgListas1;
	}

	public Lista removeCfgListas1(Lista cfgListas1) {
		getCfgListas1().remove(cfgListas1);
		cfgListas1.setSegUsuario1(null);

		return cfgListas1;
	}

	public List<Lista> getCfgListas2() {
		return this.cfgListas2;
	}

	public void setCfgListas2(List<Lista> cfgListas2) {
		this.cfgListas2 = cfgListas2;
	}

	public Lista addCfgListas2(Lista cfgListas2) {
		getCfgListas2().add(cfgListas2);
		cfgListas2.setSegUsuario2(this);

		return cfgListas2;
	}

	public Lista removeCfgListas2(Lista cfgListas2) {
		getCfgListas2().remove(cfgListas2);
		cfgListas2.setSegUsuario2(null);

		return cfgListas2;
	}

	public List<Parametro> getCfgParametros1() {
		return this.cfgParametros1;
	}

	public void setCfgParametros1(List<Parametro> cfgParametros1) {
		this.cfgParametros1 = cfgParametros1;
	}

	public Parametro addCfgParametros1(Parametro cfgParametros1) {
		getCfgParametros1().add(cfgParametros1);
		cfgParametros1.setSegUsuario1(this);

		return cfgParametros1;
	}

	public Parametro removeCfgParametros1(Parametro cfgParametros1) {
		getCfgParametros1().remove(cfgParametros1);
		cfgParametros1.setSegUsuario1(null);

		return cfgParametros1;
	}

	public List<Parametro> getCfgParametros2() {
		return this.cfgParametros2;
	}

	public void setCfgParametros2(List<Parametro> cfgParametros2) {
		this.cfgParametros2 = cfgParametros2;
	}

	public Parametro addCfgParametros2(Parametro cfgParametros2) {
		getCfgParametros2().add(cfgParametros2);
		cfgParametros2.setSegUsuario2(this);

		return cfgParametros2;
	}

	public Parametro removeCfgParametros2(Parametro cfgParametros2) {
		getCfgParametros2().remove(cfgParametros2);
		cfgParametros2.setSegUsuario2(null);

		return cfgParametros2;
	}

	public List<Regla> getCfgReglas1() {
		return this.cfgReglas1;
	}

	public void setCfgReglas1(List<Regla> cfgReglas1) {
		this.cfgReglas1 = cfgReglas1;
	}

	public Regla addCfgReglas1(Regla cfgReglas1) {
		getCfgReglas1().add(cfgReglas1);
		cfgReglas1.setSegUsuario1(this);

		return cfgReglas1;
	}

	public Regla removeCfgReglas1(Regla cfgReglas1) {
		getCfgReglas1().remove(cfgReglas1);
		cfgReglas1.setSegUsuario1(null);

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
		cfgReglas2.setSegUsuario2(this);

		return cfgReglas2;
	}

	public Regla removeCfgReglas2(Regla cfgReglas2) {
		getCfgReglas2().remove(cfgReglas2);
		cfgReglas2.setSegUsuario2(null);

		return cfgReglas2;
	}

	public List<Valor> getCfgValors1() {
		return this.cfgValors1;
	}

	public void setCfgValors1(List<Valor> cfgValors1) {
		this.cfgValors1 = cfgValors1;
	}

	public Valor addCfgValors1(Valor cfgValors1) {
		getCfgValors1().add(cfgValors1);
		cfgValors1.setSegUsuario1(this);

		return cfgValors1;
	}

	public Valor removeCfgValors1(Valor cfgValors1) {
		getCfgValors1().remove(cfgValors1);
		cfgValors1.setSegUsuario1(null);

		return cfgValors1;
	}

	public List<Valor> getCfgValors2() {
		return this.cfgValors2;
	}

	public void setCfgValors2(List<Valor> cfgValors2) {
		this.cfgValors2 = cfgValors2;
	}

	public Valor addCfgValors2(Valor cfgValors2) {
		getCfgValors2().add(cfgValors2);
		cfgValors2.setSegUsuario2(this);

		return cfgValors2;
	}

	public Valor removeCfgValors2(Valor cfgValors2) {
		getCfgValors2().remove(cfgValors2);
		cfgValors2.setSegUsuario2(null);

		return cfgValors2;
	}

	public List<AbogadoPersona> getExpAbogadoPersonas1() {
		return this.expAbogadoPersonas1;
	}

	public void setExpAbogadoPersonas1(List<AbogadoPersona> expAbogadoPersonas1) {
		this.expAbogadoPersonas1 = expAbogadoPersonas1;
	}

	public AbogadoPersona addExpAbogadoPersonas1(AbogadoPersona expAbogadoPersonas1) {
		getExpAbogadoPersonas1().add(expAbogadoPersonas1);
		expAbogadoPersonas1.setSegUsuario1(this);

		return expAbogadoPersonas1;
	}

	public AbogadoPersona removeExpAbogadoPersonas1(AbogadoPersona expAbogadoPersonas1) {
		getExpAbogadoPersonas1().remove(expAbogadoPersonas1);
		expAbogadoPersonas1.setSegUsuario1(null);

		return expAbogadoPersonas1;
	}

	public List<AbogadoPersona> getExpAbogadoPersonas2() {
		return this.expAbogadoPersonas2;
	}

	public void setExpAbogadoPersonas2(List<AbogadoPersona> expAbogadoPersonas2) {
		this.expAbogadoPersonas2 = expAbogadoPersonas2;
	}

	public AbogadoPersona addExpAbogadoPersonas2(AbogadoPersona expAbogadoPersonas2) {
		getExpAbogadoPersonas2().add(expAbogadoPersonas2);
		expAbogadoPersonas2.setSegUsuario2(this);

		return expAbogadoPersonas2;
	}

	public AbogadoPersona removeExpAbogadoPersonas2(AbogadoPersona expAbogadoPersonas2) {
		getExpAbogadoPersonas2().remove(expAbogadoPersonas2);
		expAbogadoPersonas2.setSegUsuario2(null);

		return expAbogadoPersonas2;
	}

	public List<Adjunto> getExpAdjuntos1() {
		return this.expAdjuntos1;
	}

	public void setExpAdjuntos1(List<Adjunto> expAdjuntos1) {
		this.expAdjuntos1 = expAdjuntos1;
	}

	public Adjunto addExpAdjuntos1(Adjunto expAdjuntos1) {
		getExpAdjuntos1().add(expAdjuntos1);
		expAdjuntos1.setSegUsuario1(this);

		return expAdjuntos1;
	}

	public Adjunto removeExpAdjuntos1(Adjunto expAdjuntos1) {
		getExpAdjuntos1().remove(expAdjuntos1);
		expAdjuntos1.setSegUsuario1(null);

		return expAdjuntos1;
	}

	public List<Adjunto> getExpAdjuntos2() {
		return this.expAdjuntos2;
	}

	public void setExpAdjuntos2(List<Adjunto> expAdjuntos2) {
		this.expAdjuntos2 = expAdjuntos2;
	}

	public Adjunto addExpAdjuntos2(Adjunto expAdjuntos2) {
		getExpAdjuntos2().add(expAdjuntos2);
		expAdjuntos2.setSegUsuario2(this);

		return expAdjuntos2;
	}

	public Adjunto removeExpAdjuntos2(Adjunto expAdjuntos2) {
		getExpAdjuntos2().remove(expAdjuntos2);
		expAdjuntos2.setSegUsuario2(null);

		return expAdjuntos2;
	}

	public List<Anexo> getExpAnexos1() {
		return this.expAnexos1;
	}

	public void setExpAnexos1(List<Anexo> expAnexos1) {
		this.expAnexos1 = expAnexos1;
	}

	public Anexo addExpAnexos1(Anexo expAnexos1) {
		getExpAnexos1().add(expAnexos1);
		expAnexos1.setSegUsuario1(this);

		return expAnexos1;
	}

	public Anexo removeExpAnexos1(Anexo expAnexos1) {
		getExpAnexos1().remove(expAnexos1);
		expAnexos1.setSegUsuario1(null);

		return expAnexos1;
	}

	public List<Anexo> getExpAnexos2() {
		return this.expAnexos2;
	}

	public void setExpAnexos2(List<Anexo> expAnexos2) {
		this.expAnexos2 = expAnexos2;
	}

	public Anexo addExpAnexos2(Anexo expAnexos2) {
		getExpAnexos2().add(expAnexos2);
		expAnexos2.setSegUsuario2(this);

		return expAnexos2;
	}

	public Anexo removeExpAnexos2(Anexo expAnexos2) {
		getExpAnexos2().remove(expAnexos2);
		expAnexos2.setSegUsuario2(null);

		return expAnexos2;
	}

	public List<Arma> getExpArmas1() {
		return this.expArmas1;
	}

	public void setExpArmas1(List<Arma> expArmas1) {
		this.expArmas1 = expArmas1;
	}

	public Arma addExpArmas1(Arma expArmas1) {
		getExpArmas1().add(expArmas1);
		expArmas1.setSegUsuario1(this);

		return expArmas1;
	}

	public Arma removeExpArmas1(Arma expArmas1) {
		getExpArmas1().remove(expArmas1);
		expArmas1.setSegUsuario1(null);

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
		expArmas2.setSegUsuario2(this);

		return expArmas2;
	}

	public Arma removeExpArmas2(Arma expArmas2) {
		getExpArmas2().remove(expArmas2);
		expArmas2.setSegUsuario2(null);

		return expArmas2;
	}

	public List<CentroPoblado> getExpCentroPoblados1() {
		return this.expCentroPoblados1;
	}

	public void setExpCentroPoblados1(List<CentroPoblado> expCentroPoblados1) {
		this.expCentroPoblados1 = expCentroPoblados1;
	}

	public CentroPoblado addExpCentroPoblados1(CentroPoblado expCentroPoblados1) {
		getExpCentroPoblados1().add(expCentroPoblados1);
		expCentroPoblados1.setSegUsuario1(this);

		return expCentroPoblados1;
	}

	public CentroPoblado removeExpCentroPoblados1(CentroPoblado expCentroPoblados1) {
		getExpCentroPoblados1().remove(expCentroPoblados1);
		expCentroPoblados1.setSegUsuario1(null);

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
		expCentroPoblados2.setSegUsuario2(this);

		return expCentroPoblados2;
	}

	public CentroPoblado removeExpCentroPoblados2(CentroPoblado expCentroPoblados2) {
		getExpCentroPoblados2().remove(expCentroPoblados2);
		expCentroPoblados2.setSegUsuario2(null);

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
		expDelitos1.setSegUsuario1(this);

		return expDelitos1;
	}

	public Delito removeExpDelitos1(Delito expDelitos1) {
		getExpDelitos1().remove(expDelitos1);
		expDelitos1.setSegUsuario1(null);

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
		expDelitos2.setSegUsuario2(this);

		return expDelitos2;
	}

	public Delito removeExpDelitos2(Delito expDelitos2) {
		getExpDelitos2().remove(expDelitos2);
		expDelitos2.setSegUsuario2(null);

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
		expDependencias1.setSegUsuario1(this);

		return expDependencias1;
	}

	public Dependencia removeExpDependencias1(Dependencia expDependencias1) {
		getExpDependencias1().remove(expDependencias1);
		expDependencias1.setSegUsuario1(null);

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
		expDependencias2.setSegUsuario2(this);

		return expDependencias2;
	}

	public Dependencia removeExpDependencias2(Dependencia expDependencias2) {
		getExpDependencias2().remove(expDependencias2);
		expDependencias2.setSegUsuario2(null);

		return expDependencias2;
	}

	public List<DetCrimen> getExpDetCrimens1() {
		return this.expDetCrimens1;
	}

	public void setExpDetCrimens1(List<DetCrimen> expDetCrimens1) {
		this.expDetCrimens1 = expDetCrimens1;
	}

	public DetCrimen addExpDetCrimens1(DetCrimen expDetCrimens1) {
		getExpDetCrimens1().add(expDetCrimens1);
		expDetCrimens1.setSegUsuario1(this);

		return expDetCrimens1;
	}

	public DetCrimen removeExpDetCrimens1(DetCrimen expDetCrimens1) {
		getExpDetCrimens1().remove(expDetCrimens1);
		expDetCrimens1.setSegUsuario1(null);

		return expDetCrimens1;
	}

	public List<DetCrimen> getExpDetCrimens2() {
		return this.expDetCrimens2;
	}

	public void setExpDetCrimens2(List<DetCrimen> expDetCrimens2) {
		this.expDetCrimens2 = expDetCrimens2;
	}

	public DetCrimen addExpDetCrimens2(DetCrimen expDetCrimens2) {
		getExpDetCrimens2().add(expDetCrimens2);
		expDetCrimens2.setSegUsuario2(this);

		return expDetCrimens2;
	}

	public DetCrimen removeExpDetCrimens2(DetCrimen expDetCrimens2) {
		getExpDetCrimens2().remove(expDetCrimens2);
		expDetCrimens2.setSegUsuario2(null);

		return expDetCrimens2;
	}

	public List<DetDroga> getExpDetDrogas1() {
		return this.expDetDrogas1;
	}

	public void setExpDetDrogas1(List<DetDroga> expDetDrogas1) {
		this.expDetDrogas1 = expDetDrogas1;
	}

	public DetDroga addExpDetDrogas1(DetDroga expDetDrogas1) {
		getExpDetDrogas1().add(expDetDrogas1);
		expDetDrogas1.setSegUsuario1(this);

		return expDetDrogas1;
	}

	public DetDroga removeExpDetDrogas1(DetDroga expDetDrogas1) {
		getExpDetDrogas1().remove(expDetDrogas1);
		expDetDrogas1.setSegUsuario1(null);

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
		expDetDrogas2.setSegUsuario2(this);

		return expDetDrogas2;
	}

	public DetDroga removeExpDetDrogas2(DetDroga expDetDrogas2) {
		getExpDetDrogas2().remove(expDetDrogas2);
		expDetDrogas2.setSegUsuario2(null);

		return expDetDrogas2;
	}

	public List<DetExpedientePersona> getExpDetExpedientePersonas1() {
		return this.expDetExpedientePersonas1;
	}

	public void setExpDetExpedientePersonas1(List<DetExpedientePersona> expDetExpedientePersonas1) {
		this.expDetExpedientePersonas1 = expDetExpedientePersonas1;
	}

	public DetExpedientePersona addExpDetExpedientePersonas1(DetExpedientePersona expDetExpedientePersonas1) {
		getExpDetExpedientePersonas1().add(expDetExpedientePersonas1);
		expDetExpedientePersonas1.setSegUsuario1(this);

		return expDetExpedientePersonas1;
	}

	public DetExpedientePersona removeExpDetExpedientePersonas1(DetExpedientePersona expDetExpedientePersonas1) {
		getExpDetExpedientePersonas1().remove(expDetExpedientePersonas1);
		expDetExpedientePersonas1.setSegUsuario1(null);

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
		expDetExpedientePersonas2.setSegUsuario2(this);

		return expDetExpedientePersonas2;
	}

	public DetExpedientePersona removeExpDetExpedientePersonas2(DetExpedientePersona expDetExpedientePersonas2) {
		getExpDetExpedientePersonas2().remove(expDetExpedientePersonas2);
		expDetExpedientePersonas2.setSegUsuario2(null);

		return expDetExpedientePersonas2;
	}

	public List<DetLlamada> getExpDetLlamadas1() {
		return this.expDetLlamadas1;
	}

	public void setExpDetLlamadas1(List<DetLlamada> expDetLlamadas1) {
		this.expDetLlamadas1 = expDetLlamadas1;
	}

	public DetLlamada addExpDetLlamadas1(DetLlamada expDetLlamadas1) {
		getExpDetLlamadas1().add(expDetLlamadas1);
		expDetLlamadas1.setSegUsuario1(this);

		return expDetLlamadas1;
	}

	public DetLlamada removeExpDetLlamadas1(DetLlamada expDetLlamadas1) {
		getExpDetLlamadas1().remove(expDetLlamadas1);
		expDetLlamadas1.setSegUsuario1(null);

		return expDetLlamadas1;
	}

	public List<DetLlamada> getExpDetLlamadas2() {
		return this.expDetLlamadas2;
	}

	public void setExpDetLlamadas2(List<DetLlamada> expDetLlamadas2) {
		this.expDetLlamadas2 = expDetLlamadas2;
	}

	public DetLlamada addExpDetLlamadas2(DetLlamada expDetLlamadas2) {
		getExpDetLlamadas2().add(expDetLlamadas2);
		expDetLlamadas2.setSegUsuario2(this);

		return expDetLlamadas2;
	}

	public DetLlamada removeExpDetLlamadas2(DetLlamada expDetLlamadas2) {
		getExpDetLlamadas2().remove(expDetLlamadas2);
		expDetLlamadas2.setSegUsuario2(null);

		return expDetLlamadas2;
	}

	public List<DetPerArmExp> getExpDetPerArmExps1() {
		return this.expDetPerArmExps1;
	}

	public void setExpDetPerArmExps1(List<DetPerArmExp> expDetPerArmExps1) {
		this.expDetPerArmExps1 = expDetPerArmExps1;
	}

	public DetPerArmExp addExpDetPerArmExps1(DetPerArmExp expDetPerArmExps1) {
		getExpDetPerArmExps1().add(expDetPerArmExps1);
		expDetPerArmExps1.setSegUsuario1(this);

		return expDetPerArmExps1;
	}

	public DetPerArmExp removeExpDetPerArmExps1(DetPerArmExp expDetPerArmExps1) {
		getExpDetPerArmExps1().remove(expDetPerArmExps1);
		expDetPerArmExps1.setSegUsuario1(null);

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
		expDetPerArmExps2.setSegUsuario2(this);

		return expDetPerArmExps2;
	}

	public DetPerArmExp removeExpDetPerArmExps2(DetPerArmExp expDetPerArmExps2) {
		getExpDetPerArmExps2().remove(expDetPerArmExps2);
		expDetPerArmExps2.setSegUsuario2(null);

		return expDetPerArmExps2;
	}

	public List<DetPerInmExp> getExpDetPerInmExps1() {
		return this.expDetPerInmExps1;
	}

	public void setExpDetPerInmExps1(List<DetPerInmExp> expDetPerInmExps1) {
		this.expDetPerInmExps1 = expDetPerInmExps1;
	}

	public DetPerInmExp addExpDetPerInmExps1(DetPerInmExp expDetPerInmExps1) {
		getExpDetPerInmExps1().add(expDetPerInmExps1);
		expDetPerInmExps1.setSegUsuario1(this);

		return expDetPerInmExps1;
	}

	public DetPerInmExp removeExpDetPerInmExps1(DetPerInmExp expDetPerInmExps1) {
		getExpDetPerInmExps1().remove(expDetPerInmExps1);
		expDetPerInmExps1.setSegUsuario1(null);

		return expDetPerInmExps1;
	}

	public List<DetPerInmExp> getExpDetPerInmExps2() {
		return this.expDetPerInmExps2;
	}

	public void setExpDetPerInmExps2(List<DetPerInmExp> expDetPerInmExps2) {
		this.expDetPerInmExps2 = expDetPerInmExps2;
	}

	public DetPerInmExp addExpDetPerInmExps2(DetPerInmExp expDetPerInmExps2) {
		getExpDetPerInmExps2().add(expDetPerInmExps2);
		expDetPerInmExps2.setSegUsuario2(this);

		return expDetPerInmExps2;
	}

	public DetPerInmExp removeExpDetPerInmExps2(DetPerInmExp expDetPerInmExps2) {
		getExpDetPerInmExps2().remove(expDetPerInmExps2);
		expDetPerInmExps2.setSegUsuario2(null);

		return expDetPerInmExps2;
	}

	public List<DetPerTelExp> getExpDetPerTelExps1() {
		return this.expDetPerTelExps1;
	}

	public void setExpDetPerTelExps1(List<DetPerTelExp> expDetPerTelExps1) {
		this.expDetPerTelExps1 = expDetPerTelExps1;
	}

	public DetPerTelExp addExpDetPerTelExps1(DetPerTelExp expDetPerTelExps1) {
		getExpDetPerTelExps1().add(expDetPerTelExps1);
		expDetPerTelExps1.setSegUsuario1(this);

		return expDetPerTelExps1;
	}

	public DetPerTelExp removeExpDetPerTelExps1(DetPerTelExp expDetPerTelExps1) {
		getExpDetPerTelExps1().remove(expDetPerTelExps1);
		expDetPerTelExps1.setSegUsuario1(null);

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
		expDetPerTelExps2.setSegUsuario2(this);

		return expDetPerTelExps2;
	}

	public DetPerTelExp removeExpDetPerTelExps2(DetPerTelExp expDetPerTelExps2) {
		getExpDetPerTelExps2().remove(expDetPerTelExps2);
		expDetPerTelExps2.setSegUsuario2(null);

		return expDetPerTelExps2;
	}

	public List<DetPerVehExp> getExpDetPerVehExps1() {
		return this.expDetPerVehExps1;
	}

	public void setExpDetPerVehExps1(List<DetPerVehExp> expDetPerVehExps1) {
		this.expDetPerVehExps1 = expDetPerVehExps1;
	}

	public DetPerVehExp addExpDetPerVehExps1(DetPerVehExp expDetPerVehExps1) {
		getExpDetPerVehExps1().add(expDetPerVehExps1);
		expDetPerVehExps1.setSegUsuario1(this);

		return expDetPerVehExps1;
	}

	public DetPerVehExp removeExpDetPerVehExps1(DetPerVehExp expDetPerVehExps1) {
		getExpDetPerVehExps1().remove(expDetPerVehExps1);
		expDetPerVehExps1.setSegUsuario1(null);

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
		expDetPerVehExps2.setSegUsuario2(this);

		return expDetPerVehExps2;
	}

	public DetPerVehExp removeExpDetPerVehExps2(DetPerVehExp expDetPerVehExps2) {
		getExpDetPerVehExps2().remove(expDetPerVehExps2);
		expDetPerVehExps2.setSegUsuario2(null);

		return expDetPerVehExps2;
	}

	public List<Documento> getExpDocumentos1() {
		return this.expDocumentos1;
	}

	public void setExpDocumentos1(List<Documento> expDocumentos1) {
		this.expDocumentos1 = expDocumentos1;
	}

	public Documento addExpDocumentos1(Documento expDocumentos1) {
		getExpDocumentos1().add(expDocumentos1);
		expDocumentos1.setSegUsuario1(this);

		return expDocumentos1;
	}

	public Documento removeExpDocumentos1(Documento expDocumentos1) {
		getExpDocumentos1().remove(expDocumentos1);
		expDocumentos1.setSegUsuario1(null);

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
		expDocumentos2.setSegUsuario2(this);

		return expDocumentos2;
	}

	public Documento removeExpDocumentos2(Documento expDocumentos2) {
		getExpDocumentos2().remove(expDocumentos2);
		expDocumentos2.setSegUsuario2(null);

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
		expDrogas1.setSegUsuario1(this);

		return expDrogas1;
	}

	public Droga removeExpDrogas1(Droga expDrogas1) {
		getExpDrogas1().remove(expDrogas1);
		expDrogas1.setSegUsuario1(null);

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
		expDrogas2.setSegUsuario2(this);

		return expDrogas2;
	}

	public Droga removeExpDrogas2(Droga expDrogas2) {
		getExpDrogas2().remove(expDrogas2);
		expDrogas2.setSegUsuario2(null);

		return expDrogas2;
	}

	public List<Entidad> getExpEntidads1() {
		return this.expEntidads1;
	}

	public void setExpEntidads1(List<Entidad> expEntidads1) {
		this.expEntidads1 = expEntidads1;
	}

	public Entidad addExpEntidads1(Entidad expEntidads1) {
		getExpEntidads1().add(expEntidads1);
		expEntidads1.setSegUsuario1(this);

		return expEntidads1;
	}

	public Entidad removeExpEntidads1(Entidad expEntidads1) {
		getExpEntidads1().remove(expEntidads1);
		expEntidads1.setSegUsuario1(null);

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
		expEntidads2.setSegUsuario2(this);

		return expEntidads2;
	}

	public Entidad removeExpEntidads2(Entidad expEntidads2) {
		getExpEntidads2().remove(expEntidads2);
		expEntidads2.setSegUsuario2(null);

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
		expEspecies1.setSegUsuario1(this);

		return expEspecies1;
	}

	public Especie removeExpEspecies1(Especie expEspecies1) {
		getExpEspecies1().remove(expEspecies1);
		expEspecies1.setSegUsuario1(null);

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
		expEspecies2.setSegUsuario2(this);

		return expEspecies2;
	}

	public Especie removeExpEspecies2(Especie expEspecies2) {
		getExpEspecies2().remove(expEspecies2);
		expEspecies2.setSegUsuario2(null);

		return expEspecies2;
	}

	public List<Estado> getExpEstados1() {
		return this.expEstados1;
	}

	public void setExpEstados1(List<Estado> expEstados1) {
		this.expEstados1 = expEstados1;
	}

	public Estado addExpEstados1(Estado expEstados1) {
		getExpEstados1().add(expEstados1);
		expEstados1.setSegUsuario1(this);

		return expEstados1;
	}

	public Estado removeExpEstados1(Estado expEstados1) {
		getExpEstados1().remove(expEstados1);
		expEstados1.setSegUsuario1(null);

		return expEstados1;
	}

	public List<Estado> getExpEstados2() {
		return this.expEstados2;
	}

	public void setExpEstados2(List<Estado> expEstados2) {
		this.expEstados2 = expEstados2;
	}

	public Estado addExpEstados2(Estado expEstados2) {
		getExpEstados2().add(expEstados2);
		expEstados2.setSegUsuario2(this);

		return expEstados2;
	}

	public Estado removeExpEstados2(Estado expEstados2) {
		getExpEstados2().remove(expEstados2);
		expEstados2.setSegUsuario2(null);

		return expEstados2;
	}

	public List<Expediente> getExpExpedientes1() {
		return this.expExpedientes1;
	}

	public void setExpExpedientes1(List<Expediente> expExpedientes1) {
		this.expExpedientes1 = expExpedientes1;
	}

	public Expediente addExpExpedientes1(Expediente expExpedientes1) {
		getExpExpedientes1().add(expExpedientes1);
		expExpedientes1.setSegUsuario1(this);

		return expExpedientes1;
	}

	public Expediente removeExpExpedientes1(Expediente expExpedientes1) {
		getExpExpedientes1().remove(expExpedientes1);
		expExpedientes1.setSegUsuario1(null);

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
		expExpedientes2.setSegUsuario2(this);

		return expExpedientes2;
	}

	public Expediente removeExpExpedientes2(Expediente expExpedientes2) {
		getExpExpedientes2().remove(expExpedientes2);
		expExpedientes2.setSegUsuario2(null);

		return expExpedientes2;
	}

	public List<ExpedienteDelito> getExpExpedienteDelitos1() {
		return this.expExpedienteDelitos1;
	}

	public void setExpExpedienteDelitos1(List<ExpedienteDelito> expExpedienteDelitos1) {
		this.expExpedienteDelitos1 = expExpedienteDelitos1;
	}

	public ExpedienteDelito addExpExpedienteDelitos1(ExpedienteDelito expExpedienteDelitos1) {
		getExpExpedienteDelitos1().add(expExpedienteDelitos1);
		expExpedienteDelitos1.setSegUsuario1(this);

		return expExpedienteDelitos1;
	}

	public ExpedienteDelito removeExpExpedienteDelitos1(ExpedienteDelito expExpedienteDelitos1) {
		getExpExpedienteDelitos1().remove(expExpedienteDelitos1);
		expExpedienteDelitos1.setSegUsuario1(null);

		return expExpedienteDelitos1;
	}

	public List<ExpedienteDelito> getExpExpedienteDelitos2() {
		return this.expExpedienteDelitos2;
	}

	public void setExpExpedienteDelitos2(List<ExpedienteDelito> expExpedienteDelitos2) {
		this.expExpedienteDelitos2 = expExpedienteDelitos2;
	}

	public ExpedienteDelito addExpExpedienteDelitos2(ExpedienteDelito expExpedienteDelitos2) {
		getExpExpedienteDelitos2().add(expExpedienteDelitos2);
		expExpedienteDelitos2.setSegUsuario2(this);

		return expExpedienteDelitos2;
	}

	public ExpedienteDelito removeExpExpedienteDelitos2(ExpedienteDelito expExpedienteDelitos2) {
		getExpExpedienteDelitos2().remove(expExpedienteDelitos2);
		expExpedienteDelitos2.setSegUsuario2(null);

		return expExpedienteDelitos2;
	}

	public List<ExpedienteMediosMovil> getExpExpedienteMediosMovils1() {
		return this.expExpedienteMediosMovils1;
	}

	public void setExpExpedienteMediosMovils1(List<ExpedienteMediosMovil> expExpedienteMediosMovils1) {
		this.expExpedienteMediosMovils1 = expExpedienteMediosMovils1;
	}

	public ExpedienteMediosMovil addExpExpedienteMediosMovils1(ExpedienteMediosMovil expExpedienteMediosMovils1) {
		getExpExpedienteMediosMovils1().add(expExpedienteMediosMovils1);
		expExpedienteMediosMovils1.setSegUsuario1(this);

		return expExpedienteMediosMovils1;
	}

	public ExpedienteMediosMovil removeExpExpedienteMediosMovils1(ExpedienteMediosMovil expExpedienteMediosMovils1) {
		getExpExpedienteMediosMovils1().remove(expExpedienteMediosMovils1);
		expExpedienteMediosMovils1.setSegUsuario1(null);

		return expExpedienteMediosMovils1;
	}

	public List<ExpedienteMediosMovil> getExpExpedienteMediosMovils2() {
		return this.expExpedienteMediosMovils2;
	}

	public void setExpExpedienteMediosMovils2(List<ExpedienteMediosMovil> expExpedienteMediosMovils2) {
		this.expExpedienteMediosMovils2 = expExpedienteMediosMovils2;
	}

	public ExpedienteMediosMovil addExpExpedienteMediosMovils2(ExpedienteMediosMovil expExpedienteMediosMovils2) {
		getExpExpedienteMediosMovils2().add(expExpedienteMediosMovils2);
		expExpedienteMediosMovils2.setSegUsuario2(this);

		return expExpedienteMediosMovils2;
	}

	public ExpedienteMediosMovil removeExpExpedienteMediosMovils2(ExpedienteMediosMovil expExpedienteMediosMovils2) {
		getExpExpedienteMediosMovils2().remove(expExpedienteMediosMovils2);
		expExpedienteMediosMovils2.setSegUsuario2(null);

		return expExpedienteMediosMovils2;
	}

	public List<Explosivo> getExpExplosivos1() {
		return this.expExplosivos1;
	}

	public void setExpExplosivos1(List<Explosivo> expExplosivos1) {
		this.expExplosivos1 = expExplosivos1;
	}

	public Explosivo addExpExplosivos1(Explosivo expExplosivos1) {
		getExpExplosivos1().add(expExplosivos1);
		expExplosivos1.setSegUsuario1(this);

		return expExplosivos1;
	}

	public Explosivo removeExpExplosivos1(Explosivo expExplosivos1) {
		getExpExplosivos1().remove(expExplosivos1);
		expExplosivos1.setSegUsuario1(null);

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
		expExplosivos2.setSegUsuario2(this);

		return expExplosivos2;
	}

	public Explosivo removeExpExplosivos2(Explosivo expExplosivos2) {
		getExpExplosivos2().remove(expExplosivos2);
		expExplosivos2.setSegUsuario2(null);

		return expExplosivos2;
	}

	public List<Importe> getExpImportes1() {
		return this.expImportes1;
	}

	public void setExpImportes1(List<Importe> expImportes1) {
		this.expImportes1 = expImportes1;
	}

	public Importe addExpImportes1(Importe expImportes1) {
		getExpImportes1().add(expImportes1);
		expImportes1.setSegUsuario1(this);

		return expImportes1;
	}

	public Importe removeExpImportes1(Importe expImportes1) {
		getExpImportes1().remove(expImportes1);
		expImportes1.setSegUsuario1(null);

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
		expImportes2.setSegUsuario2(this);

		return expImportes2;
	}

	public Importe removeExpImportes2(Importe expImportes2) {
		getExpImportes2().remove(expImportes2);
		expImportes2.setSegUsuario2(null);

		return expImportes2;
	}

	public List<Inmueble> getExpInmuebles1() {
		return this.expInmuebles1;
	}

	public void setExpInmuebles1(List<Inmueble> expInmuebles1) {
		this.expInmuebles1 = expInmuebles1;
	}

	public Inmueble addExpInmuebles1(Inmueble expInmuebles1) {
		getExpInmuebles1().add(expInmuebles1);
		expInmuebles1.setSegUsuario1(this);

		return expInmuebles1;
	}

	public Inmueble removeExpInmuebles1(Inmueble expInmuebles1) {
		getExpInmuebles1().remove(expInmuebles1);
		expInmuebles1.setSegUsuario1(null);

		return expInmuebles1;
	}

	public List<Inmueble> getExpInmuebles2() {
		return this.expInmuebles2;
	}

	public void setExpInmuebles2(List<Inmueble> expInmuebles2) {
		this.expInmuebles2 = expInmuebles2;
	}

	public Inmueble addExpInmuebles2(Inmueble expInmuebles2) {
		getExpInmuebles2().add(expInmuebles2);
		expInmuebles2.setSegUsuario2(this);

		return expInmuebles2;
	}

	public Inmueble removeExpInmuebles2(Inmueble expInmuebles2) {
		getExpInmuebles2().remove(expInmuebles2);
		expInmuebles2.setSegUsuario2(null);

		return expInmuebles2;
	}

	public List<Instalacion> getExpInstalacions1() {
		return this.expInstalacions1;
	}

	public void setExpInstalacions1(List<Instalacion> expInstalacions1) {
		this.expInstalacions1 = expInstalacions1;
	}

	public Instalacion addExpInstalacions1(Instalacion expInstalacions1) {
		getExpInstalacions1().add(expInstalacions1);
		expInstalacions1.setSegUsuario1(this);

		return expInstalacions1;
	}

	public Instalacion removeExpInstalacions1(Instalacion expInstalacions1) {
		getExpInstalacions1().remove(expInstalacions1);
		expInstalacions1.setSegUsuario1(null);

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
		expInstalacions2.setSegUsuario2(this);

		return expInstalacions2;
	}

	public Instalacion removeExpInstalacions2(Instalacion expInstalacions2) {
		getExpInstalacions2().remove(expInstalacions2);
		expInstalacions2.setSegUsuario2(null);

		return expInstalacions2;
	}

	public List<Municione> getExpMuniciones1() {
		return this.expMuniciones1;
	}

	public void setExpMuniciones1(List<Municione> expMuniciones1) {
		this.expMuniciones1 = expMuniciones1;
	}

	public Municione addExpMuniciones1(Municione expMuniciones1) {
		getExpMuniciones1().add(expMuniciones1);
		expMuniciones1.setSegUsuario1(this);

		return expMuniciones1;
	}

	public Municione removeExpMuniciones1(Municione expMuniciones1) {
		getExpMuniciones1().remove(expMuniciones1);
		expMuniciones1.setSegUsuario1(null);

		return expMuniciones1;
	}

	public List<Municione> getExpMuniciones2() {
		return this.expMuniciones2;
	}

	public void setExpMuniciones2(List<Municione> expMuniciones2) {
		this.expMuniciones2 = expMuniciones2;
	}

	public Municione addExpMuniciones2(Municione expMuniciones2) {
		getExpMuniciones2().add(expMuniciones2);
		expMuniciones2.setSegUsuario2(this);

		return expMuniciones2;
	}

	public Municione removeExpMuniciones2(Municione expMuniciones2) {
		getExpMuniciones2().remove(expMuniciones2);
		expMuniciones2.setSegUsuario2(null);

		return expMuniciones2;
	}

	public List<Organizacion> getExpOrganizacions1() {
		return this.expOrganizacions1;
	}

	public void setExpOrganizacions1(List<Organizacion> expOrganizacions1) {
		this.expOrganizacions1 = expOrganizacions1;
	}

	public Organizacion addExpOrganizacions1(Organizacion expOrganizacions1) {
		getExpOrganizacions1().add(expOrganizacions1);
		expOrganizacions1.setSegUsuario1(this);

		return expOrganizacions1;
	}

	public Organizacion removeExpOrganizacions1(Organizacion expOrganizacions1) {
		getExpOrganizacions1().remove(expOrganizacions1);
		expOrganizacions1.setSegUsuario1(null);

		return expOrganizacions1;
	}

	public List<Organizacion> getExpOrganizacions2() {
		return this.expOrganizacions2;
	}

	public void setExpOrganizacions2(List<Organizacion> expOrganizacions2) {
		this.expOrganizacions2 = expOrganizacions2;
	}

	public Organizacion addExpOrganizacions2(Organizacion expOrganizacions2) {
		getExpOrganizacions2().add(expOrganizacions2);
		expOrganizacions2.setSegUsuario2(this);

		return expOrganizacions2;
	}

	public Organizacion removeExpOrganizacions2(Organizacion expOrganizacions2) {
		getExpOrganizacions2().remove(expOrganizacions2);
		expOrganizacions2.setSegUsuario2(null);

		return expOrganizacions2;
	}

	public List<Predecesor> getExpPredecesors1() {
		return this.expPredecesors1;
	}

	public void setExpPredecesors1(List<Predecesor> expPredecesors1) {
		this.expPredecesors1 = expPredecesors1;
	}

	public Predecesor addExpPredecesors1(Predecesor expPredecesors1) {
		getExpPredecesors1().add(expPredecesors1);
		expPredecesors1.setSegUsuario1(this);

		return expPredecesors1;
	}

	public Predecesor removeExpPredecesors1(Predecesor expPredecesors1) {
		getExpPredecesors1().remove(expPredecesors1);
		expPredecesors1.setSegUsuario1(null);

		return expPredecesors1;
	}

	public List<Predecesor> getExpPredecesors2() {
		return this.expPredecesors2;
	}

	public void setExpPredecesors2(List<Predecesor> expPredecesors2) {
		this.expPredecesors2 = expPredecesors2;
	}

	public Predecesor addExpPredecesors2(Predecesor expPredecesors2) {
		getExpPredecesors2().add(expPredecesors2);
		expPredecesors2.setSegUsuario2(this);

		return expPredecesors2;
	}

	public Predecesor removeExpPredecesors2(Predecesor expPredecesors2) {
		getExpPredecesors2().remove(expPredecesors2);
		expPredecesors2.setSegUsuario2(null);

		return expPredecesors2;
	}

	public List<Ruta> getExpRutas1() {
		return this.expRutas1;
	}

	public void setExpRutas1(List<Ruta> expRutas1) {
		this.expRutas1 = expRutas1;
	}

	public Ruta addExpRutas1(Ruta expRutas1) {
		getExpRutas1().add(expRutas1);
		expRutas1.setSegUsuario1(this);

		return expRutas1;
	}

	public Ruta removeExpRutas1(Ruta expRutas1) {
		getExpRutas1().remove(expRutas1);
		expRutas1.setSegUsuario1(null);

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
		expRutas2.setSegUsuario2(this);

		return expRutas2;
	}

	public Ruta removeExpRutas2(Ruta expRutas2) {
		getExpRutas2().remove(expRutas2);
		expRutas2.setSegUsuario2(null);

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
		expRutas3.setSegUsuario3(this);

		return expRutas3;
	}

	public Ruta removeExpRutas3(Ruta expRutas3) {
		getExpRutas3().remove(expRutas3);
		expRutas3.setSegUsuario3(null);

		return expRutas3;
	}

	public List<Ruta> getExpRutas4() {
		return this.expRutas4;
	}

	public void setExpRutas4(List<Ruta> expRutas4) {
		this.expRutas4 = expRutas4;
	}

	public Ruta addExpRutas4(Ruta expRutas4) {
		getExpRutas4().add(expRutas4);
		expRutas4.setSegUsuario4(this);

		return expRutas4;
	}

	public Ruta removeExpRutas4(Ruta expRutas4) {
		getExpRutas4().remove(expRutas4);
		expRutas4.setSegUsuario4(null);

		return expRutas4;
	}

	public List<SituacionGeneral> getExpSituacionGenerals1() {
		return this.expSituacionGenerals1;
	}

	public void setExpSituacionGenerals1(List<SituacionGeneral> expSituacionGenerals1) {
		this.expSituacionGenerals1 = expSituacionGenerals1;
	}

	public SituacionGeneral addExpSituacionGenerals1(SituacionGeneral expSituacionGenerals1) {
		getExpSituacionGenerals1().add(expSituacionGenerals1);
		expSituacionGenerals1.setSegUsuario1(this);

		return expSituacionGenerals1;
	}

	public SituacionGeneral removeExpSituacionGenerals1(SituacionGeneral expSituacionGenerals1) {
		getExpSituacionGenerals1().remove(expSituacionGenerals1);
		expSituacionGenerals1.setSegUsuario1(null);

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
		expSituacionGenerals2.setSegUsuario2(this);

		return expSituacionGenerals2;
	}

	public SituacionGeneral removeExpSituacionGenerals2(SituacionGeneral expSituacionGenerals2) {
		getExpSituacionGenerals2().remove(expSituacionGenerals2);
		expSituacionGenerals2.setSegUsuario2(null);

		return expSituacionGenerals2;
	}

	public List<TipoHecho> getExpTipoHechos1() {
		return this.expTipoHechos1;
	}

	public void setExpTipoHechos1(List<TipoHecho> expTipoHechos1) {
		this.expTipoHechos1 = expTipoHechos1;
	}

	public TipoHecho addExpTipoHechos1(TipoHecho expTipoHechos1) {
		getExpTipoHechos1().add(expTipoHechos1);
		expTipoHechos1.setSegUsuario1(this);

		return expTipoHechos1;
	}

	public TipoHecho removeExpTipoHechos1(TipoHecho expTipoHechos1) {
		getExpTipoHechos1().remove(expTipoHechos1);
		expTipoHechos1.setSegUsuario1(null);

		return expTipoHechos1;
	}

	public List<TipoHecho> getExpTipoHechos2() {
		return this.expTipoHechos2;
	}

	public void setExpTipoHechos2(List<TipoHecho> expTipoHechos2) {
		this.expTipoHechos2 = expTipoHechos2;
	}

	public TipoHecho addExpTipoHechos2(TipoHecho expTipoHechos2) {
		getExpTipoHechos2().add(expTipoHechos2);
		expTipoHechos2.setSegUsuario2(this);

		return expTipoHechos2;
	}

	public TipoHecho removeExpTipoHechos2(TipoHecho expTipoHechos2) {
		getExpTipoHechos2().remove(expTipoHechos2);
		expTipoHechos2.setSegUsuario2(null);

		return expTipoHechos2;
	}

	public List<Vehiculo> getExpVehiculos1() {
		return this.expVehiculos1;
	}

	public void setExpVehiculos1(List<Vehiculo> expVehiculos1) {
		this.expVehiculos1 = expVehiculos1;
	}

	public Vehiculo addExpVehiculos1(Vehiculo expVehiculos1) {
		getExpVehiculos1().add(expVehiculos1);
		expVehiculos1.setSegUsuario1(this);

		return expVehiculos1;
	}

	public Vehiculo removeExpVehiculos1(Vehiculo expVehiculos1) {
		getExpVehiculos1().remove(expVehiculos1);
		expVehiculos1.setSegUsuario1(null);

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
		expVehiculos2.setSegUsuario2(this);

		return expVehiculos2;
	}

	public Vehiculo removeExpVehiculos2(Vehiculo expVehiculos2) {
		getExpVehiculos2().remove(expVehiculos2);
		expVehiculos2.setSegUsuario2(null);

		return expVehiculos2;
	}

	public List<Hojaremision> getHrHojaremisions1() {
		return this.hrHojaremisions1;
	}

	public void setHrHojaremisions1(List<Hojaremision> hrHojaremisions1) {
		this.hrHojaremisions1 = hrHojaremisions1;
	}

	public Hojaremision addHrHojaremisions1(Hojaremision hrHojaremisions1) {
		getHrHojaremisions1().add(hrHojaremisions1);
		hrHojaremisions1.setSegUsuario1(this);

		return hrHojaremisions1;
	}

	public Hojaremision removeHrHojaremisions1(Hojaremision hrHojaremisions1) {
		getHrHojaremisions1().remove(hrHojaremisions1);
		hrHojaremisions1.setSegUsuario1(null);

		return hrHojaremisions1;
	}

	public List<Hojaremision> getHrHojaremisions2() {
		return this.hrHojaremisions2;
	}

	public void setHrHojaremisions2(List<Hojaremision> hrHojaremisions2) {
		this.hrHojaremisions2 = hrHojaremisions2;
	}

	public Hojaremision addHrHojaremisions2(Hojaremision hrHojaremisions2) {
		getHrHojaremisions2().add(hrHojaremisions2);
		hrHojaremisions2.setSegUsuario2(this);

		return hrHojaremisions2;
	}

	public Hojaremision removeHrHojaremisions2(Hojaremision hrHojaremisions2) {
		getHrHojaremisions2().remove(hrHojaremisions2);
		hrHojaremisions2.setSegUsuario2(null);

		return hrHojaremisions2;
	}

	public List<HojaremisionMuestra> getHrHojaremisionMuestras1() {
		return this.hrHojaremisionMuestras1;
	}

	public void setHrHojaremisionMuestras1(List<HojaremisionMuestra> hrHojaremisionMuestras1) {
		this.hrHojaremisionMuestras1 = hrHojaremisionMuestras1;
	}

	public HojaremisionMuestra addHrHojaremisionMuestras1(HojaremisionMuestra hrHojaremisionMuestras1) {
		getHrHojaremisionMuestras1().add(hrHojaremisionMuestras1);
		hrHojaremisionMuestras1.setSegUsuario1(this);

		return hrHojaremisionMuestras1;
	}

	public HojaremisionMuestra removeHrHojaremisionMuestras1(HojaremisionMuestra hrHojaremisionMuestras1) {
		getHrHojaremisionMuestras1().remove(hrHojaremisionMuestras1);
		hrHojaremisionMuestras1.setSegUsuario1(null);

		return hrHojaremisionMuestras1;
	}

	public List<HojaremisionMuestra> getHrHojaremisionMuestras2() {
		return this.hrHojaremisionMuestras2;
	}

	public void setHrHojaremisionMuestras2(List<HojaremisionMuestra> hrHojaremisionMuestras2) {
		this.hrHojaremisionMuestras2 = hrHojaremisionMuestras2;
	}

	public HojaremisionMuestra addHrHojaremisionMuestras2(HojaremisionMuestra hrHojaremisionMuestras2) {
		getHrHojaremisionMuestras2().add(hrHojaremisionMuestras2);
		hrHojaremisionMuestras2.setSegUsuario2(this);

		return hrHojaremisionMuestras2;
	}

	public HojaremisionMuestra removeHrHojaremisionMuestras2(HojaremisionMuestra hrHojaremisionMuestras2) {
		getHrHojaremisionMuestras2().remove(hrHojaremisionMuestras2);
		hrHojaremisionMuestras2.setSegUsuario2(null);

		return hrHojaremisionMuestras2;
	}

	public List<ModeloMarca> getMntModeloMarcas1() {
		return this.mntModeloMarcas1;
	}

	public void setMntModeloMarcas1(List<ModeloMarca> mntModeloMarcas1) {
		this.mntModeloMarcas1 = mntModeloMarcas1;
	}

	public ModeloMarca addMntModeloMarcas1(ModeloMarca mntModeloMarcas1) {
		getMntModeloMarcas1().add(mntModeloMarcas1);
		mntModeloMarcas1.setSegUsuario1(this);

		return mntModeloMarcas1;
	}

	public ModeloMarca removeMntModeloMarcas1(ModeloMarca mntModeloMarcas1) {
		getMntModeloMarcas1().remove(mntModeloMarcas1);
		mntModeloMarcas1.setSegUsuario1(null);

		return mntModeloMarcas1;
	}

	public List<ModeloMarca> getMntModeloMarcas2() {
		return this.mntModeloMarcas2;
	}

	public void setMntModeloMarcas2(List<ModeloMarca> mntModeloMarcas2) {
		this.mntModeloMarcas2 = mntModeloMarcas2;
	}

	public ModeloMarca addMntModeloMarcas2(ModeloMarca mntModeloMarcas2) {
		getMntModeloMarcas2().add(mntModeloMarcas2);
		mntModeloMarcas2.setSegUsuario2(this);

		return mntModeloMarcas2;
	}

	public ModeloMarca removeMntModeloMarcas2(ModeloMarca mntModeloMarcas2) {
		getMntModeloMarcas2().remove(mntModeloMarcas2);
		mntModeloMarcas2.setSegUsuario2(null);

		return mntModeloMarcas2;
	}

	public List<Pais> getMntPaises1() {
		return this.mntPaises1;
	}

	public void setMntPaises1(List<Pais> mntPaises1) {
		this.mntPaises1 = mntPaises1;
	}

	public Pais addMntPaises1(Pais mntPaises1) {
		getMntPaises1().add(mntPaises1);
		mntPaises1.setSegUsuario1(this);

		return mntPaises1;
	}

	public Pais removeMntPaises1(Pais mntPaises1) {
		getMntPaises1().remove(mntPaises1);
		mntPaises1.setSegUsuario1(null);

		return mntPaises1;
	}

	public List<Pais> getMntPaises2() {
		return this.mntPaises2;
	}

	public void setMntPaises2(List<Pais> mntPaises2) {
		this.mntPaises2 = mntPaises2;
	}

	public Pais addMntPaises2(Pais mntPaises2) {
		getMntPaises2().add(mntPaises2);
		mntPaises2.setSegUsuario2(this);

		return mntPaises2;
	}

	public Pais removeMntPaises2(Pais mntPaises2) {
		getMntPaises2().remove(mntPaises2);
		mntPaises2.setSegUsuario2(null);

		return mntPaises2;
	}

	public List<TipoEspecie> getMntTipoEspecies1() {
		return this.mntTipoEspecies1;
	}

	public void setMntTipoEspecies1(List<TipoEspecie> mntTipoEspecies1) {
		this.mntTipoEspecies1 = mntTipoEspecies1;
	}

	public TipoEspecie addMntTipoEspecies1(TipoEspecie mntTipoEspecies1) {
		getMntTipoEspecies1().add(mntTipoEspecies1);
		mntTipoEspecies1.setSegUsuario1(this);

		return mntTipoEspecies1;
	}

	public TipoEspecie removeMntTipoEspecies1(TipoEspecie mntTipoEspecies1) {
		getMntTipoEspecies1().remove(mntTipoEspecies1);
		mntTipoEspecies1.setSegUsuario1(null);

		return mntTipoEspecies1;
	}

	public List<TipoEspecie> getMntTipoEspecies2() {
		return this.mntTipoEspecies2;
	}

	public void setMntTipoEspecies2(List<TipoEspecie> mntTipoEspecies2) {
		this.mntTipoEspecies2 = mntTipoEspecies2;
	}

	public TipoEspecie addMntTipoEspecies2(TipoEspecie mntTipoEspecies2) {
		getMntTipoEspecies2().add(mntTipoEspecies2);
		mntTipoEspecies2.setSegUsuario2(this);

		return mntTipoEspecies2;
	}

	public TipoEspecie removeMntTipoEspecies2(TipoEspecie mntTipoEspecies2) {
		getMntTipoEspecies2().remove(mntTipoEspecies2);
		mntTipoEspecies2.setSegUsuario2(null);

		return mntTipoEspecies2;
	}

	public List<Equipo> getOrgEquipos1() {
		return this.orgEquipos1;
	}

	public void setOrgEquipos1(List<Equipo> orgEquipos1) {
		this.orgEquipos1 = orgEquipos1;
	}

	public Equipo addOrgEquipos1(Equipo orgEquipos1) {
		getOrgEquipos1().add(orgEquipos1);
		orgEquipos1.setSegUsuario1(this);

		return orgEquipos1;
	}

	public Equipo removeOrgEquipos1(Equipo orgEquipos1) {
		getOrgEquipos1().remove(orgEquipos1);
		orgEquipos1.setSegUsuario1(null);

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
		orgEquipos2.setSegUsuario2(this);

		return orgEquipos2;
	}

	public Equipo removeOrgEquipos2(Equipo orgEquipos2) {
		getOrgEquipos2().remove(orgEquipos2);
		orgEquipos2.setSegUsuario2(null);

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
		orgIntegrantes1.setSegUsuario1(this);

		return orgIntegrantes1;
	}

	public Integrante removeOrgIntegrantes1(Integrante orgIntegrantes1) {
		getOrgIntegrantes1().remove(orgIntegrantes1);
		orgIntegrantes1.setSegUsuario1(null);

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
		orgIntegrantes2.setSegUsuario2(this);

		return orgIntegrantes2;
	}

	public Integrante removeOrgIntegrantes2(Integrante orgIntegrantes2) {
		getOrgIntegrantes2().remove(orgIntegrantes2);
		orgIntegrantes2.setSegUsuario2(null);

		return orgIntegrantes2;
	}

	public List<Integrante> getOrgIntegrantes3() {
		return this.orgIntegrantes3;
	}

	public void setOrgIntegrantes3(List<Integrante> orgIntegrantes3) {
		this.orgIntegrantes3 = orgIntegrantes3;
	}

	public Integrante addOrgIntegrantes3(Integrante orgIntegrantes3) {
		getOrgIntegrantes3().add(orgIntegrantes3);
		orgIntegrantes3.setSegUsuario3(this);

		return orgIntegrantes3;
	}

	public Integrante removeOrgIntegrantes3(Integrante orgIntegrantes3) {
		getOrgIntegrantes3().remove(orgIntegrantes3);
		orgIntegrantes3.setSegUsuario3(null);

		return orgIntegrantes3;
	}

	public List<Correo> getPerCorreos1() {
		return this.perCorreos1;
	}

	public void setPerCorreos1(List<Correo> perCorreos1) {
		this.perCorreos1 = perCorreos1;
	}

	public Correo addPerCorreos1(Correo perCorreos1) {
		getPerCorreos1().add(perCorreos1);
		perCorreos1.setSegUsuario1(this);

		return perCorreos1;
	}

	public Correo removePerCorreos1(Correo perCorreos1) {
		getPerCorreos1().remove(perCorreos1);
		perCorreos1.setSegUsuario1(null);

		return perCorreos1;
	}

	public List<Correo> getPerCorreos2() {
		return this.perCorreos2;
	}

	public void setPerCorreos2(List<Correo> perCorreos2) {
		this.perCorreos2 = perCorreos2;
	}

	public Correo addPerCorreos2(Correo perCorreos2) {
		getPerCorreos2().add(perCorreos2);
		perCorreos2.setSegUsuario2(this);

		return perCorreos2;
	}

	public Correo removePerCorreos2(Correo perCorreos2) {
		getPerCorreos2().remove(perCorreos2);
		perCorreos2.setSegUsuario2(null);

		return perCorreos2;
	}

	public List<Detalle> getPerDetalles1() {
		return this.perDetalles1;
	}

	public void setPerDetalles1(List<Detalle> perDetalles1) {
		this.perDetalles1 = perDetalles1;
	}

	public Detalle addPerDetalles1(Detalle perDetalles1) {
		getPerDetalles1().add(perDetalles1);
		perDetalles1.setSegUsuario1(this);

		return perDetalles1;
	}

	public Detalle removePerDetalles1(Detalle perDetalles1) {
		getPerDetalles1().remove(perDetalles1);
		perDetalles1.setSegUsuario1(null);

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
		perDetalles2.setSegUsuario2(this);

		return perDetalles2;
	}

	public Detalle removePerDetalles2(Detalle perDetalles2) {
		getPerDetalles2().remove(perDetalles2);
		perDetalles2.setSegUsuario2(null);

		return perDetalles2;
	}

	public List<Direccion> getPerDireccions1() {
		return this.perDireccions1;
	}

	public void setPerDireccions1(List<Direccion> perDireccions1) {
		this.perDireccions1 = perDireccions1;
	}

	public Direccion addPerDireccions1(Direccion perDireccions1) {
		getPerDireccions1().add(perDireccions1);
		perDireccions1.setSegUsuario1(this);

		return perDireccions1;
	}

	public Direccion removePerDireccions1(Direccion perDireccions1) {
		getPerDireccions1().remove(perDireccions1);
		perDireccions1.setSegUsuario1(null);

		return perDireccions1;
	}

	public List<Direccion> getPerDireccions2() {
		return this.perDireccions2;
	}

	public void setPerDireccions2(List<Direccion> perDireccions2) {
		this.perDireccions2 = perDireccions2;
	}

	public Direccion addPerDireccions2(Direccion perDireccions2) {
		getPerDireccions2().add(perDireccions2);
		perDireccions2.setSegUsuario2(this);

		return perDireccions2;
	}

	public Direccion removePerDireccions2(Direccion perDireccions2) {
		getPerDireccions2().remove(perDireccions2);
		perDireccions2.setSegUsuario2(null);

		return perDireccions2;
	}

	public List<Empresa> getPerEmpresas1() {
		return this.perEmpresas1;
	}

	public void setPerEmpresas1(List<Empresa> perEmpresas1) {
		this.perEmpresas1 = perEmpresas1;
	}

	public Empresa addPerEmpresas1(Empresa perEmpresas1) {
		getPerEmpresas1().add(perEmpresas1);
		perEmpresas1.setSegUsuario1(this);

		return perEmpresas1;
	}

	public Empresa removePerEmpresas1(Empresa perEmpresas1) {
		getPerEmpresas1().remove(perEmpresas1);
		perEmpresas1.setSegUsuario1(null);

		return perEmpresas1;
	}

	public List<Empresa> getPerEmpresas2() {
		return this.perEmpresas2;
	}

	public void setPerEmpresas2(List<Empresa> perEmpresas2) {
		this.perEmpresas2 = perEmpresas2;
	}

	public Empresa addPerEmpresas2(Empresa perEmpresas2) {
		getPerEmpresas2().add(perEmpresas2);
		perEmpresas2.setSegUsuario2(this);

		return perEmpresas2;
	}

	public Empresa removePerEmpresas2(Empresa perEmpresas2) {
		getPerEmpresas2().remove(perEmpresas2);
		perEmpresas2.setSegUsuario2(null);

		return perEmpresas2;
	}

	public List<Identificacion> getPerIdentificacions1() {
		return this.perIdentificacions1;
	}

	public void setPerIdentificacions1(List<Identificacion> perIdentificacions1) {
		this.perIdentificacions1 = perIdentificacions1;
	}

	public Identificacion addPerIdentificacions1(Identificacion perIdentificacions1) {
		getPerIdentificacions1().add(perIdentificacions1);
		perIdentificacions1.setSegUsuario1(this);

		return perIdentificacions1;
	}

	public Identificacion removePerIdentificacions1(Identificacion perIdentificacions1) {
		getPerIdentificacions1().remove(perIdentificacions1);
		perIdentificacions1.setSegUsuario1(null);

		return perIdentificacions1;
	}

	public List<Identificacion> getPerIdentificacions2() {
		return this.perIdentificacions2;
	}

	public void setPerIdentificacions2(List<Identificacion> perIdentificacions2) {
		this.perIdentificacions2 = perIdentificacions2;
	}

	public Identificacion addPerIdentificacions2(Identificacion perIdentificacions2) {
		getPerIdentificacions2().add(perIdentificacions2);
		perIdentificacions2.setSegUsuario2(this);

		return perIdentificacions2;
	}

	public Identificacion removePerIdentificacions2(Identificacion perIdentificacions2) {
		getPerIdentificacions2().remove(perIdentificacions2);
		perIdentificacions2.setSegUsuario2(null);

		return perIdentificacions2;
	}

	public List<Imagen> getPerImagens1() {
		return this.perImagens1;
	}

	public void setPerImagens1(List<Imagen> perImagens1) {
		this.perImagens1 = perImagens1;
	}

	public Imagen addPerImagens1(Imagen perImagens1) {
		getPerImagens1().add(perImagens1);
		perImagens1.setSegUsuario1(this);

		return perImagens1;
	}

	public Imagen removePerImagens1(Imagen perImagens1) {
		getPerImagens1().remove(perImagens1);
		perImagens1.setSegUsuario1(null);

		return perImagens1;
	}

	public List<Imagen> getPerImagens2() {
		return this.perImagens2;
	}

	public void setPerImagens2(List<Imagen> perImagens2) {
		this.perImagens2 = perImagens2;
	}

	public Imagen addPerImagens2(Imagen perImagens2) {
		getPerImagens2().add(perImagens2);
		perImagens2.setSegUsuario2(this);

		return perImagens2;
	}

	public Imagen removePerImagens2(Imagen perImagens2) {
		getPerImagens2().remove(perImagens2);
		perImagens2.setSegUsuario2(null);

		return perImagens2;
	}

	public List<Letrado> getPerLetrados1() {
		return this.perLetrados1;
	}

	public void setPerLetrados1(List<Letrado> perLetrados1) {
		this.perLetrados1 = perLetrados1;
	}

	public Letrado addPerLetrados1(Letrado perLetrados1) {
		getPerLetrados1().add(perLetrados1);
		perLetrados1.setSegUsuario1(this);

		return perLetrados1;
	}

	public Letrado removePerLetrados1(Letrado perLetrados1) {
		getPerLetrados1().remove(perLetrados1);
		perLetrados1.setSegUsuario1(null);

		return perLetrados1;
	}

	public List<Letrado> getPerLetrados2() {
		return this.perLetrados2;
	}

	public void setPerLetrados2(List<Letrado> perLetrados2) {
		this.perLetrados2 = perLetrados2;
	}

	public Letrado addPerLetrados2(Letrado perLetrados2) {
		getPerLetrados2().add(perLetrados2);
		perLetrados2.setSegUsuario2(this);

		return perLetrados2;
	}

	public Letrado removePerLetrados2(Letrado perLetrados2) {
		getPerLetrados2().remove(perLetrados2);
		perLetrados2.setSegUsuario2(null);

		return perLetrados2;
	}

	public List<NoIdentificado> getPerNoIdentificados1() {
		return this.perNoIdentificados1;
	}

	public void setPerNoIdentificados1(List<NoIdentificado> perNoIdentificados1) {
		this.perNoIdentificados1 = perNoIdentificados1;
	}

	public NoIdentificado addPerNoIdentificados1(NoIdentificado perNoIdentificados1) {
		getPerNoIdentificados1().add(perNoIdentificados1);
		perNoIdentificados1.setSegUsuario1(this);

		return perNoIdentificados1;
	}

	public NoIdentificado removePerNoIdentificados1(NoIdentificado perNoIdentificados1) {
		getPerNoIdentificados1().remove(perNoIdentificados1);
		perNoIdentificados1.setSegUsuario1(null);

		return perNoIdentificados1;
	}

	public List<NoIdentificado> getPerNoIdentificados2() {
		return this.perNoIdentificados2;
	}

	public void setPerNoIdentificados2(List<NoIdentificado> perNoIdentificados2) {
		this.perNoIdentificados2 = perNoIdentificados2;
	}

	public NoIdentificado addPerNoIdentificados2(NoIdentificado perNoIdentificados2) {
		getPerNoIdentificados2().add(perNoIdentificados2);
		perNoIdentificados2.setSegUsuario2(this);

		return perNoIdentificados2;
	}

	public NoIdentificado removePerNoIdentificados2(NoIdentificado perNoIdentificados2) {
		getPerNoIdentificados2().remove(perNoIdentificados2);
		perNoIdentificados2.setSegUsuario2(null);

		return perNoIdentificados2;
	}

	public List<Parentesco> getParentescos1() {
		return this.Parentescos1;
	}

	public void setParentescos1(List<Parentesco> Parentescos1) {
		this.Parentescos1 = Parentescos1;
	}

	public Parentesco addParentescos1(Parentesco Parentescos1) {
		getParentescos1().add(Parentescos1);
		Parentescos1.setSegUsuario1(this);

		return Parentescos1;
	}

	public Parentesco removeParentescos1(Parentesco Parentescos1) {
		getParentescos1().remove(Parentescos1);
		Parentescos1.setSegUsuario1(null);

		return Parentescos1;
	}

	public List<Parentesco> getParentescos2() {
		return this.Parentescos2;
	}

	public void setParentescos2(List<Parentesco> Parentescos2) {
		this.Parentescos2 = Parentescos2;
	}

	public Parentesco addParentescos2(Parentesco Parentescos2) {
		getParentescos2().add(Parentescos2);
		Parentescos2.setSegUsuario2(this);

		return Parentescos2;
	}

	public Parentesco removeParentescos2(Parentesco Parentescos2) {
		getParentescos2().remove(Parentescos2);
		Parentescos2.setSegUsuario2(null);

		return Parentescos2;
	}

	public List<Persona> getPerPersonas1() {
		return this.perPersonas1;
	}

	public void setPerPersonas1(List<Persona> perPersonas1) {
		this.perPersonas1 = perPersonas1;
	}

	public Persona addPerPersonas1(Persona perPersonas1) {
		getPerPersonas1().add(perPersonas1);
		perPersonas1.setSegUsuario1(this);

		return perPersonas1;
	}

	public Persona removePerPersonas1(Persona perPersonas1) {
		getPerPersonas1().remove(perPersonas1);
		perPersonas1.setSegUsuario1(null);

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
		perPersonas2.setSegUsuario2(this);

		return perPersonas2;
	}

	public Persona removePerPersonas2(Persona perPersonas2) {
		getPerPersonas2().remove(perPersonas2);
		perPersonas2.setSegUsuario2(null);

		return perPersonas2;
	}

	public List<Policia> getPerPolicias1() {
		return this.perPolicias1;
	}

	public void setPerPolicias1(List<Policia> perPolicias1) {
		this.perPolicias1 = perPolicias1;
	}

	public Policia addPerPolicias1(Policia perPolicias1) {
		getPerPolicias1().add(perPolicias1);
		perPolicias1.setSegUsuario1(this);

		return perPolicias1;
	}

	public Policia removePerPolicias1(Policia perPolicias1) {
		getPerPolicias1().remove(perPolicias1);
		perPolicias1.setSegUsuario1(null);

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
		perPolicias2.setSegUsuario2(this);

		return perPolicias2;
	}

	public Policia removePerPolicias2(Policia perPolicias2) {
		getPerPolicias2().remove(perPolicias2);
		perPolicias2.setSegUsuario2(null);

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
		perTelefonos1.setSegUsuario1(this);

		return perTelefonos1;
	}

	public Telefono removePerTelefonos1(Telefono perTelefonos1) {
		getPerTelefonos1().remove(perTelefonos1);
		perTelefonos1.setSegUsuario1(null);

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
		perTelefonos2.setSegUsuario2(this);

		return perTelefonos2;
	}

	public Telefono removePerTelefonos2(Telefono perTelefonos2) {
		getPerTelefonos2().remove(perTelefonos2);
		perTelefonos2.setSegUsuario2(null);

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
		segOpcions1.setSegUsuario1(this);

		return segOpcions1;
	}

	public Opcion removeSegOpcions1(Opcion segOpcions1) {
		getSegOpcions1().remove(segOpcions1);
		segOpcions1.setSegUsuario1(null);

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
		segOpcions2.setSegUsuario2(this);

		return segOpcions2;
	}

	public Opcion removeSegOpcions2(Opcion segOpcions2) {
		getSegOpcions2().remove(segOpcions2);
		segOpcions2.setSegUsuario2(null);

		return segOpcions2;
	}

	public List<Permiso> getSegPermisos1() {
		return this.segPermisos1;
	}

	public void setSegPermisos1(List<Permiso> segPermisos1) {
		this.segPermisos1 = segPermisos1;
	}

	public Permiso addSegPermisos1(Permiso segPermisos1) {
		getSegPermisos1().add(segPermisos1);
		segPermisos1.setSegUsuario1(this);

		return segPermisos1;
	}

	public Permiso removeSegPermisos1(Permiso segPermisos1) {
		getSegPermisos1().remove(segPermisos1);
		segPermisos1.setSegUsuario1(null);

		return segPermisos1;
	}

	public List<Permiso> getSegPermisos2() {
		return this.segPermisos2;
	}

	public void setSegPermisos2(List<Permiso> segPermisos2) {
		this.segPermisos2 = segPermisos2;
	}

	public Permiso addSegPermisos2(Permiso segPermisos2) {
		getSegPermisos2().add(segPermisos2);
		segPermisos2.setSegUsuario2(this);

		return segPermisos2;
	}

	public Permiso removeSegPermisos2(Permiso segPermisos2) {
		getSegPermisos2().remove(segPermisos2);
		segPermisos2.setSegUsuario2(null);

		return segPermisos2;
	}

	public List<Preferencia> getSegPreferencias() {
		return this.segPreferencias;
	}

	public void setSegPreferencias(List<Preferencia> segPreferencias) {
		this.segPreferencias = segPreferencias;
	}

	public Preferencia addSegPreferencia(Preferencia segPreferencia) {
		getSegPreferencias().add(segPreferencia);
		segPreferencia.setSegUsuario(this);

		return segPreferencia;
	}

	public Preferencia removeSegPreferencia(Preferencia segPreferencia) {
		getSegPreferencias().remove(segPreferencia);
		segPreferencia.setSegUsuario(null);

		return segPreferencia;
	}

	public List<Rol> getSegRols1() {
		return this.segRols1;
	}

	public void setSegRols1(List<Rol> segRols1) {
		this.segRols1 = segRols1;
	}

	public Rol addSegRols1(Rol segRols1) {
		getSegRols1().add(segRols1);
		segRols1.setSegUsuario1(this);

		return segRols1;
	}

	public Rol removeSegRols1(Rol segRols1) {
		getSegRols1().remove(segRols1);
		segRols1.setSegUsuario1(null);

		return segRols1;
	}

	public List<Rol> getSegRols2() {
		return this.segRols2;
	}

	public void setSegRols2(List<Rol> segRols2) {
		this.segRols2 = segRols2;
	}

	public Rol addSegRols2(Rol segRols2) {
		getSegRols2().add(segRols2);
		segRols2.setSegUsuario2(this);

		return segRols2;
	}

	public Rol removeSegRols2(Rol segRols2) {
		getSegRols2().remove(segRols2);
		segRols2.setSegUsuario2(null);

		return segRols2;
	}

	public Dependencia getExpDependencia() {
		return this.expDependencia;
	}

	public void setExpDependencia(Dependencia expDependencia) {
		this.expDependencia = expDependencia;
	}

	public Policia getPerPolicia() {
		return this.perPolicia;
	}

	public void setPerPolicia(Policia perPolicia) {
		this.perPolicia = perPolicia;
	}

	public Rol getSegRol() {
		return this.segRol;
	}

	public void setSegRol(Rol segRol) {
		this.segRol = segRol;
	}

	public Usuario getSegUsuario1() {
		return this.segUsuario1;
	}

	public void setSegUsuario1(Usuario segUsuario1) {
		this.segUsuario1 = segUsuario1;
	}

	public List<Usuario> getSegUsuarios1() {
		return this.segUsuarios1;
	}

	public void setSegUsuarios1(List<Usuario> segUsuarios1) {
		this.segUsuarios1 = segUsuarios1;
	}

	public Usuario addSegUsuarios1(Usuario segUsuarios1) {
		getSegUsuarios1().add(segUsuarios1);
		segUsuarios1.setSegUsuario1(this);

		return segUsuarios1;
	}

	public Usuario removeSegUsuarios1(Usuario segUsuarios1) {
		getSegUsuarios1().remove(segUsuarios1);
		segUsuarios1.setSegUsuario1(null);

		return segUsuarios1;
	}

	public Usuario getSegUsuario2() {
		return this.segUsuario2;
	}

	public void setSegUsuario2(Usuario segUsuario2) {
		this.segUsuario2 = segUsuario2;
	}

	public List<Usuario> getSegUsuarios2() {
		return this.segUsuarios2;
	}

	public void setSegUsuarios2(List<Usuario> segUsuarios2) {
		this.segUsuarios2 = segUsuarios2;
	}

	public Usuario addSegUsuarios2(Usuario segUsuarios2) {
		getSegUsuarios2().add(segUsuarios2);
		segUsuarios2.setSegUsuario2(this);

		return segUsuarios2;
	}

	public Usuario removeSegUsuarios2(Usuario segUsuarios2) {
		getSegUsuarios2().remove(segUsuarios2);
		segUsuarios2.setSegUsuario2(null);

		return segUsuarios2;
	}

	public List<Departamento> getUbgDepartamentos1() {
		return this.ubgDepartamentos1;
	}

	public void setUbgDepartamentos1(List<Departamento> ubgDepartamentos1) {
		this.ubgDepartamentos1 = ubgDepartamentos1;
	}

	public Departamento addUbgDepartamentos1(Departamento ubgDepartamentos1) {
		getUbgDepartamentos1().add(ubgDepartamentos1);
		ubgDepartamentos1.setSegUsuario1(this);

		return ubgDepartamentos1;
	}

	public Departamento removeUbgDepartamentos1(Departamento ubgDepartamentos1) {
		getUbgDepartamentos1().remove(ubgDepartamentos1);
		ubgDepartamentos1.setSegUsuario1(null);

		return ubgDepartamentos1;
	}

	public List<Departamento> getUbgDepartamentos2() {
		return this.ubgDepartamentos2;
	}

	public void setUbgDepartamentos2(List<Departamento> ubgDepartamentos2) {
		this.ubgDepartamentos2 = ubgDepartamentos2;
	}

	public Departamento addUbgDepartamentos2(Departamento ubgDepartamentos2) {
		getUbgDepartamentos2().add(ubgDepartamentos2);
		ubgDepartamentos2.setSegUsuario2(this);

		return ubgDepartamentos2;
	}

	public Departamento removeUbgDepartamentos2(Departamento ubgDepartamentos2) {
		getUbgDepartamentos2().remove(ubgDepartamentos2);
		ubgDepartamentos2.setSegUsuario2(null);

		return ubgDepartamentos2;
	}

	public List<Distrito> getUbgDistritos1() {
		return this.ubgDistritos1;
	}

	public void setUbgDistritos1(List<Distrito> ubgDistritos1) {
		this.ubgDistritos1 = ubgDistritos1;
	}

	public Distrito addUbgDistritos1(Distrito ubgDistritos1) {
		getUbgDistritos1().add(ubgDistritos1);
		ubgDistritos1.setSegUsuario1(this);

		return ubgDistritos1;
	}

	public Distrito removeUbgDistritos1(Distrito ubgDistritos1) {
		getUbgDistritos1().remove(ubgDistritos1);
		ubgDistritos1.setSegUsuario1(null);

		return ubgDistritos1;
	}

	public List<Distrito> getUbgDistritos2() {
		return this.ubgDistritos2;
	}

	public void setUbgDistritos2(List<Distrito> ubgDistritos2) {
		this.ubgDistritos2 = ubgDistritos2;
	}

	public Distrito addUbgDistritos2(Distrito ubgDistritos2) {
		getUbgDistritos2().add(ubgDistritos2);
		ubgDistritos2.setSegUsuario2(this);

		return ubgDistritos2;
	}

	public Distrito removeUbgDistritos2(Distrito ubgDistritos2) {
		getUbgDistritos2().remove(ubgDistritos2);
		ubgDistritos2.setSegUsuario2(null);

		return ubgDistritos2;
	}

	public List<Provincia> getUbgProvincias1() {
		return this.ubgProvincias1;
	}

	public void setUbgProvincias1(List<Provincia> ubgProvincias1) {
		this.ubgProvincias1 = ubgProvincias1;
	}

	public Provincia addUbgProvincias1(Provincia ubgProvincias1) {
		getUbgProvincias1().add(ubgProvincias1);
		ubgProvincias1.setSegUsuario1(this);

		return ubgProvincias1;
	}

	public Provincia removeUbgProvincias1(Provincia ubgProvincias1) {
		getUbgProvincias1().remove(ubgProvincias1);
		ubgProvincias1.setSegUsuario1(null);

		return ubgProvincias1;
	}

	public List<Provincia> getUbgProvincias2() {
		return this.ubgProvincias2;
	}

	public void setUbgProvincias2(List<Provincia> ubgProvincias2) {
		this.ubgProvincias2 = ubgProvincias2;
	}

	public Provincia addUbgProvincias2(Provincia ubgProvincias2) {
		getUbgProvincias2().add(ubgProvincias2);
		ubgProvincias2.setSegUsuario2(this);

		return ubgProvincias2;
	}

	public Provincia removeUbgProvincias2(Provincia ubgProvincias2) {
		getUbgProvincias2().remove(ubgProvincias2);
		ubgProvincias2.setSegUsuario2(null);

		return ubgProvincias2;
	}

}