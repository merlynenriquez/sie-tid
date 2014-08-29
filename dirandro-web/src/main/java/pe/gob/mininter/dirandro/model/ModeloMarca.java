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

	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="TIPO")
	private Valor tipo;

	//bi-directional many-to-one association to ModeloMarca
	@ManyToOne
	@JoinColumn(name="PADRE")
	private ModeloMarca padre;

	public ModeloMarca() {
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

	public Valor getTipo() {
		return tipo;
	}

	public void setTipo(Valor tipo) {
		this.tipo = tipo;
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

}