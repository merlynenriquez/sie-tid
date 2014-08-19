package pe.gob.mininter.dirandro.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.mininter.dirandro.dao.hibernate.DepartamentoHibernate;
import pe.gob.mininter.dirandro.model.Departamento;
import pe.gob.mininter.dirandro.model.Valor;
import pe.gob.mininter.dirandro.service.DepartamentoService;

@Service
@Transactional
public class DepartamentoServiceImpl extends BaseServiceImpl<Departamento, Long> implements DepartamentoService {
	
	private static final long serialVersionUID = -5986305360207245244L;

	private DepartamentoHibernate departamentoHibernate;

	@Autowired
	protected DepartamentoServiceImpl(DepartamentoHibernate departamentoHibernate) {
		super(departamentoHibernate);
		this.departamentoHibernate = departamentoHibernate;
	}

	public List<Departamento> listarTodos() {
		List<Departamento> listaDepartamentos = new ArrayList<Departamento>();
		listaDepartamentos = departamentoHibernate.obtenerTodos();
		return listaDepartamentos;
	}

	@Override
	public void registrarDepartamento(Departamento departamento) {
		departamentoHibernate.crear(departamento);

	}

	@Override
	public void registrarDepartamento(List<Departamento> listaDepartamento, Valor estado) {
		if(listaDepartamento!=null){
			for (Departamento depa : listaDepartamento) {
				depa.setEstado(estado);
				Departamento departamento = departamentoHibernate.obtener(depa.getId());
				if (departamento != null) {
					departamento.setEstado(depa.getEstado());
					departamento.setNombre(depa.getNombre());
					super.actualizar(departamento);
				} else {
					super.crear(depa);
				}
			}
		}
	}

	@Override
	public void inactivarRegistros(List<Departamento> listaDepartamento, Valor estado) {
		List<Departamento> departamentoBD = departamentoHibernate.obtenerTodos();
		if(departamentoBD.size()>0){
			for(Departamento departamento:departamentoBD){
				if(!existeRegistro(listaDepartamento, departamento)){
					departamento.setEstado(estado);
					super.actualizar(departamento);
				}
			}
		}
	}
	
	private boolean existeRegistro(List<Departamento> listaDepartamento, Departamento departamento){
		if(listaDepartamento.size()>0){
			for(Departamento depa:listaDepartamento){
				if(depa.getId().compareTo(departamento.getId())==0){
					return true;
				}
			}
		}
		return false;
	}
}
