package telas;

import dados.Funcionario;
import dados.Usuario;
import repositorios.RepositorioFuncionariosLista;

public class Programa {

	public static void main(String[] args) {
		System.out.println("Gerenciador movelaria");
		
		Usuario iann = new Funcionario("Iann", "iann@email.com", "9999-9999");
		
		RepositorioFuncionariosLista funcionarios = new RepositorioFuncionariosLista();
		
		funcionarios.adicionar(iann);
		
	}

}
