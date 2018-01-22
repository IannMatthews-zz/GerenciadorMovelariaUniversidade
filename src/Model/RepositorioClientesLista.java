package Model;

import java.util.ArrayList;
import java.util.List;

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

	public Pessoa buscar(Pessoa u) throws PessoaNaoEncontradaException {
		for (Cliente cliente : clientes) {
			if (cliente.getId() == u.getId()) {
				return cliente;
			}
		}
		throw new PessoaNaoEncontradaException("Cliente não encontrado");
	}

	public Pessoa buscar(int id) throws PessoaNaoEncontradaException {
		for (Cliente cliente : clientes) {
			if (cliente.getId() == id) {
				return cliente;
			}
		}
		throw new PessoaNaoEncontradaException("Cliente não encontrado");
	}

	public Pessoa buscar(String email) throws PessoaNaoEncontradaException {
		for (Cliente cliente : clientes) {
			if (cliente.getContato().getEmail().equals(email)) {
				return cliente;
			}
		}
		throw new PessoaNaoEncontradaException("Cliente não encontrado");
	}

	public void editar(Pessoa u) throws PessoaNaoEncontradaException {
		Pessoa cliente = buscar((u.getId() * (-1)));
		cliente.setNome(u.getNome());
		cliente.setContato(u.getContato());
		cliente.setEndereco(u.getEndereco());
	}

	

	

}
