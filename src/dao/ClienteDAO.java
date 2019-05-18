package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import util.ConnectionUtil;
import model.Cliente;

public class ClienteDAO {

	private ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();
	
    private Connection con = ConnectionUtil.getConnection();
    
    public List<Cliente>getListaClientes(){
    	try{
    		Statement stmt = con.createStatement();
    		String query = "select * from cliente";
    		ResultSet rs = stmt.executeQuery(query);
    		while (rs.next()){
    			Cliente c = new Cliente ();
    			c.setId(rs.getInt("id"));
    			c.setNome(rs.getString("nome"));
    			c.setCpf(rs.getString("cpf"));
    			
    			listaClientes.add (c);
    		}
    		return listaClientes;
    	}catch (SQLException e){
    		e.printStackTrace();
    	}
    	return null;
    }

    public List<Cliente>getListaClientesByNome(String nome){
    	String query = "select * from cliente";
    	try{
    		PreparedStatement stmt = con.prepareStatement(query);
    		stmt.setString(1, nome);
    		ResultSet rs = stmt.executeQuery(query);
    		while (rs.next()){
    			Cliente c = new Cliente ();
    			c.setId(rs.getInt("id"));
    			c.setNome(rs.getString("nome"));
    			c.setCpf(rs.getString("cpf"));
    			
    			listaClientes.add (c);
    		}
    		return listaClientes;
    	}catch (SQLException e){
    		e.printStackTrace();
    	}
    	return null;
    }
    
    
    
    public void inserir (Cliente cliente){
    	String query = "insert into cliente (nome,cpf) values (?,?)";
    	try {
    	PreparedStatement pstmt = con.prepareStatement(query);
    	pstmt.setString(1, cliente.getNome());
    	pstmt.setString(2, cliente.getCpf());
    	pstmt.execute();
    	con.commit();
    	}catch (SQLException e){
    		e.printStackTrace();
    	}
    }
    
    public void editar (Cliente cliente){
    	String query = "update cliente set nome = ?, cpf = ? where id = ?";
    	
    	try{
    		PreparedStatement pstmt = con.prepareStatement(query);
        	pstmt.setString(1, cliente.getNome());
        	pstmt.setString(2, cliente.getCpf());
        	pstmt.setInt(3, cliente.getId());
        	pstmt.executeUpdate();
        	con.commit();
    	}catch (SQLException e){
    		e.printStackTrace();
    	}
    	
    }
    
    public void excluir (int id){
    	String query = "delete from cliente where id = ?";
    	try{		
    	PreparedStatement pstmt = con.prepareStatement(query);
    	pstmt.setInt(1, id);
    	pstmt.execute();
    	con.commit();
    	}catch (SQLException e){
    		e.printStackTrace();
    	}
    }
    
    
	public void setListaClientes(ArrayList<Cliente> listaClientes) {
		this.listaClientes = listaClientes;
	}
	
}
