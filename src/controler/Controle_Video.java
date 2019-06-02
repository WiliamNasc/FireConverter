package controler;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import model.Video;

public class Controle_Video {

	private ComboBox<String> extensao;
	private TextField txtarquivo;
	private List<String> lVideo = new ArrayList<String>();

	public Controle_Video(ComboBox<String> extensao) {

		this.extensao = extensao;
	}

	public Controle_Video(TextField txtarquivo) {

		this.txtarquivo = txtarquivo;
	}

	public Controle_Video(ComboBox<String> extensao, TextField txtarquivo) {

		this.extensao = extensao;
		this.txtarquivo = txtarquivo;

	}

	public void listaVideo() {

		Video v = new Video();
		extensao.getItems().addAll("AVI", "Mkv", "Mp4");
		lVideo.add(txtarquivo.getText());
		v.setlVideo(lVideo);
		System.out.println(v.getlVideo());

	}

	

}
