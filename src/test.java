import com.hs.hip.common.*;

public class test {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		HDIdeaCipher cipher = new HDIdeaCipher();
		String result = cipher.transform(0, "11111");
		 
		 System.out.println(result);
		 String dresult = cipher.transform(1,result);
		 
		 System.out.println(dresult);
		
		
		 
		 int i = 2147000000;
		 String db_User_Paswword = "dwrfe\"tt";
		 db_User_Paswword.replaceAll("\"", "\\\"");
		 
		 System.out.println(db_User_Paswword);
 
		 String a= "ssl:N";
		 if(a.indexOf("Y")>-1)System.out.println("ok");
			 
		 

	}

}
