package pe.gob.mininter.dirandro.service.impl;

import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.gob.mininter.dirandro.dao.hibernate.ExplosivoHibernate;
import pe.gob.mininter.dirandro.model.Explosivo;
import pe.gob.mininter.dirandro.service.ExplosivoService;
import pe.gob.mininter.dirandro.util.Busqueda;

@Service
public class ExplosivoServiceImpl extends BaseServiceImpl<Explosivo, Long> implements ExplosivoService{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2697106645391028183L;
	
	private ExplosivoHibernate explosivoHibernate;
	
	@Autowired
	public ExplosivoServiceImpl(ExplosivoHibernate explosivoHibernate) {
		super(explosivoHibernate);
		this.explosivoHibernate = explosivoHibernate;
	}
	
	public Explosivo obtener(Long id){		
		return explosivoHibernate.obtener(id);
	}

	@Override
	public List<Explosivo> buscar(Explosivo explosivo) {
		
		Busqueda filtro = Busqueda.forClass(Explosivo.class);
		
		if (explosivo != null) {
			if(explosivo.getExpediente()!=null){
				if ( explosivo.getExpediente().getId()!=null) {
					filtro.add(Restrictions.eq("expediente.id", explosivo.getExpediente().getId()));
				}
			}					
		}
		return explosivoHibernate.buscar(filtro);		
	}

	
}
