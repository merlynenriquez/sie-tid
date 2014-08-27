package pe.gob.mininter.dirandro.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import pe.gob.mininter.dirandro.dao.hibernate.CentroPobladoHibernate;
import pe.gob.mininter.dirandro.model.CentroPoblado;
import pe.gob.mininter.dirandro.service.CentroPobladoService;
import pe.gob.mininter.dirandro.util.Busqueda;

public class CentroPobladoServiceImpl extends BaseServiceImpl<CentroPoblado, Long>
	implements CentroPobladoService {

	private CentroPobladoHibernate centroPobladoHibernate;
	
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

}
