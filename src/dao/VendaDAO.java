package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Statement;

import exceptions.VendaException;
import util.ConnectionUtil;
import model.ItemVenda;
import model.Venda;

public class VendaDAO {

	private ArrayList<Venda> listaVendas = new ArrayList<Venda>();
	
	private Connection con = ConnectionUtil.getConnection();
	
	private static VendaDAO vendaDao;
	
	public static VendaDAO obterInstancia(){
		if ( vendaDao == null){
			vendaDao = new VendaDAO();
		}
		return vendaDao;
	}

	public ArrayList<Venda> getListaVendas() {
		return listaVendas;
	}

	public void setListaVendas(ArrayList<Venda> listaVendas) {
		this.listaVendas = listaVendas;
	}
	
	public void inserir (Venda venda) throws VendaException{
		String query = "insert into venda (data_venda,id_cliente,valor_total) values (?,?,?)";
		try{
		PreparedStatement pstmt = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
		pstmt.setDate(1, new java.sql.Date(venda.getDataVenda().getTime()));
		pstmt.setInt(2, venda.getCliente().getId());
		pstmt.setDouble(3, venda.getValorTotal());
		pstmt.executeUpdate();
		int idVenda = 0;
		ResultSet rs = pstmt.getGeneratedKeys();
		
		if (rs.next()){
			idVenda = rs.getInt(1);
		}
		
		String queryItens = "insert into item_venda(id_venda,id_produto,qtde,valor_item) values (?,?,?,?)";
		PreparedStatement pstmtItens = con.prepareStatement(queryItens);
		for (ItemVenda iv : venda.getListaItemVenda()){
			pstmtItens.setInt(1, idVenda);
			pstmtItens.setInt(2, iv.getProduto().getId());
			pstmtItens.setInt(3, iv.getQtde());
			pstmtItens.setDouble(4, iv.getValorTotalItem());
			pstmtItens.executeUpdate();
			
		}
		con.commit();
		}catch(SQLException e){
			throw new VendaException("Erro ao salvar");
		}
	}
}

