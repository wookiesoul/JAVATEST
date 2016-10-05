
import java.net.MalformedURLException;
import java.net.URL;




public class UrlTest {
	public static void main(String args[]){
		
		String urlAddress = "http://192.168.3.115:8080/sso/checkserver.jsp";
		
		int i = urlAddress.indexOf("sso");
		
		String domain = urlAddress.substring(0, i);
		System.out.println(i);
		  System.out.println(""	  + domain );
		  
			String db_User_Paswword ="$2a342rfd";
			System.out.println(db_User_Paswword.substring(0, 3));
		/* =========================================DEBUG LOG========================================= */
				if(db_User_Paswword.substring(0, 3).equals("$2a"))System.out.println("aaa");;
			
		
	}

}
