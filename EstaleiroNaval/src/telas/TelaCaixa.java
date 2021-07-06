package telas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import persistencia.FabricaConexao;

import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import java.awt.Font;

import estaleiroNaval.Caixa;
import estaleiroNaval.Funcionario;

@SuppressWarnings("serial")
public class TelaCaixa extends JFrame {

	private JPanel contentPane;
	private JTextField textoNomeProjeto;
	private JTextField textoSaldoCaixa;

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
		setBounds(100, 100, 550, 400);
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
		botaoSaldoEmCaixa.setBounds(89, 89, 143, 23);
		panel.add(botaoSaldoEmCaixa);
		
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setBounds(325, 88, 199, 262);
		panel.add(textArea);
		
		JButton botaoListarProjetos = new JButton("Listar Projetos");
		botaoListarProjetos.setBounds(347, 46, 156, 23);
		panel.add(botaoListarProjetos);
		
		JLabel labelNomeProjeto = new JLabel("Nome do Projeto");
		labelNomeProjeto.setHorizontalAlignment(SwingConstants.CENTER);
		labelNomeProjeto.setBounds(110, 225, 104, 14);
		panel.add(labelNomeProjeto);
		
		textoNomeProjeto = new JTextField();
		labelNomeProjeto.setLabelFor(textoNomeProjeto);
		textoNomeProjeto.setBounds(89, 244, 143, 20);
		panel.add(textoNomeProjeto);
		textoNomeProjeto.setColumns(10);
		
		JButton botaoVenderProjeto = new JButton("Vender Projeto");
		botaoVenderProjeto.setBounds(89, 286, 143, 23);
		panel.add(botaoVenderProjeto);
		
		JLabel labelAdministracaoCaixa = new JLabel("ADMINISTRA\u00C7\u00C3O DE CAIXA");
		labelAdministracaoCaixa.setFont(new Font("Tahoma", Font.BOLD, 16));
		labelAdministracaoCaixa.setHorizontalAlignment(SwingConstants.CENTER);
		labelAdministracaoCaixa.setBounds(0, 11, 534, 24);
		panel.add(labelAdministracaoCaixa);
		
		textoSaldoCaixa = new JTextField();
		textoSaldoCaixa.setEditable(false);
		textoSaldoCaixa.setBounds(89, 123, 143, 20);
		panel.add(textoSaldoCaixa);
		textoSaldoCaixa.setColumns(10);
		
		
	}
}
