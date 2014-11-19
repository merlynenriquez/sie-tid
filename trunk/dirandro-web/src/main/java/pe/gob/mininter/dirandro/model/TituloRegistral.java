package pe.gob.mininter.dirandro.model;

import java.io.Serializable;

import javax.persistence.*;

import pe.gob.mininter.dirandro.util.beanbase.AuditoriaBean;

import java.sql.Timestamp;


/**
 * The persistent class for the INF_TITULO_REGISTRAL database table.
 * 
 */
@Entity
@Table(name="INF_TITULO_REGISTRAL")
public class TituloRegistral extends AuditoriaBean implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="INF_TITULO_REGISTRAL_ID_GENERATOR", sequenceName="SEQ_INF_TITULO_REGISTRAL", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="INF_TITULO_REGISTRAL_ID_GENERATOR")
	private Long id;

	@Column(name="FECHA_SEGUIMIENTO")
	private Timestamp fechaSeguimiento;

	@Column(name="FECHA_TERMINO")
	private Timestamp fechaTermino;

	@Column(name="FECHA_TITULO")
	private Timestamp fechaTitulo;

	@Column(name="NRO_TITULO")
	private String nroTitulo;

	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="SEDE_REGISTRAL")
	private Valor sedeRegistral;

	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="ESTADO_TRAMITE")
	private Valor estadoTramite;

	//bi-directional many-to-one association to DetPerInmExp
	@ManyToOne
	@JoinColumn(name="INMUEBLE")
	private DetPerInmExp inmueble;

	//bi-directional many-to-one association to DetPerVehExp
	@ManyToOne
	@JoinColumn(name="VEHICULO")
	private DetPerVehExp vehiculo;

	//bi-directional many-to-one association to Informe
	@ManyToOne
	@JoinColumn(name="INFORME")
	private Informe informe;

	public TituloRegistral() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Timestamp getFechaSeguimiento() {
		return fechaSeguimiento;
	}

	public void setFechaSeguimiento(Timestamp fechaSeguimiento) {
		this.fechaSeguimiento = fechaSeguimiento;
	}

	public Timestamp getFechaTermino() {
		return fechaTermino;
	}

	public void setFechaTermino(Timestamp fechaTermino) {
		this.fechaTermino = fechaTermino;
	}

	public Timestamp getFechaTitulo() {
		return fechaTitulo;
	}

	public void setFechaTitulo(Timestamp fechaTitulo) {
		this.fechaTitulo = fechaTitulo;
	}

	public String getNroTitulo() {
		return nroTitulo;
	}

	public void setNroTitulo(String nroTitulo) {
		this.nroTitulo = nroTitulo;
	}

	public Valor getSedeRegistral() {
		return sedeRegistral;
	}

	public void setSedeRegistral(Valor sedeRegistral) {
		this.sedeRegistral = sedeRegistral;
	}

	public Valor getEstadoTramite() {
		return estadoTramite;
	}

	public void setEstadoTramite(Valor estadoTramite) {
		this.estadoTramite = estadoTramite;
	}

	public DetPerInmExp getInmueble() {
		return inmueble;
	}

	public void setInmueble(DetPerInmExp inmueble) {
		this.inmueble = inmueble;
	}

	public DetPerVehExp getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(DetPerVehExp vehiculo) {
		this.vehiculo = vehiculo;
	}

	public Informe getInforme() {
		return informe;
	}

	public void setInforme(Informe informe) {
		this.informe = informe;
	}

	public boolean esNuevo(){
		return id == null || id.longValue() == 0;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TituloRegistral other = (TituloRegistral) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}