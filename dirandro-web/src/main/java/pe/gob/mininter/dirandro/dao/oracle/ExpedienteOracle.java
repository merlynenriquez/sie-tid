package pe.gob.mininter.dirandro.dao.oracle;

import pe.gob.mininter.dirandro.model.Dependencia;

public interface ExpedienteOracle extends BaseOracle  {
	
	public Integer obtenerAutogenerado(Dependencia dependencia);
	
}
