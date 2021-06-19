package telas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import java.awt.Color;

public class TelaEstoque extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
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

	/**
	 * Create the frame.
	 */
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
		
		JLabel labelEstoque = new JLabel("ESTOQUE DE MATERIAIS");
		labelEstoque.setForeground(Color.YELLOW);
		labelEstoque.setFont(new Font("Segoe UI Black", Font.BOLD, 34));
		labelEstoque.setBounds(72, 33, 437, 36);
		panel.add(labelEstoque);
		
		JLabel labelFundoEstoque = new JLabel("Imagem Fundo");
		labelFundoEstoque.setIcon(new ImageIcon(TelaEstoque.class.getResource("/imagens/fundo_estoque.jpg")));
		labelFundoEstoque.setBounds(0, 0, 584, 361);
		panel.add(labelFundoEstoque);
	}

}
