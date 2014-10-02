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

import org.apache.commons.lang.StringUtils;

import pe.gob.mininter.dirandro.exception.ValidacionException;
import pe.gob.mininter.dirandro.util.Constante;
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
	@SequenceGenerator(name="MNT_PAISES_ID_GENERATOR", sequenceName="SEQ_PAIS", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="MNT_PAISES_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=16)
	private Long id;

	@Column(nullable=false, length=400)
	private String nombre;
	
	@Column(length=400)
	private String nacionalidad;

	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="ESTADO")
	private Valor estado;
	
	//bi-directional many-to-one association to Pais
	@ManyToOne
	@JoinColumn(name="PADRE")
	private Pais padre;
 
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

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public Valor getEstado() {
		return estado;
	}

	public void setEstado(Valor estado) {
		this.estado = estado;
	}

	public Pais getPadre() {
		return padre;
	}

	public void setPadre(Pais padre) {
		this.padre = padre;
	}

	@Override
	public void validar() {
		if (StringUtils.isBlank(nombre)) {
			throw new ValidacionException(Constante.CODIGO_MENSAJE.VALIDAR_TEXTBOX, new Object[] { "Nombre" });
		}
		if (estado == null) {
			throw new ValidacionException(Constante.CODIGO_MENSAJE.VALIDAR_COMBOBOX, new Object[] { "Estado" });
		}
	
		
	}

}