package pe.gob.mininter.dirandro.service.impl;

import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.gob.mininter.dirandro.dao.hibernate.DocumentoHibernate;
import pe.gob.mininter.dirandro.model.Documento;
import pe.gob.mininter.dirandro.model.Expediente;
import pe.gob.mininter.dirandro.service.DocumentoService;
import pe.gob.mininter.dirandro.util.Busqueda;

@Service
public class DocumentoServiceImpl extends BaseServiceImpl<Documento, Long> implements DocumentoService {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2205985056144010761L;
	
	private DocumentoHibernate documentoHibernate;

	@Autowired
	public DocumentoServiceImpl(DocumentoHibernate documentoHibernate) {
		super(documentoHibernate);
		this.documentoHibernate = documentoHibernate;
	}

	@Override
	public List<Documento> obtenerDocumentosDelExpediente(Expediente expediente) {
		Busqueda filtro = Busqueda.forClass(Documento.class);
		filtro.createAlias("expediente", "e");
		filtro.add(Restrictions.eq("e.id", expediente.getId()));
		return documentoHibernate.buscar(filtro);
	}

	@Override
	public List<Documento> buscar(Documento documento) {
		Busqueda filtro = Busqueda.forClass(Documento.class);
		if(documento!=null){
			addILikeRestrictions(filtro, "expediente", "ex", "autogenerado", documento.getExpediente().getAutogenerado());
			addILikeRestrictions(filtro, "tablaOrigen", "to", "nombre", documento.getTablaOrigen().getNombre());
			filtro.add(Restrictions.eq("origen", documento.getCodigoOrigen()));
			addILikeRestrictions(filtro, "tipoDocumento", "td", "nombre", documento.getTipoDocumento().getNombre());
			addILikeRestrictions(filtro, "nroDocumento", documento.getNroDocumento());
			addILikeRestrictions(filtro, "asunto", documento.getAsunto());
			filtro.add(Restrictions.eq("diasAtencion", documento.getDiasAtencion()));
			filtro.add(Restrictions.eq("folios", documento.getFolios()));
			addILikeRestrictions(filtro, "adjunto", "a", "nombre", documento.getAdjunto().getNombre());
			addILikeRestrictions(filtro, "prioridad", "p", "nombre", documento.getPrioridad().getNombre());
		}
		return documentoHibernate.buscar(filtro);
	}

}
