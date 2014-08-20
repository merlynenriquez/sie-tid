package pe.gob.mininter.dirandro.service.impl;

import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.gob.mininter.dirandro.dao.hibernate.IdentificacionHibernate;
import pe.gob.mininter.dirandro.model.Identificacion;
import pe.gob.mininter.dirandro.service.IdentificacionService;
import pe.gob.mininter.dirandro.service.ValorService;
import pe.gob.mininter.dirandro.util.Busqueda;

@Service
public class IdentificacionServiceImpl extends BaseServiceImpl<Identificacion, Long>
		implements IdentificacionService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8064866370340152994L;
	
	private IdentificacionHibernate identificacionHibernate;
	
	@Autowired
	private ValorService valorService;
	
	@Autowired
	public IdentificacionServiceImpl(IdentificacionHibernate identificacionHibernate) {
		super(identificacionHibernate);
		this.identificacionHibernate = identificacionHibernate;
	}


	@Override
	public List<Identificacion> obtenerIdentificacionesXPersona(Long idPersona, boolean estadoActivo) {
		Busqueda filtro = Busqueda.forClass(Identificacion.class);
		filtro.add(Restrictions.eq("persona.id", idPersona));
		/*if(estadoActivo)
		{
			filtro.createAlias("estado", "e");
			filtro.add(Restrictions.eq("e.codigo", Constante.VALOR.CODIGO.ACTIVO));
		}*/
		return identificacionHibernate.buscar(filtro);
	}

}
