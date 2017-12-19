package arquivos;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import dados.Cliente;

public class ArquivoClientes {
	private String nome;
	File pasta;
	private static ArquivoClientes instance;
	
	public static ArquivoClientes getInstance() {
		if(instance == null) {
			instance = new ArquivoClientes();
		}
		
		return instance;
	}
	
	
	public ArquivoClientes() {
		pasta = new File("Clientes");
		pasta.mkdir();
	}
	
	public void criarArquivo(String nome) throws IOException {
		this.setNome(nome + ".txt");
		File arq = new File(pasta + "/" + this.getNome());
		arq.createNewFile();
	}
	
	public void fazerBackup(Cliente cliente) throws IOException {
		String nomeArquivo = "Cliente" + cliente.getId();
		this.criarArquivo(nomeArquivo);
		
		File arq = new File(pasta + "/" + this.getNome());
		FileWriter fw = new FileWriter(arq);
		BufferedWriter bw = new BufferedWriter(fw);
		
		bw.write(cliente.getId() + "\n");
		bw.write(cliente.getNome() + "\n");
		bw.write(cliente.getContato().getEmail() + "\n");
		bw.write(cliente.getContato().getDDD() + "\n");
		bw.write(cliente.getContato().getNumero() + "\n");
		bw.write(cliente.getEndereco().getCEP() + "\n");
		bw.write(cliente.getEndereco().getEndereco() + "\n");
		bw.write(cliente.getEndereco().getLatitude() + "\n");
		bw.write(cliente.getEndereco().getLongitude() + "\n");
		
		bw.flush();
		
	}
	
	
	public String getNome() {
		return this.nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
}
