package repositorios;

import java.util.ArrayList;
import java.util.List;

import dados.Produto;
import interfaces.IRepositorioProdutos;

public class RepositorioProdutosLista implements IRepositorioProdutos {
	private List<Produto> produtos;

	public RepositorioProdutosLista() {
		produtos = new ArrayList<Produto>();
	}
	
	public void adicionar(Produto produto) {
		produtos.add(produto);
	}

	public void remover(Produto produto) {
		if(this.existe(produto)) {
			produtos.remove(produto);
		}
	}
	
	public boolean existe(Produto produto) {
		if (produtos.contains(produto)) {
			return true;
		}
		return false;
	}

	public Produto buscar(Produto produto) {
		for(Produto p : produtos) {
			if(p.getId() == produto.getId()) {
				return p;
			}
		}
		return null;
	}

	public Produto buscar(int id) {
		for(Produto p : produtos) {
			if(p.getId() == id) {
				return p;
			}
		}
		return null;
	}

	public Produto buscar(String nome) {
		for(Produto p : produtos) {
			if(p.getNome() == nome) {
				return p;
			}
		}
		return null;
	}

}
