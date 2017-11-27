package interfaces;

import dados.Marceneiro;
import dados.Produto;
import dados.Venda;
import dados.Vendedor;

public interface IRepositorioVendas {

	void adicionar(Venda venda);
	void remover(Venda venda);
	boolean existe(Venda venda);
	Venda buscar(Marceneiro m);
	Venda buscar(Vendedor v);
	Venda buscar(Produto produto);
}
