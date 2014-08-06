package pe.gob.mininter.dirandro.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.stereotype.Component;

import pe.gob.mininter.dirandro.model.Valor;

@Component
public class ValorMapper implements ParameterizedRowMapper<Valor> {

	@Override
	public Valor mapRow(ResultSet rs, int rowNum) throws SQLException {
		Valor valor=new Valor();
		valor.setId(rs.getLong("id"));
		valor.setCodigo(rs.getString("codigo"));
		valor.setNombre(rs.getString("nombre"));
		valor.setDescripcion(rs.getString("descripcion"));
		valor.setEstado(rs.getString("estado"));
		return valor;
	}

}
