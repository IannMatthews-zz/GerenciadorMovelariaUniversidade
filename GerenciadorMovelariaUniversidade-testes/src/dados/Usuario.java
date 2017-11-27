package dados;

public abstract class Usuario {
	private static int geradorId;
	private int id;
	private String nome;
	private Localizacao endereco;
	Contato contato; 
	
	public Usuario(String nome, String email, int ddd, int numero) {
		geradorId++;
		this.id = geradorId;
		this.setNome(nome);
		//.alterado para adicao do objeto contato
		contato = new Contato(email,ddd, numero );
		
		endereco = new Localizacao();
	}

	public static int getGeradorId() {
		return geradorId;
	}

	public static void setGeradorId(int geradorId) {
		Usuario.geradorId = geradorId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Localizacao getEndereco() {
		return endereco;
	}

	public void setEndereco(Localizacao endereco) {
		this.endereco = endereco;
	}

	public Contato getContato() {
		return contato;
	}

	public void setContato(Contato contato) {
		this.contato = contato;
	}
	


}
