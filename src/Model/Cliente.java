package Model;

public class Cliente extends Pessoa {

	public Cliente(String nome, String email, int ddd, int numero)  {
		super(nome, email, ddd, numero);
	}
	
	
//	adicionado com id para pegar os arquivos de clientes
	public Cliente(int id, String nome, String email, int ddd, int numero)  {
		super(id, nome, email, ddd, numero);
	}

}
