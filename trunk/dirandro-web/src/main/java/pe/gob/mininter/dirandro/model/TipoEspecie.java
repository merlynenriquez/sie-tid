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
 * The persistent class for the MNT_TIPO_ESPECIE database table.
 * 
 */
@Entity
@Table(name="MNT_TIPO_ESPECIE")
public class TipoEspecie extends AuditoriaBean implements Validador, Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2491507680984090721L;

	@Id
	@SequenceGenerator(name="MNT_TIPO_ESPECIE_ID_GENERATOR", sequenceName="SEQ_TIPO_ESPECIE", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="MNT_TIPO_ESPECIE_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=16)
	private Long id;

	@Column(length=400)
	private String nombre;

	//bi-directional many-to-one association to TipoEspecie
	@ManyToOne
	@JoinColumn(name="PADRE")
	private TipoEspecie padre;

	public TipoEspecie() {
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
	public TipoEspecie getPadre() {
		return padre;
	}
	public void setPadre(TipoEspecie padre) {
		this.padre = padre;
	}

	@Override
	public void validar() {
		// TODO Auto-generated method stub
		
	}

}