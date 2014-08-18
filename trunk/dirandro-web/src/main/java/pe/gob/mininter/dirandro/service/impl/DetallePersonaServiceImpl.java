package pe.gob.mininter.dirandro.service.impl;

import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.gob.mininter.dirandro.dao.hibernate.DetallePersonaHibernate;
import pe.gob.mininter.dirandro.model.Detalle;
import pe.gob.mininter.dirandro.service.DetallePersonaService;
import pe.gob.mininter.dirandro.util.Busqueda;

@Service
public class DetallePersonaServiceImpl  extends BaseServiceImpl<Detalle, Long>  implements DetallePersonaService {

	private DetallePersonaHibernate detallePersonaHibernate;
	
	@Autowired
	protected DetallePersonaServiceImpl( DetallePersonaHibernate detallePersonaHibernate ) {
		super(detallePersonaHibernate);
		this.detallePersonaHibernate = detallePersonaHibernate;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 122979221300752336L;

	@Override
	public void actualizar(Detalle object) {
		object.validar();
		detallePersonaHibernate.actualizar(object);
	}

	@Override
	public void crear(Detalle object) {
		try {
			object.validar();
			System.out.println( "insertar detalle persona " );
			super.crear(object);	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public Detalle obtenerPorPersona(Long idPersona) {
		Busqueda filtro = Busqueda.forClass(Detalle.class);
		if (idPersona != null) {
			filtro.add(Restrictions.eq("persona.id", idPersona ));
		}
	//	filtro.addOrder(Order.asc("codigo"));
		List<Detalle>  del = detallePersonaHibernate.buscar(filtro);
		if( del.size() > 0)
			return del.get(0);
		else
			return null;
	}



}
