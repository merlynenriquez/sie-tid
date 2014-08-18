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
 * The persistent class for the PER_DETALLE database table.
 * 
 */
@Entity
@Table(name="PER_DETALLE")
public class Detalle extends AuditoriaBean implements Validador, Serializable {
	
	private static final long serialVersionUID = 2783567751765001502L;

	@Id
	@SequenceGenerator(name="PER_DETALLE_ID_GENERATOR", sequenceName="SEQ_DETALLE")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PER_DETALLE_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=16)
	private Long id;

	@Column(length=20)
	private String calzado;

	@Column(name="FECHALUGAR_ULTVEZ", length=2000)
	private String fechalugarUltvez;

	@Column
	private Double peso;

	@Column(name="RASGO_FACIAL", length=400)
	private String rasgoFacial;

	@Column(length=2000)
	private String senas;

	@Column
	private Double talla;

	@Column(length=2000)
	private String vestimenta;

	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="TIPO_RAZA")
	private Valor tipoRaza;

	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="TIPO_OREJA")
	private Valor tipoOreja;

	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="COLOR_CABELLO")
	private Valor colorCabello;

	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="COLOR_OJO")
	private Valor colorOjo;

	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="COLOR_PIEL")
	private Valor colorPiel;

	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="TIPO_OJO")
	private Valor tipoOjo;

	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="TIPO_NARIZ")
	private Valor tipoNariz;

	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="TIPO_LABIO")
	private Valor tipoLabio;

	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="TIPO_CEJA")
	private Valor tipoCeja;

	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="TIPO_CABELLO")
	private Valor tipoCabello;

	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="PROFESION")
	private Valor profesion;

	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="FORMA_CARA")
	private Valor formaCara;

	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="FORMA_BOCA")
	private Valor formaBoca;

	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="CORTE_CABELLO")
	private Valor corteCabello;

	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="CONTEXTURA")
	private Valor contextura;

	//bi-directional many-to-one association to NoIdentificado
	@ManyToOne
	@JoinColumn(name="PERSONA_NA")
	private NoIdentificado perNoIdentificado;

	//bi-directional many-to-one association to Persona
	@ManyToOne
	@JoinColumn(name="PERSONA")
	private Persona persona;

	public Detalle() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCalzado() {
		return this.calzado;
	}

	public void setCalzado(String calzado) {
		this.calzado = calzado;
	}
	
	public String getFechalugarUltvez() {
		return this.fechalugarUltvez;
	}

	public void setFechalugarUltvez(String fechalugarUltvez) {
		this.fechalugarUltvez = fechalugarUltvez;
	}

	public Double getPeso() {
		return this.peso;
	}

	public void setPeso(Double peso) {
		this.peso = peso;
	}

	public String getRasgoFacial() {
		return this.rasgoFacial;
	}

	public void setRasgoFacial(String rasgoFacial) {
		this.rasgoFacial = rasgoFacial;
	}

	public String getSenas() {
		return this.senas;
	}

	public void setSenas(String senas) {
		this.senas = senas;
	}

	public Double getTalla() {
		return this.talla;
	}

	public void setTalla(Double talla) {
		this.talla = talla;
	}

	public String getVestimenta() {
		return this.vestimenta;
	}

	public void setVestimenta(String vestimenta) {
		this.vestimenta = vestimenta;
	}
	
	public Valor getTipoRaza() {
		return tipoRaza;
	}

	public void setTipoRaza(Valor tipoRaza) {
		this.tipoRaza = tipoRaza;
	}

	public Valor getTipoOreja() {
		return tipoOreja;
	}

	public void setTipoOreja(Valor tipoOreja) {
		this.tipoOreja = tipoOreja;
	}

	public Valor getColorCabello() {
		return colorCabello;
	}

	public void setColorCabello(Valor colorCabello) {
		this.colorCabello = colorCabello;
	}

	public Valor getColorOjo() {
		return colorOjo;
	}

	public void setColorOjo(Valor colorOjo) {
		this.colorOjo = colorOjo;
	}

	public Valor getColorPiel() {
		return colorPiel;
	}

	public void setColorPiel(Valor colorPiel) {
		this.colorPiel = colorPiel;
	}

	public Valor getTipoOjo() {
		return tipoOjo;
	}

	public void setTipoOjo(Valor tipoOjo) {
		this.tipoOjo = tipoOjo;
	}

	public Valor getTipoNariz() {
		return tipoNariz;
	}

	public void setTipoNariz(Valor tipoNariz) {
		this.tipoNariz = tipoNariz;
	}

	public Valor getTipoLabio() {
		return tipoLabio;
	}

	public void setTipoLabio(Valor tipoLabio) {
		this.tipoLabio = tipoLabio;
	}

	public Valor getTipoCeja() {
		return tipoCeja;
	}

	public void setTipoCeja(Valor tipoCeja) {
		this.tipoCeja = tipoCeja;
	}

	public Valor getTipoCabello() {
		return tipoCabello;
	}

	public void setTipoCabello(Valor tipoCabello) {
		this.tipoCabello = tipoCabello;
	}

	public Valor getProfesion() {
		return profesion;
	}

	public void setProfesion(Valor profesion) {
		this.profesion = profesion;
	}

	public Valor getFormaCara() {
		return formaCara;
	}

	public void setFormaCara(Valor formaCara) {
		this.formaCara = formaCara;
	}

	public Valor getFormaBoca() {
		return formaBoca;
	}

	public void setFormaBoca(Valor formaBoca) {
		this.formaBoca = formaBoca;
	}

	public Valor getCorteCabello() {
		return corteCabello;
	}

	public void setCorteCabello(Valor corteCabello) {
		this.corteCabello = corteCabello;
	}

	public Valor getContextura() {
		return contextura;
	}

	public void setContextura(Valor contextura) {
		this.contextura = contextura;
	}

	public NoIdentificado getPerNoIdentificado() {
		return this.perNoIdentificado;
	}

	public void setPerNoIdentificado(NoIdentificado perNoIdentificado) {
		this.perNoIdentificado = perNoIdentificado;
	}

	public Persona getPersona() {
		return this.persona;
	}

	public void setPersona(Persona perPersona) {
		this.persona = perPersona;
	}

	@Override
	public void validar() {
		/*if(StringUtils.isBlank( nombres ))
		{
			throw new ValidacionException(Constante.CODIGO_MENSAJE.VALIDAR_TEXTBOX, new Object[]{"Nombre"});
		}*/
	}
}