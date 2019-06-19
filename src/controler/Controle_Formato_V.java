package controler;

import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;

import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import model.Formato_V;
import persistence.Formato_VDao;


public class Controle_Formato_V implements IControle_F_V {

	private ComboBox<Formato_V> cmb_extensao;
	private TextField txtformato;
	private TextArea txtdescricao;

	public Controle_Formato_V(ComboBox<Formato_V> cmbextensao) {

		this.cmb_extensao = cmbextensao;
	}

	public Controle_Formato_V(TextField txtformato,TextArea txtdescricao) {

		this.txtformato = txtformato;
		this. txtdescricao =  txtdescricao;
	}

	public Controle_Formato_V(ComboBox<Formato_V> cmb_extensao, TextField txtformato) {

		this.cmb_extensao = cmb_extensao;
		this.txtformato = txtformato;

	}

	


	@Override
	public void listaextensao_V() {
		
		try {
			
			Formato_VDao videodao = new Formato_VDao();
			List<Formato_V> listaExtensao = videodao.consultar_v();
			if (cmb_extensao.getVisibleRowCount() > 0){
				
				cmb_extensao.getItems().removeAll();
			}
			
			if (listaExtensao != null){
				
				for (Formato_V video : listaExtensao) {
					
					cmb_extensao.getItems().add(video);
				}
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), " Erro ",
										 JOptionPane.ERROR_MESSAGE);
			
		}
		
	}

	@Override
	public void inserirInfo_V() {
		
		try {
			Formato_VDao videodao = new Formato_VDao();
			Formato_V video = new Formato_V();
			video.setExtensao(txtformato.getText());
			video.setDescricao(txtdescricao.getText());
			videodao.inserir_v(video);
		} catch (ClassNotFoundException | SQLException e) {
			
			JOptionPane.showMessageDialog(null, e.getMessage(), " Erro ",
					 JOptionPane.ERROR_MESSAGE);
		}
		
	}



}
