package pe.gob.mininter.dirandro.model;

import java.io.Serializable;

import javax.persistence.*;

import pe.gob.mininter.dirandro.util.Validador;
import pe.gob.mininter.dirandro.util.beanbase.AuditoriaBean;

import java.sql.Timestamp;
import java.math.BigDecimal;


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

}