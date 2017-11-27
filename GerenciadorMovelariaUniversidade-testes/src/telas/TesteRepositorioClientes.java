package telas;

import dados.Cliente;
import repositorios.RepositorioClientesLista;

public class TesteRepositorioClientes {

	public static void main(String[] args) {
		
		RepositorioClientesLista clientes = new RepositorioClientesLista();
		
		Cliente c1 = new Cliente("1", "1@email", 11, 111111);
		Cliente c2 = new Cliente("2", "2@email", 22, 222222);
		Cliente c3 = new Cliente("3", "3@email", 33, 333333);
		//adicionar
		clientes.adicionar(c1);
		clientes.adicionar(c2);
		clientes.adicionar(c3);
		//imprimir id's
		System.out.println(c1.getId());
		System.out.println(c2.getId());
		System.out.println(c3.getId());
		//imprimir do repositorio
		System.out.println();
		System.out.println(clientes.buscar(c1).getId());
		System.out.println(clientes.buscar(c1).getNome());
		System.out.println("(" + clientes.buscar(c1).getContato().getDDD()+") "+ clientes.buscar(c1).getContato().getNumero() );
		System.out.println(clientes.buscar(c1).getContato().getEmail());
		
		System.out.println();
		System.out.println(clientes.buscar(c2).getId());
		System.out.println(clientes.buscar(c2).getNome());
		System.out.println("(" + clientes.buscar(c2).getContato().getDDD()+") "+ clientes.buscar(c2).getContato().getNumero() );
		System.out.println(clientes.buscar(c2).getContato().getEmail());
		
		System.out.println();
		System.out.println(clientes.buscar(c3).getId());
		System.out.println(clientes.buscar(c3).getNome());
		System.out.println("(" + clientes.buscar(c3).getContato().getDDD()+") "+ clientes.buscar(c3).getContato().getNumero() );
		System.out.println(clientes.buscar(c3).getContato().getEmail());
		
		// remover do repositorio
		clientes.remover(c2);
		if(clientes.existe(c2))
			System.out.println(clientes.buscar("2@email nao foi removido").getId());
		else
			System.out.println(c2.getId()+" removido!");
	}

}
