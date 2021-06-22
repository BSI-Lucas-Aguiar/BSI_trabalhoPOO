package telas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import estaleiroNaval.Funcionario;
import persistencia.FabricaConexao;

import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class TelaFuncionarios extends JFrame {

	private JPanel contentPane;
	private JTextField textoNome;
	private JTextField textoCargo;
	private JTextField textoProjeto;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaFuncionarios frame = new TelaFuncionarios();
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
	public TelaFuncionarios() {
		setTitle("Funcion\u00E1rios do Estaleiro");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 700, 500);
		setResizable(false);
		setLocationRelativeTo(null);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JButton botaoListarFuncionarios = new JButton("Listar Funcion\u00E1rios");		
		botaoListarFuncionarios.setBounds(47, 11, 162, 23);
		panel.add(botaoListarFuncionarios);
		
		JTextArea textAreaFuncionarios = new JTextArea();
		textAreaFuncionarios.setEditable(false);
		textAreaFuncionarios.setBounds(10, 54, 243, 396);
		panel.add(textAreaFuncionarios);
		
		textoNome = new JTextField();
		textoNome.setBounds(276, 56, 360, 20);
		panel.add(textoNome);
		textoNome.setColumns(10);
		
		textoCargo = new JTextField();
		textoCargo.setBounds(276, 117, 360, 20);
		panel.add(textoCargo);
		textoCargo.setColumns(10);
		
		textoProjeto = new JTextField();
		textoProjeto.setBounds(276, 179, 360, 20);
		panel.add(textoProjeto);
		textoProjeto.setColumns(10);
		
		JLabel labelNome = new JLabel("Nome");
		labelNome.setHorizontalAlignment(SwingConstants.CENTER);
		labelNome.setBounds(433, 31, 46, 14);
		panel.add(labelNome);
		
		JLabel labelCargo = new JLabel("Cargo");
		labelCargo.setHorizontalAlignment(SwingConstants.CENTER);
		labelCargo.setBounds(433, 92, 46, 14);
		panel.add(labelCargo);
		
		JLabel labelProjeto = new JLabel("Projeto");
		labelProjeto.setHorizontalAlignment(SwingConstants.CENTER);
		labelProjeto.setBounds(433, 154, 46, 14);
		panel.add(labelProjeto);
		
		JButton botaoCadastrarFuncionario = new JButton("Cadastrar Funcion\u00E1rio");
		botaoCadastrarFuncionario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					Connection conexao = FabricaConexao.getConexao();
					Statement cadastrarFuncionario = conexao.createStatement();
					System.out.println("Conexão com o BD realizada para cadastro!");
					
					cadastrarFuncionario.execute("USE estaleiro_naval;");
					cadastrarFuncionario.execute("INSERT INTO funcionario(nome, cargo, projetoAtual) VALUES ('"+textoNome.getText()+"','"+textoCargo.getText()+"','"+textoProjeto.getText()+"');");
					
					conexao.close();
					System.out.println("Conexão para cadastro finalizada!");
					
				} catch (Exception e1) {
					
					e1.printStackTrace();
				}
				
			}
		});
		botaoCadastrarFuncionario.setBounds(276, 250, 168, 23);
		panel.add(botaoCadastrarFuncionario);
		
		JButton botaoDemitirFuncionario = new JButton("Demitir Funcion\u00E1rio");
		botaoDemitirFuncionario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		botaoDemitirFuncionario.setBounds(276, 309, 168, 23);
		panel.add(botaoDemitirFuncionario);
		
		JButton botaoAlterarProjeto = new JButton("Alterar Projeto");
		botaoAlterarProjeto.setBounds(510, 250, 126, 23);
		panel.add(botaoAlterarProjeto);
	}
}
