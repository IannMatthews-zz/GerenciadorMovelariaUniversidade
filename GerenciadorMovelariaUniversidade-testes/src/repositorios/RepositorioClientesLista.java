package repositorios;

import java.util.ArrayList;
import java.util.List;

import dados.Cliente;
import dados.Usuario;
import interfaces.IRepositorioUsuarios;

public class RepositorioClientesLista implements IRepositorioUsuarios {
	private List<Cliente> clientes = new ArrayList<Cliente>();

	
	public void adicionar(Usuario u) {
		clientes.add((Cliente) u);
	}

	
	public void remover(Usuario u) {
		if (this.existe(u)) {
			clientes.remove((Cliente) u);
		}
	}

	
	public boolean existe(Usuario u) {
		if (clientes.contains(u)) {
			return true;
		}
		return false;
	}

	
	public Usuario buscar(Usuario u) {
		for(Cliente cliente : clientes) {
			if(cliente.getId() == u.getId()) {
				return cliente;
			}
		}
		return null;
	}

	
	public Usuario buscar(int id) {
		for(Cliente cliente : clientes) {
			if(cliente.getId() == id) {
				return cliente;
			}
		}
		return null;
	}

	public Usuario buscar(String email) {
		for(Cliente cliente : clientes) {
			if(cliente.getContato().getEmail() == email) {
				return cliente;
			}
		}
		return null;
	}

}
