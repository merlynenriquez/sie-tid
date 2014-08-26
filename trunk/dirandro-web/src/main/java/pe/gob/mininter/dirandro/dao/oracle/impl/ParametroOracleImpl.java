package pe.gob.mininter.dirandro.dao.oracle.impl;

import mx4j.log.Logger;

import org.springframework.stereotype.Repository;

import pe.gob.mininter.dirandro.dao.oracle.ParametroOracle;
import pe.gob.mininter.dirandro.model.Parametro;

@Repository
public class ParametroOracleImpl extends BaseOracleImpl implements ParametroOracle {

	private static final long serialVersionUID = 3235540191658803094L;
	
	@Override
	public void actualizar(Parametro object) {
		
		String sql = "UPDATE " + obtenerObjetoBBDD("CFG_PARAMETRO") + " " +
				"SET CODIGO=?, NOMBRE=?, DESCRIPCION=?, VALOR=?, ESTADO=?, EDITOR=?, EDICION=? " +
				"WHERE CODIGO=? ";
				jdbcTemplate.update(sql, 
				new Object[] {
				object.getCodigo(), 
				object.getNombre(),
				object.getDescripcion(),
				object.getValor(),
				object.getEstado().getId(),
				object.getEditor().getId(),
				object.getEdicion(),
				object.getCodigoAnterior()
				});
				System.out.println("sql="+sql.toString());
	}
	
}
