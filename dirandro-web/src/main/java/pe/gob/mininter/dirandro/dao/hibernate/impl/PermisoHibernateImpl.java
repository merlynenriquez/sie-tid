package pe.gob.mininter.dirandro.dao.hibernate.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pe.gob.mininter.dirandro.dao.hibernate.PermisoHibernate;
import pe.gob.mininter.dirandro.model.Permiso;
import pe.gob.mininter.dirandro.util.Busqueda;
import pe.gob.mininter.dirandro.util.Constante;

@Repository
public class PermisoHibernateImpl extends BaseHibernateImpl<Permiso, Long> implements PermisoHibernate {
	
	private static final long serialVersionUID = -1143632255799838731L;

	@Autowired
	public PermisoHibernateImpl(SessionFactory sessionFactory) {
		setSessionFactory(sessionFactory);
	}

	@Override
	public List<Permiso> obtenerPermisosXRol(Long idRol, boolean estadoActivo) {
		Busqueda filtro = Busqueda.forClass(Permiso.class);
        filtro.createAlias("rol", "r");
        filtro.createAlias("opcion", "o");
        filtro.createAlias("o.estado", "oe");           
        filtro.add(Restrictions.eq("oe.codigo", Constante.VALOR.CODIGO.ACTIVO));
        filtro.add(Restrictions.eq("r.id", idRol));
        if(estadoActivo)
        {
                filtro.createAlias("estado", "e");
                filtro.add(Restrictions.eq("e.codigo", Constante.VALOR.CODIGO.ACTIVO));
                
        }
        filtro.addOrder(Order.asc("o.padre"));
        filtro.addOrder(Order.asc("o.orden"));
        return buscar(filtro);
	}
	
}