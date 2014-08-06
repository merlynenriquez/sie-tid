package pe.gob.mininter.dirandro.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import pe.gob.mininter.dirandro.util.Validador;
import pe.gob.mininter.dirandro.util.beanbase.AuditoriaBean;


/**
 * The persistent class for the MNT_TIPO_ESPECIE database table.
 * 
 */
@Entity
@Table(name="MNT_TIPO_ESPECIE")
public class TipoEspecie extends AuditoriaBean implements Validador, Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2491507680984090721L;

	@Id
	@SequenceGenerator(name="MNT_TIPO_ESPECIE_ID_GENERATOR", sequenceName="SEQ_")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="MNT_TIPO_ESPECIE_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=16)
	private Long id;

	@Column(length=400)
	private String nombre;

	//bi-directional many-to-one association to Especie
	@OneToMany(mappedBy="mntTipoEspecie")
	private List<Especie> expEspecies;

	//bi-directional many-to-one association to TipoEspecie
	@ManyToOne
	@JoinColumn(name="PADRE")
	private TipoEspecie mntTipoEspecie;

	//bi-directional many-to-one association to TipoEspecie
	@OneToMany(mappedBy="mntTipoEspecie")
	private List<TipoEspecie> mntTipoEspecies;

	public TipoEspecie() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Especie> getExpEspecies() {
		return expEspecies;
	}

	public void setExpEspecies(List<Especie> expEspecies) {
		this.expEspecies = expEspecies;
	}

	public TipoEspecie getMntTipoEspecie() {
		return mntTipoEspecie;
	}

	public void setMntTipoEspecie(TipoEspecie mntTipoEspecie) {
		this.mntTipoEspecie = mntTipoEspecie;
	}

	public List<TipoEspecie> getMntTipoEspecies() {
		return mntTipoEspecies;
	}

	public void setMntTipoEspecies(List<TipoEspecie> mntTipoEspecies) {
		this.mntTipoEspecies = mntTipoEspecies;
	}

	@Override
	public void validar() {
		// TODO Auto-generated method stub
		
	}

}