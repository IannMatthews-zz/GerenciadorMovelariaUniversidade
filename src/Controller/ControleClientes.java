package Controller;

import Model.Cliente;
import Model.IRepositorioPessoas;
import Model.PessoaNaoEncontradaException;
import Model.RepositorioClientesLista;

public class ControleClientes {
	IRepositorioPessoas clientes = new RepositorioClientesLista();
	
	public void cadastrar(Cliente pessoa) {
		clientes.adicionar(pessoa);
	}
	
	public void apagar(Cliente pessoa) {
		clientes.remover(pessoa);
	}
	
	public boolean existe(Cliente pessoa) {
		return clientes.existe(pessoa);
	}
	
	public Cliente buscar(int id) throws PessoaNaoEncontradaException {
		return (Cliente) clientes.buscar(id);
	}
	
	public Cliente buscar(String email) throws PessoaNaoEncontradaException {
		return (Cliente) clientes.buscar(email);
	}
	
	public Cliente buscar(Cliente pessoa) throws PessoaNaoEncontradaException {
		return (Cliente) clientes.buscar(pessoa);
	}
}
