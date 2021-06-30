package telas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import estaleiroNaval.Compra;
import persistencia.FabricaConexao;

import java.awt.Toolkit;
import javax.swing.JTextArea;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Font;

@SuppressWarnings("serial")
public class TelaCadastroMateriais extends JFrame {

	private JPanel contentPane;
	private JTextField textoNomeMaterial;
	private JTextField textoPrecoMaterial;

	//Iniciar a Tela
	//********************************************************************************************************
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroMateriais frame = new TelaCadastroMateriais();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public TelaCadastroMateriais() {
		setTitle("Cadastro de Materiais");
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaCadastroMateriais.class.getResource("/imagens/icone_estaleiro.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		setResizable(false);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JTextArea textAreaCompra = new JTextArea();
		textAreaCompra.setBounds(10, 235, 554, 105);
		panel.add(textAreaCompra);
		
		//Botão Listar Materiais
		//********************************************************************************************************
		JButton botaoListarMateriais = new JButton("Listar Materiais");
		botaoListarMateriais.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
	                //Conexão da FabricaConexao
					Connection conexao = FabricaConexao.getConexao();
					System.out.println("Conexão com o BD para listar funcionários!");

	                Compra compra = new Compra();
	                
	                //Pega os materiais e forma um arraylist
	                ArrayList<Compra> listaCompra = compra.listarCompra();

	                if(listaCompra != null) {
	                	textAreaCompra.setText("");
	                    for(Compra c: listaCompra) {
	                    	textAreaCompra.setText(textAreaCompra.getText()+ c.getNomeMaterial()+" | "+ c.getPrecoMaterial()+"\n");

	                    }
	                }
	                
	                JOptionPane.showMessageDialog(null, "Lista de Materiais Atualizada!");
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
		botaoListarMateriais.setBounds(218, 201, 145, 23);
		panel.add(botaoListarMateriais);
		
		textoNomeMaterial = new JTextField();
		textoNomeMaterial.setBounds(10, 74, 145, 20);
		panel.add(textoNomeMaterial);
		textoNomeMaterial.setColumns(10);
		
		JLabel labelCadastroMateriais = new JLabel("Cadastro de Materiais");
		labelCadastroMateriais.setHorizontalAlignment(SwingConstants.CENTER);
		labelCadastroMateriais.setFont(new Font("Tahoma", Font.BOLD, 20));
		labelCadastroMateriais.setBounds(0, 11, 584, 25);
		panel.add(labelCadastroMateriais);
		
		JLabel labelNomeMaterial = new JLabel("Nome do Material");
		labelNomeMaterial.setLabelFor(textoNomeMaterial);
		labelNomeMaterial.setBounds(10, 49, 102, 14);
		panel.add(labelNomeMaterial);
		
		JLabel labelPreçoMaterial = new JLabel("Pre\u00E7o do Material");
		labelPreçoMaterial.setBounds(10, 105, 102, 14);
		panel.add(labelPreçoMaterial);
		
		textoPrecoMaterial = new JTextField();
		labelPreçoMaterial.setLabelFor(textoPrecoMaterial);
		textoPrecoMaterial.setBounds(10, 130, 145, 20);
		panel.add(textoPrecoMaterial);
		textoPrecoMaterial.setColumns(10);
		
		//Botão Cadastrar Material
		//********************************************************************************************************
		JButton botaoCadastrarMaterial = new JButton("Cadastrar Material");
		botaoCadastrarMaterial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection conexao = FabricaConexao.getConexao();
					Statement cadastrarMaterial= conexao.createStatement();
					System.out.println("Conexão com o BD realizada para cadastro!");
					
					cadastrarMaterial.execute("USE estaleiro_naval;");
					cadastrarMaterial.execute("INSERT INTO compra(nomeMaterial, precoMaterial) VALUES ('"+textoNomeMaterial.getText()+"','"+Double.parseDouble(textoPrecoMaterial.getText())+"')");
					
					
					conexao.close();
					System.out.println("Conexão para cadastro finalizada!");
					
					JOptionPane.showMessageDialog(null, "Material removido do BD!");
					
				} catch (Exception e1) {
					
					e1.printStackTrace();
				}
			}
		});
		botaoCadastrarMaterial.setBounds(10, 161, 145, 23);
		panel.add(botaoCadastrarMaterial);
		
		//Botão Excluir Material
		//********************************************************************************************************
		JButton botaoExcluirMaterial = new JButton("Remover Material");
		botaoExcluirMaterial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Compra material = new Compra();
				
				material.setNomeMaterial(textoNomeMaterial.getText());
				
				material.removerMaterial();
				
				JOptionPane.showMessageDialog(null, "Material cadastrado no BD!");
			}
		});
		botaoExcluirMaterial.setBounds(218, 161, 145, 23);
		panel.add(botaoExcluirMaterial);
		
		JLabel labelPonto = new JLabel("Double, use ponto Ex: 5.50");
		labelPonto.setBounds(165, 133, 152, 14);
		panel.add(labelPonto);
		
		//Botão Alterar Material - Altera o preço de um material
		//********************************************************************************************************
		JButton labelAlterarMaterial = new JButton("Editar Pre\u00E7o");
		labelAlterarMaterial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Compra alterar = new Compra();
				
				alterar.setNomeMaterial(textoNomeMaterial.getText());
				alterar.setPrecoMaterial(textoPrecoMaterial.getText());
				
				alterar.alterarDados();
				
			}
		});
		labelAlterarMaterial.setBounds(419, 161, 145, 23);
		panel.add(labelAlterarMaterial);
	}
}
