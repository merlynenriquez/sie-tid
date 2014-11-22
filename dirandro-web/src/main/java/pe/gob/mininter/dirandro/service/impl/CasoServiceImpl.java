package pe.gob.mininter.dirandro.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.mininter.dirandro.dao.hibernate.CasoHibernate;
import pe.gob.mininter.dirandro.model.Caso;
import pe.gob.mininter.dirandro.service.CasoService;
import pe.gob.mininter.dirandro.util.Busqueda;

@Service
public class CasoServiceImpl extends BaseServiceImpl<Caso, Long> implements CasoService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8064866370340152994L;
	
	private CasoHibernate casoHibernate;
		
	@Autowired
	public CasoServiceImpl(CasoHibernate casoHibernate) {
		super(casoHibernate);
		this.casoHibernate = casoHibernate;
	}

	@Override
	public List<Caso> buscar(Caso caso) {
		Busqueda filtro = Busqueda.forClass(Caso.class);		
		if(caso!=null){
//			if(caso.getPersona()!=null){
//				if(caso.getPersona().getId()!=null){
//					filtro.add(Restrictions.eq("persona.id", correo.getPersona().getId()));			
//				}
//			}
		}
		return casoHibernate.buscar(filtro);
	}

	@Override
	public Map<String, List<Caso>> listarCasos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, List<Caso>> filtrarCasos(List<Caso> lstCasos) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public void registrarCaso(Caso caso) {
		super.crear(caso);
		String numeroCaso = StringUtils.leftPad(String.valueOf(caso.getId()), 10, "0");
		caso.setNroCaso(numeroCaso);
		super.actualizar(caso);
	}

	@Override
	public List<Caso> buscarBandeja(Map<String, Object> map) {
		Busqueda filtro = Busqueda.forClass(Caso.class);
		if(map!=null){
			
//			if(StringUtils.isNotBlank((String)map.get(PanelBandejaPericias.COLUMNA_EXPEDIENTE))) {
//				filtro.createAlias("muestra", "m");
//				filtro.createAlias("m.hojaremision", "hr");
//				addILikeRestrictions(filtro, "hr.expediente", "ex", "autogenerado", (String)map.get(PanelBandejaPericias.COLUMNA_EXPEDIENTE));
//			}
//			if(StringUtils.isNotBlank((String)map.get(PanelBandejaPericias.COLUMNA_TIPO_HR))) {
//				filtro.createAlias("muestra", "m");
//				filtro.createAlias("m.hojaremision", "hr");
//				addILikeRestrictions(filtro, "hr.tipoHr", "th", "nombre", (String)map.get(PanelBandejaPericias.COLUMNA_TIPO_HR));
//			}
//			if(StringUtils.isNotBlank((String)map.get(PanelBandejaPericias.COLUMNA_HOJA_REMISION))) {
//				filtro.createAlias("muestra", "m");
//				addILikeRestrictions(filtro, "m.hojaRemision", "hr", "numero", (String)map.get(PanelBandejaPericias.COLUMNA_HOJA_REMISION));
//			}
//			/*
//			 * No se puede xq no es campo
//			 * if(StringUtils.isNotBlank((String)map.get(PanelBandejaPericias.COLUMNA_TIPO_MUESTRA))) {
//				filtro.createAlias("muestra", "m");
//				addILikeRestrictions(filtro, "m.", "tm", "autogenerado", (String)map.get(PanelBandejaPericias.COLUMNA_TIPO_MUESTRA));
//			}*/
//			if(StringUtils.isNotBlank((String)map.get(PanelBandejaPericias.COLUMNA_TIPO_MUESTRA_NOMBRE))) {
//				
//				filtro.createAlias("muestra", "mu");
//				
//				filtro.add(Restrictions.or(
//						Restrictions.ilike("mu.droga.tipoDroga.nombre", (String)map.get(PanelBandejaHojaRemision.COLUMNA_PERSONA), MatchMode.ANYWHERE),
//						Restrictions.ilike("mu.especie.nombre", (String)map.get(PanelBandejaHojaRemision.COLUMNA_PERSONA), MatchMode.ANYWHERE)
//				));
//			
//			}
//			/*addILikeRestrictions(filtro, "destino", "de", "nombre", (String)map.get(PanelBandejaPericias.COLUMNA_DEPENDENCIA_DESTINO));
//			addBetweenGeLeRestrictions(filtro, "fechaPeritaje", (Date)map.get(PanelBandejaPericias.COLUMNA_FECHA_EMISION+TablaFiltro.KEY_INICIAL), 
//					(Date)map.get(PanelBandejaPericias.COLUMNA_FECHA_EMISION+TablaFiltro.KEY_FINAL));
//			addILikeRestrictions(filtro, "estado", (String)map.get(PanelBandejaPericias.COLUMNA_NUMERO));
//			*/
			
		}
		return casoHibernate.buscar(filtro);	
	}
 
	
}
