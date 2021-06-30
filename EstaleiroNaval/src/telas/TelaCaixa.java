package telas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class TelaCaixa extends JFrame {

	private JPanel contentPane;
	private JTextField textoSaldo;
	private JTextField textoNomeProjeto;

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
			}
		});
		botaoSaldoEmCaixa.setBounds(89, 46, 143, 23);
		panel.add(botaoSaldoEmCaixa);
		
		textoSaldo = new JTextField();
		textoSaldo.setEditable(false);
		textoSaldo.setBounds(89, 87, 143, 20);
		panel.add(textoSaldo);
		textoSaldo.setColumns(10);
		
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setBounds(325, 45, 199, 305);
		panel.add(textArea);
		
		JButton botaoListarProjetos = new JButton("Listar Projetos");
		botaoListarProjetos.setBounds(348, 11, 156, 23);
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
	}
}
