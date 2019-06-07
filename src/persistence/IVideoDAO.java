package persistence;

import java.sql.Connection;
import java.sql.SQLException;

public interface IVideoDAO {
	
	public Connection getConnection() throws ClassNotFoundException, SQLException;

}
