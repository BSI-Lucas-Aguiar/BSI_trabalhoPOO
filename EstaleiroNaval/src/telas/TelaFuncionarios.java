package telas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import estaleiroNaval.Funcionario;
import persistencia.DadosMYSQL;

import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class TelaFuncionarios extends JFrame {

	private JPanel contentPane;

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
		setResizable(false);
		setLocationRelativeTo(null);
		setBounds(100, 100, 700, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JButton botaoListarFuncionarios = new JButton("Listar Funcion\u00E1rios");
		/*botaoListarFuncionarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String url = DadosMYSQL.getUrl();
				String usuario = DadosMYSQL.getUsuario(); 
				String senha = DadosMYSQL.getSenha(); 
				
				Connection conexao;
				try {
					conexao = DriverManager
							.getConnection(url, usuario, senha);
					//Código
					ArrayList<Funcionario> listaFuncionarios = 
					
					
					System.out.println("Conexão Caixa!");
					conexao.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
				
				
				System.out.println("Conexão Caixa finalizada!");
			}
		});
		*/
		botaoListarFuncionarios.setBounds(47, 11, 138, 23);
		panel.add(botaoListarFuncionarios);
		
		JTextArea textAreaFuncionarios = new JTextArea();
		textAreaFuncionarios.setEditable(false);
		textAreaFuncionarios.setBounds(10, 54, 215, 396);
		panel.add(textAreaFuncionarios);
	}
}
