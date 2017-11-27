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
	
	public void adicionar(Usuario u) {
		funcionarios.add((Funcionario) u);
		//System.out.println("Funcionario adicionado com sucesso!"); //implementado apenas para testar polimorfismo (estava testando se esse metodo adiciona um cliente)
	}
	
	public void remover(Usuario u) {
		funcionarios.remove((Funcionario)u);
	}
	
	public boolean existe(Usuario u) {
		if(this.funcionarios.contains(u))
			return true;
		return false;
	}

	public Usuario buscar(Usuario u) {
		for(Usuario u2 : funcionarios) {
			if(u2.getId()==u.getId())
				return u2;
			
		}
		return null;
	}
	
	public Usuario buscar(int id) {
		for(Usuario u2 : funcionarios) {
			if(u2.getId()==id)
				return u2;
			
		}	// TODO Auto-generated method stub
		return null;
	}

	public Usuario buscar(String email) {
		for(Usuario u2 : funcionarios) {
			if(u2.getContato().getEmail()==email)
				return u2;
			
		}// TODO Auto-generated method stub
		return null;
	}

}
