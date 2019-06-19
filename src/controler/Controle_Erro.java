package controler;


import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;


import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import model.Erro;
import persistence.ErroDao;




public class Controle_Erro implements IControle_E {

	private ComboBox<String> cmb_erro;
	private TextArea txtdescricao;
	
	
	public Controle_Erro(ComboBox<String> cmb_erro) {

		this.cmb_erro = cmb_erro;
	}

	public Controle_Erro(TextArea txtdescricao) {

		this.txtdescricao = txtdescricao;
	}

	public Controle_Erro(ComboBox<String> cmb_erro, TextArea txtdescricao) {

		this.cmb_erro = cmb_erro;
		this.txtdescricao = txtdescricao;

	}
	
	
	
	

	@Override
	public void inserirInfo_U() {
		
		try {
			ErroDao errodao = new ErroDao();
			Erro erro = new Erro();
			erro.setCategoria(cmb_erro.getValue());
			erro.setDescricao(txtdescricao.getText());
			errodao.inserir_e(erro);
		} catch (ClassNotFoundException | SQLException e) {
			
			JOptionPane.showMessageDialog(null, e.getMessage(), " Erro ",
					 JOptionPane.ERROR_MESSAGE);
		}
		
		
	}

	@Override
	public List<Erro> tabelaErro() throws SQLException {
		return null;
		
		
	}

}
