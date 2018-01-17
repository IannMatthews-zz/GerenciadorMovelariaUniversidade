package Controller;

import Model.Cliente;
import Model.IRepositorioPessoas;
import Model.Pessoa;
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
	
	public Cliente buscar(int id) {
		return (Cliente) clientes.buscar(id);
	}
	
	public Cliente buscar(String email) {
		return (Cliente) clientes.buscar(email);
	}
	
	public Cliente buscar(Cliente pessoa) {
		return (Cliente) clientes.buscar(pessoa);
	}
}
