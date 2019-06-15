package persistence;

import java.sql.SQLException;
import java.util.List;
import model.Usuario;


public interface IUserDao {
	
	public void inserir_u (Usuario user) throws SQLException;
	public void alterar_u (Usuario user) throws SQLException;
	public void excluir_u (Usuario user) throws SQLException;
	public String consultar_u1 (Usuario user) throws SQLException;
	public List<Usuario> consultar_u () throws SQLException;
	public int proximoCod_U () throws SQLException;

}
