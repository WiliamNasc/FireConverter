package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Usuario;

public class UsuarioDao implements IUserDao {

	private Connection conexao;

	public UsuarioDao() throws ClassNotFoundException, SQLException {

		IConexaoDao conexaod = new ConexaoDao();
		conexao = conexaod.getConnection();
	}

	@Override
	public void inserir_u(Usuario user) throws SQLException {

		String sql = "INSERT INTO USUARIO (NOME,EMAIL,SENHA) VALUES (?,?,?)";
		PreparedStatement ps = conexao.prepareStatement(sql);
		ps.setString(1, user.getNome());
		ps.setString(2, user.getEmail());
		ps.setString(3, user.getSenha());
		ps.execute();
		ps.close();

	}

	@Override
	public void alterar_u(Usuario user) throws SQLException {

		String sql = "UPDATE USUARIO SET NOME = ?,EMAIL = ? WHERE SENHA = ?";
		PreparedStatement ps = conexao.prepareStatement(sql);
		ps.setString(1, user.getNome());
		ps.setString(2, user.getEmail());
		ps.setString(3, user.getSenha());
		ps.execute();
		ps.close();

	}

	@Override
	public void excluir_u(Usuario user) throws SQLException {

		String sql = "DELETE USUARIO WHERE EMAIL = ?";
		PreparedStatement ps = conexao.prepareStatement(sql);
		ps.setString(1, user.getEmail());
		ps.execute();
		ps.close();

	}

	@Override
	public String consultar_u(Usuario user) throws SQLException {

		String usuario, erro;
		erro =  "usuário não existe";
		String sql = "SELECT EMAIL,NOME FROM USUARIO WHERE EMAIL = ? OR NOME = ?";
		PreparedStatement ps = conexao.prepareStatement(sql);
		ps.setString(1, user.getEmail());
		ps.setString(2, user.getNome());
		ResultSet rs = ps.executeQuery();

		if (rs.next()) {
			usuario = rs.getString("NOME");
			rs.close();
			ps.close();
			return usuario;
		} else {

			rs.close();
			ps.close();

			return erro;
		}

	}

	@Override
	public List<Usuario> consultar_u() throws SQLException {

		List<Usuario> listaUser = new ArrayList<Usuario>();
		String sql = "SELECT NOME FROM USUARIO";
		PreparedStatement ps = conexao.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {

			Usuario usuario = new Usuario();
			usuario.setNome(rs.getString("NOME"));
			listaUser.add(usuario);
		}

		rs.close();
		ps.close();

		return listaUser;

	}

	@Override
	public int proximoCod_U() throws SQLException {

		String sql = "SELECT MAX(COD_USER) + 1 AS PROXIMO_COD_USER WHERE USUARIO";
		PreparedStatement ps = conexao.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {

			return rs.getInt("PROXIMO_COD_USER");

		} else {
			return 1;
		}
	}

	@Override
	public String consultar_senha(Usuario user) throws SQLException {

		String senha, erro;
		erro = "senha não existe";
		String sql = "SELECT SENHA FROM USUARIO WHERE SENHA = ?";
		PreparedStatement ps = conexao.prepareStatement(sql);
		ps.setString(1, user.getSenha());
		ResultSet rs = ps.executeQuery();

		if (rs.next()) {
			senha = rs.getString("SENHA");
			rs.close();
			ps.close();
			return senha;
		} else {

			rs.close();
			ps.close();

			return erro;
		}
	}

	@Override
	public String consultar_Email(Usuario user) throws SQLException {
		
		String usuario, erro;
		erro =  "usuário não existe";
		String sql = "SELECT EMAIL FROM USUARIO WHERE EMAIL = ?";
		PreparedStatement ps = conexao.prepareStatement(sql);
		ps.setString(1, user.getEmail());
		ResultSet rs = ps.executeQuery();

		if (rs.next()) {
			usuario = rs.getString("EMAIL");
			rs.close();
			ps.close();
			return usuario;
		} else {

			rs.close();
			ps.close();

			return erro;
		}
	}

	@Override
	public String consultar_Nome(Usuario user) throws SQLException {
		
		String usuario, erro;
		erro =  "usuário não existe";
		String sql = "SELECT NOME FROM USUARIO WHERE NOME = ?";
		PreparedStatement ps = conexao.prepareStatement(sql);
		ps.setString(1, user.getNome());
		ps.setString(2,user.getEmail());
		ResultSet rs = ps.executeQuery();

		if (rs.next()) {
			usuario = rs.getString("NOME");
			rs.close();
			ps.close();
			return usuario;
		} else {

			rs.close();
			ps.close();

			return erro;
		}
	}

}
