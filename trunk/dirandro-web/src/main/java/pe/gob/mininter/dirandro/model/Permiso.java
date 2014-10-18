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

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import pe.gob.mininter.dirandro.util.Validador;
import pe.gob.mininter.dirandro.util.beanbase.AuditoriaBean;


/**
 * The persistent class for the SEG_PERMISO database table.
 * 
 */
@Entity
@Table(name="SEG_PERMISO")
public class Permiso extends AuditoriaBean implements Validador, Serializable {
	
	private static final long serialVersionUID = -4708245203204061256L;

	@Id
	@SequenceGenerator(name="SEG_PERMISO_ID_GENERATOR", sequenceName="SEQ_PERMISO", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEG_PERMISO_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=16)
	private Long id;

	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="ESTADO", nullable=false)
	private Valor estado;

	//bi-directional many-to-one association to Opcion
	@ManyToOne
	@JoinColumn(name="OPCION", nullable=false)
	private Opcion opcion;

	//bi-directional many-to-one association to Rol
	@ManyToOne
	@JoinColumn(name="ROL", nullable=false)
	private Rol rol;

	public Permiso() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	} 
	
	public Opcion getOpcion() {
		return opcion;
	}

	public void setOpcion(Opcion opcion) {
		this.opcion = opcion;
	}

	
	public Valor getEstado() {
		return estado;
	}

	public void setEstado(Valor estado) {
		this.estado = estado;
	}

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	@Override
	public void validar() {
		// TODO Auto-generated method stub
		
	}

	@Override
    public int hashCode() {
            HashCodeBuilder hashCodeBuilder = new HashCodeBuilder(5, 31);
            if(rol != null && opcion != null)
            {
                    hashCodeBuilder.append(rol.getCodigo());
                    hashCodeBuilder.append(opcion.getCodigo());
            }
            else
            {
                    hashCodeBuilder.append(getId());
            }
            return hashCodeBuilder.toHashCode();
    }

    @Override
    public boolean equals(Object obj) {
            if(obj == null)
            {
                    return false;
            }
            if (obj instanceof Permiso) {
                    Permiso bean = (Permiso) obj;
                    EqualsBuilder equalsBuilder = new EqualsBuilder();
                    if(rol != null && opcion != null && bean.rol != null && bean.opcion != null)
                    {
                            equalsBuilder.append(rol.getId(), bean.rol.getId());
                            equalsBuilder.append(opcion.getId(), bean.opcion.getId());
                    }
                    else
                    {
                            equalsBuilder.append(getId(), bean.getId());
                    }
                    return equalsBuilder.isEquals();
                    
            }
            return false;
    }
	
}