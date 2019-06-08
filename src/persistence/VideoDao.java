package persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import net.sourceforge.jtds.jdbc.*;

public class VideoDao implements IVideoDAO {
	
	List<String> video = new ArrayList<String>();
	
	private Connection c;
	
	public void add_formato (String a, String b){
		
		video.add("Formato: " + a);
		video.add("Endere�o: " + b);
		
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
		Class.forName("net.sourceforge.jtds.jdbc.Driver");
		c = DriverManager.getConnection("jdbc:jtds:sqlserver://localhost:1433/DB_FIRECONVERT",
		"wil", "123");
		System.out.println("Ok");
		return c;
	}
	
	public static void main(String[] args) {
		VideoDao vd = new VideoDao();
		try {
			vd.getConnection();
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}

}
