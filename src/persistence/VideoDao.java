package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Formato_V;
import model.Video;


public class VideoDao implements IVideoDao {
	
	private Connection conexao;
	
	public VideoDao() throws ClassNotFoundException, SQLException {
		
		IConexaoDao conexaod = new ConexaoDao();
		conexao = conexaod.getConnection();
	}

	@Override
	public void inserir_v(Video video, Formato_V formato) throws SQLException {
		
		String sql = "INSERT INTO VIDEO (ENDERECO,EXTENSAO) VALUES (?,?)";
		PreparedStatement ps = conexao.prepareStatement(sql);
		ps.setString(1, video.getEndereco());
		ps.setString(2, formato.getExtensao());
		ps.execute();
		ps.close();
	}

	@Override
	public void alterar_v(Video video) throws SQLException {
		
		String sql = "UPDATE VIDEO SET ENDERECO = ?, EXTENSAO = ? WHERE COD_V = ?";
		PreparedStatement ps = conexao.prepareStatement(sql);
		ps.setString(1, video.getEndereco());
		ps.setString(2, video.getExtensao());
		ps.setInt(3, video.getCod_v());
		ps.execute();
		ps.close();
		
	}

	@Override
	public void excluir_v(Video video) throws SQLException {
		
		String sql = "DELETE VIDEO WHERE COD_V = ?";
		PreparedStatement ps = conexao.prepareStatement(sql);
		ps.setInt(1, video.getCod_v());
		ps.execute();
		ps.close();
	}

	@Override
	public Video consultar_v(Video video) throws SQLException {
		
		String sql = "SELECT COD_V,ENDERECO,EXTENSAO FROM VIDEO WHERE COD_V = ?";
		PreparedStatement ps = conexao.prepareStatement(sql);
		ps.setInt(1, video.getCod_v());
		ResultSet rs = ps.executeQuery();
		if(rs.next()){
			
			video.setCod_v(rs.getInt("COD_V"));
			video.setEndereco(rs.getString("ENDERECO"));
			video.setExtensao(rs.getString("EXETENSAO"));
		}
		
		rs.close();
		ps.close();
		
		return video;
	}

	@Override
	public List<Video> consultar_v() throws SQLException {
		
		List<Video> listaExtensao = new ArrayList<Video>();
		String sql = "SELECT EXTENSAO FROM VIDEO";
		PreparedStatement ps = conexao.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
			
			Video video = new Video();
			video.setExtensao(rs.getString("EXTENSAO"));
			listaExtensao.add(video);
		}
		
		rs.close();
		ps.close();
		
		return listaExtensao;
	}

	@Override
	public int proximoCod_V() throws SQLException {
		
		String sql = "SELECT MAX(COD_V) + 1 AS PROXIMO_COD_V WHERE VIDEO";
		PreparedStatement ps = conexao.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		if(rs.next()){
			
			return rs.getInt("PROXIMO_COD_V");
		
		}else{
			return 1;
			}
		
		
	}

	
	
	

}
