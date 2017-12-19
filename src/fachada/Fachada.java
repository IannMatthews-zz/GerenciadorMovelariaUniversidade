package fachada;

import java.util.ArrayList;

import controle.ControleClientes;
import controle.ControleVendas;
import controle.ControleVendedores;
import dados.Cliente;
import dados.Venda;
import dados.Vendedor;

public class Fachada {
	private ControleClientes clientes;
	private ControleVendedores vendedores;
	private ControleVendas vendas;
	
	public Fachada() {
		clientes = new ControleClientes();
		vendedores = new ControleVendedores();
		vendas = new ControleVendas();
	}
	
	private static Fachada instance;

	public static Fachada getInstance() {
		if(Fachada.instance == null) {
			Fachada.instance = new Fachada();
		}
		return Fachada.instance;
	}
	
	//controleClientes
	public void cadastrar(Cliente cliente) {
		clientes.cadastrar(cliente);
	}
	
	public void apagar(Cliente cliente) {
		clientes.apagar(cliente);
	}
	
	public boolean existe(Cliente cliente) {
		return clientes.existe(cliente);
	}
	
	public Cliente buscarCliente(int id) {
		return (Cliente) clientes.buscar(id);
	}

	public Cliente buscarCliente(String email) {
		return (Cliente) clientes.buscar(email);
	}
	
	public Cliente buscarCliente(Cliente cliente) {
		return (Cliente) clientes.buscar(cliente);
	}
	
	
	//controleVendedores
	public void cadastrar(Vendedor vendedor) {
		vendedores.cadastrar(vendedor);
	}
	
	public void apagar(Vendedor vendedor) {
		vendedores.apagar(vendedor);
	}
	
	public boolean existe(Vendedor vendedor) {
		return vendedores.existe(vendedor);
	}
	
	public Vendedor buscarVendedor(int id)
	{
		return vendedores.buscar(id);
	}
	
	public Vendedor buscarVendedor(String email) {
		return (Vendedor) vendedores.buscar(email);
	}
	
	public Vendedor buscarVendedor(Vendedor vendedor) {
		return (Vendedor) vendedores.buscar(vendedor);
	}

	
	//controleVendas
	public void adicionar(Venda venda)
	{
		this.vendas.adicionar(venda);
	}
	
	public void remover(Venda venda)
	{
		this.vendas.remover(venda);
	}
	
	public void cancelar(Venda venda)
	{
		this.vendas.cancelar(venda);
	}
	
	public ArrayList<Venda> buscarVendas(Vendedor vendedor)
	{
		return this.vendas.buscar(vendedor);
	}
	
	public ArrayList<Venda> buscarVendas(Cliente cliente)
	{
		return this.vendas.buscar(cliente);
	}

	public void entregar(Venda venda)
	{
		this.vendas.entregarProdutos(venda);
	}
	
}
 