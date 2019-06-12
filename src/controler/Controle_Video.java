package controler;


import java.sql.SQLException;


import javax.swing.JOptionPane;

import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import model.Formato_V;
import model.Video;
import persistence.VideoDao;


public class Controle_Video implements IControle_V {

	private ComboBox<Formato_V> cmb_extensao;
	private TextField txtendereco;

	public Controle_Video(ComboBox<Formato_V> cmbextensao) {

		this.cmb_extensao = cmbextensao;
	}

	public Controle_Video(TextField txtendereco) {

		this.txtendereco = txtendereco;
	}

	public Controle_Video(ComboBox<Formato_V> cmb_extensao, TextField txtendereco) {

		this.cmb_extensao = cmb_extensao;
		this.txtendereco = txtendereco;

	}

	


	/*@Override
	public void listaextensao() {
		
		try {
			
			VideoDao videodao = new VideoDao();
			List<Video> listaExtensao = videodao.consultar_v();
			if (cmb_extensao.getVisibleRowCount() > 0){
				
				cmb_extensao.getItems().removeAll();
			}
			
			if (listaExtensao != null){
				
				for (Video video : listaExtensao) {
					
					cmb_extensao.getItems().add(video);
				}
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), " Erro ",
										 JOptionPane.ERROR_MESSAGE);
			
		}}*/
		
	

	@Override
	public void inserirInfo_V() {
		
		try {
			VideoDao videodao = new VideoDao();
			Formato_V formato = new Formato_V();
			Video video = new Video();
			video.setEndereco(txtendereco.getText());
			formato.setExtensao(cmb_extensao.getValue().toString());
			videodao.inserir_v(video, formato);
		} catch (ClassNotFoundException | SQLException e) {
			
			JOptionPane.showMessageDialog(null, e.getMessage(), " Erro ",
					 JOptionPane.ERROR_MESSAGE);
		}
		
	}

	

}
