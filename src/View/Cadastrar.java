package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.Fachada;
import Model.Cliente;
import Model.Fabrica;
import Model.Localizacao;
import Model.Marceneiro;
import Model.Vendedor;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ButtonGroup;

public class Cadastrar extends JFrame {

	private JPanel contentPane;
	private JTextField tfNome;
	private JTextField txtEmail;
	private JTextField txtDDD;
	private JTextField txtNumero;
	private JTextField txtEndereco;
	private JTextField txtCep;
	private JPasswordField senha;
	private JPasswordField repetirSenha;

	JRadioButton rdbtnCliente = new JRadioButton("Cliente");
	JRadioButton rdbtnVendedor = new JRadioButton("Vendedor");
	JRadioButton rdbtnMarceneiro = new JRadioButton("Marceneiro");

	private static Cadastrar instance;
	// private Fabrica fabrica = new Fabrica();
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cadastrar frame = new Cadastrar();
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
	public Cadastrar() {
		setTitle("Cadastro");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 414, 239);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(21, 11, 46, 14);
		panel.add(lblNome);

		tfNome = new JTextField();
		tfNome.setBounds(77, 8, 209, 20);
		panel.add(tfNome);
		tfNome.setColumns(10);

		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(21, 36, 46, 14);
		panel.add(lblEmail);

		txtEmail = new JTextField();
		txtEmail.setBounds(77, 33, 209, 20);
		panel.add(txtEmail);
		txtEmail.setColumns(10);

		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setBounds(21, 71, 46, 14);
		panel.add(lblTelefone);

		txtDDD = new JTextField();
		txtDDD.setBounds(77, 68, 40, 20);
		panel.add(txtDDD);
		txtDDD.setColumns(10);

		txtNumero = new JTextField();
		txtNumero.setBounds(127, 68, 159, 20);
		panel.add(txtNumero);
		txtNumero.setColumns(10);

		JLabel lblEndereco = new JLabel("Endereco:");
		lblEndereco.setBounds(10, 107, 57, 14);
		panel.add(lblEndereco);

		txtEndereco = new JTextField();
		txtEndereco.setBounds(77, 104, 209, 20);
		panel.add(txtEndereco);
		txtEndereco.setColumns(10);

		JLabel lblCep = new JLabel("Cep:");
		lblCep.setBounds(21, 132, 46, 14);
		panel.add(lblCep);

		txtCep = new JTextField();
		txtCep.setBounds(77, 129, 209, 20);
		panel.add(txtCep);
		txtCep.setColumns(10);

		// botao Cadastrar
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (rdbtnCliente.isSelected()) {
					// Cliente cliente = fabrica.getCliente(tfNome.getText(), txtEmail.getText(),
					// Integer.parseInt(txtDDD.getText()), Integer.parseInt(txtNumero.getText()),
					// fabrica.getLocalizacao(txtEndereco.getText(),
					// Integer.parseInt(txtCep.getText())));

					Cliente cliente = new Cliente(tfNome.getText(), txtEmail.getText(),
							Integer.parseInt(txtDDD.getText()), Integer.parseInt(txtNumero.getText()),
							new Localizacao(txtEndereco.getText(), Integer.parseInt(txtCep.getText())));
					Fachada.getInstance().cadastrar(cliente);

					Fachada.getInstance().cadastrar(cliente);
				}
				if (senha.getPassword().equals(repetirSenha.getPassword())) {
					if (rdbtnVendedor.isSelected()) {
						// Vendedor vendedor = fabrica.getVendedor(tfNome.getText(), txtEmail.getText(),
						// new String(senha.getPassword()), Integer.parseInt(txtDDD.getText()),
						// Integer.parseInt(txtNumero.getText()),
						// fabrica.getLocalizacao(txtEndereco.getText(),
						// Integer.parseInt(txtCep.getText())));
						Vendedor vendedor = new Vendedor(tfNome.getText(), txtEmail.getText(),
								new String(senha.getPassword()), Integer.parseInt(txtDDD.getText()),
								Integer.parseInt(txtNumero.getText()),
								new Localizacao(txtEndereco.getText(), Integer.parseInt(txtCep.getText())));

						Fachada.getInstance().cadastrar(vendedor);
					} else if (rdbtnMarceneiro.isSelected()) {
						Marceneiro marceneiro = new Marceneiro(tfNome.getText(), txtEmail.getText(),
								new String(senha.getPassword()), Integer.parseInt(txtDDD.getText()),
								Integer.parseInt(txtNumero.getText()),
								new Localizacao(txtEndereco.getText(), Integer.parseInt(txtCep.getText())));

						// Fachada.getInstance().cadastrar(marceneiro);
					}
					/*
					 * if(rdbtnMarceneiro.isSelected()) { Marceneiro marceneiro =
					 * fabrica.getMarceneiro(tfNome.getText(), txtEmail.getText(),new String
					 * (senha.getPassword()) , Integer.parseInt(txtDDD.getText()),
					 * Integer.parseInt(txtNumero.getText()),
					 * fabrica.getLocalizacao(txtEndereco.getText(),
					 * Integer.parseInt(txtCep.getText())));
					 * Fachada.getInstance().cadastrar(marceneiro); }
					 */
				}
			}
		});
		btnCadastrar.setBounds(296, 170, 108, 58);
		panel.add(btnCadastrar);

		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setBounds(21, 157, 46, 14);
		panel.add(lblSenha);

		senha = new JPasswordField();
		repetirSenha = new JPasswordField();
		senha.setBounds(127, 154, 159, 20);
		panel.add(senha);

		JLabel lblRepetirSenha = new JLabel("Repetir senha:");
		lblRepetirSenha.setBounds(21, 183, 96, 14);
		panel.add(lblRepetirSenha);

		repetirSenha.setBounds(127, 185, 159, 20);
		panel.add(repetirSenha);
		repetirSenha.setColumns(10);
		buttonGroup.add(rdbtnMarceneiro);

		rdbtnMarceneiro.setBounds(304, 7, 109, 23);
		panel.add(rdbtnMarceneiro);
		buttonGroup.add(rdbtnVendedor);

		rdbtnVendedor.setBounds(304, 36, 109, 23);
		panel.add(rdbtnVendedor);
		buttonGroup.add(rdbtnCliente);
		rdbtnCliente.setSelected(true);

		rdbtnCliente.setBounds(304, 67, 109, 23);
		panel.add(rdbtnCliente);
	}

	public static Cadastrar getInstance() {
		if (Cadastrar.instance == null) {
			Cadastrar.instance = new Cadastrar();
		}
		return Cadastrar.instance;
	}
}
