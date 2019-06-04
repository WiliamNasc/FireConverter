package persistence;

import java.util.ArrayList;
import java.util.List;

public class VideoDao {
	
	List<String> video = new ArrayList<String>();
	
	public void add_formato (String a, String b){
		
		/*video.add("Formato: " + a);
		video.add("Endereço: " + b);*/
		
	}
	
	public void ver (){
	   
		System.out.println(video.get(0));
		System.out.println(video.get(1));
		
		for(String v: video){
			System.out.println(v.toString());
		}
	}

}
