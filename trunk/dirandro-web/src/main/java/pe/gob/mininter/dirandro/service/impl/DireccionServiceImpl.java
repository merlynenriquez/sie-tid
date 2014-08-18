package pe.gob.mininter.dirandro.service.impl;

import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.gob.mininter.dirandro.dao.hibernate.DireccionHibernate;
import pe.gob.mininter.dirandro.model.Direccion;
import pe.gob.mininter.dirandro.service.DireccionService;
import pe.gob.mininter.dirandro.service.ValorService;
import pe.gob.mininter.dirandro.util.Busqueda;

@Service
public class DireccionServiceImpl extends BaseServiceImpl<Direccion, Long>
		implements DireccionService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8064866370340152994L;
	
	private DireccionHibernate direccionHibernate;
	
	@Autowired
	private ValorService valorService;
	
	@Autowired
	public DireccionServiceImpl(DireccionHibernate direccionHibernate) {
		super(direccionHibernate);
		this.direccionHibernate = direccionHibernate;
	}

	@Override
	public List<Direccion> obtenerDireccionesXPersona(Long idPersona,boolean estadoActivo) {
		Busqueda filtro = Busqueda.forClass(Direccion.class);
		filtro.add(Restrictions.eq("persona.id", idPersona));
		/*if(estadoActivo)
		{
			filtro.createAlias("estado", "e");
			filtro.add(Restrictions.eq("e.codigo", Constante.VALOR.CODIGO.ACTIVO));
		}*/
		return direccionHibernate.buscar(filtro);
	}

}
