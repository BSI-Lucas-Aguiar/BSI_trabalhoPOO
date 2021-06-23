package telas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class TelaEstoque extends JFrame {

	private JPanel contentPane;
	private JTextField textoRetirarMaterial;

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
		textoRetirarMaterial.setBounds(57, 295, 185, 25);
		panel.add(textoRetirarMaterial);
		
		//Botão Retirar material
		//********************************************************************************************************
		JButton botaoRetirarMaterial = new JButton("Retirar Material");
		botaoRetirarMaterial.setBounds(358, 282, 160, 55);
		panel.add(botaoRetirarMaterial);
		
		JLabel labelEstoque = new JLabel("ESTOQUE DE MATERIAIS");
		labelEstoque.setForeground(Color.YELLOW);
		labelEstoque.setFont(new Font("Segoe UI Black", Font.BOLD, 34));
		labelEstoque.setBounds(73, 35, 437, 36);
		panel.add(labelEstoque);
		
		JLabel labelFundoEstoque = new JLabel("Imagem Fundo");
		labelFundoEstoque.setIcon(new ImageIcon(TelaEstoque.class.getResource("/imagens/fundo_estoque.jpg")));
		labelFundoEstoque.setBounds(0, 0, 584, 361);
		panel.add(labelFundoEstoque);
	}
}
