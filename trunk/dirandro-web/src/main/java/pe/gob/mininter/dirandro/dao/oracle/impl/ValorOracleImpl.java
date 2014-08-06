package pe.gob.mininter.dirandro.dao.oracle.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pe.gob.mininter.dirandro.dao.mapper.ValorMapper;
import pe.gob.mininter.dirandro.dao.oracle.ValorOracle;
import pe.gob.mininter.dirandro.model.Valor;


@Repository
public class ValorOracleImpl extends BaseOracleImpl implements ValorOracle {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8130414329480736955L;
	@Autowired
	private ValorMapper valorMapper;

	@Override
	public List<Valor> obtenerxVector(Long valor1) {
		
		StringBuffer s_sql = new StringBuffer();
		
		s_sql.append("select va.id, va.codigo, va.nombre, va.orden, va.descripcion, va.estado from ");
		s_sql.append(obtenerObjetoBBDD("cfg_vector")).append(" v ");
		s_sql.append("inner join ").append(obtenerObjetoBBDD("cfg_valor")).append(" va on v.valor2=va.id ");
		s_sql.append("where v.valor1=? ");
		
		List<Valor> valores = jdbcTemplate.query(s_sql.toString(), valorMapper,valor1);
		
		return valores;
	}
	
}
