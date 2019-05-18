package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

import java.awt.FlowLayout;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dao.ClienteDAO;
import dao.ProdutoDAO;
import model.Cliente;
import model.ClienteTableModel;
import model.Produto;
import model.ProdutoTableModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class ConsultaProdutosUI extends JInternalFrame {
	private JTextField jtfPesquisa;
	private JTable jtListaProdutos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultaProdutosUI frame = new ConsultaProdutosUI();
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
	public ConsultaProdutosUI() {
		setClosable(true);
		setTitle("Consulta de Produtos");
		setBounds(100, 100, 450, 357);
		
		JPanel jpConsultaProdutos = new JPanel();
		jpConsultaProdutos.setBorder(new TitledBorder(null, "Produtos", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JButton jbEditar = new JButton("Editar");
		
		JButton jbExcluir = new JButton("Excluir");
		
		JButton jbInserir = new JButton("Inserir");
		
		JButton jbAtualizar = new JButton("Atualizar");
		
		JButton jbCancelar = new JButton("Cancelar");
		jbCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(jpConsultaProdutos, GroupLayout.PREFERRED_SIZE, 414, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(jbEditar)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(jbExcluir)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(jbInserir)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(jbAtualizar)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(jbCancelar)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(jpConsultaProdutos, GroupLayout.PREFERRED_SIZE, 281, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(jbEditar)
						.addComponent(jbExcluir)
						.addComponent(jbInserir)
						.addComponent(jbAtualizar)
						.addComponent(jbCancelar))
					.addContainerGap(37, Short.MAX_VALUE))
		);
		
		JLabel jlPesquisa = new JLabel("Pesquisa:");
		
		jtfPesquisa = new JTextField();
		jtfPesquisa.setColumns(10);
		
		JButton jbBuscar = new JButton("Buscar");
		jbBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<Produto> listaProdutoPesquisa = new ArrayList<Produto>();
				for ( Produto p : ProdutoDAO.obterInstancia().getListaProdutos() ){
					if (p.getDescricao().contains(jtfPesquisa.getText())){
						listaProdutoPesquisa.add(p);
					}
				}
				jtListaProdutos.setModel(new ProdutoTableModel(listaProdutoPesquisa));
			}
		});
		
		JScrollPane jspListaProdutos = new JScrollPane();
		GroupLayout gl_jpConsultaProdutos = new GroupLayout(jpConsultaProdutos);
		gl_jpConsultaProdutos.setHorizontalGroup(
			gl_jpConsultaProdutos.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_jpConsultaProdutos.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_jpConsultaProdutos.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_jpConsultaProdutos.createSequentialGroup()
							.addComponent(jlPesquisa)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(jtfPesquisa, GroupLayout.PREFERRED_SIZE, 259, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(jbBuscar))
						.addComponent(jspListaProdutos, GroupLayout.PREFERRED_SIZE, 379, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(12, Short.MAX_VALUE))
		);
		gl_jpConsultaProdutos.setVerticalGroup(
			gl_jpConsultaProdutos.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_jpConsultaProdutos.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_jpConsultaProdutos.createParallelGroup(Alignment.BASELINE)
						.addComponent(jlPesquisa)
						.addComponent(jtfPesquisa, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(jbBuscar))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(jspListaProdutos, GroupLayout.PREFERRED_SIZE, 208, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
		jtListaProdutos = new JTable();
		jtListaProdutos.setModel(
				new ProdutoTableModel(
						ProdutoDAO.obterInstancia().getListaProdutos()));
		jspListaProdutos.setViewportView(jtListaProdutos);
		jpConsultaProdutos.setLayout(gl_jpConsultaProdutos);
		getContentPane().setLayout(groupLayout);

	}

}
