package telas;

import dados.Funcionario;
import dados.Produto;
import dados.Usuario;
import dados.Venda;
import dados.Vendedor;
import repositorios.RepositorioFuncionariosLista;

public class Programa {

	public static void main(String[] args) {
		System.out.println("Gerenciador movelaria");
		
		Funcionario iann = new Vendedor("Iann", "iann@email.com",81,99999999);
		
		Venda venda01 = new Venda(new Produto(null,"Estante",2,2,2,2,0,4,true));
		
		
		
		RepositorioFuncionariosLista funcionarios = new RepositorioFuncionariosLista();
		
		funcionarios.adicionar(iann);
		
	}

}
