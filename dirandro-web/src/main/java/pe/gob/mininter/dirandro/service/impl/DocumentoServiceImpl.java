package pe.gob.mininter.dirandro.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.gob.mininter.dirandro.dao.hibernate.DocumentoHibernate;
import pe.gob.mininter.dirandro.model.Documento;
import pe.gob.mininter.dirandro.service.DocumentoService;

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

}
