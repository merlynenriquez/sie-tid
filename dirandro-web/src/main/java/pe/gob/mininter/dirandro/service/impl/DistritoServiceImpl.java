package pe.gob.mininter.dirandro.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.mininter.dirandro.dao.hibernate.DistritoHibernate;
import pe.gob.mininter.dirandro.dao.hibernate.ProvinciaHibernate;
import pe.gob.mininter.dirandro.model.Distrito;
import pe.gob.mininter.dirandro.model.Valor;
import pe.gob.mininter.dirandro.service.DistritoService;

@Service
@Transactional
public class DistritoServiceImpl extends BaseServiceImpl<Distrito, Long> implements DistritoService {

	private static final long serialVersionUID = 4719013859545989493L;

	private DistritoHibernate distritoHibernate;

	@Autowired
	private ProvinciaHibernate provinciaHibernate;
	
	@Autowired
	protected DistritoServiceImpl(DistritoHibernate distritoHibernate) {
		super(distritoHibernate);
		this.distritoHibernate = distritoHibernate;
	}

	public List<Distrito> listarTodos() {
		return null;
	}

	@Override
	public void registrarDistrito(Distrito distrito) {

	}

	@Override
	public void registrarDistrito(List<Distrito> listaDistrito, Valor estado) {
		if(listaDistrito!=null){
			for (Distrito dist : listaDistrito) {
				Long codigoProvincia;
				codigoProvincia = dist.getId() / 1000L;
				dist.setProvincia(provinciaHibernate.obtener(codigoProvincia));
				dist.setEstado(estado);
				if (dist.getProvincia() != null) {
					Distrito distrito = distritoHibernate.obtener(dist.getId());
					if (distrito != null) {
						distrito.setProvincia(dist.getProvincia());
						distrito.setNombre(dist.getNombre());
						distrito.setCodigoHost(dist.getCodigoHost());
						distrito.setEstado(dist.getEstado());
						super.actualizar(distrito);
					} else {
						super.crear(dist);
					}
				}
			}
		}
	}

	@Override
	public void inactivarRegistros(List<Distrito> listaDistrito, Valor estado) {
		List<Distrito> distritosBD = distritoHibernate.obtenerTodos();
		if(distritosBD.size()>0){
			for(Distrito distrito:distritosBD){
				if(!existeRegistro(listaDistrito, distrito)){
					distrito.setEstado(estado);
					super.actualizar(distrito);
				}
			}
		}
	}
	
	private boolean existeRegistro(List<Distrito> listaDistrito, Distrito distrito){
		if(listaDistrito.size()>0){
			for(Distrito dist:listaDistrito){
				if(dist.getId().compareTo(distrito.getId())==0){
					return true;
				}
			}
		}
		return false;
	}
}
