package pe.gob.mininter.dirandro.service.impl;

import java.util.List;

import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.mininter.dirandro.dao.hibernate.LetradoHibernate;
import pe.gob.mininter.dirandro.model.Letrado;
import pe.gob.mininter.dirandro.service.LetradoService;
import pe.gob.mininter.dirandro.util.Busqueda;

@Service
public class LetradoServiceImpl extends BaseServiceImpl<Letrado, Long> implements LetradoService {

	private static final long serialVersionUID = -3238415592261474361L;

	protected enum TipoOperacion{CREAR,ACTUALIZAR,ELIMINAR}
	
	private LetradoHibernate letradoHibernate;
	
	@Autowired
	public LetradoServiceImpl(LetradoHibernate letradoHibernate) {
		super(letradoHibernate);
		this.letradoHibernate = letradoHibernate;
	}

	@Override	
	@Transactional(propagation=Propagation.REQUIRED)
	public void crear(Letrado letrado) {		 
		super.crear(letrado);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void actualizar(Letrado letrado) {		
		super.actualizar(letrado);
	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED, readOnly = false)
	public void eliminar(Letrado letrado) {
		super.actualizar(letrado);
	}

	@Override
	public List<Letrado> buscar(Letrado letrado) {
		Busqueda filtro = Busqueda.forClass(Letrado.class);
		if (letrado != null) {
			
			filtro.createAlias("perPersona", "per");
						
			if (letrado.getPerPersona().getNombres() != null) {
				filtro.add(Restrictions.ilike("per.nombres",letrado.getPerPersona().getNombres() , MatchMode.ANYWHERE));
			}
			if (letrado.getPerPersona().getApePaterno() != null) {
				filtro.add(Restrictions.ilike("per.apePaterno",letrado.getPerPersona().getApePaterno() , MatchMode.ANYWHERE));
			}
			
			if (letrado.getPerPersona().getNroDocumento()!= null) {
				filtro.add(Restrictions.ilike("per.nroDocumento", letrado.getPerPersona().getNroDocumento(), MatchMode.ANYWHERE));
			}
		}
		//filtro.addOrder(Order.asc("codigo"));
		return letradoHibernate.buscar(filtro);
	}

	@Override
	public List<Letrado> listarLetrado() {

		Busqueda filtro = Busqueda.forClass(Letrado.class);

		filtro.createAlias("perPersona", "per");

		filtro.addOrder(Order.asc("per.nombres")); 

		return letradoHibernate.buscar(filtro);

	}	
	
}