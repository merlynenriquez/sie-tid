package pe.gob.mininter.dirandro.service.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.mininter.dirandro.dao.hibernate.ExpedienteTelefonoHibernate;
import pe.gob.mininter.dirandro.model.DetPerTelExp;
import pe.gob.mininter.dirandro.model.Expediente;
import pe.gob.mininter.dirandro.model.Numero;
import pe.gob.mininter.dirandro.model.Telefono;
import pe.gob.mininter.dirandro.service.ExpedienteTelefonoService;
import pe.gob.mininter.dirandro.util.Busqueda;
import pe.gob.mininter.dirandro.util.HarecUtil;

@Service
public class ExpedienteTelefonoServiceImpl extends BaseServiceImpl<DetPerTelExp, Long> implements ExpedienteTelefonoService {
	
	private static final long serialVersionUID = 1893717123659192777L;
	
	private ExpedienteTelefonoHibernate expTelefonoHibernate;
	
	@Autowired
	public ExpedienteTelefonoServiceImpl(ExpedienteTelefonoHibernate expTelefonoHibernate) {
		super(expTelefonoHibernate);	
		this.expTelefonoHibernate = expTelefonoHibernate;
	}

	@Override
	public List<DetPerTelExp> buscar(DetPerTelExp detTelefono) {
		Busqueda filtro = Busqueda.forClass(DetPerTelExp.class);
		if(detTelefono!=null){
			logger.debug(" filtrando detalle");
			if(HarecUtil.valorIdToEmpty(detTelefono.getOperadora())!=null){
				logger.debug("operadora id "+detTelefono.getOperadora().getId());
				filtro.add(Restrictions.eq("operadora.id", detTelefono.getOperadora().getId()));
			}
			
			Telefono telefono = detTelefono.getEquipo();
			if(telefono !=null){
				
				if( HarecUtil.marcaModeloIdToEmpty( telefono.getMarca() )!=null ){
					filtro.createAlias("equipo", "eq");
					logger.debug("id equipo " + telefono.getMarca().getId());
					filtro.add(Restrictions.eq("eq.id", telefono.getMarca().getId()));
				}
				
			}
			
			Numero numero = detTelefono.getNumeroTelefonico();
			if( numero !=null ){
				
				if( !StringUtils.isEmpty(numero.getNumero()) ){
					filtro.createAlias("numeroTelefonico", "nu");
					logger.debug("numero " + numero.getNumero());
					filtro.add(Restrictions.ilike("nu.numero", numero.getNumero(), MatchMode.ANYWHERE));
				}
			}
			
			Expediente  expediente = detTelefono.getExpediente();
			if(expediente!=null)
			{
				if (expediente.getFechaRegistro() !=null || expediente.getFechaRegistroFinal() !=null){
					filtro.createAlias("expediente", "e");
					
					if (expediente.getFechaRegistro() !=null){
						filtro.add(Restrictions.ge("e.fechaRegistro", expediente.getFechaRegistro()));
					}
					if (expediente.getFechaRegistroFinal() !=null){
						filtro.add(Restrictions.le("e.fechaRegistro", expediente.getFechaRegistroFinal()));
					}	
				}
				
			}
		}
		return expTelefonoHibernate.buscar(filtro);
	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void crear(DetPerTelExp object) {
		super.crear(object);
	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void actualizar(DetPerTelExp object) {
		//Busqueda filtro = Busqueda.forClass(DetPerVehExp.class);
		expTelefonoHibernate.actualizar(object);
	}
}
