package persistence;

import java.sql.SQLException;
import java.util.List;

import model.Formato_A;


public interface IFormato_ADao {
	
	public void inserir_v (Formato_A formato) throws SQLException;
	public void alterar_v (Formato_A formato) throws SQLException;
	public void excluir_v (Formato_A formato) throws SQLException;
	public Formato_A consultar_v (Formato_A formato) throws SQLException;
	public List<Formato_A> consultar_v () throws SQLException;
	public int proximoCod_V () throws SQLException;

}
