package pe.gob.mininter.dirandro.service.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.gob.mininter.dirandro.dao.hibernate.HojaRemisionHibernate;
import pe.gob.mininter.dirandro.model.Hojaremision;
import pe.gob.mininter.dirandro.service.HojaRemisionService;
import pe.gob.mininter.dirandro.util.Busqueda;
import pe.gob.mininter.dirandro.vaadin.panel.bandeja.PanelBandejaHojaRemision;
import pe.gob.mininter.dirandro.vaadin.util.TablaFiltro;

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

	@Override
	public List<Hojaremision> buscarBandeja(Map<String, Object> map) {
		Busqueda filtro = Busqueda.forClass(Hojaremision.class);
		if(map!=null){
			addILikeRestrictions(filtro, "numero", (String)map.get(PanelBandejaHojaRemision.COLUMNA_NUMERO));
			addILikeRestrictions(filtro, "tipoHr", "th", "nombre", (String)map.get(PanelBandejaHojaRemision.COLUMNA_TIPO_HR));
			addILikeRestrictions(filtro, "expediente", "ex", "autogenerado", (String)map.get(PanelBandejaHojaRemision.COLUMNA_EXPEDIENTE));
			addILikeRestrictions(filtro, "origen", "or", "nombre", (String)map.get(PanelBandejaHojaRemision.COLUMNA_DEPENDENCIA_REMITE));
			addILikeRestrictions(filtro, "destino", "de", "nombre", (String)map.get(PanelBandejaHojaRemision.COLUMNA_DEPENDENCIA_DESTINO));
			addBetweenGeLeRestrictions(filtro, "fechaEmision", (Date)map.get(PanelBandejaHojaRemision.COLUMNA_FECHA_EMISION+TablaFiltro.KEY_INICIAL), 
					(Date)map.get(PanelBandejaHojaRemision.COLUMNA_FECHA_EMISION+TablaFiltro.KEY_FINAL));
			addBetweenGeLeRestrictions(filtro, "fechaTraslado", (Date)map.get(PanelBandejaHojaRemision.COLUMNA_FECHA_TRASLADO+TablaFiltro.KEY_INICIAL), 
					(Date)map.get(PanelBandejaHojaRemision.COLUMNA_FECHA_TRASLADO+TablaFiltro.KEY_FINAL));
			if(StringUtils.isNotBlank((String)map.get(PanelBandejaHojaRemision.COLUMNA_PERSONA))) {
				
				filtro.createAlias("conductor", "co");
							
				filtro.add(Restrictions.or(
						Restrictions.ilike("co.nombres", (String)map.get(PanelBandejaHojaRemision.COLUMNA_PERSONA), MatchMode.ANYWHERE),
						Restrictions.ilike("co.apePaterno", (String)map.get(PanelBandejaHojaRemision.COLUMNA_PERSONA), MatchMode.ANYWHERE),
						Restrictions.ilike("co.apeMaterno", (String)map.get(PanelBandejaHojaRemision.COLUMNA_PERSONA), MatchMode.ANYWHERE)
						));
			}
			addILikeRestrictions(filtro, "nroLicencia", (String)map.get(PanelBandejaHojaRemision.COLUMNA_NRO_LICENCIA));
			addILikeRestrictions(filtro, "oficio", (String)map.get(PanelBandejaHojaRemision.COLUMNA_OFICIO));
			addILikeRestrictions(filtro, "vehiculoMarca", "ve", "nombre", (String)map.get(PanelBandejaHojaRemision.COLUMNA_VEHICULO_MARCA));
			addILikeRestrictions(filtro, "vehiculoPlaca", (String)map.get(PanelBandejaHojaRemision.COLUMNA_VEHICULO_PLACA));
			addILikeRestrictions(filtro, "motivoTraslado", (String)map.get(PanelBandejaHojaRemision.COLUMNA_MOTIVO_TRASLADO));
			addBetweenGeLeRestrictions(filtro, "fechaRecepcion", (Date)map.get(PanelBandejaHojaRemision.COLUMNA_FECHA_RECEPCION+TablaFiltro.KEY_INICIAL), 
					(Date)map.get(PanelBandejaHojaRemision.COLUMNA_FECHA_RECEPCION+TablaFiltro.KEY_FINAL));
			if(StringUtils.isNotBlank((String)map.get(PanelBandejaHojaRemision.COLUMNA_COSTO_TRASLADO))){
				filtro.add(Restrictions.eq("costoTraslado", new BigDecimal((String)map.get(PanelBandejaHojaRemision.COLUMNA_COSTO_TRASLADO))));
			}
			if(StringUtils.isNotBlank((String)map.get(PanelBandejaHojaRemision.COLUMNA_CUSTODIO))) {
				
				filtro.createAlias("custodio", "cu");
				filtro.createAlias("cu.persona", "pe");
							
				filtro.add(Restrictions.or(
						Restrictions.ilike("pe.nombres", (String)map.get(PanelBandejaHojaRemision.COLUMNA_CUSTODIO), MatchMode.ANYWHERE),
						Restrictions.ilike("pe.apePaterno", (String)map.get(PanelBandejaHojaRemision.COLUMNA_CUSTODIO), MatchMode.ANYWHERE),
						Restrictions.ilike("pe.apeMaterno", (String)map.get(PanelBandejaHojaRemision.COLUMNA_CUSTODIO), MatchMode.ANYWHERE)
						));
			}
			addILikeRestrictions(filtro, "observacion", (String)map.get(PanelBandejaHojaRemision.COLUMNA_OBSERVACION));
			
			
			
		}
		return hojaDeRemisionHibernate.buscar(filtro);	
	}

	
}
