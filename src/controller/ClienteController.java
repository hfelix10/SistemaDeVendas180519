package controller;

import java.util.List;

import dao.ClienteDAO;
import exceptions.ClienteException;
import model.Cliente;

public class ClienteController {
	
	public void inserir (Cliente cliente) throws ClienteException{
		if (cliente.getNome().equals("")){
			throw new ClienteException ("Nome inválido");
		}
		if (cliente.getCpf().equals("") || cliente.getCpf().equals("___.___.___-__")){
			throw new ClienteException("CPF invalido");
		}
		new ClienteDAO().inserir(cliente);
	}
	
	public List<Cliente>getListaClientes(){
		return new ClienteDAO().getListaClientes();
	}
	
	public List<Cliente>getListaClientesByNome(String nome)throws ClienteException{
		if(nome.equals("")|| nome.length() < 3){
			throw new ClienteException("Informe um nome para pesquisa");
		}
		return new ClienteDAO().getListaClientesByNome(nome);
	}
	
	public  void editar (Cliente cliente) throws ClienteException{
		if (cliente.getId() == 0){
			throw new ClienteException("Cliente invalido");
		}
		if (cliente.getNome().equals("")){
			throw new ClienteException ("Nome inválido");
		}
		if (cliente.getCpf().equals("")){
			throw new ClienteException("CPF invalido");
		}
		new ClienteDAO().editar(cliente);
	}
	
	public void excluir (int id)throws ClienteException{
		if (id==0){
			throw new ClienteException("Selecione um cliente");
		}
		new ClienteDAO().excluir(id);
	}
}
