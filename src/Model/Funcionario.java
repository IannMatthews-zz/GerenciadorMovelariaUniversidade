package Model;

public class Funcionario extends Pessoa {

	private String senha;
	
	public Funcionario(String nome, String email, String senha, int ddd, int numero, Localizacao endereco)  {
		super(nome, email, ddd, numero, endereco);
		
		setSenha(senha);
	}
	
	protected String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public boolean ValidaSenha(String senha){
		if(getSenha().equals(senha))
			return true;
		return false;
		
	}

}
