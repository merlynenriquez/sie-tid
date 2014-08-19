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
 * The persistent class for the MNT_PAISES database table.
 * 
 */
@Entity
@Table(name="MNT_PAISES")
public class Pais extends AuditoriaBean implements Validador, Serializable {
	
	private static final long serialVersionUID = 7231450892175975279L;

	@Id
	@SequenceGenerator(name="MNT_PAISES_ID_GENERATOR", sequenceName="SEQ_")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="MNT_PAISES_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=16)
	private Long id;

	@Column(nullable=false, length=200)
	private String nombre;

	private Integer estado;
	
	//bi-directional many-to-one association to Pais
	@ManyToOne
	@JoinColumn(name="PADRE")
	private Pais mntPais;
 

	public Pais() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
   
	public Pais getMntPais() {
		return this.mntPais;
	}

	public void setMntPais(Pais mntPais) {
		this.mntPais = mntPais;
	}
	 
	public Integer getEstado() {
		return estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}

	@Override
	public void validar() {
		// TODO Auto-generated method stub
		
	}

}