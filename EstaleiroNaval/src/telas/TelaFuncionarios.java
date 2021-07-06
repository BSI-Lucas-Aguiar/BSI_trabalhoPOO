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
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Toolkit;
import java.awt.Font;

@SuppressWarnings("serial")
public class TelaFuncionarios extends JFrame {

	private JPanel contentPane;
	private JTextField textoNome;
	private JTextField textoCargo;
	private JTextField textoProjeto;

	//Iniciar a Tela
	//********************************************************************************************************
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

	public TelaFuncionarios() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaFuncionarios.class.getResource("/imagens/icone_estaleiro.png")));
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
		
		JTextArea textAreaFuncionarios = new JTextArea();
		textAreaFuncionarios.setEditable(false);
		textAreaFuncionarios.setBounds(10, 99, 243, 351);
		panel.add(textAreaFuncionarios);
		
		//Função de Listar os Funcionários
		//********************************************************************************************************
		JButton botaoListarFuncionarios = new JButton("Listar Funcion\u00E1rios");		
		botaoListarFuncionarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
	                //Conexão da FabricaConexao
					Connection conexao = FabricaConexao.getConexao();
					System.out.println("Conexão com o BD para listar funcionários!");

	                Funcionario funcionario = new Funcionario();

	                //Pega os funcionários do BD e forma uma arraylist
	                ArrayList<Funcionario> listaFuncionario = funcionario.listarFuncionario();

	                if(listaFuncionario != null) {
	                	textAreaFuncionarios.setText("");
	                    for(Funcionario f: listaFuncionario) {
	                    	textAreaFuncionarios.setText(textAreaFuncionarios.getText()+ f.getNome()+" | "+ f.getCargo()+" | "+f.getProjetoAtual()+"\n");

	                    }
	                }
	                
	                JOptionPane.showMessageDialog(null, "Lista de Funcionários Atualizada!");
	                conexao.close();
	                System.out.println("Conexão para listar funcionários finalizada!");

	            }
	            catch (SQLException ex) {
	                System.err.println("Erro na conexão do BD: "+ex.getMessage());
	            }
	            catch (Exception ex) {
	                System.err.println("Erro geral: "+ex.getMessage());
	            }
			}
		});
		botaoListarFuncionarios.setBounds(48, 65, 162, 23);
		panel.add(botaoListarFuncionarios);
		
		
		textoNome = new JTextField();
		textoNome.setBounds(276, 100, 360, 20);
		panel.add(textoNome);
		textoNome.setColumns(10);
		
		textoCargo = new JTextField();
		textoCargo.setBounds(276, 161, 360, 20);
		panel.add(textoCargo);
		textoCargo.setColumns(10);
		
		textoProjeto = new JTextField();
		textoProjeto.setBounds(276, 223, 360, 20);
		panel.add(textoProjeto);
		textoProjeto.setColumns(10);
		
		JLabel labelNome = new JLabel("Nome");
		labelNome.setLabelFor(textoNome);
		labelNome.setHorizontalAlignment(SwingConstants.CENTER);
		labelNome.setBounds(433, 75, 46, 14);
		panel.add(labelNome);
		
		JLabel labelCargo = new JLabel("Cargo");
		labelCargo.setLabelFor(textoCargo);
		labelCargo.setHorizontalAlignment(SwingConstants.CENTER);
		labelCargo.setBounds(433, 136, 46, 14);
		panel.add(labelCargo);
		
		JLabel labelProjeto = new JLabel("Projeto");
		labelProjeto.setLabelFor(textoProjeto);
		labelProjeto.setHorizontalAlignment(SwingConstants.CENTER);
		labelProjeto.setBounds(433, 198, 46, 14);
		panel.add(labelProjeto);
		
		//Botão Cadastrar Funcionário
		//********************************************************************************************************
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
					
					JOptionPane.showMessageDialog(null, "Funcionário cadastrado!");
					
				} catch (Exception e1) {
					System.err.println("Erro no cadastro de funcionário"+ e1);
				}
				
			}
		});
		botaoCadastrarFuncionario.setBounds(372, 294, 168, 23);
		panel.add(botaoCadastrarFuncionario);
		
		//Botão Demitir Funcionário
		//********************************************************************************************************
		JButton botaoDemitirFuncionario = new JButton("Demitir Funcion\u00E1rio");
		botaoDemitirFuncionario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Funcionario demissao = new Funcionario();
				
				demissao.setNome(textoNome.getText());
				demissao.setCargo(textoCargo.getText());
				demissao.setProjetoAtual(textoProjeto.getText());
				
				demissao.demitirFuncionario();
				
				JOptionPane.showMessageDialog(null, "Funcionário demitido!");
			}
		});
		botaoDemitirFuncionario.setBounds(372, 392, 168, 23);
		panel.add(botaoDemitirFuncionario);
		
		//Botão Alterar Dados
		//********************************************************************************************************
		JButton botaoAlterarDados = new JButton("Alterar Dados");
		botaoAlterarDados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Funcionario alterar = new Funcionario();
				
				alterar.setNome(textoNome.getText());
				alterar.setCargo(textoCargo.getText());
				alterar.setProjetoAtual(textoProjeto.getText());
				
				alterar.alterarDados();
				
			}
		});
		botaoAlterarDados.setBounds(372, 342, 168, 23);
		panel.add(botaoAlterarDados);
		
		JLabel labelInstrucoes = new JLabel("As altera\u00E7\u00F5es s\u00E3o feitas com base no \"Nome\"");
		labelInstrucoes.setHorizontalAlignment(SwingConstants.CENTER);
		labelInstrucoes.setBounds(276, 254, 360, 14);
		panel.add(labelInstrucoes);
		
		JLabel labelFuncionarios = new JLabel("CADASTRO DE FUNCION\u00C1RIOS");
		labelFuncionarios.setFont(new Font("Tahoma", Font.BOLD, 24));
		labelFuncionarios.setHorizontalAlignment(SwingConstants.CENTER);
		labelFuncionarios.setBounds(0, 11, 684, 32);
		panel.add(labelFuncionarios);
	}
}
