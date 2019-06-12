package persistence;

import java.sql.SQLException;
import java.util.List;

import model.Formato_V;


public interface IFormato_VDao {
	
	public void inserir_v (Formato_V formato) throws SQLException;
	public void alterar_v (Formato_V formato) throws SQLException;
	public void excluir_v (Formato_V formato) throws SQLException;
	public Formato_V consultar_v (Formato_V formato) throws SQLException;
	public List<Formato_V> consultar_v () throws SQLException;
	public int proximoCod_V () throws SQLException;
	

}
