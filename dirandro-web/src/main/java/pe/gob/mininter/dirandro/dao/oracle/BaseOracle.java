package pe.gob.mininter.dirandro.dao.oracle;

import java.io.Serializable;

import org.springframework.jdbc.core.JdbcTemplate;

public interface BaseOracle extends Serializable {

	void setJdbcTemplate(JdbcTemplate jdbcTemplate);
	
	String obtenerObjetoBBDD(String objetoBBDD);
	
}
