package pe.gob.mininter.dirandro.util.beanbase;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import pe.gob.mininter.dirandro.model.Usuario;

@MappedSuperclass
public class AuditoriaBean extends BeanBase {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9163371034756898686L;
	
	@ManyToOne
	@JoinColumn(name="CREADOR", nullable=false, insertable = true, updatable = false)
	private Usuario creador;
	
	@Column(name = "CREACION", nullable = false, insertable = true, updatable = false)
	@Temporal( TemporalType.TIMESTAMP)
	private Date creacion;
	
	@ManyToOne
	@JoinColumn(name = "EDITOR", insertable = false, updatable = true)
	private Usuario editor;
	
	@Column(name = "EDICION", insertable = false, updatable = true)
	@Temporal( TemporalType.TIMESTAMP)
	private Date edicion;
	
	protected void copy(final AuditoriaBean source)
    {
        this.creador = source.creador;
        this.creacion = source.creacion;
        this.editor = source.editor;
        this.edicion = source.edicion;
    }
 
    protected static boolean getBooleanValue(final Boolean value)
    {
        return Boolean.valueOf(String.valueOf(value));
    }

	public Usuario getCreador() {
		return creador;
	}

	public void setCreador(Usuario creador) {
		this.creador = creador;
	}

	public Date getCreacion() {
		return creacion;
	}

	public void setCreacion(Date creacion) {
		this.creacion = creacion;
	}

	public Usuario getEditor() {
		return editor;
	}

	public void setEditor(Usuario editor) {
		this.editor = editor;
	}

	public Date getEdicion() {
		return edicion;
	}

	public void setEdicion(Date edicion) {
		this.edicion = edicion;
	}
	
	public boolean esNuevo()
	{
		return creador == null && creacion == null;
	}

}
