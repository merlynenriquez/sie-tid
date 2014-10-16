package pe.gob.mininter.dirandro.service.impl;

import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.gob.mininter.dirandro.dao.hibernate.ArmaHibernate;
import pe.gob.mininter.dirandro.model.Arma;
import pe.gob.mininter.dirandro.service.ArmaService;
import pe.gob.mininter.dirandro.util.Busqueda;

@Service
public class ArmaServiceImpl extends BaseServiceImpl<Arma, Long> implements ArmaService{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6214909808376225533L;
	private ArmaHibernate armaHibernate; 
	
	@Autowired
	public ArmaServiceImpl(ArmaHibernate armaHibernate) {
		super(armaHibernate);
		this.armaHibernate = armaHibernate;
	}
	
	@Override
	public List<Arma> buscar(Arma arma) {
		Busqueda filtro = Busqueda.forClass(Arma.class);
		if (arma != null) {
			if (arma.getModelo() != null && arma.getModelo().getId()!=null) {
				filtro.createAlias("modelo", "m");
				filtro.add(Restrictions.eq("m.id", arma.getModelo().getId()));
			}
			if (arma.getEstadoSerie() != null && arma.getEstadoSerie().getId()!=null) {
				filtro.createAlias("estadoSerie", "e");
				filtro.add(Restrictions.eq("e.id", arma.getModelo().getId()));
			}
			addILikeRestrictions(filtro, "nroSerie", arma.getNroSerie());
			if (arma.getCalibre() != null && arma.getCalibre().getId()!=null) {
				filtro.createAlias("calibre", "c");
				filtro.add(Restrictions.eq("c.id", arma.getCalibre().getId()));
			}
			addILikeRestrictions(filtro, "internamiento", arma.getInternamiento());
			
		}
		return armaHibernate.buscar(filtro);		
	}
	
}
