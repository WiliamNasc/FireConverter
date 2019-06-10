package controler;






import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;

import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import model.Video;
import persistence.VideoDao;


public class Controle_Video implements IControle_V {

	private ComboBox<Video> cmb_extensao;
	private TextField txtendereco;

	public Controle_Video(ComboBox<Video> cmbextensao) {

		this.cmb_extensao = cmbextensao;
	}

	public Controle_Video(TextField txtendereco) {

		this.txtendereco = txtendereco;
	}

	public Controle_Video(ComboBox<Video> cmb_extensao, TextField txtendereco) {

		this.cmb_extensao = cmb_extensao;
		this.txtendereco = txtendereco;

	}

	


	@Override
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
			
		}
		
	}

	

}
