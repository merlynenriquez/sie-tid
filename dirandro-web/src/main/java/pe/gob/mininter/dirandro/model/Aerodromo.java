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
 * The persistent class for the INT_AERODROMO database table.
 * 
 */
@Entity
@Table(name="INT_AERODROMO")
public class Aerodromo extends AuditoriaBean implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="INT_AERODROMO_ID_GENERATOR", sequenceName="SEQ_INT_AERODROMO")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="INT_AERODROMO_ID_GENERATOR")
	private Long id;

	private String nombre;

	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="AERONAVE_MAXIMA")
	private Valor aeronaveMaxima;

	//bi-directional many-to-one association to Empresa
	@ManyToOne
	@JoinColumn(name="EMPRESA")
	private Empresa empresa;

	//bi-directional many-to-one association to Distrito
	@ManyToOne
	@JoinColumn(name="UBICACION")
	private Distrito ubicacion;

	public Aerodromo() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Valor getAeronaveMaxima() {
		return aeronaveMaxima;
	}

	public void setAeronaveMaxima(Valor aeronaveMaxima) {
		this.aeronaveMaxima = aeronaveMaxima;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public Distrito getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(Distrito ubicacion) {
		this.ubicacion = ubicacion;
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
		Aerodromo other = (Aerodromo) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}