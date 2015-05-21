package br.hebert.fiap.livraria.dao.impl.testes;

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

public class CategoriaDAOTestes implements CategoriaDAOInterface {

	private final Logger logger = Logger.getLogger(this.getClass().getName());
	private static final List<Categoria> categoriasDummy = new ArrayList<Categoria>();

	public CategoriaDAOTestes() {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.hebert.fiap.livraria.dao.CategoriaDAOInterface#listarCategorias()
	 */
	@Override
	public List<Categoria> listarCategorias() {
		if (categoriasDummy.isEmpty()) {
			for (int i = 0; i < 10; i++) {
				Categoria cat = new Categoria();
				cat.setId(i);
				cat.setNome("Categoria " + i);
				categoriasDummy.add(cat);
			}

		}
		return categoriasDummy;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * br.hebert.fiap.livraria.dao.CategoriaDAOInterface#inserirCategoria(java
	 * .lang.String)
	 */
	@Override
	public boolean inserirCategoria(String nome) {
		Categoria novaCat = new Categoria();
		novaCat.setId(categoriasDummy.size());
		novaCat.setNome(nome);
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * br.hebert.fiap.livraria.dao.CategoriaDAOInterface#verificaDuplicidade
	 * (java.lang.String)
	 */
	@Override
	public boolean verificaDuplicidade(String nome) {
		for (Categoria cat : categoriasDummy) {
			if (nome.toLowerCase().equals(cat.getNome().toLowerCase())) {
				return true;
			}
		}
		return false;
	}

	@Override
	public void close() {
		// TODO Auto-generated method stub

	}

}
