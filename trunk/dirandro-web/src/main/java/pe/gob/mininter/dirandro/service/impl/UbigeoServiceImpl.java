package pe.gob.mininter.dirandro.service.impl;

import java.util.List;

import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.gob.mininter.dirandro.dao.hibernate.DistritoHibernate;
import pe.gob.mininter.dirandro.dao.hibernate.PaisHibernate;
import pe.gob.mininter.dirandro.model.Distrito;
import pe.gob.mininter.dirandro.model.Pais;
import pe.gob.mininter.dirandro.service.UbigeoService;
import pe.gob.mininter.dirandro.util.Busqueda;

@Service
public class UbigeoServiceImpl implements UbigeoService {
	
	@Autowired
	private DistritoHibernate distritoHibernate;
	
	@Autowired
	private PaisHibernate paisHibernate;
	
	@Override
	public Distrito obtenerDistritoHost(String codigoHost) {
		Busqueda filtro = Busqueda.forClass(Distrito.class);
		filtro.add(Restrictions.eq("codigo", codigoHost));
		List<Distrito> distritos = distritoHibernate.buscar(filtro);
		
		if(distritos.size() > 0){
			return distritos.get(0);
		}
		return null;
	}

	@Override
	public List<Distrito> obtenerTodos() {
		Busqueda filtro = Busqueda.forClass(Distrito.class);
		filtro.createAlias("provincia", "p");
		filtro.createAlias("p.departamento", "d");
		filtro.addOrder(Order.asc("nombre"));
		filtro.addOrder(Order.asc("p.nombre"));
		filtro.addOrder(Order.asc("d.nombre"));
		return distritoHibernate.buscar(filtro);
	}

	@Override
	public Distrito obtenerDistrito(Long idDistrito) {
		return distritoHibernate.obtener(idDistrito);
	}

	@Override
	public void cargarUbigeo() {
		/*Busqueda filtro = Busqueda.forClass(Distrito.class);
		filtro.createAlias("provincia", "p");
		filtro.createAlias("p.departamento", "d");
		filtro.addOrder(Order.asc("nombre"));
		filtro.addOrder(Order.asc("p.nombre"));
		filtro.addOrder(Order.asc("d.nombre"));
		distritos=distritoHibernate.buscar(filtro);*/
	}

	@Override
	public List<Pais> obtenerPaises() {
		Busqueda filtro = Busqueda.forClass(Pais.class);
		filtro.addOrder(Order.asc("nombre"));
		return paisHibernate.buscar(filtro);
	}
	
}
