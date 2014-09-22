package pe.gob.mininter.dirandro.service.impl;

import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.gob.mininter.dirandro.dao.hibernate.HojaRemisionHibernate;
import pe.gob.mininter.dirandro.model.Hojaremision;
import pe.gob.mininter.dirandro.service.HojaRemisionService;
import pe.gob.mininter.dirandro.util.Busqueda;

@Service
public class HojaRemisionServiceImpl extends BaseServiceImpl<Hojaremision, Long> implements HojaRemisionService{

	private static final long serialVersionUID = 2697106645391028183L;
	
	private HojaRemisionHibernate hojaDeRemisionHibernate;
	
	@Autowired
	public HojaRemisionServiceImpl(HojaRemisionHibernate hojaDeRemisionHibernate) {
		super(hojaDeRemisionHibernate);
		this.hojaDeRemisionHibernate = hojaDeRemisionHibernate;
	}

	public Hojaremision obtener(Long id){		
		return hojaDeRemisionHibernate.obtener(id);
	}

	@Override
	public List<Hojaremision> buscar(Hojaremision hojaremision) {
		
		Busqueda filtro = Busqueda.forClass(Hojaremision.class);
		
		if (hojaremision != null) {
			
			if(hojaremision.getExpediente()!=null){
				if ( hojaremision.getExpediente().getId()!=null) {
					filtro.add(Restrictions.eq("expediente.id", hojaremision.getExpediente().getId()));
				}
			}
			if(hojaremision.getOrigen()!=null){
				if ( hojaremision.getOrigen().getId()!=null) {
					filtro.add(Restrictions.eq("origen.id", hojaremision.getOrigen().getId()));
				}
			}
			if(hojaremision.getDestino()!=null){
				if ( hojaremision.getDestino().getId()!=null) {
					filtro.add(Restrictions.eq("destino.id", hojaremision.getDestino().getId()));
				}
			}
			if(hojaremision.getTipoHr()!=null){
				if ( hojaremision.getTipoHr().getId()!=null) {
					filtro.add(Restrictions.eq("tipoHr.id", hojaremision.getTipoHr().getId()));
				}
			}
			if(hojaremision.getConductor()!=null){
				if ( hojaremision.getConductor().getId()!=null) {
					filtro.add(Restrictions.eq("conductor.id", hojaremision.getConductor().getId()));
				}
			}
			if(hojaremision.getCustodio()!=null){
				if ( hojaremision.getCustodio().getId()!=null) {
					filtro.add(Restrictions.eq("custodio.id", hojaremision.getCustodio().getId()));
				}
			}
			/*filtro.createAlias("perPersona", "per");
		
			if (Policia.getPerPersona().getNombres() != null && Policia.getPerPersona().getNombres().length() > 0) {
				filtro.add(Restrictions.ilike("per.nombres", Policia.getPerPersona().getNombres(), MatchMode.ANYWHERE));
			}
			
			if (Policia.getPerPersona().getApePaterno()!= null && Policia.getPerPersona().getApePaterno().length() > 0) {
				filtro.add(Restrictions.ilike("per.apePaterno", Policia.getPerPersona().getApePaterno(), MatchMode.ANYWHERE));
			}
			
			if (Policia.getPerPersona().getApeMaterno()!= null && Policia.getPerPersona().getApeMaterno().length() > 0) {
				filtro.add(Restrictions.ilike("per.apeMaterno", Policia.getPerPersona().getApeMaterno(), MatchMode.ANYWHERE));
			}
			
			if (Policia.getPerPersona().getNroDocumento()!= null) {
				filtro.add(Restrictions.ilike("per.nroDocumento", Policia.getPerPersona().getNroDocumento(), MatchMode.ANYWHERE));
			}*/
			
			/*filtro.createAlias("perPersona", "per");
			if (empresa.getPerPersona() != null && empresa.getRazonSocial().length() > 0) {
				filtro.add(Restrictions.ilike("razon_social", empresa.getRazonSocial(), MatchMode.ANYWHERE));
			}
						
			if (empresa.getRazonSocial() != null && empresa.getRazonSocial().length() > 0) {
				filtro.add(Restrictions.ilike("razonSocial", empresa.getRazonSocial(), MatchMode.ANYWHERE));
			}
			else
			if (empresa.getRuc() != null && empresa.getRuc().length() > 0) {
				filtro.add(Restrictions.ilike("ruc", empresa.getRuc(), MatchMode.ANYWHERE));
			}*/
								
		}
		return hojaDeRemisionHibernate.buscar(filtro);		
	}

	
}
