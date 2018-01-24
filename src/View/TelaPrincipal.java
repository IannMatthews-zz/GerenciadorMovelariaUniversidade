package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JToolBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import org.eclipse.wb.swing.FocusTraversalOnArray;

import Controller.Fachada;
import Model.Cliente;
import Model.Fabrica;
import Model.Localizacao;
import Model.Pessoa;
import Model.PessoaNaoEncontradaException;
import Model.Vendedor;

import java.awt.Component;
import javax.swing.SwingConstants;
import javax.swing.JInternalFrame;
import javax.swing.JCheckBox;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Color;

public class TelaPrincipal extends JFrame {

	private JPanel contentPane;
	private boolean marceneiroLogado = false;
	private boolean vendedorLogado = false;
	private String login = "admin";
	private String password = "";
	private Fabrica fabrica;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal frame = new TelaPrincipal();
					frame.setVisible(true);
					iniciaTelas(frame);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public static void iniciaTelas(TelaPrincipal janela) {
		janela.apagarTelas();
		janela.panelLogin.setVisible(true);
	}

	final JPanel panelGerenciarClientes = new JPanel();
	final JPanel panelVendedor = new JPanel();
	final JPanel panelMarceneiro = new JPanel();
	final JPanel panelCadastroCliente = new JPanel();
	final JPanel panelFazerPedido = new JPanel();
	final JPanel panelLogin = new JPanel();
	final JPanel panelNovoCliente = new JPanel();
	final JPanel panelExcluirCliente = new JPanel();
	final JPanel panelCadastrarVendedor = new JPanel();
	JPanel panelConsultarCliente = new JPanel();
	private JTextField txtLoginVendedor;
	private JPasswordField pswdVendedor;
	private JTextField txtLoginMarceneiro;
	private JPasswordField pswdMarceneiro;
	private JTextField txtDDDCliente;
	private JTextField txtNumeroCliente;
	private JTextField txtEnderecoCliente;
	private JTextField txtCEPCliente;
	private JTextField txtNomeCliente;
	private JTextField txtEmailCliente;
	private JTextField txtExcluirCliente;
	private JTextField txtIdConsultarCliente;
	private JTextField txtConsultarClienteEmail;
	private JTextField txtConsultaClienteNome;
	private JTextField txtConsultaClienteEmail;
	private JTextField txtConsultaClienteId;
	private JTextField txtConsultaClienteDDD;
	private JTextField txtConsultaClienteNumero;
	private JTextField txtConsultaClienteEndereco;
	private JTextField txtConsultaClienteCEP;

	// INDICA ID DO CLIENTE RECEM CRIADO
	JLabel lblIdNovoCliente = new JLabel("");
	private JTextField txtPesquisar;
	private JTextField txtNomeVendedor;
	private JTextField txtEmail;
	private JTextField txtCep;
	private JTextField txtEndereco;
	private JTextField txtDDD;
	private JTextField txtNumero;

	/**
	 * Create the frame.
	 */
	public TelaPrincipal() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 450);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnHome = new JMenu("Home");
		mnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		menuBar.add(mnHome);
		
		JMenuItem mntmHome = new JMenuItem("Home");
		mntmHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				apagarTelas();
				panelLogin.setVisible(true);
			}
		});
		mnHome.add(mntmHome);

		JMenu mnUsuario = new JMenu("Usuario");
		menuBar.add(mnUsuario);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		panelMarceneiro.setVisible(false);

		panelCadastrarVendedor.setVisible(false);

		panelLogin.setBounds(0, 0, 684, 389);
		contentPane.add(panelLogin);
		panelLogin.setLayout(null);

		JLabel lblLogin = new JLabel("Login:");
		lblLogin.setBounds(31, 96, 64, 14);
		panelLogin.add(lblLogin);

		final JButton btnEntrarVendedor = new JButton("Entrar");
		txtLoginVendedor = new JTextField();
		txtLoginVendedor.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if (arg0.getKeyCode() == KeyEvent.VK_ENTER) {
					btnEntrarVendedor.doClick();
				}
			}
		});
		txtLoginVendedor.setBounds(90, 91, 132, 20);
		panelLogin.add(txtLoginVendedor);
		txtLoginVendedor.setColumns(10);

		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setBounds(31, 121, 64, 14);
		panelLogin.add(lblSenha);

		pswdVendedor = new JPasswordField();
		pswdVendedor.setBounds(90, 119, 132, 20);
		panelLogin.add(pswdVendedor);

		btnEntrarVendedor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (txtLoginVendedor.getText().equals(login) && pswdVendedor.getText().equals(password)) {
					vendedorLogado = true;
					apagarTelas();
					panelVendedor.setVisible(true);
				}
			}
		});
		btnEntrarVendedor.setBounds(133, 150, 89, 23);
		panelLogin.add(btnEntrarVendedor);

		JLabel label = new JLabel("Login:");
		label.setBounds(407, 96, 64, 14);
		panelLogin.add(label);

		final JButton btnEntrarMarceneiro = new JButton("Entrar");
		txtLoginMarceneiro = new JTextField();
		txtLoginMarceneiro.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if (arg0.getKeyCode() == KeyEvent.VK_ENTER) {
					btnEntrarMarceneiro.doClick();
				}
			}
		});
		txtLoginMarceneiro.setColumns(10);
		txtLoginMarceneiro.setBounds(466, 91, 132, 20);
		panelLogin.add(txtLoginMarceneiro);

		JLabel label_1 = new JLabel("Senha:");
		label_1.setBounds(407, 121, 64, 14);
		panelLogin.add(label_1);

		pswdMarceneiro = new JPasswordField();
		pswdMarceneiro.setBounds(466, 119, 132, 20);
		panelLogin.add(pswdMarceneiro);

		btnEntrarMarceneiro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// if (txtLoginMarceneiro.getText().equals(login) &&
				// pswdMarceneiro.getText().equals(password)) {
				if (txtLoginMarceneiro.getText().equals(login)
						&& password.equals(new String(pswdMarceneiro.getPassword()))) {
					marceneiroLogado = true;
					apagarTelas();
					panelMarceneiro.setVisible(true);
				}
			}
		});
		btnEntrarMarceneiro.setBounds(509, 150, 89, 23);
		panelLogin.add(btnEntrarMarceneiro);

		JLabel lblVendedor_1 = new JLabel("Vendedor");
		lblVendedor_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblVendedor_1.setBounds(31, 43, 191, 37);
		panelLogin.add(lblVendedor_1);

		JLabel lblMarceneiro_1 = new JLabel("Marceneiro");
		lblMarceneiro_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMarceneiro_1.setBounds(407, 43, 191, 37);
		panelLogin.add(lblMarceneiro_1);

		JButton btnCriarConta = new JButton("Criar conta.");
		btnCriarConta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Cadastrar.getInstance().setVisible(true);
			}
		});
		btnCriarConta.setBounds(283, 360, 108, 29);
		panelLogin.add(btnCriarConta);

		final JLabel lblTesteCadastro = new JLabel("0");
		lblTesteCadastro.setBounds(72, 316, 46, 14);
		panelLogin.add(lblTesteCadastro);

		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					lblTesteCadastro.setText(String.valueOf(Fachada.getInstance().buscarCliente(1).getNome()));
				} catch (PessoaNaoEncontradaException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnAtualizar.setBounds(51, 360, 89, 23);
		panelLogin.add(btnAtualizar);
		panelLogin.setVisible(true);
		panelLogin.setVisible(true);

		panelGerenciarClientes.setBounds(0, 0, 684, 389);
		contentPane.add(panelGerenciarClientes);
		panelGerenciarClientes.setLayout(null);

		JButton btnNovo = new JButton("Novo");
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				apagarTelas();
				panelGerenciarClientes.setVisible(true);
				panelNovoCliente.setVisible(true);
			}
		});

		JButton btnClientesVoltar = new JButton("Voltar");
		btnClientesVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				apagarTelas();
				panelVendedor.setVisible(true);
			}
		});
		btnClientesVoltar.setBounds(585, 11, 89, 35);
		panelGerenciarClientes.add(btnClientesVoltar);
		btnNovo.setBounds(10, 57, 200, 100);
		panelGerenciarClientes.add(btnNovo);

		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				apagarTelas();
				panelGerenciarClientes.setVisible(true);
				panelExcluirCliente.setVisible(true);
			}
		});
		btnExcluir.setBounds(10, 167, 200, 100);
		panelGerenciarClientes.add(btnExcluir);

		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				apagarTelas();
				panelGerenciarClientes.setVisible(true);
				panelConsultarCliente.setVisible(true);
			}
		});
		btnConsultar.setBounds(10, 278, 200, 100);
		panelGerenciarClientes.add(btnConsultar);

		JLabel lblClientes = new JLabel("Clientes");
		lblClientes.setHorizontalAlignment(SwingConstants.CENTER);
		lblClientes.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblClientes.setBounds(10, 11, 664, 35);
		panelGerenciarClientes.add(lblClientes);

		panelNovoCliente.setBounds(220, 57, 454, 321);
		panelGerenciarClientes.add(panelNovoCliente);
		panelNovoCliente.setLayout(null);

		JLabel lblNovoCliente = new JLabel("Novo Cliente");
		lblNovoCliente.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNovoCliente.setBounds(10, 11, 434, 30);
		panelNovoCliente.add(lblNovoCliente);

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(10, 52, 60, 14);
		panelNovoCliente.add(lblNome);

		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setBounds(10, 77, 60, 14);
		panelNovoCliente.add(lblEmail);

		JLabel lblDdd = new JLabel("DDD:");
		lblDdd.setBounds(10, 102, 60, 14);
		panelNovoCliente.add(lblDdd);

		JLabel lblNmero = new JLabel("N\u00FAmero:");
		lblNmero.setBounds(80, 102, 60, 14);
		panelNovoCliente.add(lblNmero);

		txtDDDCliente = new JTextField();
		txtDDDCliente.setBounds(10, 127, 50, 20);
		panelNovoCliente.add(txtDDDCliente);
		txtDDDCliente.setColumns(10);

		txtNumeroCliente = new JTextField();
		txtNumeroCliente.setBounds(80, 127, 110, 20);
		panelNovoCliente.add(txtNumeroCliente);
		txtNumeroCliente.setColumns(10);

		JLabel lblEndereo = new JLabel("Endere\u00E7o:");
		lblEndereo.setBounds(10, 158, 60, 14);
		panelNovoCliente.add(lblEndereo);

		txtEnderecoCliente = new JTextField();
		txtEnderecoCliente.setBounds(80, 155, 364, 20);
		panelNovoCliente.add(txtEnderecoCliente);
		txtEnderecoCliente.setColumns(10);

		JLabel lblCep = new JLabel("CEP:");
		lblCep.setBounds(10, 186, 60, 14);
		panelNovoCliente.add(lblCep);

		txtCEPCliente = new JTextField();
		txtCEPCliente.setBounds(54, 183, 390, 20);
		panelNovoCliente.add(txtCEPCliente);
		txtCEPCliente.setColumns(10);

		txtNomeCliente = new JTextField();
		txtNomeCliente.setBounds(54, 49, 390, 20);
		panelNovoCliente.add(txtNomeCliente);
		txtNomeCliente.setColumns(10);

		txtEmailCliente = new JTextField();
		txtEmailCliente.setBounds(54, 74, 390, 20);
		panelNovoCliente.add(txtEmailCliente);
		txtEmailCliente.setColumns(10);

		JButton btnConcluirCliente = new JButton("Concluir");
		btnConcluirCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Cliente cliente;

				try {
					cliente = new Cliente(txtNomeCliente.getText(), txtEmailCliente.getText(),
							Integer.parseInt(txtDDDCliente.getText()), Integer.parseInt(txtNumeroCliente.getText()),
							new Localizacao(txtEnderecoCliente.getText(), Integer.parseInt(txtCEPCliente.getText())));
					Fachada.getInstance().cadastrar(cliente);
					try {
						lblIdNovoCliente.setForeground(Color.BLACK);
						lblIdNovoCliente
								.setText(String.valueOf(Fachada.getInstance().buscarCliente(cliente.getId()).getId()));
					} catch (PessoaNaoEncontradaException e) {
						lblIdNovoCliente.setForeground(Color.RED);
						lblIdNovoCliente.setText("Erro ao criar cliente");
						e.printStackTrace();
					}
				} catch (NumberFormatException ex) {
					lblIdNovoCliente.setForeground(Color.RED);
					lblIdNovoCliente.setText("Campo numérico inválido");
					ex.printStackTrace();
				}

				txtNomeCliente.setText("");
				txtEmailCliente.setText("");
				txtDDDCliente.setText("");
				txtNumeroCliente.setText("");
				txtEnderecoCliente.setText("");
				txtCEPCliente.setText("");
			}
		});
		btnConcluirCliente.setBounds(355, 287, 89, 23);
		panelNovoCliente.add(btnConcluirCliente);

		JButton btnCancelarCliente = new JButton("Cancelar");
		btnCancelarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtNomeCliente.setText("");
				txtEmailCliente.setText("");
				txtDDDCliente.setText("");
				txtNumeroCliente.setText("");
				txtEnderecoCliente.setText("");
				txtCEPCliente.setText("");

				panelNovoCliente.setVisible(false);
			}
		});
		btnCancelarCliente.setBounds(256, 287, 89, 23);
		panelNovoCliente.add(btnCancelarCliente);

		JLabel lblIdDoNovo = new JLabel("ID do novo cliente:");
		lblIdDoNovo.setBounds(10, 291, 130, 14);
		panelNovoCliente.add(lblIdDoNovo);

		lblIdNovoCliente.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblIdNovoCliente.setBounds(110, 291, 136, 14);
		panelNovoCliente.add(lblIdNovoCliente);

		panelConsultarCliente.setBounds(220, 57, 454, 321);
		panelGerenciarClientes.add(panelConsultarCliente);
		panelConsultarCliente.setLayout(null);

		JLabel lblConsultarCliente = new JLabel("Consultar Cliente");
		lblConsultarCliente.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblConsultarCliente.setBounds(10, 11, 217, 30);
		panelConsultarCliente.add(lblConsultarCliente);

		JLabel lblIdConsultarCliente = new JLabel("ID:");
		lblIdConsultarCliente.setBounds(10, 52, 46, 14);
		panelConsultarCliente.add(lblIdConsultarCliente);

		txtIdConsultarCliente = new JTextField();
		txtIdConsultarCliente.setBounds(50, 49, 120, 20);
		panelConsultarCliente.add(txtIdConsultarCliente);
		txtIdConsultarCliente.setColumns(10);

		final JLabel lblConsultarClienteAviso = new JLabel("");
		JButton btnConsultarPorId = new JButton("Consultar por ID");
		btnConsultarPorId.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Pessoa cliente;
					cliente = Fachada.getInstance().buscarCliente(Integer.parseInt(txtIdConsultarCliente.getText()));

					txtConsultaClienteId.setText(String.valueOf(cliente.getId()));
					txtConsultaClienteNome.setText(cliente.getNome());
					txtConsultaClienteEmail.setText(cliente.getContato().getEmail());
					txtConsultaClienteDDD.setText(String.valueOf(cliente.getContato().getDDD()));
					txtConsultaClienteNumero.setText(String.valueOf(cliente.getContato().getNumero()));
					txtConsultaClienteEndereco.setText(cliente.getEndereco().getEndereco());
					txtConsultaClienteCEP.setText(String.valueOf(cliente.getEndereco().getCEP()));

					lblConsultarClienteAviso.setText("");
				} catch (NumberFormatException e) {
					txtConsultaClienteId.setText("");
					txtConsultaClienteNome.setText("");
					txtConsultaClienteEmail.setText("");
					txtConsultaClienteDDD.setText("");
					txtConsultaClienteNumero.setText("");
					txtConsultaClienteEndereco.setText("");
					txtConsultaClienteCEP.setText("");

					lblConsultarClienteAviso.setForeground(Color.RED);
					lblConsultarClienteAviso.setText("Campo ID Inválido");

					e.printStackTrace();
				} catch (PessoaNaoEncontradaException e) {
					txtConsultaClienteId.setText("");
					txtConsultaClienteNome.setText("");
					txtConsultaClienteEmail.setText("");
					txtConsultaClienteDDD.setText("");
					txtConsultaClienteNumero.setText("");
					txtConsultaClienteEndereco.setText("");
					txtConsultaClienteCEP.setText("");

					lblConsultarClienteAviso.setForeground(Color.RED);
					lblConsultarClienteAviso.setText("Cliente não encontrado");

					e.printStackTrace();
				}
			}
		});
		btnConsultarPorId.setBounds(10, 77, 160, 23);
		panelConsultarCliente.add(btnConsultarPorId);

		JLabel lblEmail_1 = new JLabel("E-mail:");
		lblEmail_1.setBounds(10, 111, 46, 14);
		panelConsultarCliente.add(lblEmail_1);

		txtConsultarClienteEmail = new JTextField();
		txtConsultarClienteEmail.setBounds(50, 111, 120, 20);
		panelConsultarCliente.add(txtConsultarClienteEmail);
		txtConsultarClienteEmail.setColumns(10);

		JButton btnConsultarPorEmail = new JButton("Consultar por e-mail");
		btnConsultarPorEmail.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Pessoa cliente;
					cliente = Fachada.getInstance().buscarCliente(txtConsultarClienteEmail.getText());

					txtConsultaClienteId.setText(String.valueOf(cliente.getId()));
					txtConsultaClienteNome.setText(cliente.getNome());
					txtConsultaClienteEmail.setText(cliente.getContato().getEmail());
					txtConsultaClienteDDD.setText(String.valueOf(cliente.getContato().getDDD()));
					txtConsultaClienteNumero.setText(String.valueOf(cliente.getContato().getNumero()));
					txtConsultaClienteEndereco.setText(cliente.getEndereco().getEndereco());
					txtConsultaClienteCEP.setText(String.valueOf(cliente.getEndereco().getCEP()));
				} catch (PessoaNaoEncontradaException e) {
					lblConsultarClienteAviso.setForeground(Color.RED);
					lblConsultarClienteAviso.setText("Cliente não encontrado");
					e.printStackTrace();
				}

			}
		});
		btnConsultarPorEmail.setBounds(10, 142, 160, 23);
		panelConsultarCliente.add(btnConsultarPorEmail);

		JLabel lblResultadoConsultaCliente = new JLabel("Resultado");
		lblResultadoConsultaCliente.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblResultadoConsultaCliente.setBounds(227, 11, 217, 30);
		panelConsultarCliente.add(lblResultadoConsultaCliente);

		JLabel lblNomeConsultaCliente = new JLabel("Nome:");
		lblNomeConsultaCliente.setBounds(227, 77, 217, 14);
		panelConsultarCliente.add(lblNomeConsultaCliente);

		txtConsultaClienteNome = new JTextField();
		txtConsultaClienteNome.setEditable(false);
		txtConsultaClienteNome.setBounds(227, 103, 227, 20);
		panelConsultarCliente.add(txtConsultaClienteNome);
		txtConsultaClienteNome.setColumns(10);

		JLabel lblEmailConsultaCliente = new JLabel("E-mail:");
		lblEmailConsultaCliente.setBounds(227, 136, 46, 14);
		panelConsultarCliente.add(lblEmailConsultaCliente);

		txtConsultaClienteEmail = new JTextField();
		txtConsultaClienteEmail.setEditable(false);
		txtConsultaClienteEmail.setBounds(283, 133, 171, 20);
		panelConsultarCliente.add(txtConsultaClienteEmail);
		txtConsultaClienteEmail.setColumns(10);

		JLabel lblConsultaClienteId = new JLabel("ID:");
		lblConsultaClienteId.setBounds(227, 52, 46, 14);
		panelConsultarCliente.add(lblConsultaClienteId);

		txtConsultaClienteId = new JTextField();
		txtConsultaClienteId.setEditable(false);
		txtConsultaClienteId.setBounds(283, 49, 171, 20);
		panelConsultarCliente.add(txtConsultaClienteId);
		txtConsultaClienteId.setColumns(10);

		JLabel lblConsultaClienteTelefone = new JLabel("Telefone:");
		lblConsultaClienteTelefone.setBounds(227, 167, 58, 14);
		panelConsultarCliente.add(lblConsultaClienteTelefone);

		txtConsultaClienteDDD = new JTextField();
		txtConsultaClienteDDD.setEditable(false);
		txtConsultaClienteDDD.setBounds(283, 164, 40, 20);
		panelConsultarCliente.add(txtConsultaClienteDDD);
		txtConsultaClienteDDD.setColumns(10);

		txtConsultaClienteNumero = new JTextField();
		txtConsultaClienteNumero.setEditable(false);
		txtConsultaClienteNumero.setBounds(333, 164, 121, 20);
		panelConsultarCliente.add(txtConsultaClienteNumero);
		txtConsultaClienteNumero.setColumns(10);

		JLabel lblConsultaClienteEndereo = new JLabel("Endere\u00E7o:");
		lblConsultaClienteEndereo.setBounds(227, 192, 227, 14);
		panelConsultarCliente.add(lblConsultaClienteEndereo);

		txtConsultaClienteEndereco = new JTextField();
		txtConsultaClienteEndereco.setEditable(false);
		txtConsultaClienteEndereco.setBounds(227, 217, 227, 20);
		panelConsultarCliente.add(txtConsultaClienteEndereco);
		txtConsultaClienteEndereco.setColumns(10);

		JLabel lblConsultaClienteCep = new JLabel("CEP:");
		lblConsultaClienteCep.setBounds(227, 248, 46, 14);
		panelConsultarCliente.add(lblConsultaClienteCep);

		txtConsultaClienteCEP = new JTextField();
		txtConsultaClienteCEP.setEditable(false);
		txtConsultaClienteCEP.setBounds(283, 248, 171, 20);
		panelConsultarCliente.add(txtConsultaClienteCEP);
		txtConsultaClienteCEP.setColumns(10);

		final JButton btnEditarClienteCancelar = new JButton("Cancelar");
		final JButton btnEditarClienteConfirmar = new JButton("Confirmar");
		final JButton btnEditarCliente = new JButton("Editar Cliente");

		btnEditarClienteConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// EDITAR O CLIENTE NO REPOSITORIO

				txtConsultaClienteNome.setEditable(false);
				txtConsultaClienteEmail.setEditable(false);
				txtConsultaClienteDDD.setEditable(false);
				txtConsultaClienteNumero.setEditable(false);
				txtConsultaClienteEndereco.setEditable(false);
				txtConsultaClienteCEP.setEditable(false);

				btnEditarClienteCancelar.setVisible(false);
				btnEditarClienteConfirmar.setVisible(false);

				btnEditarCliente.setVisible(true);
			}
		});

		btnEditarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtConsultaClienteNome.setEditable(true);
				txtConsultaClienteEmail.setEditable(true);
				txtConsultaClienteDDD.setEditable(true);
				txtConsultaClienteNumero.setEditable(true);
				txtConsultaClienteEndereco.setEditable(true);
				txtConsultaClienteCEP.setEditable(true);

				btnEditarClienteConfirmar.setVisible(true);
				btnEditarClienteCancelar.setVisible(true);

				btnEditarCliente.setVisible(false);
			}
		});
		btnEditarCliente.setBounds(227, 287, 227, 23);
		panelConsultarCliente.add(btnEditarCliente);
		btnEditarClienteConfirmar.setBounds(354, 287, 100, 23);
		panelConsultarCliente.add(btnEditarClienteConfirmar);

		btnEditarClienteCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// RESTAURAR OS DADOS NO LADO RESULTADO

				txtConsultaClienteNome.setEditable(false);
				txtConsultaClienteEmail.setEditable(false);
				txtConsultaClienteDDD.setEditable(false);
				txtConsultaClienteNumero.setEditable(false);
				txtConsultaClienteEndereco.setEditable(false);
				txtConsultaClienteCEP.setEditable(false);

				btnEditarClienteCancelar.setVisible(false);
				btnEditarClienteConfirmar.setVisible(false);

				btnEditarCliente.setVisible(true);
			}
		});
		btnEditarClienteCancelar.setBounds(227, 287, 100, 23);
		panelConsultarCliente.add(btnEditarClienteCancelar);

		lblConsultarClienteAviso.setBounds(10, 287, 207, 23);
		panelConsultarCliente.add(lblConsultarClienteAviso);

		panelExcluirCliente.setBounds(220, 57, 454, 321);
		panelGerenciarClientes.add(panelExcluirCliente);
		panelExcluirCliente.setLayout(null);

		JLabel lblExcluirCliente = new JLabel("Excluir Cliente");
		lblExcluirCliente.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblExcluirCliente.setBounds(10, 11, 434, 30);
		panelExcluirCliente.add(lblExcluirCliente);

		JLabel lblInsiraOId = new JLabel("Insira o ID do cliente para ser exclu\u00EDdo:");
		lblInsiraOId.setBounds(10, 52, 434, 14);
		panelExcluirCliente.add(lblInsiraOId);

		txtExcluirCliente = new JTextField();
		txtExcluirCliente.setBounds(10, 77, 100, 20);
		panelExcluirCliente.add(txtExcluirCliente);
		txtExcluirCliente.setColumns(10);

		final JCheckBox chckbxConfirmarExcluir = new JCheckBox("Confirmar");
		chckbxConfirmarExcluir.setBounds(116, 76, 97, 23);
		panelExcluirCliente.add(chckbxConfirmarExcluir);

		final JLabel lblExcluirClienteAviso = new JLabel("");
		JButton btnExcluirCliente = new JButton("Excluir");
		btnExcluirCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (txtExcluirCliente.getText() != "" && chckbxConfirmarExcluir.isSelected()) {
					try {
						Fachada.getInstance().apagar(
								Fachada.getInstance().buscarCliente(Integer.parseInt(txtExcluirCliente.getText())));
						lblExcluirClienteAviso.setForeground(Color.GREEN);
						lblExcluirClienteAviso.setText("Cliente apagado com Sucesso");
					} catch (NumberFormatException e) {
						lblExcluirClienteAviso.setForeground(Color.RED);
						lblExcluirClienteAviso.setText("Campo ID Inválido");
						e.printStackTrace();
					} catch (PessoaNaoEncontradaException e) {
						lblExcluirClienteAviso.setForeground(Color.RED);
						lblExcluirClienteAviso.setText("Cliente não existe");
						e.printStackTrace();
					}
				}
			}
		});
		btnExcluirCliente.setBounds(10, 108, 203, 23);
		panelExcluirCliente.add(btnExcluirCliente);

		lblExcluirClienteAviso.setForeground(Color.RED);
		lblExcluirClienteAviso.setBounds(10, 142, 203, 30);
		panelExcluirCliente.add(lblExcluirClienteAviso);

		panelCadastroCliente.setBounds(0, 0, 684, 389);
		contentPane.add(panelCadastroCliente);
		panelCadastroCliente.setLayout(null);
		panelCadastrarVendedor.setBounds(213, 11, 471, 378);
		contentPane.add(panelCadastrarVendedor);
		panelCadastrarVendedor.setLayout(null);

		JLabel lblNovoVendedor = new JLabel("Novo Vendedor");
		lblNovoVendedor.setBounds(10, 11, 160, 25);
		lblNovoVendedor.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panelCadastrarVendedor.add(lblNovoVendedor);

		JLabel label_3 = new JLabel("Nome:");
		label_3.setBounds(20, 47, 41, 14);
		panelCadastrarVendedor.add(label_3);

		JLabel label_4 = new JLabel("E-mail:");
		label_4.setBounds(19, 72, 42, 14);
		panelCadastrarVendedor.add(label_4);

		JLabel label_5 = new JLabel("DDD:");
		label_5.setBounds(20, 97, 41, 14);
		panelCadastrarVendedor.add(label_5);

		JLabel label_6 = new JLabel("N\u00FAmero:");
		label_6.setBounds(71, 97, 58, 14);
		panelCadastrarVendedor.add(label_6);

		txtNomeVendedor = new JTextField();
		txtNomeVendedor.setBounds(75, 47, 372, 20);
		txtNomeVendedor.setColumns(10);
		panelCadastrarVendedor.add(txtNomeVendedor);

		txtEmail = new JTextField();
		txtEmail.setBounds(75, 69, 372, 20);
		txtEmail.setColumns(10);
		panelCadastrarVendedor.add(txtEmail);

		JLabel label_7 = new JLabel("Endere\u00E7o:");
		label_7.setBounds(20, 152, 58, 14);
		panelCadastrarVendedor.add(label_7);

		txtCep = new JTextField();
		txtCep.setBounds(56, 177, 391, 20);
		txtCep.setColumns(10);
		panelCadastrarVendedor.add(txtCep);

		JLabel label_8 = new JLabel("CEP:");
		label_8.setBounds(20, 177, 29, 14);
		panelCadastrarVendedor.add(label_8);

		txtEndereco = new JTextField();
		txtEndereco.setBounds(79, 149, 368, 20);
		txtEndereco.setColumns(10);
		panelCadastrarVendedor.add(txtEndereco);

		txtDDD = new JTextField();
		txtDDD.setBounds(20, 122, 49, 20);
		txtDDD.setColumns(10);
		panelCadastrarVendedor.add(txtDDD);

		txtNumero = new JTextField();
		txtNumero.setBounds(79, 122, 108, 20);
		txtNumero.setColumns(10);
		panelCadastrarVendedor.add(txtNumero);

		JButton bntConcluir = new JButton("Concluir");
		bntConcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Fachada.getInstance()
						.cadastrar(fabrica.getVendedor(txtNomeVendedor.getText(), txtEmail.getText(), "senha",
								Integer.parseInt(txtDDD.getText()), Integer.parseInt(txtNumero.getText()),
								new Localizacao("endereco", 0)));

			}
		});
		bntConcluir.setBounds(239, 290, 99, 23);
		panelCadastrarVendedor.add(bntConcluir);

		JButton button_1 = new JButton("Cancelar");
		button_1.setBounds(348, 290, 99, 23);
		panelCadastrarVendedor.add(button_1);

		JLabel label_9 = new JLabel("ID do novo cliente:");
		label_9.setBounds(10, 328, 91, 14);
		panelCadastrarVendedor.add(label_9);

		JLabel label_10 = new JLabel("");
		label_10.setBounds(348, 240, 0, 0);
		label_10.setFont(new Font("Tahoma", Font.BOLD, 11));
		panelCadastrarVendedor.add(label_10);

		panelMarceneiro.setBounds(0, 0, 684, 389);
		contentPane.add(panelMarceneiro);
		panelMarceneiro.setLayout(null);

		JLabel lblMarceneiro = new JLabel("Marceneiro");
		lblMarceneiro.setBounds(0, 0, 684, 14);
		panelMarceneiro.add(lblMarceneiro);

		JButton btnNewButton = new JButton("Cadastrar Vendedor");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelCadastrarVendedor.setVisible(true);

			}
		});
		btnNewButton.setBounds(10, 167, 200, 100);
		panelMarceneiro.add(btnNewButton);

		JButton btnExcluirVendedor = new JButton("Excluir Vendedor");
		btnExcluirVendedor.setBounds(10, 278, 200, 100);
		panelMarceneiro.add(btnExcluirVendedor);

		JPanel panelPesquisar = new JPanel();
		panelPesquisar.setLayout(null);
		panelPesquisar.setBounds(10, 25, 200, 100);
		panelMarceneiro.add(panelPesquisar);

		JLabel lblPesquisar = new JLabel("Pesquisar");
		lblPesquisar.setBounds(10, 11, 61, 14);
		panelPesquisar.add(lblPesquisar);

		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnPesquisar.setBounds(10, 66, 180, 23);
		panelPesquisar.add(btnPesquisar);

		txtPesquisar = new JTextField();
		txtPesquisar.setColumns(10);
		txtPesquisar.setBounds(71, 8, 119, 20);
		panelPesquisar.add(txtPesquisar);

		panelVendedor.setLayout(null);
		panelVendedor.setBounds(0, 0, 684, 389);
		contentPane.add(panelVendedor);

		JLabel lblVendedor = new JLabel("Vendedor");
		lblVendedor.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblVendedor.setHorizontalAlignment(SwingConstants.CENTER);
		lblVendedor.setBounds(0, 0, 684, 45);
		panelVendedor.add(lblVendedor);

		JButton btnGerenciarClientes = new JButton("Gerenciar Clientes");
		btnGerenciarClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				apagarTelas();
				panelGerenciarClientes.setVisible(true);
			}
		});
		btnGerenciarClientes.setBounds(250, 56, 200, 100);
		panelVendedor.add(btnGerenciarClientes);

		JButton btnGerenciarVendas = new JButton("Gerenciar Vendas");
		btnGerenciarVendas.setBounds(250, 167, 200, 100);
		btnGerenciarVendas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Vendas.getInstance().setVisible(true);
			}
		});
		panelVendedor.add(btnGerenciarVendas);

		JButton btnFazerPedido = new JButton("Fazer Pedido");
		btnFazerPedido.setBounds(250, 278, 200, 100);
		panelVendedor.add(btnFazerPedido);

		// LIMPAR TELA NA INICIALIZACAO
		apagarTelas();

		panelFazerPedido.setBounds(0, 0, 684, 389);
		contentPane.add(panelFazerPedido);

		JMenuItem mntmVendedor = new JMenuItem("Vendedor");
		mntmVendedor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (vendedorLogado) {
					apagarTelas();
					panelVendedor.setVisible(true);
				} else {
					apagarTelas();
					panelLogin.setVisible(true);
				}
			}
		});
		mnUsuario.add(mntmVendedor);

		JMenuItem mntmMarceneiro = new JMenuItem("Marceneiro");
		mntmMarceneiro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (marceneiroLogado) {
					apagarTelas();
					panelMarceneiro.setVisible(true);
				} else {
					apagarTelas();
					panelLogin.setVisible(true);
				}
			}
		});
		mnUsuario.add(mntmMarceneiro);

	}

	private void apagarTelas() {
		panelGerenciarClientes.setVisible(false);
		panelVendedor.setVisible(false);
		panelCadastroCliente.setVisible(false);
		panelFazerPedido.setVisible(false);
		panelLogin.setVisible(false);
		panelNovoCliente.setVisible(false);
		panelExcluirCliente.setVisible(false);
		panelConsultarCliente.setVisible(false);
		panelMarceneiro.setVisible(false);
		panelCadastrarVendedor.setVisible(false);
	}

	public void cadastrarVendedor() {
		Vendedor vendedor = fabrica.getVendedor(txtNomeVendedor.getText(), txtEmail.getText(), "senha",
				Integer.parseInt(txtDDD.getText()), Integer.parseInt(txtNumero.getText()),
				new Localizacao("endereco", 0));
		Fachada.getInstance().cadastrar(vendedor);
	}
}
