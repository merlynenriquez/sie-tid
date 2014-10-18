package pe.gob.mininter.dirandro.dao.hibernate.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pe.gob.mininter.dirandro.dao.hibernate.RolHibernate;
import pe.gob.mininter.dirandro.model.Rol;
import pe.gob.mininter.dirandro.util.Busqueda;

@Repository
public class RolHibernateImpl extends BaseHibernateImpl<Rol, Long> implements RolHibernate {
	
	private static final long serialVersionUID = -1143632255799838731L;

	@Autowired
	public RolHibernateImpl(SessionFactory sessionFactory) {
		setSessionFactory(sessionFactory);
	}

	@Override
	public List<Rol> busquedaRoles(Rol rol) {
		List<String> alias=new ArrayList<String>();
        Busqueda filtro = Busqueda.forClass(Rol.class);
        if(rol!=null){
                if(rol.getId()!=null){
                        filtro.add(Restrictions.eq("id",
                                        rol.getId()));
                }
                if(rol.getCodigo()!=null){
                        filtro.add(Restrictions.ilike("codigo",
                                        rol.getCodigo(), MatchMode.ANYWHERE));
                }
                if(rol.getNombre()!=null){
                        filtro.add(Restrictions.ilike("nombre",
                                        rol.getNombre(), MatchMode.ANYWHERE));
                }
                if(rol.getEstado()!=null){
                        filtro.createAlias("estado", "e");
                        alias.add("e");
                        filtro.add(Restrictions.ilike("e.nombre",
                                        rol.getEstado().getNombre(), MatchMode.ANYWHERE));
                }
        }
        filtro.addOrder(Order.asc("id"));
        return buscar(filtro);
	}
	
}