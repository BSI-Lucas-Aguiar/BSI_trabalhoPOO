package telas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class TelaPrincipal extends JFrame {

	private JPanel contentPane;
	
	//Iniciar a Tela
	//********************************************************************************************************
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
		setTitle("Gerenciamento de Estaleiro Naval");
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
		
		JMenuItem menuProjetosManipularProjeto = new JMenuItem("Controle de Projetos");
		menuProjetosManipularProjeto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaProjeto telaProjeto = new TelaProjeto();
				telaProjeto.setVisible(true);
			}
		});
		menuProjetos.add(menuProjetosManipularProjeto);
		
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
		
		//Janela de Estoque
		//********************************************************************************************************
		JMenuItem menuEstoqueManipularEstoque = new JMenuItem("Manipular Estoque");
		menuEstoqueManipularEstoque.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaEstoque telaEstoque = new TelaEstoque();
				telaEstoque.setVisible(true);
			}
		});
		menuEstoque.add(menuEstoqueManipularEstoque);
		
		JMenu menuMateriais = new JMenu("Materiais");
		menuBar.add(menuMateriais);
		
		//Janela de Compra
		//********************************************************************************************************
		JMenuItem menuManipularMateriais = new JMenuItem("Cadastro de Materiais");
		menuManipularMateriais.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCadastroMateriais telaCompras = new TelaCadastroMateriais();
				telaCompras.setVisible(true);
			}
		});
		menuMateriais.add(menuManipularMateriais);
		
		JMenu menuCaixa = new JMenu("Caixa");
		menuBar.add(menuCaixa);
		
		//Janela do caixa
		//********************************************************************************************************
		JMenuItem menuCaixaTotalCaixa = new JMenuItem("Administra\u00E7\u00E3o de Caixa");
		menuCaixaTotalCaixa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCaixa telaCaixa = new TelaCaixa();
				telaCaixa.setVisible(true);
			}
		});
		menuCaixa.add(menuCaixaTotalCaixa);
		
		JMenu menuRelatorios = new JMenu("Relat\u00F3rios");
		menuBar.add(menuRelatorios);
		
		JMenuItem menuRelatorioProducao = new JMenuItem("Relat\u00F3rio de Produ\u00E7\u00E3o");
		menuRelatorioProducao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaRelatorio telaRelatorio = new TelaRelatorio();
				telaRelatorio.setVisible(true);
			}
		});
		menuRelatorios.add(menuRelatorioProducao);
		
		//Janela de Conteúdo
		//********************************************************************************************************
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel painel = new JPanel();
		contentPane.add(painel, BorderLayout.CENTER);
		painel.setLayout(null);
		
		JLabel labelGerenciamento = new JLabel("GERENCIAMENTO DE");
		labelGerenciamento.setHorizontalAlignment(SwingConstants.CENTER);
		labelGerenciamento.setBackground(new Color(0, 0, 0));
		labelGerenciamento.setForeground(Color.BLACK);
		labelGerenciamento.setFont(new Font("Impact", Font.BOLD, 45));
		labelGerenciamento.setBounds(0, 351, 784, 54);
		painel.add(labelGerenciamento);
		
		JLabel lblEstaleiroNaval = new JLabel("ESTALEIRO NAVAL");
		lblEstaleiroNaval.setHorizontalAlignment(SwingConstants.CENTER);
		lblEstaleiroNaval.setForeground(Color.BLACK);
		lblEstaleiroNaval.setFont(new Font("Impact", Font.BOLD, 45));
		lblEstaleiroNaval.setBackground(Color.BLACK);
		lblEstaleiroNaval.setBounds(0, 397, 784, 54);
		painel.add(lblEstaleiroNaval);
		
		JLabel labelBarquinho = new JLabel("");
		labelBarquinho.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/imagens/icone_timao.png")));
		labelBarquinho.setBounds(498, -255, 621, 568);
		painel.add(labelBarquinho);
		
		//Label com meu instagram
		//********************************************************************************************************
		JLabel labelCriador = new JLabel("CRIADO POR: @LUCASSENDRAK");
		labelCriador.setHorizontalAlignment(SwingConstants.LEFT);
		labelCriador.setForeground(Color.WHITE);
		labelCriador.setFont(new Font("Malgun Gothic", Font.BOLD, 30));
		labelCriador.setBounds(10, 491, 784, 37);
		painel.add(labelCriador);
		
		//Imagem de Fundo
		//********************************************************************************************************
		JLabel labelFundoMain = new JLabel("imagemMain");
		labelFundoMain.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/imagens/estaleiro_naval_principal.png")));
		labelFundoMain.setBounds(0, 0, 784, 539);
		painel.add(labelFundoMain);
		
		//Confirmação de fechar programa
		//********************************************************************************************************
		addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
            	Object[] objeto = {"Sair","Cancelar"};
                int sair = JOptionPane.showOptionDialog(contentPane, 
                        "Tem certeza que deseja encerrar o Sistema?", "Atenção!!!",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        objeto, objeto[0]);
                
                if(sair == JOptionPane.YES_OPTION){
                	System.out.println("Aplicação Finalizada, obrigado por utilizar!");
                    System.exit(0);
                }else {
                    setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                }
            }
        });
	}
}
