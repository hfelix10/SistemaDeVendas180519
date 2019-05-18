package model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class ProdutoTableModel extends AbstractTableModel {
	
	private static final long serialVersionUID = 1L;
	private static final int COL_ID = 0;
	private static final int COL_DESCRICAO = 1;
	private static final int COL_PRECO = 2;

	private List<Produto> valores;       

	//Esse � um construtor, que recebe a nossa lista de produtos
	public ProdutoTableModel(List<Produto> valores) {
		this.valores = new ArrayList<Produto>(valores);
	}

	public int getRowCount() {
		//Quantas linhas tem sua tabela? Uma para cada item da lista.
		return valores.size();
	}

	public int getColumnCount() {
		//Quantas colunas tem a tabela? Nesse exemplo, s� 2.
		return 3;
	}

	public String getColumnName(int column) {
		//Qual � o nome das nossas colunas?
		if (column == COL_ID) return "ID";
		if (column == COL_DESCRICAO) return "Descrição do Produto";
		if (column == COL_PRECO) return "Preço(R$)";
		return ""; //Nunca deve ocorrer
	}

	public Object getValueAt(int row, int column) {
		//Precisamos retornar o valor da coluna column e da linha row.
		Produto produto = valores.get(row);
		if (column == COL_ID)
			return produto.getId();
		else 
			if (column == COL_DESCRICAO) 
					return produto.getDescricao();
			else 
				if (column == COL_PRECO) 
					return produto.getPreco();
		return ""; //Nunca deve ocorrer
	}

	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		Produto produto = valores.get(rowIndex);
		//Vamos alterar o valor da coluna columnIndex na linha rowIndex com o valor aValue passado no par�metro.
		//Note que vc poderia alterar 2 campos ao inv�s de um s�.
		if (columnIndex == COL_ID)
			produto.setId(Integer.parseInt(aValue.toString()));
		else 
			if (columnIndex == COL_DESCRICAO) 
				produto.setDescricao(aValue.toString());
			else 
				if (columnIndex == COL_PRECO) 
					produto.setPreco(Double.parseDouble(aValue.toString()));
	}

	public Class<?> getColumnClass(int columnIndex) {
		//Qual a classe das nossas colunas? Como estamos exibindo texto, � string.
		return String.class;
	}

	public boolean isCellEditable(int rowIndex, int columnIndex) {
		//Indicamos se a c�lula da rowIndex e da columnIndex � edit�vel. Nossa tabela toda �.
		return true;
	}
	//J� que esse tableModel � de produtos, vamos fazer um get que retorne um objeto produto inteiro.
	//Isso elimina a necessidade de chamar o getValueAt() nas telas. 
	public Produto get(int row) {
		return valores.get(row);
	}
}

