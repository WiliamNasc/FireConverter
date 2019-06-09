package model;

import java.util.ArrayList;
import java.util.List;

public class Video {
	
	private String endereco;
	private String extensao = "Mp4 /n Mkv";
	private int cod_v;
	
	
	public int getCod_v() {
		return cod_v;
	}
	public void setCod_v(int cod_v) {
		this.cod_v = cod_v;
	}

	List<String> lVideo = new ArrayList<String>();
	
	
	
	public List<String> getlVideo() {
		return lVideo;
	}
	public void setlVideo(List<String> lVideo) {
		this.lVideo = lVideo;
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
