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
	
	}
