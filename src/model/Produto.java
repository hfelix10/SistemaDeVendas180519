package model;

public class Produto {

	private int id;
	private String descricao;
	private Double preco;
	public Produto() {
	}
	public Produto(int id, String descricao, Double preco) {
		this.id = id;
		this.descricao = descricao;
		this.preco = preco;
	}
	public Produto(String descricao, Double preco) {
		this.descricao = descricao;
		this.preco = preco;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Double getPreco() {
		return preco;
	}
	public void setPreco(Double preco) {
		this.preco = preco;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String toString() {
		return this.descricao; 
	}
	
}
