package telas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class TelaPrincipal extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
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

	/**
	 * Create the frame.
	 */
	public TelaPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
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
		
		JMenuItem menuEstoqueListarEstoque = new JMenuItem("Listar Estoque");
		menuEstoque.add(menuEstoqueListarEstoque);
		
		JMenuItem menuEstoqueRetirarMaterial = new JMenuItem("Retirar Material");
		menuEstoque.add(menuEstoqueRetirarMaterial);
		
		JMenu menuCompra = new JMenu("Compra");
		menuBar.add(menuCompra);
		
		JMenuItem menuCompraCadastrarMaterial = new JMenuItem("Cadastrar Material");
		menuCompra.add(menuCompraCadastrarMaterial);
		
		JMenuItem menuCompraComprarMaterial = new JMenuItem("Comprar Material");
		menuCompra.add(menuCompraComprarMaterial);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
	}

}
