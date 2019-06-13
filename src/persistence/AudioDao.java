package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Audio;
import model.Formato_A;




public class AudioDao implements IAudioDao {
	
	private Connection conexao;
	
	public AudioDao() throws ClassNotFoundException, SQLException {
		
		IConexaoDao conexaod = new ConexaoDao();
		conexao = conexaod.getConnection();
	}

	@Override
	public void inserir_a(Audio audio, Formato_A formato) throws SQLException {
		
		String sql = "INSERT INTO AUDIO (ENDERECO,EXTENSAO) VALUES (?,?)";
		PreparedStatement ps = conexao.prepareStatement(sql);
		ps.setString(1, audio.getEndereco());
		ps.setString(2, formato.getExtensao());
		ps.execute();
		ps.close();
		
	}

	@Override
	public void alterar_a(Audio audio) throws SQLException {
		
		String sql = "UPDATE AUDIO SET ENDERECO = ?, EXTENSAO = ? WHERE COD_A = ?";
		PreparedStatement ps = conexao.prepareStatement(sql);
		ps.setString(1, audio.getEndereco());
		ps.setString(2, audio.getExtensao());
		ps.setInt(3, audio.getCod_v());
		ps.execute();
		ps.close();
		
	}

	@Override
	public void excluir_a(Audio audio) throws SQLException {
		
		String sql = "DELETE AUDIO WHERE COD_A = ?";
		PreparedStatement ps = conexao.prepareStatement(sql);
		ps.setInt(1, audio.getCod_v());
		ps.execute();
		ps.close();
		
	}

	@Override
	public Audio consultar_a(Audio audio) throws SQLException {
		
		String sql = "SELECT COD_A,ENDERECO,EXTENSAO FROM AUDIO WHERE COD_A = ?";
		PreparedStatement ps = conexao.prepareStatement(sql);
		ps.setInt(1, audio.getCod_v());
		ResultSet rs = ps.executeQuery();
		if(rs.next()){
			
			audio.setCod_v(rs.getInt("COD_A"));
			audio.setEndereco(rs.getString("ENDERECO"));
			audio.setExtensao(rs.getString("EXETENSAO"));
		}
		
		rs.close();
		ps.close();
		
		return audio;
	}

	@Override
	public List<Audio> consultar_a() throws SQLException {
		
		List<Audio> listaExtensao = new ArrayList<Audio>();
		String sql = "SELECT EXTENSAO FROM AUDIO";
		PreparedStatement ps = conexao.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
			
			Audio audio = new Audio();
			audio.setExtensao(rs.getString("EXTENSAO"));
			listaExtensao.add(audio);
		}
		
		rs.close();
		ps.close();
		
		return listaExtensao;
	}

	@Override
	public int proximoCod_A() throws SQLException {
		
		String sql = "SELECT MAX(COD_A) + 1 AS PROXIMO_COD_A WHERE AUDIO";
		PreparedStatement ps = conexao.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		if(rs.next()){
			
			return rs.getInt("PROXIMO_COD_A");
		
		}else{
			return 1;
			}
		
		
	}

		
	}
	
	
	


