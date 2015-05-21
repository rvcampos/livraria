package br.hebert.fiap.livraria.dao;

import java.sql.SQLException;

public class UsuarioDAO extends BaseDAO {

	public UsuarioDAO() throws SQLException {
		super();
		// TODO Auto-generated constructor stub
	}

	private static final String sqlSelecionaUsuarioPorLogin = "SELECT * FROM USUARIO where login = ?";
	private static final String sqlUpdateSenhaUsuario = "SELECT * FROM USUARIO where login = ?";
}
