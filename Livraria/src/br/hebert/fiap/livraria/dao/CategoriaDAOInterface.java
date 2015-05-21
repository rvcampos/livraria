package br.hebert.fiap.livraria.dao;

import java.util.List;

import br.hebert.fiap.livraria.model.Categoria;

public interface CategoriaDAOInterface {

	/**
	 * Listar todas as categorias
	 * 
	 * @return
	 */
	public List<Categoria> listarCategorias();

	/**
	 * Método para inserir uma nova {@link Categoria}
	 * 
	 * @param nome
	 * @return
	 */
	public boolean inserirCategoria(String nome);

	/**
	 * Verifica se já existe uma {@link Categoria} com o mesmo nome
	 * 
	 * @param nome
	 * @return <code>true</code> quando existe uma categoria com o mesmo nome
	 */
	public boolean verificaDuplicidade(String nome);
	
	public void close();

}