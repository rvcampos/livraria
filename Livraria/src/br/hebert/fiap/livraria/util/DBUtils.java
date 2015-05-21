package br.hebert.fiap.livraria.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public final class DBUtils {

	private static InitialContext cxt;
	private static DataSource ds;
	static {
		try {
			cxt = new InitialContext();
			ds = (DataSource) cxt.lookup("java:/comp/env/jdbc/LivrariaDB");
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static Connection getConnection() throws SQLException {
		return ds.getConnection();
	}

	public static void close(ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (Exception e) {
			}
		}
	}

	public static void close(PreparedStatement pstm) {
		if (pstm != null) {
			try {
				pstm.close();
			} catch (Exception e) {
			}
		}
	}

	public static void close(Connection conn) {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
			}
		}
	}
}
