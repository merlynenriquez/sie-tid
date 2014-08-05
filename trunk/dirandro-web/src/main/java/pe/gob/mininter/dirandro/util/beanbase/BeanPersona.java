package pe.gob.mininter.dirandro.util.beanbase;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class BeanPersona extends AuditoriaBean {

	private static final long serialVersionUID = -5169208296310566760L;
	
	@Column(nullable=false, length=200)
	protected String nombres;
	public String getNombres() { return nombres; }
	public void setNombres(String nombres) { this.nombres = nombres; }
	
	@Column(name="PATERNO", length=150)
	protected String paterno;
	public String getPaterno() { return paterno; }
	public void setPaterno(String paterno) { this.paterno = paterno; }

	@Column(name="MATERNO", length=150)
	protected String materno;
	public String getMaterno() { return materno; }
	public void setMaterno(String materno) { this.materno = materno; }

}