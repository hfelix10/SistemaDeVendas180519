package model;

public class ItemVenda {

	private Produto produto;
	private int qtde;
	private Double valorTotalItem;
	
	public ItemVenda() {
	}
	public ItemVenda(Produto produto, int qtde) {
		this.produto = produto;
		this.qtde = qtde;
	}
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	public int getQtde() {
		return qtde;
	}
	public void setQtde(int qtde) {
		this.qtde = qtde;
	}
	public Double getValorTotalItem() {
		return valorTotalItem;
	}
	public void setValorTotalItem(Double valorTotalItem) {
		this.valorTotalItem = valorTotalItem;
	}
	
}
