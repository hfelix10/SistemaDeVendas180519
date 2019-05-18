package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import util.ConnectionUtil;
import model.Cliente;
import model.Produto;

public class ProdutoDAO {

	private ArrayList<Produto> listaProdutos = new ArrayList<Produto>();
	private static ProdutoDAO produtoDao;
	
	  private Connection con = ConnectionUtil.getConnection();
	  
	  
	  public List<Produto>getListaProdutos(){
	    	try{
	    		Statement stmt = con.createStatement();
	    		String query = "select * from produto";
	    		ResultSet rs = stmt.executeQuery(query);
	    		while (rs.next()){
	    			Produto p = new Produto ();
	    			p.setId(rs.getInt("id_produto"));
	    			p.setDescricao(rs.getString("descricao"));
	    			p.setPreco(rs.getDouble("valor_unitario"));
	    			
	    			listaProdutos.add (p);
	    		}
	    		return listaProdutos;
	    	}catch (SQLException e){
	    		e.printStackTrace();
	    	}
	    	return null;
	    }
	
	public static ProdutoDAO obterInstancia(){
		if ( produtoDao == null){
			produtoDao = new ProdutoDAO();
		}
		return produtoDao;
	}

	public void setListaProdutos(ArrayList<Produto> listaProdutos) {
		this.listaProdutos = listaProdutos;
	}
	
}
