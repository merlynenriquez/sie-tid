package pe.gob.mininter.dirandro.service.impl;

import java.util.List;

import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.gob.mininter.dirandro.dao.hibernate.CasoVehiculoHibernate;
import pe.gob.mininter.dirandro.model.DetCasoVehiculo;
import pe.gob.mininter.dirandro.service.CasoVehiculoService;
import pe.gob.mininter.dirandro.util.Busqueda;
import pe.gob.mininter.dirandro.util.HarecUtil;

@Service
public class CasoVehiculoServiceImpl extends BaseServiceImpl<DetCasoVehiculo, Long> implements CasoVehiculoService {

	private static final long serialVersionUID = 7777934778383709438L;
	
	private CasoVehiculoHibernate casoVehiculoHibernate;
		
	@Autowired
	public CasoVehiculoServiceImpl(CasoVehiculoHibernate casoVehiculoHibernate) {
		super(casoVehiculoHibernate);
		this.casoVehiculoHibernate = casoVehiculoHibernate;
	}

	@Override
	public List<DetCasoVehiculo> buscar(DetCasoVehiculo caso) {
		Busqueda filtro = Busqueda.forClass(DetCasoVehiculo.class);		
		if(caso!=null){
//			if(caso.getPersona()!=null){
//				if(caso.getPersona().getId()!=null){
//					filtro.add(Restrictions.eq("persona.id", correo.getPersona().getId()));			
//				}
//			}
			

			if(caso.getCaso()!=null){
				filtro.createAlias("caso", "c");
				if(caso.getCaso().getId()!=null){
					filtro.add(Restrictions.eq("c.id", caso.getCaso().getId() ));			
				}
				if(!HarecUtil.nullToEmpty( caso.getCaso().getNombre() ).equals("")){
					filtro.add(Restrictions.ilike("c.nombre", caso.getCaso().getNombre(), MatchMode.ANYWHERE ));			
				}
			}
		}
		return casoVehiculoHibernate.buscar(filtro);
	}

}
