package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Formato;


public class FormatoDao implements IFormatoDao {
	
private Connection conexao;
	
	public FormatoDao() throws ClassNotFoundException, SQLException {
		
		IConexaoDao conexaod = new ConexaoDao();
		conexao = conexaod.getConnection();
	}

	@Override
	public void inserir_v(Formato video) throws SQLException {
		
		String sql = "INSERT INTO FORMATO (EXTENSAO) VALUES (?)";
		PreparedStatement ps = conexao.prepareStatement(sql);
		//ps.setInt(1, video.getCod_v());
		ps.setString(1, video.getExtensao());
		ps.execute();
		ps.close();
	}

	@Override
	public void alterar_v(Formato video) throws SQLException {
		
		String sql = "UPDATE FORMATO SET EXTENSAO = ? WHERE COD_FORM = ?";
		PreparedStatement ps = conexao.prepareStatement(sql);
		ps.setString(2, video.getExtensao());
		ps.execute();
		ps.close();
		
	}

	@Override
	public void excluir_v(Formato video) throws SQLException {
		
		String sql = "DELETE FORMATO WHERE COD_FORM = ?";
		PreparedStatement ps = conexao.prepareStatement(sql);
		//ps.setInt(1, video.getCod_v());
		ps.execute();
		ps.close();
	}

	@Override
	public Formato consultar_v(Formato video) throws SQLException {
		
		String sql = "SELECT COD_FORM,EXTENSAO FROM FORMATO WHERE COD_FORM = ?";
		PreparedStatement ps = conexao.prepareStatement(sql);
		//ps.setInt(1, video.getCod_v());
		ResultSet rs = ps.executeQuery();
		if(rs.next()){
			
			video.setExtensao(rs.getString("EXETENSAO"));
		}
		
		rs.close();
		ps.close();
		
		return video;
	}

	@Override
	public List<Formato> consultar_v() throws SQLException {
		
		List<Formato> listaExtensao = new ArrayList<Formato>();
		String sql = "SELECT EXTENSAO FROM FORMATO";
		PreparedStatement ps = conexao.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
			
			Formato video = new Formato();
			video.setExtensao(rs.getString("EXTENSAO"));
			listaExtensao.add(video);
		}
		
		rs.close();
		ps.close();
		
		return listaExtensao;
	}

	@Override
	public int proximoCod_V() throws SQLException {
		
		String sql = "SELECT MAX(COD_FORM) + 1 AS PROXIMO_COD_FORM WHERE FORMATO";
		PreparedStatement ps = conexao.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		if(rs.next()){
			
			return rs.getInt("PROXIMO_COD_FORM");
		
		}else{
			return 1;
			}
		
		
	}

}
