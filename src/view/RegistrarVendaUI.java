package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import util.MaskFields;
import dao.ClienteDAO;
import dao.ProdutoDAO;
import dao.VendaDAO;
import exceptions.VendaException;
import model.Cliente;
import model.ItemVenda;
import model.ItemVendaTableModel;
import model.Produto;
import model.Venda;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class RegistrarVendaUI extends JInternalFrame {
	private JTextField jtfCodigo;
	private JFormattedTextField jtfDataVenda;
	private JFormattedTextField jtfQtde;
	private JTable jtItensVenda;
	private ArrayList<ItemVenda> listaItemVendaTemp = new ArrayList<ItemVenda>();
	private Double soma = 0.0; 
	private JLabel jlValorTotalVenda;
	private DecimalFormat formatValor = new DecimalFormat("0.00");
	private SimpleDateFormat formatData = new SimpleDateFormat("dd/MM/yyyy");
	private JComboBox jcbListaClientes;
	private JComboBox jcbListaProdutos;
	private MaskFields maskFields = new MaskFields();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistrarVendaUI frame = new RegistrarVendaUI();
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
	public RegistrarVendaUI() {
		setClosable(true);
		setTitle("Registro de Vendas");
		setBounds(100, 100, 615, 408);
		
		JPanel jpRegistroVendas = new JPanel();
		jpRegistroVendas.setBorder(new TitledBorder(null, "Registro de Vendas", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JButton jbRegistrarVenda = new JButton("Registrar Venda");
		jbRegistrarVenda.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				try {
				Venda venda = new Venda();
				venda.setCliente((Cliente)jcbListaClientes.getSelectedItem());
				venda.setDataVenda(formatData.parse(jtfDataVenda.getText()));
				venda.setListaItemVenda(listaItemVendaTemp);
				venda.setValorTotal(Double.parseDouble(jlValorTotalVenda.getText()));
				new VendaDAO().inserir(venda);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}catch (VendaException e2){
					e2.printStackTrace();
				}
			}
		});
		
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
						.addComponent(jpRegistroVendas, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(jbRegistrarVenda)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(jbCancelar)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(jpRegistroVendas, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(jbCancelar)
						.addComponent(jbRegistrarVenda))
					.addGap(19))
		);
		
		JLabel jlCodigo = new JLabel("Código:");
		
		jtfCodigo = new JTextField();
		jtfCodigo.setColumns(10);
		
		JLabel jlDataVenda = new JLabel("Data da Venda:");
		
		jtfDataVenda = new JFormattedTextField();
		try{
			maskFields.maskData(jtfDataVenda);
		}catch (ParseException e1){
			JOptionPane.showMessageDialog(null, "Impossivel aplicar mascara");
			e1.printStackTrace();
		}
		
		jtfDataVenda.setColumns(10);
		
		JLabel lblCliente = new JLabel("Cliente:");
		
		DefaultComboBoxModel<Cliente> modelCliente = 
				new DefaultComboBoxModel<Cliente>();
		
		for ( Cliente c : new ClienteDAO().getListaClientes()){
			modelCliente.addElement(c);
		}
		
		jcbListaClientes = new JComboBox();
		jcbListaClientes.setModel(modelCliente);
		
		JPanel jpItensVenda = new JPanel();
		jpItensVenda.setBorder(new TitledBorder(null, "Itens da Venda", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GroupLayout gl_jpRegistroVendas = new GroupLayout(jpRegistroVendas);
		gl_jpRegistroVendas.setHorizontalGroup(
			gl_jpRegistroVendas.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_jpRegistroVendas.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_jpRegistroVendas.createParallelGroup(Alignment.LEADING)
						.addComponent(jpItensVenda, GroupLayout.DEFAULT_SIZE, 547, Short.MAX_VALUE)
						.addGroup(gl_jpRegistroVendas.createParallelGroup(Alignment.LEADING, false)
							.addGroup(gl_jpRegistroVendas.createSequentialGroup()
								.addComponent(jlCodigo)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(jtfCodigo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(jlDataVenda)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(jtfDataVenda, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE))
							.addGroup(gl_jpRegistroVendas.createSequentialGroup()
								.addComponent(lblCliente)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(jcbListaClientes, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
					.addContainerGap())
		);
		gl_jpRegistroVendas.setVerticalGroup(
			gl_jpRegistroVendas.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_jpRegistroVendas.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_jpRegistroVendas.createParallelGroup(Alignment.BASELINE)
						.addComponent(jlCodigo)
						.addComponent(jtfCodigo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(jlDataVenda)
						.addComponent(jtfDataVenda, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_jpRegistroVendas.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCliente)
						.addComponent(jcbListaClientes, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(jpItensVenda, GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		JLabel jlQtde = new JLabel("Qtde:");
		
		jtfQtde = new JFormattedTextField();
		try{
			maskFields.maskInteiro(jtfQtde);
		}catch (ParseException e1){
			JOptionPane.showMessageDialog(null, "Implossivel aplicar mascara");
			e1.printStackTrace();
		}
		
		jtfQtde.setColumns(10);
		
		JLabel lblProduto = new JLabel("Produto:");
		
		DefaultComboBoxModel<Produto> modelProduto = 
				new DefaultComboBoxModel<Produto>();
		
		for ( Produto p : ProdutoDAO.obterInstancia().getListaProdutos()){
			modelProduto.addElement(p);
		}
		
		jcbListaProdutos = new JComboBox();
		jcbListaProdutos.setModel(modelProduto);
		
		JButton jbAdicionar = new JButton("Adicionar");
		jbAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ItemVenda iv = new ItemVenda();
				iv.setQtde(Integer.parseInt(jtfQtde.getText()));
				iv.setProduto((Produto)jcbListaProdutos.getSelectedItem());
				iv.setValorTotalItem(iv.getQtde() * iv.getProduto().getPreco());
				listaItemVendaTemp.add(iv);
				jtItensVenda.setModel(new ItemVendaTableModel(listaItemVendaTemp));
				soma += iv.getValorTotalItem();
				jlValorTotalVenda.setText(soma.toString());
			}
		});
		
		JScrollPane jspItensVenda = new JScrollPane();
		
		JButton jbRemoverItem = new JButton("Remover Item");
		jbRemoverItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ItemVenda iv = listaItemVendaTemp.get(jtItensVenda.getSelectedRow());
				soma -= iv.getValorTotalItem();
				jlValorTotalVenda.setText(formatValor.format(soma));
				listaItemVendaTemp.remove(jtItensVenda.getSelectedRow());
				jtItensVenda.setModel(new ItemVendaTableModel(listaItemVendaTemp));
			}
		});

		jlValorTotalVenda = new JLabel("0,00");
		GroupLayout gl_jpItensVenda = new GroupLayout(jpItensVenda);
		gl_jpItensVenda.setHorizontalGroup(
			gl_jpItensVenda.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_jpItensVenda.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_jpItensVenda.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_jpItensVenda.createSequentialGroup()
							.addGroup(gl_jpItensVenda.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_jpItensVenda.createSequentialGroup()
									.addComponent(jlQtde)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(jtfQtde, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(lblProduto)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(jcbListaProdutos, GroupLayout.PREFERRED_SIZE, 278, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(jbAdicionar))
								.addComponent(jspItensVenda, GroupLayout.PREFERRED_SIZE, 481, GroupLayout.PREFERRED_SIZE))
							.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGroup(gl_jpItensVenda.createSequentialGroup()
							.addComponent(jbRemoverItem)
							.addPreferredGap(ComponentPlacement.RELATED, 281, Short.MAX_VALUE)
							.addComponent(jlValorTotalVenda)
							.addGap(59))))
		);
		gl_jpItensVenda.setVerticalGroup(
			gl_jpItensVenda.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_jpItensVenda.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_jpItensVenda.createParallelGroup(Alignment.BASELINE)
						.addComponent(jlQtde)
						.addComponent(jtfQtde, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblProduto)
						.addComponent(jcbListaProdutos, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(jbAdicionar))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(jspItensVenda, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(gl_jpItensVenda.createParallelGroup(Alignment.BASELINE)
						.addComponent(jbRemoverItem)
						.addComponent(jlValorTotalVenda))
					.addContainerGap())
		);
		
		jtItensVenda = new JTable();
		jtItensVenda.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"Descri\u00E7\u00E3o Produto", "Valor Unit\u00E1rio(R$)", "Qtde", "Valor Total Item(R$)"
			}
		));
		jspItensVenda.setViewportView(jtItensVenda);
		jpItensVenda.setLayout(gl_jpItensVenda);
		jpRegistroVendas.setLayout(gl_jpRegistroVendas);
		getContentPane().setLayout(groupLayout);

	}
}
