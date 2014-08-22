package pe.gob.mininter.dirandro.model;

import java.io.Serializable;
import java.math.BigDecimal;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import pe.gob.mininter.dirandro.util.Validador;
import pe.gob.mininter.dirandro.util.beanbase.AuditoriaBean;


/**
 * The persistent class for the EXP_ABOGADO_PERSONA database table.
 * 
 */
@Entity
@Table(name="EXP_ABOGADO_PERSONA")
public class AbogadoPersona extends AuditoriaBean implements Validador, Serializable {
	
	private static final long serialVersionUID = 6618362410494391936L;

	@Id
	@SequenceGenerator(name="EXP_ABOGADO_PERSONA_ID_GENERATOR", sequenceName="SEQ_", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="EXP_ABOGADO_PERSONA_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=16)
	private Long id;

	@Column(precision=16)
	private BigDecimal estado;

	@Temporal(TemporalType.DATE)
	@Column(name="FEC_INI_REPRESENTACION")
	private Date fecIniRepresentacion;

	//bi-directional many-to-one association to DetExpedientePersona
	@ManyToOne
	@JoinColumn(name="PERSONA", nullable=false)
	private DetExpedientePersona expDetExpedientePersona;

	//bi-directional many-to-one association to Letrado
	@ManyToOne
	@JoinColumn(name="ABOGADO")
	private Letrado perLetrado;

	public AbogadoPersona() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getEstado() {
		return this.estado;
	}

	public void setEstado(BigDecimal estado) {
		this.estado = estado;
	}

	public Date getFecIniRepresentacion() {
		return this.fecIniRepresentacion;
	}

	public void setFecIniRepresentacion(Date fecIniRepresentacion) {
		this.fecIniRepresentacion = fecIniRepresentacion;
	}

	public DetExpedientePersona getExpDetExpedientePersona() {
		return this.expDetExpedientePersona;
	}

	public void setExpDetExpedientePersona(DetExpedientePersona expDetExpedientePersona) {
		this.expDetExpedientePersona = expDetExpedientePersona;
	}

	public Letrado getPerLetrado() {
		return this.perLetrado;
	}

	public void setPerLetrado(Letrado perLetrado) {
		this.perLetrado = perLetrado;
	}

	@Override
	public void validar() {
		// TODO Auto-generated method stub
		
	}

}