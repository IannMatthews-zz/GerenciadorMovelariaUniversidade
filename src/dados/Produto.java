package dados;

public class Produto {

	private Orcamento orcamento;
	private String nome;
	private double largura;
	private double altura;
	private double profundidade;
	private int portas;
	private int rodas;
	private int gavetas;
	private boolean revestimentoTipoA;	
	
	
	public Produto(Orcamento orcamento, String nome, double largura, double altura, double profundidade, int portas,
			int rodas, int gavetas, boolean revestimentoTipoA) {
		this.orcamento = orcamento;
		this.nome = nome;
		this.largura = largura;
		this.altura = altura;
		this.profundidade = profundidade;
		this.portas = portas;
		this.rodas = rodas;
		this.gavetas = gavetas;
		this.revestimentoTipoA = revestimentoTipoA;
	}
	
	
	
	public Orcamento getOrcamento() {
		return orcamento;
	}
	public void setOrcamento(Orcamento orcamento) {
		this.orcamento = orcamento;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getLargura() {
		return largura;
	}
	public void setLargura(double largura) {
		this.largura = largura;
	}
	public double getAltura() {
		return altura;
	}
	public void setAltura(double altura) {
		this.altura = altura;
	}
	public double getProfundidade() {
		return profundidade;
	}
	public void setProfundidade(double profundidade) {
		this.profundidade = profundidade;
	}
	public int getPortas() {
		return portas;
	}
	public void setPortas(int portas) {
		this.portas = portas;
	}
	public int getRodas() {
		return rodas;
	}
	public void setRodas(int rodas) {
		this.rodas = rodas;
	}
	public int getGavetas() {
		return gavetas;
	}
	public void setGavetas(int gavetas) {
		this.gavetas = gavetas;
	}
	public boolean isRevestimentoTipoA() {
		return revestimentoTipoA;
	}
	public void setRevestimentoTipoA(boolean revestimentoTipoA) {
		this.revestimentoTipoA = revestimentoTipoA;
	}
	
}
