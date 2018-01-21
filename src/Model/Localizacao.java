package Model;

public class Localizacao {

	private String endereco;
	private int CEP;
	private double latitude;
	private double longitude;
	
	public Localizacao(String endereco, int CEP) {
		this.setEndereco(endereco);
		this.setCEP(CEP);
	}
	
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public int getCEP() {
		return CEP;
	}
	public void setCEP(int CEP) {
		this.CEP = CEP;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
}

