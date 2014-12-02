package pe.gob.mininter.dirandro.model;

import java.io.Serializable;
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

import pe.gob.mininter.dirandro.util.beanbase.AuditoriaBean;


/**
 * The persistent class for the AGE_NOTA_AGENTE database table.
 * 
 */
@Entity
@Table(name="AGE_NOTA_AGENTE")
public class NotaAgente extends AuditoriaBean implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="AGE_NOTA_AGENTE_ID_GENERATOR", sequenceName="SEQ_AGE_NOTA_AGENTE", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="AGE_NOTA_AGENTE_ID_GENERATOR")
	private Long id;

	private String contenido;

	@Column(name="FECHA_NOTA")
	private Timestamp fechaNota;

	//bi-directional many-to-one association to Caso
	@ManyToOne
	@JoinColumn(name="CASO")
	private Caso caso;

	//bi-directional many-to-one association to Policia
	@ManyToOne
	@JoinColumn(name="AGENTE")
	private Policia agente;
	
	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="TIPO")
	private Valor tipoNota;
	
	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="ESTADO")
	private Valor estado;

	public NotaAgente() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getContenido() {
		return contenido;
	}

	public void setContenido(String contenido) {
		this.contenido = contenido;
	}

	public Timestamp getFechaNota() {
		return fechaNota;
	}

	public void setFechaNota(Timestamp fechaNota) {
		this.fechaNota = fechaNota;
	}

	public Caso getCaso() {
		return caso;
	}

	public void setCaso(Caso caso) {
		this.caso = caso;
	}

	public Policia getAgente() {
		return agente;
	}

	public void setAgente(Policia agente) {
		this.agente = agente;
	}

	public Valor getTipoNota() {
		return tipoNota;
	}

	public void setTipoNota(Valor tipoNota) {
		this.tipoNota = tipoNota;
	}

	public Valor getEstado() {
		return estado;
	}

	public void setEstado(Valor estado) {
		this.estado = estado;
	}

}