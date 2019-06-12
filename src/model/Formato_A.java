package model;

public class Formato_A {
	
	private String extensao;
	private int cod_v;
	
	
	public int getCod_v() {
		return cod_v;
	}
	public void setCod_v(int cod_v) {
		this.cod_v = cod_v;
	}

	public String getExtensao() {
		return extensao;
	}
	public void setExtensao(String extensao) {
		this.extensao = extensao;
	}
	
	@Override
	public String toString() {
		return this.extensao;
	}

}
