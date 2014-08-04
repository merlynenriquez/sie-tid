package pe.gob.mininter.dirandro.interceptor.impl;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.aopalliance.intercept.MethodInvocation;
import org.springframework.stereotype.Component;

import pe.gob.mininter.dirandro.interceptor.AuditarInterceptor;

@Component("auditarInterceptor")
public class AuditarInterceptorImpl implements AuditarInterceptor, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2269463476088223892L;

	private final static String METODO_CREAR = "crear";
	private final static String METODO_ACTUALIZAR = "actualizar";
	private final static String METODO_GRABAR_TODOS = "grabarTodos";

	@SuppressWarnings({ "rawtypes" })
	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {

		/*if (validarInvocacion(invocation)) {
			Usuario usuario = HarecUtil.obtenerUsuarioSesion();
			Object parametro = invocation.getArguments()[0];
			Date fechaHora = new Date();
			if (METODO_CREAR.equals(invocation.getMethod().getName())) {
				((AuditoriaBean) parametro).setCreador(usuario);
				((AuditoriaBean) parametro).setCreacion(fechaHora);
			}
			if (METODO_ACTUALIZAR.equals(invocation.getMethod().getName())) {
				((AuditoriaBean) parametro).setEditor(usuario);
				((AuditoriaBean) parametro).setEdicion(fechaHora);
			}
			if (METODO_GRABAR_TODOS.equals(invocation.getMethod().getName())) {
				List auditoriaBeans = (List) parametro;
				for (Object obj : auditoriaBeans) {
					AuditoriaBean auditoriaBean;
					if (obj instanceof AuditoriaBean) {
						auditoriaBean = (AuditoriaBean) obj;
					} else {
						continue;
					}

					if (auditoriaBean.esNuevo()) {
						auditoriaBean.setCreador(usuario);
						auditoriaBean.setCreacion(fechaHora);
					} else {
						auditoriaBean.setEditor(usuario);
						auditoriaBean.setEdicion(fechaHora);
					}
				}
			}
		}*/
		return invocation.proceed();
	}

	private boolean validarInvocacion(MethodInvocation invocation) {
		/*if (invocation.getArguments().length == 1) {
			Object parametro = invocation.getArguments()[0];
			return (parametro instanceof AuditoriaBean || parametro instanceof List<?>)
					&& (METODO_CREAR.equals(invocation.getMethod().getName())
							|| METODO_ACTUALIZAR.equals(invocation.getMethod()
									.getName()) || METODO_GRABAR_TODOS
								.equals(invocation.getMethod().getName()));

		}*/
		return false;
	}

}
