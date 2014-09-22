package pe.gob.mininter.dirandro.service.impl;

import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.gob.mininter.dirandro.dao.hibernate.ImporteHibernate;
import pe.gob.mininter.dirandro.model.Importe;
import pe.gob.mininter.dirandro.service.ImporteService;
import pe.gob.mininter.dirandro.util.Busqueda;

@Service
public class ImporteServiceImpl extends BaseServiceImpl<Importe, Long> implements ImporteService {

	private static final long serialVersionUID = 8640969246869906288L;
	
	private ImporteHibernate importeHibernate; 
	
	@Autowired
	public ImporteServiceImpl(ImporteHibernate importeHibernate) {
		super(importeHibernate);
		this.importeHibernate = importeHibernate;
	}

	@Override
	public List<Importe> buscar(Importe importe) {
		Busqueda filtro = Busqueda.forClass(Importe.class);
		
		if(importe.getExpediente()!=null){
			if (importe.getExpediente().getId()!=null) {
				filtro.add(Restrictions.eq("expediente.id", importe.getExpediente().getId()));
			}
		}
		
		return importeHibernate.buscar(filtro);		
	}
	
}
