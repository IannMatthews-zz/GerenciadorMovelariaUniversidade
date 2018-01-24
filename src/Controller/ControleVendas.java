package Controller;

import java.util.ArrayList;

import Model.Cliente;
import Model.IRepositorioVendas;
import Model.RepositorioVendas;
import Model.Venda;
import Model.Vendedor;

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
	
	public ArrayList<Venda>buscar()
	{
		return this.vendas.buscar();
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
	public void entregarProdutos(Venda venda)
	{
		vendas.buscar(venda).isProdutoEntregue();

	}
}
