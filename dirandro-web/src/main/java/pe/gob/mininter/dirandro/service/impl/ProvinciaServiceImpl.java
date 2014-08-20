package pe.gob.mininter.dirandro.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.mininter.dirandro.dao.hibernate.DepartamentoHibernate;
import pe.gob.mininter.dirandro.dao.hibernate.ParametroHibernate;
import pe.gob.mininter.dirandro.dao.hibernate.ProvinciaHibernate;
import pe.gob.mininter.dirandro.dao.hibernate.UsuarioHibernate;
import pe.gob.mininter.dirandro.model.Provincia;
import pe.gob.mininter.dirandro.model.Valor;
import pe.gob.mininter.dirandro.service.ProvinciaService;

@Service
@Transactional
public class ProvinciaServiceImpl extends BaseServiceImpl<Provincia, Long> implements ProvinciaService{

	private static final long serialVersionUID = 3679415642634973429L;

	ProvinciaHibernate provinciaHibernate;
	
	@Autowired
	DepartamentoHibernate departamentoHibernate;
	
	@Autowired
	private ParametroHibernate parametroHibernate;
	
	@Autowired
	private UsuarioHibernate usuarioHibernate;
	
	@Autowired
	protected ProvinciaServiceImpl(ProvinciaHibernate provinciaHibernate) {
		super(provinciaHibernate);
		this.provinciaHibernate = provinciaHibernate;
	}

	public List<Provincia> listarTodos() {
		return null;
	}

	public void registrarProvincia(Provincia provincia) {
		
	}

	@Transactional(propagation=Propagation.REQUIRED)
	@Override
	public void registrarProvincia(List<Provincia> listaProvincia, Valor estado) {		
		if (listaProvincia!=null){
			for (Provincia prov:listaProvincia){			
				Long codigoDepartamento;			
				codigoDepartamento = prov.getId()/100L;
				prov.setDepartamento(departamentoHibernate.obtener(codigoDepartamento));
				prov.setEstado(estado);
				if (prov.getDepartamento() != null){
					Provincia provincia = provinciaHibernate.obtener(prov.getId()) ;
					if (provincia != null){
						provincia.setDepartamento(prov.getDepartamento());
						provincia.setNombre(prov.getNombre());
						provincia.setEstado(prov.getEstado());
						super.actualizar(provincia);
					}else{
						super.crear(prov);
					}				
				}			 
			}
		}		
	}

	@Override
	public void inactivarRegistros(List<Provincia> listaProvincia, Valor estado) {
		List<Provincia> provinciasBD = provinciaHibernate.obtenerTodos();
		if(provinciasBD.size()>0){
			for(Provincia provincia:provinciasBD){
				if(!existeRegistro(listaProvincia, provincia)){
					provincia.setEstado(estado);
					super.actualizar(provincia);
				}
			}
		}
	}
	
	private boolean existeRegistro(List<Provincia> listaProvincia, Provincia provincia){
		if(listaProvincia.size()>0){
			for(Provincia prov:listaProvincia){
				if(prov.getId().compareTo(provincia.getId())==0){
					return true;
				}
			}
		}
		return false;
	}
}
