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

import org.apache.commons.lang.StringUtils;

import pe.gob.mininter.dirandro.exception.ValidacionException;
import pe.gob.mininter.dirandro.util.Constante;
import pe.gob.mininter.dirandro.util.Validador;
import pe.gob.mininter.dirandro.util.beanbase.AuditoriaBean;


/**
 * The persistent class for the EXP_VEHICULO database table.
 * 
 */
@Entity
@Table(name="EXP_VEHICULO")
public class Vehiculo extends AuditoriaBean implements Validador, Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8452393232453894146L;

	@Id
	@SequenceGenerator(name="EXP_VEHICULO_ID_GENERATOR", sequenceName="SEQ_VEHICULO", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="EXP_VEHICULO_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=16)
	private Long id;

	@Column(name="MODELO_ESPECIFICO", length=500)
	private String modeloEspecifico;

	@Column(length=200)
	private String placa;

	@Column(name="SERIE_CHASIS", length=100)
	private String serieChasis;

	@Column(name="SERIE_MOTOR", length=100)
	private String serieMotor;

	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="CILINDROS", nullable=false)
	private Valor cilindros;

	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="TIPO_TAMANO")
	private Valor tipoTamano;

	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="PERIODO_FABRICACION")
	private Valor periodoFabricacion;

	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="TRANSMISION")
	private Valor transmision;

	//bi-directional many-to-one association to Valor
	@ManyToOne
	@JoinColumn(name="COLOR")
	private Valor color;

	//bi-directional many-to-one association to ModeloMarca
	@ManyToOne
	@JoinColumn(name="MODELO")
	private ModeloMarca modeloMarca;

	public Vehiculo() {
	}

	public Vehiculo(Long id) {
		this.id=id;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getModeloEspecifico() {
		return modeloEspecifico;
	}

	public void setModeloEspecifico(String modeloEspecifico) {
		this.modeloEspecifico = modeloEspecifico;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getSerieChasis() {
		return serieChasis;
	}

	public void setSerieChasis(String serieChasis) {
		this.serieChasis = serieChasis;
	}

	public String getSerieMotor() {
		return serieMotor;
	}

	public void setSerieMotor(String serieMotor) {
		this.serieMotor = serieMotor;
	}

	public Valor getCilindros() {
		return cilindros;
	}

	public void setCilindros(Valor cilindros) {
		this.cilindros = cilindros;
	}

	public Valor getTipoTamano() {
		return tipoTamano;
	}

	public void setTipoTamano(Valor tipoTamano) {
		this.tipoTamano = tipoTamano;
	}

	public Valor getTransmision() {
		return transmision;
	}

	public void setTransmision(Valor transmision) {
		this.transmision = transmision;
	}

	public Valor getColor() {
		return color;
	}

	public void setColor(Valor color) {
		this.color = color;
	}

	public Valor getPeriodoFabricacion() {
		return periodoFabricacion;
	}

	public void setPeriodoFabricacion(Valor periodoFabricacion) {
		this.periodoFabricacion = periodoFabricacion;
	}

	public ModeloMarca getModeloMarca() {
		return modeloMarca;
	}

	public void setModeloMarca(ModeloMarca modeloMarca) {
		this.modeloMarca = modeloMarca;
	}

	@Override
	public void validar() {
		if (tipoTamano == null) {
			throw new ValidacionException(Constante.CODIGO_MENSAJE.VALIDAR_COMBOBOX, new Object[] { "Tipo de Tamaño" });
		}
		if (transmision== null) {
			throw new ValidacionException(Constante.CODIGO_MENSAJE.VALIDAR_COMBOBOX, new Object[] { "Transmisión" });
		}
		if (cilindros== null) {
			throw new ValidacionException(Constante.CODIGO_MENSAJE.VALIDAR_COMBOBOX, new Object[] { "Número de Cilindros" });
		}
		if (StringUtils.isBlank(placa)) {
			throw new ValidacionException(Constante.CODIGO_MENSAJE.VALIDAR_TEXTBOX, new Object[] { "Número de la placa" });
		}
		if (modeloMarca== null) {
			throw new ValidacionException(Constante.CODIGO_MENSAJE.VALIDAR_COMBOBOX, new Object[] { "Marca" });
		}
	}

	public boolean esNuevo(){
		return id == null || id.longValue() == 0;
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
		Vehiculo other = (Vehiculo) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}