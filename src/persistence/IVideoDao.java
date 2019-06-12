package persistence;

import java.sql.SQLException;
import java.util.List;

import model.Formato_V;
import model.Video;


public interface IVideoDao {
	
	public void inserir_v (Video extensao, Formato_V formato) throws SQLException;
	public void alterar_v (Video extensao) throws SQLException;
	public void excluir_v (Video extensao) throws SQLException;
	public Video consultar_v (Video extensao) throws SQLException;
	public List<Video> consultar_v () throws SQLException;
	public int proximoCod_V () throws SQLException;
}
