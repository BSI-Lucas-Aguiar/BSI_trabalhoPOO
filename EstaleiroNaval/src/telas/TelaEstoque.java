package telas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import estaleiroNaval.Caixa;
import estaleiroNaval.Compra;
import estaleiroNaval.Estoque;
import estaleiroNaval.Projeto;
import persistencia.FabricaConexao;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

@SuppressWarnings("serial")
public class TelaEstoque extends JFrame {

	private JPanel contentPane;
	private JTextField textoNomeMaterial;
	private JTextField textoQuantidadeMaterial;
	private JTextField textoMaterialEmEstoque;
	private JTextField textoSaldoCaixa;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaEstoque frame = new TelaEstoque();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public TelaEstoque() {
		setTitle("Estoque de Materiais");
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaEstoque.class.getResource("/imagens/icone_estaleiro.png")));
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
		
		//Combo Box - Lista de Projetos
		JLabel labelProjeto = new JLabel("Projeto Selecionado");
		labelProjeto.setHorizontalAlignment(SwingConstants.CENTER);
		labelProjeto.setBounds(367, 229, 160, 14);
		panel.add(labelProjeto);
		
		JComboBox <Object> comboBoxProjetos = new JComboBox<>();
		comboBoxProjetos.setBounds(367, 260, 160, 22);
		panel.add(comboBoxProjetos);
		Projeto proj = new Projeto();
		ArrayList<Projeto> listaProj = proj.listarProjetos();
		for(Projeto p:listaProj) {
			comboBoxProjetos.addItem(p.getCodigoProjeto());
		}
		
		//Botão Retirar material
		//********************************************************************************************************
		JButton botaoUtilizarMaterial = new JButton("Utilizar Material");
		botaoUtilizarMaterial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String projeto = (String)comboBoxProjetos.getSelectedItem();
				
				//Buscando a quantidade de material em estoque
				Estoque estoqueMat = new Estoque();
				int totalEstoque;
				totalEstoque = (estoqueMat.listarEstoque());
				
				//Pergunta de material
				int qtdMaterial = Integer.parseInt(JOptionPane.showInputDialog("Informe a quantidade de material que será colocada no: "+projeto+"\nTotal em estoque: "+totalEstoque));
				
				//Verificar quantidade no estoque
				if(totalEstoque >= qtdMaterial) {
					Estoque estoque = new Estoque();
					estoque.retirarMaterial(qtdMaterial, projeto);
				}else {
					JOptionPane.showMessageDialog(null, "Não há material suficiente no estoque.");
				}
			}
		});
		botaoUtilizarMaterial.setBounds(367, 304, 160, 29);
		panel.add(botaoUtilizarMaterial);
		
		JLabel labelEstoque = new JLabel("ESTOQUE DE MATERIAIS");
		labelEstoque.setHorizontalAlignment(SwingConstants.CENTER);
		labelEstoque.setForeground(Color.BLACK);
		labelEstoque.setFont(new Font("Segoe UI Black", Font.BOLD, 34));
		labelEstoque.setBounds(0, 21, 584, 36);
		panel.add(labelEstoque);
		
		JTextArea textAreaCompra = new JTextArea();
		textAreaCompra.setBounds(25, 259, 224, 91);
		panel.add(textAreaCompra);
		
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
		botaoListarMateriais.setBounds(51, 225, 171, 23);
		panel.add(botaoListarMateriais);
		
		textoNomeMaterial = new JTextField();
		textoNomeMaterial.setBounds(367, 98, 160, 20);
		panel.add(textoNomeMaterial);
		textoNomeMaterial.setColumns(10);
		
		JLabel labelNome = new JLabel("Nome do Material");
		labelNome.setLabelFor(textoNomeMaterial);
		labelNome.setHorizontalAlignment(SwingConstants.CENTER);
		labelNome.setBounds(384, 83, 126, 14);
		panel.add(labelNome);
		
		textoQuantidadeMaterial = new JTextField();
		textoQuantidadeMaterial.setColumns(10);
		textoQuantidadeMaterial.setBounds(367, 143, 160, 20);
		panel.add(textoQuantidadeMaterial);
		
		JLabel labelQuantidadeDeMaterial = new JLabel("Quantidade de Material");
		labelQuantidadeDeMaterial.setLabelFor(textoQuantidadeMaterial);
		labelQuantidadeDeMaterial.setHorizontalAlignment(SwingConstants.CENTER);
		labelQuantidadeDeMaterial.setBounds(384, 129, 126, 14);
		panel.add(labelQuantidadeDeMaterial);
		
		JButton botaoComprarMaterial = new JButton("Comprar Material");
		botaoComprarMaterial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Estoque estoque = new Estoque();
				
				String nomeMaterial = textoNomeMaterial.getText();
				int quantidadeMaterialBD = Integer.parseInt(textoQuantidadeMaterial.getText()) ;
				
				estoque.comprarMaterial(nomeMaterial, quantidadeMaterialBD);
				
			}
		});
		botaoComprarMaterial.setBounds(367, 182, 160, 23);
		panel.add(botaoComprarMaterial);
		
		JLabel labelMaterialEmEstoque = new JLabel("Material em Estoque");
		labelMaterialEmEstoque.setHorizontalAlignment(SwingConstants.CENTER);
		labelMaterialEmEstoque.setBounds(25, 83, 126, 14);
		panel.add(labelMaterialEmEstoque);
		
		textoMaterialEmEstoque = new JTextField();
		labelMaterialEmEstoque.setLabelFor(textoMaterialEmEstoque);
		textoMaterialEmEstoque.setEditable(false);
		textoMaterialEmEstoque.setBounds(152, 82, 97, 20);
		panel.add(textoMaterialEmEstoque);
		textoMaterialEmEstoque.setColumns(10);
		
		JLabel labelDinheiroEmCaixa = new JLabel("Saldo Em Caixa");
		labelDinheiroEmCaixa.setHorizontalAlignment(SwingConstants.CENTER);
		labelDinheiroEmCaixa.setBounds(25, 129, 126, 14);
		panel.add(labelDinheiroEmCaixa);
		
		textoSaldoCaixa = new JTextField();
		labelDinheiroEmCaixa.setLabelFor(textoSaldoCaixa);
		textoSaldoCaixa.setEditable(false);
		textoSaldoCaixa.setColumns(10);
		textoSaldoCaixa.setBounds(152, 126, 97, 20);
		panel.add(textoSaldoCaixa);
		
		JButton botaoAtualizar = new JButton("Atualizar");
		botaoAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Atualizar Saldo em Caixa
				try {
	                //Pegar o valor do BD
	                Caixa caixa = new Caixa();
	                
	                String totalCaixa;
	                totalCaixa = Double.toString(caixa.consultarTotal());
	                
	                textoSaldoCaixa.setText("R$ "+totalCaixa);
	                
	                
				}
	            catch (Exception ex) {
	                System.err.println("Erro geral: "+ex.getMessage());
	            }
				//Atualizar Quantidade de material
				try {
					Estoque estoque = new Estoque();
					
					String totalEstoque;
					totalEstoque = Integer.toString(estoque.listarEstoque());
					
					textoMaterialEmEstoque.setText(totalEstoque);
					
				} 
				catch (Exception e1) {
					System.err.println("Erro na listagem de estoque."+e1);
				}
				//Confirmação JOptionPane
				JOptionPane.showMessageDialog(null, "Informações Atualizadas!");
			}
		});
		botaoAtualizar.setBounds(152, 168, 97, 23);
		panel.add(botaoAtualizar);
		
		
				
	}
}
