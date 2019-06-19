package controler;


import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;

import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import model.Formato_A;
import persistence.Formato_ADao;



public class Controle_Formato_A implements IControle_F_A {

	private ComboBox<Formato_A> cmb_extensao;
	private TextField txtformato;
	private TextArea txtdescricao;
	
	public Controle_Formato_A(ComboBox<Formato_A> cmbextensao) {

		this.cmb_extensao = cmbextensao;
	}

	public Controle_Formato_A(TextField txtformato, TextArea txtdescricao) {

		this.txtformato = txtformato;
		this.txtdescricao = txtdescricao;
	}

	public Controle_Formato_A(ComboBox<Formato_A> cmb_extensao, TextField txtformato) {

		this.cmb_extensao = cmb_extensao;
		this.txtformato = txtformato;

	}

	


	@Override
	public void listaextensao_A() {
		
		try {
			
			Formato_ADao audioodao = new Formato_ADao();
			List<Formato_A> listaExtensao = audioodao.consultar_v();
			if (cmb_extensao.getVisibleRowCount() > 0){
				
				cmb_extensao.getItems().removeAll();
			}
			
			if (listaExtensao != null){
				
				for (Formato_A audio : listaExtensao) {
					
					cmb_extensao.getItems().add(audio);
				}
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), " Erro ",
										 JOptionPane.ERROR_MESSAGE);
			
		}
		
	}

	@Override
	public void inserirInfo_A() {
		
		try {
			Formato_ADao audiodao = new Formato_ADao();
			Formato_A audio = new Formato_A();
			audio.setExtensao(txtformato.getText());
			audio.setDescricao(txtdescricao.getText());
			audiodao.inserir_v(audio);
		} catch (ClassNotFoundException | SQLException e) {
			
			JOptionPane.showMessageDialog(null, e.getMessage(), " Erro ",
					 JOptionPane.ERROR_MESSAGE);
		}
		
	}



}
