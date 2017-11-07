package interfaces;


import dados.Orcamento;
import dados.Produto;
import dados.Venda;

public interface iMarceneiro {

	Orcamento calcularCusto(Produto produto);
	void adicionarProduto(Produto produto);
	void definirTempoDeproducao(Venda venda);
	
}
