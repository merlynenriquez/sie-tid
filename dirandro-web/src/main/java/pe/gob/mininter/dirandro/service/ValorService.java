package pe.gob.mininter.dirandro.service;

import java.util.List;

import pe.gob.mininter.dirandro.model.Valor;

public interface ValorService extends BaseService<Valor, Long> {

	public List<Valor> buscar(Valor valor);
	
	public List<Valor> obtenerLista(String codigoLista);
	
	public Valor obtenerValor(String lista, String valor);
	
	public List<Valor> obtenerListaSalida(String codigoLista);
}
