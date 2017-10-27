package repositorios;

import java.util.ArrayList;
import java.util.List;

import dados.Funcionario;
import dados.Usuario;
import interfaces.IRepositorioUsuarios;

public class RepositorioFuncionariosLista implements IRepositorioUsuarios {

	private List<Funcionario> funcionarios;

	public RepositorioFuncionariosLista() {
		funcionarios = new ArrayList<Funcionario>();
	}

	@Override
	public void adicionar(Usuario u) {
		funcionarios.add((Funcionario) u);
		//System.out.println("Funcionario adicionado com sucesso!"); //implementado apenas para testar polimorfismo (estava testando se esse metodo adiciona um cliente)
	}

	@Override
	public void remover(Usuario u) {
		funcionarios.remove((Funcionario)u);
	}

	@Override
	public boolean existe(Usuario u) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Usuario buscar(Usuario u) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario buscar(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario buscar(String email) {
		// TODO Auto-generated method stub
		return null;
	}

}
