package pe.gob.mininter.dirandro.service.impl;

import java.util.List;

import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.gob.mininter.dirandro.dao.hibernate.DetAerodromoHibernate;
import pe.gob.mininter.dirandro.model.DetAerodromo;
import pe.gob.mininter.dirandro.service.DetAerodromoService;
import pe.gob.mininter.dirandro.util.Busqueda;

@Service
@SuppressWarnings("serial")
public class DetAerodromoServiceImpl extends BaseServiceImpl<DetAerodromo, Long> implements DetAerodromoService {
	
	private DetAerodromoHibernate detAerodromoHibernate;
	
	@Autowired
	public DetAerodromoServiceImpl(DetAerodromoHibernate detAerodromoHibernate) {
		super(detAerodromoHibernate);
		this.detAerodromoHibernate = detAerodromoHibernate;
	}

	@Override
	public List<DetAerodromo> buscar(DetAerodromo detAerodromo) {
		Busqueda filtro = Busqueda.forClass(DetAerodromo.class);
		if (detAerodromo != null) {
			if(detAerodromo.getIntInteligencia()!=null){
				filtro.createAlias("intInteligencia", "i");
				filtro.add(Restrictions.eq("i.id", detAerodromo.getIntInteligencia().getId()));
			}
		}
		filtro.addOrder(Order.asc("id"));
		return detAerodromoHibernate.buscar(filtro);
	}
	
}
