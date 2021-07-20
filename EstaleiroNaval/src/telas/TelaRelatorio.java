package telas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import estaleiroNaval.Projeto;

import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class TelaRelatorio extends JFrame {

	private JPanel contentPane;
	private JTable tabelaRelatorios;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaRelatorio frame = new TelaRelatorio();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public TelaRelatorio() {
		setTitle("Relat\u00F3rio de Produ\u00E7\u00E3o");
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaRelatorio.class.getResource("/imagens/icone_estaleiro.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		setResizable(false);
		setLocationRelativeTo(null); //Centralizar a Janela
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel labelRelatorio = new JLabel("RELAT\u00D3RIO DE PRODU\u00C7\u00C3O");
		labelRelatorio.setFont(new Font("Tahoma", Font.BOLD, 18));
		labelRelatorio.setHorizontalAlignment(SwingConstants.CENTER);
		labelRelatorio.setBounds(0, 0, 584, 28);
		contentPane.add(labelRelatorio);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 25, 584, 336);
		contentPane.add(scrollPane);
		
		tabelaRelatorios = new JTable();
		scrollPane.setViewportView(tabelaRelatorios);
		
		DefaultTableModel tabela = new DefaultTableModel();
		
		tabela.addColumn("Código do Projeto");
		tabela.addColumn("Material Necessário");
		tabela.addColumn("Material Utilizado");
		tabela.addColumn("Vendido?");
		tabela.addColumn("Valor da Embarcação");
		tabela.addColumn("Tipo");
		tabela.addColumn("Concluído?");
		
		Projeto projeto = new Projeto();
		ArrayList<Projeto> listaProjeto = projeto.listarProjetos();
		
		if(listaProjeto != null) {
			String concluido;
            for(Projeto p: listaProjeto) {
            	if( p.getMaterialUtilizado() >= p.getQuantidadeMaterial()) {
            		concluido = "Sim";
        		}else {
        			concluido = "Não";
        		}
            	tabela.addRow(new String[]{
            		p.getCodigoProjeto(), 
            		Integer.toString(p.getQuantidadeMaterial()), 
            		Integer.toString(p.getMaterialUtilizado()), 
            		Boolean.toString(p.isVendido()), 
            		Double.toString(p.getValorEmbarcacao()), 
            		p.getTipo(),
            		concluido
            		
            		
            	});
            }
            tabelaRelatorios.setModel(tabela);
            //tabelaProjetos.setEnabled(false); //Bloqueia a seleção na tabela
        }
		
		
//		chamarRelatorio();
		
	}
//	public void chamarRelatorio() {
//		Projeto projeto = new Projeto();
//		ArrayList<Projeto> listaProjeto = projeto.listarProjetos();
//		
//		if(listaProjeto != null) {
//            for(Projeto p: listaProjeto) {
//            	tabela.addRow(new String[]{
//            		p.getCodigoProjeto(), 
//            		Integer.toString(p.getQuantidadeMaterial()), 
//            		Integer.toString(p.getMaterialUtilizado()), 
//            		Boolean.toString(p.isVendido()), 
//            		Double.toString(p.getValorEmbarcacao()), 
//            		p.getTipo()
//            	});
//            }
//            tabelaRelatorios.setModel(tabela);
//            //tabelaProjetos.setEnabled(false); //Bloqueia a seleção na tabela
//        }
//	}
}
