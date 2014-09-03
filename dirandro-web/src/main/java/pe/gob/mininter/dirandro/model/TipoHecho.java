package pe.gob.mininter.dirandro.model;

import java.io.Serializable;
import java.math.BigDecimal;

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
 * The persistent class for the EXP_TIPO_HECHO database table.
 * 
 */
@Entity
@Table(name="EXP_TIPO_HECHO")
public class TipoHecho extends AuditoriaBean implements Validador, Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4187903309065345585L;

	@Id
	@SequenceGenerator(name="EXP_TIPO_HECHO_ID_GENERATOR", sequenceName="SEQ_TIPO_HECHO", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="EXP_TIPO_HECHO_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=16)
	private Long id;

	@Column(precision=16)
	private BigDecimal estado;

	@Column(nullable=false, length=400)
	private String nombre;

	@ManyToOne
	@JoinColumn(name="PADRE")
	private TipoHecho padre;
	
	public TipoHecho() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getEstado() {
		return estado;
	}

	public void setEstado(BigDecimal estado) {
		this.estado = estado;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public TipoHecho getPadre() {
		return padre;
	}

	public void setPadre(TipoHecho padre) {
		this.padre = padre;
	}

	@Override
	public void validar() {
		if (StringUtils.isBlank(nombre)) {
			throw new ValidacionException(Constante.CODIGO_MENSAJE.VALIDAR_TEXTBOX, new Object[] { "Nombre del Tipo de Hecho" });
		}
		if (estado == null) {
			throw new ValidacionException(Constante.CODIGO_MENSAJE.VALIDAR_COMBOBOX, new Object[] { "Estado del Tipo de Hecho" });
		}
	}

}