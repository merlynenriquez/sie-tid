package pe.gob.mininter.dirandro.service.impl;

import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.gob.mininter.dirandro.dao.hibernate.CorreoHibernate;
import pe.gob.mininter.dirandro.model.Correo;
import pe.gob.mininter.dirandro.service.CorreoService;
import pe.gob.mininter.dirandro.service.ValorService;
import pe.gob.mininter.dirandro.util.Busqueda;

@Service
public class CorreoServiceImpl extends BaseServiceImpl<Correo, Long>
		implements CorreoService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8064866370340152994L;
	
	private CorreoHibernate correoHibernate;
	
	@Autowired
	private ValorService valorService;
	
	@Autowired
	public CorreoServiceImpl(CorreoHibernate correoHibernate) {
		super(correoHibernate);
		this.correoHibernate = correoHibernate;
	}

	@Override
	public List<Correo> obtenerCorreosXPersona(Long idPersona,boolean estadoActivo) {
		Busqueda filtro = Busqueda.forClass(Correo.class);
		filtro.add(Restrictions.eq("persona.id", idPersona));
		/*if(estadoActivo)
		{
			filtro.createAlias("estado", "e");
			filtro.add(Restrictions.eq("e.codigo", Constante.VALOR.CODIGO.ACTIVO));
		}*/
		return correoHibernate.buscar(filtro);
	}

}
