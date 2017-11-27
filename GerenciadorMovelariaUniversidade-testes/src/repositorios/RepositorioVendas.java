package repositorios;

import java.util.ArrayList;

import dados.Marceneiro;
import dados.Produto;
import dados.Venda;
import dados.Vendedor;
import interfaces.IRepositorioVendas;
public class RepositorioVendas implements IRepositorioVendas {

	private ArrayList<Venda> vendas;
	
	public RepositorioVendas ()
	{
		this.vendas = new ArrayList<Venda>();
	}

	public void adicionar(Venda venda)
	{
		this.vendas.add(venda);
	}

	public void remover(Venda venda) 
	{
		this.vendas.remove(venda);
	}

	public boolean existe(Venda venda) 
	{
		if(vendas.contains(venda))
			return true;
		return false;
	}

	public Venda buscar(Marceneiro m) {
		for(Venda venda : vendas) {
			if(venda.getProduto().getOrcamento().getMarceneiro().getId() == m.getId())
			{
				return venda;
			}
		}
		return null;
		
	}

	public Venda buscar(Vendedor v) {
		for(Venda venda : vendas) {
			if(venda.getProduto().getOrcamento().getVendedor().equals(v));
			{
				return venda;
			}
		}
		return null;
	}

	public Venda buscar(Produto produto) {
		for(Venda venda : vendas) {
			if(venda.getProduto().equals(produto))
			{
				return venda;
			}
		}
		return null;
	}
	
	
}
