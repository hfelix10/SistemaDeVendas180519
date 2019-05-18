package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;

import dao.ProdutoDAO;
import model.Produto;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CadastroProdutoUI extends JInternalFrame {
	private final JPanel jpCadastroProdutos = new JPanel();
	private final JLabel jlDescricao = new JLabel("Descrição:");
	private JTextField jtfDescricaoProduto;
	private JTextField jtfPrecoProduto;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroProdutoUI frame = new CadastroProdutoUI();
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
	public CadastroProdutoUI() {
		setClosable(true);
		setTitle("Cadastro de Produtos");
		setBounds(100, 100, 450, 205);
		
		JButton jbSalvar = new JButton("Salvar");
		jbSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Produto p = new Produto();
				p.setDescricao(jtfDescricaoProduto.getText());
				p.setPreco(Double.parseDouble(jtfPrecoProduto.getText()));
				ProdutoDAO.obterInstancia().getListaProdutos().add(p);
				JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso!");
			}
		});
		
		JButton jbCancelar = new JButton("Cancelar");
		jbCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(jpCadastroProdutos, GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(jbSalvar)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(jbCancelar)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(jpCadastroProdutos, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(jbSalvar)
						.addComponent(jbCancelar))
					.addContainerGap())
		);
		
		jtfDescricaoProduto = new JTextField();
		jtfDescricaoProduto.setColumns(10);
		
		JLabel jlPreco = new JLabel("Preço:");
		
		jtfPrecoProduto = new JTextField();
		jtfPrecoProduto.setColumns(10);
		GroupLayout gl_jpCadastroProdutos = new GroupLayout(jpCadastroProdutos);
		gl_jpCadastroProdutos.setHorizontalGroup(
			gl_jpCadastroProdutos.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_jpCadastroProdutos.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_jpCadastroProdutos.createParallelGroup(Alignment.LEADING)
						.addComponent(jlDescricao, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
						.addComponent(jlPreco))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_jpCadastroProdutos.createParallelGroup(Alignment.LEADING)
						.addComponent(jtfPrecoProduto, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(jtfDescricaoProduto, GroupLayout.DEFAULT_SIZE, 324, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_jpCadastroProdutos.setVerticalGroup(
			gl_jpCadastroProdutos.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_jpCadastroProdutos.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_jpCadastroProdutos.createParallelGroup(Alignment.BASELINE)
						.addComponent(jlDescricao)
						.addComponent(jtfDescricaoProduto, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(29)
					.addGroup(gl_jpCadastroProdutos.createParallelGroup(Alignment.BASELINE)
						.addComponent(jlPreco)
						.addComponent(jtfPrecoProduto, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(124, Short.MAX_VALUE))
		);
		jpCadastroProdutos.setBorder(new TitledBorder(null, "Produto", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		jpCadastroProdutos.setLayout(gl_jpCadastroProdutos);
		getContentPane().setLayout(groupLayout);

	}
}
