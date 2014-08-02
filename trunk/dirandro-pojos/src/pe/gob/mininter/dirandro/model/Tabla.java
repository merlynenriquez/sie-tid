package pe.gob.mininter.dirandro.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the SEQ_TABLA database table.
 * 
 */
@Entity
@Table(name="SEQ_TABLA")
public class Tabla implements Serializable {
	private static final long serialVersionUID = 1L;

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

}