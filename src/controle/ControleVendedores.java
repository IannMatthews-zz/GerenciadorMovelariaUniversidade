package controle;


import dados.Venda;
import dados.Vendedor;
import interfaces.IRepositorioPessoas;
import repositorios.RepositorioFuncionariosLista;

public class ControleVendedores {
	
		IRepositorioPessoas vendedores = new RepositorioFuncionariosLista();
		
		public void cadastrar(Vendedor pessoa) {
			vendedores.adicionar(pessoa);
		}
		
		public void apagar(Vendedor pessoa) {
			vendedores.remover(pessoa);
		}
		
		public boolean existe(Vendedor pessoa) {
			return vendedores.existe(pessoa);
		}
		
		public Vendedor buscar(int id) {
			return (Vendedor) vendedores.buscar(id);
		}
		
		public Vendedor buscar(String email) {
			return (Vendedor) vendedores.buscar(email);
		}
		
		public Vendedor buscar(Vendedor pessoa) {
			return (Vendedor) vendedores.buscar(pessoa);
		}
}
