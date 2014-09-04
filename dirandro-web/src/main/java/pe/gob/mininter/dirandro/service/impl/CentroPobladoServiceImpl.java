package pe.gob.mininter.dirandro.service.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.gob.mininter.dirandro.dao.hibernate.CentroPobladoHibernate;
import pe.gob.mininter.dirandro.model.CentroPoblado;
import pe.gob.mininter.dirandro.service.CentroPobladoService;
import pe.gob.mininter.dirandro.util.Busqueda;

@Service
public class CentroPobladoServiceImpl extends BaseServiceImpl<CentroPoblado, Long> implements CentroPobladoService {
	
	private static final long serialVersionUID = 3448706158479870676L;
	
	private CentroPobladoHibernate centroPobladoHibernate;
	
	@Override
	public void actualizar(CentroPoblado object) {
		object.validar();
		super.actualizar(object);
	}

	@Override
	public void crear(CentroPoblado object) {
		object.validar();
		super.crear(object);
	}

	@Autowired
	public CentroPobladoServiceImpl(CentroPobladoHibernate centroPobladoHibernate) {
		super(centroPobladoHibernate);
		this.centroPobladoHibernate = centroPobladoHibernate;
	}

	@Override
	public List<CentroPoblado> listarCentroPoblado() {
		Busqueda filtro = Busqueda.forClass(CentroPoblado.class);
		return centroPobladoHibernate.buscar(filtro);
	}

	@Override
	public List<CentroPoblado> buscar(CentroPoblado centroPoblado) {
		Busqueda filtro = Busqueda.forClass(CentroPoblado.class);
		
		if (centroPoblado!=null){
			if (centroPoblado.getId() != null) {
				filtro.add(Restrictions.eq("id", centroPoblado.getId()));
			}
			if(centroPoblado.getNombre()!= null){
				filtro.add(Restrictions.ilike("nombre",centroPoblado.getNombre(), MatchMode.ANYWHERE));
			}
			if(centroPoblado.getDistrito()!= null && StringUtils.isNotEmpty(centroPoblado.getDistrito().getNombre())){
				filtro.createAlias("distrito", "d");
				filtro.add(Restrictions.ilike("d.nombre",centroPoblado.getDistrito().getNombre(), MatchMode.ANYWHERE));
			}
			if(centroPoblado.getCategoria()!= null && StringUtils.isNotEmpty(centroPoblado.getCategoria().getNombre())){
				filtro.createAlias("categoria", "c");
				filtro.add(Restrictions.ilike("c.nombre",centroPoblado.getCategoria().getNombre(), MatchMode.ANYWHERE));
			}
		}
		
		filtro.addOrder(Order.asc("nombre"));
		return centroPobladoHibernate.buscar(filtro);
	}

}
