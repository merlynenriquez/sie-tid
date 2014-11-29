package pe.gob.mininter.dirandro.model;

import java.io.Serializable;
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

import pe.gob.mininter.dirandro.util.beanbase.AuditoriaBean;


/**
 * The persistent class for the INF_ORG_EXHORTO database table.
 * 
 */
@Entity
@Table(name="INF_ORG_EXHORTO")
public class OrgExhorto extends AuditoriaBean implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="INF_ORG_EXHORTO_ID_GENERATOR", sequenceName="SEQ_INF_ORG_EXHORTO", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="INF_ORG_EXHORTO_ID_GENERATOR")
	private Long id;

	@Column(name="CODIGO_DESTINO")
	private Long codigoDestino;

	@Column(name="CODIGO_ORIGEN")
	private Long codigoOrigen;

	@Column(name="FECHA_DILINGECIA")
	private Date fechaDilingecia;

	@Column(name="FECHA_SOLICITUD")
	private Date fechaSolicitud;

	private String observaciones;

	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="TABLA_ORIGEN")
	private Valor origen;

	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="ESTADO")
	private Valor estado;

	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="TABLA_DESTINO")
	private Valor destino;

	//bi-directional many-to-one association to Informe
	@ManyToOne
	@JoinColumn(name="INFORME")
	private Informe informe;


	public OrgExhorto() {
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Long getCodigoDestino() {
		return codigoDestino;
	}


	public void setCodigoDestino(Long codigoDestino) {
		this.codigoDestino = codigoDestino;
	}


	public Long getCodigoOrigen() {
		return codigoOrigen;
	}


	public void setCodigoOrigen(Long codigoOrigen) {
		this.codigoOrigen = codigoOrigen;
	}


	public Date getFechaDilingecia() {
		return fechaDilingecia;
	}


	public void setFechaDilingecia(Date fechaDilingecia) {
		this.fechaDilingecia = fechaDilingecia;
	}


	public Date getFechaSolicitud() {
		return fechaSolicitud;
	}


	public void setFechaSolicitud(Date fechaSolicitud) {
		this.fechaSolicitud = fechaSolicitud;
	}


	public String getObservaciones() {
		return observaciones;
	}


	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}


	public Valor getOrigen() {
		return origen;
	}


	public void setOrigen(Valor origen) {
		this.origen = origen;
	}


	public Valor getEstado() {
		return estado;
	}


	public void setEstado(Valor estado) {
		this.estado = estado;
	}


	public Valor getDestino() {
		return destino;
	}


	public void setDestino(Valor destino) {
		this.destino = destino;
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
		OrgExhorto other = (OrgExhorto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}