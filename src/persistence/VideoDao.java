package persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class VideoDao implements IVideoDAO {
	
	// video - https://www.youtube.com/watch?v=YhJwPckaoiM
	// site - https://www.sqlfromhell.com/alterando-as-portas-de-conexao-do-sql-server/
	// video crud - https://www.youtube.com/watch?v=vH1Z5tv8fCk
	
	List<String> video = new ArrayList<String>();
	
	private Connection c;
	
	public void add_formato (String formato, String endereco){
		
		video.add("Formato: " + formato);
		video.add("Endereço: " + endereco);
		
	}
	
	public void ver (){
	   
		System.out.println(video.get(0));
		System.out.println(video.get(1));
		
		for(String v: video){
			System.out.println(v.toString());
		}
	}

	@Override
	public Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		c = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=DB_FIRECONVERTER",
		"sa", "123");
		System.out.println("Conectou, Porra!!!");
		return c;
	}
	
	public static void main(String[] args) {
		VideoDao vd = new VideoDao();
		try {
			vd.getConnection();
			
		} catch (ClassNotFoundException | SQLException e) {
	
			System.out.println(e.getMessage());
		}
	}

}
