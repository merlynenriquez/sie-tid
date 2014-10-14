package pe.gob.mininter.dirandro.service.impl;

import java.util.List;

import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.gob.mininter.dirandro.dao.hibernate.IntegranteHibernate;
import pe.gob.mininter.dirandro.model.Integrante;
import pe.gob.mininter.dirandro.service.IntegranteService;
import pe.gob.mininter.dirandro.util.Busqueda;
import pe.gob.mininter.dirandro.util.Constante;

@Service
public class IntegranteServiceImpl extends BaseServiceImpl<Integrante, Long> implements IntegranteService {

	/**
	 * 
	 */
	private static final long serialVersionUID = -149039932393680253L;
	
	private IntegranteHibernate integranteHibernate;

	@Autowired
	public IntegranteServiceImpl(IntegranteHibernate integranteHibernate) {
		super(integranteHibernate);
		this.integranteHibernate = integranteHibernate;
	}

	@Override
	public List<Integrante> listarIntegrantes() {
		Busqueda filtro	= Busqueda.forClass(Integrante.class);
		return integranteHibernate.buscar(filtro);
	}
	
	
	@Override
	public List<Integrante> buscar(Integrante integrante) {
		Busqueda filtro = Busqueda.forClass(Integrante.class);
		
		if (integrante != null) {
			if (integrante.getId() != null) {
				filtro.add(Restrictions.eq("id", integrante.getId()));
			}
			
			if (integrante.getEstado() != null && integrante.getEstado().getNombre() != null) {
				filtro.createAlias("estado", "e");
				filtro.add(Restrictions.ilike("e.nombre",integrante.getEstado().getNombre(), MatchMode.ANYWHERE));
			}
			if(integrante.getDependencia()!=null){
				filtro.createAlias("dependencia", "dep");
				filtro.add(Restrictions.eq("dep.id",integrante.getDependencia().getId()));
			}
		}
		
		filtro.createAlias("estado", "e");
		filtro.add(Restrictions.eq("e.codigo", Constante.VALOR.CODIGO.ACTIVO));
		
		filtro.addOrder(Order.asc("id"));
		return integranteHibernate.buscar(filtro);
	}
	

}
