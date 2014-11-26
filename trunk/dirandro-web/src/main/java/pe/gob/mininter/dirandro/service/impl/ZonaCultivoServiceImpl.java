package pe.gob.mininter.dirandro.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.gob.mininter.dirandro.dao.hibernate.ZonaCultivoHibernate;
import pe.gob.mininter.dirandro.model.Usuario;
import pe.gob.mininter.dirandro.model.ZonaCultivo;
import pe.gob.mininter.dirandro.service.ZonaCultivoService;
import pe.gob.mininter.dirandro.util.Busqueda;

@Service
@SuppressWarnings("serial")
public class ZonaCultivoServiceImpl extends BaseServiceImpl<ZonaCultivo, Long> implements ZonaCultivoService {
	
	private ZonaCultivoHibernate zonaCultivoHibernate;
	
	@Autowired
	public ZonaCultivoServiceImpl(ZonaCultivoHibernate zonaCultivoHibernate) {
		super(zonaCultivoHibernate);
		this.zonaCultivoHibernate = zonaCultivoHibernate;
	}

	@Override
	public List<ZonaCultivo> buscar(ZonaCultivo zona) {
		Busqueda filtro = Busqueda.forClass(ZonaCultivo.class);		
		if (zona!=null){
			if(zona.getId()!= null){
				//filtro.add(Restrictions.ilike("usuario",usuario.getUsuario(),MatchMode.ANYWHERE));
			}	
		}
		return zonaCultivoHibernate.buscar(filtro);
	}
	
}
