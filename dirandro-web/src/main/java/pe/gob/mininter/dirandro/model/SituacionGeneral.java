package pe.gob.mininter.dirandro.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

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
 * The persistent class for the EXP_SITUACION_GENERAL database table.
 * 
 */
@Entity
@Table(name="EXP_SITUACION_GENERAL")
public class SituacionGeneral extends AuditoriaBean implements Validador, Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4473456073297589273L;

	@Id
	@SequenceGenerator(name="EXP_SITUACION_GENERAL_ID_GENERATOR", sequenceName="SEQ_", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="EXP_SITUACION_GENERAL_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=16)
	private Long id;

	private Timestamp fecha;

	@Column(name="ID_REGISTRO", precision=16)
	private BigDecimal idRegistro;

	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="TABLA")
	private Valor tabla;

	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="SITUACION")
	private Valor situacion;

	public SituacionGeneral() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Timestamp getFecha() {
		return fecha;
	}

	public void setFecha(Timestamp fecha) {
		this.fecha = fecha;
	}

	public BigDecimal getIdRegistro() {
		return idRegistro;
	}

	public void setIdRegistro(BigDecimal idRegistro) {
		this.idRegistro = idRegistro;
	}

	public Valor getTabla() {
		return tabla;
	}

	public void setTabla(Valor tabla) {
		this.tabla = tabla;
	}

	public Valor getSituacion() {
		return situacion;
	}

	public void setSituacion(Valor situacion) {
		this.situacion = situacion;
	}

	@Override
	public void validar() {
		// TODO Auto-generated method stub
		
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
		SituacionGeneral other = (SituacionGeneral) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}