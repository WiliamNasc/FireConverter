package controler;


import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import model.Erro;
import persistence.ErroDao;




public class Controle_Erro implements IControle_E {

	private ComboBox<String> cmb_erro;
	private TextArea txtdescricao;
	private TableView tblErro;
	
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
	
	public Controle_Erro(TableView tblErro) {
		
		this.tblErro = tblErro;
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
		
		if (tblErro != null){
			
		
			
			
			
			ErroDao erroDao;
			try {
				erroDao = new ErroDao();
				List<Erro> listErro = erroDao.consultar_e();
				return listErro;
			} catch (Exception e) {
				throw new SQLException("Erro na consulta");
			}
		} else {
			throw new SQLException("Erro no Banco de Dados");
		}
		
	}

}
