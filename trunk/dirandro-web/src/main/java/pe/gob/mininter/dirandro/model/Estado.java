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
 * The persistent class for the EXP_ESTADO database table.
 * 
 */
@Entity
@Table(name="EXP_ESTADO")
public class Estado extends AuditoriaBean implements Validador, Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4210782498533438412L;

	@Id
	@SequenceGenerator(name="EXP_ESTADO_ID_GENERATOR", sequenceName="SEQ_ESTADO", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="EXP_ESTADO_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=16)
	private Long id;

	@Column(length=30)
	private String codigo;

	@Column(length=400)
	private String descripcion;

	@Column(nullable=false, length=100)
	private String nombre;

	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="ESTADO", nullable=false)
	private Valor estadoExpediente;

	public Estado() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Valor getEstadoExpediente() {
		return estadoExpediente;
	}

	public void setEstadoExpediente(Valor estadoExpediente) {
		this.estadoExpediente = estadoExpediente;
	}

	@Override
	public void validar() {
		// TODO Auto-generated method stub
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
		Estado other = (Estado) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}