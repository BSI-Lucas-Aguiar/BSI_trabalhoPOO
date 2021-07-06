package telas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import estaleiroNaval.Funcionario;
import estaleiroNaval.Projeto;
import persistencia.FabricaConexao;

import java.awt.Toolkit;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

public class TelaProjeto extends JFrame {

	private JPanel contentPane;
	private JTextField textoCodigoProjeto;
	private JTextField textoQuantidadeMaterial;
	private JTextField textoValorEmbarcacao;
	private JTable tabelaProjetos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaProjeto frame = new TelaProjeto();
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
	
	public TelaProjeto() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaProjeto.class.getResource("/imagens/icone_estaleiro.png")));
		setTitle("Controle de Projetos");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		setResizable(false);
		setLocationRelativeTo(null); //Centralizar a Janela
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea textoListarProjetos = new JTextArea();
		textoListarProjetos.setBounds(10, 351, 555, 150);
		contentPane.add(textoListarProjetos);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 208, 564, 142);
		contentPane.add(scrollPane);
		
		tabelaProjetos = new JTable();
		tabelaProjetos.setFont(new Font("Tahoma", Font.PLAIN, 11));
		tabelaProjetos.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"C\u00F3digo do Projeto", "Material Necess\u00E1rio", "Utilizado", "Vendido?", "Valor de Venda", "Tipo"
			}
			) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tabelaProjetos.getColumnModel().getColumn(0).setPreferredWidth(125);
		tabelaProjetos.getColumnModel().getColumn(1).setPreferredWidth(125);
		tabelaProjetos.getColumnModel().getColumn(2).setPreferredWidth(90);
		tabelaProjetos.getColumnModel().getColumn(2).setPreferredWidth(100);
		tabelaProjetos.getColumnModel().getColumn(4).setPreferredWidth(100);
		scrollPane.setViewportView(tabelaProjetos);
		
		
		JButton botaoListarProjetos = new JButton("Listar Projetos");
		botaoListarProjetos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					DefaultTableModel tabela = new DefaultTableModel();
					
					tabela.addColumn("Código do Projeto");
					tabela.addColumn("Material Necessário");
					tabela.addColumn("Utilizado");
					tabela.addColumn("Vendido?");
					tabela.addColumn("Valor de Venda");
					tabela.addColumn("Tipo");
					
					Projeto projeto = new Projeto();
					ArrayList<Projeto> listaProjeto = projeto.listarProjetos();
					
					if(listaProjeto != null) {
	                    for(Projeto p: listaProjeto) {
	                    	tabela.addRow(new String[]{
	                    		p.getCodigoProjeto(), 
	                    		Integer.toString(p.getQuantidadeMaterial()), 
	                    		Integer.toString(p.getMaterialUtilizado()), 
	                    		Boolean.toString(p.isVendido()), 
	                    		Double.toString(p.getValorEmbarcacao()), 
	                    		p.getTipo()
	                    	});
	                    }
	                    tabelaProjetos.setModel(tabela);
	                    //tabelaProjetos.setEnabled(false); //Bloqueia a seleção na tabela
	                }
					
					/*
	                //Conexão da FabricaConexao
					Connection conexao = FabricaConexao.getConexao();
					System.out.println("Conexão com o BD para listar os projetos!");

					Projeto proj = new Projeto();

	                //Pega os funcionários do BD e forma uma arraylist
	                ArrayList<Projeto> listaProjeto = proj.listarProjetos();

	                if(listaProjeto != null) {
	                	textoListarProjetos.setText("");
	                    for(Projeto p: listaProjeto) {
	                    	textoListarProjetos.setText(textoListarProjetos.getText()+ p.getCodigoProjeto()+" | "+ p.getQuantidadeMaterial()+" | "+p.getMaterialUtilizado()+" | "+p.isVendido()+" | "+p.getValorEmbarcacao()+" | "+p.getTipo()+ "\n");

	                    }
	                }
	                
	                JOptionPane.showMessageDialog(null, "Lista de Projetos Atualizada!");
	                conexao.close();
	                System.out.println("Conexão para listar Projetos finalizada!");

	            }
	            catch (SQLException ex) {
	                System.err.println("Erro na conexão do BD: "+ex.getMessage());
	            }
	            catch (Exception ex) {
	                System.err.println("Erro geral: "+ex.getMessage());
	            }
	            */
			}
		});
		botaoListarProjetos.setBounds(210, 149, 150, 23);
		contentPane.add(botaoListarProjetos);
		
		textoCodigoProjeto = new JTextField();
		textoCodigoProjeto.setBounds(10, 92, 150, 20);
		contentPane.add(textoCodigoProjeto);
		textoCodigoProjeto.setColumns(10);
		
		textoQuantidadeMaterial = new JTextField();
		textoQuantidadeMaterial.setBounds(415, 92, 150, 20);
		contentPane.add(textoQuantidadeMaterial);
		textoQuantidadeMaterial.setColumns(10);
		
		textoValorEmbarcacao = new JTextField();
		textoValorEmbarcacao.setBounds(210, 92, 150, 20);
		contentPane.add(textoValorEmbarcacao);
		textoValorEmbarcacao.setColumns(10);
		
		JComboBox comboBoxTipoEmbarcacao = new JComboBox();
		comboBoxTipoEmbarcacao.setModel(new DefaultComboBoxModel(new String[] {"Lancha"}));
		comboBoxTipoEmbarcacao.setBounds(10, 149, 150, 22);
		contentPane.add(comboBoxTipoEmbarcacao);
		
		JLabel labelProjetos = new JLabel("CONTROLE DE PROJETOS");
		labelProjetos.setFont(new Font("Tahoma", Font.BOLD, 22));
		labelProjetos.setHorizontalAlignment(SwingConstants.CENTER);
		labelProjetos.setBounds(0, 11, 584, 34);
		contentPane.add(labelProjetos);
		
		JLabel labelCodigoProjeto = new JLabel("C\u00F3digo do Projeto");
		labelCodigoProjeto.setLabelFor(textoCodigoProjeto);
		labelCodigoProjeto.setHorizontalAlignment(SwingConstants.CENTER);
		labelCodigoProjeto.setBounds(10, 67, 150, 14);
		contentPane.add(labelCodigoProjeto);
		
		JLabel labelQuantidadeMaterial = new JLabel("Quantidade de Material");
		labelQuantidadeMaterial.setLabelFor(textoQuantidadeMaterial);
		labelQuantidadeMaterial.setHorizontalAlignment(SwingConstants.CENTER);
		labelQuantidadeMaterial.setBounds(415, 67, 150, 14);
		contentPane.add(labelQuantidadeMaterial);
		
		JLabel labelValorEmbarcacao = new JLabel("Valor da Embarca\u00E7\u00E3o");
		labelValorEmbarcacao.setLabelFor(textoValorEmbarcacao);
		labelValorEmbarcacao.setHorizontalAlignment(SwingConstants.CENTER);
		labelValorEmbarcacao.setBounds(210, 67, 150, 14);
		contentPane.add(labelValorEmbarcacao);
		
		JLabel labelTipoEmbarcacao = new JLabel("Tipo de Embarca\u00E7\u00E3o");
		labelTipoEmbarcacao.setLabelFor(comboBoxTipoEmbarcacao);
		labelTipoEmbarcacao.setHorizontalAlignment(SwingConstants.CENTER);
		labelTipoEmbarcacao.setBounds(10, 124, 150, 14);
		contentPane.add(labelTipoEmbarcacao);
		
		JButton botaoCadastrarProjeto = new JButton("Cadastrar Projeto");
		botaoCadastrarProjeto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection conexao = FabricaConexao.getConexao();
					Statement cadastrarProjeto = conexao.createStatement();
					System.out.println("Conexão com o BD realizada para cadastro de projeto!");
					
					cadastrarProjeto.execute("USE estaleiro_naval;");
					cadastrarProjeto.execute("INSERT INTO lancha(codigoProjeto, quantidadeMaterial, materialUtilizado, vendido, valorEmbarcacao, tipo) VALUES ('"+textoCodigoProjeto.getText()+"','"+Integer.parseInt(textoQuantidadeMaterial.getText())+"','"+0+"','"+0+"','"+Double.parseDouble(textoValorEmbarcacao.getText())+"','"+comboBoxTipoEmbarcacao.getSelectedItem()+"');");
					
					conexao.close();
					System.out.println("Conexão para cadastro finalizada!");
					
					JOptionPane.showMessageDialog(null, "Projeto cadastrado!");
					
				} catch (Exception e1) {
					System.err.println("Erro no Cadastro de Projeto"+e1);
				}
			}
		});
		botaoCadastrarProjeto.setBounds(415, 123, 150, 23);
		contentPane.add(botaoCadastrarProjeto);
		
		JButton botaoAlterarProjeto = new JButton("Alterar Projeto");
		botaoAlterarProjeto.setBounds(415, 149, 150, 23);
		contentPane.add(botaoAlterarProjeto);
		
		JButton botaoDeletarProjeto = new JButton("Deletar Projeto");
		botaoDeletarProjeto.setBounds(415, 174, 150, 23);
		contentPane.add(botaoDeletarProjeto);
		
		
	}
}
