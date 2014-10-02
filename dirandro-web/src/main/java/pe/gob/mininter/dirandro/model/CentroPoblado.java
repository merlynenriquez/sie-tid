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
 * The persistent class for the EXP_CENTRO_POBLADO database table.
 * 
 */
@Entity
@Table(name="EXP_CENTRO_POBLADO")
public class CentroPoblado extends AuditoriaBean implements Validador, Serializable {

	private static final long serialVersionUID = -510486200814174107L;

	@Id
	@SequenceGenerator(name="EXP_CENTRO_POBLADO_ID_GENERATOR", sequenceName="SEQ_CENTRO_POBLADO", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="EXP_CENTRO_POBLADO_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=16)
	private Long id;

	@Column(nullable=false, length=400)
	private String nombre;

	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="CATEGORIA")
	private Valor categoria;
	
	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="ESTADO")
	private Valor estado;

	//bi-directional many-to-one association to Distrito
	@ManyToOne
	@JoinColumn(name="DISTRITO")
	private Distrito distrito;

	public CentroPoblado() {
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

	public Valor getCategoria() {
		return categoria;
	}

	public void setCategoria(Valor categoria) {
		this.categoria = categoria;
	}

	public Valor getEstado() {
		return estado;
	}

	public void setEstado(Valor estado) {
		this.estado = estado;
	}

	public Distrito getDistrito() {
		return distrito;
	}

	public void setDistrito(Distrito distrito) {
		this.distrito = distrito;
	}

	@Override
	public void validar() {
		if(StringUtils.isBlank(nombre)){
			throw new ValidacionException(Constante.CODIGO_MENSAJE.VALIDAR_TEXTBOX, new Object[]{"Nombre del Centro Poblado"});
		}
		if(categoria == null){
			throw new ValidacionException(Constante.CODIGO_MENSAJE.VALIDAR_COMBOBOX, new Object[]{"Categoría"});
		}
		if(estado == null){
			throw new ValidacionException(Constante.CODIGO_MENSAJE.VALIDAR_COMBOBOX, new Object[]{"Estado"});
		}
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
		CentroPoblado other = (CentroPoblado) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}