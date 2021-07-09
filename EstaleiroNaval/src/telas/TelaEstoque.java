package telas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import estaleiroNaval.Caixa;
import estaleiroNaval.Compra;
import estaleiroNaval.Estoque;
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

@SuppressWarnings("serial")
public class TelaEstoque extends JFrame {

	private JPanel contentPane;
	private JTextField textoRetirarMaterial;
	private JTextField textoNome;
	private JTextField textoQuantidade;
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
		
		textoRetirarMaterial = new JTextField();
		textoRetirarMaterial.setToolTipText("Quantidade de material a ser retirada do estoque;");
		textoRetirarMaterial.setHorizontalAlignment(SwingConstants.LEFT);
		textoRetirarMaterial.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textoRetirarMaterial.setForeground(Color.BLACK);
		textoRetirarMaterial.setColumns(10);
		textoRetirarMaterial.setBounds(367, 239, 160, 25);
		panel.add(textoRetirarMaterial);
		
		//Bot�o Retirar material
		//********************************************************************************************************
		JButton botaoRetirarMaterial = new JButton("Retirar Material");
		botaoRetirarMaterial.setBounds(367, 275, 160, 55);
		panel.add(botaoRetirarMaterial);
		
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
	                //Conex�o da FabricaConexao
					Connection conexao = FabricaConexao.getConexao();
					System.out.println("Conex�o com o BD para listar funcion�rios!");

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
	                System.out.println("Conex�o para listar funcion�rios finalizada!");

	            }
	            catch (SQLException ex) {
	                System.err.println("Erro na conex�o do BD: "+ex.getMessage());
	            }
	            catch (Exception ex) {
	                System.err.println("Erro geral: "+ex.getMessage());
	            }
			}
		});
		botaoListarMateriais.setBounds(51, 225, 171, 23);
		panel.add(botaoListarMateriais);
		
		textoNome = new JTextField();
		textoNome.setBounds(367, 98, 160, 20);
		panel.add(textoNome);
		textoNome.setColumns(10);
		
		JLabel labelNome = new JLabel("Nome do Material");
		labelNome.setLabelFor(textoNome);
		labelNome.setHorizontalAlignment(SwingConstants.CENTER);
		labelNome.setBounds(384, 83, 126, 14);
		panel.add(labelNome);
		
		textoQuantidade = new JTextField();
		textoQuantidade.setColumns(10);
		textoQuantidade.setBounds(367, 143, 160, 20);
		panel.add(textoQuantidade);
		
		JLabel labelQuantidadeDeMaterial = new JLabel("Quantidade de Material");
		labelQuantidadeDeMaterial.setLabelFor(textoQuantidade);
		labelQuantidadeDeMaterial.setHorizontalAlignment(SwingConstants.CENTER);
		labelQuantidadeDeMaterial.setBounds(384, 129, 126, 14);
		panel.add(labelQuantidadeDeMaterial);
		
		JButton botaoComprarMaterial = new JButton("Comprar Material");
		botaoComprarMaterial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
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
		textoMaterialEmEstoque.setBounds(161, 82, 88, 20);
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
		textoSaldoCaixa.setBounds(161, 126, 88, 20);
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
	                
	                textoSaldoCaixa.setText(totalCaixa);
	                
	                JOptionPane.showMessageDialog(null, "Saldo Atualizado!");
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
			}
		});
		botaoAtualizar.setBounds(160, 168, 89, 23);
		panel.add(botaoAtualizar);
	}
}
