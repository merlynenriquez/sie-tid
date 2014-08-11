package pe.gob.mininter.dirandro.dao.oracle.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;

import pe.gob.mininter.dirandro.dao.oracle.BaseOracle;

public class BaseOracleImpl implements BaseOracle {
	
	private static final long serialVersionUID = -771641799162451923L;

	protected JdbcTemplate jdbcTemplate;
	
	@Value("SIETID")
	private String schema;

	@Override
	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public String obtenerObjetoBBDD(String objetoBBDD) {
		return schema+"."+objetoBBDD;
	}

}
