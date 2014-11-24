package pe.gob.mininter.dirandro.service.impl;

import java.util.List;
import java.util.Map;

import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.gob.mininter.dirandro.dao.hibernate.InformeHibernate;
import pe.gob.mininter.dirandro.model.Caso;
import pe.gob.mininter.dirandro.model.Expediente;
import pe.gob.mininter.dirandro.model.Informe;
import pe.gob.mininter.dirandro.service.InformeService;
import pe.gob.mininter.dirandro.util.Busqueda;

@Service
public class InformeServiceImpl extends BaseServiceImpl<Informe, Long> implements InformeService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8064866370340152994L;
	
	private InformeHibernate informeHibernate;
		
	@Autowired
	public InformeServiceImpl(InformeHibernate informeHibernate) {
		super(informeHibernate);
		this.informeHibernate = informeHibernate;
	}

	@Override
	public Map<String, List<Informe>> filtrarInforme(List<Informe> lstInforme) {
		return null;
	}

	@Override
	public List<Informe> buscarBandeja(Map<String, Object> map) {
		return null;
	}

	@Override
	public void registrarInforme(Informe informe) {
		// TODO Auto-generated method stub
	}

	@Override
	public Informe obtenerPorExpediente(Expediente expediente) {
		Informe inf = new Informe();
		inf.setExpediente(expediente);
		List<Informe> lis = buscar(inf);
		 
		 if(lis!=null && lis.size()>0)
			 return lis.get(0);
		 else
			 return null;
	}

	@Override
	public List<Informe> buscar(Informe informe) {
		Busqueda filtro = Busqueda.forClass(Informe.class);		
		if(informe!=null){
			if(informe.getId()!=null){
				filtro.add(Restrictions.eq("id", informe.getId()));			
			}
			if(informe.getExpediente()!=null){
				if(informe.getExpediente().getId()!=null){
					filtro.add(Restrictions.eq("expediente.id", informe.getExpediente().getId()));			
				}	
			}
		}
		return informeHibernate.buscar(filtro);
	}
	
}
