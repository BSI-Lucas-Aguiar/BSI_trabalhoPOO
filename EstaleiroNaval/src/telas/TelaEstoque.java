package telas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;
import javax.swing.table.DefaultTableModel;

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
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JScrollPane;

@SuppressWarnings("serial")
public class TelaEstoque extends JFrame {

	private JPanel contentPane;
	private JTextField textoQuantidadeMaterial;
	private JTextField textoMaterialEmEstoque;
	private JTextField textoSaldoCaixa;
	private JTable tabelaListaMateriais;
	private JTextField textoPrecoUnitario;
	
	//Iniciar a Tela
	//********************************************************************************************************
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
		labelProjeto.setBounds(321, 235, 160, 14);
		panel.add(labelProjeto);
		
		JComboBox <Object> comboBoxProjetos = new JComboBox<>();
		comboBoxProjetos.setBounds(321, 260, 160, 22);
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
		botaoUtilizarMaterial.setBounds(321, 304, 160, 29);
		panel.add(botaoUtilizarMaterial);
		
		JLabel labelEstoque = new JLabel("ESTOQUE DE MATERIAIS");
		labelEstoque.setHorizontalAlignment(SwingConstants.CENTER);
		labelEstoque.setForeground(Color.BLACK);
		labelEstoque.setFont(new Font("Segoe UI Black", Font.BOLD, 34));
		labelEstoque.setBounds(0, 21, 584, 36);
		panel.add(labelEstoque);
		
		//Tabela
		//********************************************************************************************************
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(25, 264, 224, 86);
		panel.add(scrollPane);
		
		tabelaListaMateriais = new JTable();
		scrollPane.setViewportView(tabelaListaMateriais);
		DefaultTableModel modelo = new DefaultTableModel();
    	modelo.addColumn("Materiais");
    	modelo.addColumn("Preço");
    	tabelaListaMateriais.setModel(modelo);
		
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
	                
	                //Limpa tabela
	                modelo.setRowCount(0);
	                if(listaCompra != null) {
	                	for(Compra c: listaCompra) {
	                		modelo.addRow(new String[] {c.getNomeMaterial(), c.getPrecoMaterial()} );
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
		
		JLabel labelNome = new JLabel("Nome do Material");
		labelNome.setHorizontalAlignment(SwingConstants.CENTER);
		labelNome.setBounds(321, 68, 160, 29);
		panel.add(labelNome);
		
		textoQuantidadeMaterial = new JTextField();
		textoQuantidadeMaterial.setColumns(10);
		textoQuantidadeMaterial.setBounds(321, 151, 160, 20);
		panel.add(textoQuantidadeMaterial);
		
		JLabel labelQuantidadeDeMaterial = new JLabel("Quantidade de Material");
		labelQuantidadeDeMaterial.setLabelFor(textoQuantidadeMaterial);
		labelQuantidadeDeMaterial.setHorizontalAlignment(SwingConstants.CENTER);
		labelQuantidadeDeMaterial.setBounds(321, 126, 160, 25);
		panel.add(labelQuantidadeDeMaterial);
		
		//Combo Box Lista de Materiais
		////********************************************************************************************************
		JComboBox<Object> comboBoxNomeMateriais = new JComboBox<>();
		comboBoxNomeMateriais.setBounds(321, 95, 160, 22);
		panel.add(comboBoxNomeMateriais);
		comboBoxNomeMateriais.addPopupMenuListener(new PopupMenuListener() {
			public void popupMenuWillBecomeInvisible(PopupMenuEvent e) {
	            
	            String querySQL = "SELECT * FROM estaleiro_naval.compra WHERE nomeMaterial = ?";
	            
	            try {
	            	Connection conexao = FabricaConexao.getConexao();
	                PreparedStatement ps = conexao.prepareStatement(querySQL);
	                ps.setString(1,(String) comboBoxNomeMateriais.getSelectedItem());
	                
	                ResultSet rs = ps.executeQuery();
	                
	                if(comboBoxNomeMateriais.getSelectedItem().equals("") == true) {
                		textoPrecoUnitario.setText("");
                	}
	                
	                if(rs.next()) {
	                	textoPrecoUnitario.setText(Double.toString(rs.getDouble("precoMaterial")));
	                }
	                conexao.close();
	            } 
	            catch (Exception e2) {
	            	System.err.println("Erro: "+e2);
	            }
			}
		
			@Override
	        public void popupMenuWillBecomeVisible(PopupMenuEvent e) {
	            // TODO Auto-generated method stub
	            
	        }
	
	        @Override
	        public void popupMenuCanceled(PopupMenuEvent e) {
	            // TODO Auto-generated method stub
	            
	        }
		});        
		        
		Compra comp  = new Compra();
		ArrayList<Compra> listaCompra = comp.listarCompra();
		comboBoxNomeMateriais.addItem("");
		for(Compra c:listaCompra) {
			comboBoxNomeMateriais.addItem(c.getNomeMaterial());
		}
		
		//Botão Comprar Material
		//********************************************************************************************************
		JButton botaoComprarMaterial = new JButton("Comprar Material");
		botaoComprarMaterial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Estoque estoque = new Estoque();
				
				String nomeMaterial = (String)comboBoxNomeMateriais.getSelectedItem();
				int quantidadeMaterialBD = Integer.parseInt(textoQuantidadeMaterial.getText()) ;
				
				estoque.comprarMaterial(nomeMaterial, quantidadeMaterialBD);
				
			}
		});
		botaoComprarMaterial.setBounds(321, 191, 160, 23);
		panel.add(botaoComprarMaterial);
		
		JLabel labelMaterialEmEstoque = new JLabel("Material em Estoque");
		labelMaterialEmEstoque.setHorizontalAlignment(SwingConstants.CENTER);
		labelMaterialEmEstoque.setBounds(51, 75, 171, 14);
		panel.add(labelMaterialEmEstoque);
		
		textoMaterialEmEstoque = new JTextField();
		labelMaterialEmEstoque.setLabelFor(textoMaterialEmEstoque);
		textoMaterialEmEstoque.setEditable(false);
		textoMaterialEmEstoque.setBounds(51, 96, 171, 20);
		panel.add(textoMaterialEmEstoque);
		textoMaterialEmEstoque.setColumns(10);
		
		JLabel labelDinheiroEmCaixa = new JLabel("Saldo Em Caixa");
		labelDinheiroEmCaixa.setHorizontalAlignment(SwingConstants.CENTER);
		labelDinheiroEmCaixa.setBounds(51, 129, 171, 22);
		panel.add(labelDinheiroEmCaixa);
		
		textoSaldoCaixa = new JTextField();
		labelDinheiroEmCaixa.setLabelFor(textoSaldoCaixa);
		textoSaldoCaixa.setEditable(false);
		textoSaldoCaixa.setColumns(10);
		textoSaldoCaixa.setBounds(51, 154, 171, 20);
		panel.add(textoSaldoCaixa);
		
		//Botão Atualizar dados
		//********************************************************************************************************
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
		botaoAtualizar.setBounds(51, 191, 171, 23);
		panel.add(botaoAtualizar);
		
		JLabel labelPrecoUnidade = new JLabel("Pre\u00E7o Un.");
		labelPrecoUnidade.setHorizontalAlignment(SwingConstants.CENTER);
		labelPrecoUnidade.setBounds(491, 75, 83, 14);
		panel.add(labelPrecoUnidade);
		
		textoPrecoUnitario = new JTextField();
		textoPrecoUnitario.setEditable(false);
		textoPrecoUnitario.setBounds(491, 96, 86, 20);
		panel.add(textoPrecoUnitario);
		textoPrecoUnitario.setColumns(10);
		
		
		
		
				
	}
}
