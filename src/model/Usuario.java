package model;

public class Usuario {
	
	private int cod_user;
	private String nome;
	private String email;
	private String senha;
	
	
	
	public int getCod_user() {
		return cod_user;
	}
	
	public void setCod_user(int cod_user) {
		this.cod_user = cod_user;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getSenha() {
		return senha;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	@Override
	public String toString() {
		return this.nome;
	}


}
