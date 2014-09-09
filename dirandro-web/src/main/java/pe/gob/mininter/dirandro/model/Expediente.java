package pe.gob.mininter.dirandro.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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
	@SequenceGenerator(name="EXP_EXPEDIENTE_ID_GENERATOR", sequenceName="SEQ_EXPEDIENTE", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="EXP_EXPEDIENTE_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=16)
	private Long id;

	@Column(length=500)
	private String asunto;

	@Column(length=100)
	private String autogenerado;

	@Column(name="CODIGO_INTERVINIENTE", precision=16)
	private Long codigoInterviniente;

	@Column(length=400)
	private String descripcion;

	@Column(name="DIAS_ATENCION", precision=4)
	private BigDecimal diasAtencion;

	@Column(name="DIRECCION_HECHO", length=200)
	private String direccionHecho;

	@Column(name="FECHA_REGISTRO")
	@Temporal( TemporalType.TIMESTAMP)
	private Date fechaRegistro;

	@Column(name="HORA_HECHO")
	private Date horaHecho;

	@Column(name="NOMBRE_CASO", length=400)
	private String nombreCaso;

	@Column(name="REFERENCIA_HECHO", length=300)
	private String referenciaHecho;

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
	private CentroPoblado centroPoblado;

	//bi-directional many-to-one association to Dependencia
	@ManyToOne
	@JoinColumn(name="DEPENDENCIA")
	private Dependencia dependencia;

	//bi-directional many-to-one association to Entidad
	@ManyToOne
	@JoinColumn(name="JURISDICCION_HECHO")
	private Entidad expEntidad;

	//bi-directional many-to-one association to Estado
	@ManyToOne
	@JoinColumn(name="ESTADO_EXP", nullable=false)
	private Estado estado;	

	//bi-directional many-to-one association to Expediente
	@ManyToOne
	@JoinColumn(name="PADRE")
	private Expediente padre;

	//bi-directional many-to-one association to TipoHecho
	@ManyToOne
	@JoinColumn(name="TIPO_HECHO")
	private TipoHecho tipoHecho;

	//bi-directional many-to-one association to Integrante
	@ManyToOne
	@JoinColumn(name="INTEGRANTE")
	private Integrante integrante;

	//bi-directional many-to-one association to Distrito
	@ManyToOne
	@JoinColumn(name="LUGAR_HECHO")
	private Distrito lugarHecho;

	public Expediente() {
	}
	
	public boolean esNuevo()
	{
		return id == null || id.longValue() == 0;
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

	public Long getCodigoInterviniente() {
		return codigoInterviniente;
	}

	public void setCodigoInterviniente(Long codigoInterviniente) {
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

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public Date getHoraHecho() {
		return horaHecho;
	}

	public void setHoraHecho(Date horaHecho) {
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

	public CentroPoblado getCentroPoblado() {
		return centroPoblado;
	}

	public void setCentroPoblado(CentroPoblado expCentroPoblado) {
		this.centroPoblado = expCentroPoblado;
	}

	public Dependencia getDependencia() {
		return dependencia;
	}

	public void setDependencia(Dependencia expDependencia) {
		this.dependencia = expDependencia;
	}

	public Entidad getExpEntidad() {
		return expEntidad;
	}

	public void setExpEntidad(Entidad expEntidad) {
		this.expEntidad = expEntidad;
	}

	public Estado getExpEstado() {
		return estado;
	}

	public void setExpEstado(Estado expEstado) {
		this.estado = expEstado;
	}

	public Expediente getPadre() {
		return padre;
	}

	public void setPadre(Expediente expExpediente) {
		this.padre = expExpediente;
	}

	public TipoHecho getTipoHecho() {
		return tipoHecho;
	}

	public void setTipoHecho(TipoHecho expTipoHecho) {
		this.tipoHecho = expTipoHecho;
	}

	public Integrante getIntegrante() {
		return integrante;
	}

	public void setIntegrante(Integrante orgIntegrante) {
		this.integrante = orgIntegrante;
	}

	public Distrito getLugarHecho() {
		return lugarHecho;
	}

	public void setLugarHecho(Distrito ubgDistrito) {
		this.lugarHecho = ubgDistrito;
	}

	@Override
	public void validar() {
		// TODO Auto-generated method stub
		
	}

}