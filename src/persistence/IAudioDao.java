package persistence;

import java.sql.SQLException;
import java.util.List;

import model.Audio;
import model.Formato_A;



public interface IAudioDao {
	
	public void inserir_a (Audio extensao, Formato_A formato) throws SQLException;
	public void alterar_a (Audio extensao) throws SQLException;
	public void excluir_a (Audio extensao) throws SQLException;
	public Audio consultar_a (Audio extensao) throws SQLException;
	public List<Audio> consultar_a () throws SQLException;
	public int proximoCod_A () throws SQLException;

}
