package pe.gob.mininter.dirandro.service.impl;

import java.util.List;
import java.util.Map;

import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.mininter.dirandro.dao.hibernate.PaisHibernate;
import pe.gob.mininter.dirandro.exception.ValidacionException;
import pe.gob.mininter.dirandro.model.Pais;
import pe.gob.mininter.dirandro.service.PaisService;
import pe.gob.mininter.dirandro.util.Busqueda;
import pe.gob.mininter.dirandro.util.Constante;
import pe.gob.mininter.dirandro.util.HarecUtil;

@Service
public class PaisServiceImpl extends BaseServiceImpl<Pais, Long> implements PaisService {
	
	private static final long serialVersionUID = -6887474707981937738L;
	
	private PaisHibernate paisHibernate;
	
	@Autowired
	protected PaisServiceImpl(PaisHibernate paisHibernate) {
		super(paisHibernate);		 
		this.paisHibernate = paisHibernate;
	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void actualizar(Pais object) {
		object.validar();
		if(object.getPadre()!=null && object.getPadre().getId()!=null){
			if(object.getId().equals(object.getPadre().getId())){
				throw new ValidacionException(Constante.CODIGO_MENSAJE.VALIDAR_BUCLE_PADRE, new Object[] { object.getNombre() });
			}
		}
		paisHibernate.actualizar(object);
	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void crear(Pais object) {		
		object.validar();
		super.crear(object);
	}

	@Override
	public List<Pais> buscar(Pais pais){
		Busqueda filtro = Busqueda.forClass(Pais.class);
		filtro.addOrder(Order.asc("nombre"));
		return paisHibernate.buscar(filtro);
	}

	@Override
	public Map<String, List<Pais>> listarPaises() {
		Busqueda filtro = Busqueda.forClass(Pais.class);
		filtro.addOrder(Order.asc("nombre"));		
		List<Pais> lstPaises = paisHibernate.buscar(filtro);
		return HarecUtil.ordenarPaises(lstPaises);
	}

	
}
