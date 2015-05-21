package br.hebert.fiap.livraria.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.hebert.fiap.livraria.model.Livro;
import br.hebert.fiap.livraria.util.DBUtils;

public class LivroDAO extends BaseDAO {

	public LivroDAO() throws SQLException {
		super();
	}

	public Livro getLivroPorId(String idLivro) {
		Livro livro = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;

		try {

		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			DBUtils.close(rs);
			DBUtils.close(pstm);
		}

		return livro;
	}
}
