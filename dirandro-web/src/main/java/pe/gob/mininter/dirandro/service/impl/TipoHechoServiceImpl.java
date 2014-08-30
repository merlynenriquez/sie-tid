package pe.gob.mininter.dirandro.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.gob.mininter.dirandro.dao.hibernate.TipoHechoHibernate;
import pe.gob.mininter.dirandro.model.TipoHecho;
import pe.gob.mininter.dirandro.service.TipoHechoService;
import pe.gob.mininter.dirandro.util.Busqueda;

@Service
public class TipoHechoServiceImpl extends BaseServiceImpl<TipoHecho, Long> implements TipoHechoService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2601419480887715709L;
	
	private TipoHechoHibernate tipoHechoHibernate;

	@Autowired
	public TipoHechoServiceImpl(TipoHechoHibernate tipoHechoHibernate) {
		super(tipoHechoHibernate);
		this.tipoHechoHibernate = tipoHechoHibernate;
	}

	@Override
	public List<TipoHecho> listarTipoHecho() {
		Busqueda filtro = Busqueda.forClass(TipoHecho.class);		
		return tipoHechoHibernate.buscar(filtro);
	}	

}
