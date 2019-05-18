package view;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class PrincipalUI extends JFrame {

	private JPanel contentPane;

		private static PrincipalUI instancia;
		
		public static PrincipalUI obterIntancia (){
			if (instancia ==null){
				instancia = new PrincipalUI();
			}
			return instancia;
		}
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PrincipalUI frame = obterIntancia();
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
	public PrincipalUI() {
		setTitle("Sistema de Vendas 2016-1");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		
		JMenuBar jmbMenuPrincipal = new JMenuBar();
		setJMenuBar(jmbMenuPrincipal);
		
		JMenu mnCadastros = new JMenu("Cadastros");
		jmbMenuPrincipal.add(mnCadastros);
		
		JMenuItem jmiCadastroClientes = new JMenuItem("Clientes");
		jmiCadastroClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastroClienteUI cadClienteUI = new CadastroClienteUI(null);
				cadClienteUI.setFocusable(true);
				cadClienteUI.requestFocus();
				contentPane.add(cadClienteUI, 0);
				cadClienteUI.setVisible(true);
			}
		});
		mnCadastros.add(jmiCadastroClientes);
		
		JMenuItem jmiCadastroProdutos = new JMenuItem("Produtos");
		jmiCadastroProdutos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastroProdutoUI cadProdutoUI = new CadastroProdutoUI();
				cadProdutoUI.setFocusable(true);
				cadProdutoUI.requestFocus();
				contentPane.add(cadProdutoUI, 0);
				cadProdutoUI.setVisible(true);
			}
		});
		mnCadastros.add(jmiCadastroProdutos);
		
		JMenu mnConsultas = new JMenu("Consultas");
		jmbMenuPrincipal.add(mnConsultas);
		
		JMenuItem jmiConsultaClientes = new JMenuItem("Clientes");
		jmiConsultaClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConsultaClienteUI consultaClienteUI = new ConsultaClienteUI();
				consultaClienteUI.setFocusable(true);
				consultaClienteUI.requestFocus();
				contentPane.add(consultaClienteUI, 0);
				consultaClienteUI.setVisible(true);
			}
		});
		mnConsultas.add(jmiConsultaClientes);
		
		JMenuItem jmiConsultaProdutos = new JMenuItem("Produtos");
		jmiConsultaProdutos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConsultaProdutosUI consultaProdutoUI = new ConsultaProdutosUI();
				consultaProdutoUI.setFocusable(true);
				consultaProdutoUI.requestFocus();
				contentPane.add(consultaProdutoUI, 0);
				consultaProdutoUI.setVisible(true);
			}
		});
		mnConsultas.add(jmiConsultaProdutos);
		
		JMenu mnVendas = new JMenu("Vendas");
		jmbMenuPrincipal.add(mnVendas);
		
		JMenuItem jmiRegistroDeVenda = new JMenuItem("Registro de Venda");
		jmiRegistroDeVenda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegistrarVendaUI regVendaUI = new RegistrarVendaUI();
				regVendaUI.setFocusable(true);
				regVendaUI.requestFocus();
				contentPane.add(regVendaUI, 0);
				regVendaUI.setVisible(true);
			}
		});
		mnVendas.add(jmiRegistroDeVenda);
		
		JMenuItem jmiRelatorioMensalDeVenda = new JMenuItem("Relat\u00F3rio Mensal de Venda");
		jmiRelatorioMensalDeVenda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RelatorioMensalUI relMensalVendaUI = new RelatorioMensalUI();
				relMensalVendaUI.setFocusable(true);
				relMensalVendaUI.requestFocus();
				contentPane.add(relMensalVendaUI, 0);
				relMensalVendaUI.setVisible(true);
			}
		});
		mnVendas.add(jmiRelatorioMensalDeVenda);
		
		JMenu mnSair = new JMenu("Sair");
		mnSair.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		jmbMenuPrincipal.add(mnSair);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGap(0, 774, Short.MAX_VALUE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGap(0, 530, Short.MAX_VALUE)
		);
		contentPane.setLayout(gl_contentPane);
	}

}
