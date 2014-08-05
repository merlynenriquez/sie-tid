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
	@SequenceGenerator(name="EXP_EXPEDIENTE_ID_GENERATOR", sequenceName="SEQ_")
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
	private Valor cfgValor1;

	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="CUENCA")
	private Valor cfgValor2;

	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="TABLA_INTERVINIENTE")
	private Valor cfgValor3;

	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="TIPO_DIRECCION")
	private Valor cfgValor4;

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
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAsunto() {
		return this.asunto;
	}

	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}

	public String getAutogenerado() {
		return this.autogenerado;
	}

	public void setAutogenerado(String autogenerado) {
		this.autogenerado = autogenerado;
	}

	public BigDecimal getCodigoInterviniente() {
		return this.codigoInterviniente;
	}

	public void setCodigoInterviniente(BigDecimal codigoInterviniente) {
		this.codigoInterviniente = codigoInterviniente;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public BigDecimal getDiasAtencion() {
		return this.diasAtencion;
	}

	public void setDiasAtencion(BigDecimal diasAtencion) {
		this.diasAtencion = diasAtencion;
	}

	public String getDireccionHecho() {
		return this.direccionHecho;
	}

	public void setDireccionHecho(String direccionHecho) {
		this.direccionHecho = direccionHecho;
	}

	public Timestamp getFechaRegistro() {
		return this.fechaRegistro;
	}

	public void setFechaRegistro(Timestamp fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public Timestamp getHoraHecho() {
		return this.horaHecho;
	}

	public void setHoraHecho(Timestamp horaHecho) {
		this.horaHecho = horaHecho;
	}

	public String getNombreCaso() {
		return this.nombreCaso;
	}

	public void setNombreCaso(String nombreCaso) {
		this.nombreCaso = nombreCaso;
	}

	public String getReferenciaHecho() {
		return this.referenciaHecho;
	}

	public void setReferenciaHecho(String referenciaHecho) {
		this.referenciaHecho = referenciaHecho;
	}

	public List<Adjunto> getExpAdjuntos() {
		return this.expAdjuntos;
	}

	public void setExpAdjuntos(List<Adjunto> expAdjuntos) {
		this.expAdjuntos = expAdjuntos;
	}

	public Adjunto addExpAdjunto(Adjunto expAdjunto) {
		getExpAdjuntos().add(expAdjunto);
		expAdjunto.setExpExpediente(this);

		return expAdjunto;
	}

	public Adjunto removeExpAdjunto(Adjunto expAdjunto) {
		getExpAdjuntos().remove(expAdjunto);
		expAdjunto.setExpExpediente(null);

		return expAdjunto;
	}

	public List<DetExpedientePersona> getExpDetExpedientePersonas() {
		return this.expDetExpedientePersonas;
	}

	public void setExpDetExpedientePersonas(List<DetExpedientePersona> expDetExpedientePersonas) {
		this.expDetExpedientePersonas = expDetExpedientePersonas;
	}

	public DetExpedientePersona addExpDetExpedientePersona(DetExpedientePersona expDetExpedientePersona) {
		getExpDetExpedientePersonas().add(expDetExpedientePersona);
		expDetExpedientePersona.setExpExpediente(this);

		return expDetExpedientePersona;
	}

	public DetExpedientePersona removeExpDetExpedientePersona(DetExpedientePersona expDetExpedientePersona) {
		getExpDetExpedientePersonas().remove(expDetExpedientePersona);
		expDetExpedientePersona.setExpExpediente(null);

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
		expDetPerArmExp.setExpExpediente(this);

		return expDetPerArmExp;
	}

	public DetPerArmExp removeExpDetPerArmExp(DetPerArmExp expDetPerArmExp) {
		getExpDetPerArmExps().remove(expDetPerArmExp);
		expDetPerArmExp.setExpExpediente(null);

		return expDetPerArmExp;
	}

	public List<DetPerInmExp> getExpDetPerInmExps() {
		return this.expDetPerInmExps;
	}

	public void setExpDetPerInmExps(List<DetPerInmExp> expDetPerInmExps) {
		this.expDetPerInmExps = expDetPerInmExps;
	}

	public DetPerInmExp addExpDetPerInmExp(DetPerInmExp expDetPerInmExp) {
		getExpDetPerInmExps().add(expDetPerInmExp);
		expDetPerInmExp.setExpExpediente(this);

		return expDetPerInmExp;
	}

	public DetPerInmExp removeExpDetPerInmExp(DetPerInmExp expDetPerInmExp) {
		getExpDetPerInmExps().remove(expDetPerInmExp);
		expDetPerInmExp.setExpExpediente(null);

		return expDetPerInmExp;
	}

	public List<DetPerTelExp> getExpDetPerTelExps() {
		return this.expDetPerTelExps;
	}

	public void setExpDetPerTelExps(List<DetPerTelExp> expDetPerTelExps) {
		this.expDetPerTelExps = expDetPerTelExps;
	}

	public DetPerTelExp addExpDetPerTelExp(DetPerTelExp expDetPerTelExp) {
		getExpDetPerTelExps().add(expDetPerTelExp);
		expDetPerTelExp.setExpExpediente(this);

		return expDetPerTelExp;
	}

	public DetPerTelExp removeExpDetPerTelExp(DetPerTelExp expDetPerTelExp) {
		getExpDetPerTelExps().remove(expDetPerTelExp);
		expDetPerTelExp.setExpExpediente(null);

		return expDetPerTelExp;
	}

	public List<DetPerVehExp> getExpDetPerVehExps() {
		return this.expDetPerVehExps;
	}

	public void setExpDetPerVehExps(List<DetPerVehExp> expDetPerVehExps) {
		this.expDetPerVehExps = expDetPerVehExps;
	}

	public DetPerVehExp addExpDetPerVehExp(DetPerVehExp expDetPerVehExp) {
		getExpDetPerVehExps().add(expDetPerVehExp);
		expDetPerVehExp.setExpExpediente(this);

		return expDetPerVehExp;
	}

	public DetPerVehExp removeExpDetPerVehExp(DetPerVehExp expDetPerVehExp) {
		getExpDetPerVehExps().remove(expDetPerVehExp);
		expDetPerVehExp.setExpExpediente(null);

		return expDetPerVehExp;
	}

	public List<Documento> getExpDocumentos() {
		return this.expDocumentos;
	}

	public void setExpDocumentos(List<Documento> expDocumentos) {
		this.expDocumentos = expDocumentos;
	}

	public Documento addExpDocumento(Documento expDocumento) {
		getExpDocumentos().add(expDocumento);
		expDocumento.setExpExpediente(this);

		return expDocumento;
	}

	public Documento removeExpDocumento(Documento expDocumento) {
		getExpDocumentos().remove(expDocumento);
		expDocumento.setExpExpediente(null);

		return expDocumento;
	}

	public List<Droga> getExpDrogas() {
		return this.expDrogas;
	}

	public void setExpDrogas(List<Droga> expDrogas) {
		this.expDrogas = expDrogas;
	}

	public Droga addExpDroga(Droga expDroga) {
		getExpDrogas().add(expDroga);
		expDroga.setExpExpediente(this);

		return expDroga;
	}

	public Droga removeExpDroga(Droga expDroga) {
		getExpDrogas().remove(expDroga);
		expDroga.setExpExpediente(null);

		return expDroga;
	}

	public List<Especie> getExpEspecies() {
		return this.expEspecies;
	}

	public void setExpEspecies(List<Especie> expEspecies) {
		this.expEspecies = expEspecies;
	}

	public Especie addExpEspecy(Especie expEspecy) {
		getExpEspecies().add(expEspecy);
		expEspecy.setExpExpediente(this);

		return expEspecy;
	}

	public Especie removeExpEspecy(Especie expEspecy) {
		getExpEspecies().remove(expEspecy);
		expEspecy.setExpExpediente(null);

		return expEspecy;
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

	public Valor getCfgValor4() {
		return this.cfgValor4;
	}

	public void setCfgValor4(Valor cfgValor4) {
		this.cfgValor4 = cfgValor4;
	}

	public CentroPoblado getExpCentroPoblado() {
		return this.expCentroPoblado;
	}

	public void setExpCentroPoblado(CentroPoblado expCentroPoblado) {
		this.expCentroPoblado = expCentroPoblado;
	}

	public Dependencia getExpDependencia() {
		return this.expDependencia;
	}

	public void setExpDependencia(Dependencia expDependencia) {
		this.expDependencia = expDependencia;
	}

	public Entidad getExpEntidad() {
		return this.expEntidad;
	}

	public void setExpEntidad(Entidad expEntidad) {
		this.expEntidad = expEntidad;
	}

	public Estado getExpEstado() {
		return this.expEstado;
	}

	public void setExpEstado(Estado expEstado) {
		this.expEstado = expEstado;
	}

	public Expediente getExpExpediente() {
		return this.expExpediente;
	}

	public void setExpExpediente(Expediente expExpediente) {
		this.expExpediente = expExpediente;
	}

	public List<Expediente> getExpExpedientes() {
		return this.expExpedientes;
	}

	public void setExpExpedientes(List<Expediente> expExpedientes) {
		this.expExpedientes = expExpedientes;
	}

	public Expediente addExpExpediente(Expediente expExpediente) {
		getExpExpedientes().add(expExpediente);
		expExpediente.setExpExpediente(this);

		return expExpediente;
	}

	public Expediente removeExpExpediente(Expediente expExpediente) {
		getExpExpedientes().remove(expExpediente);
		expExpediente.setExpExpediente(null);

		return expExpediente;
	}

	public TipoHecho getExpTipoHecho() {
		return this.expTipoHecho;
	}

	public void setExpTipoHecho(TipoHecho expTipoHecho) {
		this.expTipoHecho = expTipoHecho;
	}

	public Integrante getOrgIntegrante() {
		return this.orgIntegrante;
	}

	public void setOrgIntegrante(Integrante orgIntegrante) {
		this.orgIntegrante = orgIntegrante;
	}

	public Distrito getUbgDistrito() {
		return this.ubgDistrito;
	}

	public void setUbgDistrito(Distrito ubgDistrito) {
		this.ubgDistrito = ubgDistrito;
	}

	public List<ExpedienteDelito> getExpExpedienteDelitos() {
		return this.expExpedienteDelitos;
	}

	public void setExpExpedienteDelitos(List<ExpedienteDelito> expExpedienteDelitos) {
		this.expExpedienteDelitos = expExpedienteDelitos;
	}

	public ExpedienteDelito addExpExpedienteDelito(ExpedienteDelito expExpedienteDelito) {
		getExpExpedienteDelitos().add(expExpedienteDelito);
		expExpedienteDelito.setExpExpediente(this);

		return expExpedienteDelito;
	}

	public ExpedienteDelito removeExpExpedienteDelito(ExpedienteDelito expExpedienteDelito) {
		getExpExpedienteDelitos().remove(expExpedienteDelito);
		expExpedienteDelito.setExpExpediente(null);

		return expExpedienteDelito;
	}

	public List<Explosivo> getExpExplosivos() {
		return this.expExplosivos;
	}

	public void setExpExplosivos(List<Explosivo> expExplosivos) {
		this.expExplosivos = expExplosivos;
	}

	public Explosivo addExpExplosivo(Explosivo expExplosivo) {
		getExpExplosivos().add(expExplosivo);
		expExplosivo.setExpExpediente(this);

		return expExplosivo;
	}

	public Explosivo removeExpExplosivo(Explosivo expExplosivo) {
		getExpExplosivos().remove(expExplosivo);
		expExplosivo.setExpExpediente(null);

		return expExplosivo;
	}

	public List<Importe> getExpImportes() {
		return this.expImportes;
	}

	public void setExpImportes(List<Importe> expImportes) {
		this.expImportes = expImportes;
	}

	public Importe addExpImporte(Importe expImporte) {
		getExpImportes().add(expImporte);
		expImporte.setExpExpediente(this);

		return expImporte;
	}

	public Importe removeExpImporte(Importe expImporte) {
		getExpImportes().remove(expImporte);
		expImporte.setExpExpediente(null);

		return expImporte;
	}

	public List<Instalacion> getExpInstalacions() {
		return this.expInstalacions;
	}

	public void setExpInstalacions(List<Instalacion> expInstalacions) {
		this.expInstalacions = expInstalacions;
	}

	public Instalacion addExpInstalacion(Instalacion expInstalacion) {
		getExpInstalacions().add(expInstalacion);
		expInstalacion.setExpExpediente(this);

		return expInstalacion;
	}

	public Instalacion removeExpInstalacion(Instalacion expInstalacion) {
		getExpInstalacions().remove(expInstalacion);
		expInstalacion.setExpExpediente(null);

		return expInstalacion;
	}

	public List<Municione> getExpMuniciones() {
		return this.expMuniciones;
	}

	public void setExpMuniciones(List<Municione> expMuniciones) {
		this.expMuniciones = expMuniciones;
	}

	public Municione addExpMunicione(Municione expMunicione) {
		getExpMuniciones().add(expMunicione);
		expMunicione.setExpExpediente(this);

		return expMunicione;
	}

	public Municione removeExpMunicione(Municione expMunicione) {
		getExpMuniciones().remove(expMunicione);
		expMunicione.setExpExpediente(null);

		return expMunicione;
	}

	public List<Ruta> getExpRutas() {
		return this.expRutas;
	}

	public void setExpRutas(List<Ruta> expRutas) {
		this.expRutas = expRutas;
	}

	public Ruta addExpRuta(Ruta expRuta) {
		getExpRutas().add(expRuta);
		expRuta.setExpExpediente(this);

		return expRuta;
	}

	public Ruta removeExpRuta(Ruta expRuta) {
		getExpRutas().remove(expRuta);
		expRuta.setExpExpediente(null);

		return expRuta;
	}

	public List<Hojaremision> getHrHojaremisions() {
		return this.hrHojaremisions;
	}

	public void setHrHojaremisions(List<Hojaremision> hrHojaremisions) {
		this.hrHojaremisions = hrHojaremisions;
	}

	public Hojaremision addHrHojaremision(Hojaremision hrHojaremision) {
		getHrHojaremisions().add(hrHojaremision);
		hrHojaremision.setExpExpediente(this);

		return hrHojaremision;
	}

	public Hojaremision removeHrHojaremision(Hojaremision hrHojaremision) {
		getHrHojaremisions().remove(hrHojaremision);
		hrHojaremision.setExpExpediente(null);

		return hrHojaremision;
	}

	public List<NoIdentificado> getPerNoIdentificados() {
		return this.perNoIdentificados;
	}

	public void setPerNoIdentificados(List<NoIdentificado> perNoIdentificados) {
		this.perNoIdentificados = perNoIdentificados;
	}

	public NoIdentificado addPerNoIdentificado(NoIdentificado perNoIdentificado) {
		getPerNoIdentificados().add(perNoIdentificado);
		perNoIdentificado.setExpExpediente(this);

		return perNoIdentificado;
	}

	public NoIdentificado removePerNoIdentificado(NoIdentificado perNoIdentificado) {
		getPerNoIdentificados().remove(perNoIdentificado);
		perNoIdentificado.setExpExpediente(null);

		return perNoIdentificado;
	}

	@Override
	public void validar() {
		// TODO Auto-generated method stub
		
	}

}