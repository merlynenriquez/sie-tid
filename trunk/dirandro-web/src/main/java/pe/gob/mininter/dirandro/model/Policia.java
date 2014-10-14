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
 * The persistent class for the PER_POLICIA database table.
 * 
 */
@Entity
@Table(name="PER_POLICIA")
public class Policia extends AuditoriaBean implements Validador, Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5529054350503925440L;

	@Id
	@SequenceGenerator(name="PER_POLICIA_ID_GENERATOR", sequenceName="SEQ_POLICIA", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PER_POLICIA_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=16)
	private Long id;

	@Column(length=200)
	private String campo;

	@Column(length=24)
	private String cip;

	@Column(length=4000)
	private String unidad;

	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="CARGO")
	private Valor cargo;

	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="GRADO")
	private Valor grado;

	//bi-directional many-to-one association to Persona
	@ManyToOne
	@JoinColumn(name="PERSONA")
	private Persona persona;

	public Policia() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCampo() {
		return campo;
	}

	public void setCampo(String campo) {
		this.campo = campo;
	}

	public String getCip() {
		return cip;
	}

	public void setCip(String cip) {
		this.cip = cip;
	}

	public String getUnidad() {
		return unidad;
	}

	public void setUnidad(String unidad) {
		this.unidad = unidad;
	}

	public Valor getCargo() {
		return cargo;
	}

	public void setCargo(Valor cargo) {
		this.cargo = cargo;
	}

	public Valor getGrado() {
		return grado;
	}

	public void setGrado(Valor grado) {
		this.grado = grado;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona value) {
		this.persona = value;
	}
	
	@Override
	public void validar() {
		if (persona == null) {
			throw new ValidacionException(Constante.CODIGO_MENSAJE.VALIDAR_COMBOBOX, new Object[] { "Persona" });
		}
		if (StringUtils.isBlank(cip)) {
			throw new ValidacionException(Constante.CODIGO_MENSAJE.VALIDAR_TEXTBOX, new Object[] { "CIP" });
		}
		if (grado == null) {
			throw new ValidacionException(Constante.CODIGO_MENSAJE.VALIDAR_TEXTBOX, new Object[] { "Grado" });
		}
		if (unidad == null) {
			throw new ValidacionException(Constante.CODIGO_MENSAJE.VALIDAR_TEXTBOX, new Object[] { "Unidad" });
		}
		if (cargo == null) {
			throw new ValidacionException(Constante.CODIGO_MENSAJE.VALIDAR_TEXTBOX, new Object[] { "Cargo" });
		}
	}
	
	public String getNombreCompleto(){
		return this.persona.getNombreCompleto();
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
		Policia other = (Policia) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	
}