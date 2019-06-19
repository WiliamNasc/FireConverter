package model;

public class Audio {
	
	private String endereco;
	private String extensao;
	private int cod_audio;
	
	
	public int getCod_a() {
		return cod_audio;
	}
	public void setCod_a(int cod_audio) {
		this.cod_audio = cod_audio;
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
