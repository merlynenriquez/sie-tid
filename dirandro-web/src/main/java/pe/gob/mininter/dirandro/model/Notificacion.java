package pe.gob.mininter.dirandro.model;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
 * The persistent class for the INF_NOTIFICACION database table.
 * 
 */
@Entity
@Table(name="INF_NOTIFICACION")
public class Notificacion extends AuditoriaBean implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="INF_NOTIFICACION_ID_GENERATOR", sequenceName="SEQ_INF_NOTIFICACION", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="INF_NOTIFICACION_ID_GENERATOR")
	private Long id;

	@Column(name="FECHA_PLAZO")
	private Date fechaPlazo;

	@Column(name="FECHA_RECEPCION")
	private Date fechaRecepcion;

	@Column(name="FECHA_VENCIMIENTO")
	private Date fechaVencimiento;

	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="TIPO_NOTIFICACION")
	private Valor tipoNotificacion;

	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="ESTADO")
	private Valor estado;

	//bi-directional many-to-one association to Dependencia
	@ManyToOne
	@JoinColumn(name="UNIDAD_PPTID")
	private Dependencia unidad;

	//bi-directional many-to-one association to Informe
	@ManyToOne
	@JoinColumn(name="INFORME")
	private Informe informe;

	public Notificacion() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getFechaPlazo() {
		return fechaPlazo;
	}

	public void setFechaPlazo(Date fechaPlazo) {
		this.fechaPlazo = fechaPlazo;
	}

	public Date getFechaRecepcion() {
		return fechaRecepcion;
	}

	public void setFechaRecepcion(Date fechaRecepcion) {
		this.fechaRecepcion = fechaRecepcion;
	}

	public Date getFechaVencimiento() {
		return fechaVencimiento;
	}

	public void setFechaVencimiento(Date fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}

	public Valor getTipoNotificacion() {
		return tipoNotificacion;
	}

	public void setTipoNotificacion(Valor tipoNotificacion) {
		this.tipoNotificacion = tipoNotificacion;
	}

	public Valor getEstado() {
		return estado;
	}

	public void setEstado(Valor estado) {
		this.estado = estado;
	}

	public Dependencia getUnidad() {
		return unidad;
	}

	public void setUnidad(Dependencia unidad) {
		this.unidad = unidad;
	}

	public Informe getInforme() {
		return informe;
	}

	public void setInforme(Informe informe) {
		this.informe = informe;
	}

	public String getCompleto(){
		DateFormat df=new SimpleDateFormat("dd/MM/yyyy");
		return (tipoNotificacion==null?"":tipoNotificacion.getNombre())+" "+
				(fechaRecepcion==null?"":df.format(fechaRecepcion));
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
		Notificacion other = (Notificacion) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}