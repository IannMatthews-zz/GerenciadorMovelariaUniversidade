package Model;

import java.util.ArrayList;

import Model.Produto.Cor;

public class Fabrica {

	public Fabrica()
	{
		
		
	}
	public Produto getProduto (double altura, double diametro, Cor pes, Cor tampo)
	{
		return new MesaDeCantoRedonda(altura, diametro, pes, tampo);
	}
	
	public Vendedor getVendedor ( String nome, String email, int ddd, int numero, Localizacao endereco)
	{
		return new Vendedor(nome, email, ddd, numero, endereco);
	}
	
	public Localizacao getLocalizacao(String endereco, int CEP) {
		return new Localizacao(endereco, CEP);
	}
	
	public Venda getVenda(ArrayList<Produto> produto, Cliente cliente, Vendedor vendedor, Frete frete,int prazoDeEntrega)
	{
		return new Venda(produto, cliente, vendedor, frete, prazoDeEntrega);
	}
}
