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

import pe.gob.mininter.dirandro.util.beanbase.AuditoriaBean;


/**
 * The persistent class for the INT_DET_INT_RUTA database table.
 * 
 */
@Entity
@Table(name="INT_DET_INT_RUTA")
public class DetIntRuta extends AuditoriaBean implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="INT_DET_INT_RUTA_ID_GENERATOR", sequenceName="SEQ_INT_DET_INT_RUTA", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="INT_DET_INT_RUTA_ID_GENERATOR")
	private Long id;

	@Column(name="DESCRIPCION_DESTINO")
	private String descripcionDestino;

	@Column(name="DESCRIPCION_ORIGEN")
	private String descripcionOrigen;

	//bi-directional many-to-one association to Inteligencia
	@ManyToOne
	@JoinColumn(name="INTELIGENCIA")
	private Inteligencia inteligencia;

	//bi-directional many-to-one association to RutaTid
	@ManyToOne
	@JoinColumn(name="RUTA")
	private RutaTid ruta;

	public DetIntRuta() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescripcionDestino() {
		return descripcionDestino;
	}

	public void setDescripcionDestino(String descripcionDestino) {
		this.descripcionDestino = descripcionDestino;
	}

	public String getDescripcionOrigen() {
		return descripcionOrigen;
	}

	public void setDescripcionOrigen(String descripcionOrigen) {
		this.descripcionOrigen = descripcionOrigen;
	}

	public Inteligencia getInteligencia() {
		return inteligencia;
	}

	public void setInteligencia(Inteligencia inteligencia) {
		this.inteligencia = inteligencia;
	}

	public RutaTid getRuta() {
		return ruta;
	}

	public void setRuta(RutaTid ruta) {
		this.ruta = ruta;
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
		DetIntRuta other = (DetIntRuta) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}