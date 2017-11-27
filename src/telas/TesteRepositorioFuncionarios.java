package telas;

import dados.Cliente;
import dados.Funcionario;
import dados.Marceneiro;
import dados.Vendedor;
import repositorios.RepositorioClientesLista;
import repositorios.RepositorioFuncionariosLista;

public class TesteRepositorioFuncionarios {

	public static void main(String[] args) {
		
		RepositorioFuncionariosLista funcionarios = new RepositorioFuncionariosLista();
		
		Funcionario v = new Vendedor("vendedor", "v1@email", 11, 111111);
		Funcionario m = new Marceneiro("marceneiro", "m2@email", 22, 222222);
		
		//adicionar
		funcionarios.adicionar(v);
		funcionarios.adicionar(m);
	
		//imprimir id's
		System.out.println(v.getId());
		System.out.println(m.getId());
		
		//imprimir do repositorio
		System.out.println();
		System.out.println(funcionarios.buscar(v).getId());
		System.out.println(funcionarios.buscar(v).getNome());
		System.out.println("(" + funcionarios.buscar(v).getContato().getDDD()+") "+ funcionarios.buscar(v).getContato().getNumero() );
		System.out.println(funcionarios.buscar(v).getContato().getEmail());
		
		System.out.println();
		System.out.println(funcionarios.buscar(m).getId());
		System.out.println(funcionarios.buscar(m).getNome());
		System.out.println("(" + funcionarios.buscar(m).getContato().getDDD()+") "+ funcionarios.buscar(m).getContato().getNumero() );
		System.out.println(funcionarios.buscar(m).getContato().getEmail());
		
		System.out.println();

		// remover do repositorio
		funcionarios.remover(m);
		if(funcionarios.existe(m))
			System.out.println(funcionarios.buscar("2@email nao foi removido").getId());
		else
			System.out.println(m.getId()+" removido!");
	

	}

}
