package pe.gob.mininter.dirandro.service.impl;

import java.util.List;

import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.mininter.dirandro.dao.hibernate.AbogadoPersonaHibernate;
import pe.gob.mininter.dirandro.model.AbogadoPersona;
import pe.gob.mininter.dirandro.service.AbogadoPersonaService;
import pe.gob.mininter.dirandro.util.Busqueda;

@Service
public class AbogadoPersonaServiceImpl extends BaseServiceImpl<AbogadoPersona, Long> implements AbogadoPersonaService {

	private static final long serialVersionUID = -3238415592261474361L;

	protected enum TipoOperacion{CREAR,ACTUALIZAR,ELIMINAR}
	
	private AbogadoPersonaHibernate abogadoPersonaHibernate;
	
	@Autowired
	public AbogadoPersonaServiceImpl(AbogadoPersonaHibernate abogadoPersonaHibernate) {
		super(abogadoPersonaHibernate);
		this.abogadoPersonaHibernate = abogadoPersonaHibernate;
	}

	@Override	
	@Transactional(propagation=Propagation.REQUIRED)
	public void crear(AbogadoPersona abogadoPersona) {		 
		super.crear(abogadoPersona);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void actualizar(AbogadoPersona abogadoPersona) {		
		super.actualizar(abogadoPersona);
	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED, readOnly = false)
	public void eliminar(AbogadoPersona abogadoPersona) {
		super.actualizar(abogadoPersona);
	}

	@Override
	public List<AbogadoPersona> listarAbogadoPersona() {
		Busqueda filtro = Busqueda.forClass(AbogadoPersona.class);
		//filtro.createAlias("persona", "p");
		//filtro.addOrder(Order.asc("p.nombres"));
		return abogadoPersonaHibernate.buscar(filtro);
	}	
	
}
