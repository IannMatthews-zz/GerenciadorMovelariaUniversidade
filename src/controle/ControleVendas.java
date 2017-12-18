package controle;

import java.util.ArrayList;

import dados.Cliente;
import dados.Venda;
import dados.Vendedor;
import interfaces.IRepositorioVendas;
import repositorios.RepositorioVendas;

public class ControleVendas {

	IRepositorioVendas vendas = new RepositorioVendas();
	
	
	public void adicionar(Venda venda)
	{
		this.vendas.adicionar(venda);
	}
	public void remover(Venda venda)
	{
		this.vendas.remover(venda);
	}
	public ArrayList<Venda> buscar(Vendedor vendedor)
	{
		return this.vendas.buscar(vendedor);
	}
	public ArrayList<Venda> buscar(Cliente cliente)
	{
		return this.vendas.buscar(cliente);
	}
	public void cancelar(Venda venda)
	{
		vendas.buscar(venda).isVendaCancelada();
	}
}
