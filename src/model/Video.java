package model;

public class Video {
	
	private String endereco;
	private String extensao;
	private int cod_video;
	
	
	public int getCod_v() {
		return cod_video;
	}
	public void setCod_v(int cod_video) {
		this.cod_video = cod_video;
	}

	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
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
