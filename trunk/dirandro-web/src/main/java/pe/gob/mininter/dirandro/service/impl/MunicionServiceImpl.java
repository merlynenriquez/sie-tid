package pe.gob.mininter.dirandro.service.impl;

import java.util.List;

import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.mininter.dirandro.dao.hibernate.MunicionHibernate;
import pe.gob.mininter.dirandro.model.Municion;
import pe.gob.mininter.dirandro.service.MunicionService;
import pe.gob.mininter.dirandro.util.Busqueda;

@Service
public class MunicionServiceImpl extends BaseServiceImpl<Municion, Long> implements MunicionService{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6214909808376225533L;
	private MunicionHibernate municionHibernate; 
	
	@Autowired
	public MunicionServiceImpl(MunicionHibernate municionHibernate) {
		super(municionHibernate);
		this.municionHibernate = municionHibernate;
	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void crear(Municion object) {
		object.validar();
		//Busqueda filtro = Busqueda.forClass(Municion.class);
		//filtro.add(Restrictions.eq("nombres", object.get));
		/*if (PoliciaHibernate.buscar(filtro).size()>0) {
			throw new ValidacionException(
					Constante.CODIGO_MENSAJE.VALIDAR_Policia_EXISTENTE,
					new Object[] { object.getNombres() });
		}*/
		municionHibernate.crear(object);
	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void actualizar(Municion object) {
		object.validar();
		//Busqueda filtro = Busqueda.forClass(Municion.class);
		/*filtro.add(Restrictions.eq("nombres", object.getNombres()));
		filtro.add(Restrictions.not(Restrictions.eq("id", object.getId())));
		/*if (PoliciaHibernate.buscar(filtro).size()>0) {
			throw new ValidacionException(
					Constante.CODIGO_MENSAJE.VALIDAR_Policia_EXISTENTE,
					new Object[] { object.getNombres() });
		}*/
		municionHibernate.actualizar(object);
	}

	@Override
	public List<Municion> buscar(Municion municion) {
		Busqueda filtro = Busqueda.forClass(Municion.class);
		if (municion != null) {
			
			if (municion.getCalibre() != null && municion.getCalibre().getId()!=null) {
				filtro.add(Restrictions.eq("calibre.id", municion.getCalibre().getId()));
			}
			if (municion.getTipo() != null && municion.getTipo().getId()!=null) {
				filtro.add(Restrictions.eq("tipo.id", municion.getTipo().getId()));
			}
			if (municion.getTipoMedida() != null && municion.getTipoMedida().getId()!=null) {
				filtro.add(Restrictions.eq("tipoMedida.id", municion.getTipoMedida().getId()));
			}
			if (municion.getDescripcion()!= null && municion.getDescripcion().length() > 0) {
				filtro.add(Restrictions.ilike("descripcion", municion.getDescripcion(), MatchMode.ANYWHERE));
			}
			
		}
		return municionHibernate.buscar(filtro);		
	}
	
}
