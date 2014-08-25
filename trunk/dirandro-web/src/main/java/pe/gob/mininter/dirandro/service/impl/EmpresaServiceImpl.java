package pe.gob.mininter.dirandro.service.impl;

import java.util.List;

import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.mininter.dirandro.dao.hibernate.EmpresaHibernate;
import pe.gob.mininter.dirandro.model.Empresa;
import pe.gob.mininter.dirandro.service.EmpresaService;
import pe.gob.mininter.dirandro.util.Busqueda;

@Service
public class EmpresaServiceImpl extends BaseServiceImpl<Empresa, Long> implements EmpresaService{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2697106645391028183L;
	
	private EmpresaHibernate empresaHibernate;
	
	@Autowired
	public EmpresaServiceImpl(EmpresaHibernate empresaHibernate) {
		super(empresaHibernate);
		this.empresaHibernate = empresaHibernate;
	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void crear(Empresa object) {
		object.validar();
		Busqueda filtro = Busqueda.forClass(Empresa.class);
		//filtro.add(Restrictions.eq("nombres", object.getNombres()));
		/*if (PoliciaHibernate.buscar(filtro).size()>0) {
			throw new ValidacionException(
					Constante.CODIGO_MENSAJE.VALIDAR_Policia_EXISTENTE,
					new Object[] { object.getNombres() });
		}*/
		super.crear(object);
	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void actualizar(Empresa object) {
		object.validar();
		Busqueda filtro = Busqueda.forClass(Empresa.class);
		/*filtro.add(Restrictions.eq("nombres", object.getNombres()));
		filtro.add(Restrictions.not(Restrictions.eq("id", object.getId())));
		/*if (PoliciaHibernate.buscar(filtro).size()>0) {
			throw new ValidacionException(
					Constante.CODIGO_MENSAJE.VALIDAR_Policia_EXISTENTE,
					new Object[] { object.getNombres() });
		}*/
		empresaHibernate.actualizar(object);
	}

	public Empresa obtener(Long id){		
		return empresaHibernate.obtener(id);
	}

	@Override
	public List<Empresa> buscar(Empresa empresa) {
		
		Busqueda filtro = Busqueda.forClass(Empresa.class);
		
		if (empresa != null) {
			
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
			}*/
						
			if (empresa.getRazonSocial() != null && empresa.getRazonSocial().length() > 0) {
				filtro.add(Restrictions.ilike("razonSocial", empresa.getRazonSocial(), MatchMode.ANYWHERE));
			}
			else
			if (empresa.getRuc() != null && empresa.getRuc().length() > 0) {
				filtro.add(Restrictions.ilike("ruc", empresa.getRuc(), MatchMode.ANYWHERE));
			}
								
		}
		return empresaHibernate.buscar(filtro);		
	}

	@Override
	public List<Empresa> listarEmpresas() {
		Busqueda filtro = Busqueda.forClass(Empresa.class);
		filtro.createAlias("perPersona", "per");
		filtro.addOrder(Order.asc("per.nombres")); 
		return empresaHibernate.buscar(filtro);
	}
	
}
