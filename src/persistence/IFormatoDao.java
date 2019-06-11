package persistence;

import java.sql.SQLException;
import java.util.List;

import model.Formato;


public interface IFormatoDao {
	
	public void inserir_v (Formato extensao) throws SQLException;
	public void alterar_v (Formato extensao) throws SQLException;
	public void excluir_v (Formato extensao) throws SQLException;
	public Formato consultar_v (Formato extensao) throws SQLException;
	public List<Formato> consultar_v () throws SQLException;
	public int proximoCod_V () throws SQLException;

}
