package persistence;

import java.sql.SQLException;
import java.util.List;

import model.Audio;
import model.Formato_A;



public interface IAudioDao {
	
	public void inserir_a (Audio audio, Formato_A formato_a) throws SQLException;
	public void alterar_a (Audio audio) throws SQLException;
	public void excluir_a (Audio audio) throws SQLException;
	public Audio consultar_a (Audio audio) throws SQLException;
	public List<Audio> consultar_a () throws SQLException;
	public int proximoCod_A () throws SQLException;

}
