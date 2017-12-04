package controle;

import dados.Cliente;
import dados.Usuario;
import interfaces.IRepositorioUsuarios;
import repositorios.RepositorioClientesLista;

public class ControleClientes {
	IRepositorioUsuarios clientes = new RepositorioClientesLista();
	
	public void cadastrar(Usuario usuario) {
		clientes.adicionar(usuario);
	}
	
	public void apagar(Usuario usuario) {
		clientes.remover(usuario);
	}
	
	public boolean existe(Usuario usuario) {
		return clientes.existe(usuario);
	}
	
	public Cliente buscar(int id) {
		return (Cliente) clientes.buscar(id);
	}
	
	public Cliente buscar(String email) {
		return (Cliente) clientes.buscar(email);
	}
	
	public Cliente buscar(Usuario usuario) {
		return (Cliente) clientes.buscar(usuario);
	}
}
