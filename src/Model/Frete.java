package Model;

public class Frete {
	
	Localizacao endereco;
	private double valorFrete;
	
	public Frete (Localizacao endereco)
	{
		this.endereco = endereco;
		
		/*this.valorFrete = pesquuisar api localizacao
		 * para calcular valor frete, mede-se distancia entre PONTO_DE_PARTIDA e this.endereco
		 */
	}
	public Localizacao getEndereco() {
		return endereco;
	}
	public void setEndereco(Localizacao endereco) {
		this.endereco = endereco;
	}
	public double getValorFrete() {
		return valorFrete;
	}
	public void setValorFrete(double valorFrete) {
		this.valorFrete = valorFrete;
	}
	

}
