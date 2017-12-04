package fachada;

import controle.ControleClientes;
import dados.Cliente;
import dados.Usuario;

public class Fachada {
	private ControleClientes clientes;
	
	public Fachada() {
		clientes = new ControleClientes();
	}
	
	private static Fachada instance;

	public Fachada getInstance() {
		if(Fachada.instance == null) {
			Fachada.instance = new Fachada();
		}
		return Fachada.instance;
	}
	
	public void cadastrar(Usuario usuario) {
		clientes.cadastrar(usuario);
	}
	
	public void apagar(Usuario usuario) {
		clientes.apagar(usuario);
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
