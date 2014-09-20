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
 * The persistent class for the MNT_MODELO_MARCA database table.
 * 
 */
@Entity
@Table(name="MNT_MODELO_MARCA")
public class ModeloMarca extends AuditoriaBean implements Validador, Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 9127973250630000562L;

	@Id
	@SequenceGenerator(name="MNT_MODELO_MARCA_ID_GENERATOR", sequenceName="SEQ_MODELO_MARCA", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="MNT_MODELO_MARCA_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=16)
	private Long id;

	@Column(length=200)
	private String nombre;
	
	//bi-directional many-to-one association to ModeloMarca
	@ManyToOne
	@JoinColumn(name="PADRE")
	private ModeloMarca padre;

	public ModeloMarca() {
	}
	
	public ModeloMarca(Long id) {
		this.id = id;
	}
	
	public ModeloMarca(ModeloMarca padre) {
		this.padre = padre;
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

	public ModeloMarca getPadre() {
		return padre;
	}

	public void setPadre(ModeloMarca padre) {
		this.padre = padre;
	}

	@Override
	public void validar() {
		// TODO Auto-generated method stub
		/*if (tipoDocumento == null) {
			throw new ValidacionException(Constante.CODIGO_MENSAJE.VALIDAR_COMBOBOX, new Object[] { "Tipo de Documento" });
		}
		if (StringUtils.isBlank(nroDocumento)) {
			throw new ValidacionException(Constante.CODIGO_MENSAJE.VALIDAR_TEXTBOX, new Object[] { "Numero de Documento" });
		}
	*/
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
		ModeloMarca other = (ModeloMarca) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}