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
		super.crear(object);
	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void actualizar(Empresa object) {
		object.validar();		
		empresaHibernate.actualizar(object);
	}

	public Empresa obtener(Long id){		
		return empresaHibernate.obtener(id);
	}

	@Override
	public List<Empresa> buscar(Empresa empresa) {
		
		Busqueda filtro = Busqueda.forClass(Empresa.class);
		
		if (empresa != null) {
						
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
		filtro.addOrder(Order.asc("razonSocial")); 
		return empresaHibernate.buscar(filtro);
	}
	
}
