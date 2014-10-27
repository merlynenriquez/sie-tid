package pe.gob.mininter.dirandro.service.impl;

import java.util.List;

import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.mininter.dirandro.dao.hibernate.ExpedientePersonaHibernate;
import pe.gob.mininter.dirandro.model.DetExpedientePersona;
import pe.gob.mininter.dirandro.model.Expediente;
import pe.gob.mininter.dirandro.model.Persona;
import pe.gob.mininter.dirandro.service.ExpedientePersonaService;
import pe.gob.mininter.dirandro.util.Busqueda;
import pe.gob.mininter.dirandro.util.HarecUtil;

@Service
public class ExpedientePersonaServiceImpl extends BaseServiceImpl<DetExpedientePersona, Long> implements ExpedientePersonaService {
	
	private static final long serialVersionUID = 2124806059954362807L;
	
	private ExpedientePersonaHibernate expPersonaHibernate;
	
	@Autowired
	public ExpedientePersonaServiceImpl(ExpedientePersonaHibernate expPersonaHibernate) {
		super(expPersonaHibernate);
		this.expPersonaHibernate = expPersonaHibernate;
	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void crear(DetExpedientePersona object) {
		//TODO: Validar las restricciones
		super.crear(object);
	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void actualizar(DetExpedientePersona object) {
		expPersonaHibernate.actualizar(object);
	}

	@Override
	public List<DetExpedientePersona> buscar(DetExpedientePersona expPersona) {
		Busqueda filtro = Busqueda.forClass(DetExpedientePersona.class);
		
		if(expPersona!=null){
			Persona persona = expPersona.getInvolucrado() ;
			if ( persona != null) {
			
				filtro.createAlias("involucrado", "p");
				
				if (persona.getTipoDocumento()!= null && HarecUtil.valorIdToEmpty( persona.getTipoDocumento() ) != null ) {
					filtro.createAlias("p.tipoDocumento", "t");
					filtro.add(Restrictions.eq("t.id", persona.getTipoDocumento().getId() ));				
				}
				if ( !HarecUtil.nullToEmpty( persona.getNroDocumento() ).equals("") ) {
					filtro.add(Restrictions.ilike("p.nroDocumento",persona.getNroDocumento(), MatchMode.ANYWHERE));
				}
				if (!HarecUtil.nullToEmpty( persona.getNombres() ).equals("") ) {
					filtro.add(Restrictions.ilike("p.nombres",persona.getNombres(), MatchMode.ANYWHERE));
				}
				if (!HarecUtil.nullToEmpty(persona.getApePaterno() ).equals("") ) {
					filtro.add(Restrictions.ilike("p.apePaterno",persona.getApePaterno(), MatchMode.ANYWHERE));
				}
				if (!HarecUtil.nullToEmpty(persona.getApeMaterno() ).equals("") ) {
					filtro.add(Restrictions.ilike("p.apeMaterno",persona.getApeMaterno(), MatchMode.ANYWHERE));
				}
				if (!HarecUtil.nullToEmpty(persona.getSexo() ).equals("") ) {
					filtro.add(Restrictions.like("p.sexo",persona.getSexo() ));
				}
				if (persona.getEstadoCivil()!= null) {
					filtro.createAlias("p.estadoCivil", "e");
					filtro.add(Restrictions.ilike("e.nombre", persona.getEstadoCivil().getNombre(), MatchMode.ANYWHERE));				
				}		
				if (persona.getNacionalidad()!= null) {
					filtro.createAlias("p.nacionalidad", "n");
					filtro.add(Restrictions.ilike("n.nombre", persona.getNacionalidad().getNombre(), MatchMode.ANYWHERE));				
				}
			}
			
			Expediente  expediente = expPersona.getExpediente();
			if(expediente!=null)
			{
				filtro.createAlias("expediente", "e");
				
				if ( expediente.getId()!=null) {
					filtro.add(Restrictions.eq("e.id", expediente.getId()));
				}
				if (expediente.getFechaRegistro() !=null){
					filtro.add(Restrictions.ge("e.fechaRegistro", expediente.getFechaRegistro()));
				}
				if (expediente.getFechaRegistroFinal() !=null){
					filtro.add(Restrictions.le("e.fechaRegistro", expediente.getFechaRegistroFinal()));
				}
			}
				
		}
		
		return expPersonaHibernate.buscar(filtro);		
	}

	@Override
	public List<DetExpedientePersona> buscarBusqueda(
			DetExpedientePersona expPersona) {
		Busqueda filtro = Busqueda.forClass(DetExpedientePersona.class);
		if(expPersona!=null){
			addILikeRestrictions(filtro, "involucrado", "i", "nombres", expPersona.getInvolucrado().getNombres());
			addILikeRestrictions(filtro, "empresaInvolucrada", "e", "razonSocial", expPersona.getEmpresaInvolucrada().getRazonSocial());
			addILikeRestrictions(filtro, "participacion", "p", "nombre", expPersona.getParticipacion().getNombre());
			//addILikeRestrictions(filtro, "participacion", "p", "nombre", expPersona.getTipoParticipacion());
			addILikeRestrictions(filtro, "estadoDato", "ed", "nombre", expPersona.getEstadoDato().getNombre());
			addILikeRestrictions(filtro, "expediente", "ex", "autogenerado", expPersona.getExpediente().getAutogenerado());
			addILikeRestrictions(filtro, "organizacion", "or", "nombre", expPersona.getOrganizacion().getNombre());
			addILikeRestrictions(filtro, "ocupacion", "oc", "nombre", expPersona.getOcupacion().getNombre());
			addILikeRestrictions(filtro, "situacion", "si", "nombre", expPersona.getSituacion().getNombre());
			addILikeRestrictions(filtro, "alias", expPersona.getAlias());
		}
		return expPersonaHibernate.buscar(filtro);
	}

	@Override
	public List<DetExpedientePersona> cargarIntervinientes(Expediente expediente) {
		Busqueda filtro = Busqueda.forClass(DetExpedientePersona.class);
		filtro.add(Restrictions.eq("expediente", expediente));
		return expPersonaHibernate.buscar(filtro);		
	}
	
}
