package telas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

@SuppressWarnings("serial")
public class TelaPrincipal extends JFrame {

	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {					
					TelaPrincipal frame = new TelaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public TelaPrincipal() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaPrincipal.class.getResource("/imagens/icone_estaleiro.png")));
		setTitle("Estaleiro Naval");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		setResizable(false);
		setLocationRelativeTo(null); //Centralizar a Janela
		
		//JMenu e Opções do Menu
		//********************************************************************************************************
		JMenuBar menuBar = new JMenuBar();
		menuBar.setFont(new Font("Courier New", Font.PLAIN, 12));
		setJMenuBar(menuBar);
		
		JMenu menuProjetos = new JMenu("Projetos");
		menuBar.add(menuProjetos);
		
		JMenuItem menuProjetosCriarProjeto = new JMenuItem("Criar Projeto");
		menuProjetos.add(menuProjetosCriarProjeto);
		
		JMenuItem menuProjetosListarProjetos = new JMenuItem("Listar Projetos");
		menuProjetos.add(menuProjetosListarProjetos);
		
		JMenuItem menuProjetosVenderProjeto = new JMenuItem("Vender Projeto");
		menuProjetos.add(menuProjetosVenderProjeto);
		
		JMenu menuFuncionarios = new JMenu("Funcion\u00E1rios");
		menuBar.add(menuFuncionarios);
		
		JMenuItem menuFuncionariosManipularFuncionários = new JMenuItem("Manipular Funcion\u00E1rios");
		menuFuncionariosManipularFuncionários.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaFuncionarios telaFuncionarios = new TelaFuncionarios();
				telaFuncionarios.setVisible(true);
			}
		});
		menuFuncionarios.add(menuFuncionariosManipularFuncionários);
		
		JMenu menuEstoque = new JMenu("Estoque");
		menuBar.add(menuEstoque);
		
		//Abrir Menu Manipular Estoque 
		JMenuItem menuEstoqueManipularEstoque = new JMenuItem("Manipular Estoque");
		menuEstoqueManipularEstoque.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaEstoque telaEstoque = new TelaEstoque();
				telaEstoque.setVisible(true);
			}
		});
		menuEstoque.add(menuEstoqueManipularEstoque);
		
		JMenu menuCompra = new JMenu("Compra");
		menuBar.add(menuCompra);
		
		JMenuItem menuCompraCadastrarMaterial = new JMenuItem("Cadastrar Material");
		menuCompra.add(menuCompraCadastrarMaterial);
		
		JMenuItem menuCompraComprarMaterial = new JMenuItem("Comprar Material");
		menuCompra.add(menuCompraComprarMaterial);
		
		JMenu menuCaixa = new JMenu("Caixa");
		menuBar.add(menuCaixa);
		
		//Janela do caixa
		//********************************************************************************************************
		JMenuItem menuCaixaTotalCaixa = new JMenuItem("Total em Caixa");
		menuCaixaTotalCaixa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCaixa telaCaixa = new TelaCaixa();
				telaCaixa.setVisible(true);
			}
		});
		menuCaixa.add(menuCaixaTotalCaixa);
		
		//Janela de Conteúdo
		//********************************************************************************************************
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel painel = new JPanel();
		contentPane.add(painel, BorderLayout.CENTER);
		painel.setLayout(null);
		
		JLabel labelMain = new JLabel("ESTALEIRO NAVAL");
		labelMain.setForeground(new Color(255, 0, 255));
		labelMain.setFont(new Font("Verdana", Font.BOLD, 50));
		labelMain.setBounds(124, 29, 532, 49);
		painel.add(labelMain);
		
		JLabel labelCriador = new JLabel("CRIADO POR: @LUCASSENDRAK");
		labelCriador.setForeground(Color.RED);
		labelCriador.setFont(new Font("Unispace", Font.BOLD, 30));
		labelCriador.setBounds(0, 502, 459, 37);
		painel.add(labelCriador);
		
		//Imagem de Fundo
		//********************************************************************************************************
		JLabel labelFundoMain = new JLabel("imagemMain");
		labelFundoMain.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/imagens/imagemMainEstaleiro.jpg")));
		labelFundoMain.setBounds(0, 0, 784, 539);
		painel.add(labelFundoMain);
	}
}
