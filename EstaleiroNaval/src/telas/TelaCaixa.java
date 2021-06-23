package telas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

@SuppressWarnings("serial")
public class TelaCaixa extends JFrame {

	private JPanel contentPane;

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
		setBounds(100, 100, 450, 300);
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
		botaoSaldoEmCaixa.setBounds(127, 109, 143, 23);
		panel.add(botaoSaldoEmCaixa);
		
		JLabel labelFundoCaixa = new JLabel("New label");
		labelFundoCaixa.setIcon(new ImageIcon(TelaCaixa.class.getResource("/imagens/fundo_caixa.jpg")));
		labelFundoCaixa.setBounds(-1303, -869, 2057, 1328);
		panel.add(labelFundoCaixa);
	}
}
