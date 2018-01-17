package Model;

import java.util.ArrayList;
import java.util.List;

public class RepositorioFuncionariosLista implements IRepositorioPessoas {

	private List<Funcionario> funcionarios;

	public RepositorioFuncionariosLista() {
		funcionarios = new ArrayList<Funcionario>();
	}
	
	public void adicionar(Pessoa u) {
		funcionarios.add((Funcionario) u);
		//System.out.println("Funcionario adicionado com sucesso!"); //implementado apenas para testar polimorfismo (estava testando se esse metodo adiciona um cliente)
	}
	
	public void remover(Pessoa u) {
		funcionarios.remove((Funcionario)u);
	}
	
	public boolean existe(Pessoa u) {
		if(this.funcionarios.contains(u))
			return true;
		return false;
	}

	public Pessoa buscar(Pessoa u) {
		for(Pessoa u2 : funcionarios) {
			if(u2.getId()==u.getId())
				return u2;
			
		}
		return null;
	}
	
	public Pessoa buscar(int id) {
		for(Pessoa u2 : funcionarios) {
			if(u2.getId()==id)
				return u2;
			
		}	// TODO Auto-generated method stub
		return null;
	}

	public Pessoa buscar(String email) {
		for(Pessoa u2 : funcionarios) {
			if(u2.getContato().getEmail()==email)
				return u2;
			
		}// TODO Auto-generated method stub
		return null;
	}

}
