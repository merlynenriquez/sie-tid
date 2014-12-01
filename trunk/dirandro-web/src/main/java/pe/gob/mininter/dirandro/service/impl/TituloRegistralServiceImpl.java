package pe.gob.mininter.dirandro.service.impl;

import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.gob.mininter.dirandro.dao.hibernate.TituloRegistralHibernate;
import pe.gob.mininter.dirandro.model.TituloRegistral;
import pe.gob.mininter.dirandro.service.TituloRegistralService;
import pe.gob.mininter.dirandro.util.Busqueda;

@Service
@SuppressWarnings("serial")
public class TituloRegistralServiceImpl extends BaseServiceImpl<TituloRegistral, Long> implements TituloRegistralService {
	
	private TituloRegistralHibernate tituloRegistralHibernate;
	
	@Autowired
	public TituloRegistralServiceImpl(TituloRegistralHibernate tituloRegistralHibernate) {
		super(tituloRegistralHibernate);
		this.tituloRegistralHibernate = tituloRegistralHibernate;
	}

	@Override
	public List<TituloRegistral> buscar(TituloRegistral tituloRegistral) {
		Busqueda filtro = Busqueda.forClass(TituloRegistral.class);
		
		if(tituloRegistral!=null){
			if(tituloRegistral.getInforme()!=null){
				filtro.createAlias("informe", "i");
				filtro.add(Restrictions.eq("i.id", tituloRegistral.getInforme().getId()));
			}
		}
		
		return tituloRegistralHibernate.buscar(filtro);
	}
	
}
