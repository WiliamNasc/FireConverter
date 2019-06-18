package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Erro;


public class ErroDao implements IErroDao {
	
	private Connection conexao;
	
	public ErroDao() throws ClassNotFoundException, SQLException {
		
		IConexaoDao conexaod = new ConexaoDao();
		conexao = conexaod.getConnection();
	}

	@Override
	public void inserir_e(Erro erro) throws SQLException {
		
		String sql = "INSERT INTO ERRO1 (CATEGORIA,DESCRICAO) VALUES (?,?)";
		PreparedStatement ps = conexao.prepareStatement(sql);
		ps.setString(1, erro.getCategoria());
		ps.setString(2, erro.getDescricao());
		ps.execute();
		ps.close();
		
	}

	@Override
	public void alterar_e(Erro erro) throws SQLException {
		
		String sql = "UPDATE ERRO SET CATEGORIA=?,DESCRICAO = ? WHERE COD_ERRO = ?";
		PreparedStatement ps = conexao.prepareStatement(sql);
		ps.setString(1, erro.getDescricao());
		ps.setString(2, erro.getCategoria());
		ps.setInt(3, erro.getCod_erro());
		ps.execute();
		ps.close();
		
		
	}

	@Override
	public void excluir_e(Erro erro) throws SQLException {
		
		String sql = "DELETE ERRO WHERE COD_ERRO = ?";
		PreparedStatement ps = conexao.prepareStatement(sql);
		ps.setInt(1, erro.getCod_erro());
		ps.execute();
		ps.close();
		
	}

	@Override
	public Erro consultar_e(Erro erro) throws SQLException {
		
		String sql = "SELECT COD_ERRO,CATEGORIA,DESCRICAO FROM ERRO WHERE COD_ERRO = ?";
		PreparedStatement ps = conexao.prepareStatement(sql);
		ps.setInt(1, erro.getCod_erro());
		ResultSet rs = ps.executeQuery();
		if(rs.next()){
			
			erro.setCod_erro(rs.getInt("COD_ERRO"));
			erro.setDescricao(rs.getString("DESCRICAO"));
			
		}
		
		rs.close();
		ps.close();
		
		return erro;
	}

	@Override
	public List<Erro> consultar_e() throws SQLException {
		
		List<Erro> listaErro = new ArrayList<Erro>();
		String sql = "SELECT COD_ERRO,CATEGORIA,DESCRICAO FROM ERRO1";
		PreparedStatement ps = conexao.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
			
			Erro erro = new Erro();
			erro.setCod_erro(rs.getInt("COD_ERRO"));
			erro.setCategoria(rs.getString("CATEGORIA"));
			erro.setDescricao(rs.getString("DESCRICAO"));
			listaErro.add(erro);
		}
		
		rs.close();
		ps.close();
		
		return listaErro;
	}

	@Override
	public int proximoCod_E() throws SQLException {
		
		String sql = "SELECT MAX(COD_ERRO) + 1 AS PROXIMO_COD_ERRO WHERE ERRO";
		PreparedStatement ps = conexao.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		if(rs.next()){
			
			return rs.getInt("PROXIMO_COD_ERRO");
		
		}else{
			return 1;
			}
	}

}
