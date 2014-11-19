package pe.gob.mininter.dirandro.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.gob.mininter.dirandro.dao.hibernate.InteligenciaHibernate;
import pe.gob.mininter.dirandro.model.Inteligencia;
import pe.gob.mininter.dirandro.service.InteligenciaService;
import pe.gob.mininter.dirandro.util.Busqueda;

@Service
public class InteligenciaServiceImpl extends BaseServiceImpl<Inteligencia, Long> implements InteligenciaService{

	private static final long serialVersionUID = 5130593284697098405L;
	
	private InteligenciaHibernate inteligenciaHibernate; 
	
	@Autowired
	public InteligenciaServiceImpl(InteligenciaHibernate inteligenciaHibernate) {
		super(inteligenciaHibernate);
		this.inteligenciaHibernate = inteligenciaHibernate;
	}
	
	@Override
	public List<Inteligencia> buscar(Inteligencia inteligencia) {
		Busqueda filtro = Busqueda.forClass(Inteligencia.class);
		if (inteligencia != null) {
			
		}
		return inteligenciaHibernate.buscar(filtro);		
	}
	
}
