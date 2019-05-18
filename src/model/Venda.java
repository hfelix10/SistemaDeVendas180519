package model;

import java.util.ArrayList;
import java.util.Date;

public class Venda {

	private Date dataVenda;
	private Cliente cliente;
	private ArrayList<ItemVenda> listaItemVenda;
	private Double valorTotal;
	public Venda() {
	}
	public Venda(Date dataVenda, Cliente cliente, Double valorTotal) {
		this.dataVenda = dataVenda;
		this.cliente = cliente;
		this.valorTotal = valorTotal;
	}
	public Date getDataVenda() {
		return dataVenda;
	}
	public void setDataVenda(Date dataVenda) {
		this.dataVenda = dataVenda;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public ArrayList<ItemVenda> getListaItemVenda() {
		return listaItemVenda;
	}
	public void setListaItemVenda(ArrayList<ItemVenda> listaItemVenda) {
		this.listaItemVenda = listaItemVenda;
	}
	public Double getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}
	
}
