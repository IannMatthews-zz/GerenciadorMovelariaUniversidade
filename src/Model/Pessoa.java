package Model;

public abstract class Pessoa {
	private static int geradorId;
	private int id;
	private String nome;
	private Localizacao endereco;
	Contato contato;

	public Pessoa(String nome, String email, int ddd, int numero, Localizacao endereco) {
		geradorId++;
		this.id = geradorId;
		this.setNome(nome);
		// .alterado para adicao do objeto contato
		contato = new Contato(email, ddd, numero);

		this.endereco = endereco;
	}

	public Pessoa(int id, String nome, String email, int ddd, int numero, Localizacao endereco) {
//		if (id >= geradorId) {
			this.setId(id);
			this.setNome(nome);
			// .alterado para adicao do objeto contato
			contato = new Contato(email, ddd, numero);

			this.endereco = endereco;
//		}
	}

	public static int getGeradorId() {
		return geradorId;
	}

	public static void setGeradorId(int geradorId) {
		Pessoa.geradorId = geradorId;
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
