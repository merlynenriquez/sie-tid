package pe.gob.mininter.dirandro.service.impl;

import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.gob.mininter.dirandro.dao.hibernate.ParentescoHibernate;
import pe.gob.mininter.dirandro.model.Parentesco;
import pe.gob.mininter.dirandro.service.ParentescoService;
import pe.gob.mininter.dirandro.service.ValorService;
import pe.gob.mininter.dirandro.util.Busqueda;

@Service
public class ParentescoServiceImpl extends BaseServiceImpl<Parentesco, Long> implements ParentescoService {

	private static final long serialVersionUID = 8064866370340152994L;
	
	private ParentescoHibernate parentescoHibernate;
	
	@Autowired
	private ValorService valorService;
	
	@Autowired
	public ParentescoServiceImpl(ParentescoHibernate parentescoHibernate) {
		super(parentescoHibernate);
		this.parentescoHibernate = parentescoHibernate;
	}

	@Override
	public List<Parentesco> obtenerParientesXPersona(Long idPersona,boolean estadoActivo) {
		Busqueda filtro = Busqueda.forClass(Parentesco.class);
		filtro.add(Restrictions.eq("persona.id", idPersona));
		/*if(estadoActivo)
		{
			filtro.createAlias("estado", "e");
			filtro.add(Restrictions.eq("e.codigo", Constante.VALOR.CODIGO.ACTIVO));
		}*/
		return parentescoHibernate.buscar(filtro);
	}

}
