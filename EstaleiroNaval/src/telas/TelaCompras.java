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
import javax.swing.ImageIcon;

@SuppressWarnings("serial")
public class TelaCompras extends JFrame {

	private JPanel contentPane;
	private JTextField textoQuantidade;
	private JTextField textoInformarMaterial;
	private JTextField textoNomeMaterial;
	private JTextField textoPrecoMaterial;

	//Iniciar a Tela
	//********************************************************************************************************
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCompras frame = new TelaCompras();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public TelaCompras() {
		setTitle("Compras");
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaCompras.class.getResource("/imagens/icone_estaleiro.png")));
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
		
		textoQuantidade = new JTextField();
		textoQuantidade.setToolTipText("Informe a quantidade de material.");
		textoQuantidade.setBounds(24, 79, 152, 20);
		panel.add(textoQuantidade);
		textoQuantidade.setColumns(10);
		
		//Botão de comprar Material ainda não implementado - Depende da classe estoque e caixa ainda não criadas
		//********************************************************************************************************
		JButton botaoComprarMaterial = new JButton("Comprar Material");
		botaoComprarMaterial.setBounds(24, 108, 152, 23);
		panel.add(botaoComprarMaterial);
		
		textoInformarMaterial = new JTextField();
		textoInformarMaterial.setToolTipText("Informe qual material.");
		textoInformarMaterial.setBounds(24, 30, 152, 20);
		panel.add(textoInformarMaterial);
		textoInformarMaterial.setColumns(10);
		
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
		botaoListarMateriais.setBounds(204, 201, 136, 23);
		panel.add(botaoListarMateriais);
		
		textoNomeMaterial = new JTextField();
		textoNomeMaterial.setBounds(428, 63, 118, 20);
		panel.add(textoNomeMaterial);
		textoNomeMaterial.setColumns(10);
		
		JLabel labelCadastroMateriais = new JLabel("Cadastro de Materiais");
		labelCadastroMateriais.setBounds(410, 14, 126, 14);
		panel.add(labelCadastroMateriais);
		
		JLabel labelNomeMaterial = new JLabel("Nome do Material");
		labelNomeMaterial.setLabelFor(textoNomeMaterial);
		labelNomeMaterial.setBounds(428, 46, 102, 14);
		panel.add(labelNomeMaterial);
		
		JLabel labelMaterial = new JLabel("Material - Somente ser\u00E1 implementado no futuro");
		labelMaterial.setHorizontalAlignment(SwingConstants.CENTER);
		labelMaterial.setBounds(24, 14, 244, 14);
		panel.add(labelMaterial);
		
		JLabel labelQuantidade = new JLabel("Quantidade - Somente ser\u00E1 implementado no futuro");
		labelQuantidade.setHorizontalAlignment(SwingConstants.CENTER);
		labelQuantidade.setBounds(24, 61, 258, 14);
		panel.add(labelQuantidade);
		
		JLabel labelPreçoMaterial = new JLabel("Pre\u00E7o do Material");
		labelPreçoMaterial.setBounds(428, 94, 102, 14);
		panel.add(labelPreçoMaterial);
		
		textoPrecoMaterial = new JTextField();
		textoPrecoMaterial.setBounds(428, 109, 118, 20);
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
		botaoCadastrarMaterial.setBounds(401, 138, 145, 23);
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
		botaoExcluirMaterial.setBounds(401, 172, 145, 23);
		panel.add(botaoExcluirMaterial);
		
		JLabel labelPonto = new JLabel("Double se ponto Ex: 5.50");
		labelPonto.setBounds(280, 112, 152, 14);
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
		labelAlterarMaterial.setBounds(401, 206, 145, 23);
		panel.add(labelAlterarMaterial);
		
		JLabel labelFundoCompra = new JLabel("");
		labelFundoCompra.setIcon(new ImageIcon(TelaCompras.class.getResource("/imagens/fundo_compra.jpg")));
		labelFundoCompra.setBounds(0, -691, 866, 1200);
		panel.add(labelFundoCompra);
	}
}
