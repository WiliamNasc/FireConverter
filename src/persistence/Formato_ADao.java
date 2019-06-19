package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Formato_A;




public class Formato_ADao implements IFormato_ADao {
	
private Connection conexao;
	
	public Formato_ADao() throws ClassNotFoundException, SQLException {
		
		IConexaoDao conexaod = new ConexaoDao();
		conexao = conexaod.getConnection();
	}

	@Override
	public void inserir_v(Formato_A formato) throws SQLException {
		
		String sql = "INSERT INTO FORMATO_AUDIO (EXTENSAO,DESCRICAO) VALUES (?,?)";
		PreparedStatement ps = conexao.prepareStatement(sql);
		ps.setString(1, formato.getExtensao());
		ps.setString(2, formato.getDescricao());
		ps.execute();
		ps.close();
		
	}

	@Override
	public void alterar_v(Formato_A formato) throws SQLException {
		
		String sql = "UPDATE FORMATO_AUDIO SET EXTENSAO = ? WHERE COD_FORM = ?";
		PreparedStatement ps = conexao.prepareStatement(sql);
		ps.setString(2, formato.getExtensao());
		ps.execute();
		ps.close();
		
	}

	@Override
	public void excluir_v(Formato_A formato) throws SQLException {
		
		String sql = "DELETE FORMATO_AUDIO WHERE COD_FORM = ?";
		PreparedStatement ps = conexao.prepareStatement(sql);
		ps.execute();
		ps.close();
		
	}

	@Override
	public Formato_A consultar_v(Formato_A formato) throws SQLException {
		
		String sql = "SELECT COD_FORM,EXTENSAO FROM FORMATO_AUDIO WHERE COD_FORM = ?";
		PreparedStatement ps = conexao.prepareStatement(sql);
		ps.setInt(1, formato.getCod_v());
		ResultSet rs = ps.executeQuery();
		if(rs.next()){
			
			formato.setExtensao(rs.getString("EXETENSAO"));
		}
		
		rs.close();
		ps.close();
		
		return formato;
	}

	@Override
	public List<Formato_A> consultar_v() throws SQLException {
		
		List<Formato_A> listaExtensao = new ArrayList<Formato_A>();
		String sql = "SELECT EXTENSAO FROM FORMATO_AUDIO";
		PreparedStatement ps = conexao.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()){
			
			Formato_A formato = new Formato_A();
			formato.setExtensao(rs.getString("EXTENSAO"));
			listaExtensao.add(formato);
		}
		
		rs.close();
		ps.close();
		
		return listaExtensao;
	}

	@Override
	public int proximoCod_V() throws SQLException {
		
		String sql = "SELECT MAX(COD_FORM) + 1 AS PROXIMO_COD_FORM WHERE FORMATO_AUDIO";
		PreparedStatement ps = conexao.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		if(rs.next()){
			
			return rs.getInt("PROXIMO_COD_FORM");
		
		}else{
			return 1;
			}
	}

	


}
