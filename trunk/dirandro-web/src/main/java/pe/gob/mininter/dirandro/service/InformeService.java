package pe.gob.mininter.dirandro.service;

import java.util.List;
import java.util.Map;

import pe.gob.mininter.dirandro.model.Expediente;
import pe.gob.mininter.dirandro.model.Informe;

public interface InformeService  extends BaseService<Informe,Long>{
	
	public Map<String, List<Informe>> filtrarInforme(List<Informe> lstInforme);
	
	public List<Informe> buscar(Informe informe);
	
	public List<Informe> buscarBandeja(Map<String, Object> map);
	
	public void registrarInforme(Informe informe);
	
	public Informe obtenerPorExpediente(Expediente expediente);
}