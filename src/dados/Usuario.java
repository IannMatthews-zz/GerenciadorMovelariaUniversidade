package dados;

public abstract class Usuario {
	private static int geradorId;
	private int id;
	private String nome;
	private String email;
	private String telefone;
	
	public Usuario(String nome, String email, String telefone) {
		geradorId++;
		this.id = geradorId;
		this.setNome(nome);
		this.setEmail(email);
		this.setTelefone(telefone);
	}
	
	public int getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	private void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	private void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	private void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	
}
