package pe.gob.mininter.dirandro.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import pe.gob.mininter.dirandro.util.Validador;


/**
 * The persistent class for the SEQ_TABLA database table.
 * 
 */
@Entity
@Table(name="SEQ_TABLA")
public class Tabla  implements Validador, Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 243193776159587957L;

	@Id
	@SequenceGenerator(name="SEQ_TABLA_TABLA_GENERATOR", sequenceName="SEQ_")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_TABLA_TABLA_GENERATOR")
	@Column(unique=true, nullable=false, length=500)
	private String tabla;

	@Column(name="ULTIMO_ID", precision=16)
	private BigDecimal ultimoId;

	public Tabla() {
	}

	public String getTabla() {
		return this.tabla;
	}

	public void setTabla(String tabla) {
		this.tabla = tabla;
	}

	public BigDecimal getUltimoId() {
		return this.ultimoId;
	}

	public void setUltimoId(BigDecimal ultimoId) {
		this.ultimoId = ultimoId;
	}

	@Override
	public void validar() {
		// TODO Auto-generated method stub
		
	}

}