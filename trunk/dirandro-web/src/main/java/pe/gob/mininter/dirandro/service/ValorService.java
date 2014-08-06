package pe.gob.mininter.dirandro.service;

import java.util.List;

import pe.gob.mininter.dirandro.model.Valor;

public interface ValorService extends BaseService<Valor, Long> {

	List<Valor> buscar(Valor valor);
	
	List<Valor> obtenerLista(String codigoLista);
	
	Valor obtenerValor(String lista, String valor);
	
	List<Valor> obtenerxVector(Long valor1);
	
	List<Valor> obtenerListaSalida(String codigoLista);
}
