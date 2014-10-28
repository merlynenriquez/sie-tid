package pe.gob.mininter.dirandro.dao.oracle.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pe.gob.mininter.dirandro.dao.mapper.UsuarioMapper;
import pe.gob.mininter.dirandro.dao.oracle.ExpedienteOracle;
import pe.gob.mininter.dirandro.model.Dependencia;

@Repository
public class ExpedienteOracleImpl extends BaseOracleImpl implements ExpedienteOracle{
	
	private static final long serialVersionUID = -8804515043898862319L;
	
	@Autowired
	private UsuarioMapper usuarioMapper;
	
	@Override
	public Integer obtenerAutogenerado(Dependencia dependencia) {
		StringBuffer s_sql = new StringBuffer();
		s_sql.append("SELECT MAX(autogenerado)+1 FROM ");
		s_sql.append(obtenerObjetoBBDD("exp_dependencia")).append(" d where id ="+dependencia.getId());
		Integer result = jdbcTemplate.queryForInt(s_sql.toString());
		
		if (result > 0) {
			return result;
		}else {
			return null;
		}
	}
	
}
