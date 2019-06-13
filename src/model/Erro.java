package model;

public class Erro {
	
	private int cod_erro;
	private String descricao;
	private String categoria;
	
	
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	
	public int getCod_erro() {
		return cod_erro;
	}
	public void setCod_erro(int cod_erro) {
		this.cod_erro = cod_erro;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
	@Override
	public String toString() {
		return this.descricao;
	}
	

}
