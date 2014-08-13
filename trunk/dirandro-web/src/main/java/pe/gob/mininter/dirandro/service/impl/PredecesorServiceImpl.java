package pe.gob.mininter.dirandro.service.impl;

import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.mininter.dirandro.dao.hibernate.PredecesorHibernate;
import pe.gob.mininter.dirandro.exception.ValidacionException;
import pe.gob.mininter.dirandro.model.Predecesor;
import pe.gob.mininter.dirandro.service.PredecesorService;
import pe.gob.mininter.dirandro.util.Busqueda;
import pe.gob.mininter.dirandro.util.Constante;

@Service
public class PredecesorServiceImpl  extends BaseServiceImpl<Predecesor, Long> implements PredecesorService{
	
	private static final long serialVersionUID = 2697106645391028183L;
	
	private PredecesorHibernate predecesorHibernate;
	
	@Autowired
	public PredecesorServiceImpl(PredecesorHibernate predecesorHibernate) {
		super(predecesorHibernate);
		this.predecesorHibernate = predecesorHibernate;
	}

	@Override
	public List<Predecesor> buscar(Predecesor predecesor) {		
		Busqueda filtro = Busqueda.forClass(Predecesor.class);		
		if (predecesor != null) {		
			if (predecesor.getDependencia()!= null) {
				if( predecesor.getDependencia().getId() != null ){
					filtro.createAlias("dependencia", "d");
					filtro.add(Restrictions.eq("d.id",predecesor.getDependencia().getId()));					
				}
			}			
			if (predecesor.getPredecedor() != null) {
				if( predecesor.getPredecedor().getId() != null ){
					filtro.createAlias("predecesor", "p");
					filtro.add(Restrictions.eq("p.id",predecesor.getPredecedor().getId()));					
				}								
			}
		}		
		return predecesorHibernate.buscar(filtro);
	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void crear(Predecesor object) {	
		object.validar();
		Busqueda filtro = Busqueda.forClass(Predecesor.class);
		filtro.createAlias("dependencia", "d");		
		filtro.createAlias("predecesor", "p");
		filtro.add(Restrictions.eq("d.id", object.getDependencia().getId()));
		filtro.add(Restrictions.eq("p.id", object.getPredecedor().getId()));
		if (predecesorHibernate.buscar(filtro).size()>0) {
			throw new ValidacionException(Constante.CODIGO_MENSAJE.VALIDAR_PREDECESOR_EXISTENTE, new Object[] { object.getPredecedor().getNombre() });
		}
		super.crear(object);
	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void actualizar(Predecesor object) {
		object.validar();
		Busqueda filtro = Busqueda.forClass(Predecesor.class);
		filtro.createAlias("dependencia", "d");		
		filtro.createAlias("predecesor", "p");
		filtro.add(Restrictions.eq("d.id", object.getDependencia().getId()));
		filtro.add(Restrictions.eq("p.id", object.getPredecedor().getId()));
		filtro.add(Restrictions.not(Restrictions.eq("id", object.getId())));
		if (predecesorHibernate.buscar(filtro).size()>0) {
			throw new ValidacionException(Constante.CODIGO_MENSAJE.VALIDAR_PREDECESOR_EXISTENTE, new Object[] { object.getPredecedor().getNombre() });
		}
		predecesorHibernate.actualizar(object);
	}
}