package pe.gob.mininter.dirandro.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.gob.mininter.dirandro.dao.hibernate.NotaAgenteHibernate;
import pe.gob.mininter.dirandro.model.NotaAgente;
import pe.gob.mininter.dirandro.service.NotaAgenteService;
@Service
public class NotaAgenteServiceImpl extends BaseServiceImpl<NotaAgente, Long> implements NotaAgenteService {

	private static final long serialVersionUID = 61112443746703372L;
	
	private NotaAgenteHibernate notaAgenteHibernate;
	
	@Autowired
	public NotaAgenteServiceImpl(NotaAgenteHibernate notaAgenteHibernate) {
		super(notaAgenteHibernate);
		this.notaAgenteHibernate = notaAgenteHibernate;
	}

	@Override
	public List<NotaAgente> buscar(NotaAgente notaAgente) {
		// TODO Auto-generated method stub
		return null;
	}


}
