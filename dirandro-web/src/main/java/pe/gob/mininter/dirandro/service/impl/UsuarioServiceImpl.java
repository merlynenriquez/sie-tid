package pe.gob.mininter.dirandro.service.impl;

import java.util.List;

import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.mininter.dirandro.dao.hibernate.UsuarioHibernate;
import pe.gob.mininter.dirandro.dao.oracle.UsuarioOracle;
import pe.gob.mininter.dirandro.exception.ValidacionException;
import pe.gob.mininter.dirandro.model.Usuario;
import pe.gob.mininter.dirandro.service.UsuarioService;
import pe.gob.mininter.dirandro.util.Busqueda;
import pe.gob.mininter.dirandro.util.Constante;

@Service
public class UsuarioServiceImpl extends BaseServiceImpl<Usuario, Long> implements UsuarioService {
	
	private static final long serialVersionUID = 3585418496951268063L;	
	private UsuarioHibernate usuarioHibernate;
	
	@Autowired
	private UsuarioOracle usuarioOracle;	
	
	@Autowired
	public UsuarioServiceImpl(UsuarioHibernate usuarioHibernate) {
		super(usuarioHibernate);		
		this.usuarioHibernate = usuarioHibernate;
	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void crear(Usuario object) {
		object.validar();
		Busqueda filtro = Busqueda.forClass(Usuario.class);
		filtro.add(Restrictions.eq("usuario", object.getUsuario()));
		filtro.add(Restrictions.eq("nombres", object.getNombres()));
		filtro.add(Restrictions.eq("apePat", object.getApePat()));
		filtro.add(Restrictions.eq("apeMat", object.getApeMat()));
		if (usuarioHibernate.buscar(filtro).size()>0) {
			throw new ValidacionException(Constante.CODIGO_MENSAJE.VALIDAR_VALOR_EXISTENTE, new Object[] { object.getUsuario() });
		}
		super.crear(object);
	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void actualizar(Usuario object) {
		object.validar();
		Busqueda filtro = Busqueda.forClass(Usuario.class);
		filtro.add(Restrictions.eq("usuario", object.getUsuario() ));
		filtro.add(Restrictions.not(Restrictions.eq("id", object.getId())));
		
		if (usuarioHibernate.buscar(filtro).size()>0)
			throw new ValidacionException(Constante.CODIGO_MENSAJE.VALIDAR_VALOR_EXISTENTE, new Object[] { object.getUsuario() });
		
		usuarioHibernate.actualizar(object);		
	}	
	
	@Override
	public Usuario grabarUsuario(Usuario usuario) {
		Busqueda filtro = Busqueda.forClass(Usuario.class);
		filtro.add(Restrictions.eq("usuario", usuario.getUsuario()));
		List<Usuario> usuarios = usuarioHibernate.buscar(filtro);
		if(usuarios.size() == 0){
			usuario.setClave("*****");
			crear(usuario);
			return usuario;
		}
		else{
			Usuario usu = usuarios.get(0);
			usu.setCargo(usuario.getCargo());
			usu.setDescCargo(usuario.getDescCargo());
			actualizar(usu);
			return usu;
		}
	}	

	public Usuario obtenerUsuarioXRegistro(Usuario usuario){
		Busqueda filtro = Busqueda.forClass(Usuario.class);
		
		if (usuario != null) {
			if (usuario.getUsuario() != null) 
				filtro.add(Restrictions.eq("usuario", usuario.getUsuario()));
						
			if (usuario.getClave() != null) 
				filtro.add(Restrictions.eq("clave", usuario.getClave()));
		}			
		List<Usuario> lstUsuarios = usuarioHibernate.buscar(filtro);
		
		if (!lstUsuarios.isEmpty()) 
			return lstUsuarios.get(0);
		else
			return null;		
	}
	
	@Override
	public List<Usuario> obtenerTodos() {
		return usuarioOracle.obtenerTodos();
	}

	@Override
	public List<Usuario> buscar(Usuario usuario) {
		Busqueda filtro = Busqueda.forClass(Usuario.class);		
		if (usuario!=null){
			if(usuario.getUsuario()!= null){
				filtro.add(Restrictions.ilike("usuario",usuario.getUsuario(),MatchMode.ANYWHERE));
			}	
			if(usuario.getNombres()!= null){
				filtro.add(Restrictions.ilike("nombres",usuario.getNombres(),MatchMode.ANYWHERE));
				logger.debug("busca nombres");
			}
			if(usuario.getApePat() != null){
				filtro.add(Restrictions.ilike("apePat",usuario.getApePat(),MatchMode.ANYWHERE));
			}
			if(usuario.getApeMat() != null){
				filtro.add(Restrictions.ilike("apeMat",usuario.getApeMat(),MatchMode.ANYWHERE));
			}
			if(usuario.getCargo() != null){
				filtro.add(Restrictions.ilike("cargo",usuario.getCargo(),MatchMode.ANYWHERE));
			}
			if (usuario.getOficina()!= null) {
				if(usuario.getOficina().getNombre()!=null){
					filtro.createAlias("oficina", "ofi");
					filtro.add(Restrictions.ilike("ofi.nombre",usuario.getOficina().getNombre(),MatchMode.ANYWHERE));
				}
			}
		}
		filtro.addOrder(Order.asc("apePat"));
		filtro.addOrder(Order.asc("apeMat"));
		return this.usuarioHibernate.buscar(filtro);		
	}
}
