package persistence;

import java.sql.SQLException;
import java.util.List;
import model.Erro;


public interface IErroDao {
	
	public void inserir_e (Erro erro) throws SQLException;
	public void alterar_e (Erro erro) throws SQLException;
	public void excluir_e (Erro erro) throws SQLException;
	public Erro consultar_e (Erro erro) throws SQLException;
	public List<Erro> consultar_e () throws SQLException;
	public int proximoCod_E () throws SQLException;

}
