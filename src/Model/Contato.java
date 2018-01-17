package Model;

public class Contato
{

	private String email;
	private int DDD;
	private int numero;
	
	public Contato(String email, int dDD, int numero) {
		this.email = email;
		this.DDD = dDD;
		this.numero = numero;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getDDD() {
		return DDD;
	}
	public void setDDD(int dDD) {
		DDD = dDD;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	

}