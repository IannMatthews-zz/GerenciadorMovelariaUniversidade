package interfaces;


import dados.Cliente;
import dados.Produto;

public interface iVendedor {

	//vendas
	void solicitarOrcamento(Produto produto);
	void agendarVisita(Cliente cliente);
	void confimarVenda(Produto produto);
	void venderProduto(Produto produto);
	
	//outras informacoes
	void  verSaldoAReceber();
	void  verHistoricoDeVendas();
	void  socilitarPagamento();
	void  verHistoricoDePagamentos();
}
