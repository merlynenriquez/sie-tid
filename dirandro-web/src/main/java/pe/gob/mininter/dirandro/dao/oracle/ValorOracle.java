package pe.gob.mininter.dirandro.dao.oracle;

import java.util.List;

import pe.gob.mininter.dirandro.model.Valor;

public interface ValorOracle extends BaseOracle {
	
	List<Valor> obtenerxVector(Long valor1);
	
}
