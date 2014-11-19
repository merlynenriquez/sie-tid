package pe.gob.mininter.dirandro.model;

import java.io.Serializable;

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
 * The persistent class for the INT_RUTA database table.
 * 
 */
@Entity
@Table(name="INT_RUTA")
public class RutaTid extends AuditoriaBean implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="INT_RUTA_ID_GENERATOR", sequenceName="SEQ_INT_RUTA")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="INT_RUTA_ID_GENERATOR")
	private Long id;
	
	private String descripcion;

	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="TIPO")
	private Valor tipo;

	//bi-directional many-to-one association to Distrito
	@ManyToOne
	@JoinColumn(name="DESTINO")
	private Distrito destino;

	//bi-directional many-to-one association to Distrito
	@ManyToOne
	@JoinColumn(name="ORIGEN")
	private Distrito origen;

	public RutaTid() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Valor getTipo() {
		return tipo;
	}

	public void setTipo(Valor tipo) {
		this.tipo = tipo;
	}

	public Distrito getDestino() {
		return destino;
	}

	public void setDestino(Distrito destino) {
		this.destino = destino;
	}

	public Distrito getOrigen() {
		return origen;
	}

	public void setOrigen(Distrito origen) {
		this.origen = origen;
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
		RutaTid other = (RutaTid) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}