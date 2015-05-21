package br.hebert.fiap.livraria.dao;

import java.sql.Connection;
import java.sql.SQLException;

import br.hebert.fiap.livraria.util.DBUtils;

public class BaseDAO {

	protected Connection conn;

	public BaseDAO() throws SQLException {
		this.conn = DBUtils.getConnection();
	}
	
	public void close()
	{
		DBUtils.close(conn);
	}
}
