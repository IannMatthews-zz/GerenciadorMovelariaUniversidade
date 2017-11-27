package dados;



public class Orcamento /*implements iVendedor, iMarceneiro*/ {

	private final double TAXA_DE_COMISSAO;
	private double valorVenda;
	private double valorCusto;
	private double valorComissaoVendedor;
	private Cliente cliente;
	private Vendedor vendedor;
	private Marceneiro marceneiro;
	
	
	public Orcamento(Cliente c1, Vendedor v, double taxaDeComissao) 
	{
		this.cliente = c1;
		this.vendedor = v;
		this.TAXA_DE_COMISSAO = taxaDeComissao;
	}
	public Orcamento(Marceneiro marceneiro, double taxaDeComissao)
	{
		this.marceneiro = marceneiro;
		this.TAXA_DE_COMISSAO = taxaDeComissao;

	}
	
	
	
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public Vendedor getVendedor() {
		return vendedor;
	}
	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}
	public Marceneiro getMarceneiro() {
		return marceneiro;
	}
	public void setMarceneiro(Marceneiro marceneiro) {
		this.marceneiro = marceneiro;
	}
	public double getValorVenda() {
		return valorVenda;
	}
	public double getValorCusto() {
		return valorCusto;
	}
	public double getValorComissaoVendedor() {		
		return valorComissaoVendedor;
	}
	
	
	
	// set  valorComissaoVendedor e valorVenda
	public void definirOrcamento(double valorCusto, Marceneiro marceneiro) {

		this.valorCusto = valorCusto;
		calcularValorVenda(this.valorCusto);
		calcularValorComissaoVendedor();
		this.marceneiro = marceneiro;
	}
	private void calcularValorComissaoVendedor()
	{
		this.valorComissaoVendedor =  valorVenda * TAXA_DE_COMISSAO;
	}
	private void calcularValorVenda(double custo)
	{
		this.valorVenda = custo * 2.5;
	}
	
	
}
