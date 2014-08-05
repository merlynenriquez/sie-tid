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
 * The persistent class for the MNT_PAISES database table.
 * 
 */
@Entity
@Table(name="MNT_PAISES")
public class Pais extends AuditoriaBean implements Validador, Serializable {
	
	private static final long serialVersionUID = 7231450892175975279L;

	@Id
	@SequenceGenerator(name="MNT_PAISES_ID_GENERATOR", sequenceName="SEQ_")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="MNT_PAISES_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=16)
	private Long id;

	@Column(nullable=false, length=200)
	private String nombre;

	//bi-directional many-to-one association to Droga
	@OneToMany(mappedBy="mntPais1")
	private List<Droga> expDrogas1;

	//bi-directional many-to-one association to Droga
	@OneToMany(mappedBy="mntPais2")
	private List<Droga> expDrogas2;

	//bi-directional many-to-one association to Pais
	@ManyToOne
	@JoinColumn(name="PADRE")
	private Pais mntPais;

	//bi-directional many-to-one association to Pais
	@OneToMany(mappedBy="mntPais")
	private List<Pais> mntPaises;

	public Pais() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Droga> getExpDrogas1() {
		return this.expDrogas1;
	}

	public void setExpDrogas1(List<Droga> expDrogas1) {
		this.expDrogas1 = expDrogas1;
	}

	public Droga addExpDrogas1(Droga expDrogas1) {
		getExpDrogas1().add(expDrogas1);
		expDrogas1.setMntPais1(this);

		return expDrogas1;
	}

	public Droga removeExpDrogas1(Droga expDrogas1) {
		getExpDrogas1().remove(expDrogas1);
		expDrogas1.setMntPais1(null);

		return expDrogas1;
	}

	public List<Droga> getExpDrogas2() {
		return this.expDrogas2;
	}

	public void setExpDrogas2(List<Droga> expDrogas2) {
		this.expDrogas2 = expDrogas2;
	}

	public Droga addExpDrogas2(Droga expDrogas2) {
		getExpDrogas2().add(expDrogas2);
		expDrogas2.setMntPais2(this);

		return expDrogas2;
	}

	public Droga removeExpDrogas2(Droga expDrogas2) {
		getExpDrogas2().remove(expDrogas2);
		expDrogas2.setMntPais2(null);

		return expDrogas2;
	}

	public Pais getMntPais() {
		return this.mntPais;
	}

	public void setMntPais(Pais mntPais) {
		this.mntPais = mntPais;
	}

	public List<Pais> getMntPaises() {
		return this.mntPaises;
	}

	public void setMntPaises(List<Pais> mntPaises) {
		this.mntPaises = mntPaises;
	}

	public Pais addMntPais(Pais mntPais) {
		getMntPaises().add(mntPais);
		mntPais.setMntPais(this);

		return mntPais;
	}

	public Pais removeMntPais(Pais mntPais) {
		getMntPaises().remove(mntPais);
		mntPais.setMntPais(null);

		return mntPais;
	}

	@Override
	public void validar() {
		// TODO Auto-generated method stub
		
	}

}