package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.Fachada;
import javafx.collections.FXCollections;

import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.EnumSet;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;

import Model.Cliente;
import Model.Fabrica;
import Model.MesaDeCantoRedonda;
import Model.PessoaNaoEncontradaException;
import Model.Produto;
import Model.Produto.Cor;
import Model.Venda;
import Model.Vendedor;

import javax.swing.JList;
import javax.swing.JScrollBar;
import java.awt.Component;;

public class Vendas extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField tfAltura;
	private JTextField tfDiametro;
	private JTextField tfNomeDoCliente;
	JList JlistaDeProdutos = new JList();
	final JPanel panel_NovaVenda = new JPanel();
	private DefaultListModel<String> modeloPesquisa = new DefaultListModel<String>();
	
	
	private DefaultListModel<String> modeloAdicionarProduto = new DefaultListModel<String>();
	private ArrayList<Produto> listaDeProdutos = new ArrayList<Produto>();
	ArrayList<Cor> corList = new ArrayList<Cor>(EnumSet.allOf(Cor.class));
	private Fabrica fabrica = new Fabrica();
	private static Vendas instance;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Vendas frame = new Vendas();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	

	/**
	 * Create the frame.
	 */
	public Vendas() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 750, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		JPanel panel_Vendas = new JPanel();
		panel_Vendas.setBounds(10, 11, 714, 400);
		contentPane.add(panel_Vendas);
		panel_Vendas.setLayout(null);
		
		JLabel lblVendas = new JLabel("Vendas");
		lblVendas.setBounds(291, 11, 131, 75);
		panel_Vendas.add(lblVendas);
		lblVendas.setFont(new Font("Tahoma", Font.PLAIN, 32));
		
		JPanel panel_pesquizar = new JPanel();
		panel_pesquizar.setBounds(10, 24, 200, 75);
		panel_Vendas.add(panel_pesquizar);
		panel_pesquizar.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Pesquisar");
		lblNewLabel.setBounds(10, 11, 61, 14);
		panel_pesquizar.add(lblNewLabel);
		
		JButton btnListarVendas = new JButton("Listar Vendas");
		btnListarVendas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_NovaVenda.setVisible(false);
				pesquisar();
				
			}
		});
		btnListarVendas.setBounds(20, 36, 180, 23);
		panel_pesquizar.add(btnListarVendas);
		
		textField = new JTextField();
		textField.setBounds(71, 8, 119, 20);
		panel_pesquizar.add(textField);
		textField.setColumns(10);
		
		panel_NovaVenda.setVisible(false);
		panel_NovaVenda.setBounds(220, 97, 484, 292);
		panel_Vendas.add(panel_NovaVenda);
		panel_NovaVenda.setLayout(null);
		
		JLabel lblNomeDoCliente = new JLabel("Nome do Cliente:");
		lblNomeDoCliente.setBounds(5, 11, 91, 14);
		panel_NovaVenda.add(lblNomeDoCliente);
		
		JRadioButton rdbtnMesaDeCanto = new JRadioButton("Mesa de Canto");
		rdbtnMesaDeCanto.setBounds(5, 32, 109, 23);
		panel_NovaVenda.add(rdbtnMesaDeCanto);
		
		JPanel panel_AdicionarProduto = new JPanel();
		panel_AdicionarProduto.setBounds(4, 147, 258, 145);
		panel_NovaVenda.add(panel_AdicionarProduto);
		panel_AdicionarProduto.setLayout(null);
		
		JLabel lblAltura = new JLabel("Altura:");
		lblAltura.setBounds(10, 11, 58, 14);
		panel_AdicionarProduto.add(lblAltura);
		
		JLabel lblDiametro = new JLabel("Diametro:");
		lblDiametro.setBounds(10, 36, 74, 14);
		panel_AdicionarProduto.add(lblDiametro);
		
		JLabel lblCorDoTampo = new JLabel("Cor do tampo:");
		lblCorDoTampo.setBounds(10, 61, 74, 14);
		panel_AdicionarProduto.add(lblCorDoTampo);
		
		JLabel lblCorDosPes = new JLabel("Cor dos pes:");
		lblCorDosPes.setBounds(10, 86, 74, 14);
		panel_AdicionarProduto.add(lblCorDosPes);
		
		tfAltura = new JTextField();
		tfAltura.setBounds(78, 8, 119, 20);
		panel_AdicionarProduto.add(tfAltura);
		tfAltura.setColumns(10);
		
		tfDiametro = new JTextField();
		tfDiametro.setColumns(10);
		tfDiametro.setBounds(78, 33, 119, 20);
		panel_AdicionarProduto.add(tfDiametro);
		
		final JComboBox<Cor> cbCorTampo = new JComboBox<Cor>();
		cbCorTampo.setBounds(94, 58, 103, 20);
		panel_AdicionarProduto.add(cbCorTampo);
		
		final JComboBox <Cor>cbCorPe = new JComboBox<Cor>();
		cbCorPe.setBounds(94, 83, 103, 20);
		panel_AdicionarProduto.add(cbCorPe);
		
		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adcionarProduto(fabrica.getProduto(Double.parseDouble(tfAltura.getText()), Double.parseDouble(tfDiametro.getText()), cbCorPe.getItemAt(cbCorPe.getSelectedIndex()), cbCorTampo.getItemAt(cbCorTampo.getSelectedIndex())));
				
			}
		});
		btnAdicionar.setBounds(10, 114, 187, 23);
		panel_AdicionarProduto.add(btnAdicionar);
		
		JPanel panel_FinalizarVenda = new JPanel();
		panel_FinalizarVenda.setBounds(272, 10, 202, 282);
		panel_NovaVenda.add(panel_FinalizarVenda);
		panel_FinalizarVenda.setLayout(null);
		
		JButton btnNewButton = new JButton("Finalizar Venda");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					finalizarVenda();
				} catch (PessoaNaoEncontradaException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(10, 242, 181, 29);
		panel_FinalizarVenda.add(btnNewButton);
		
		JButton btnRemover = new JButton("Remover");
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				removerProduto();
			}
		});
		btnRemover.setBounds(10, 208, 89, 23);
		panel_FinalizarVenda.add(btnRemover);
		
		JlistaDeProdutos.setBounds(0, 0, 192, 197);
		JlistaDeProdutos.setModel(modeloAdicionarProduto);
		panel_FinalizarVenda.add(JlistaDeProdutos);
		
		tfNomeDoCliente = new JTextField();
		tfNomeDoCliente.setBounds(106, 8, 156, 20);
		panel_NovaVenda.add(tfNomeDoCliente);
		tfNomeDoCliente.setColumns(10);
		
		
		JButton btnNovaVenda = new JButton("Nova Venda");
		btnNovaVenda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_NovaVenda.setVisible(true);
	
				preencherComboCores(cbCorPe);
				preencherComboCores(cbCorTampo);
				
				
			}
		});
		btnNovaVenda.setBounds(10, 110, 200, 60);
		panel_Vendas.add(btnNovaVenda);
		
		JButton btnCancelarVenda = new JButton("CancelarVenda");
		btnCancelarVenda.setEnabled(false);
		btnCancelarVenda.setBounds(10, 181, 200, 60);
		panel_Vendas.add(btnCancelarVenda);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setEnabled(false);
		btnExcluir.setBounds(10, 252, 200, 60);
		panel_Vendas.add(btnExcluir);
	}
	

	
	
	
	public static Vendas getInstance() {
		if(Vendas.instance == null) {
			Vendas.instance = new Vendas();
		}
		return Vendas.instance;
	}
	
	public void preencherComboCores(JComboBox cb) {
		for(Cor cor: corList) {
			cb.addItem(cor);
		}
	}

	public void adcionarProduto(Produto p) {
		modeloAdicionarProduto.addElement(p.getNome() +" "+ p.getPreco()+"Altura: "+ ((MesaDeCantoRedonda)p).getAltura()+"Diametro: "+((MesaDeCantoRedonda)p).getDiametro());
		listaDeProdutos.add(p);
	}
	public void removerProduto()
	{
		listaDeProdutos.remove(JlistaDeProdutos.getSelectedIndex());
		modeloAdicionarProduto.removeElementAt(JlistaDeProdutos.getSelectedIndex());
	}
	
	public void finalizarVenda() throws PessoaNaoEncontradaException {
		Cliente cliente = Fachada.getInstance().buscarCliente(tfNomeDoCliente.getText());
		Vendedor vendedor = Fachada.getInstance().buscarVendedor(1);
		Fachada.getInstance().adicionar(fabrica.getVenda(listaDeProdutos,cliente , vendedor, null, 5));
		listaDeProdutos.clear();
		modeloAdicionarProduto.clear();
	}
	
	public void pesquisar() {
		for(Venda v: Fachada.getInstance().buscarVendas())
			modeloPesquisa.addElement(v.getCliente().getNome());
	}
}
