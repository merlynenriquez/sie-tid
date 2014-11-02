package pe.gob.mininter.dirandro.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import pe.gob.mininter.dirandro.exception.ValidacionException;
import pe.gob.mininter.dirandro.util.Constante;
import pe.gob.mininter.dirandro.util.Validador;
import pe.gob.mininter.dirandro.util.beanbase.AuditoriaBean;

/**
 * The persistent class for the EXP_NOTA_INFORMATIVA database table.
 * 
 */
@Entity
@Table(name="EXP_NOTA_INFORMATIVA")
public class NotaInformativa  extends AuditoriaBean implements Validador, Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="EXP_NOTA_INFORMATIVA_ID_GENERATOR", sequenceName="SEQ_EXP_NOTA_INFORMATIVA")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="EXP_NOTA_INFORMATIVA_ID_GENERATOR")
	private Long id;

	private String contenido;

	@Column(name="FECHA_REGISTRO")
	private Date fechaRegistro;

	private String numero;

	@ManyToOne
	@JoinColumn(name="PARTE")
	private Expediente parte;

	public NotaInformativa() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getContenido() {
		return this.contenido;
	}

	public void setContenido(String contenido) {
		this.contenido = contenido;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public String getNumero() {
		return this.numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Expediente getParte() {
		return parte;
	}

	public void setParte(Expediente parte) {
		this.parte = parte;
	}

	@Override
	public void validar() {
		
		if( this.parte == null)
		{
			throw new ValidacionException(Constante.CODIGO_MENSAJE.VALIDAR_COMBOBOX, new Object[]{"Parte Policial"});
		}
		
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
		NotaInformativa other = (NotaInformativa) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}