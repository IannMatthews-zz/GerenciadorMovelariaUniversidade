package teste;

import java.util.ArrayList;

import dados.Cliente;
import dados.Funcionario;
import dados.Produto;
import dados.Usuario;
import dados.Venda;
import dados.Vendedor;
import fachada.Fachada;
import repositorios.RepositorioFuncionariosLista;

public class Programa {

	public static void main(String[] args) {
		Fachada fachada = Fachada.getInstance();
		System.out.println("Gerenciador movelaria");
		
		Vendedor iann = new Vendedor("Iann", "iann@email.com",81,99999999);
		Vendedor bruno = new Vendedor("bruno", "bruno@email.com",81,99999999);
		Cliente c1 = new Cliente("cliente1", "cliente1@email.com",81,99999999);
		Cliente c2 = new Cliente("cliente2", "cliente2@email.com",81,99999999);
		ArrayList<Produto> produtosC1 = new ArrayList<Produto>();
		ArrayList<Produto> produtosC2 = new ArrayList<Produto>();
		
		Venda v1 = new Venda(produtosC2, c2, bruno, null, 5);
		Venda v2 = new Venda(produtosC1,c1,iann,null,5);
		
		fachada.cadastrar(c1);
		fachada.cadastrar(c2);
		
		fachada.cadastrar(bruno);
		fachada.cadastrar(iann);
		
		fachada.adicionar(v1);
		fachada.adicionar(v2);
		
	}

}
