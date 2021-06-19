package telas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import persistencia.CriarBD;

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
					//Chamada da criação do BD, a senha root deve ser alterada na classe criarBD do pacote persistencia
					CriarBD.iniciarBD();
					
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
		
		JMenu menuFuncionarios = new JMenu("Funcion\u00E1rios");
		menuBar.add(menuFuncionarios);
		
		JMenuItem menuFuncionariosCadastrarFuncionarios = new JMenuItem("Cadastrar Funcion\u00E1rio");
		menuFuncionarios.add(menuFuncionariosCadastrarFuncionarios);
		
		JMenuItem menuFuncionariosDemitirFuncionario = new JMenuItem("Demitir Funcion\u00E1rio");
		menuFuncionarios.add(menuFuncionariosDemitirFuncionario);
		
		JMenuItem menuFuncionariosListarFuncionarios = new JMenuItem("Listar Funcion\u00E1rios");
		menuFuncionarios.add(menuFuncionariosListarFuncionarios);
		
		JMenuItem menuFuncionariosAlterarProjeto = new JMenuItem("Alterar Projeto");
		menuFuncionarios.add(menuFuncionariosAlterarProjeto);
		
		JMenu menuEstoque = new JMenu("Estoque");
		menuBar.add(menuEstoque);
		
		//Abrir Listar Estoque Menu
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
		
		JMenuItem menuCaixaVenderProjeto = new JMenuItem("Vender Projeto");
		menuCaixa.add(menuCaixaVenderProjeto);
		
		JMenuItem menuCaixaTotalCaixa = new JMenuItem("Total em Caixa");
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
		
		JLabel labelMain = new JLabel("Estaleiro Naval");
		labelMain.setForeground(Color.BLACK);
		labelMain.setFont(new Font("Verdana", Font.BOLD, 50));
		labelMain.setBounds(183, 65, 421, 49);
		painel.add(labelMain);
		
		JLabel labelCriador = new JLabel("Criado por: @lucassendrak");
		labelCriador.setForeground(Color.RED);
		labelCriador.setFont(new Font("Unispace", Font.BOLD, 30));
		labelCriador.setBounds(0, 502, 458, 37);
		painel.add(labelCriador);
		
		//Imagem de Fundo
		//********************************************************************************************************
		JLabel labelFundoMain = new JLabel("imagemMain");
		labelFundoMain.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/imagens/imagemMainEstaleiro.jpg")));
		labelFundoMain.setBounds(0, 0, 784, 539);
		painel.add(labelFundoMain);
	}
}
