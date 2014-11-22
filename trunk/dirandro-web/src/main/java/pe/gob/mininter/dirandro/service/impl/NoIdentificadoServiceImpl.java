package pe.gob.mininter.dirandro.service.impl;

import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.gob.mininter.dirandro.dao.hibernate.NoIdentificadoHibernate;
import pe.gob.mininter.dirandro.model.Expediente;
import pe.gob.mininter.dirandro.model.NoIdentificado;
import pe.gob.mininter.dirandro.service.NoIdentificadoService;
import pe.gob.mininter.dirandro.util.Busqueda;

@Service
public class NoIdentificadoServiceImpl extends BaseServiceImpl<NoIdentificado, Long> implements NoIdentificadoService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 680998051676171770L;
	
	private NoIdentificadoHibernate noIdentificadoHibernate;

	@Autowired
	public NoIdentificadoServiceImpl(NoIdentificadoHibernate noIdentificadoHibernate) {
		super(noIdentificadoHibernate);
		this.noIdentificadoHibernate = noIdentificadoHibernate;
	}

	@Override
	public List<NoIdentificado> cargarDelExpediente(Expediente expediente) {
		Busqueda filtro = Busqueda.forClass(NoIdentificado.class);
		filtro.add(Restrictions.eq("expediente", expediente));
		return noIdentificadoHibernate.buscar(filtro);
	}


}
