package teste;

import java.io.IOException;
import java.util.ArrayList;

import Controller.Fachada;
import Model.Cliente;
import Model.Frete;
import Model.Localizacao;
import Model.Produto;
import Model.Venda;
import Model.Vendedor;
import arquivos.ArquivoClientes;

public class Programa {

	public static void main(String[] args) {
		System.out.println("Gerenciador movelaria");
		
		Vendedor iann = new Vendedor("Iann", "iann@email.com",81,99999999);
		Vendedor bruno = new Vendedor("bruno", "bruno@email.com",81,99999999);
		Cliente c1 = new Cliente("cliente1", "cliente1@email.com",81,99999999);
		Cliente c2 = new Cliente("cliente2", "cliente2@email.com",81,99999999);
		ArrayList<Produto> produtosC1 = new ArrayList<Produto>();
		ArrayList<Produto> produtosC2 = new ArrayList<Produto>();
		
		produtosC2.add(new Produto());
		
		Venda v1 = new Venda(produtosC2, c2, bruno, new Frete(new Localizacao()), 5);
		Venda v2 = new Venda(produtosC1,c1,iann,null,5);
		
		Fachada.getInstance().cadastrar(c1);
		Fachada.getInstance().cadastrar(c2);
		
		Fachada.getInstance().cadastrar(bruno);
		Fachada.getInstance().cadastrar(iann);
		
		try {
			ArquivoClientes.getInstance().fazerBackup(c1);
			ArquivoClientes.getInstance().fazerBackup(c2);
		} catch (IOException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			System.out.println("Deu errado");
		}
		
		Fachada.getInstance().adicionar(v1);
		Fachada.getInstance().adicionar(v2);
		
		try {
			Cliente cliente = ArquivoClientes.getInstance().lerArquivo(3);
			System.out.println(cliente.getId() + "\n" + cliente.getNome());
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
//			System.out.println("Deu errado em conversão de numero");
		} catch (IOException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			System.out.println("deu errado IO");
		}
		System.out.println();
		
	}

}
