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
		
		String sql = "UPDATE USUARIO SET NOME = ?, EMAIL = ?, SENHA = ? WHERE COD_USER = ?";
		PreparedStatement ps = conexao.prepareStatement(sql);
		ps.setString(1, user.getNome());
		ps.setString(2, user.getEmail());
		ps.setString(3, user.getSenha());
		ps.setInt(4, user.getCod_user());
		ps.execute();
		ps.close();
		
	}

	@Override
	public void excluir_u(Usuario user) throws SQLException {
		
		String sql = "DELETE USUARIO WHERE COD_USER = ?";
		PreparedStatement ps = conexao.prepareStatement(sql);
		ps.setInt(1, user.getCod_user());
		ps.execute();
		ps.close();
		
	}

	@Override
	public Usuario consultar_u(Usuario user) throws SQLException {
		
		String sql = "SELECT COD_USER,NOME,EMAIL FROM USUARIO WHERE COD_USER = ?";
		PreparedStatement ps = conexao.prepareStatement(sql);
		ps.setInt(1, user.getCod_user());
		ResultSet rs = ps.executeQuery();
		if(rs.next()){
			
			user.setCod_user(rs.getInt("COD_USER"));
			user.setNome(rs.getString("NOME"));
			user.setEmail(rs.getString("EMAIL"));
		}
		
		rs.close();
		ps.close();
		
		return user;
	}

	@Override
	public List<Usuario> consultar_u() throws SQLException {
		
		List<Usuario> listaUser = new ArrayList<Usuario>();
		String sql = "SELECT NOME FROM USUARIO";
		PreparedStatement ps = conexao.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
			
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
		if(rs.next()){
			
			return rs.getInt("PROXIMO_COD_USER");
		
		}else{
			return 1;
			}
	}

}
