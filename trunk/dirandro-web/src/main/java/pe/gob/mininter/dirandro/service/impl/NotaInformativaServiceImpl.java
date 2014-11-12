package pe.gob.mininter.dirandro.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.mininter.dirandro.dao.hibernate.NotaInformativaHibernate;
import pe.gob.mininter.dirandro.model.NotaInformativa;
import pe.gob.mininter.dirandro.service.NotaInformativaService;
import pe.gob.mininter.dirandro.util.Busqueda;
import pe.gob.mininter.dirandro.vaadin.panel.bandeja.PanelBandejaNotaInformativa;
import pe.gob.mininter.dirandro.vaadin.util.TablaFiltro;
@Service
public class NotaInformativaServiceImpl extends BaseServiceImpl<NotaInformativa, Long> implements NotaInformativaService {

	private static final long serialVersionUID = -6879679678950091298L;
	
	private NotaInformativaHibernate notaInformativaHibernate;
	
	@Autowired
	public NotaInformativaServiceImpl(NotaInformativaHibernate notaInformativaHibernate ) {
		super(notaInformativaHibernate);
		this.notaInformativaHibernate = notaInformativaHibernate;
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void actualizar(NotaInformativa object) {
		notaInformativaHibernate.actualizar(object);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void crear(NotaInformativa object) {
		notaInformativaHibernate.crear(object);
	}

	@Override
	public List<NotaInformativa> buscar(NotaInformativa objeto) {		
		Busqueda filtro = Busqueda.forClass(NotaInformativa.class);		
		if(objeto !=null){			
			if ( objeto.getNumero() != null) {
				filtro.add(Restrictions.eq("numero", objeto.getNumero() ));
			}
			if ( objeto.getCreador() != null) {
				//filtro.add(Restrictions.eq("creador", objeto.getCreador() ));
				
				if ( objeto.getCreador().getOficina() != null) {
					filtro.createAlias("creador.oficina", "o");
					filtro.add(Restrictions.eq("o.id", objeto.getCreador().getOficina().getId() ));				
				}
				
			}
			if ( objeto.getParte() != null) {
				filtro.createAlias("parte", "p");
				filtro.add(Restrictions.eq("p.autogenerado", objeto.getParte().getAutogenerado() ));				
			}
		}						
		return notaInformativaHibernate.buscar(filtro);		
	}

	//TODO: Revisar se cae
	@Override
	public List<NotaInformativa> buscarBandeja(Map<String, Object> map) {
		Busqueda filtro = Busqueda.forClass(NotaInformativa.class);
		if(map!=null){
			addILikeRestrictions(filtro, "numero", (String)map.get(PanelBandejaNotaInformativa.COLUMNA_NUMERO));
			addILikeRestrictions(filtro, "expediente", "ex", "autogenerado", (String)map.get(PanelBandejaNotaInformativa.COLUMNA_PARTE));
			
			addBetweenGeLeRestrictions(filtro, "fechaRegistro", 
					(Date)map.get(PanelBandejaNotaInformativa.COLUMNA_FECHA+TablaFiltro.KEY_INICIAL), 
					(Date)map.get(PanelBandejaNotaInformativa.COLUMNA_FECHA+TablaFiltro.KEY_FINAL));
			
			if(StringUtils.isNotBlank((String)map.get(PanelBandejaNotaInformativa.COLUMNA_CREADOR))) {
				
				filtro.createAlias("creador", "co");
				filtro.add(Restrictions.or(
						Restrictions.ilike("co.nombres", (String)map.get(PanelBandejaNotaInformativa.COLUMNA_CREADOR), MatchMode.ANYWHERE),
						Restrictions.ilike("co.apePaterno", (String)map.get(PanelBandejaNotaInformativa.COLUMNA_CREADOR), MatchMode.ANYWHERE),
						Restrictions.ilike("co.apeMaterno", (String)map.get(PanelBandejaNotaInformativa.COLUMNA_CREADOR), MatchMode.ANYWHERE)
						));
			}
			
			if(StringUtils.isNotBlank((String)map.get(PanelBandejaNotaInformativa.COLUMNA_DEPENDENCIA))) {
				addILikeRestrictions(filtro, "creador.oficina", "of", "nombre", (String)map.get(PanelBandejaNotaInformativa.COLUMNA_DEPENDENCIA));
			}	
		}
		return notaInformativaHibernate.buscar(filtro);	
	}
}
