package pe.gob.mininter.dirandro.model;

import java.io.ByteArrayOutputStream;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import pe.gob.mininter.dirandro.exception.ValidacionException;
import pe.gob.mininter.dirandro.util.Constante;
import pe.gob.mininter.dirandro.util.Validador;
import pe.gob.mininter.dirandro.util.beanbase.AuditoriaBean;


/**
 * The persistent class for the EXP_ADJUNTO database table.
 * 
 */
@Entity
@Table(name="EXP_OFICIO_SOLICITADO_ADJUNTO")
public class OficioSolicitadoAdjunto extends AuditoriaBean implements Validador, Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="EXP_OFICIO_SOLICITADO_ADJUNTO_ID_GENERATOR", sequenceName="SEQ_OFICIO_SOLICITADO_ADJUNTO", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="EXP_OFICIO_SOLICITADO_ADJUNTO_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=16)
	private Long id;

	@ManyToOne
	@JoinColumn(name="OFICIO_SOLICITADO")
	private OficioSolicitado oficioSolicitado;

	@ManyToOne
	@JoinColumn(name="ADJUNTO")
	private Adjunto adjunto;

	@ManyToOne
	@JoinColumn(name="TIPO")
	private Valor tipo;

	public OficioSolicitadoAdjunto() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public OficioSolicitado getOficioSolicitado() {
		return oficioSolicitado;
	}

	public void setOficioSolicitado(OficioSolicitado oficioSolicitado) {
		this.oficioSolicitado = oficioSolicitado;
	}

	public Adjunto getAdjunto() {
		return adjunto;
	}

	public void setAdjunto(Adjunto adjunto) {
		this.adjunto = adjunto;
	}

	public Valor getTipo() {
		return tipo;
	}

	public void setTipo(Valor tipo) {
		this.tipo = tipo;
	}

	@Override
	public void validar() {
	/*	if( this.getTipo() == null)
		{
			throw new ValidacionException(Constante.CODIGO_MENSAJE.VALIDAR_COMBOBOX, new Object[]{"Tipo de adjunto"});
		}
		if( this.getOutputStream() == null)
		{
			throw new ValidacionException(Constante.CODIGO_MENSAJE.VALIDAR_COMBOBOX, new Object[]{"Adjunto"});
		}*/
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
		OficioSolicitadoAdjunto other = (OficioSolicitadoAdjunto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}