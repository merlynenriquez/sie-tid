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
 * The persistent class for the EXP_ANEXO database table.
 * 
 */
@Entity
@Table(name="EXP_ANEXO")
public class Anexo extends AuditoriaBean implements Validador, Serializable {
	
	private static final long serialVersionUID = 6445376440998958328L;

	@Id
	@SequenceGenerator(name="EXP_ANEXO_ID_GENERATOR", sequenceName="SEQ_")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="EXP_ANEXO_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=16)
	private Long id;

	//bi-directional many-to-one association to Adjunto
	@ManyToOne
	@JoinColumn(name="ADJUNTO")
	private Adjunto expAdjunto;

	//bi-directional many-to-one association to Documento
	@ManyToOne
	@JoinColumn(name="DOCUMENTO")
	private Documento expDocumento;

	public Anexo() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Adjunto getExpAdjunto() {
		return this.expAdjunto;
	}

	public void setExpAdjunto(Adjunto expAdjunto) {
		this.expAdjunto = expAdjunto;
	}

	public Documento getExpDocumento() {
		return this.expDocumento;
	}

	public void setExpDocumento(Documento expDocumento) {
		this.expDocumento = expDocumento;
	}

	@Override
	public void validar() {
		// TODO Auto-generated method stub
		
	}

}