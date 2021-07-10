package telas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;

import estaleiroNaval.Caixa;
import estaleiroNaval.Projeto;

import javax.swing.JScrollPane;
import javax.swing.JTable;

@SuppressWarnings("serial")
public class TelaCaixa extends JFrame {

	private JPanel contentPane;
	private JTextField textoNomeProjeto;
	private JTextField textoSaldoCaixa;
	private JTable tabelaProjetos;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCaixa frame = new TelaCaixa();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public TelaCaixa() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaCaixa.class.getResource("/imagens/icone_estaleiro.png")));
		setTitle("Caixa");
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
		
		//Botão que chama a função de mostrar o Saldo em caixa - Ainda não implementado
		//********************************************************************************************************
		JButton botaoSaldoEmCaixa = new JButton("Saldo em Caixa");
		botaoSaldoEmCaixa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
			}
		});
		botaoSaldoEmCaixa.setBounds(60, 106, 143, 23);
		panel.add(botaoSaldoEmCaixa);
		
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
			}
		});
		botaoListarProjetos.setBounds(205, 174, 188, 23);
		panel.add(botaoListarProjetos);
		
		JLabel labelNomeProjeto = new JLabel("Nome do Projeto");
		labelNomeProjeto.setHorizontalAlignment(SwingConstants.CENTER);
		labelNomeProjeto.setBounds(391, 50, 143, 14);
		panel.add(labelNomeProjeto);
		
		textoNomeProjeto = new JTextField();
		labelNomeProjeto.setLabelFor(textoNomeProjeto);
		textoNomeProjeto.setBounds(391, 75, 143, 20);
		panel.add(textoNomeProjeto);
		textoNomeProjeto.setColumns(10);
		
		JButton botaoVenderProjeto = new JButton("Vender Projeto");
		botaoVenderProjeto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Caixa caixa = new Caixa();
				
				caixa.venderProjeto(textoNomeProjeto.getText());
			}
		});
		botaoVenderProjeto.setBounds(391, 106, 143, 23);
		panel.add(botaoVenderProjeto);
		
		JLabel labelAdministracaoCaixa = new JLabel("ADMINISTRA\u00C7\u00C3O DE CAIXA");
		labelAdministracaoCaixa.setFont(new Font("Tahoma", Font.BOLD, 17));
		labelAdministracaoCaixa.setHorizontalAlignment(SwingConstants.CENTER);
		labelAdministracaoCaixa.setBounds(0, 11, 584, 24);
		panel.add(labelAdministracaoCaixa);
		
		textoSaldoCaixa = new JTextField();
		textoSaldoCaixa.setEditable(false);
		textoSaldoCaixa.setBounds(60, 75, 143, 20);
		panel.add(textoSaldoCaixa);
		textoSaldoCaixa.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 208, 564, 142);
		panel.add(scrollPane);
		
		tabelaProjetos = new JTable();
		tabelaProjetos.setFont(new Font("Tahoma", Font.PLAIN, 11));
		scrollPane.setViewportView(tabelaProjetos);
		
		
	}
}
