package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.Fachada;
import Model.PessoaNaoEncontradaException;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField tfNomeLogin;
	private JPasswordField pwdSenha;
	JPanel panelNovoMarceneiro = new JPanel();
	JPanel panelPrincipal = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panelPrincipal.setVisible(false);
		panelPrincipal.setBounds(0, 0, 414, 239);
		contentPane.add(panelPrincipal);
		panelPrincipal.setLayout(null);
		
		JButton btnNovoCliente = new JButton("Novo cliente");
		btnNovoCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cadastrar.getInstance().setVisible(true);
				Cadastrar.getInstance().rdbtnVendedor.setVisible(false);
				Cadastrar.getInstance().rdbtnMarceneiro.setVisible(false);
				Cadastrar.getInstance().rdbtnCliente.setSelected(true);
			}
		});
		btnNovoCliente.setBounds(10, 24, 116, 52);
		panelPrincipal.add(btnNovoCliente);
		
		JButton btnIrParaVendas = new JButton("Ir Para Vendas");
		btnIrParaVendas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Vendas.getInstance().setVisible(true);
			}
		});
		btnIrParaVendas.setBounds(10, 87, 116, 58);
		panelPrincipal.add(btnIrParaVendas);
		
		JButton btnRelatorios = new JButton("Relatorios");
		btnRelatorios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Relatorios.getInstance().setVisible(true);
			}
		});
		btnRelatorios.setBounds(10, 156, 116, 52);
		panelPrincipal.add(btnRelatorios);
		
		final JPanel panelEntrar = new JPanel();
		panelEntrar.setBounds(10, 11, 414, 239);
		contentPane.add(panelEntrar);
		panelEntrar.setLayout(null);
		
		JPanel panelLogin = new JPanel();
		panelLogin.setBounds(186, 11, 218, 114);
		panelEntrar.add(panelLogin);
		panelLogin.setLayout(null);
		
		JLabel lblLogin = new JLabel("Login:");
		lblLogin.setBounds(33, 11, 46, 14);
		panelLogin.add(lblLogin);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setBounds(30, 46, 46, 14);
		panelLogin.add(lblSenha);
		
		tfNomeLogin = new JTextField();
		tfNomeLogin.setBounds(84, 11, 116, 20);
		panelLogin.add(tfNomeLogin);
		tfNomeLogin.setColumns(10);
		
		pwdSenha = new JPasswordField();
		pwdSenha.setBounds(84, 40, 116, 20);
		panelLogin.add(pwdSenha);
		pwdSenha.setText("senha");
		
		JButton btnLogin = new JButton("Entrar");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					/*try {
						Fachada.getInstance().buscarVendedor(tfNomeLogin.getText()).ValidaSenha(new String(pwdSenha.getPassword()));
					} catch (PessoaNaoEncontradaException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}*/
					
					try {
						Fachada.getInstance().Logar(Fachada.getInstance().buscarVendedor(tfNomeLogin.getText()));
					} catch (PessoaNaoEncontradaException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					panelEntrar.setVisible(false);
					panelPrincipal.setVisible(true);
				
				
			}
		});
		btnLogin.setBounds(107, 67, 89, 23);
		panelLogin.add(btnLogin);
		
		panelNovoMarceneiro.setBounds(10, 115, 173, 113);
		panelEntrar.add(panelNovoMarceneiro);
		panelNovoMarceneiro.setLayout(null);
		
		JLabel lblNovoMarceneiro = new JLabel("Novo Marceneiro");
		lblNovoMarceneiro.setBounds(10, 11, 107, 14);
		panelNovoMarceneiro.add(lblNovoMarceneiro);
		
		JButton btnNewButton = new JButton("Cadastrar");
		btnNewButton.addActionListener(new ActionListener() {

	public void actionPerformed(ActionEvent arg0) {
				Cadastrar.getInstance().setVisible(true);;
				Cadastrar.getInstance().rdbtnCliente.setVisible(false);
				Cadastrar.getInstance().rdbtnMarceneiro.setVisible(false);
				Cadastrar.getInstance().rdbtnVendedor.setSelected(true);
			}
		});
		btnNewButton.setBounds(10, 36, 153, 66);
		panelNovoMarceneiro.add(btnNewButton);
	}
}
