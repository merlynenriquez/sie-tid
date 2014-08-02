package pe.gob.mininter.dirandro.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the MNT_TIPO_ESPECIE database table.
 * 
 */
@Entity
@Table(name="MNT_TIPO_ESPECIE")
public class TipoEspecie implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="MNT_TIPO_ESPECIE_ID_GENERATOR", sequenceName="SEQ_")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="MNT_TIPO_ESPECIE_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=16)
	private long id;

	@Column(nullable=false)
	private Timestamp creacion;

	private Timestamp edicion;

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

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="CREADOR", nullable=false)
	private Usuario segUsuario1;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="EDITOR")
	private Usuario segUsuario2;

	public TipoEspecie() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Timestamp getCreacion() {
		return this.creacion;
	}

	public void setCreacion(Timestamp creacion) {
		this.creacion = creacion;
	}

	public Timestamp getEdicion() {
		return this.edicion;
	}

	public void setEdicion(Timestamp edicion) {
		this.edicion = edicion;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Especie> getExpEspecies() {
		return this.expEspecies;
	}

	public void setExpEspecies(List<Especie> expEspecies) {
		this.expEspecies = expEspecies;
	}

	public Especie addExpEspecy(Especie expEspecy) {
		getExpEspecies().add(expEspecy);
		expEspecy.setMntTipoEspecie(this);

		return expEspecy;
	}

	public Especie removeExpEspecy(Especie expEspecy) {
		getExpEspecies().remove(expEspecy);
		expEspecy.setMntTipoEspecie(null);

		return expEspecy;
	}

	public TipoEspecie getMntTipoEspecie() {
		return this.mntTipoEspecie;
	}

	public void setMntTipoEspecie(TipoEspecie mntTipoEspecie) {
		this.mntTipoEspecie = mntTipoEspecie;
	}

	public List<TipoEspecie> getMntTipoEspecies() {
		return this.mntTipoEspecies;
	}

	public void setMntTipoEspecies(List<TipoEspecie> mntTipoEspecies) {
		this.mntTipoEspecies = mntTipoEspecies;
	}

	public TipoEspecie addMntTipoEspecy(TipoEspecie mntTipoEspecy) {
		getMntTipoEspecies().add(mntTipoEspecy);
		mntTipoEspecy.setMntTipoEspecie(this);

		return mntTipoEspecy;
	}

	public TipoEspecie removeMntTipoEspecy(TipoEspecie mntTipoEspecy) {
		getMntTipoEspecies().remove(mntTipoEspecy);
		mntTipoEspecy.setMntTipoEspecie(null);

		return mntTipoEspecy;
	}

	public Usuario getSegUsuario1() {
		return this.segUsuario1;
	}

	public void setSegUsuario1(Usuario segUsuario1) {
		this.segUsuario1 = segUsuario1;
	}

	public Usuario getSegUsuario2() {
		return this.segUsuario2;
	}

	public void setSegUsuario2(Usuario segUsuario2) {
		this.segUsuario2 = segUsuario2;
	}

}