package br.hebert.fiap.livraria.dao;

import java.sql.SQLException;

import br.hebert.fiap.livraria.dao.impl.CategoriaDAO;
import br.hebert.fiap.livraria.dao.impl.testes.CategoriaDAOTestes;

public final class DAOFactory {
	
	private static final boolean testes = true;

	private DAOFactory() {
		// TODO Auto-generated constructor stub
	}
	
	public static CategoriaDAOInterface getCategoriaDAO() throws SQLException
	{
		if(testes)
		{
			return new CategoriaDAOTestes();
		}
		return new CategoriaDAO();
	}
}
