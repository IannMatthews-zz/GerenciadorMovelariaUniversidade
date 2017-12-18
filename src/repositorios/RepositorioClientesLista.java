package repositorios;

import java.util.ArrayList;
import java.util.List;

import dados.Cliente;
import dados.Pessoa;
import interfaces.IRepositorioPessoas;

public class RepositorioClientesLista implements IRepositorioPessoas {
	private List<Cliente> clientes = new ArrayList<Cliente>();

	
	public void adicionar(Pessoa u) {
		clientes.add((Cliente) u);
	}

	
	public void remover(Pessoa u) {
		if (this.existe(u)) {
			clientes.remove((Cliente) u);
		}
	}

	
	public boolean existe(Pessoa u) {
		if (clientes.contains(u)) {
			return true;
		}
		return false;
	}

	
	public Pessoa buscar(Pessoa u) {
		for(Cliente cliente : clientes) {
			if(cliente.getId() == u.getId()) {
				return cliente;
			}
		}
		return null;
	}

	
	public Pessoa buscar(int id) {
		for(Cliente cliente : clientes) {
			if(cliente.getId() == id) {
				return cliente;
			}
		}
		return null;
	}

	public Pessoa buscar(String email) {
		for(Cliente cliente : clientes) {
			if(cliente.getContato().getEmail() == email) {
				return cliente;
			}
		}
		return null;
	}

}
