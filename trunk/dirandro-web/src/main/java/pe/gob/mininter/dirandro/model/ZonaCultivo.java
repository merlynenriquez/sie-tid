package pe.gob.mininter.dirandro.model;

import java.io.Serializable;
import java.math.BigDecimal;

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
 * The persistent class for the INT_ZONA_CULTIVO database table.
 * 
 */
@Entity
@Table(name="INT_ZONA_CULTIVO")
public class ZonaCultivo extends AuditoriaBean implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="INT_ZONA_CULTIVO_ID_GENERATOR", sequenceName="SEQ_INT_ZONA_CULTIVO", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="INT_ZONA_CULTIVO_ID_GENERATOR")
	private Long id;

	private BigDecimal hectareas;

	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="TIPO_CULTIVO")
	private Valor tipoCultivo;

	//bi-directional many-to-one association to Distrito
	@ManyToOne
	@JoinColumn(name="UBICACION")
	private Distrito distrito;

	public ZonaCultivo() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getHectareas() {
		return hectareas;
	}

	public void setHectareas(BigDecimal hectareas) {
		this.hectareas = hectareas;
	}

	public Valor getTipoCultivo() {
		return tipoCultivo;
	}

	public void setTipoCultivo(Valor tipoCultivo) {
		this.tipoCultivo = tipoCultivo;
	}

	public Distrito getDistrito() {
		return distrito;
	}

	public void setDistrito(Distrito distrito) {
		this.distrito = distrito;
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
		ZonaCultivo other = (ZonaCultivo) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}