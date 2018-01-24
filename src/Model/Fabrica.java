package Model;

import java.util.ArrayList;

import Model.Produto.Cor;

public class Fabrica {

	public Fabrica() {

	}

	public Produto getProduto(double altura, double diametro, Cor pes, Cor tampo) {
		return new MesaDeCantoRedonda(altura, diametro, pes, tampo);
	}
	
	public Marceneiro getMarceneiro(String nome, String email, String senha, int ddd, int numero, Localizacao endereco) {
		return new Marceneiro(nome, email,senha, ddd, numero, endereco);
	}

	public Vendedor getVendedor(String nome, String email, String senha, int ddd, int numero, Localizacao endereco) {
		return new Vendedor(nome, email,senha, ddd, numero, endereco);
	}

	public Localizacao getLocalizacao(String endereco, int CEP) {
		return new Localizacao(endereco, CEP);
	}

	public Venda getVenda(ArrayList<Produto> produto, Cliente cliente, Vendedor vendedor, Frete frete,
			int prazoDeEntrega) {
		return new Venda(produto, cliente, vendedor, frete, prazoDeEntrega);
	}

	public Cliente getCliente(String nome, String email, int ddd, int numero, Localizacao endereco) {
		return new Cliente(nome, email, ddd, numero, endereco);		
				}
}
