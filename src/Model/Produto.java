package Model;

public class Produto {

	private static int contadorId;
	private int id;
	private double preco;

	
	public Produto() {
		this.id = Produto.contadorId++;
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
