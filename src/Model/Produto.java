package Model;

public class Produto {

	private static int contadorId;
	private int id;
	private String nome;
	private double preco;

	
	public Produto(String nome) {
		this.id = Produto.contadorId++;
		setNome(nome);
	}
	
	public int getId() {
		return this.id;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}
	

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	

	public enum Cor {
		BRANCO(0), PRETO(1), AMARELO(2), AMARELO_BRILHO(3), VERMELHO(4), VERMELHO_BRILHO(5) ,
		MADEIRADO(6);
		private int cor;
		
		Cor(int cor) {
			this.cor = cor;
			
		}
		
		public int getCor() {
			return cor;
		}
		
	}
	}
