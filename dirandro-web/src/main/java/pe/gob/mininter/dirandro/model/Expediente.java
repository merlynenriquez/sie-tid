package pe.gob.mininter.dirandro.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
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
 * The persistent class for the EXP_EXPEDIENTE database table.
 * 
 */
@Entity
@Table(name="EXP_EXPEDIENTE")
public class Expediente extends AuditoriaBean implements Validador, Serializable {
	
	private static final long serialVersionUID = 5892064154535170688L;

	@Id
	@SequenceGenerator(name="EXP_EXPEDIENTE_ID_GENERATOR", sequenceName="SEQ_", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="EXP_EXPEDIENTE_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=16)
	private Long id;

	@Column(length=500)
	private String asunto;

	@Column(length=100)
	private String autogenerado;

	@Column(name="CODIGO_INTERVINIENTE", precision=16)
	private BigDecimal codigoInterviniente;

	@Column(length=400)
	private String descripcion;

	@Column(name="DIAS_ATENCION", precision=4)
	private BigDecimal diasAtencion;

	@Column(name="DIRECCION_HECHO", length=200)
	private String direccionHecho;

	@Column(name="FECHA_REGISTRO")
	private Timestamp fechaRegistro;

	@Column(name="HORA_HECHO")
	private Timestamp horaHecho;

	@Column(name="NOMBRE_CASO", length=400)
	private String nombreCaso;

	@Column(name="REFERENCIA_HECHO", length=300)
	private String referenciaHecho;

	//bi-directional many-to-one association to Adjunto
	@OneToMany(mappedBy="expExpediente")
	private List<Adjunto> expAdjuntos;

	//bi-directional many-to-one association to DetExpedientePersona
	@OneToMany(mappedBy="expExpediente")
	private List<DetExpedientePersona> expDetExpedientePersonas;

	//bi-directional many-to-one association to DetPerArmExp
	@OneToMany(mappedBy="expExpediente")
	private List<DetPerArmExp> expDetPerArmExps;

	//bi-directional many-to-one association to DetPerInmExp
	@OneToMany(mappedBy="expExpediente")
	private List<DetPerInmExp> expDetPerInmExps;

	//bi-directional many-to-one association to DetPerTelExp
	@OneToMany(mappedBy="expExpediente")
	private List<DetPerTelExp> expDetPerTelExps;

	//bi-directional many-to-one association to DetPerVehExp
	@OneToMany(mappedBy="expExpediente")
	private List<DetPerVehExp> expDetPerVehExps;

	//bi-directional many-to-one association to Documento
	@OneToMany(mappedBy="expExpediente")
	private List<Documento> expDocumentos;

	//bi-directional many-to-one association to Droga
	@OneToMany(mappedBy="expExpediente")
	private List<Droga> expDrogas;

	//bi-directional many-to-one association to Especie
	@OneToMany(mappedBy="expExpediente")
	private List<Especie> expEspecies;

	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="TIPO_FINALIDAD")
	private Valor tipoFinalidad;

	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="CUENCA")
	private Valor cuenca;

	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="TABLA_INTERVINIENTE")
	private Valor tablaInterviniente;

	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="TIPO_DIRECCION")
	private Valor tipoDireccion;

	//bi-directional many-to-one association to CentroPoblado
	@ManyToOne
	@JoinColumn(name="CENTRO_POBLADO")
	private CentroPoblado expCentroPoblado;

	//bi-directional many-to-one association to Dependencia
	@ManyToOne
	@JoinColumn(name="DEPENDENCIA")
	private Dependencia expDependencia;

	//bi-directional many-to-one association to Entidad
	@ManyToOne
	@JoinColumn(name="JURISDICCION_HECHO")
	private Entidad expEntidad;

	//bi-directional many-to-one association to Estado
	@ManyToOne
	@JoinColumn(name="ESTADO_EXP", nullable=false)
	private Estado expEstado;

	//bi-directional many-to-one association to Expediente
	@ManyToOne
	@JoinColumn(name="PADRE")
	private Expediente expExpediente;

	//bi-directional many-to-one association to Expediente
	@OneToMany(mappedBy="expExpediente")
	private List<Expediente> expExpedientes;

	//bi-directional many-to-one association to TipoHecho
	@ManyToOne
	@JoinColumn(name="TIPO_HECHO")
	private TipoHecho expTipoHecho;

	//bi-directional many-to-one association to Integrante
	@ManyToOne
	@JoinColumn(name="INTEGRANTE")
	private Integrante orgIntegrante;

	//bi-directional many-to-one association to Distrito
	@ManyToOne
	@JoinColumn(name="LUGAR_HECHO")
	private Distrito ubgDistrito;

	//bi-directional many-to-one association to ExpedienteDelito
	@OneToMany(mappedBy="expExpediente")
	private List<ExpedienteDelito> expExpedienteDelitos;

	//bi-directional many-to-one association to Explosivo
	@OneToMany(mappedBy="expExpediente")
	private List<Explosivo> expExplosivos;

	//bi-directional many-to-one association to Importe
	@OneToMany(mappedBy="expExpediente")
	private List<Importe> expImportes;

	//bi-directional many-to-one association to Instalacion
	@OneToMany(mappedBy="expExpediente")
	private List<Instalacion> expInstalacions;

	//bi-directional many-to-one association to Municione
	@OneToMany(mappedBy="expExpediente")
	private List<Municione> expMuniciones;

	//bi-directional many-to-one association to Ruta
	@OneToMany(mappedBy="expExpediente")
	private List<Ruta> expRutas;

	//bi-directional many-to-one association to Hojaremision
	@OneToMany(mappedBy="expExpediente")
	private List<Hojaremision> hrHojaremisions;

	//bi-directional many-to-one association to NoIdentificado
	@OneToMany(mappedBy="expExpediente")
	private List<NoIdentificado> perNoIdentificados;

	public Expediente() {
	}
 
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAsunto() {
		return asunto;
	}

	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}

	public String getAutogenerado() {
		return autogenerado;
	}

	public void setAutogenerado(String autogenerado) {
		this.autogenerado = autogenerado;
	}

	public BigDecimal getCodigoInterviniente() {
		return codigoInterviniente;
	}

	public void setCodigoInterviniente(BigDecimal codigoInterviniente) {
		this.codigoInterviniente = codigoInterviniente;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public BigDecimal getDiasAtencion() {
		return diasAtencion;
	}

	public void setDiasAtencion(BigDecimal diasAtencion) {
		this.diasAtencion = diasAtencion;
	}

	public String getDireccionHecho() {
		return direccionHecho;
	}

	public void setDireccionHecho(String direccionHecho) {
		this.direccionHecho = direccionHecho;
	}

	public Timestamp getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Timestamp fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public Timestamp getHoraHecho() {
		return horaHecho;
	}

	public void setHoraHecho(Timestamp horaHecho) {
		this.horaHecho = horaHecho;
	}

	public String getNombreCaso() {
		return nombreCaso;
	}

	public void setNombreCaso(String nombreCaso) {
		this.nombreCaso = nombreCaso;
	}

	public String getReferenciaHecho() {
		return referenciaHecho;
	}

	public void setReferenciaHecho(String referenciaHecho) {
		this.referenciaHecho = referenciaHecho;
	}

	public List<Adjunto> getExpAdjuntos() {
		return expAdjuntos;
	}

	public void setExpAdjuntos(List<Adjunto> expAdjuntos) {
		this.expAdjuntos = expAdjuntos;
	}

	public List<DetExpedientePersona> getExpDetExpedientePersonas() {
		return expDetExpedientePersonas;
	}

	public void setExpDetExpedientePersonas(
			List<DetExpedientePersona> expDetExpedientePersonas) {
		this.expDetExpedientePersonas = expDetExpedientePersonas;
	}

	public List<DetPerArmExp> getExpDetPerArmExps() {
		return expDetPerArmExps;
	}

	public void setExpDetPerArmExps(List<DetPerArmExp> expDetPerArmExps) {
		this.expDetPerArmExps = expDetPerArmExps;
	}

	public List<DetPerInmExp> getExpDetPerInmExps() {
		return expDetPerInmExps;
	}

	public void setExpDetPerInmExps(List<DetPerInmExp> expDetPerInmExps) {
		this.expDetPerInmExps = expDetPerInmExps;
	}

	public List<DetPerTelExp> getExpDetPerTelExps() {
		return expDetPerTelExps;
	}

	public void setExpDetPerTelExps(List<DetPerTelExp> expDetPerTelExps) {
		this.expDetPerTelExps = expDetPerTelExps;
	}

	public List<DetPerVehExp> getExpDetPerVehExps() {
		return expDetPerVehExps;
	}

	public void setExpDetPerVehExps(List<DetPerVehExp> expDetPerVehExps) {
		this.expDetPerVehExps = expDetPerVehExps;
	}

	public List<Documento> getExpDocumentos() {
		return expDocumentos;
	}

	public void setExpDocumentos(List<Documento> expDocumentos) {
		this.expDocumentos = expDocumentos;
	}

	public List<Droga> getExpDrogas() {
		return expDrogas;
	}

	public void setExpDrogas(List<Droga> expDrogas) {
		this.expDrogas = expDrogas;
	}

	public List<Especie> getExpEspecies() {
		return expEspecies;
	}

	public void setExpEspecies(List<Especie> expEspecies) {
		this.expEspecies = expEspecies;
	}

	public Valor getTipoFinalidad() {
		return tipoFinalidad;
	}

	public void setTipoFinalidad(Valor tipoFinalidad) {
		this.tipoFinalidad = tipoFinalidad;
	}

	public Valor getCuenca() {
		return cuenca;
	}

	public void setCuenca(Valor cuenca) {
		this.cuenca = cuenca;
	}

	public Valor getTablaInterviniente() {
		return tablaInterviniente;
	}

	public void setTablaInterviniente(Valor tablaInterviniente) {
		this.tablaInterviniente = tablaInterviniente;
	}

	public Valor getTipoDireccion() {
		return tipoDireccion;
	}

	public void setTipoDireccion(Valor tipoDireccion) {
		this.tipoDireccion = tipoDireccion;
	}

	public CentroPoblado getExpCentroPoblado() {
		return expCentroPoblado;
	}

	public void setExpCentroPoblado(CentroPoblado expCentroPoblado) {
		this.expCentroPoblado = expCentroPoblado;
	}

	public Dependencia getExpDependencia() {
		return expDependencia;
	}

	public void setExpDependencia(Dependencia expDependencia) {
		this.expDependencia = expDependencia;
	}

	public Entidad getExpEntidad() {
		return expEntidad;
	}

	public void setExpEntidad(Entidad expEntidad) {
		this.expEntidad = expEntidad;
	}

	public Estado getExpEstado() {
		return expEstado;
	}

	public void setExpEstado(Estado expEstado) {
		this.expEstado = expEstado;
	}

	public Expediente getExpExpediente() {
		return expExpediente;
	}

	public void setExpExpediente(Expediente expExpediente) {
		this.expExpediente = expExpediente;
	}

	public List<Expediente> getExpExpedientes() {
		return expExpedientes;
	}

	public void setExpExpedientes(List<Expediente> expExpedientes) {
		this.expExpedientes = expExpedientes;
	}

	public TipoHecho getExpTipoHecho() {
		return expTipoHecho;
	}

	public void setExpTipoHecho(TipoHecho expTipoHecho) {
		this.expTipoHecho = expTipoHecho;
	}

	public Integrante getOrgIntegrante() {
		return orgIntegrante;
	}

	public void setOrgIntegrante(Integrante orgIntegrante) {
		this.orgIntegrante = orgIntegrante;
	}

	public Distrito getUbgDistrito() {
		return ubgDistrito;
	}

	public void setUbgDistrito(Distrito ubgDistrito) {
		this.ubgDistrito = ubgDistrito;
	}

	public List<ExpedienteDelito> getExpExpedienteDelitos() {
		return expExpedienteDelitos;
	}

	public void setExpExpedienteDelitos(List<ExpedienteDelito> expExpedienteDelitos) {
		this.expExpedienteDelitos = expExpedienteDelitos;
	}

	public List<Explosivo> getExpExplosivos() {
		return expExplosivos;
	}

	public void setExpExplosivos(List<Explosivo> expExplosivos) {
		this.expExplosivos = expExplosivos;
	}

	public List<Importe> getExpImportes() {
		return expImportes;
	}

	public void setExpImportes(List<Importe> expImportes) {
		this.expImportes = expImportes;
	}

	public List<Instalacion> getExpInstalacions() {
		return expInstalacions;
	}

	public void setExpInstalacions(List<Instalacion> expInstalacions) {
		this.expInstalacions = expInstalacions;
	}

	public List<Municione> getExpMuniciones() {
		return expMuniciones;
	}

	public void setExpMuniciones(List<Municione> expMuniciones) {
		this.expMuniciones = expMuniciones;
	}

	public List<Ruta> getExpRutas() {
		return expRutas;
	}

	public void setExpRutas(List<Ruta> expRutas) {
		this.expRutas = expRutas;
	}

	public List<Hojaremision> getHrHojaremisions() {
		return hrHojaremisions;
	}

	public void setHrHojaremisions(List<Hojaremision> hrHojaremisions) {
		this.hrHojaremisions = hrHojaremisions;
	}

	public List<NoIdentificado> getPerNoIdentificados() {
		return perNoIdentificados;
	}

	public void setPerNoIdentificados(List<NoIdentificado> perNoIdentificados) {
		this.perNoIdentificados = perNoIdentificados;
	}

	@Override
	public void validar() {
		// TODO Auto-generated method stub
		
	}

}