package Model;

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
}
