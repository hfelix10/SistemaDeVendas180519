package model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import exceptions.ClienteException;

public class ClienteTableModel extends AbstractTableModel {
	
	private static final long serialVersionUID = 1L;
	private static final int COL_ID = 0;
	private static final int COL_NOME = 1;
	private static final int COL_CPF = 2;

	private List<Cliente> valores;       

	//Esse � um construtor, que recebe a nossa lista de clientes
	public ClienteTableModel(List<Cliente> valores) {
		this.valores = new ArrayList<Cliente>(valores);
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
		if (column == COL_NOME) return "Nome do Cliente";
		if (column == COL_CPF) return "CPF";
		return ""; //Nunca deve ocorrer
	}

	public Object getValueAt(int row, int column) {
		//Precisamos retornar o valor da coluna column e da linha row.
		Cliente cliente = valores.get(row);
		if (column == COL_ID)
			return cliente.getId();
		else 
			if (column == COL_NOME) 
					return cliente.getNome();
			else 
				if (column == COL_CPF) 
					return cliente.getCpf();
		return ""; //Nunca deve ocorrer
	}

	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		Cliente cliente = valores.get(rowIndex);
		//Vamos alterar o valor da coluna columnIndex na linha rowIndex com o valor aValue passado no par�metro.
		//Note que vc poderia alterar 2 campos ao inv�s de um s�.
		if (columnIndex == COL_ID)
			cliente.setId(Integer.parseInt(aValue.toString()));
		else 
			if (columnIndex == COL_NOME) 
				cliente.setNome(aValue.toString());
			else 
				if (columnIndex == COL_CPF) 
					cliente.setCpf(aValue.toString());
	}

	public Class<?> getColumnClass(int columnIndex) {
		//Qual a classe das nossas colunas? Como estamos exibindo texto, � string.
		return String.class;
	}

	public boolean isCellEditable(int rowIndex, int columnIndex) {
		//Indicamos se a c�lula da rowIndex e da columnIndex � edit�vel. Nossa tabela toda �.
		return true;
	}
	//J� que esse tableModel � de clientes, vamos fazer um get que retorne um objeto cliente inteiro.
	//Isso elimina a necessidade de chamar o getValueAt() nas telas. 
	public Cliente get(int row) throws ClienteException{
		if (row  < 0){
			throw new ClienteException("Selecione um cliente");
		}
		return valores.get(row);
	}
}

