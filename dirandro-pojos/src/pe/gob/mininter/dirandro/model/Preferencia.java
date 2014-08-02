package pe.gob.mininter.dirandro.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the SEG_PREFERENCIA database table.
 * 
 */
@Entity
@Table(name="SEG_PREFERENCIA")
public class Preferencia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SEG_PREFERENCIA_ID_GENERATOR", sequenceName="SEQ_")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEG_PREFERENCIA_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=16)
	private long id;

	@Column(length=500)
	private String ancho;

	@Column(length=500)
	private String colapso;

	@Column(length=700)
	private String columna;

	@Column(nullable=false, length=100)
	private String tabla;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="USUARIO")
	private Usuario segUsuario;

	public Preferencia() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAncho() {
		return this.ancho;
	}

	public void setAncho(String ancho) {
		this.ancho = ancho;
	}

	public String getColapso() {
		return this.colapso;
	}

	public void setColapso(String colapso) {
		this.colapso = colapso;
	}

	public String getColumna() {
		return this.columna;
	}

	public void setColumna(String columna) {
		this.columna = columna;
	}

	public String getTabla() {
		return this.tabla;
	}

	public void setTabla(String tabla) {
		this.tabla = tabla;
	}

	public Usuario getSegUsuario() {
		return this.segUsuario;
	}

	public void setSegUsuario(Usuario segUsuario) {
		this.segUsuario = segUsuario;
	}

}