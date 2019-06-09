package persistence;

import java.sql.Connection;
import java.sql.SQLException;

public interface IConexaoDao {
	
	public Connection getConnection() throws ClassNotFoundException, SQLException;

}
