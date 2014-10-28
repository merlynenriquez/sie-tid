package pe.gob.mininter.dirandro.service;

import java.util.List;

import pe.gob.mininter.dirandro.model.Documento;
import pe.gob.mininter.dirandro.model.Expediente;
import pe.gob.mininter.dirandro.model.Ruta;
import pe.gob.mininter.dirandro.model.Usuario;
import pe.gob.mininter.dirandro.util.FormBandejaTrabajo;

public interface ExpedienteService extends BaseService<Expediente,Long> {
	
	public void registrarExpediente(Expediente expediente, Documento documento, Ruta ruta);
	
	public List<Expediente> buscar(Expediente expediente);
	
	public void agregarDocumento(Expediente expediente, Documento documento);
	
	public List<Expediente> obtenerBandejaDeTrabajo(FormBandejaTrabajo form);
	
	public void actualizarAtestado(Expediente expediente, Usuario usuario);

}
