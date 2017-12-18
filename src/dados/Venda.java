package dados;

import java.util.ArrayList;

public class Venda {

	private ArrayList<Produto> produto;
	private Cliente cliente;
	private Vendedor vendedor;
	private Frete frete;
	private int prazoDeEntrega;
	private double valorVenda;
	private boolean produtoEntregue;
	private boolean vendaCancelada;
	
	public Venda(ArrayList<Produto> produto, Cliente cliente, Vendedor vendedor, Frete frete,
			int prazoDeEntrega) {
		super();
		this.produto = produto;
		this.cliente = cliente;//sem a necessidade de setCliente
		this.vendedor = vendedor;//sem a necessidade de setVendedor
		this.frete = frete;
		this.prazoDeEntrega = prazoDeEntrega;
		this.produtoEntregue = false;
		this.setVendaCancelada(false);
	}

	public ArrayList<Produto> getProduto() {
		return produto;
	}

	
	public void setProduto(ArrayList<Produto> produto) {
		this.produto = produto;
	}	
	public void setProduto(Produto produto)
	{
		this.produto.add(produto);
	}

	public void removerProduto(Produto produto)
	{
		if(!this.produtoEntregue)
			this.produto.remove(produto);
		
	}
	
	public Cliente getCliente() {
		return cliente;
	}


	public Vendedor getVendedor() {
		return vendedor;
	}

	public Frete getFrete() {
		return frete;
	}

	public void setFrete(Frete frete) {
		this.frete = frete;
	}

	public int getPrazoDeEntrega() {
		return prazoDeEntrega;
	}

	public void setPrazoDeEntrega(int prazoDeEntrega) {
		this.prazoDeEntrega = prazoDeEntrega;
	}

	public boolean isProdutoEntregue() {
		return produtoEntregue;
	}

	public void setProdutoEntregue() {
		this.produtoEntregue = true;
	}

	public boolean isVendaCancelada() {
		return vendaCancelada;
	}

	public void setVendaCancelada(boolean vendaCancelada) {
		this.vendaCancelada = vendaCancelada;
	}

	public double getValorVenda() {
		return valorVenda;
	}

	public void setValorVenda()
	{
		double preco = 0;
		for(Produto p : produto)
		{
			preco = preco + p.getPreco();
		}
		this.valorVenda = preco;
	}
	

}


