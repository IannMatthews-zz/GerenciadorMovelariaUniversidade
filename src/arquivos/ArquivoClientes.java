package arquivos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import Model.Cliente;
import Model.Contato;
import Model.Localizacao;

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
		this.setNome(nome + ".clnt");
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
	
	public Cliente lerArquivo(int id) throws NumberFormatException, IOException {
		Cliente cliente;
		
		File arq = new File(pasta + "/Cliente" + id + ".clnt");
		FileReader fr = new FileReader(arq);
		BufferedReader br = new BufferedReader(fr);
		
		int idCliente = Integer.parseInt(br.readLine());
		String nomeCliente = br.readLine();
		
		String emailCliente = br.readLine();
		int DDDCliente = Integer.parseInt(br.readLine());
		int numeroCliente = Integer.parseInt(br.readLine());
		
		Localizacao endereco = new Localizacao();
		endereco.setCEP(Integer.parseInt(br.readLine()));
		endereco.setEndereco(br.readLine());
		endereco.setLatitude(Double.parseDouble(br.readLine()));
		endereco.setLongitude(Double.parseDouble(br.readLine()));
		
		cliente = new Cliente(idCliente,nomeCliente, emailCliente, DDDCliente, 
				numeroCliente, endereco);
		
		//br.close();
		return cliente;
	}
	
	
	public String getNome() {
		return this.nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
}
