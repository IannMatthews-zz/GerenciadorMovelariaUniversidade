package interfaces;

import dados.Produto;

public interface IRepositorioProdutos {
	void adicionar(Produto produto);
	void remover(Produto produto);
	boolean existe(Produto produto);
	Produto buscar(Produto produto);
	Produto buscar(int id);
	Produto buscar(String nome);
}
