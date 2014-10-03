package pe.gob.mininter.dirandro.service.impl;

import java.util.List;

import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.gob.mininter.dirandro.dao.hibernate.MunicionHibernate;
import pe.gob.mininter.dirandro.model.Municion;
import pe.gob.mininter.dirandro.service.MunicionService;
import pe.gob.mininter.dirandro.util.Busqueda;

@Service
public class MunicionServiceImpl extends BaseServiceImpl<Municion, Long> implements MunicionService{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6214909808376225533L;
	private MunicionHibernate municionHibernate; 
	
	@Autowired
	public MunicionServiceImpl(MunicionHibernate municionHibernate) {
		super(municionHibernate);
		this.municionHibernate = municionHibernate;
	}
	
	@Override
	public List<Municion> buscar(Municion municion) {
		Busqueda filtro = Busqueda.forClass(Municion.class);
		if (municion != null) {
			
			if (municion.getCalibre() != null && municion.getCalibre().getId()!=null) {
				filtro.add(Restrictions.eq("calibre.id", municion.getCalibre().getId()));
			}
			if (municion.getDescripcion()!= null && municion.getDescripcion().length() > 0) {
				filtro.add(Restrictions.ilike("descripcion", municion.getDescripcion(), MatchMode.ANYWHERE));
			}
			if(municion.getExpediente()!=null){
				if ( municion.getExpediente().getId()!=null) {
					filtro.add(Restrictions.eq("expediente.id", municion.getExpediente().getId()));
				}
			}
			
		}
		return municionHibernate.buscar(filtro);		
	}
	
}
