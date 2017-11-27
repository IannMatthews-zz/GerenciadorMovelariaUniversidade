package telas;

import dados.Cliente;
import dados.Marceneiro;
import dados.Orcamento;
import dados.Produto;
import dados.Usuario;
import dados.Venda;
import dados.Vendedor;
import repositorios.RepositorioClientesLista;
import repositorios.RepositorioFuncionariosLista;
import repositorios.RepositorioVendas;

public class TesteRealizarVenda {

	public static void main(String[] args) {
	
		RepositorioClientesLista clientes = new RepositorioClientesLista();
		RepositorioFuncionariosLista funcionarios = new RepositorioFuncionariosLista();
		RepositorioVendas vendas = new RepositorioVendas();
		
		Cliente c1 = new Cliente("cliente1", "cliente1@email", 81, 1111111);
		Vendedor v = new Vendedor("vendedor", "vendedor@email", 81, 1111111);
		Marceneiro m = new Marceneiro("marceneiro", "marceneiro@email", 81, 1111111);
		Orcamento orcamento = new Orcamento(c1,v,10);
		Produto produto = new Produto(orcamento, "rack", 10, 10,10,10,4,4, false);
		Venda venda = new Venda(produto);
		

		
		vendas.adicionar(venda);
		
		System.out.println(vendas.buscar(produto).isVendaConfirmada());
		System.out.println(vendas.buscar(produto).isOrcamentoPronto());
		System.out.println(vendas.buscar(produto).isProdutoEntregue());
		
		vendas.buscar(v).confirmarVenda();
		vendas.buscar(produto).adicionarOrcamento();
		vendas.buscar(produto).entregarProduto();
		
		System.out.println(vendas.buscar(produto).getPrazoDeEntrega());
		System.out.println(vendas.buscar(produto).isVendaConfirmada());
		System.out.println(vendas.buscar(produto).isOrcamentoPronto());
		System.out.println(vendas.buscar(produto).isProdutoEntregue());
		
		System.out.println("Cliente " + vendas.buscar(produto).getProduto().getOrcamento().getVendedor().getNome());
		System.out.println("Cliente " + vendas.buscar(produto).getProduto().getOrcamento().getCliente().getNome());

	}

}
