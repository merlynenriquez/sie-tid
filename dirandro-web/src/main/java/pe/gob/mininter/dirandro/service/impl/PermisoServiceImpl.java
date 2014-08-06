package pe.gob.mininter.dirandro.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.ListUtils;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.mininter.dirandro.dao.hibernate.PermisoHibernate;
import pe.gob.mininter.dirandro.model.Opcion;
import pe.gob.mininter.dirandro.model.Permiso;
import pe.gob.mininter.dirandro.model.Rol;
import pe.gob.mininter.dirandro.model.Valor;
import pe.gob.mininter.dirandro.service.PermisoService;
import pe.gob.mininter.dirandro.service.ValorService;
import pe.gob.mininter.dirandro.util.Busqueda;
import pe.gob.mininter.dirandro.util.Constante;

@Service
public class PermisoServiceImpl extends BaseServiceImpl<Permiso, Long>
		implements PermisoService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8064866370340152994L;
	
	private PermisoHibernate permisoHibernate;
	
	@Autowired
	private ValorService valorService;
	
	@Autowired
	public PermisoServiceImpl(PermisoHibernate permisoHibernate) {
		super(permisoHibernate);
		this.permisoHibernate = permisoHibernate;
	}

	@Override
	public List<Permiso> obtenerPermisosXRol(Long idRol, boolean estadoActivo) {
		Busqueda filtro = Busqueda.forClass(Permiso.class);
		filtro.createAlias("rol", "r");
		filtro.createAlias("opcion", "o");
		filtro.add(Restrictions.eq("r.id", idRol));
		if(estadoActivo)
		{
			filtro.createAlias("estado", "e");
			filtro.add(Restrictions.eq("e.codigo", Constante.VALOR.CODIGO.ACTIVO));
		}
		filtro.addOrder(Order.asc("o.padre"));
		filtro.addOrder(Order.asc("o.tipo"));
		filtro.addOrder(Order.asc("o.orden"));
		return permisoHibernate.buscar(filtro);
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void guardarPermisos(Long idRol, List<Long> idsOpciones) {
		List<Permiso> permisosALL = obtenerPermisosXRol(idRol, false);
		List<Permiso> permisosA = obtenerPermisosXRol(idRol, true);
		List<Permiso> permisosSel = new ArrayList<Permiso>();
		for (Long idOpcion : idsOpciones) {
			Permiso permiso = new Permiso();
			permiso.setRol(new Rol());
			permiso.getRol().setId(idRol);
			permiso.setOpcion(new Opcion());
			permiso.getOpcion().setId(idOpcion);
			permisosSel.add(permiso);
		}
		List<Permiso> permisosD = ListUtils.subtract(permisosALL, permisosA);
		
		List<Permiso> updPermisosD = ListUtils.subtract(permisosA, permisosSel);
		List<Permiso> updPermisosA = ListUtils.intersection(permisosSel, permisosD);
		List<Permiso> insPermisosA = ListUtils.subtract(permisosSel, permisosALL);
		
		Valor estadoInactivo = valorService.obtenerValor(Constante.LISTA.CODIGO.ESTADO, Constante.VALOR.CODIGO.INACTIVO);
		Valor estadoActivo = valorService.obtenerValor(Constante.LISTA.CODIGO.ESTADO, Constante.VALOR.CODIGO.ACTIVO);
		
		prepararLista(updPermisosD, estadoInactivo);
		prepararLista(updPermisosA, estadoActivo);
		prepararLista(insPermisosA, estadoActivo);
		
		List<Permiso> permisosU = ListUtils.union(updPermisosD, updPermisosA);
		List<Permiso> permisos = ListUtils.union(permisosU, insPermisosA);
		
		super.grabarTodos(permisos);
		
	}
	
	private void prepararLista(List<Permiso> lista, Valor estado)
	{
		for (Permiso permiso : lista) {
			permiso.setEstado(estado);
		}
	}

	@Override
	public List<Permiso> obtenerTodos() {
		// TODO Auto-generated method stub
		return null;
	}

}
