package controler;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import model.Usuario;
import persistence.UsuarioDao;


public class Controle_Usuario implements IControle_U {

	private ComboBox<Usuario> cmb_usuario;
	private TextField txtnome, txtemail, txtsenha;
	
	public Controle_Usuario(ComboBox<Usuario> cmbextensao) {

		this.cmb_usuario = cmbextensao;
	}

	public Controle_Usuario(TextField txtnome, TextField txtemail, TextField txtsenha) {

		this.txtnome = txtnome;
		this.txtemail = txtemail;
		this.txtsenha = txtsenha;
	}
	
	

	public Controle_Usuario(ComboBox<Usuario> cmb_usuario, TextField txtnome
			,TextField txtemail, TextField txtsenha ) {

		this.cmb_usuario = cmb_usuario;
		this.txtnome = txtnome;
		this.txtemail = txtemail;
		this.txtsenha = txtsenha;

	}
	
	
	@Override
	public void inserirInfo_U() {
		
		try {
			UsuarioDao usuariodao = new UsuarioDao();
			Usuario usuario = new Usuario();
			usuario.setNome(txtnome.getText());
			usuario.setEmail(txtemail.getText());
			usuario.setSenha(txtsenha.getText());
			usuariodao.inserir_u(usuario);
		} catch (ClassNotFoundException | SQLException e) {
			
			JOptionPane.showMessageDialog(null, e.getMessage(), " Erro ",
					 JOptionPane.ERROR_MESSAGE);
		}
		
	}

}
