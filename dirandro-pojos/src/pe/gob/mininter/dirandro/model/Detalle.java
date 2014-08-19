package pe.gob.mininter.dirandro.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.math.BigDecimal;


/**
 * The persistent class for the PER_DETALLE database table.
 * 
 */
@Entity
@Table(name="PER_DETALLE")
public class Detalle implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="PER_DETALLE_ID_GENERATOR", sequenceName="SEQ_")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PER_DETALLE_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=16)
	private long id;

	@Column(length=20)
	private String calzado;

	private Timestamp creacion;

	private Timestamp edicion;

	@Column(name="FECHALUGAR_ULTVEZ", length=2000)
	private String fechalugarUltvez;

	@Column(precision=3, scale=2)
	private BigDecimal peso;

	@Column(name="RASGO_FACIAL", length=4000)
	private String rasgoFacial;

	@Column(length=2000)
	private String senas;

	@Column(precision=3, scale=2)
	private BigDecimal talla;

	@Column(length=2000)
	private String vestimenta;

	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="TIPO_RAZA")
	private Valor cfgValor1;

	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="TIPO_OREJA")
	private Valor cfgValor2;

	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="COLOR_CABELLO")
	private Valor cfgValor3;

	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="COLOR_OJO")
	private Valor cfgValor4;

	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="COLOR_PIEL")
	private Valor cfgValor5;

	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="TIPO_OJO")
	private Valor cfgValor6;

	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="TIPO_NARIZ")
	private Valor cfgValor7;

	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="TIPO_LABIO")
	private Valor cfgValor8;

	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="TIPO_CEJA")
	private Valor cfgValor9;

	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="TIPO_CABELLO")
	private Valor cfgValor10;

	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="PROFESION")
	private Valor cfgValor11;

	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="FORMA_CARA")
	private Valor cfgValor12;

	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="FORMA_BOCA")
	private Valor cfgValor13;

	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="CORTE_CABELLO")
	private Valor cfgValor14;

	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="CONTEXTURA")
	private Valor cfgValor15;

	//bi-directional many-to-one association to NoIdentificado
	@ManyToOne
	@JoinColumn(name="PERSONA_NA")
	private NoIdentificado perNoIdentificado;

	//bi-directional many-to-one association to Persona
	@ManyToOne
	@JoinColumn(name="PERSONA")
	private Persona perPersona;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="CREADOR")
	private Usuario segUsuario1;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="EDITOR")
	private Usuario segUsuario2;

	public Detalle() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCalzado() {
		return this.calzado;
	}

	public void setCalzado(String calzado) {
		this.calzado = calzado;
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

	public String getFechalugarUltvez() {
		return this.fechalugarUltvez;
	}

	public void setFechalugarUltvez(String fechalugarUltvez) {
		this.fechalugarUltvez = fechalugarUltvez;
	}

	public BigDecimal getPeso() {
		return this.peso;
	}

	public void setPeso(BigDecimal peso) {
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

	public BigDecimal getTalla() {
		return this.talla;
	}

	public void setTalla(BigDecimal talla) {
		this.talla = talla;
	}

	public String getVestimenta() {
		return this.vestimenta;
	}

	public void setVestimenta(String vestimenta) {
		this.vestimenta = vestimenta;
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

	public Valor getCfgValor5() {
		return this.cfgValor5;
	}

	public void setCfgValor5(Valor cfgValor5) {
		this.cfgValor5 = cfgValor5;
	}

	public Valor getCfgValor6() {
		return this.cfgValor6;
	}

	public void setCfgValor6(Valor cfgValor6) {
		this.cfgValor6 = cfgValor6;
	}

	public Valor getCfgValor7() {
		return this.cfgValor7;
	}

	public void setCfgValor7(Valor cfgValor7) {
		this.cfgValor7 = cfgValor7;
	}

	public Valor getCfgValor8() {
		return this.cfgValor8;
	}

	public void setCfgValor8(Valor cfgValor8) {
		this.cfgValor8 = cfgValor8;
	}

	public Valor getCfgValor9() {
		return this.cfgValor9;
	}

	public void setCfgValor9(Valor cfgValor9) {
		this.cfgValor9 = cfgValor9;
	}

	public Valor getCfgValor10() {
		return this.cfgValor10;
	}

	public void setCfgValor10(Valor cfgValor10) {
		this.cfgValor10 = cfgValor10;
	}

	public Valor getCfgValor11() {
		return this.cfgValor11;
	}

	public void setCfgValor11(Valor cfgValor11) {
		this.cfgValor11 = cfgValor11;
	}

	public Valor getCfgValor12() {
		return this.cfgValor12;
	}

	public void setCfgValor12(Valor cfgValor12) {
		this.cfgValor12 = cfgValor12;
	}

	public Valor getCfgValor13() {
		return this.cfgValor13;
	}

	public void setCfgValor13(Valor cfgValor13) {
		this.cfgValor13 = cfgValor13;
	}

	public Valor getCfgValor14() {
		return this.cfgValor14;
	}

	public void setCfgValor14(Valor cfgValor14) {
		this.cfgValor14 = cfgValor14;
	}

	public Valor getCfgValor15() {
		return this.cfgValor15;
	}

	public void setCfgValor15(Valor cfgValor15) {
		this.cfgValor15 = cfgValor15;
	}

	public NoIdentificado getPerNoIdentificado() {
		return this.perNoIdentificado;
	}

	public void setPerNoIdentificado(NoIdentificado perNoIdentificado) {
		this.perNoIdentificado = perNoIdentificado;
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