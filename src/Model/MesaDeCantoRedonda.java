package Model;

public class MesaDeCantoRedonda extends Produto{

	private final String NOME = "Mesa de canto Redonda";
	private double altura;
	private double diametro;
	
	//criar enum cores
	/**Cores pes;
	Cores tampo;
	**/
	public MesaDeCantoRedonda(double altura, double diameatro /*Cores pes, Cores tampo*/) {
		super();
		this.altura = altura;
		this.diametro = diameatro;
		/*this.tampo = tampo;
		 * this.pes=pes;
		 */
		
	}
	
	public double getAltura() {
		return altura;
	}
	public void setAltura(double altura) {
		this.altura = altura;
	}
	public double getDiametro() {
		return diametro;
	}
	public void setDiametro(double diametro) {
		this.diametro = diametro;
	}

	public String getNOME() {
		return NOME;
	}
	

}
