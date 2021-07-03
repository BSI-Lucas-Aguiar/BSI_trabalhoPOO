package telas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.DefaultComboBoxModel;

public class TelaProjeto extends JFrame {

	private JPanel contentPane;
	private JTextField textoCodigoProjeto;
	private JTextField textoQuantidadeMaterial;
	private JTextField textoValorEmbarcacao;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaProjeto frame = new TelaProjeto();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaProjeto() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaProjeto.class.getResource("/imagens/icone_estaleiro.png")));
		setTitle("Projetos");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		setResizable(false);
		setLocationRelativeTo(null); //Centralizar a Janela
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea textoListarProjetos = new JTextArea();
		textoListarProjetos.setBounds(10, 90, 235, 260);
		contentPane.add(textoListarProjetos);
		
		JButton botaoListarProjetos = new JButton("Listar Projetos");
		botaoListarProjetos.setBounds(20, 56, 214, 23);
		contentPane.add(botaoListarProjetos);
		
		textoCodigoProjeto = new JTextField();
		textoCodigoProjeto.setBounds(255, 92, 150, 20);
		contentPane.add(textoCodigoProjeto);
		textoCodigoProjeto.setColumns(10);
		
		textoQuantidadeMaterial = new JTextField();
		textoQuantidadeMaterial.setBounds(415, 92, 150, 20);
		contentPane.add(textoQuantidadeMaterial);
		textoQuantidadeMaterial.setColumns(10);
		
		textoValorEmbarcacao = new JTextField();
		textoValorEmbarcacao.setBounds(255, 150, 150, 20);
		contentPane.add(textoValorEmbarcacao);
		textoValorEmbarcacao.setColumns(10);
		
		JComboBox comboBoxTipoEmbarcacao = new JComboBox();
		comboBoxTipoEmbarcacao.setModel(new DefaultComboBoxModel(new String[] {"Lancha"}));
		comboBoxTipoEmbarcacao.setBounds(415, 149, 150, 22);
		contentPane.add(comboBoxTipoEmbarcacao);
		
		JLabel labelProjetos = new JLabel("ADMINISTRA\u00C7\u00C3O DE PROJETOS");
		labelProjetos.setFont(new Font("Tahoma", Font.BOLD, 22));
		labelProjetos.setHorizontalAlignment(SwingConstants.CENTER);
		labelProjetos.setBounds(0, 11, 584, 34);
		contentPane.add(labelProjetos);
		
		JLabel labelCodigoProjeto = new JLabel("C\u00F3digo do Projeto");
		labelCodigoProjeto.setLabelFor(textoCodigoProjeto);
		labelCodigoProjeto.setHorizontalAlignment(SwingConstants.CENTER);
		labelCodigoProjeto.setBounds(279, 65, 100, 14);
		contentPane.add(labelCodigoProjeto);
		
		JLabel labelQuantidadeMaterial = new JLabel("Quantidade de Material");
		labelQuantidadeMaterial.setLabelFor(textoQuantidadeMaterial);
		labelQuantidadeMaterial.setHorizontalAlignment(SwingConstants.CENTER);
		labelQuantidadeMaterial.setBounds(415, 65, 150, 14);
		contentPane.add(labelQuantidadeMaterial);
		
		JLabel labelValorEmbarcacao = new JLabel("Valor da Embarca\u00E7\u00E3o");
		labelValorEmbarcacao.setLabelFor(textoValorEmbarcacao);
		labelValorEmbarcacao.setHorizontalAlignment(SwingConstants.CENTER);
		labelValorEmbarcacao.setBounds(255, 125, 150, 14);
		contentPane.add(labelValorEmbarcacao);
		
		JLabel labelTipoEmbarcacao = new JLabel("Tipo de Embarca\u00E7\u00E3o");
		labelTipoEmbarcacao.setLabelFor(comboBoxTipoEmbarcacao);
		labelTipoEmbarcacao.setHorizontalAlignment(SwingConstants.CENTER);
		labelTipoEmbarcacao.setBounds(415, 124, 150, 14);
		contentPane.add(labelTipoEmbarcacao);
		
		JButton botaoCadastrarProjeto = new JButton("Cadastrar Projeto");
		botaoCadastrarProjeto.setBounds(255, 200, 150, 23);
		contentPane.add(botaoCadastrarProjeto);
		
		JButton botaoAlterarProjeto = new JButton("Alterar Projeto");
		botaoAlterarProjeto.setBounds(415, 200, 150, 23);
		contentPane.add(botaoAlterarProjeto);
		
		JButton botaoDeletarProjeto = new JButton("Deletar Projeto");
		botaoDeletarProjeto.setBounds(255, 254, 150, 23);
		contentPane.add(botaoDeletarProjeto);
	}
}
