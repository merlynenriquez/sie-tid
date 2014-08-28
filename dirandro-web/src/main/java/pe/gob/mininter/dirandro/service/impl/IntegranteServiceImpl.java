package pe.gob.mininter.dirandro.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.gob.mininter.dirandro.dao.hibernate.IntegranteHibernate;
import pe.gob.mininter.dirandro.model.Integrante;
import pe.gob.mininter.dirandro.service.IntegranteService;
import pe.gob.mininter.dirandro.util.Busqueda;

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
	
	

	

}
