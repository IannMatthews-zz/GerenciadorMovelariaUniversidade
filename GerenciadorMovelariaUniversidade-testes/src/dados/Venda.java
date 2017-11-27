package dados;

public class Venda {

	private Produto produto;
	private Frete frete;
	private int prazoDeEntrega;
	private boolean vendaConfirmada;
	private boolean orcamentoPronto;
	private boolean producaoIniciada;
	private boolean produtoEntregue;
	
	
	
	
	public Venda(Produto produto) {
		this.produto = produto;
		this.vendaConfirmada = false;
		this.orcamentoPronto = false;
		this.producaoIniciada = false;
		this.produtoEntregue = false;
	}
	
	
	public Produto getProduto() {
		return produto;
	}
	
	public int getPrazoDeEntrega() {
		return prazoDeEntrega;
	}
	
	public boolean isVendaConfirmada()
	{
		return vendaConfirmada;
	}
	public boolean isOrcamentoPronto() {
		return orcamentoPronto;
	}
	public boolean isProducaoIniciada() {
		return producaoIniciada;
	}
	public boolean isProdutoEntregue() {
		return produtoEntregue;
	}
	

	public void setFrete(Frete frete)
	{
		this.frete = frete;
	}
	public void setPrazoDeEntrega(int prazo)
	{
		this.prazoDeEntrega = prazo;
	}
	public void confirmarVenda()
	{
		this.vendaConfirmada = true;
	}
	public void adicionarOrcamento()
	{
		this.orcamentoPronto = true;
	}
	public void iniciarProducao()
	{
		this.producaoIniciada = true;
	}
	public void entregarProduto()
	{
		this.produtoEntregue = true;
	}
	
}
