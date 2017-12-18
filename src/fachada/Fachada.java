package fachada;

import controle.ControleClientes;
import controle.ControleVendas;
import controle.ControleVendedores;
import dados.Cliente;
import dados.Vendedor;

public class Fachada {
	private ControleClientes clientes;
	private ControleVendedores vendedores;
	private ControleVendas vendas;
	
	public Fachada() {
		clientes = new ControleClientes();
		vendedores = new ControleVendedores();
	}
	
	private static Fachada instance;

	public Fachada getInstance() {
		if(Fachada.instance == null) {
			Fachada.instance = new Fachada();
		}
		return Fachada.instance;
	}
	
	public void cadastrar(Cliente cliente) {
		clientes.cadastrar(cliente);
	}
	public void cadastrar(Vendedor vendedor) {
		vendedores.cadastrar(vendedor);
	}

	public void apagar(Cliente cliente) {
		clientes.apagar(cliente);
	}
	public void apagar(Vendedor vendedor) {
		vendedores.apagar(vendedor);
	}
	
	
	public boolean existe(Cliente cliente) {
		return clientes.existe(cliente);
	}
	public boolean existe(Vendedor vendedor) {
		return vendedores.existe(vendedor);
	}
	
	public Cliente buscarCliente(int id) {
		return (Cliente) clientes.buscar(id);
	}

	public Vendedor buscarVendedor(int id)
	{
		return vendedores.buscar(id);
	}
	
	public Cliente buscarCliente(String email) {
		return (Cliente) clientes.buscar(email);
	}
	
	public Vendedor buscarVendedor(String email) {
		return (Vendedor) vendedores.buscar(email);
	}
	
	public Cliente buscarCliente(Cliente cliente) {
		return (Cliente) clientes.buscar(cliente);
	}
	
	public Vendedor buscarVendedor(Vendedor vendedor) {
		return (Vendedor) vendedores.buscar(vendedor);
	}
	
}
 