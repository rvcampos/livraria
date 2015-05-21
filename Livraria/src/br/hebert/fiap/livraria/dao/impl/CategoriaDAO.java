package br.hebert.fiap.livraria.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import br.hebert.fiap.livraria.dao.BaseDAO;
import br.hebert.fiap.livraria.dao.CategoriaDAOInterface;
import br.hebert.fiap.livraria.model.Categoria;
import br.hebert.fiap.livraria.util.DBUtils;

public class CategoriaDAO extends BaseDAO implements CategoriaDAOInterface {

	private final Logger logger = Logger.getLogger(this.getClass().getName());

	private static final String sqlInsertCategoria = "INSERT INTO CATEGORIA (nome) VALUES (?)";
	private static final String sqlVerificaDuplicidade = "SELECT 1 FROM CATEGORIA WHERE lower(nome) = lower(?)";
	private static final String sqlListarCategorias = "SELECT * FROM CATEGORIA";
	private static final String sqlDeletarCategoria = "DELETE CATEGORIA WHERE id_categoria = ?";

	public CategoriaDAO() throws SQLException {
		super();
	}

	/* (non-Javadoc)
	 * @see br.hebert.fiap.livraria.dao.CategoriaDAOInterface#listarCategorias()
	 */
	@Override
	public List<Categoria> listarCategorias() {
		PreparedStatement pstm = null;
		ResultSet rs = null;
		List<Categoria> lista = new ArrayList<Categoria>();
		try {
			pstm = conn.prepareStatement(sqlListarCategorias);
			rs = pstm.executeQuery();
			while (rs.next()) {
				Categoria cat = new Categoria();
				cat.setId(rs.getInt("idCategoria"));
				cat.setNome(rs.getString("nome"));
				lista.add(cat);
			}
		} catch (Exception e) {
			logger.throwing(this.getClass().getName(), "listarCategorias", e);
		} finally {
			DBUtils.close(pstm);
			DBUtils.close(rs);
		}
		return lista;
	}

	/* (non-Javadoc)
	 * @see br.hebert.fiap.livraria.dao.CategoriaDAOInterface#inserirCategoria(java.lang.String)
	 */
	@Override
	public boolean inserirCategoria(String nome) {
		PreparedStatement pstm = null;

		try {
			pstm = conn.prepareStatement(sqlInsertCategoria);
			pstm.setString(1, nome);
			return pstm.executeUpdate() > 0;
		} catch (Exception e) {
			logger.throwing(this.getClass().getName(), "inserirCategoria", e);
		} finally {
			DBUtils.close(pstm);
		}
		return false;
	}

	/* (non-Javadoc)
	 * @see br.hebert.fiap.livraria.dao.CategoriaDAOInterface#verificaDuplicidade(java.lang.String)
	 */
	@Override
	public boolean verificaDuplicidade(String nome) {
		PreparedStatement pstm = null;
		ResultSet rs = null;

		try {
			pstm = conn.prepareStatement(sqlVerificaDuplicidade);
			pstm.setString(1, nome);
			rs = pstm.executeQuery();
			return rs.next();
		} catch (Exception e) {
			logger.throwing(this.getClass().getName(), "verificaDuplicidade", e);
		} finally {
			DBUtils.close(pstm);
			DBUtils.close(rs);
		}
		return false;
	}

	@Override
	public boolean deleteCategoria(Integer idCategoria) {
		PreparedStatement pstm = null;

		try {
			pstm = conn.prepareStatement(sqlDeletarCategoria);
			pstm.setInt(1, idCategoria);
			return pstm.executeUpdate() > 0;
		} catch (Exception e) {
			logger.throwing(this.getClass().getName(), "deleteCategoria", e);
		} finally {
			DBUtils.close(pstm);
		}
		return false;
	}

}
