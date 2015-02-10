package pe.gob.mininter.dirandro.service;

import java.util.List;
import java.util.Map;

import pe.gob.mininter.dirandro.model.NotaInformativa;

public interface NotaInformativaService extends BaseService<NotaInformativa,Long> {

	public List<NotaInformativa> buscar(NotaInformativa objeto);
	public List<NotaInformativa> buscarBandeja(Map<String, Object> map);
	public void registrarNotaInformativa(NotaInformativa objeto);
}
