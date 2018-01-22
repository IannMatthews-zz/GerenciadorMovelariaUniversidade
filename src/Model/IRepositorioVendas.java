package Model;

import java.util.ArrayList;

public interface IRepositorioVendas {

	void adicionar(Venda venda);
	void remover(Venda venda);
	void cancelar(Venda venda);
	boolean existe(Venda venda);
	Venda buscar(Venda venda);
	ArrayList<Venda> buscar(Cliente cliente);
	ArrayList<Venda> buscar(Vendedor v);
}
